package KuuspisteKakkonen;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ValuuttaGUI extends Application {

    // Käytetään kontrolleria, joka hallinnoi valuuttoja ja laskentaa
    private final ValuuttaController controller = new ValuuttaController();

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20)); // Lisätään marginaalit
        grid.setHgap(10); // Sarakkeiden väli
        grid.setVgap(10); // Rivien väli

        // 1. Ohjeet
        Label ohjeLabel = new Label("Syötä määrä ja valitse valuutat:");
        grid.add(ohjeLabel, 0, 0, 2, 1);

        // 2. Syöttökenttä ja Label
        grid.add(new Label("Määrä:"), 0, 1);
        TextField maaraField = new TextField();
        grid.add(maaraField, 1, 1);

        // 3. Valuuttavalinnat (Labelit suoraan laatikoiden päälle)
        Label mistaLabel = new Label("Mistä:");
        ComboBox<Valuutta> mistaBox = new ComboBox<>(); // Tyypiksi Valuutta
        mistaBox.getItems().addAll(controller.getValuutat());
        mistaBox.getSelectionModel().selectFirst();
        grid.add(mistaLabel, 0, 2);
        grid.add(mistaBox, 0, 3);

        Label mihinLabel = new Label("Mihin:");
        ComboBox<Valuutta> mihinBox = new ComboBox<>(); // Tyypiksi Valuutta
        mihinBox.getItems().addAll(controller.getValuutat());
        mihinBox.getSelectionModel().select(1);
        grid.add(mihinLabel, 1, 2);
        grid.add(mihinBox, 1, 3);

        // 4. Tuloskenttä (vain luku)
        grid.add(new Label("Tulos:"), 0, 4);
        TextField tulosField = new TextField();
        tulosField.setEditable(false);
        grid.add(tulosField, 1, 4);

        // 5. Muunnosnappi
        Button convertBtn = new Button("Muunna");
        grid.add(convertBtn, 1, 5);

        // Tapahtumankäsittely
        convertBtn.setOnAction(e -> {
            try {
                double maara = Double.parseDouble(maaraField.getText());

                // KORJATTU: ComboBox palauttaa Valuutta-olion, ei Stringiä
                Valuutta mista = mistaBox.getValue();
                Valuutta mihin = mihinBox.getValue();

                if (mista != null && mihin != null) {
                    double tulos = controller.muunna(maara, mista, mihin);
                    tulosField.setText(String.format("%.2f", tulos)); // Päivitetään kenttä
                }
            } catch (NumberFormatException ex) {
                tulosField.setText("Virheellinen syöte"); // Virheiden hallinta
            }
        });

        Scene scene = new Scene(grid, 400, 350);

        // CSS fontin muutos sans-serifiksi
        scene.getRoot().setStyle("-fx-font-family: 'sans-serif';");

        primaryStage.setTitle("Valuuttamuunnin");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}