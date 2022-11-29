package credit.book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CreditTests {
    @Test
    public void testMyCreditBook() {
        CreditBook myBook = new CreditBook(2);
        myBook.terms = new HashMap<>();
        Map<String, Grade> TermMap1 = new HashMap<>();
        TermMap1.put("Imperative programming", Grade.SATISFACTORY);
        TermMap1.put("Declarative programming", Grade.GOOD);
        TermMap1.put("History", Grade.EXCELLENT);
        TermMap1.put("Fundamentals of speech culture", Grade.EXCELLENT);
        TermMap1.put("Math. Analysis", Grade.SATISFACTORY);
        TermMap1.put("Discrete mathematics", Grade.SATISFACTORY);
        TermMap1.put("Physical education", Grade.CREDIT);
        TermMap1.put("Digital platforms", Grade.CREDIT);
        TermMap1.put("English", Grade.CREDIT);
        Term term = new Term(TermMap1);
        myBook.terms.put(1, term);
        Map<String, Grade> TermMap2 = new HashMap<>();
        TermMap2.put("Imperative programming", Grade.SATISFACTORY);
        TermMap2.put("Declarative programming", Grade.SATISFACTORY);
        TermMap2.put("Math. Analysis", Grade.SATISFACTORY);
        TermMap2.put("Discrete mathematics", Grade.SATISFACTORY);
        TermMap2.put("Physical education", Grade.CREDIT);
        TermMap2.put("Digital platforms", Grade.GOOD);
        TermMap2.put("English", Grade.GOOD);
        TermMap2.put("Measuring practicum", Grade.CREDIT);
        term = new Term(TermMap2);
        myBook.terms.put(2, term);
        Assertions.assertFalse(myBook.redDimploma());
        Assertions.assertFalse(myBook.incScholarship());
        Assertions.assertEquals("3,6", myBook.avgMark());
    }

    @Test
    public void testIncScholarship() {
        CreditBook myBook = new CreditBook(2);
        myBook.terms = new HashMap<>();
        Map<String, Grade> TermMap1 = new HashMap<>();
        TermMap1.put("Imperative programming", Grade.SATISFACTORY);
        TermMap1.put("Declarative programming", Grade.GOOD);
        TermMap1.put("History", Grade.EXCELLENT);
        TermMap1.put("Fundamentals of speech culture", Grade.EXCELLENT);
        TermMap1.put("Math. Analysis", Grade.SATISFACTORY);
        TermMap1.put("Discrete mathematics", Grade.SATISFACTORY);
        TermMap1.put("Physical education", Grade.CREDIT);
        TermMap1.put("Digital platforms", Grade.CREDIT);
        TermMap1.put("English", Grade.CREDIT);
        Term term = new Term(TermMap1);
        myBook.terms.put(1, term);
        Map<String, Grade> TermMap2 = new HashMap<>();
        TermMap2.put("Imperative programming", Grade.EXCELLENT);
        TermMap2.put("Declarative programming", Grade.EXCELLENT);
        TermMap2.put("Math. Analysis", Grade.EXCELLENT);
        TermMap2.put("Discrete mathematics", Grade.EXCELLENT);
        TermMap2.put("Physical education", Grade.CREDIT);
        TermMap2.put("Digital platforms", Grade.EXCELLENT);
        TermMap2.put("English", Grade.EXCELLENT);
        TermMap2.put("Measuring practicum", Grade.CREDIT);
        term = new Term(TermMap2);
        myBook.terms.put(2, term);
        Assertions.assertFalse(myBook.redDimploma());
        Assertions.assertTrue(myBook.incScholarship());
        Assertions.assertEquals("4,4", myBook.avgMark());
    }

    @Test
    public void testRedDiploma() {
        CreditBook myBook = new CreditBook(8);
        myBook.terms = new HashMap<>();
        Map<String, Grade> TermMap1 = new HashMap<>();
        TermMap1.put("Imperative programming", Grade.EXCELLENT);
        TermMap1.put("Declarative programming", Grade.GOOD);
        TermMap1.put("History", Grade.EXCELLENT);
        TermMap1.put("Fundamentals of speech culture", Grade.EXCELLENT);
        TermMap1.put("Math. Analysis", Grade.EXCELLENT);
        TermMap1.put("Discrete mathematics", Grade.EXCELLENT);
        TermMap1.put("Physical education", Grade.CREDIT);
        TermMap1.put("Digital platforms", Grade.CREDIT);
        TermMap1.put("English", Grade.CREDIT);
        Term term = new Term(TermMap1);
        myBook.terms.put(1, term);

        Map<String, Grade> TermMap2 = new HashMap<>();
        TermMap2.put("Imperative programming", Grade.EXCELLENT);
        TermMap2.put("Declarative programming", Grade.EXCELLENT);
        TermMap2.put("Math. Analysis", Grade.EXCELLENT);
        TermMap2.put("Discrete mathematics", Grade.EXCELLENT);
        TermMap2.put("Physical education", Grade.CREDIT);
        TermMap2.put("Digital platforms", Grade.GOOD);
        TermMap2.put("English", Grade.GOOD);
        TermMap2.put("Measuring practicum", Grade.CREDIT);
        term = new Term(TermMap2);
        myBook.terms.put(2, term);

        Map<String, Grade> TermMap3 = new HashMap<>();
        TermMap3.put("OOP", Grade.EXCELLENT);
        TermMap3.put("AI", Grade.EXCELLENT);
        TermMap3.put("TFCV", Grade.EXCELLENT); // Типа ТФКП
        TermMap3.put("Calculation models", Grade.EXCELLENT);
        TermMap3.put("Physical education", Grade.CREDIT);
        TermMap3.put("OS", Grade.GOOD);
        TermMap3.put("English", Grade.EXCELLENT);
        TermMap3.put("Development of SHC", Grade.CREDIT);
        TermMap3.put("Probability theory", Grade.EXCELLENT);
        term = new Term(TermMap3);
        myBook.terms.put(3, term);

        Map<String, Grade> TermMap4 = new HashMap<>();
        TermMap4.put("OOP", Grade.EXCELLENT);
        TermMap4.put("Development of SHC", Grade.EXCELLENT);
        TermMap4.put("Probability theory", Grade.EXCELLENT);
        TermMap4.put("Calculation models", Grade.EXCELLENT);
        TermMap4.put("Physical education", Grade.CREDIT);
        TermMap4.put("IDCS", Grade.GOOD);
        TermMap4.put("English", Grade.EXCELLENT);
        TermMap4.put("Computer networks", Grade.EXCELLENT);
        TermMap4.put("Philosophy", Grade.CREDIT);
        term = new Term(TermMap4);
        myBook.terms.put(4, term);

        Map<String, Grade> TermMap5 = new HashMap<>();
        TermMap5.put("Machine learning", Grade.EXCELLENT);
        TermMap5.put("Mobile development", Grade.EXCELLENT);
        TermMap5.put("Calculating math", Grade.EXCELLENT);
        TermMap5.put("Information processing", Grade.EXCELLENT);
        TermMap5.put("Physical education", Grade.CREDIT);
        TermMap5.put("Team development of SHC", Grade.GOOD);
        TermMap5.put("English", Grade.GOOD);
        TermMap5.put("Information security", Grade.CREDIT);
        term = new Term(TermMap5);
        myBook.terms.put(5, term);

        Map<String, Grade> TermMap6 = new HashMap<>();
        TermMap6.put("Machine learning", Grade.EXCELLENT);
        TermMap6.put("Mobile development", Grade.EXCELLENT);
        TermMap6.put("Calculating math", Grade.EXCELLENT);
        TermMap6.put("Information processing", Grade.EXCELLENT);
        TermMap6.put("Physical education", Grade.CREDIT);
        TermMap6.put("Team development of SHC", Grade.GOOD);
        TermMap6.put("English", Grade.GOOD);
        TermMap6.put("Information security", Grade.CREDIT);
        term = new Term(TermMap6);
        myBook.terms.put(6, term);

        Map<String, Grade> TermMap7 = new HashMap<>();
        TermMap7.put("Bioinformatics", Grade.EXCELLENT);
        TermMap7.put("Semantic Web", Grade.EXCELLENT);
        TermMap7.put("Information protection", Grade.EXCELLENT);
        TermMap7.put("Educational practice", Grade.EXCELLENT);
        TermMap7.put("Computational linguistics", Grade.CREDIT);
        term = new Term(TermMap7);
        myBook.terms.put(7, term);

        Map<String, Grade> TermMap8 = new HashMap<>();
        TermMap8.put("Life safety", Grade.EXCELLENT);
        TermMap8.put("Fundamentals of rhetoric", Grade.EXCELLENT);
        TermMap8.put("Production practice", Grade.EXCELLENT);
        TermMap8.put("Economics", Grade.EXCELLENT);
        term = new Term(TermMap8);
        myBook.terms.put(8, term);

        myBook.diplomaGrades.put("Qualification work", Grade.EXCELLENT);
        myBook.diplomaGrades.put("Imperative programming", Grade.EXCELLENT);
        myBook.diplomaGrades.put("Declarative programming", Grade.EXCELLENT);
        myBook.diplomaGrades.put("Math. Analysis", Grade.EXCELLENT);
        myBook.diplomaGrades.put("Digital platforms", Grade.GOOD);
        myBook.diplomaGrades.put("OOP", Grade.EXCELLENT);
        myBook.diplomaGrades.put("OS", Grade.GOOD);
        myBook.diplomaGrades.put("English", Grade.EXCELLENT);
        myBook.diplomaGrades.put("Team development of SHC", Grade.GOOD);
        myBook.diplomaGrades.put("Semantic Web", Grade.EXCELLENT);
        myBook.diplomaGrades.put("Economics", Grade.EXCELLENT);
        myBook.diplomaGrades.put("Mobile development", Grade.EXCELLENT);
        myBook.diplomaGrades.put("Bioinformatics", Grade.EXCELLENT);
        myBook.diplomaGrades.put("Machine learning", Grade.EXCELLENT);

        Assertions.assertTrue(myBook.redDimploma());
        Assertions.assertEquals("4,8", myBook.avgMark());
    }

    @Test
    public void testWithoutRedDiploma() {
        CreditBook myBook = new CreditBook(8);
        myBook.terms = new HashMap<>();
        Map<String, Grade> TermMap1 = new HashMap<>();
        TermMap1.put("Imperative programming", Grade.SATISFACTORY);
        TermMap1.put("Declarative programming", Grade.GOOD);
        TermMap1.put("History", Grade.EXCELLENT);
        TermMap1.put("Fundamentals of speech culture", Grade.EXCELLENT);
        TermMap1.put("Math. Analysis", Grade.EXCELLENT);
        TermMap1.put("Discrete mathematics", Grade.EXCELLENT);
        TermMap1.put("Physical education", Grade.CREDIT);
        TermMap1.put("Digital platforms", Grade.CREDIT);
        TermMap1.put("English", Grade.CREDIT);
        Term term = new Term(TermMap1);
        myBook.terms.put(1, term);

        Map<String, Grade> TermMap2 = new HashMap<>();
        TermMap2.put("Imperative programming", Grade.EXCELLENT);
        TermMap2.put("Declarative programming", Grade.EXCELLENT);
        TermMap2.put("Math. Analysis", Grade.EXCELLENT);
        TermMap2.put("Discrete mathematics", Grade.EXCELLENT);
        TermMap2.put("Physical education", Grade.CREDIT);
        TermMap2.put("Digital platforms", Grade.GOOD);
        TermMap2.put("English", Grade.GOOD);
        TermMap2.put("Measuring practicum", Grade.CREDIT);
        term = new Term(TermMap2);
        myBook.terms.put(2, term);

        Map<String, Grade> TermMap3 = new HashMap<>();
        TermMap3.put("OOP", Grade.EXCELLENT);
        TermMap3.put("AI", Grade.EXCELLENT);
        TermMap3.put("TFCV", Grade.EXCELLENT); // Типа ТФКП
        TermMap3.put("Calculation models", Grade.EXCELLENT);
        TermMap3.put("Physical education", Grade.CREDIT);
        TermMap3.put("OS", Grade.GOOD);
        TermMap3.put("English", Grade.EXCELLENT);
        TermMap3.put("Development of SHC", Grade.CREDIT);
        TermMap3.put("Probability theory", Grade.EXCELLENT);
        term = new Term(TermMap3);
        myBook.terms.put(3, term);

        Map<String, Grade> TermMap4 = new HashMap<>();
        TermMap4.put("OOP", Grade.EXCELLENT);
        TermMap4.put("Development of SHC", Grade.EXCELLENT);
        TermMap4.put("Probability theory", Grade.EXCELLENT);
        TermMap4.put("Calculation models", Grade.EXCELLENT);
        TermMap4.put("Physical education", Grade.CREDIT);
        TermMap4.put("IDCS", Grade.GOOD);
        TermMap4.put("English", Grade.EXCELLENT);
        TermMap4.put("Computer networks", Grade.EXCELLENT);
        TermMap4.put("Philosophy", Grade.CREDIT);
        term = new Term(TermMap4);
        myBook.terms.put(4, term);

        Map<String, Grade> TermMap5 = new HashMap<>();
        TermMap5.put("Machine learning", Grade.EXCELLENT);
        TermMap5.put("Mobile development", Grade.EXCELLENT);
        TermMap5.put("Calculating math", Grade.EXCELLENT);
        TermMap5.put("Information processing", Grade.EXCELLENT);
        TermMap5.put("Physical education", Grade.CREDIT);
        TermMap5.put("Team development of SHC", Grade.GOOD);
        TermMap5.put("English", Grade.GOOD);
        TermMap5.put("Information security", Grade.CREDIT);
        term = new Term(TermMap5);
        myBook.terms.put(5, term);

        Map<String, Grade> TermMap6 = new HashMap<>();
        TermMap6.put("Machine learning", Grade.EXCELLENT);
        TermMap6.put("Mobile development", Grade.EXCELLENT);
        TermMap6.put("Calculating math", Grade.EXCELLENT);
        TermMap6.put("Information processing", Grade.EXCELLENT);
        TermMap6.put("Physical education", Grade.CREDIT);
        TermMap6.put("Team development of SHC", Grade.GOOD);
        TermMap6.put("English", Grade.GOOD);
        TermMap6.put("Information security", Grade.CREDIT);
        term = new Term(TermMap6);
        myBook.terms.put(6, term);

        Map<String, Grade> TermMap7 = new HashMap<>();
        TermMap7.put("Bioinformatics", Grade.EXCELLENT);
        TermMap7.put("Semantic Web", Grade.EXCELLENT);
        TermMap7.put("Information protection", Grade.EXCELLENT);
        TermMap7.put("Educational practice", Grade.EXCELLENT);
        TermMap7.put("Computational linguistics", Grade.CREDIT);
        term = new Term(TermMap7);
        myBook.terms.put(7, term);

        Map<String, Grade> TermMap8 = new HashMap<>();
        TermMap8.put("Life safety", Grade.EXCELLENT);
        TermMap8.put("Fundamentals of rhetoric", Grade.EXCELLENT);
        TermMap8.put("Production practice", Grade.EXCELLENT);
        TermMap8.put("Economics", Grade.EXCELLENT);
        term = new Term(TermMap8);
        myBook.terms.put(8, term);

        myBook.diplomaGrades.put("Qualification work", Grade.EXCELLENT);
        myBook.diplomaGrades.put("Imperative programming", Grade.EXCELLENT);
        myBook.diplomaGrades.put("Declarative programming", Grade.EXCELLENT);
        myBook.diplomaGrades.put("Math. Analysis", Grade.EXCELLENT);
        myBook.diplomaGrades.put("Digital platforms", Grade.GOOD);
        myBook.diplomaGrades.put("OOP", Grade.EXCELLENT);
        myBook.diplomaGrades.put("OS", Grade.GOOD);
        myBook.diplomaGrades.put("English", Grade.EXCELLENT);
        myBook.diplomaGrades.put("Team development of SHC", Grade.GOOD);
        myBook.diplomaGrades.put("Semantic Web", Grade.EXCELLENT);
        myBook.diplomaGrades.put("Economics", Grade.EXCELLENT);
        myBook.diplomaGrades.put("Mobile development", Grade.EXCELLENT);
        myBook.diplomaGrades.put("Bioinformatics", Grade.EXCELLENT);
        myBook.diplomaGrades.put("Machine learning", Grade.EXCELLENT);

        Assertions.assertFalse(myBook.redDimploma());
        Assertions.assertEquals("4,8", myBook.avgMark());
    }
}
