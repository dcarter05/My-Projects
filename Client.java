import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Client {
    // Private attributes for encapsulation
    private String firstName;
    private String lastName;
    private Contact contact;
    private Budget budget;

    // Default constructor: Initializes empty values
    public Client() {
        this.firstName = "";
        this.lastName = "";
        this.contact = new Contact(); // Initialize with default Contact object
        this.budget = new Budget();   // Initialize with default Budget object
    }

    // Parameterized constructor: Initializes with provided names
    public Client(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.contact = new Contact(); // Ensure contact is initialized
        this.budget = new Budget();   // Ensure budget is initialized
    }

    // Overrides the default toString() method to provide meaningful output
    @Override
    public String toString() {
        return "Client Information:" + System.lineSeparator() +
                "First Name: " + firstName + System.lineSeparator() +
                "Last Name: " + lastName + System.lineSeparator() +
                "Contact: " + (contact != null ? contact.toString() : "No contact info") + System.lineSeparator() +
                "Budget: " + (budget != null ? budget.toString() : "No budget info") + System.lineSeparator();
    }

    public void loadClientFile(File filename) throws IOException {
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            if (scanner.hasNextLine()) this.firstName = scanner.nextLine();
            if (scanner.hasNextLine()) this.lastName = scanner.nextLine();
            if (scanner.hasNextLine()) this.contact.setHomeAddress(scanner.nextLine());
            if (scanner.hasNextLine()) this.contact.setPhone(scanner.nextLine());;
            if (scanner.hasNextLine()) this.contact.setEmail(scanner.nextLine());;
            if (scanner.hasNextLine()) this.budget.setTotalIncome(scanner.nextDouble());
        }
    }

    public void saveClientFile(File filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(firstName + System.lineSeparator());
            writer.write(lastName + System.lineSeparator());
            writer.write(contact.getHomeAddress() + System.lineSeparator());
            writer.write(contact.getPhone() + System.lineSeparator());
            writer.write(contact.getEmail() + System.lineSeparator());
            writer.write(budget.getTotalIncome() + System.lineSeparator());
        }
    }

    public String getBudgetReport() {
        return "Budget Report:" + System.lineSeparator() +
                "Total Income: " + budget.getTotalIncome() + System.lineSeparator() +
                "Total Allocated: " + budget.getTotalAllocated() + System.lineSeparator() +
                "Remaining Balance: " + budget.getAllocationBalance();
    }

    // Getter method for firstName
    public String getFirstName() {
        return firstName;
    }

    // Setter method for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter method for lastName
    public String getLastName() {
        return lastName;
    }

    // Setter method for lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter method for contact
    public Contact getContact() {
        return contact;
    }

    // Setter method for contact with null check
    public void setContact(Contact contact) {
        if (contact != null) {
            this.contact = contact;
        }
    }

    // Getter method for budget
    public Budget getBudget() {
        return budget;
    }

    // Setter method for budget with null check
    public void setBudget(Budget budget) {
        if (budget != null) {
            this.budget = budget;
        }
    }
}