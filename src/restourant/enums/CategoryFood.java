package restourant.enums;

enum Category {
    breakfast("breakfast"),
    dinner("dinner"),
    
    first("first"),
    second("second"),
    fastFood("fastFood"),
    hot("hot");

    private final String categ;

    Category(String categ){
        this.categ = categ;
    }

    public String getCateg() {
        return categ;
    }
}