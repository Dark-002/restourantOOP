package restourant.hall;
import restourant.enums.StatTables;
public class Table {
    private int num;
    private Order order;
    private StatTables stat;


//    public  Table(Order ord, int num, StatTables stat){
//        this.order = ord;
//        this.stat = stat;
//        this.num = num;
//    }

    public Table(int num, StatTables stat){
        this.num = num;
        this.stat = stat;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public StatTables getStat() {
        return stat;
    }

    public void setStat(StatTables stat) {
        this.stat = stat;
    }
}
