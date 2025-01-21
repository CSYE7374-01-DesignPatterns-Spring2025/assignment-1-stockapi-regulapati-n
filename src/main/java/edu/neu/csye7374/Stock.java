package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class Stock extends Publisher<Stock, Double> implements Tradeable{
    String name;
    double price;

    String description;

    private int metric;

    protected List<Double> prevPrices = new ArrayList<>();

    public Stock(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    private void init(double price) {
        prevPrices.add(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public void setBid(double bid) {
        prevPrices.add(bid);
        double newPrice = (prevPrices.stream().mapToDouble(i -> i.doubleValue()).sum())/prevPrices.size();
        publishChange(this, newPrice);
    }

    @Override
    public int getMetric() {
        double mean = (prevPrices.stream().mapToDouble(i -> i.doubleValue()).sum()) / prevPrices.size();
        double dev = 0.0;
        for (double num : prevPrices) {
            dev += mean - num;
        }
        dev = dev / prevPrices.size();
        this.metric = dev > 33.5 ? 1 : -1;
        return this.metric;
    }

    @Override
    public String toString() {
        return "Stock [name=" + name + ", price=" + price + ", description=" + description + ", metric= " + metric + "]";
    }

    @Override
    public void publishChange(Stock obj, Double value) {
        this.observerSet.forEach(observer -> observer.notifyChange(obj, value));
    }
}
