module com.example.notes_zhavoronkov {
    requires fastjson;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.notes_zhavoronkov to javafx.fxml;
    exports com.example.notes_zhavoronkov;
}