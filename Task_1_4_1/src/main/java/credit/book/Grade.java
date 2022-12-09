package credit.book;

/**
 * Enum for the grades/marks in the credit book.
 */
public enum Grade {
    EXCELLENT("Excellent"),
    GOOD("Good"),
    SATISFACTORY("Satisfactory"),
    BAD("Bad"),
    CREDIT("Credit"),
    NONCREDIT("NonCredit");

    private final String grade;

    Grade(String grade) {
        this.grade = grade;
    }

    static int convert(Grade grade) {
        return switch (grade) {
            case EXCELLENT -> 5;
            case GOOD -> 4;
            case SATISFACTORY -> 3;
            case BAD -> 2;
            default -> 0;
        };
    }
}
