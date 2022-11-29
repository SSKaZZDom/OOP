package credit.book;

import java.util.*;

record Term(Map<String, Grade> exams) {
    public List<Grade> examGrades() {
        List<Grade> res = new ArrayList<>();
        for (String subject : exams.keySet()) {
            res.add(exams.get(subject));
        }
        return res;
    }
}
