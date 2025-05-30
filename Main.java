/*
Dorian Carter Jr.

This Java application helps users manage their personal finances by organizing client information, budgeting categories, income, and expenses. The system reads from a structured data file and outputs a formatted budget report, displaying income, expenses, and the remaining balance.

Key Features:

- File-Based Data Input: Reads client info and financial records from a structured .txt file.
- Client Profile: Stores user details including name, address, and contact information.
- Budget Management: Differentiates between income and expenses, supports multiple budget categories.
- Formatted Report: Outputs a clean, readable budget report to the console.
- Financial Summary: Calculates total income, total expenses, and unallocated income balance.
- Robust Input Handling: Skips malformed entries and ensures safe file reading.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "budgetdata.txt"; // Ensure this file is in the correct directory
        List<String> clientInfo = new ArrayList<>();
        List<String[]> expenses = new ArrayList<>();
        List<String[]> income = new ArrayList<>();
        double totalExpenses = 0;
        double totalIncome = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Read client details (first 5 lines)
            for (int i = 0; i < 5; i++) {
                clientInfo.add(br.readLine().trim());
            }

            String line;
            while ((line = br.readLine()) != null && !line.trim().equals("0")) {
                String[] parts = line.trim().split("\\s+", 3); // Split into max 3 parts

                if (parts.length < 3) {
                    System.out.println("Skipping malformed line: " + line);
                    continue;
                }

                try {
                    double amount = Double.parseDouble(parts[0].trim());
                    int type = Integer.parseInt(parts[1].trim()); // 0 = Expense, 1 = Income
                    String category = parts[2].trim();

                    // Read the next line as the description
                    String description = br.readLine();
                    if (description == null) description = ""; // Avoid null values

                    if (type == 1) {
                        income.add(new String[]{category, String.format("%.2f", amount), description});
                        totalIncome += amount;
                    } else {
                        expenses.add(new String[]{category, String.format("%.2f", amount), description});
                        totalExpenses += amount;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid data: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Print report
        System.out.println("\nSample Budget Report:\n");
        for (String info : clientInfo) {
            System.out.println(info);
        }

        System.out.println("\nExpenses");
        for (String[] exp : expenses) {
            System.out.printf("%-15s %7s   %s\n", exp[0], exp[1], exp[2]);
        }

        System.out.printf("\nTotal Allocated: %.2f\n", totalExpenses);

        System.out.println("\nIncome");
        for (String[] inc : income) {
            System.out.printf("%-15s %7s   %s\n", inc[0], inc[1], inc[2]);
        }

        System.out.printf("\nTotal income: %.2f\n", totalIncome);
        System.out.printf("Unallocated income: %.2f\n", totalIncome - totalExpenses);
    }
}