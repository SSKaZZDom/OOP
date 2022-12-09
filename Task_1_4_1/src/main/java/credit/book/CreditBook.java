package credit.book;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class CreditBook.
 * This implementation contains:
 *  In constructor:
 *  - Map of Terms
 *  - Map of diploma grades
 *  Functions:
 *  - avgMark function
 *  - incScholarship function
 *  - redDiploma function
 */
public class CreditBook {
    Map<Integer, Term> terms = new HashMap<>();
    Map<String, Grade> diplomaGrades = new HashMap<>();
    int cntTerms;

    /**
     * Constructor of CreditBook class.
     *
     * @param cntTerms - number of finishing terms
     */
    public CreditBook(int cntTerms) {
        this.cntTerms = cntTerms;
    }

    /**
     * redDiploma function.
     * return true if you completed all requirements for obtaining a red diploma
     */
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

    /**
     * incScholarship function.
     * return true if you have only excellent marks in the last Term
     */
    public boolean incScholarship() {
        List<Grade> grades = new ArrayList<>(terms.get(cntTerms).examGrades());
        boolean flag = true;
        for (Grade grade : grades) {
            if (grade == Grade.BAD || grade == Grade.SATISFACTORY) {
                flag = false;
            } else if (grade == Grade.GOOD || grade == Grade.NONCREDIT) {
                flag = false;
            } // Не смог всунуть это в один if, потому что ограничение длины строки от rewiewdog
        }
        return flag;
    }

    /**
     * avgMark function.
     * return average mark in format "#.#"
     */
    public String avgMark() {
        double sum = 0;
        int cnt = 0;
        int mark;
        List<Grade> grades = new ArrayList<>();
        for (int i = 1; i <= cntTerms; i++) {
            grades.addAll(terms.get(i).examGrades());
        }
        for (Grade grade : grades) {
            mark = Grade.convert(grade);
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
        for (int i = 1; i <= 8; i++) {
            grades.addAll(terms.get(i).examGrades());
            for (Grade grade : grades) {
                if (grade == Grade.BAD || grade == Grade.SATISFACTORY || grade == Grade.NONCREDIT) {
                    return true;
                }
            }
        }
        return flag;
    }

    private double marksPercent() {
        double cntAll = 0;
        double cntGreat = 0;
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
        return cntGreat / cntAll;
    }
}
