package restourant.Admin;

import restourant.UI.User;
import restourant.enums.CategoryFood;
import restourant.hall.Menu;
import restourant.kitchen.Food;

import javax.sound.sampled.EnumControl;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private String password = "0000";
    Scanner sc = new Scanner(System.in);

    Menu menu = new Menu();
    public Admin(String pass){

        while(true) {
            if (pass.equals(password)) {
                System.out.println("FUNCTIONAL(go to user interface - -1):\n");
                System.out.println("1.AddFood");
                int choseNum = sc.nextInt();
                if(choseNum == -1){
                    System.out.println("Bye-Bye");
                    new User();
                }


                if (choseNum == 1) {
                    System.out.println("Categories:");
                    System.out.println(String.format("1.%s\n2.%s\n3.%s\n4.%s", CategoryFood.breakfast, CategoryFood.dinner, CategoryFood.fastFood, CategoryFood.afternoonSnack));
                    System.out.print("Enter category:");
                    int numCateg = sc.nextInt();
                    ArrayList<Food> menuO;
                    while (true) {
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
                    sc.nextLine();
                    System.out.println("Create new dish");
                    System.out.println("Enter name:");
                    String name = sc.nextLine();
                    System.out.println("Enter cost:");
                    int cost = sc.nextInt();
                    if (numCateg == 1) {
                        menu.addFood(name, CategoryFood.breakfast, cost);
                        menuO = menu.getMenuBreakFast();
                    } else if (numCateg == 2) {
                        menu.addFood(name, CategoryFood.dinner, cost);
                        menuO = menu.getMenuDinner();
                    } else if (numCateg == 3) {
                        menu.addFood(name, CategoryFood.fastFood, cost);
                        menuO = menu.getMenuFastFood();
                    } else if (numCateg == 4) {
                        menu.addFood(name, CategoryFood.afternoonSnack, cost);
                        menuO = menu.getMenuAfterSnack();
                    } else {
                        System.out.println("The data is not correct, try one more time");
                        break;
                    }
                }

            } else {
                System.out.println("YOU ARE NOT ADMIN");
                break;
            }
        }
    }
}
