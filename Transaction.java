public class Transaction {
    // Private instance variables to store transaction details
    private String category;
    private String date;
    private double amount;
    private String description;

    // Default constructor initializing fields to default values
    public Transaction() {
        setCategory("");
        setDate("");
        setAmount(0);
        setDescription("");
    }

    // Parameterized constructor to initialize transaction details (without category)
    public Transaction(String date, double amount, String description) {
        this.setDate(date);
        this.setAmount(amount);
        this.setDescription(description);
    }

    // Overriding toString() method to return transaction details in a formatted manner
    @Override
    public String toString() {
        return "Transaction on: " + date + "\n" +
                "Category: " + category + "\n" +
                "Amount: $" + amount + "\n" +
                "Description: " + description;
    }

    // Getter method for category
    public String getCategory() {
        return category;
    }

    // Setter method for category
    public void setCategory(String category) {
        this.category = category;
    }

    // Getter method for date
    public String getDate() {
        return date;
    }

    // Setter method for date
    public void setDate(String date) {
        this.date = date;
    }

    // Getter method for amount
    public double getAmount() {
        return amount;
    }

    // Setter method for amount
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Getter method for description
    public String getDescription() {
        return description;
    }

    // Setter method for description
    public void setDescription(String description) {
        this.description = description;
    }
}
