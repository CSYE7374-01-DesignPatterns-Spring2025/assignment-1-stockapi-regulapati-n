package edu.neu.csye7374;

public class WMTStock extends Stock {
    public WMTStock(double price) {
        super("WLMT", price, "A wholesale and retail company");
    }

    @Override
    public int getMetric() {
        double mean = (this.prevPrices.stream().mapToDouble(i -> i.doubleValue()).sum()) / this.prevPrices.size();
        double dev = 0.0;
        for (double num : this.prevPrices) {
            dev += mean - num/3;
        }
        dev = dev / this.prevPrices.size();
        return dev > 200 ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Stock [name=" + this.getName() + ", price=" + this.getPrice() + ", description=" + this.getDescription() + ", metric= " + this.getMetric() + "]";
    }
}
