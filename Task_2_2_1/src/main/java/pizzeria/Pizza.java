package pizzeria;

/**
 * Pizza class.
 * Has methods that return parameters.
 */
public class Pizza {
    private final int timeToCooking;
    private final int range;
    private final int orderId;

    /**
     * Constructor of Pizza class - has information about order.
     *
     * @param timeToCooking What time abstract Cook needs, if he/she has speed = 1
     * @param range What time abstract Courier needs, if he/she has speed = 1
     * @param orderId id of this order.
     */
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