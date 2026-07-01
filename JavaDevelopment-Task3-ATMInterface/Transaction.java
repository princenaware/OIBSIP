import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private static int counter = 1001;

    private int transactionId;
    private String type;
    private double amount;
    private String dateTime;

    public Transaction(String type, double amount) {

        this.transactionId = counter++;
        this.type = type;
        this.amount = amount;

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");

        this.dateTime =
                LocalDateTime.now().format(formatter);
    }

    @Override
    public String toString() {

        return "Txn ID: " + transactionId
                + " | " + dateTime
                + " | " + type
                + " | ₹" + String.format("%.2f", amount);
    }
}