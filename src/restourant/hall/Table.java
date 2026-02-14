package restourant.hall;
import restourant.enums.StatTables;
public class Table {
    private int num;
    private Order order;
    private StatTables stat;

    public  Table(Order ord, int num, StatTables stat){
        this.order = ord;
        this.stat = stat;
        this.num = num;
    }
    @Override
    public String toString() {
        if (stat == StatTables.open) {
            return "Столик №" + num + ": не занят";
        }
        return "Столик №" + num + ": занят";
    }
    public Table(int num, StatTables stat){
        this.num = num;
        this.stat = stat;
    }

}
