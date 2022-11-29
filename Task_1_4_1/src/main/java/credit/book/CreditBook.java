package credit.book;

import java.text.DecimalFormat;
import java.util.*;

public class CreditBook {
    Map<Integer, Term> terms;
    Map<String, Grade> diplomaGrades;
    int cntTerms;

    public CreditBook(int cntTerms) {
        terms = new HashMap<>();
        diplomaGrades = new HashMap<>();
        this.cntTerms = cntTerms;
    }

    public boolean redDimploma() {
        if (cntTerms < 8) {
            return false;
        }
        boolean res = true;
        if (diplomaGrades.containsKey("Qualification work")) {
            res = diplomaGrades.get("Qualification work").equals(Grade.EXCELLENT);
        } else {
            return false;
        }
        res = res && !this.hasSatisfactory();
        res = res && this.marksPercent() >= 0.75;
        return res;
    }

    public boolean incScholarship() {
        List<Grade> grades = new ArrayList<>(terms.get(cntTerms).examGrades());
        boolean flag = true;
        for (Grade grade : grades){
                switch (grade){
                    case BAD,SATISFACTORY,GOOD,NONCREDIT -> flag = false;
                }
            }
        return flag;
    }

    public String avgMark() {
        double sum = 0;
        int cnt = 0;
        int mark;
        List<Grade> grades = new ArrayList<>();
        for (int i = 1; i <= cntTerms; i++){
            grades.addAll(terms.get(i).examGrades());
        }
        for (Grade grade : grades) {
            mark = convert(grade);
            if (mark != 0) {
                sum += mark;
                cnt++;
            }
        }
        sum /= cnt;
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        return decimalFormat.format(sum);
    }

    private boolean hasSatisfactory() {
        List<Grade> grades = new ArrayList<>();
        boolean flag = false;
        for (int i = 1; i <= 8; i++){
            grades.addAll(terms.get(i).examGrades());
            for (Grade grade : grades) {
                switch (grade){
                    case BAD, SATISFACTORY, NONCREDIT -> flag = true;
                }
            }
        }
        return flag;
    }

    private double marksPercent() {
        double cntAll = 0, cntGreat = 0;
        Collection<Grade> grades = new ArrayList<>(diplomaGrades.values());
        for (Grade grade : grades) {
            if (grade.equals(Grade.EXCELLENT)) {
                cntGreat++;
            }
            cntAll++;
        }
        if (diplomaGrades.containsKey("Qualification work")) {
            cntAll--;
        }
        return cntGreat/cntAll;
    }

    private int convert(Grade grade) {
        return switch (grade) {
            case EXCELLENT -> 5;
            case GOOD -> 4;
            case SATISFACTORY -> 3;
            case BAD -> 2;
            default -> 0;
        };
    }
}
