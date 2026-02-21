package restourant.kitchen;

import restourant.enums.CategoryFood;

public class Food {
    public String name;
    double cost;
    CategoryFood categ;
    public Food(String name, CategoryFood categ, double cost){
        this.name = name;
        this.categ = categ;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public CategoryFood getCategory() {
        return categ;
    }

    public void setCategory( CategoryFood categ) {
        this.categ = categ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return (String.format("name: %s cost: %.2f category: %s", name, cost, categ));
    }
}
