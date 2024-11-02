import java.util.HashMap;
import javax.swing.*;

public class bank {   
    private static HashMap<String, Integer> NamePassword = new HashMap<>();
    private static HashMap<String, Integer> NameAmount = new HashMap<>();

    public static void create() {
        String name = JOptionPane.showInputDialog("Enter your Name:");
        String passwordStr = JOptionPane.showInputDialog("Enter your password:");

        if (name == null || passwordStr == null) {
            return;
        }

        try {
            int password = Integer.parseInt(passwordStr);
            if (NamePassword.containsKey(name)) {
                JOptionPane.showMessageDialog(null, "Oops! Name already exists. Please provide a unique name!");
            } else {
                NamePassword.put(name, password);
                NameAmount.put(name, 0);
                JOptionPane.showMessageDialog(null, "Account Created!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid password! Please enter a numeric password.");
        }
    }

    public static void credit() {
        String name = JOptionPane.showInputDialog("Enter your Name:");
        if (name == null) return; 

        if (NamePassword.containsKey(name)) {
            String creditAmountStr = JOptionPane.showInputDialog("Enter the credit amount:");
            String passwordStr = JOptionPane.showInputDialog("Enter the password:");
            if (creditAmountStr == null || passwordStr == null) {
                return; 
            }

            try {
                int creditAmount = Integer.parseInt(creditAmountStr);
                int password = Integer.parseInt(passwordStr);
                if (NamePassword.get(name) == password) {
                    int currentBalance = NameAmount.get(name);
                    currentBalance += creditAmount;
                    NameAmount.put(name, currentBalance);
                    JOptionPane.showMessageDialog(null, "Credit added successfully! New balance: " + currentBalance);
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Password!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a numeric value.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Account not found. Please check the name and try again.");
        }
    }

    public static void debit() {
        String name = JOptionPane.showInputDialog("Enter your Name:");
        if (name == null) return; 

        if (NamePassword.containsKey(name)) {
            String debitAmountStr = JOptionPane.showInputDialog("Enter the debit amount:");
            String passwordStr = JOptionPane.showInputDialog("Enter the password:");
            if (debitAmountStr == null || passwordStr == null) {
                return;
            }

            try {
                int debitAmount = Integer.parseInt(debitAmountStr);
                int password = Integer.parseInt(passwordStr);
                if (NamePassword.get(name) == password) {
                    int currentBalance = NameAmount.get(name);
                    if (currentBalance >= debitAmount) {
                        currentBalance -= debitAmount;
                        NameAmount.put(name, currentBalance);
                        JOptionPane.showMessageDialog(null, "Debited successfully! New balance: " + currentBalance);
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient balance for this operation.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Password!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a numeric value.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Account not found. Please check the name and try again.");
        }
    }

    public static void viewBalance() {
        String name = JOptionPane.showInputDialog("Enter your Name:");
        if (name == null) return;

        if (NamePassword.containsKey(name)) {
            String passwordStr = JOptionPane.showInputDialog("Enter your Password:");
            if (passwordStr == null) return; 

            try {
                int password = Integer.parseInt(passwordStr);
                if (NamePassword.get(name) == password) {
                    int currentBalance = NameAmount.get(name);
                    JOptionPane.showMessageDialog(null, "Your current balance is: " + currentBalance);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Password!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a numeric value.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Account not found. Please check the name and try again.");
        }
    }

    public static void logo() {
        StringBuilder logo = new StringBuilder();
        logo.append("Welcome!..");
        JOptionPane.showMessageDialog(null, logo.toString());
    }

    public static void main(String[] args) {
        logo();
        while (true) {
            String menu = "1) Create an account...\n"
                    + "2) Credit amount...\n"
                    + "3) Debit amount...\n"
                    + "4) View Balance...\n"
                    + "5) Exit...";
            String choiceStr = JOptionPane.showInputDialog(menu);
            if (choiceStr == null) {
                JOptionPane.showMessageDialog(null, "Exiting the program. Goodbye!");
                System.exit(0);
            }

            try {
                int choice = Integer.parseInt(choiceStr);
                switch (choice) {
                    case 1:
                        create();
                        break;
                    case 2:
                        credit();
                        break;
                    case 3:
                        debit();
                        break;
                    case 4:
                        viewBalance();
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Exiting the program. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice! Please select a valid option.");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a numeric value.");
            }
        }
    }
}
