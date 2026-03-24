package sortingvisuals;

import sortingvisuals.algorithms.SortAlgorithm;
import sortingvisuals.algorithms.BubbleSort;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

/**
 *
 * @author Zakharii
 */
public class SortingVisualS extends Application {
    
    private int[] array;
    private Rectangle[] bars;
    
    private Pane sortingPane = new Pane();
    
    private SortAlgorithm currentAlgorithm;
    
    private static final int SCENE_WIDTH = 500;
    private static final int SCENE_HEIGHT = 500;
    private static final int ARRAY_SIZE = 40;
    
    @Override
    public void start(Stage primaryStage) {
        Button genBtn = new Button("Generate");
        Button sortBtn = new Button("Sort");
        
        ComboBox<String> algSelect = new ComboBox<>();
        algSelect.getItems().addAll("Bubble Sort");
        
        algSelect.setOnAction(e -> {
            String selected = algSelect.getValue();
            
            if (selected.equals("Bubble Sort")) {
                currentAlgorithm = new BubbleSort();
            }
        });
        
        genBtn.setOnAction(e -> generateArray());
        
        sortBtn.setOnAction(e-> {
            if (array != null) {
                sortBtn.setDisable(true);
                currentAlgorithm.sort(array, bars, sortingPane);
            }
        });
        
        HBox controls = new HBox(10);
        controls.getChildren().addAll(genBtn, algSelect, sortBtn);
        controls.setPadding(new Insets(10));
        
        sortingPane.setPrefSize(SCENE_WIDTH, SCENE_HEIGHT - 50);
        
        BorderPane root = new BorderPane();
        
        root.setTop(controls);
        root.setCenter(sortingPane);
        
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        
        primaryStage.setTitle("SortingVisualS");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    private void generateArray() {
        sortingPane.getChildren().clear();
        
        array = new int[ARRAY_SIZE];
        bars = new Rectangle[ARRAY_SIZE];
        
        Random random = new Random();
        
        double barWidth = (double) SCENE_WIDTH / ARRAY_SIZE;
        
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(400) + 20;
            
            Rectangle rect = new Rectangle(barWidth - 2, array[i]);
            rect.setFill(Color.AQUA);
            
            rect.setX(i * barWidth);
            rect.setY(sortingPane.getPrefHeight() - array[i]);
            
            bars[i] = rect;
            sortingPane.getChildren().add(rect);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }   
}