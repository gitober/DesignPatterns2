package Memento;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history;
    private List<IMemento> redoList;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoList = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        clearRedoList();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        clearRedoList();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    // Undo-toiminto (Ctrl+Z) peruuttaa viimeisen tehdyn muutoksen ja palauttaa sovelluksen aiempaan tilaan
    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Undo operation");
            IMemento previousState = history.remove(history.size() - 1);
            redoList.add(model.createMemento());
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    // Redo-toiminto (Ctrl+Y) palauttaa viimeksi peruutetun muutoksen ja palauttaa sovelluksen myöhempään tilaan
    public void redo() {
        if (!redoList.isEmpty()) {
            System.out.println("Redo operation");
            IMemento redoState = redoList.remove(redoList.size() - 1);
            saveToHistory();
            model.restoreState(redoState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }

    // Tyhjennetään uudelleentoiminnon lista, koska uusi muutos mitätöi aiemmat peruutetut tilat
    private void clearRedoList() {
        redoList.clear();
    }

    public List<IMemento> getHistory() {
        return history;
    }

    // Getteri modelille, jotta Gui-luokka voi käyttää ja palauttaa mallin tilan
    public Model getModel() {
        return model;
    }

    // Getteri guille, jotta Controller-luokka voi käyttää ja palauttaa käyttöliittymän
    public Gui getGui() {
        return gui;
    }
}
