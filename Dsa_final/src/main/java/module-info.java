module com.example.dsa_final {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;

    opens User_Hompage to javafx.fxml;
    opens com.example.dsa_final to javafx.fxml;
    exports com.example.dsa_final;
}
