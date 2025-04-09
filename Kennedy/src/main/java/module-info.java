module com.kennedy.kennedy {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.kennedy.kennedy to javafx.fxml;
    exports com.kennedy.kennedy;
}