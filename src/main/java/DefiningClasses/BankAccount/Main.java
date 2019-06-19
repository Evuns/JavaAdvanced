package DefiningClasses.BankAccount;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        while (!"end".equalsIgnoreCase(command)) {
            String[] data = command.split("\\s+");
            switch (data[0]) {
                case "Create":
                    BankAccount newAccount = new BankAccount();
                    System.out.println(String.format("Account ID%d created", newAccount.getId()));
                    accounts.put(newAccount.getId(), newAccount);
                    break;
                case "Deposit":
                    int id = Integer.parseInt(data[1]);
                    if (id <= accounts.size()) {
                        double amount = Double.parseDouble(data[2]);
                        accounts.get(id).deposit(amount);
                        System.out.println(String.format("Deposited %.0f to ID%d", amount, id));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    BankAccount.setInterestRate(Double.parseDouble(data[1]));
                    break;
                case "GetInterest":
                    id = Integer.parseInt(data[1]);
                    if (id <= accounts.size()) {
                        System.out.printf("%.2f%n", accounts.get(id).getInterest(Integer.parseInt(data[2])));

                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
