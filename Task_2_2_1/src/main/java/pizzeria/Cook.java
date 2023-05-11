package pizzeria;
/**
 * Realization of Cook class.
 * Has two methods:
 * work - start of workday, cook wait the orders
 * stopped - end of workday, cook is cooking the last order and finishing work
 */
public class Cook extends Employee<CookInfo> {
    private boolean isWorking = true;
    private final Pizzeria pizzeria;
    private final CookInfo info;

    /**
     * Constructor of Cook class.
     * @param pizzeria - pizzeria where cook works.
     * @param info - name and speed of this cook.
     */
    public Cook(Pizzeria pizzeria, CookInfo info) {
        super(info, pizzeria);
        this.pizzeria = pizzeria;
        this.info = info;
    }

    @Override
    public void work() throws InterruptedException {
        while (isWorking) {
            Pizza pizza = pizzeria.getOrder();
            if (pizza != null) {
                System.out.printf("ORDER %d is being cooked by Cook %s\n",
                        pizza.orderId(),
                        info.name());
                sleep(Math.round(pizza.timeToCooking() * 1000L / info.speed()));
                pizzeria.addPizza(pizza);
                System.out.printf("ORDER %d stored by Cook %s\n",
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