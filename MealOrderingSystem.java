package FoodOrderingSystem;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;


class Menu {
    public void displayMenu() {
        System.out.println(" ── ── ── ── ── ── ── MENU ── ── ── ── ── ── ──");
        System.out.println("|                                               |");
        System.out.println("|    1. BURGER ₹50.00     2. PIZZA ₹80.00       |");
        System.out.println("|                                               |");
        System.out.println("|    3. SANDWICH ₹40.00   4. COKE ₹20.00        |");
        System.out.println("|                                               |");
        System.out.println("|    5. EXIT                                    |");
        System.out.println("|                                               |");
        System.out.println(" ── ── ── ── ── ── ── ── ── ── ── ── ── ── ── ──");

    }
}

class Order {
    ApplyCoupon ac = new ApplyCoupon();
    private final List<String> orders = new ArrayList<>();
    private double total = 0;
    public static int optionPay = 0;

    public void addItem(int choice, int quantity) {
        switch (choice) {
            case 1:
                total += 50 * quantity;
                System.out.println("You added " + quantity + " Burger");
                orders.add(quantity + " x Burger");
                break;
            case 2:
                total += 80 * quantity;
                System.out.println("You added " + quantity + " Pizza");
                orders.add(quantity + " x Pizza");
                break;
            case 3:
                total += 40 * quantity;
                System.out.println("You added " + quantity + " Sandwich");
                orders.add(quantity + " x Sandwich");
                break;
            case 4:
                total += 20 * quantity;
                System.out.println("You added " + quantity + " Coke");
                orders.add(quantity + " x Coke");
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
        total = ac.applyCoupon(total);
        System.out.println("Total after applying coupon ₹" + total);

    }


}

class ApplyCoupon{
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
                Order.optionPay = 2;
                break;
            case 3:
                total = total - Math.min((total * 35) / 100, 100);  //35% off up to ₹100
                Order.optionPay = 3;
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
                System.out.print("Enter expire date MM/YY: ");
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

class Feedback {
    Scanner sc = new Scanner(System.in);

    public void feedback() {
        System.out.println("Please rate our services from out of 5.");
        int response = sc.nextInt();
        System.out.println("Thank you for providing your rating.");
    }
}

public class MealOrderingSystem {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Order order = new Order();
        Payment pay = new Payment();
        Feedback feed = new Feedback();
        try (Scanner sc = new Scanner(System.in)) {
            AtomicBoolean orderMore = new AtomicBoolean(true);

            while (orderMore.get()) {
                menu.displayMenu();
                System.out.print("Please select an item (1-5): ");
                int choice = sc.nextInt();
                if (choice == 5) {
                    break;
                }
                System.out.print("Enter quantity for this item: ");
                int quantity = sc.nextInt();
                order.addItem(choice, quantity);


                sc.nextLine();
                System.out.println("Would you like to order anything else? (y/n)");
                String userResponse = sc.nextLine();
                if (userResponse.equalsIgnoreCase("n")) {
                    orderMore.set(false);
                }
            }
            order.displayOrder();
            pay.payBill(order.getTotal(), order.getOptionPay());
            feed.feedback();

        }
    }


}
