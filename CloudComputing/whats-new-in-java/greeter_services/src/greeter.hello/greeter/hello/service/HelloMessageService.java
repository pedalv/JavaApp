package greeter.hello.service;

import greeter.api.MessageService;
import greeter.hello.util.CapitalizeUtil;

public class HelloMessageService implements MessageService {
  public String getMessage() {
    return CapitalizeUtil.capitalize("hello");
  }
}
