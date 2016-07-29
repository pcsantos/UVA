import java.io.*;
import java.util.*;

class Main {
        
    private static final int NUMBER_MAX_OF_GUESSES = 7;

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String in;
        while(!(in = input.readLine()).equals("-1")) {
            int round = Integer.parseInt(in);
            String answer = input.readLine();
            String guesses = input.readLine();
            String output = getOutput(answer, guesses);
            System.out.println("Round " + round);
            System.out.println(output);
        }

        input.close();
    }

    private static String getOutput(String answer, String guesses) {
    
        Set<String> answerSet = new LinkedHashSet<>();
        for (int i = 0; i < answer.length(); i++) {
            answerSet.add(answer.charAt(i)+"");
        }
        
        Set<String> guessesSet = new LinkedHashSet<>();
        for (int i = 0; i < guesses.length(); i++) {
            guessesSet.add(guesses.charAt(i)+"");
        }

        int guessesCount = 0;
        Iterator<String> it = guessesSet.iterator();

        while(it.hasNext()) {
            String guess = it.next();
            
            boolean flag = false;
            String item = "";
            Iterator<String> it2 = answerSet.iterator();
            while(it2.hasNext()) {
                item = it2.next();
                if(item.equals(guess)) {
                    flag = true;
                    break;
                } 
            }
            if (flag) {
                answerSet.remove(item);
            } else {
                guessesCount++;
            }
            if (guessesCount == NUMBER_MAX_OF_GUESSES)
                return "You lose.";
            if (answerSet.isEmpty())
                return "You win.";
        }
        return "You chickened out.";
    }
}
