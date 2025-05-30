import java.util.ArrayList;

public class Budget {
    // List to store budget categories
    private ArrayList<BudgetCategory> categories;

    // Total amount allocated across all categories
    private double totalAllocated;

    // Total income available for budgeting
    private double totalIncome;

    // Default constructor initializes an empty budget
    public Budget() {
        setCategories(new ArrayList<>());
        setTotalAllocated(0);
        setTotalIncome(0);
    }

    // Returns a string representation of the budget, including all categories and balance
    @Override
    public String toString() {
        return "Budget{" +
                "categories=" + categories +
                ", totalAllocated=" + totalAllocated +
                ", totalIncome=" + totalIncome +
                ", allocationBalance=" + getAllocationBalance() +
                '}';
    }

    // Calculates and returns the remaining balance after allocation
    public double getAllocationBalance() {
        return totalIncome - totalAllocated;
    }

    // Returns the list of budget categories
    public ArrayList<BudgetCategory> getCategories() {
        return categories;
    }

    // Sets the list of budget categories with a null check
    public void setCategories(ArrayList<BudgetCategory> categories) {
        if (categories != null) {
            this.categories = categories;
            recalculateTotalAllocated();
        }
    }

    // Returns the total allocated amount
    public double getTotalAllocated() {
        return totalAllocated;
    }

    // Sets the total allocated amount
    public void setTotalAllocated(double totalAllocated) {
        this.totalAllocated = Math.max(totalAllocated, 0);
    }

    // Returns the total income
    public double getTotalIncome() {
        return totalIncome;
    }

    // Sets the total income with a non-negative value constraint
    public void setTotalIncome(double totalIncome) {
        this.totalIncome = Math.max(totalIncome, 0);
    }

    // Returns the number of categories in the budget
    public int getCategoriesSize() {
        return categories.size();
    }

    // Retrieves a category at a given index, returns null if index is invalid
    public BudgetCategory getCategory(int index) {
        if (index >= 0 && index < categories.size()) {
            return categories.get(index);
        }
        return null;
    }

    // Updates a category at a specified index, adjusting total allocated amount
    public boolean setCategory(int index, BudgetCategory category) {
        if (index >= 0 && index < categories.size() && category != null) {
            totalAllocated -= categories.get(index).getAmount();
            categories.set(index, category);
            totalAllocated += category.getAmount();
            return true;
        }
        return false;
    }

    // Adds a new category to the budget and updates total allocated
    public void addCategory(BudgetCategory category) {
        if (category != null) {
            categories.add(category);
            totalAllocated += category.getAmount();
        }
    }

    // Removes a category at the given index and updates total allocated
    public BudgetCategory removeCategory(int index) {
        if (index >= 0 && index < categories.size()) {
            BudgetCategory removedCategory = categories.remove(index);
            totalAllocated -= removedCategory.getAmount();
            return removedCategory;
        }
        return null;
    }

    // Private helper method to recalculate the total allocated budget
    private void recalculateTotalAllocated() {
        totalAllocated = 0;
        for (BudgetCategory category : categories) {
            totalAllocated += category.getAmount();
        }
    }
}
