package restourant.hall;

import restourant.kitchen.Food;
import restourant.enums.Status;
import java.util.ArrayList;



public class Order {

    private int numTable;
    public ArrayList<Food> listFood;
    private Status status;
    private double totalCost;

    public Order(int numTable) {
        this.listFood = new ArrayList<>();
        this.numTable = numTable;
        this.status = status.adopted;
        this.totalCost = 0.0;

    }
    private void calcTotal(){
        totalCost = 0;
        for(Food food: listFood){
            totalCost += food.getCost();
        }
    }
    public void addFood(Food food){
        listFood.add(food);
        calcTotal();
    }
}
