package config;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

import static config.Config.TAMANHO_QUADRADO;

public class CanvasUtil {
    public static Canvas buildSquare(Paint color){
        Canvas square = new Canvas(TAMANHO_QUADRADO, TAMANHO_QUADRADO);
        GraphicsContext gc = square.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0,0, TAMANHO_QUADRADO, TAMANHO_QUADRADO);
        return square;
    }

}
