package view;


import controller.DictionaryController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class DictionaryView extends Application {

    private DictionaryController controller;

    @Override
    public void init() {
        this.controller = new DictionaryController();
    }

    @Override
    public void start(Stage stage) {

        TextField wordInput = new TextField();
        wordInput.setPromptText("Enter a word");

        Button searchButton = new Button("Search");
        Label resultLabel = new Label("Meaning will be displayed here");

        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.getChildren().addAll(wordInput, searchButton, resultLabel);

        searchButton.setOnAction(e -> {
           String word = wordInput.getText();
           String result = controller.searchWord(word);
           resultLabel.setText(result);
        });

        Scene scene = new Scene(pane, 400, 150);
        stage.setTitle("Virtual Dictionary");
        stage.setScene(scene);
        stage.show();
    }
 }
