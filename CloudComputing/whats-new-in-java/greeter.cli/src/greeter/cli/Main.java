package greeter.cli;


import greeter.hello.service.HelloMessageService;

/**
 * ..\..\..\..\..\Java\jdk-17.0.6+10\bin\javac -d out --module-source-path src -m greeter.cli,greeter.hello
 *
 * ..\..\..\..\..\Java\jdk-17.0.6+10\bin\javac -d out --module-source-path src -m greeter.cli
 * ..\..\..\..\..\Java\jdk-17.0.6+10\bin\javac -d out .\src\greeter\cli\Main.java .\src\module-info.java
 *
 *
 * ..\..\..\..\..\Java\jdk-17.0.6+10\bin\javac -d out --module-source-path src -m greeter.hello
 * ..\..\..\..\..\Java\jdk-17.0.6+10\bin\javac -d out \
 *  .\src\greeter\hello\service\HelloMessageService.java \
 *  .\src\greeter\helloutil\CapitalizeUtil.java .\src\module-info.java
 */
public class Main {
    public static void main(String[] args) {
        HelloMessageService messageService =
                new HelloMessageService();
        String message = messageService.getMessage();
        System.out.println(message + " from a module!");
    }
}