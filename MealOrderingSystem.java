package FoodOrderingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Menu {
    public void displayMenu() {
        System.out.println(" ── ── ── ── ── ── ── MENU ── ── ── ── ── ── ──");
        System.out.println("|                                               |");
        System.out.println("|    1. BURGER            2. PIZZA              |");
        System.out.println("|                                               |");
        System.out.println("|    3. SANDWICH          4. COKE               |");
        System.out.println("|                                               |");
        System.out.println("|    5. EXIT                                    |");
        System.out.println("|                                               |");
        System.out.println(" ── ── ── ── ── ── ── ── ── ── ── ── ── ── ── ──");

    }

    public void displayBurger() {
        System.out.println("Available Burgers:");
        System.out.println("1. Classic Burger - ₹150");
        System.out.println("2. Chicken Burger - ₹120");
        System.out.println("3. Veggie Burger - ₹100");
        System.out.println("4. Cheese Burger - ₹130");
    }

    public void displayPizza() {
        System.out.println("Available Pizzas:");
        System.out.println("1. Margherita - ₹200");
        System.out.println("2. Pepperoni - ₹250");
        System.out.println("3. BBQ Chicken - ₹280");
        System.out.println("4. Veggie Supreme - ₹220");
        System.out.println("5. Hawaiian - ₹240");
    }

    public void displaySandwich() {
        System.out.println("Available Sandwiches:");
        System.out.println("1. Chicken Sandwich - ₹80");
        System.out.println("2. Veggie Sandwich - ₹70");
        System.out.println("3. Grilled Cheese Sandwich - ₹90");
        System.out.println("4. Turkey Sandwich - ₹110");
        System.out.println("5. BLT Sandwich - ₹100");
    }

    public void displayCoke() {
        System.out.println("Available Coke Options:");
        System.out.println("1. Coca-Cola Classic - ₹40");
        System.out.println("2. Diet Coke - ₹45");
        System.out.println("3. Coca-Cola Zero Sugar - ₹50");
        System.out.println("4. Cherry Coke - ₹55");
        System.out.println("5. Vanilla Coke - ₹60");
    }


}

class Order {
    ApplyCoupon ac = new ApplyCoupon();
    private final List<String> orders = new ArrayList<>();
    private double total = 0;
    public static int optionPay = 0;

    public void addItem(int choice, int itemChoice, int quantity) {
        switch (choice) {
            case 1: // Burger
                switch (itemChoice) {
                    case 1:
                        total += 150 * quantity;
                        System.out.println("You added " + quantity + " Classic Burger(s)");
                        orders.add(quantity + " x Classic Burger");
                        break;
                    case 2:
                        total += 120 * quantity;
                        System.out.println("You added " + quantity + " Chicken Burger(s)");
                        orders.add(quantity + " x Chicken Burger");
                        break;
                    case 3:
                        total += 100 * quantity;
                        System.out.println("You added " + quantity + " Veggie Burger(s)");
                        orders.add(quantity + " x Veggie Burger");
                        break;
                    case 4:
                        total += 130 * quantity;
                        System.out.println("You added " + quantity + " Cheese Burger(s)");
                        orders.add(quantity + " x Cheese Burger");
                        break;
                    default:
                        System.out.println("Invalid burger selection.");
                }
                break;
            case 2: // Pizza
                switch (itemChoice) {
                    case 1:
                        total += 200 * quantity;
                        System.out.println("You added " + quantity + " Margherita Pizza(s)");
                        orders.add(quantity + " x Margherita Pizza");
                        break;
                    case 2:
                        total += 250 * quantity;
                        System.out.println("You added " + quantity + " Pepperoni Pizza(s)");
                        orders.add(quantity + " x Pepperoni Pizza");
                        break;
                    case 3:
                        total += 280 * quantity;
                        System.out.println("You added " + quantity + " BBQ Chicken Pizza(s)");
                        orders.add(quantity + " x BBQ Chicken Pizza");
                        break;
                    case 4:
                        total += 220 * quantity;
                        System.out.println("You added " + quantity + " Veggie Supreme Pizza(s)");
                        orders.add(quantity + " x Veggie Supreme Pizza");
                        break;
                    case 5:
                        total += 240 * quantity;
                        System.out.println("You added " + quantity + " Hawaiian Pizza(s)");
                        orders.add(quantity + " x Hawaiian Pizza");
                        break;
                    default:
                        System.out.println("Invalid pizza selection.");
                }
                break;
            case 3: // Sandwich
                switch (itemChoice) {
                    case 1:
                        total += 80 * quantity;
                        System.out.println("You added " + quantity + " Chicken Sandwich(es)");
                        orders.add(quantity + " x Chicken Sandwich");
                        break;
                    case 2:
                        total += 70 * quantity;
                        System.out.println("You added " + quantity + " Veggie Sandwich(es)");
                        orders.add(quantity + " x Veggie Sandwich");
                        break;
                    case 3:
                        total += 90 * quantity;
                        System.out.println("You added " + quantity + " Grilled Cheese Sandwich(es)");
                        orders.add(quantity + " x Grilled Cheese Sandwich");
                        break;
                    case 4:
                        total += 110 * quantity;
                        System.out.println("You added " + quantity + " Turkey Sandwich(es)");
                        orders.add(quantity + " x Turkey Sandwich");
                        break;
                    case 5:
                        total += 100 * quantity;
                        System.out.println("You added " + quantity + " BLT Sandwich(es)");
                        orders.add(quantity + " x BLT Sandwich");
                        break;
                    default:
                        System.out.println("Invalid sandwich selection.");
                }
                break;
            case 4: // Coke
                switch (itemChoice) {
                    case 1:
                        total += 40 * quantity;
                        System.out.println("You added " + quantity + " Coca-Cola Classic(s)");
                        orders.add(quantity + " x Coca-Cola Classic");
                        break;
                    case 2:
                        total += 45 * quantity;
                        System.out.println("You added " + quantity + " Diet Coke(s)");
                        orders.add(quantity + " x Diet Coke");
                        break;
                    case 3:
                        total += 50 * quantity;
                        System.out.println("You added " + quantity + " Coca-Cola Zero Sugar(s)");
                        orders.add(quantity + " x Coca-Cola Zero Sugar");
                        break;
                    case 4:
                        total += 55 * quantity;
                        System.out.println("You added " + quantity + " Cherry Coke(s)");
                        orders.add(quantity + " x Cherry Coke");
                        break;
                    case 5:
                        total += 60 * quantity;
                        System.out.println("You added " + quantity + " Vanilla Coke(s)");
                        orders.add(quantity + " x Vanilla Coke");
                        break;
                    default:
                        System.out.println("Invalid coke selection.");
                }
                break;
            default:
                System.out.println("Invalid category selection.");
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

class ApplyCoupon {
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
            boolean orderMore = true;

            while (orderMore) {
                menu.displayMenu();
                System.out.print("Please select an item (1-5): ");
                int typechoice = sc.nextInt();
                if (typechoice == 5) {
                    break;
                }

                switch (typechoice) {
                    case 1:
                        menu.displayBurger();
                        break;
                    case 2:
                        menu.displayPizza();
                        break;
                    case 3:
                        menu.displayCoke();
                        break;
                    case 4:
                        menu.displaySandwich();
                }
                System.out.print("Choose an item: ");
                int itemChoice = sc.nextInt();
                System.out.print("Enter quantity for this item: ");
                int quantity = sc.nextInt();
                order.addItem(typechoice, itemChoice, quantity);


                sc.nextLine();
                System.out.println("Would you like to order anything else? (y/n)");
                String userResponse = sc.nextLine();
                if (userResponse.equalsIgnoreCase("n")) {
                    orderMore = false;
                }
            }
            order.displayOrder();
            pay.payBill(order.getTotal(), order.getOptionPay());
            feed.feedback();

        }
    }


}
