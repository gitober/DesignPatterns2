package Memento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memento implements IMemento {
    private int[] options; // Stores the color index of each ColorBox
    private boolean isSelected; // Stores the CheckBox state
    private String timestamp; // Stores the timestamp

    // Päivämäärän ja ajan muotoilu historianäkymää varten
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone();
        this.isSelected = isSelected;
        this.timestamp = LocalDateTime.now().format(formatter); // Capture timestamp when Memento is created
    }

    public int[] getOptions() {
        return options.clone();
    }

    public boolean isSelected() {
        return isSelected;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "State saved at: " + timestamp;
    }
}
