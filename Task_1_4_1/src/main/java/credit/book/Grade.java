package credit.book;

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
}