package tinkoff.scala.javaextwo;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.time.Duration;
import java.util.ArrayDeque;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandlerImpl implements Handler {
    //    @Autowired with Spring.
    Client client = new ClientImpl();
    ExecutorService executorService = Executors.newCachedThreadPool();
    ArrayDeque<Pair<Address, Payload>> pairs = new ArrayDeque<Pair<Address, Payload>>();


    @Override
    public Duration timeout() {
        return null;
    }

    @Override
    public void performOperation() {
        while (true) {
            CompletableFuture.supplyAsync(() -> client.readData(), executorService)
                    .thenAccept(this::addToDeque)
                    .thenRun(this::sendAsync);
        }
    }

    private void addToDeque(Event event) {
        Payload payload = event.payload();
        event.recipients().forEach(l -> {
            pairs.addLast(new ImmutablePair<>(l, payload));
        });
    }

    private void waitAndReturnToDeque(Pair<Address, Payload> finalNextPair){
        CompletableFuture.supplyAsync(() -> {
            try {
                wait(timeout().toMillis());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            pairs.addLast(finalNextPair);
            return null;
        }, executorService).isDone();
    }

    private void sendAsync() {
        boolean run = false;
        Pair<Address, Payload> nextPair = pairs.pollFirst();
        do {
            if(nextPair != null) {
                Pair<Address, Payload> finalNextPair = nextPair;
                CompletableFuture.supplyAsync(() -> client.sendData(finalNextPair.getKey(), finalNextPair.getRight()), executorService).thenAccept(res -> {
                    if (res.equals(Result.REJECTED)) {
                        waitAndReturnToDeque(finalNextPair);
                    }
                });
                nextPair = pairs.pollFirst();
                run = true;
            } else {
                run = false;
            }

        } while (run);
    }
}
