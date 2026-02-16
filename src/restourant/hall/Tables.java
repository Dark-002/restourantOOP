package restourant.hall;

import restourant.enums.StatTables;

import java.util.ArrayList;

public class Tables {

    private  ArrayList<Table> tables = new ArrayList<>(10);
    public Tables(){
        for(int i = 1; i <= 10; i++){
            tables.add(new Table(i, StatTables.open));
        }
    }
    public void getTableStatus(int num){
        if(num >= 0 && num <= 10){
            Table table = tables.get(num-1);
            System.out.print("table " + num + " is " + table.getStat());
        }else{
            System.out.println("Table is error");
        }
    }
    public void closeTable(int num){
        tables.set(num-1, new Table(num, StatTables.close));
    }
}

