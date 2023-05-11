package pizzeria;

/**
 * Abstract class of Employee.
 * Realizations - Cook & Courier.
 * @param <T> - information about this Employee.
 */
public abstract class Employee<T extends EmployeeInfo> extends Thread {
    final Pizzeria pizzeria;
    final T info;

    public Employee(T info, Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
        this.info = info;
    }

    public abstract void work() throws InterruptedException;

    public abstract void stopped();

    @Override
    public void run() {
        try {
            work();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
