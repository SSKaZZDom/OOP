package pizzeria;

public class EmployeeInfo {
    private final String name;
    private final int speed;

    /**
     * Constructor of EmployeeInfo.
     * Name and speed of this Employee.
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
