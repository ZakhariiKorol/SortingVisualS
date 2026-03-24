package sortingvisuals.algorithms;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public interface SortAlgorithm {
    void sort(int[] array, Rectangle[] bars, Pane pane);
}