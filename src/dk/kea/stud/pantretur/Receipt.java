package dk.kea.stud.pantretur;

public class Receipt {
    private String timestamp;
    private int total;

    public Receipt(String timestamp, int total) {
        this.timestamp = timestamp;
        this.total = total;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getTotal() {
        return total;
    }

    public String toString() {
        return "\n\nReceipt printed at " + this.timestamp + " with total " + this.getTotal() / 100.0;
    }
}
