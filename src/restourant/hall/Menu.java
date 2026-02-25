package restourant.hall;
import restourant.enums.CategoryFood;
import restourant.enums.StatTables;
import restourant.kitchen.Food;
import java.util.ArrayList;


public class Menu {
    private ArrayList<Food> menuBreakfast = new ArrayList<>();
    private ArrayList<Food> menuDinner = new ArrayList<>();
    private ArrayList<Food> menuFastFood = new ArrayList<>();
    private ArrayList<Food> menuAfternoonSnack = new ArrayList<>();

    public Menu(){

        menuBreakfast.add(new Food("eggs(my)", CategoryFood.breakfast, 1000000));
        menuBreakfast.add(new Food("oatmeal", CategoryFood.breakfast, 80));
        menuBreakfast.add(new Food("pancakes", CategoryFood.breakfast, 150));

        menuDinner.add(new Food("lasagna", CategoryFood.dinner, 120));
        menuDinner.add(new Food("steak", CategoryFood.dinner, 350));
        menuDinner.add(new Food("soup", CategoryFood.dinner, 90));

        menuFastFood.add(new Food("pizza jalapeno", CategoryFood.fastFood, 100));
        menuFastFood.add(new Food("burger", CategoryFood.fastFood, 150));
        menuFastFood.add(new Food("fries", CategoryFood.fastFood, 60));

        menuAfternoonSnack.add(new Food("sushi", CategoryFood.afternoonSnack, 999));
        menuAfternoonSnack.add(new Food("tea with cookies", CategoryFood.afternoonSnack, 70));
        menuAfternoonSnack.add(new Food("fruit salad", CategoryFood.afternoonSnack, 110));
    }

    public ArrayList<Food> getMenuBreakFast() {
        if (!menuBreakfast.isEmpty()) {
            for (int i = 0; i < menuBreakfast.size(); i++) {
                System.out.println(i + ". " + menuBreakfast.get(i));
            }
        }else{
            System.out.println("------Dishes not find!------");
        }
        return menuBreakfast;

    }
    public ArrayList<Food> getMenuDinner() {
        if (!menuDinner.isEmpty()) {
            for (int i = 0; i < menuDinner.size(); i++) {
                System.out.println(i + ". " + menuDinner.get(i));
            }
        }else{
            System.out.println("------Dishes not find!------");
        }
        return menuDinner;

    }
    public ArrayList<Food> getMenuAfterSnack() {
        if (!menuAfternoonSnack.isEmpty()) {
            for (int i = 0; i < menuAfternoonSnack.size(); i++) {
                System.out.println(i + ". " + menuAfternoonSnack.get(i));
            }
        }else{
            System.out.println("------Dishes not find!------");
        }
        return menuAfternoonSnack;

    }
    public ArrayList<Food> getMenuFastFood() {
        if (!menuFastFood.isEmpty()) {
            for (int i = 0; i < menuFastFood.size(); i++) {
                System.out.println(i + ". " + menuFastFood.get(i));
            }
        }else{
            System.out.println("------Dishes not find!------");
        }
        return menuFastFood;

    }
    public void addFood(String name, CategoryFood cat, double cost ){
        if (cat == CategoryFood.afternoonSnack){
            menuAfternoonSnack.add(new Food(name, cat, cost));
        }else if (cat == CategoryFood.dinner){
            menuDinner.add(new Food(name, cat, cost));
        }else if (cat == CategoryFood.breakfast){
            menuBreakfast.add(new Food(name, cat, cost));
        }else if (cat == CategoryFood.fastFood){
            menuFastFood.add(new Food(name, cat, cost));
        }
    }
    public void RemoveFood(int num, CategoryFood cat  ){
        if (cat == CategoryFood.afternoonSnack){
            menuAfternoonSnack.remove(menuAfternoonSnack.get(1));
        }else if (cat == CategoryFood.dinner){
            menuDinner.remove(menuDinner.get(1));
        }else if (cat == CategoryFood.breakfast){
            menuBreakfast.remove(menuBreakfast.get(1));
        }else if (cat == CategoryFood.fastFood){
            menuFastFood.remove(menuFastFood.get(1));
        }
    }
    public  void erase(CategoryFood cat){
        if (cat == CategoryFood.afternoonSnack){
            menuAfternoonSnack.clear();
        }else if (cat == CategoryFood.dinner){
            menuDinner.clear();
        }else if (cat == CategoryFood.breakfast){
            menuBreakfast.clear();
        }else if (cat == CategoryFood.fastFood){
            menuFastFood.clear();
        }
    }


}