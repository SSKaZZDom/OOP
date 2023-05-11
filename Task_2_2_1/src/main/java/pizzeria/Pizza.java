package pizzeria;

public class Pizza {
    private final int timeToCooking;
    private final int range;
    private final int orderId;

    public Pizza(int timeToCooking, int range, int orderId) {
        this.timeToCooking = timeToCooking;
        this.range = range;
        this.orderId = orderId;
    }

    public int timeToCooking() {
        return timeToCooking;
    }

    public int range() {
        return range;
    }

    public int orderId() {
        return orderId;
    }
}