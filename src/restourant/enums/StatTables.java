package restourant.enums;

public enum StatTables {
    close("close"),
    open("open");

    final private String stat;

    StatTables(String stat) {
        this.stat = stat;
    }

    public String getStat() {
        return stat;
    }
}
