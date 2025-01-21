package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Observer<Stock, Double> {
    private static StockMarket instance;

    public static StockMarket getInstance() {
        if(instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    private List<Stock> stocks = new ArrayList<>();

    public Stock getStockItem(String name, double price, String description) {
        return new Stock(name, price, description);
    }

    public void add(Stock stock) {
        stocks.add(stock);
    }

    public void remove(Stock s) {

        boolean removed = this.stocks.remove(s);

        if (!removed) {
            System.out.println("stock not found");
        }
    }

    public void displayStocks() {
        System.out.println("Displaying stocks ");
        for (Stock s : this.stocks) {
            System.out.println(s.toString());
        }
    }
    @Override
    public void notifyChange(Stock s, Double price) {
        if (this.stocks.contains(s)) {
            s.setPrice(price);
            return;
        }

        System.out.println("Stock not found");
    }

    public static void demo() {

        System.out.println("Starting the demo");

        Stock mmt_stock = new WMTStock(45);
        Stock amazon_s2 = new AmazonStock(20);

        mmt_stock.subscribe(StockMarket.getInstance());
        amazon_s2.subscribe(StockMarket.getInstance());

        StockMarket.getInstance().add(amazon_s2);
        StockMarket.getInstance().add(mmt_stock);

        amazon_s2.setBid(10);
        amazon_s2.getMetric();


        mmt_stock.setBid(100);
        mmt_stock.getMetric();

        StockMarket.getInstance().displayStocks();
        System.out.println();

        amazon_s2.setBid(40);
        amazon_s2.getMetric();

        mmt_stock.setBid(120);
        mmt_stock.getMetric();
        StockMarket.getInstance().displayStocks();
        System.out.println();

        amazon_s2.setBid(510);
        amazon_s2.getMetric();

        mmt_stock.setBid(120);
        mmt_stock.getMetric();
        StockMarket.getInstance().displayStocks();
        System.out.println();

        amazon_s2.setBid(60);
        amazon_s2.getMetric();

        mmt_stock.setBid(20);
        mmt_stock.getMetric();

        StockMarket.getInstance().displayStocks();
        System.out.println();

        amazon_s2.setBid(70);
        amazon_s2.getMetric();

        mmt_stock.setBid(16);
        mmt_stock.getMetric();

        StockMarket.getInstance().displayStocks();
        System.out.println();

        amazon_s2.setBid(80);
        amazon_s2.getMetric();

        mmt_stock.setBid(10);
        mmt_stock.getMetric();

        StockMarket.getInstance().displayStocks();
        System.out.println();

        amazon_s2.setBid(122);
        amazon_s2.getMetric();

        mmt_stock.setBid(111);
        mmt_stock.getMetric();

        StockMarket.getInstance().displayStocks();
        System.out.println();

        StockMarket.getInstance().remove(amazon_s2);
        StockMarket.getInstance().displayStocks();

    }
}
