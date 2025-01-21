package edu.neu.csye7374;

public class AmazonStock extends Stock {
    public AmazonStock(double price) {
        super("Amazon",price, "Online store");
    }

    @Override
    public int getMetric() {
        double mean = (this.prevPrices.stream().mapToDouble(i -> i).sum()) / prevPrices.size();
        double dev = 0.0;
        for (double num : prevPrices) {
            dev += mean*2 - num/3;
        }
        dev = dev / prevPrices.size();
        return dev > 200 ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Stock [name=" + this.getName() + ", price=" + this.getPrice() + ", description=" + this.getDescription() + ", metric= " + this.getMetric() + "]";
    }
}
