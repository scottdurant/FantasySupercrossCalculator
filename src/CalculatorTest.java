
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
        calculator = new Calculator();
        return calculator.calculateScore(results, prediction);
    }

    @Test
    public void testAllCorrect() {
        ArrayList<String> results = makeList("a", "b", "c", "d", "e", "f");
        ArrayList<String> prediction = makeList("a", "b", "c", "d", "e", "f");
        int score = makeCalculations(results, prediction);

        assertEquals(133, score);
    }

    // Note: these do not test if the user picks a rider who was in the top
    // five, but the position was off

    @Test
    public void testJustFirstPlaceCorrect() {
        ArrayList<String> results = makeList("a", "b", "c", "d", "e", "f");
        ArrayList<String> prediction = makeList("a", "g", "h", "i", "j", "k");
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
        ArrayList<String> prediction = makeList("g", "h", "i", "d", "j", "k");
        int score = makeCalculations(results, prediction);

        assertEquals(19, score);
    }

    @Test
    public void testJustFifthPlaceCorrect() {
        ArrayList<String> results = makeList("a", "b", "c", "d", "e", "f");
        ArrayList<String> prediction = makeList("g", "h", "i", "j", "e", "k");
        int score = makeCalculations(results, prediction);

        assertEquals(18, score);
    }

    @Test
    public void testJustWildcardCorrect() {
        ArrayList<String> results = makeList("a", "b", "c", "d", "e", "f");
        ArrayList<String> prediction = makeList("g", "h", "i", "j", "k", "f");
        int score = makeCalculations(results, prediction);

        assertEquals(26, score);
    }

    @Test
    public void testFirstAndSecondPickedInWrongOrder() {
        ArrayList<String> results = makeList("a", "b", "c", "d", "e", "f");
        ArrayList<String> prediction = makeList("b", "a", "i", "j", "k", "l");
        int score = makeCalculations(results, prediction);

        assertEquals(10, score);
    }

    @Test
    public void testFirstThirdAndFifthPickedInWrongOrder() {
        ArrayList<String> results = makeList("Tomac", "Musquin", "Baggett",
                "Craig", "Anderson", "Bloss");
        ArrayList<String> prediction = makeList("Baggett", "Tomac", "Anderson",
                "Wrong", "Wrong", "Wrong");
        int score = makeCalculations(results, prediction);

        assertEquals(15, score);
    }

    @Test
    public void testFirstCorrectSecondWrongOrder() {
        ArrayList<String> results = makeList("Tomac", "Musquin", "Baggett",
                "Craig", "Anderson", "Bloss");
        ArrayList<String> prediction = makeList("Tomac", "Wrong", "Wrong",
                "Wrong", "Musquin", "Wrong");
        int score = makeCalculations(results, prediction);

        assertEquals(31, score);
    }

    @Test
    public void testNoPointsGivenForWildCardInTopFive() {
        ArrayList<String> results = makeList("Tomac", "Musquin", "Baggett",
                "Craig", "Anderson", "Bloss");
        ArrayList<String> prediction = makeList("Tomac", "Bloss", "Wrong",
                "Wrong", "Wrong", "Wrong");
        int score = makeCalculations(results, prediction);

        assertEquals(26, score);
    }

    // Tests for checkArrays method //////////////////////////////////////////

    @Test
    public void testCheckArraysWithCorrectSizeArrays() {
        ArrayList<String> results = makeList("Tomac", "Musquin", "Baggett",
                "Craig", "Anderson", "Bloss");
        ArrayList<String> prediction = makeList("Tomac", "Bloss", "Wrong",
                "Wrong", "Wrong", "Wrong");
        Calculator calc = new Calculator();

        boolean result = calc.checkArrays(results, prediction);
        assertEquals(true, result);
    }

    @Test
    public void testCheckArraysWithOneIncorrectSizeArray() {
        ArrayList<String> results = new ArrayList<String>();
        results.add("Tomac");
        results.add("Musquin");
        results.add("Baggett");
        results.add("Craig");
        results.add("Anderson");
        ArrayList<String> prediction = makeList("Tomac", "Bloss", "Wrong",
                "Wrong", "Wrong", "Wrong");
        Calculator calc = new Calculator();

        boolean result = calc.checkArrays(results, prediction);
        assertEquals(false, result);
    }

    @Test
    public void testCheckArraysWithTwoIncorrectSizeArray() {
        ArrayList<String> results = new ArrayList<String>();
        results.add("Tomac");
        results.add("Musquin");
        results.add("Baggett");
        results.add("Craig");
        results.add("Anderson");
        ArrayList<String> prediction = makeList("Tomac", "Bloss", "Wrong",
                "Wrong", "Wrong", "Wrong");
        prediction.add("someOtherGuy");
        Calculator calc = new Calculator();

        boolean result = calc.checkArrays(results, prediction);
        assertEquals(false, result);
    }

}
