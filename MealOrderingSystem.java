package FoodOrderingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Menu {
    public void displayMenu() {
        System.out.println("1. Burger - ₹50.00");
        System.out.println("2. Pizza - ₹80.00");
        System.out.println("3. Sandwich - ₹40.00");
        System.out.println("4. Coke - ₹20.00");
        System.out.println("5. Exit");

    }
}

class Order {
    private final List<String> orders = new ArrayList<>();
    private double total = 0;

    public void addItem(int choice) {
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


            default:
                System.out.println("Invalid selection.");
        }
    }

    public void displayOrder() {
        System.out.print("You ordered a ");
        System.out.println(orders);
        System.out.println("Your total is: ₹" + total + "\nThank you for your order!");

    }
}

public class MealOrderingSystem {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Order order = new Order();
        try (Scanner sc = new Scanner(System.in)) {

            String orderMore = "";
            while (!orderMore.equalsIgnoreCase("n")) {
                menu.displayMenu();
                System.out.print("Please select an item (1-5): ");
                int choice = sc.nextInt();
                if (choice == 5) {
                    break;
                }
                order.addItem(choice);
                sc.nextLine();
                System.out.println("Would you like to order anything else? (y/n)");
                orderMore = sc.nextLine();
            }
            order.displayOrder();

        }
    }


}
