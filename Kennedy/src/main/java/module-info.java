module com.kennedy.kennedy {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.kennedy.kennedy to javafx.fxml;
    exports com.kennedy.kennedy;
    exports com.kennedy.kennedy.controllers;
    opens com.kennedy.kennedy.controllers to javafx.fxml;
    exports com.kennedy.kennedy.metiers;
    opens com.kennedy.kennedy.metiers to javafx.fxml;

    opens com.kennedy.kennedy.views to javafx.fxml;

    exports com.kennedy.kennedy.bd;
}