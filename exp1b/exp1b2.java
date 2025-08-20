import java.util.*;

interface Observer {
    void update(double price);
}

class StockPriceTracker {
    private List<Observer> observers = new ArrayList<>();
    private double price;

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer o : observers) {
            o.update(price);
        }
    }
}

class PriceAlert implements Observer {
    public void update(double price) {
        if (price > 100) {
            System.out.println("PriceAlert: Price is high! $" + price);
        }
    }
}

class DisplayBoard implements Observer {
    public void update(double price) {
        System.out.println("DisplayBoard: Current price is $" + price);
    }
}

public class exp1b2 {
    public static void main(String[] args) {
        StockPriceTracker tracker = new StockPriceTracker();
        tracker.addObserver(new PriceAlert());
        tracker.addObserver(new DisplayBoard());

        tracker.setPrice(95.0);
        tracker.setPrice(105.0);
    }
}
