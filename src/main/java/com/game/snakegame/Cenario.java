package com.game.snakegame;

import config.*;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Cenario {
    private Scene scene;
    private Group root = new Group();
    private Snake snake;
    private Food food;

    public Cenario(Stage primaryStage, Snake snake, Food food){
        this.scene = new Scene(root, Config.LARGURA,Config.ALTURA);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Jogo Da Cobrinha Feito Por Selton Alves ");
        primaryStage.show();

        this.snake = snake;
        this.food = food;

        root.getChildren().add(snake.getHead());
        root.getChildren().add(food.getFood());
    }

    public void setKeyPressed(EventHandler<? super KeyEvent> action){
        this.scene.setOnKeyPressed(action);
    }

    public void showGameOver(EventoLoop eventLoop){
        TryAgainButton tryAgainButton = new TryAgainButton(e -> {
            clean();
            add(this.snake.reset());
            add(this.food.getFood());
            eventLoop.starLoop();
        });

        this.root.getChildren().add(tryAgainButton);
    }

    private void clean(){
        this.root.getChildren().remove(0,this.root.getChildren().size());
    }

    public void add(Node node){
        this.root.getChildren().add(node);
    }
}
