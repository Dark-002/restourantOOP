    package restourant;

    import restourant.hall.Order;
    import restourant.hall.Tables;
    import restourant.kitchen.Food;

    import java.util.ArrayList;

    public class Restourant {
        private ArrayList<Food> menu;
        private ArrayList<Order> ord;
        private Tables[] tables;
        public Restourant(){
            this.ord = new ArrayList<>();
            this.menu = new ArrayList<>();
            this.tables = new Tables[10];

        }

    }
