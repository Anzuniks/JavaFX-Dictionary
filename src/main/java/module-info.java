module KuuspisteNelja.notebook {
    requires javafx.controls;
    requires javafx.fxml;

    opens KuuspisteNelja.notebook.view to javafx.graphics, javafx.fxml;
    opens KuuspisteNelja.notebook.controller to javafx.fxml;
}