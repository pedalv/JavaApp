package greeter.cli;


import greeter.hello.service.HelloMessageService;

/**
 * PS C:\workspace2\JavaApp\CloudComputing\whats-new-in-java>
 * ..\..\..\..\..\Java\jdk-17.0.6+10\bin\javac -d out --module-source-path src -m greeter.cli,greeter.hello
 * error: module greeter.cli not found in module source path
 * error: module greeter.hello not found in module source path
 *
 *
 * PS C:\workspace2\JavaApp\CloudComputing\whats-new-in-java\greeter.cli>
 * ..\..\..\..\..\Java\jdk-17.0.6+10\bin\javac -d out --module-source-path src -m greeter.cli
 * error: module greeter.cli not found in module source path
 * ..\..\..\..\..\Java\jdk-17.0.6+10\bin\javac -d out .\src\greeter\cli\Main.java .\src\module-info.java
 * .\src\module-info.java:2: error: module not found: greeter.hello
 *     requires greeter.hello;
 *                     ^
 * 1 error
 *
 *
 * PS C:\workspace2\JavaApp\CloudComputing\whats-new-in-java\greeter.hello>
 * ..\..\..\..\..\Java\jdk-17.0.6+10\bin\javac -d out --module-source-path src -m greeter.hello
 * error: module greeter.hello not found in module source path
 * ..\..\..\..\..\Java\jdk-17.0.6+10\bin\javac -d out \
 *  .\src\greeter\hello\service\HelloMessageService.java \
 *  .\src\greeter\helloutil\CapitalizeUtil.java .\src\module-info.java
 *
 */
public class Main {
    public static void main(String[] args) {
        HelloMessageService messageService =
                new HelloMessageService();
        String message = messageService.getMessage();
        System.out.println(message + " from a module!");
    }
}