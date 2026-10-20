module com.mycompany.enteroo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.enteroo to javafx.fxml;
    exports com.mycompany.enteroo;
}
