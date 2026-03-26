package sortingvisuals.algorithms;

import sortingvisuals.animation.AnimationHelper;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BubbleSort implements SortAlgorithm {
    
    private int i = 0;
    private int j = 0;
    
    private Timeline timeline;
    
    @Override
    public void sort(int[] array, Rectangle[] bars, Pane pane) {
        
        i = 0;
        j = 0;
        
        timeline = new Timeline(new KeyFrame(Duration.millis(600), e -> {

        if (i < array.length - 1) {
            if (j < array.length - i - 1) {
                
                // Reset ONLY unsorted part
                for (int k = 0;k < array.length - i; k++) {
                    bars[k].setFill(Color.AQUA);
                }
                
                // Keep sorted part green
                for (int k = array.length - i; k < array.length; k++) {
                    bars[k].setFill(Color.GREEN);
                }
                
                bars[j].setFill(Color.RED);
                bars[j + 1].setFill(Color.RED);

                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    
                    AnimationHelper.swapBars(bars, j, j + 1);
                }

                j++;

            } else {
                j = 0;
                
                bars[array.length - i - 1].setFill(Color.GREEN);
                
                i++;
            }

        } else {
            
            for (Rectangle bar : bars) {
                bar.setFill(Color.GREEN);
            }
            
            timeline.stop(); // sorting finished
        }

    }));

    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();
    }
    
    @Override
    public String toString() {
        return "Bubble Sort";
    }
}