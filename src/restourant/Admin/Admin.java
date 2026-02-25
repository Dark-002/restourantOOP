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
                System.out.println("1.AddFood\n2.RemoveFood\n3.EraseFoods");

                int choseNum = sc.nextInt();
                if (choseNum == -1) {
                    System.out.println("Bye-Bye");
                    new User();
                }

                while(true) {

                    if (choseNum == 1) {// Добавление блюда в категорию
                        while (true) {
                            System.out.println("Categories:");
                            System.out.println(String.format("1.%s\n2.%s\n3.%s\n4.%s", CategoryFood.breakfast, CategoryFood.dinner, CategoryFood.fastFood, CategoryFood.afternoonSnack));
                            System.out.print("Enter category:");
                            int numCateg = sc.nextInt();
                            if(numCateg == -1) {
                                new Admin("0000");
                            }
                            while (true) {

                                if (numCateg == 1) {
                                    System.out.println("Breakfast menu:");
                                    menu.getMenuBreakFast();
                                    break;
                                } else if (numCateg == 2) {
                                    System.out.println("Dinner menu:");
                                    menu.getMenuDinner();
                                    break;
                                } else if (numCateg == 3) {
                                    System.out.println("FastFood menu:");
                                    menu.getMenuFastFood();
                                    break;
                                } else if (numCateg == 4) {
                                    System.out.println("AfternoonSnacks menu:");
                                    menu.getMenuAfterSnack();
                                    break;
                                } else {
                                    System.out.print("Please enter a valid category (1-4): ");
                                    numCateg = sc.nextInt();
                                }
                            }
                            sc.nextLine();
                            System.out.println("Create new dish(exit - -1)");
                            System.out.println("Enter name:");
                            String name = sc.nextLine();

                            System.out.println("Enter cost:");
                            int cost = sc.nextInt();

                            if (numCateg == 1) {
                                menu.addFood(name, CategoryFood.breakfast, cost);
                                menu.getMenuBreakFast();
                            } else if (numCateg == 2) {
                                menu.addFood(name, CategoryFood.dinner, cost);
                                menu.getMenuDinner();
                            } else if (numCateg == 3) {
                                menu.addFood(name, CategoryFood.fastFood, cost);
                                menu.getMenuFastFood();
                            } else if (numCateg == 4) {
                                menu.addFood(name, CategoryFood.afternoonSnack, cost);
                                menu.getMenuAfterSnack();
                            } else {
                                System.out.println("The data is not correct, try one more time");
                                break;
                            }
                        }
                    } else if (choseNum == 2) { // удаление блюд из категорий
                        while (true) {
                            System.out.println("Categories:");
                            System.out.println(String.format("1.%s\n2.%s\n3.%s\n4.%s", CategoryFood.breakfast, CategoryFood.dinner, CategoryFood.fastFood, CategoryFood.afternoonSnack));
                            System.out.print("Enter category:");
                            int numCateg = sc.nextInt();
                            ArrayList<Food> menuO;
                            if (numCateg == -1) {
                                new Admin("0000");
                            }
                            while (true) {

                                if (numCateg == 1) {
                                    System.out.println("Breakfast menu:");
                                    menu.getMenuBreakFast();
                                    break;
                                } else if (numCateg == 2) {
                                    System.out.println("Dinner menu:");
                                    menu.getMenuDinner();
                                    break;
                                } else if (numCateg == 3) {
                                    System.out.println("FastFood menu:");
                                    menu.getMenuFastFood();
                                    break;
                                } else if (numCateg == 4) {
                                    System.out.println("AfternoonSnacks menu:");
                                    menu.getMenuAfterSnack();
                                    break;
                                } else {
                                    System.out.print("Please enter a valid category (1-4): ");
                                    numCateg = sc.nextInt();
                                }
                            }

                            sc.nextLine();

                            System.out.println("Remove dish");
                            System.out.println("Enter number dish:");
                            int num = sc.nextInt();

                            if (numCateg == 1) {
                                menu.RemoveFood(num, CategoryFood.breakfast);
                            } else if (numCateg == 2) {
                                menu.RemoveFood(num, CategoryFood.dinner);
                            } else if (numCateg == 3) {
                                menu.RemoveFood(num, CategoryFood.fastFood);
                            } else if (numCateg == 4) {
                                menu.RemoveFood(num, CategoryFood.afternoonSnack);
                            } else {
                                System.out.println("DONT CORRECT");
                            }
                        }
                    } else if (choseNum == 3) { // очищение категории
                        while (true) {
                            System.out.println("Categories:");
                            System.out.println(String.format("1.%s\n2.%s\n3.%s\n4.%s", CategoryFood.breakfast, CategoryFood.dinner, CategoryFood.fastFood, CategoryFood.afternoonSnack));
                            System.out.print("Erase dishes(-1 - exit)");
                            int numCateg = sc.nextInt();

                            if (numCateg == -1) {
                                new Admin("0000");
                            }
                            while (true) {
                                if (numCateg == 1) {
                                    System.out.println("Breakfast menu:");
                                    menu.getMenuBreakFast();
                                    break;
                                } else if (numCateg == 2) {
                                    System.out.println("Dinner menu:");
                                    menu.getMenuDinner();
                                    break;
                                } else if (numCateg == 3) {
                                    System.out.println("FastFood menu:");
                                    menu.getMenuFastFood();
                                    break;
                                } else if (numCateg == 4) {
                                    System.out.println("AfternoonSnacks menu:");
                                    menu.getMenuAfterSnack();
                                    break;
                                } else {
                                    System.out.print("Please enter a valid category (1-4): ");
                                    numCateg = sc.nextInt();
                                }
                            }

                            sc.nextLine();
                            System.out.println("Erase...");

                            if (numCateg == 1) {
                                menu.erase(CategoryFood.breakfast);
                            } else if (numCateg == 2) {
                                menu.erase(CategoryFood.dinner);
                            } else if (numCateg == 3) {
                                menu.erase(CategoryFood.fastFood);
                            } else if (numCateg == 4) {
                                menu.erase(CategoryFood.afternoonSnack);
                            } else {
                                System.out.println("DONT CORRECT");
                            }
                            System.out.println("COMPLETE!");
                        }
                    }else {
                        System.out.println("Invalid input");
                        return;
                    }
                }

            } else {
                System.out.println("YOU ARE NOT ADMIN");
                break;
            }
        }
    }
}
