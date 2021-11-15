module com.tutorials.trainingsceenbuilder_11 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.tutorials.trainingsceenbuilder_11 to javafx.fxml;
    exports com.tutorials.trainingsceenbuilder_11;
}