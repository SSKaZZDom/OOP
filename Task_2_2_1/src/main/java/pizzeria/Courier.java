package pizzeria;

/**
 * Realization of Courier class.
 * Has two methods:
 * work - start of workday, courier wait the orders
 * stopped - end of workday, courier is delivering the last order and finishing work
 */
public class Courier extends Employee<CourierInfo> {
    private volatile boolean isWorking = true;
    CourierInfo info;
    Pizzeria pizzeria;

    /**
     * Constructor of Courier class.
     *
     * @param pizzeria - pizzeria where Courier works.
     * @param info - Courier's name and speed.
     */
    public Courier(Pizzeria pizzeria, CourierInfo info) {
        super(info, pizzeria);
        this.info = info;
        this.pizzeria = pizzeria;
    }

    @Override
    public void work(){
        try {
            while (isWorking) {
                Pizza pizza = pizzeria.removePizza();
                if (pizza != null) {
                    System.out.printf("ORDER %d is now being delivered by courier %s\n",
                            pizza.orderId(),
                            info.name());
                    sleep(pizza.range() * 1000L / info.speed());
                    System.out.printf("ORDER %d delivered by courier %s\n",
                            pizza.orderId(),
                            info.name());
                }
            }
        } catch (InterruptedException e) {
            System.out.printf("Courier %s finished work prematurely :(", info.name());
        }
    }

    @Override
    public void stopped() {
        isWorking = false;
    }
}
