package pildoras.javafx_controles_videos261_269;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.*;
import javafx.stage.Stage;

/**
 * JavaFX https://www.geeksforgeeks.org/javafx-combobox-with-examples/
 * no es del curso de pildoras
 */
public class Video263b_ComboBox extends Application {

    @Override
    public void start(Stage stage) {

// Set title for the stage
        stage.setTitle("creating combo box ");

        // Create a tile pane
        TilePane r = new TilePane();

        // Create a label
        Label description_label
                = new Label("This is a combo box example ");

        // Weekdays
        String week_days[]
                = {"Monday", "Tuesday", "Wednesday",
                    "Thursday", "Friday"};

        // Create a combo box
        ComboBox combo_box
                = new ComboBox(FXCollections
                        .observableArrayList(week_days));

        // Label to display the selected menuitem
        Label selected = new Label("default item selected");

        // Create action event
        EventHandler<ActionEvent> event
                = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                selected.setText(combo_box.getValue() + " selected");
            }
        };

        // Set on action
        combo_box.setOnAction(event);

        // Create a tile pane
        TilePane tile_pane = new TilePane(combo_box, selected);

        // Create a scene
        Scene scene = new Scene(tile_pane, 200, 200);

        // Set the scene
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

