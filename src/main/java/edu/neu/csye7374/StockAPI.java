package edu.neu.csye7374;

public abstract class StockAPI implements Tradable {
    protected String ID;
    protected double price;
    protected String description;

    public StockAPI(String ID, double price, String description) {
        this.ID = ID;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%s: $%.2f - %s", ID, price, description);
    }
}
