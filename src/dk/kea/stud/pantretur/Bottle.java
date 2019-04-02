package dk.kea.stud.pantretur;

public class Bottle {
    private String type;
    private int pantValue;

    public Bottle(String type, int pantValue) {
        this.type = type;
        this.pantValue = pantValue;
    }

    public String getType() {
        return type;
    }

    public int getPantValue() {
        return pantValue;
    }
}
