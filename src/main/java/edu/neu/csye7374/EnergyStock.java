package edu.neu.csye7374;

public class EnergyStock extends StockAPI {
    private double movingAverage;

    public EnergyStock(String ID, double price, String description) {
        super(ID, price, description);
        this.movingAverage = price;
    }

    @Override
    public void setBid(String bid) {
        price = Double.parseDouble(bid);
        movingAverage = (movingAverage * 2 + price) / 3; // Simple moving average
    }

    @Override
    public int getMetric() {
        // Calculate metric based on difference from moving average
        double difference = price - movingAverage;
        return (int) (difference * 10);
    }
}
