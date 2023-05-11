package pizzeria;

/**
 * Realization of Courier class.
 * Has two methods:
 * work - start of workday, courier wait the orders
 * stopped - end of workday, courier is delivering the last order and finishing work
 */
public class Courier extends Employee<CourierInfo> {
    private boolean isWorking = true;
    CourierInfo info;
    Pizzeria pizzeria;

    /**
     * Constructor of Courier class.
     * @param pizzeria - pizzeria where Courier works.
     * @param info - Courier's name and speed.
     */
    public Courier(Pizzeria pizzeria, CourierInfo info) {
        super(info, pizzeria);
        this.info = info;
        this.pizzeria = pizzeria;
    }

    @Override
    public synchronized void work() throws InterruptedException {
        while (isWorking) {
            Pizza pizza = pizzeria.removePizza();
            if (pizza != null) {
                System.out.printf("ORDER %d is now being delivered by courier %s\n",
                        pizza.orderId(),
                        info.name());
                sleep(Math.round(pizza.range() * 1000 / info.speed()));
                System.out.printf("ORDER %d delivered by courier %s\n",
                        pizza.orderId(),
                        info.name());
            }
        }
    }

    @Override
    public void stopped() {
        isWorking = false;
    }
}
