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

    public User() {
        Scanner sc = new Scanner(System.in);
        Tables tables = new Tables();
        Menu menu = new Menu();
        System.out.println("-------RESTOURANT-------");

        while(true) {
            System.out.println("Tables:");
            for(int i = 1; i < 11 ; i++){
                System.out.print("----");
                tables.getTableStatus(i);
                System.out.println("----");
            }

            System.out.print("Your personal waiter greets you.\n" +
                    "Select a table (from 1 to 10):");
            int num = sc.nextInt();

            if (num == 666){
                sc.nextLine();
                System.out.println("Enter password:");
                String pass = sc.nextLine();
                new Admin(pass);
                return;
            }

            Table table = tables.getTable(num);
            if(table == null) {
                System.out.println("Invalid table number! Please choose 1-10.");
                continue;
            }

            if(table.getStat() == StatTables.open) {

                for (int i = 1; i < 11; i++) {
                    if (num == i) {
                        tables.closeTable(i);
                        table.setStat(StatTables.close);
                        System.out.println("Have you taken a table №" + num);
                        break;
                    }
                }
            }else {
                System.out.println("TABLE IS CLOSE, CHOOSE ANOTHER");
                continue;

            }
            System.out.println("Category Dishes:");
            System.out.println(String.format("1.%s\n2.%s\n3.%s\n4.%s", CategoryFood.breakfast, CategoryFood.dinner, CategoryFood.fastFood, CategoryFood.afternoonSnack));

            System.out.print("Enter category:");
            int numCateg = sc.nextInt();
            ArrayList<Food> menuO;


            while(true) {
                if (numCateg == 1) {
                    System.out.println("Breakfast menu:");
                    menuO = menu.getMenuBreakFast();
                    break;
                } else if (numCateg == 2) {
                    System.out.println("Dinner menu:");
                    menuO = menu.getMenuDinner();
                    break;
                } else if (numCateg == 3) {
                    System.out.println("FastFood menu:");
                    menuO = menu.getMenuFastFood();
                    break;
                } else if (numCateg == 4) {
                    System.out.println("AfternoonSnacks menu:");
                    menuO = menu.getMenuAfterSnack();
                    break;
                } else {
                    System.out.print("Please enter a valid category (1-4): ");
                    numCateg = sc.nextInt();
                }
            }
            System.out.println("Enter dish:");
            int dishIndex = sc.nextInt();
            if ( dishIndex < 0 || dishIndex > menuO.size()){
                System.out.print("Selected index dish not correct, please try again:");
                dishIndex = sc.nextInt();
            }

            Food selectedFood = menuO.get(dishIndex);
            Order newOrder = new Order(num);
            newOrder.addFood(selectedFood);

            sc.nextLine();
            while (true){
                System.out.println("Would you like to add something?\nyes/no");
                String add = sc.nextLine().trim().toLowerCase();
                if(add.equals("yes")){
                    System.out.println("\nYour current order");
                    System.out.println(newOrder.getListFood());

                    newOrder.calcTotal();
                    System.out.println("Total cost:" + newOrder.getTotalCost());
                    while(true) {

                        System.out.println("Category Dishes:");
                        System.out.println(String.format("1.%s\n2.%s\n3.%s\n4.%s", CategoryFood.breakfast, CategoryFood.dinner, CategoryFood.fastFood, CategoryFood.afternoonSnack));

                        System.out.println("Enter category:");
                        numCateg = sc.nextInt();

                        if (numCateg == 1) {
                            System.out.println("Breakfast menu:");
                            menuO = menu.getMenuBreakFast();
                            break;
                        } else if (numCateg == 2) {
                            System.out.println("Dinner menu:");
                            menuO = menu.getMenuDinner();
                            break;
                        } else if (numCateg == 3) {
                            System.out.println("FastFood menu:");
                            menuO = menu.getMenuFastFood();
                            break;
                        } else if (numCateg == 4) {
                            System.out.println("AfternoonSnacks menu:");
                            menuO = menu.getMenuAfterSnack();
                            break;
                        } else {
                            System.out.print("Please enter a valid category (1-4): ");
                            numCateg = sc.nextInt();
                        }
                    }

                    System.out.println();

                    System.out.println("\nAvailable dishes (0-" + (menuO.size() - 1) + "):");
                    for (int i = 0; i < menuO.size(); i++) {
                        Food food = menuO.get(i);
                        System.out.println((i) + ". " + food.getName() + " - " + food.getCost());
                    }

                    System.out.print("Enter dish: ");
                    dishIndex = sc.nextInt();



                    while (dishIndex < 0 || dishIndex > (menuO.size() - 1)) {
                        System.out.print("Invalid dish number (0-" + menuO.size() + "), try again: ");
                        dishIndex = sc.nextInt();
                    }

                    Food additionalFood = menuO.get(dishIndex);
                    newOrder.addFood(additionalFood);
                    System.out.println("Added: " + additionalFood.getName());

                    sc.nextLine();

                }else {
                    break;
                }

            }


        }

    }
}
