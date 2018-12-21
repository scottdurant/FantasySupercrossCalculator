import java.util.ArrayList;
import java.util.Scanner;

/*
 * TODO: Make sure no points are added if the wildcard places in the top 5 Get
 * user input/make menu system Throw exception if arrays are incorrectly sized
 */

public class Calculator {

    private int score;

    public Calculator() {
        this.score = 0;
    }

    public int calculateScore(ArrayList<String> results,
            ArrayList<String> prediction) {

        if (!checkArrays(prediction, results)) {
            System.out.println("Incorrect sized arrays!");
            return 0;
        }

        // check wildcards
        String wildCardResult = results.get(5);
        String wildCardPrediction = prediction.get(5);

        if (wildCardResult.equals(wildCardPrediction)) {
            score += 26;
        }

        // remove wildcards so we don't have to worry about them any more

        results.remove(5);
        prediction.remove(5);

        // check for exact matches (don't look at wildcard)
        for (int i = 0; i < 5; i++) {
            // if there's a match, check what position it is
            if (results.get(i).equals(prediction.get(i))) {
                if (i == 0) {
                    score += 26;
                }
                if (i == 1) {
                    score += 23;
                }
                if (i == 2) {
                    score += 21;
                }
                if (i == 3) {
                    score += 19;
                }
                if (i == 4) {
                    score += 18;
                }
            }
            else {
                // if the rider was picked, but the position was incorrect, add
                // 5
                if (results.contains(prediction.get(i))) {
                    score += 5;
                }
            }
        }

        return score;
    }

    /*
     * Checks if both the results and prediction array have a length of 6 ( top
     * five riders + wild card)
     */
    public boolean checkArrays(ArrayList<String> prediction,
            ArrayList<String> result) {
        if (prediction.size() != 6) {
            return false;
        }

        if (result.size() != 6) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Fantasy Supercross Calculator!");

        ArrayList<String> results = new ArrayList<String>();
        ArrayList<String> predictions = new ArrayList<String>();

        System.out.println("Welcome to the Fantasy Supercross Calculator!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your predictions (Top 5 riders followed by wildcard)");
        for (int i = 0; i < 6; i++) {
            String rider = scanner.nextLine();
            results.add(rider);
            System.out.println("Adding " + rider + "...");
        }
        
        System.out.println("Enter the results from the race (Top 5 riders followed by wildcard)");
        for (int i = 0; i < 6; i++) {
            String rider = scanner.nextLine();
            predictions.add(rider);
            System.out.println("Adding " + rider + "...");
        }
        
        scanner.close();
        
        System.out.println("Predictions: " + predictions);
        System.out.println("Results:     " + results);
        
        Calculator c = new Calculator();
        c.calculateScore(results, predictions);
        
        
        System.out.println("Your score is: " + c.score);

        
        System.out.println("Exiting...");

    }

}
