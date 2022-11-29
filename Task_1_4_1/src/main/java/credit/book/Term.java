package credit.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

record Term(Map<String, Grade> exams) {
    public List<Grade> examGrades() {
        List<Grade> res = new ArrayList<>();
        for (String subject : exams.keySet()) {
            res.add(exams.get(subject));
        }
        return res;
    }
}
