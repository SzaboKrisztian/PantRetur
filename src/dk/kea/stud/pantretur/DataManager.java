package dk.kea.stud.pantretur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private List<Bottle> acceptedBottles = new ArrayList<>();

    public DataManager() {
        Connection dbConnection = DBConnector.connect("root", "12345678");
        try {
            Statement statement = dbConnection.createStatement();
            ResultSet bottles = statement.executeQuery("select * from Pant;");
            while (bottles.next()) {
                acceptedBottles.add(new Bottle(bottles.getString(1), bottles.getInt(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Bottle findBottle(String type) {
        for (Bottle bottle: acceptedBottles) {
            if (type.toLowerCase().equals(bottle.getType().toLowerCase())) {
                return bottle;
            }
        }
        return null;
    }

    public void saveReceipt(Receipt receipt) {
        Connection dbConnection = DBConnector.connect("root", "12345678");
        try {
            Statement statement = dbConnection.createStatement();
            statement.executeUpdate("insert into Receipt(receiptTimestamp, total) values ('" + receipt.getTimestamp() + "', " + receipt.getTotal() + ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
