import java.util.ArrayList;

public class Tracker {
    // List to store all transactions
    private ArrayList<Transaction> transactions;

    // Variable to track the total balance
    private double balance;

    // Constructor initializes an empty transaction list and sets balance to 0
    public Tracker() {
        setTransactions(new ArrayList<>());
        setBalance(0);
    }

    // Overrides the toString method to provide a formatted string representation of the Tracker object
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tracker Balance: ").append(balance).append("\nTransactions:\n");

        // Iterate over transactions and append their string representation
        for (Transaction t : transactions) {
            sb.append(t.toString()).append("\n");
        }

        return sb.toString();
    }

    // Getter method to retrieve the list of transactions
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    // Setter method to update the list of transactions
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    // Getter method to retrieve the current balance
    public double getBalance() {
        return balance;
    }

    // Setter method to update the balance
    public void setBalance(double balance) {
        this.balance = balance;
    }
}