package config;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class Food {
    private Canvas food;

    public Food() {
        createFood();
        setRandomPosition();
    }

    private void createFood(){
        this.food = CanvasUtil.buildSquare(Color.YELLOW);
    }

    public void setRandomPosition(){
        this.food.setTranslateX(randomNumber(0, Config.LARGURA - Config.TAMANHO_QUADRADO));
        this.food.setTranslateY(randomNumber(0, Config.ALTURA - Config.TAMANHO_QUADRADO));
    }

    private Integer randomNumber(Integer min, Integer max){
        int value = (int)(Math.random() * ((max - min) + 1)) + min;
        return value - (value % Config.TAMANHO_QUADRADO);
    }

    public Canvas getFood() {
        return food;
    }

    public Integer getPositionX(){
        return (int)this.food.getTranslateX();
    }

    public Integer getPositionY(){
        return (int)this.food.getTranslateY();
    }
}
