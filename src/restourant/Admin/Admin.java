package restourant.Admin;

import restourant.UI.User;
import restourant.enums.CategoryFood;
import restourant.hall.Menu;
import restourant.kitchen.Food;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private String password = "0000";
    private Scanner sc = new Scanner(System.in);
    private Menu menu;
    private double salary;

    public Admin(String pass, Menu sharedMenu, double sharedSalary) {
        this.menu = sharedMenu;
        this.salary = sharedSalary;

        while (true) {
            if (pass.equals(password)) {
                System.out.println("FUNCTIONAL(go to user interface - -1):\n");
                System.out.println("1.AddFood\n2.RemoveFood\n3.EraseFoods\n4.GetSalary");

                int choseNum = sc.nextInt();

                if (choseNum == 1) {
                    handleAddFood();
                } else if (choseNum == 2) {
                    handleRemoveFood();
                } else if (choseNum == 3) {
                    handleEraseFoods();
                }else if(choseNum == 4){
                    getSalary();
                } else if (choseNum == -1) {
                    System.out.println("Returning to User Interface...");
                    return;
                } else {
                    System.out.println("Invalid input");
                }
            } else {
                System.out.println("YOU ARE NOT ADMIN");
                break;
            }
        }
    }

    private void handleAddFood() {
        while (true) {
            System.out.println("Categories:");
            System.out.println(String.format("1.%s\n2.%s\n3.%s\n4.%s",
                    CategoryFood.breakfast, CategoryFood.dinner, CategoryFood.fastFood, CategoryFood.afternoonSnack));
            System.out.print("Enter category (or -1 to exit): ");
            int numCateg = sc.nextInt();

            if (numCateg == -1) {
                return;
            }

            showCategoryMenu(numCateg);

            sc.nextLine();
            System.out.println("Create new dish (exit - -1)");
            System.out.println("Enter name:");
            String name = sc.nextLine();

            if (name.equals("-1")) {
                return;
            }

            System.out.println("Enter cost:");
            int cost = sc.nextInt();

            CategoryFood category = getCategoryFromNumber(numCateg);
            if (category != null) {
                menu.addFood(name, category, cost);
                System.out.println("Dish added successfully!");
                showCategoryMenu(numCateg);
            } else {
                System.out.println("Invalid category");
            }
        }
    }

    private void  getSalary() {
        System.out.println("Salary:" + this.salary);
    }
    private void handleRemoveFood() {
        while (true) {
            System.out.println("Categories:");
            System.out.println(String.format("1.%s\n2.%s\n3.%s\n4.%s",
                    CategoryFood.breakfast, CategoryFood.dinner, CategoryFood.fastFood, CategoryFood.afternoonSnack));
            System.out.print("Enter category (or -1 to exit): ");
            int numCateg = sc.nextInt();

            if (numCateg == -1) {
                return;
            }

            ArrayList<Food> categoryMenu = showCategoryMenu(numCateg);

            if (categoryMenu.isEmpty()) {
                System.out.println("This category is empty!");
                continue;
            }

            System.out.println("Remove dish");
            System.out.println("Enter number dish (0-" + (categoryMenu.size() - 1) + "): ");
            int num = sc.nextInt();

            CategoryFood category = getCategoryFromNumber(numCateg);
            if (category != null && num >= 0 && num < categoryMenu.size()) {
                menu.RemoveFood(num, category);
                System.out.println("Dish removed successfully!");
            } else {
                System.out.println("Invalid dish number or category");
            }
        }
    }

    private void handleEraseFoods() {
        while (true) {
            System.out.println("Categories:");
            System.out.println(String.format("1.%s\n2.%s\n3.%s\n4.%s",
                    CategoryFood.breakfast, CategoryFood.dinner, CategoryFood.fastFood, CategoryFood.afternoonSnack));
            System.out.print("Enter category to erase (-1 to exit): ");
            int numCateg = sc.nextInt();

            if (numCateg == -1) {
                System.out.println("Bye-Bye");
                return;
            }

            showCategoryMenu(numCateg);

            System.out.println("Are you sure you want to erase all dishes in this category? (yes/no): ");
            sc.nextLine();
            String confirm = sc.nextLine().trim().toLowerCase();

            if (confirm.equals("yes")) {
                CategoryFood category = getCategoryFromNumber(numCateg);
                if (category != null) {
                    menu.erase(category);
                    System.out.println("Category cleared successfully!");
                }
            } else {
                System.out.println("Operation cancelled");
            }
        }
    }

    private ArrayList<Food> showCategoryMenu(int numCateg) {
        ArrayList<Food> menuList = null;

        if (numCateg == 1) {
            System.out.println("Breakfast menu:");
            menuList = menu.getMenuBreakFast();
        } else if (numCateg == 2) {
            System.out.println("Dinner menu:");
            menuList = menu.getMenuDinner();
        } else if (numCateg == 3) {
            System.out.println("FastFood menu:");
            menuList = menu.getMenuFastFood();
        } else if (numCateg == 4) {
            System.out.println("AfternoonSnacks menu:");
            menuList = menu.getMenuAfterSnack();
        }

        return menuList != null ? menuList : new ArrayList<>();
    }

    private CategoryFood getCategoryFromNumber(int numCateg) {
        return switch (numCateg) {
            case 1 -> CategoryFood.breakfast;
            case 2 -> CategoryFood.dinner;
            case 3 -> CategoryFood.fastFood;
            case 4 -> CategoryFood.afternoonSnack;
            default -> null;
        };
    }
}