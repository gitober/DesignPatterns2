package Memento;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class Gui extends Application {

    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;
    private ListView<String> listView; // ListView for history

    public void start(Stage stage) {

        controller = new Controller(this);

        // Insets for margin and padding
        Insets insets = new Insets(10, 10, 10, 10);

        // Create three ColorBoxes
        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        // Create a CheckBox
        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        // Add the ColorBoxes and CheckBox to an HBox
        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        // Insets
        HBox.setMargin(colorBox1.getRectangle(), insets);
        HBox.setMargin(colorBox2.getRectangle(), insets);
        HBox.setMargin(colorBox3.getRectangle(), insets);

        // Updated label with instructions for Undo, Redo, and History
        Label label = new Label("Press Ctrl-Z to undo, Ctrl-Y to redo, Ctrl-H to view history.");
        label.setPadding(insets);

        // Create a VBox that contains the HBox and the CheckBox
        VBox vBox = new VBox(hBox, checkBox, label);

        // Call controller when the CheckBox is clicked
        checkBox.setOnAction(event -> {
            controller.setIsSelected(checkBox.isSelected());
            updateHistoryView(); // Päivitä historianäkymä
        });

        // Set the VBox to be the root of the Scene
        Scene scene = new Scene(vBox);
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                // Ctrl-Z: undo
                System.out.println("Undo key combination pressed");
                controller.undo();
                updateHistoryView(); // Päivitä historianäkymä
            } else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                // Ctrl-Y: redo
                System.out.println("Redo key combination pressed");
                controller.redo();
                updateHistoryView(); // Päivitä historianäkymä
            } else if (event.isControlDown() && event.getCode() == KeyCode.H) {
                // Ctrl-H: open history window
                openHistoryWindow();
            }
        });

        stage.setX(100);
        stage.setY(100);

        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();

        // Avaa historianäkymä automaattisesti sovelluksen käynnistyessä
        openHistoryWindow();
    }

    public void updateGui() {
        // Called after restoring state from a Memento
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }

    // Päivitetään historianäkymä reaaliajassa
    public void updateHistoryView() {
        if (listView != null) {
            listView.getItems().clear(); // Tyhjennetään vanhat tilat
            for (IMemento memento : controller.getHistory()) {
                listView.getItems().add(memento.toString()); // Display the saved timestamp from the Memento object
            }
        }
    }

    // Avaa historianäkymän
    private void openHistoryWindow() {
        Stage historyStage = new Stage();
        historyStage.setTitle("History of States");

        historyStage.setX(500);
        historyStage.setY(100);

        listView = new ListView<>();
        updateHistoryView();

        listView.setOnMouseClicked(event -> {
            int selectedIndex = listView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                System.out.println("Restoring state from history...");
                IMemento selectedMemento = controller.getHistory().get(selectedIndex);
                controller.getModel().restoreState(selectedMemento);
                updateGui();
            }
        });

        VBox vbox = new VBox(listView);
        Scene historyScene = new Scene(vbox, 300, 400);
        historyStage.setScene(historyScene);
        historyStage.show();
    }
}
