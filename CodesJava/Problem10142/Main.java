import java.util.*;
import java.io.*;

class Main {

    private static int totalVotes = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(input.readLine());
        input.readLine();
        for (int i = 0; i < testCases; i++) {
            totalVotes = 0; 
            int numberOfCandidates = Integer.parseInt(input.readLine());
            String[] candidates = new String[numberOfCandidates + 1];
            int[] candidatesVotes = new int[numberOfCandidates + 1];
            for (int j = 1; j <= numberOfCandidates; j++) {
                candidates[j] = input.readLine();
                candidatesVotes[j] = 0;
            }
            String ballot = input.readLine();
            List<Ballot> ballotsVotes = new ArrayList<Ballot>();
            
            while (ballot != null && !ballot.equals("")) {
                Ballot b = new Ballot(ballot);
                ballotsVotes.add(b);      
                ballot = input.readLine();
                totalVotes++;
            }
            
            countVotes(ballotsVotes, candidatesVotes);
            hasWinner(candidatesVotes);
            /*do {
                countVotes(ballotsVotes, candidatesVotes);
            } while (!hasWinner(candidatesVotes));*/
        }
        input.close();
    }

    private static void countVotes(List<Ballot> ballotVotes, int[] candidatesVotes) {
        
        for (Ballot ballot : ballotVotes) {
            candidatesVotes[ballot.getFirst()]++;
        }
    }

    private static boolean hasWinner(int[] candidatesVotes) {
        
        for (int i = 1; i < candidatesVotes.length; i++) {
            System.out.println(candidatesVotes[i]);
        }
        return true;
    }

    static class Ballot {
    
        private List<Integer> votes;
        
        Ballot (String ballotVotes) {
            votes = new ArrayList<Integer>();
            StringTokenizer st = new StringTokenizer(ballotVotes);
            while (st.hasMoreTokens()) {
                int vote = Integer.parseInt(st.nextToken());
                votes.add(vote);
            }
        }

        void removeVote(int candidate) {
            Integer value = new Integer(candidate);
            this.votes.remove(value);
        }

        int getFirst() {
            return votes.get(0);    
        }
    }
}
