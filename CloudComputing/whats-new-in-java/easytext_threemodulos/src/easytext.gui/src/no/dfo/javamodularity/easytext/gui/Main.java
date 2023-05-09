package no.dfo.javamodularity.easytext.gui;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import no.dfo.javamodularity.easytext.analysis.FleschKincaid;


/**
 *  ..\..\..\..\Java\jdk-20.0.1\bin\javac --module-source-path src -d out $(find . name '*.java')
 *  ..\..\..\..\Java\jdk-20.0.1\bin\java -mp out -easytext.cli/no.dfo.javamodularity.easytext.cli.Main
 *
 *  ..\..\..\..\Java\jdk-20.0.1\bin\java --list-modules
 *  ..\..\..\..\Java\jdk-20.0.1\bin\java --list-modules javafx.controls
 *
 * PS C:\workspace2\JavaApp\CloudComputing\whats-new-in-java> ..\..\..\..\Java\jdk-17.0.6+10\bin\javac --module-source-path src -d out .\easytext.gui\src\n
 * o\dfo\javamodularity\easytext\gui\Main.java
 * .\easytext.gui\src\no\dfo\javamodularity\easytext\gui\Main.java:1: error: not in a module on the module source path
 * package no.dfo.javamodularity.easytext.gui;
 * ^
 * 1 error
 * PS C:\workspace2\JavaApp\CloudComputing\whats-new-in-java>
 *
 */
public class Main extends Application {

    private static ComboBox<String> algorithm;
    private static TextArea input;
    private static Text output;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("EasyText");
        Button btn = new Button();
        btn.setText("Calculate");
        //Important
        btn.setOnAction(event ->
                output.setText(analyze(input.getText(), (String) algorithm.getValue()))
        );

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(3));
        vbox.setSpacing(3);
        Text title = new Text("Choose an algorithm:");
        algorithm = new ComboBox<>();
        algorithm.getItems().add("Flesch-Kincaid");

        vbox.getChildren().add(title);
        vbox.getChildren().add(algorithm);
        vbox.getChildren().add(btn);

        input = new TextArea();
        output = new Text();
        BorderPane pane = new BorderPane();
        pane.setRight(vbox);
        pane.setCenter(input);
        pane.setBottom(output);
        primaryStage.setScene(new Scene(pane, 600, 450));
        primaryStage.show();
    }

    private String analyze(String input, String algorithm) {
        List<List<String>> sentences = toSentences(input);

        return "Flesch-Kincaid: " + new FleschKincaid().analyze(sentences);
    }


    public static List<List<String>> toSentences(String text) {
        String removedBreaks = text.replaceAll("\\r?\\n", " ");
        ArrayList<List<String>> sentences = new ArrayList<>();
        for(String rawSentence: removedBreaks.split("[\\.\\?\\!]")) {
            List<String> words = toWords(rawSentence);
            if(words.size() > 0) {
                sentences.add(words);
            }
        }

        return sentences;
    }

    public static List<String> toWords(String sentence) {
        String[] rawWords = sentence.split("\\s+");
        List<String> words = new ArrayList<>();
        for(String rawWord: rawWords) {
            String word = rawWord.replaceAll("\\W", "");
            if(word.length() > 0) {
                words.add(word);
            }
        }

        return words;
    }
}
