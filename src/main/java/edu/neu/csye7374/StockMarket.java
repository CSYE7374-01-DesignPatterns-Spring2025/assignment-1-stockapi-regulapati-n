package edu.neu.csye7374;

public class StockMarket {
    public static void demo() {

        StockAPI techStock = new TechStock("AAPL", 150.0, "Apple Inc. Common Stock");
        StockAPI energyStock = new EnergyStock("XOM", 60.0, "Exxon Mobil Corporation Common Stock");

        String[] bids = {"151.5", "149.8", "152.3", "153.0", "151.2", "154.5"};

        System.out.println("Tech Stock (AAPL) Performance:");
        simulateMarketTrends(techStock, bids);

        System.out.println("\nEnergy Stock (XOM) Performance:");
        simulateMarketTrends(energyStock, bids);
    }

    private static void simulateMarketTrends(StockAPI stock, String[] bids) {
        for (String bid : bids) {
            stock.setBid(bid);
            System.out.println(stock + " Metric: " + stock.getMetric());
        }
    }
}
