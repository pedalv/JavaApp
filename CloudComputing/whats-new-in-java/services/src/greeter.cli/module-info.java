import greeter.api.MessageService;

module greeter.cli {
  requires greeter.api;

  //uses greeter.api.MessageService;
  uses MessageService;
}
