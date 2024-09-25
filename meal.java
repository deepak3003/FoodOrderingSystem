package FoodOrderingSystem;

import java.util.Scanner;

public class meal {

    public static void menu() {
        System.out.println("1. Burger - ₹50.00");
        System.out.println("2. Pizza - ₹80.00");
        System.out.println("3. Sandwich - ₹40.00");
        System.out.println("4. Coke - ₹20.00");
        System.out.println("5. Exit");

    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int choice;
            String order = "";

            int total = 0;

            while (!order.equalsIgnoreCase("n")) {
                menu();
                System.out.print("Please select an item (1-5): ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        total += 50;
                        break;
                    case 2:
                        total += 80;
                        break;
                    case 3:
                        total += 40;
                        break;
                    case 4:
                        total += 20;
                        break;
                    case 5:
                        order = "n";
                        continue;

                    default:
                        System.out.println("Invalid selection.");
                }
                sc.nextLine();
                System.out.println("Would you like to order anything else? (y/n)");
                order = sc.nextLine();
            }
            System.out.println("Your total is:" + total + "\nThank you for your order!");
            sc.close();
        }
    }

}
