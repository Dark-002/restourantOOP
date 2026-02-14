package restourant.hall;
import restourant.kitchen.Food;
import java.util.ArrayList;


public class Menu {
    private ArrayList<Food> menu = new ArrayList<>();

    public Menu() {
        menu.add(new Food("Картошка", "Овощи", 11));

    }

    @Override
    public String toString() {
        return (menu.toString());
    }
}