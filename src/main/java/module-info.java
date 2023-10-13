module com.example.dynamicfxaction {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dynamicfxaction to javafx.fxml;
    exports com.example.dynamicfxaction;
}