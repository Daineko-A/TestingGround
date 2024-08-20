package tinkoff.scala.javaexone;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HandlerImpl implements Handler {
//    @Autowired with Spring.
    Client client = new ClientImpl();

    @Override
    public ApplicationStatusResponse performOperation(String id) {
        LocalDateTime start = LocalDateTime.now();

        int retries = 0;
        Response applicationStatus;
        Duration delay = Duration.ofSeconds(0);

        do {
            try {
                wait(delay.toMillis());
            } catch (InterruptedException e) {
                return getFailure(start, retries);
            }

            try {
                applicationStatus = extracted(id);
            } catch (ExecutionException | InterruptedException e) {
                return getFailure(start, retries);
            }

            if (applicationStatus instanceof Response.RetryAfter) {
                delay = ((Response.RetryAfter) applicationStatus).delay();
            }

            retries++;
            if (Duration.ofSeconds(start.getSecond() - LocalDateTime.now().getSecond()).toSeconds() >= 15) {
                return getFailure(start, retries);
            }
        } while (applicationStatus instanceof Response.Failure
                || applicationStatus instanceof Response.RetryAfter);


        return new ApplicationStatusResponse.Success(id, applicationStatus.toString());
    }

    private ApplicationStatusResponse.Failure getFailure(LocalDateTime start, int retries) {
        return new ApplicationStatusResponse.Failure(
                Duration.ofSeconds(start.getSecond() - LocalDateTime.now().getSecond()),
                retries);
    }

    private Response extracted(String id) throws ExecutionException, InterruptedException {
        CompletableFuture<Response> app1 = CompletableFuture.supplyAsync(() -> client.getApplicationStatus1(id));
        CompletableFuture<Response> app2 = CompletableFuture.supplyAsync(() -> client.getApplicationStatus2(id));

        return (Response) CompletableFuture.anyOf(app1, app2)
                .thenApply(res -> res instanceof Response.Failure ? ((Response.Failure) res) : res)
                .thenApply(res -> res instanceof Response.Success ? ((Response.Success) res) : res)
                .thenApply(res -> res instanceof Response.RetryAfter ? ((Response.RetryAfter) res) : res)
                .get();
    }
}
