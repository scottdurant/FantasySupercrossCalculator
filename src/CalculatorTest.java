

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CalculatorTest {
    
    Calculator calculator;

    @Test
    public void testAllCorrect() {
        ArrayList<String> raceResults = new ArrayList<String>();
        ArrayList<String> prediction = new ArrayList<String>();
        calculator = new Calculator();
        int score = Calculator.calculateScore(raceResults, prediction);
        
        assertEquals(raceResults, prediction);
    }
    
    

}
