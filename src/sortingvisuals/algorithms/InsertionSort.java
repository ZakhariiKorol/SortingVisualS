package sortingvisuals.algorithms;

import sortingvisuals.animation.AnimationHelper;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class InsertionSort implements SortAlgorithm {
    
    private int i = 0;
    private int j = 0;
    
    private Timeline timeline;
    
    @Override
    public void sort (int[] array, Rectangle[] bars, Pane pane) {
        
        i = 0;
        j = 0;
        
        timeline = new Timeline(new KeyFrame(Duration.millis(600), e -> {
            //
        }));
        
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.stop();
    }
    
    @Override
    public String toString() {
        return "Insertion Sort";
    }
}