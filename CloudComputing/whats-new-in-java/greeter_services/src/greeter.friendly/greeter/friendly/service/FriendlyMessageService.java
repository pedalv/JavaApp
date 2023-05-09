package greeter.friendly.service;

import greeter.api.MessageService;

public class FriendlyMessageService implements MessageService {
  public String getMessage() {
    return "Friendly greetings";
  }
}
