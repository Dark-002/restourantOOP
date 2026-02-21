package restourant.hall;

import restourant.enums.StatTables;

import java.util.ArrayList;

public class Tables {

    private  ArrayList<Table> tables = new ArrayList<>(10);
    {
        for(int i = 1; i <= 10; i++){
            tables.add(new Table(i, StatTables.open));
        }
    }

    public void getTableStatus(int num){

        if(num >= 1 && num <= 10){
            Table table = tables.get(num-1);

            System.out.print("table " + num + " is " + table.getStat());
        }else{
            System.out.println("Table number " + num + " is invalid (use 1-10)");
        }
    }
    public void closeTable(int num){
        if(num >= 1 && num <= 10) {
            Table table = tables.get(num-1);
            table.setStat(StatTables.close);
        }else {
            System.out.println("Cannot close table");

        }
    }
    public void openTable(int num){
        if(num >= 1 && num <= 10){
            Table table = tables.get(num-1);
            table.setStat(StatTables.open);
            System.out.println("Table " + num + " is now OPEN");
        } else {
            System.out.println("Cannot open table: invalid number " + num);
        }
    }

    public Table getTable(int num) {
        if(num >= 1 && num <= 10) {
            return tables.get(num-1);
        }
        return null;
    }
}

