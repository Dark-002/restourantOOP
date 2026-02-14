package restourant.hall;

import restourant.enums.StatTables;

import java.util.ArrayList;

public class Tables {

    private  ArrayList<Table> tables;
    {
        for(int i = 1; i < 11; i++){
            tables.add(new Table(i, StatTables.open));
        }
    }

}

