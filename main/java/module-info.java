module com.example.tp3exo_vuefx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires json.simple;

    opens com.example.tp3exo_vuefx to javafx.fxml;
    exports com.example.tp3exo_vuefx;
}