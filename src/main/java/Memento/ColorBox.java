package Memento;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorBox {

    private int id;
    private Controller controller;
    private Rectangle rectangle;
    private Color[] colors = {Color.RED, Color.BLUE, Color.YELLOW};
    private int colorIndex = 0;

    public ColorBox(int id, Controller controller) {
        this.id = id;
        this.controller = controller;

        // Luo JavaFX Rectangle ja aseta väri
        rectangle = new Rectangle(100, 100);
        rectangle.setFill(colors[colorIndex]);

        // Klikattaessa väri vaihtuu ja historianäkymä päivittyy
        rectangle.setOnMouseClicked(e -> {
            changeColor();
            controller.setOption(id, colorIndex);
            controller.getGui().updateHistoryView(); // Päivitä historianäkymä
        });
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void changeColor() {
        colorIndex = (colorIndex + 1) % colors.length;  // Vaihda väri
        rectangle.setFill(colors[colorIndex]);
    }

    public void setColor(int index) {
        colorIndex = index;
        rectangle.setFill(colors[colorIndex]);  // Aseta väri
    }
}
