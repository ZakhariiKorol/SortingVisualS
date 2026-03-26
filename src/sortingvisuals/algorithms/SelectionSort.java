package sortingvisuals.algorithms;

import sortingvisuals.animation.AnimationHelper;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SelectionSort implements SortAlgorithm {
    
    private int i = 0;
    private int j = 0;
    private int minIndex = 0;
    
    private Timeline timeline;
    
    @Override
    public void sort(int[] array, Rectangle[] bars, Pane pane) {
        
        i = 0;
        j = 0;
        
        timeline = new Timeline(new KeyFrame(Duration.millis(600), e -> {
            
            if (i < array.length - 1) {
                if (j < array.length) {
                    // Reset colors
                    for (int k = 0;k < array.length; k++) {
                        if (k < i) {
                            bars[k].setFill(Color.GREEN);
                        } else {
                            bars[k].setFill(Color.AQUA);
                        }
                    }
                    
                    // Highligt curremin min
                    bars[minIndex].setFill(Color.BLUE);
                    
                    // Current scanning
                    bars[j].setFill(Color.RED);
                    
                    // Find new min
                    if (array[j] < array[minIndex]) {
                        minIndex = j;
                    }
                    
                    j++;
                } else {
                    // Swap min with i
                    if (minIndex != i) {
                        int temp = array[i];
                        array[i] = array[minIndex];
                        array[minIndex] = temp;
                        
                        AnimationHelper.swapBars(bars, i, minIndex);
                    }
                    
                    // Mark sorted
                    bars[i].setFill(Color.GREEN);
                    
                    // Move to next pos
                    i++;
                    minIndex = i;
                    j = i + 1;
                }
            } else {
                for (Rectangle bar : bars) {
                    bar.setFill(Color.GREEN);
                }
                
                ((Timeline) e.getSource()).stop();
            }
        }));
        
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    
    @Override
    public String toString() {
        return "Selection Sort";
    }
}