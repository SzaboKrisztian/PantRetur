package dk.kea.stud.pantretur;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

public class BottleDevourer {
    private List<Bottle> currentBottles = new ArrayList<>();
    private int runningTotal = 0;
    private DataManager dataManager = new DataManager();
    private final DateTimeFormatter TIMESTAMP_FORMAT = new DateTimeFormatterBuilder()
      .appendPattern("yyyy-MM-dd[ HH][:mm][:ss]")
      .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
      .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
      .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
      .toFormatter();

    public boolean addBottle(String type) {
        Bottle currentBottle = dataManager.findBottle(type);
        if (currentBottle == null) {
            return false;
        } else {
            currentBottles.add(currentBottle);
            runningTotal += currentBottle.getPantValue();
            return true;
        }
    }

    public void getReceipt() {
        Receipt currentReceipt = new Receipt(LocalDateTime.now().format(TIMESTAMP_FORMAT), runningTotal);
        System.out.println(currentReceipt);
        dataManager.saveReceipt(currentReceipt);
        this.runningTotal = 0;
    }

    public void donate() {
        this.runningTotal = 0;
    }

    public int getRunningTotal() {
        return this.runningTotal;
    }
}
