package restourant.UI;

import restourant.Admin.Admin;
import restourant.enums.CategoryFood;
import restourant.enums.StatTables;
import restourant.hall.Menu;
import restourant.hall.Order;
import restourant.hall.Table;
import restourant.hall.Tables;
import restourant.kitchen.Food;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private Menu menu;
    private double totalCost;
    public User(Menu sharedMenu) {
        this.menu = sharedMenu;
        Scanner sc = new Scanner(System.in);
        Tables tables = new Tables();

        System.out.println("-------RESTOURANT-------");

        while (true) {
            System.out.println("Tables:");
            for (int i = 1; i < 11; i++) {
                System.out.print("----");
                tables.getTableStatus(i);
                System.out.println("----");
            }

            System.out.print("Your personal waiter greets you.\n" +
                    "Select a table (from 1 to 10 and -1 - exit):");
            int num = sc.nextInt();
            if(num == -1){
                System.out.println("Bye-bye");
                break;
            }
            if (num == 666) {
                sc.nextLine();
                System.out.println("Enter password:");
                String pass = sc.nextLine();
                new Admin(pass, this.menu, this.totalCost);
                continue;
            }

            Table table = tables.getTable(num);
            if (table == null) {
                System.out.println("Invalid table number! Please choose 1-10.");
                continue;
            }

            if (table.getStat() == StatTables.open) {
                for (int i = 1; i < 11; i++) {
                    if (num == i) {
                        tables.closeTable(i);
                        table.setStat(StatTables.close);
                        System.out.println("Have you taken a table №" + num);
                        break;
                    }
                }
            } else {
                System.out.println("TABLE IS CLOSE, CHOOSE ANOTHER");
                continue;
            }
            processOrder(num, sc);
        }
    }

    private void processOrder(int tableNumber, Scanner sc) {
        Order newOrder = new Order(tableNumber);

        while (true) {
            System.out.println("Category Dishes:");
            System.out.println(String.format("1.%s\n2.%s\n3.%s\n4.%s",
                    CategoryFood.breakfast, CategoryFood.dinner, CategoryFood.fastFood, CategoryFood.afternoonSnack));

            System.out.print("Enter category: ");
            int numCateg = sc.nextInt();

            ArrayList<Food> menuList = getCategoryMenu(numCateg);
            if (menuList == null || menuList.isEmpty()) {
                System.out.println("This category is empty or invalid!");
                continue;
            }

            System.out.println("\nAvailable dishes (0-" + (menuList.size() - 1) + "):");
            for (int i = 0; i < menuList.size(); i++) {
                Food food = menuList.get(i);
                System.out.println(i + ". " + food.getName() + " - " + food.getCost());
            }

            System.out.print("Enter dish number: ");
            int dishIndex = sc.nextInt();

            while (dishIndex < 0 || dishIndex >= menuList.size()) {
                System.out.print("Invalid dish number (0-" + (menuList.size() - 1) + "), try again: ");
                dishIndex = sc.nextInt();
            }

            Food selectedFood = menuList.get(dishIndex);
            totalCost += selectedFood.getCost();
            newOrder.addFood(selectedFood);
            System.out.println("Added: " + selectedFood.getName());

            sc.nextLine();
            System.out.println("Would you like to add something? (yes/no): ");
            String add = sc.nextLine().trim().toLowerCase();

            if (!add.equals("yes")) {
                break;
            }

            System.out.println("\nYour current order:");
            System.out.println(newOrder.getListFood());
            newOrder.calcTotal();
            System.out.println("Total cost: " + newOrder.getTotalCost());
        }

        System.out.println("\nFinal order for table " + tableNumber + ":");
        System.out.println(newOrder.getListFood());
        newOrder.calcTotal();
        System.out.println("Total to pay: " + newOrder.getTotalCost());
        System.out.println("Thank you for your order!\n");
    }

    private ArrayList<Food> getCategoryMenu(int numCateg) {
        switch (numCateg) {
            case 1:
                System.out.println("Breakfast menu:");
                return menu.getMenuBreakFastCopy();
            case 2:
                System.out.println("Dinner menu:");
                return menu.getMenuDinnerCopy();
            case 3:
                System.out.println("FastFood menu:");
                return menu.getMenuFastFoodCopy();
            case 4:
                System.out.println("AfternoonSnacks menu:");
                return menu.getMenuAfterSnackCopy();
            default:
                return null;
        }
    }
}