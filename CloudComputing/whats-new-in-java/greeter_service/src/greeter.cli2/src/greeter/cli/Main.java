package greeter.cli;

import java.util.ServiceLoader;

import greeter.api.MessageService;

public class Main {
  public static void main(String... args) {

    Iterable<MessageService> messageServices =
      ServiceLoader.load(MessageService.class);

    for (MessageService messageService: messageServices) {
      String message = messageService.getMessage();
      System.out.println(message + " from a module!");
    }
  }
}
