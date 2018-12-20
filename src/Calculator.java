import java.util.ArrayList;

/*
 * TODO: Make sure no points are added if the wildcard places in the top 5
 * Get user input/make menu system
 */


public class Calculator {
    
    private int score;

    public Calculator() {
        this.score = 0;
    }

    public int calculateScore(ArrayList<String> results, ArrayList<String> prediction) {
        for (int i = 0; i < 5; i++) {
            String resultName = results.get(i);
            String predictionName = prediction.get(i);
            // if results contains predictionName, check if exact match. 
            if (results.contains(predictionName)){
                // if the result at i equals the prediction at i, the user has an exact
                // guess, otherwise, it was not an exact guess, so add 5
                if(resultName.equals(predictionName)){
                    if (i == 0 || i == 5) {
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
                } else {
                    score += 5;
                }
            }
            
        }
        
        // check for wild card
        
        if(results.get(results.size()-1).equals(prediction.get(prediction.size()-1))){
            score += 26;
        }
        
        return score;
    }
    
    /*
     * Checks if both the results and prediction array have a length of 6 ( top five
     *  riders + wild card)
     */
    public boolean checkArrays(ArrayList<String> prediction, ArrayList<String> result){
        if(prediction.size() != 6){
            return false;
        }
        
        if(result.size() != 6){
            return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Fantasy Supercross Calculator!");
    }

}
