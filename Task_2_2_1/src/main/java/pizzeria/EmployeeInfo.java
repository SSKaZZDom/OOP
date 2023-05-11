package pizzeria;

public class EmployeeInfo {
    private final String name;
    private final int speed;

    /**
     * Constructor of EmployeeInfo.
     *
     */
    public EmployeeInfo(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String name() {
        return name;
    }

    public int speed() {
        return speed;
    }
}
