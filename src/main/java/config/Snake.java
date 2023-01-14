package config;

import com.game.snakegame.Cenario;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

public class Snake {

    private Canvas head;
    private ArrayList<Canvas> body = new ArrayList<>();
    private ArrayList<Integer[]> positionHistory = new ArrayList<>();

    public Snake(){
        createSnake();
    }

    private void createSnake(){
        this.head = CanvasUtil.buildSquare(Color.BLUE);
        resetPosition();
    }

    private void resetPosition(){
        this.head.setTranslateX(Config.LARGURA/2 - Config.TAMANHO_QUADRADO);
        this.head.setTranslateY(Config.ALTURA/2 - Config.TAMANHO_QUADRADO);
    }


    public Canvas getHead() {
        return head;
    }

    public Integer getPositionX(){
        return (int)this.head.getTranslateX();
    }

    public Integer getPositionY(){
        return (int)this.head.getTranslateY();
    }

    public void setPosition(Integer x, Integer y){
        this.head.setTranslateX(x);
        this.head.setTranslateY(y);

        for(int i = 0; i<body.size(); i++){
            Canvas bodyPart = body.get(i);
            Integer[] position = this.positionHistory.get(this.positionHistory.size() - (i +1));
            bodyPart.setTranslateX(position[0]);
            bodyPart.setTranslateY(position[1]);
        }

        this.positionHistory.add(new Integer[]{x,y});

        if(positionHistory.size() > body.size() + 1){
            positionHistory.remove(0);
        }
    }

    public Canvas reset(){
        resetPosition();
        changeColor(Color.BLUE);
        this.positionHistory.clear();
        this.body.clear();
        return this.head;
    }

    public void die(){
        changeColor(Color.RED);
    }

    private void changeColor(Paint color){
        GraphicsContext gc = this.getHead().getGraphicsContext2D();
        gc.clearRect(0,0,Config.TAMANHO_QUADRADO, Config.TAMANHO_QUADRADO);
        gc.setFill(color);
        gc.fillRect(0,0,Config.TAMANHO_QUADRADO, Config.TAMANHO_QUADRADO);
    }

    public void eat(Cenario scenario){
        Canvas bodyPart = CanvasUtil.buildSquare(Color.BLUE);
        scenario.add(bodyPart);
        this.body.add(bodyPart);
    }

    public boolean checkColision(Integer x, Integer y){
        for(Canvas bodyPart: this.body){
            Integer bodyPositionX = (int)bodyPart.getTranslateX();
            Integer bodyPositionY = (int)bodyPart.getTranslateY();
            if(x.equals(bodyPositionX) && y.equals(bodyPositionY)){
                return true;
            }
        }

        return false;
    }
}
