module com.example.cadastromusica {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.cadastromusica to javafx.fxml;
    exports com.example.cadastromusica;
    exports com.example.cadastromusica.Controller;
    opens com.example.cadastromusica.Controller to javafx.fxml;
    exports com.example.cadastromusica.Model;
    opens com.example.cadastromusica.Model to javafx.fxml;
}