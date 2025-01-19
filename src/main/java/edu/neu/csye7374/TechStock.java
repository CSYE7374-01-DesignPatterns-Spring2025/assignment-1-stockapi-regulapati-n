package edu.neu.csye7374;

public class TechStock extends StockAPI{
    private double previousPrice;

    public TechStock(String ID, double price, String description) {
        super(ID, price, description);
        this.previousPrice = price;
    }

    @Override
    public void setBid(String bid) {
        previousPrice = price;
        price = Double.parseDouble(bid);
    }

    @Override
    public int getMetric() {
        // Calculate metric based on price change percentage
        double changePercentage = (price - previousPrice) / previousPrice * 100;
        return (int) (changePercentage * 10);
    }
}
