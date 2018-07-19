
import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.junit.Test;

public class CalculatorTest {

    Calculator calculator;

    public ArrayList<String> makeList(String one, String two, String three,
            String four, String five, String six) {

        ArrayList<String> list = new ArrayList<String>() {
            {
                add(one);
                add(two);
                add(three);
                add(four);
                add(five);
                add(six);
            }
        };

        return list;

    }

    public int makeCalculations(ArrayList<String> results,
            ArrayList<String> prediction) {
        calculator = new Calculator(results, prediction);
        return calculator.calculateScore(results, prediction);
    }

    @Test
    public void testAllCorrect() {
        ArrayList<String> results = makeList("a", "b", "c", "d", "e", "f");
        ArrayList<String> prediction = makeList("a", "b", "c", "d", "e", "f");
        int score = makeCalculations(results, prediction);

        assertEquals(133, score);
    }

    @Test
    public void testJustFirstPlaceCorrect() {
        ArrayList<String> results = makeList("a", "b", "c", "d", "e", "f");
        ArrayList<String> prediction = makeList("a", "c", "d", "e", "f", "g");
        int score = makeCalculations(results, prediction);

        assertEquals(26, score);
    }

    @Test
    public void testJustSecondPlaceCorrect() {
        ArrayList<String> results = makeList("a", "b", "c", "d", "e", "f");
        ArrayList<String> prediction = makeList("g", "b", "h", "i", "j", "k");
        int score = makeCalculations(results, prediction);

        assertEquals(23, score);
    }

    @Test
    public void testJustThirdPlaceCorrect() {
        ArrayList<String> results = makeList("a", "b", "c", "d", "e", "f");
        ArrayList<String> prediction = makeList("g", "h", "c", "i", "j", "k");
        int score = makeCalculations(results, prediction);

        assertEquals(21, score);
    }

    @Test
    public void testJustFourthPlaceCorrect() {
        ArrayList<String> results = makeList("a", "b", "c", "d", "e", "f");
        ArrayList<String> prediction = makeList("g", "h", "z", "d", "j", "k");
        int score = makeCalculations(results, prediction);

        assertEquals(19, score);
    }
    
    @Test
    public void testJustFifthPlaceCorrect() {
        ArrayList<String> results = makeList("a", "b", "c", "d", "e", "f");
        ArrayList<String> prediction = makeList("g", "h", "z", "v", "e", "k");
        int score = makeCalculations(results, prediction);

        assertEquals(18, score);
    }
    
    @Test
    public void testJustWildcardCorrect() {
        ArrayList<String> results = makeList("a", "b", "c", "d", "e", "f");
        ArrayList<String> prediction = makeList("g", "h", "z", "v", "q", "f");
        int score = makeCalculations(results, prediction);

        assertEquals(26, score);
    }

}
