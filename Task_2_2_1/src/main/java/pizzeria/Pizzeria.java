package pizzeria;

import com.google.gson.Gson;
import java.io.Reader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Pizzeria class.
 * It starts all cooks and couriers threads and has queues of orders and storage.
 */
public class Pizzeria extends Thread {
    private final int storageCapacity;
    private final Cook[] cooks;
    private final Courier[] couriers;
    private final Queue<Pizza> storage = new ArrayDeque<>();
    private final Queue<Pizza> orders = new ArrayDeque<>();

    /**
     * Constructor of Pizzeria class.
     * Has queue of orders and storage queue.
     * Also has arrays of Cooks and Couriers.
     *
     * @param r reader that reads info from the Json file.
     * @param storageCapacity capacity of pizzeria storage.
     */
    public Pizzeria(Reader r, int storageCapacity) {
        Gson gson = new Gson();

        CooksAndCouriers cooksAndCouriers = gson.fromJson(r, CooksAndCouriers.class);

        cooks = new Cook[cooksAndCouriers.cooks().length];
        Arrays.setAll(cooks, i -> new Cook(this, cooksAndCouriers.cooks[i]));

        couriers = new Courier[cooksAndCouriers.couriers().length];
        Arrays.setAll(couriers, i -> new Courier(this, cooksAndCouriers.couriers[i]));
        this.storageCapacity = storageCapacity;
    }

    /**
     * Method that return order from the top of order queue.
     */
    public Pizza getOrder() throws InterruptedException {
        synchronized (orders) {
            if (orders.size() == 0) {
                orders.wait();
            }
            return orders.poll();
        }
    }

    /**
     * Method that add pizza to the storage queue.
     */
    public void addPizza(Pizza pizza) throws InterruptedException {
        synchronized (storage) {
            while (storage.size() == storageCapacity) {
                storage.wait();
            }
            storage.add(pizza);
            storage.notify();
        }
    }

    /**
     * Method that return pizza from the top of storage queue.
     */
    public Pizza removePizza() throws InterruptedException {
        synchronized (storage) {
            if (storage.size() == 0) {
                storage.wait();
            }
            return storage.poll();
        }
    }

    /**
     * Method add order to the queue of orders.
     *
     * @param pizza - This order
     */
    public void addOrder(Pizza pizza) throws InterruptedException {
        synchronized (orders) {
            orders.add(pizza);
            orders.notify();
        }
    }

    @Override
    public void run() {
        for (Cook cook : cooks) {
            cook.start();
        }
        for (Courier courier : couriers) {
            courier.start();
        }
        try {
            closePizzeria();
        } catch (InterruptedException e) {
            System.out.println("Pizzeria cannot close properly");
        }
        System.out.println("Pizzeria is closing");
    }

    private void closePizzeria() throws InterruptedException {
        sleep(30000);
        Arrays.stream(cooks).forEach(Cook::stopped);
        Arrays.stream(couriers).forEach(Courier::stopped);
        synchronized (orders) {
            orders.notifyAll();
        }
        synchronized (storage) {
            storage.notifyAll();
        }
    }

    static class CooksAndCouriers {
        CookInfo[] cooks;
        CourierInfo[] couriers;

        CooksAndCouriers(CookInfo[] cooks, CourierInfo[] couriers) {
            this.cooks = cooks;
            this.couriers = couriers;
        }

        public CookInfo[] cooks() {
            return cooks;
        }

        public CourierInfo[] couriers() {
            return couriers;
        }
    }
}
