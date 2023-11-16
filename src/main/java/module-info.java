module com.example.cadastromusica {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.cadastromusica to javafx.fxml;
    exports com.example.cadastromusica;
}