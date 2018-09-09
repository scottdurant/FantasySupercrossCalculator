import java.util.ArrayList;

public class Calculator {
    
    private int score;

    public Calculator() {
        this.score = 0;
    }

    public int calculateScore(ArrayList<String> results, ArrayList<String> prediction) {
        // check for exact guesses
        for (int i = 0; i < results.size(); i++) {
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
                } else{
                    score += 5;
                }
            }
            
            /*
            if (resultName.equals(predictionName)) {
                // @TODO: make an enumerated class for the places compared to
                // points??
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
            }
            */
        }

        return score;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Fantasy Supercross Calculator!");
    }

}
