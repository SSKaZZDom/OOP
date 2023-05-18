package pizzeria;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Main class, where pizzeria class runs.
 */
public class Main {
    /**
     * Main method with one workday of our pizzeria with 5 orders, 4 cooks and 4 couriers.
     */
    public static void main(String[] args) {
        try (InputStream is = Main.class.getClassLoader().getResourceAsStream("1.json");) {
            assert is != null;
            try (BufferedReader r = new BufferedReader(new InputStreamReader(is))
            ) {
                Pizzeria pizzeria = new Pizzeria(r, 4);
                pizzeria.start();

                Pizza[] pizzas = new Pizza[5];
                for (int i = 0; i < 5; i++) {
                    pizzas[i] = new Pizza((i + 1) * 500, (i + 1) * 1000, i + 1);
                    pizzeria.addOrder(pizzas[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("Main has been failed");
        }
    }
}
