package FoodOrderingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MealOrderingSystem {

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
            List<String> orders = new ArrayList<>();

            double total = 0;

            while (!order.equalsIgnoreCase("n")) {
                menu();
                System.out.print("Please select an item (1-5): ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        total += 50;
                        System.out.println("You added a Burger");
                        orders.add("Burger");
                        break;
                    case 2:
                        total += 80;
                        System.out.println("You added a Pizza");
                        orders.add("Pizza");
                        break;
                    case 3:
                        total += 40;
                        System.out.println("You added a Sandwich");
                        orders.add("Sandwich");
                        break;
                    case 4:
                        total += 20;
                        System.out.println("You added a Coke");
                        orders.add("Coke");
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
            System.out.print("You ordered a ");
            System.out.println(orders);
            System.out.println("Your total is: ₹" + total + "\nThank you for your order!");
        }
    }

}
