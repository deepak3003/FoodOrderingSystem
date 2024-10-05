package FoodOrderingSystem;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;


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
    private int optionPay = 0;

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

    public double getTotal() {
        return total;
    }

    public int getOptionPay() {
        return optionPay;
    }

    public void displayOrder() {
        System.out.print("You ordered a ");
        System.out.println(orders);
        System.out.println("Your total is: ₹" + total);
        total = applyCoupon(total);
        System.out.println("Total after applying coupon ₹" + total);

    }

    public double applyCoupon(double total) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose coupon");
        System.out.println("1. Welcome bonus 40% OFF.");
        System.out.println("2. Flat ₹20 OFF using UPI");
        System.out.println("3. 35% OFF up to ₹100 using credit card");


        int option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 1:
                total = total - (total * 40) / 100;

                break;

            case 2:
                total = total - 20;  //Flat ₹20 off
                optionPay = 2;
                break;
            case 3:
                total = total - Math.min((total * 35) / 100, 100);  //35% off up to ₹100
                optionPay = 3;
                break;
            default:
                System.out.println("Invalid coupon selection. No coupon applied.");
        }
        return total;
    }
}

class Payment {
    public void payBill(double total, int option) {
        Scanner sc = new Scanner(System.in);

        if (option == 0) {
            System.out.println("Please select payment method");
            System.out.println("1. Cash");
            System.out.println("2. Pay with UPI");
            System.out.println("3. Credit/Debit Card");
            option = sc.nextInt();
            sc.nextLine();
        }
        switch (option) {
            case 1:
                System.out.println("Please pay ₹" + total + " in cash.");
                System.out.println("Payment successful! Thank you for your order.");
                break;
            case 2:
                System.out.print("Enter your upi id: ");
                String upiId = sc.nextLine();
                System.out.println("Payment processing of ₹" + total + " from upi id" + " '" + upiId + "'");
                System.out.println("Payment successful! Thank you for your order.");
                break;
            case 3:
                System.out.print("Enter your card number: ");
                String cardNumber = sc.nextLine();
                System.out.print("Enter expiration date MM/YY: ");
                String expireDate = sc.nextLine();
                System.out.print("Enter CVC number: ");
                String cvcNumber = sc.nextLine();
                System.out.println("Payment processing of ₹" + total);
                System.out.println("Payment successful! Thank you for your order.");
                break;

            default:
                System.out.println("Invalid selection.");


        }

    }
}

public class MealOrderingSystem {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Order order = new Order();
        Payment pay = new Payment();
        try (Scanner sc = new Scanner(System.in)) {
            AtomicBoolean orderMore = new AtomicBoolean(true);

            while (orderMore.get()) {
                menu.displayMenu();
                System.out.print("Please select an item (1-5): ");
                int choice = sc.nextInt();
                if (choice == 5) {
                    break;
                }
                order.addItem(choice);
                sc.nextLine();
                System.out.println("Would you like to order anything else? (y/n)");
                String userResponse = sc.nextLine();
                if (userResponse.equalsIgnoreCase("n")) {
                    orderMore.set(false);
                }
            }
            order.displayOrder();
            pay.payBill(order.getTotal(), order.getOptionPay());

        }
    }


}
