package com.game.snakegame;
import config.EventoLoop;
import config.Food;
import config.Snake;
import javafx.application.Application;
import javafx.stage.Stage;

public class Game extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Snake snake = new Snake();
        Food food = new Food();
        Cenario cenario = new Cenario(stage, snake,food);
        EventoLoop eventoLoop = new EventoLoop(cenario, snake,food);
    }
}
