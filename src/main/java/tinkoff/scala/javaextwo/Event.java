package tinkoff.scala.javaextwo;

import java.util.List;

public record Event(List<Address> recipients, Payload payload) {
}
