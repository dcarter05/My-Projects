public class BudgetCategory {
    // Private instance variables to store category details
    private String catName;
    private String catDescription;
    private double amount;
    private int categoryType; // 0 for Expense, 1 for Income

    // Default constructor initializing fields to default values
    public BudgetCategory() {
        setCatName("");
        setCatDescription("");
        setAmount(0);
        setCategoryType(0);
    }

    // Parameterized constructor to initialize budget category details
    public BudgetCategory(String catName, String catDescription, double amount, int categoryType) {
        this.setCatName(catName);
        this.setCatDescription(catDescription);
        this.setAmount(amount);
        this.setCategoryType(categoryType);
    }

    // Overriding toString() method to return budget category information in a formatted manner
    @Override
    public String toString() {
        return "Category: " + catName + " (" + (categoryType == 0 ? "Expense" : "Income") + ")\n" +
                "Description: " + catDescription + "\n" +
                "Amount: $" + amount;
    }

    // Getter method for category name
    public String getCatName() {
        return catName;
    }

    // Setter method for category name
    public void setCatName(String catName) {
        this.catName = catName;
    }

    // Getter method for category description
    public String getCatDescription() {
        return catDescription;
    }

    // Setter method for category description
    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    // Getter method for amount
    public double getAmount() {
        return amount;
    }

    // Setter method for amount
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Getter method for category type
    public int getCategoryType() {
        return categoryType;
    }

    // Setter method for category type
    public void setCategoryType(int categoryType) {
        this.categoryType = categoryType;
    }
}
