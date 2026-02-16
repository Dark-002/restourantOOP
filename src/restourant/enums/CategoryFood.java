package restourant.enums;

public enum CategoryFood {
    breakfast("breakfast"),
    dinner("dinner"),
    afternoonSnack("afternoonSnack"),
    fastFood("fastFood"),;

    private final String categ;

    CategoryFood(String categ){
        this.categ = categ;
    }

    public String getCateg() {
        return categ;
    }
}