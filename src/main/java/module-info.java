module com.game.snakegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.game.snakegame to javafx.fxml;
    exports com.game.snakegame;
}