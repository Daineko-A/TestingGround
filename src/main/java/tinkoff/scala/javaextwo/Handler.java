package tinkoff.scala.javaextwo;

import java.time.Duration;

public interface Handler {
    Duration timeout();

    void performOperation();
}

