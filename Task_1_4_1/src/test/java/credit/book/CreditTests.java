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
        Map<String, Grade> termMap1 = new HashMap<>();
        termMap1.put("Imperative programming", Grade.SATISFACTORY);
        termMap1.put("Declarative programming", Grade.GOOD);
        termMap1.put("History", Grade.EXCELLENT);
        termMap1.put("Fundamentals of speech culture", Grade.EXCELLENT);
        termMap1.put("Math. Analysis", Grade.SATISFACTORY);
        termMap1.put("Discrete mathematics", Grade.SATISFACTORY);
        termMap1.put("Physical education", Grade.CREDIT);
        termMap1.put("Digital platforms", Grade.CREDIT);
        termMap1.put("English", Grade.CREDIT);
        Term term = new Term(termMap1);
        myBook.terms.put(1, term);
        Map<String, Grade> termMap2 = new HashMap<>();
        termMap2.put("Imperative programming", Grade.SATISFACTORY);
        termMap2.put("Declarative programming", Grade.SATISFACTORY);
        termMap2.put("Math. Analysis", Grade.SATISFACTORY);
        termMap2.put("Discrete mathematics", Grade.SATISFACTORY);
        termMap2.put("Physical education", Grade.CREDIT);
        termMap2.put("Digital platforms", Grade.GOOD);
        termMap2.put("English", Grade.GOOD);
        termMap2.put("Measuring practicum", Grade.CREDIT);
        term = new Term(termMap2);
        myBook.terms.put(2, term);
        Assertions.assertFalse(myBook.redDimploma());
        Assertions.assertFalse(myBook.incScholarship());
        Assertions.assertEquals("3.6", myBook.avgMark());
    }

    @Test
    public void testIncScholarship() {
        CreditBook myBook = new CreditBook(2);
        myBook.terms = new HashMap<>();
        Map<String, Grade> termMap1 = new HashMap<>();
        termMap1.put("Imperative programming", Grade.SATISFACTORY);
        termMap1.put("Declarative programming", Grade.GOOD);
        termMap1.put("History", Grade.EXCELLENT);
        termMap1.put("Fundamentals of speech culture", Grade.EXCELLENT);
        termMap1.put("Math. Analysis", Grade.SATISFACTORY);
        termMap1.put("Discrete mathematics", Grade.SATISFACTORY);
        termMap1.put("Physical education", Grade.CREDIT);
        termMap1.put("Digital platforms", Grade.CREDIT);
        termMap1.put("English", Grade.CREDIT);
        Term term = new Term(termMap1);
        myBook.terms.put(1, term);
        Map<String, Grade> termMap2 = new HashMap<>();
        termMap2.put("Imperative programming", Grade.EXCELLENT);
        termMap2.put("Declarative programming", Grade.EXCELLENT);
        termMap2.put("Math. Analysis", Grade.EXCELLENT);
        termMap2.put("Discrete mathematics", Grade.EXCELLENT);
        termMap2.put("Physical education", Grade.CREDIT);
        termMap2.put("Digital platforms", Grade.EXCELLENT);
        termMap2.put("English", Grade.EXCELLENT);
        termMap2.put("Measuring practicum", Grade.CREDIT);
        term = new Term(termMap2);
        myBook.terms.put(2, term);
        Assertions.assertFalse(myBook.redDimploma());
        Assertions.assertTrue(myBook.incScholarship());
        Assertions.assertEquals("4.4", myBook.avgMark());
    }

    @Test
    public void testRedDiploma() {
        CreditBook myBook = new CreditBook(8);
        myBook.terms = new HashMap<>();
        Map<String, Grade> termMap1 = new HashMap<>();
        termMap1.put("Imperative programming", Grade.EXCELLENT);
        termMap1.put("Declarative programming", Grade.GOOD);
        termMap1.put("History", Grade.EXCELLENT);
        termMap1.put("Fundamentals of speech culture", Grade.EXCELLENT);
        termMap1.put("Math. Analysis", Grade.EXCELLENT);
        termMap1.put("Discrete mathematics", Grade.EXCELLENT);
        termMap1.put("Physical education", Grade.CREDIT);
        termMap1.put("Digital platforms", Grade.CREDIT);
        termMap1.put("English", Grade.CREDIT);
        Term term = new Term(termMap1);
        myBook.terms.put(1, term);

        Map<String, Grade> termMap2 = new HashMap<>();
        termMap2.put("Imperative programming", Grade.EXCELLENT);
        termMap2.put("Declarative programming", Grade.EXCELLENT);
        termMap2.put("Math. Analysis", Grade.EXCELLENT);
        termMap2.put("Discrete mathematics", Grade.EXCELLENT);
        termMap2.put("Physical education", Grade.CREDIT);
        termMap2.put("Digital platforms", Grade.GOOD);
        termMap2.put("English", Grade.GOOD);
        termMap2.put("Measuring practicum", Grade.CREDIT);
        term = new Term(termMap2);
        myBook.terms.put(2, term);

        Map<String, Grade> termMap3 = new HashMap<>();
        termMap3.put("OOP", Grade.EXCELLENT);
        termMap3.put("AI", Grade.EXCELLENT);
        termMap3.put("TFCV", Grade.EXCELLENT); // Типа ТФКП
        termMap3.put("Calculation models", Grade.EXCELLENT);
        termMap3.put("Physical education", Grade.CREDIT);
        termMap3.put("OS", Grade.GOOD);
        termMap3.put("English", Grade.EXCELLENT);
        termMap3.put("Development of SHC", Grade.CREDIT);
        termMap3.put("Probability theory", Grade.EXCELLENT);
        term = new Term(termMap3);
        myBook.terms.put(3, term);

        Map<String, Grade> termMap4 = new HashMap<>();
        termMap4.put("OOP", Grade.EXCELLENT);
        termMap4.put("Development of SHC", Grade.EXCELLENT);
        termMap4.put("Probability theory", Grade.EXCELLENT);
        termMap4.put("Calculation models", Grade.EXCELLENT);
        termMap4.put("Physical education", Grade.CREDIT);
        termMap4.put("IDCS", Grade.GOOD);
        termMap4.put("English", Grade.EXCELLENT);
        termMap4.put("Computer networks", Grade.EXCELLENT);
        termMap4.put("Philosophy", Grade.CREDIT);
        term = new Term(termMap4);
        myBook.terms.put(4, term);

        Map<String, Grade> termMap5 = new HashMap<>();
        termMap5.put("Machine learning", Grade.EXCELLENT);
        termMap5.put("Mobile development", Grade.EXCELLENT);
        termMap5.put("Calculating math", Grade.EXCELLENT);
        termMap5.put("Information processing", Grade.EXCELLENT);
        termMap5.put("Physical education", Grade.CREDIT);
        termMap5.put("Team development of SHC", Grade.GOOD);
        termMap5.put("English", Grade.GOOD);
        termMap5.put("Information security", Grade.CREDIT);
        term = new Term(termMap5);
        myBook.terms.put(5, term);

        Map<String, Grade> termMap6 = new HashMap<>();
        termMap6.put("Machine learning", Grade.EXCELLENT);
        termMap6.put("Mobile development", Grade.EXCELLENT);
        termMap6.put("Calculating math", Grade.EXCELLENT);
        termMap6.put("Information processing", Grade.EXCELLENT);
        termMap6.put("Physical education", Grade.CREDIT);
        termMap6.put("Team development of SHC", Grade.GOOD);
        termMap6.put("English", Grade.GOOD);
        termMap6.put("Information security", Grade.CREDIT);
        term = new Term(termMap6);
        myBook.terms.put(6, term);

        Map<String, Grade> termMap7 = new HashMap<>();
        termMap7.put("Bioinformatics", Grade.EXCELLENT);
        termMap7.put("Semantic Web", Grade.EXCELLENT);
        termMap7.put("Information protection", Grade.EXCELLENT);
        termMap7.put("Educational practice", Grade.EXCELLENT);
        termMap7.put("Computational linguistics", Grade.CREDIT);
        term = new Term(termMap7);
        myBook.terms.put(7, term);

        Map<String, Grade> termMap8 = new HashMap<>();
        termMap8.put("Life safety", Grade.EXCELLENT);
        termMap8.put("Fundamentals of rhetoric", Grade.EXCELLENT);
        termMap8.put("Production practice", Grade.EXCELLENT);
        termMap8.put("Economics", Grade.EXCELLENT);
        term = new Term(termMap8);
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
        Assertions.assertEquals("4.8", myBook.avgMark());
    }

    @Test
    public void testWithoutRedDiploma() {
        CreditBook myBook = new CreditBook(8);
        myBook.terms = new HashMap<>();
        Map<String, Grade> termMap1 = new HashMap<>();
        termMap1.put("Imperative programming", Grade.SATISFACTORY);
        termMap1.put("Declarative programming", Grade.GOOD);
        termMap1.put("History", Grade.EXCELLENT);
        termMap1.put("Fundamentals of speech culture", Grade.EXCELLENT);
        termMap1.put("Math. Analysis", Grade.EXCELLENT);
        termMap1.put("Discrete mathematics", Grade.EXCELLENT);
        termMap1.put("Physical education", Grade.CREDIT);
        termMap1.put("Digital platforms", Grade.CREDIT);
        termMap1.put("English", Grade.CREDIT);
        Term term = new Term(termMap1);
        myBook.terms.put(1, term);

        Map<String, Grade> termMap2 = new HashMap<>();
        termMap2.put("Imperative programming", Grade.EXCELLENT);
        termMap2.put("Declarative programming", Grade.EXCELLENT);
        termMap2.put("Math. Analysis", Grade.EXCELLENT);
        termMap2.put("Discrete mathematics", Grade.EXCELLENT);
        termMap2.put("Physical education", Grade.CREDIT);
        termMap2.put("Digital platforms", Grade.GOOD);
        termMap2.put("English", Grade.GOOD);
        termMap2.put("Measuring practicum", Grade.CREDIT);
        term = new Term(termMap2);
        myBook.terms.put(2, term);

        Map<String, Grade> termMap3 = new HashMap<>();
        termMap3.put("OOP", Grade.EXCELLENT);
        termMap3.put("AI", Grade.EXCELLENT);
        termMap3.put("TFCV", Grade.EXCELLENT); // Типа ТФКП
        termMap3.put("Calculation models", Grade.EXCELLENT);
        termMap3.put("Physical education", Grade.CREDIT);
        termMap3.put("OS", Grade.GOOD);
        termMap3.put("English", Grade.EXCELLENT);
        termMap3.put("Development of SHC", Grade.CREDIT);
        termMap3.put("Probability theory", Grade.EXCELLENT);
        term = new Term(termMap3);
        myBook.terms.put(3, term);

        Map<String, Grade> termMap4 = new HashMap<>();
        termMap4.put("OOP", Grade.EXCELLENT);
        termMap4.put("Development of SHC", Grade.EXCELLENT);
        termMap4.put("Probability theory", Grade.EXCELLENT);
        termMap4.put("Calculation models", Grade.EXCELLENT);
        termMap4.put("Physical education", Grade.CREDIT);
        termMap4.put("IDCS", Grade.GOOD);
        termMap4.put("English", Grade.EXCELLENT);
        termMap4.put("Computer networks", Grade.EXCELLENT);
        termMap4.put("Philosophy", Grade.CREDIT);
        term = new Term(termMap4);
        myBook.terms.put(4, term);

        Map<String, Grade> termMap5 = new HashMap<>();
        termMap5.put("Machine learning", Grade.EXCELLENT);
        termMap5.put("Mobile development", Grade.EXCELLENT);
        termMap5.put("Calculating math", Grade.EXCELLENT);
        termMap5.put("Information processing", Grade.EXCELLENT);
        termMap5.put("Physical education", Grade.CREDIT);
        termMap5.put("Team development of SHC", Grade.GOOD);
        termMap5.put("English", Grade.GOOD);
        termMap5.put("Information security", Grade.CREDIT);
        term = new Term(termMap5);
        myBook.terms.put(5, term);

        Map<String, Grade> termMap6 = new HashMap<>();
        termMap6.put("Machine learning", Grade.EXCELLENT);
        termMap6.put("Mobile development", Grade.EXCELLENT);
        termMap6.put("Calculating math", Grade.EXCELLENT);
        termMap6.put("Information processing", Grade.EXCELLENT);
        termMap6.put("Physical education", Grade.CREDIT);
        termMap6.put("Team development of SHC", Grade.GOOD);
        termMap6.put("English", Grade.GOOD);
        termMap6.put("Information security", Grade.CREDIT);
        term = new Term(termMap6);
        myBook.terms.put(6, term);

        Map<String, Grade> termMap7 = new HashMap<>();
        termMap7.put("Bioinformatics", Grade.EXCELLENT);
        termMap7.put("Semantic Web", Grade.EXCELLENT);
        termMap7.put("Information protection", Grade.EXCELLENT);
        termMap7.put("Educational practice", Grade.EXCELLENT);
        termMap7.put("Computational linguistics", Grade.CREDIT);
        term = new Term(termMap7);
        myBook.terms.put(7, term);

        Map<String, Grade> termMap8 = new HashMap<>();
        termMap8.put("Life safety", Grade.EXCELLENT);
        termMap8.put("Fundamentals of rhetoric", Grade.EXCELLENT);
        termMap8.put("Production practice", Grade.EXCELLENT);
        termMap8.put("Economics", Grade.EXCELLENT);
        term = new Term(termMap8);
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
        Assertions.assertEquals("4.8", myBook.avgMark());
    }
}
