package no.dfo.javamodularity.greeter;

/**
 * PS C:\workspace2\JavaApp\CloudComputing\whats-new-in-java>
 *
 * Java 11
 * ..\..\..\..\Java\jdk-11.0.14+9\bin\
 *
 * Java 17
 * ..\..\..\..\Java\jdk-17.0.6+10\bin\
 *
 * # Run from `creating_module1` directory
 * rm -rf out # Optional to clear previous compilation results
 *
 * # -d sets output directory
 * SINGLE MODULE:
 * javac -d {dir} {all source files, including module-info.java}
 * javac -d out \
 * .\greeter\src\no\dfo\javamodularity\greeter\Main.java \
 * .\greeter\src\module-info.java
 *
 * MULTIPLE MODULES:
 * javac -d {dir} \
 *  --module-source-pat {src_dir} \
 *  -m {module_name},{module_name}
 * javac -d out \
 *  --module-source-path src \
 *  --module greeter
 *
 *
 * ..\..\..\..\Java\jdk-17.0.6+10\bin\javac -d out .\greeter\src\no\dfo\javamodularity\greeter\Main.java .\greeter\src\module-info.java
 *
 * ..\..\..\..\..\Java\jdk-17.0.6+10\bin\javac -d out .\src\no\dfo\javamodularity\greeter\Main.java .\src\module-info.java
 *
 * javac -d out src/com/javamodularity/greeter/Main.java src/module-info.java
 *
 * # -p sets the module path, -m the initial module to run
 * Running A MODULE:
 * java -p {module_path} \
 *      -m {module}/{fully qualified main class}
 *
 * java --module-path {module_path} \
 *      --module {module}/{fully qualified main class}
 *
 * java  --module-path out \
 *       --module greeter/com.javamodularity.greeter.Main
 *
 *
 * ..\..\..\..\Java\jdk-17.0.6+10\bin\java -p out -m greeter/no.dfo.javamodularity.greeter.Main
 * Greetings from a module!
 *
 * ..\..\..\..\..\Java\jdk-17.0.6+10\bin\java -p out -m greeter/no.dfo.javamodularity.greeter.Main
 * Greetings from a module!
 *
 * java -p out -m greeter/com.javamodularity.greeter.Main
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Greetings from a module!");
    }
}