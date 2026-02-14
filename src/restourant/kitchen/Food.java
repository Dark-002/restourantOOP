package restourant.kitchen;

public class Food {
    String name;
    String category;
    double cost;

    public Food(String name, String categ, double cost){
        this.name = name;
        this.category = categ;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return (String.format("название: %s цена: %d категория: %s", name, cost, category));
    }
}
