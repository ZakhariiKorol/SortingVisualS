package sortingvisuals.animation;

import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class AnimationHelper {
    public static void swapBars(Rectangle[] bars, int i, int j) {
        Rectangle bar1 = bars[i];
        Rectangle bar2 = bars[j];
        
        double distance = bar2.getX() - bar1.getX();
        
        // Bar 1 moving right
        TranslateTransition tt1 = new TranslateTransition(Duration.millis(300), bar1);
        tt1.setByX(distance);
        
        // Bar 2 moving left
        TranslateTransition tt2 = new TranslateTransition(Duration.millis(300), bar2);
        tt2.setByX(-distance);
        
        tt1.play();
        tt2.play();
        
        final int[] finished = {0};
        
        Runnable onFinished = () -> {
            finished[0]++;
            if (finished[0] == 2) {
                bar1.setTranslateX(0);
                bar2.setTranslateX(0);
                
                double tempX = bar1.getX();
                bar1.setX(bar2.getX());
                bar2.setX(tempX);
                
                Rectangle temp = bars[i];
                bars[i] = bars[j];
                bars[j] = temp;
            }
        };
        
        tt1.setOnFinished(e -> onFinished.run());
        tt2.setOnFinished(e -> onFinished.run());
    }
}