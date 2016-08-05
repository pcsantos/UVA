import java.util.*;
import java.io.*;

class Main {

    private static int totalVotes = 0;
    private static List<Candidate> candidates;
    private static List<Candidate> listToRemove;
    private static List<Ballot> ballotsVotes;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(input.readLine());
        input.readLine();
        for (int i = 0; i < testCases; i++) {
            if (i > 0)
                System.out.println();
            totalVotes = 0; 
            candidates = new ArrayList<Candidate>();
            int numberOfCandidates = Integer.parseInt(input.readLine());
            for (int j = 1; j <= numberOfCandidates; j++) {
                String name = input.readLine();
                candidates.add(new Candidate(name, j));
            }
            String ballot = input.readLine();
            ballotsVotes = new ArrayList<Ballot>();
            
            while (ballot != null && !ballot.equals("")) {
                Ballot b = new Ballot(ballot);
                ballotsVotes.add(b);      
                ballot = input.readLine();
                totalVotes++;
            }
            while (true) {
                countVotes();
                if (!verifyWinner()) {
                    removeVotesToCandidatesOut();
                    resetVotes();
                } else 
                    break;
            }
            if (hasOneWinner()) {
                Candidate c = Collections.max(candidates);
                System.out.println(c.getName());
            } else {
                for (Candidate c : candidates) 
                    System.out.println(c.getName());
            }
        }
        input.close();
    }

    private static boolean hasOneWinner() {
        Candidate candidate = Collections.max(candidates);
        Candidate candidate2 = Collections.min(candidates);
        if (candidate.getVotes() == candidate2.getVotes())
            return false;
        return true;
    }
    
    private static void removeVotesToCandidatesOut() {
        for (Candidate c : listToRemove) {
            int number = c.getNumber();
            for (Ballot b : ballotsVotes) {
                b.removeVote(number);
            }
        }
    }

    private static void resetVotes() {
        for (Candidate c : candidates) {
            c.clearVotes();
        } 
    }
    private static void countVotes() {
        for (Ballot ballot : ballotsVotes) {
            int vote = ballot.getFirst();
            for (Candidate c : candidates) {
                if (c.getNumber() == vote) {
                    c.addVote();
                    break;
                }
            }
        }
    }

    private static boolean verifyWinner() {
        if (!hasOneWinner())
            return true;
        Candidate candidate = Collections.max(candidates);
        float percent = (float) candidate.getVotes() / totalVotes;
        if (percent <= 0.5) {
            removeCandidatesWithLessVotes();
            return false;
        }
        return true;
    }
    
    private static void removeCandidatesWithLessVotes() {
        listToRemove = new ArrayList<>();
        Candidate candidate = Collections.min(candidates);
        int lessVotes = candidate.getVotes();
        for (Candidate c : candidates) {
            if (c.getVotes() == lessVotes)
                listToRemove.add(c);
        }
        for (Candidate c : listToRemove) {
            candidates.remove(c);
        }
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
    }


    static class Candidate implements Comparable<Candidate> {
        
        private String name;
        private int number;
        private int votes;       
        
        Candidate(String name, int number) {
            this.name = name;
            this.number = number;
            this.votes = 0;
        }
        
        String getName() {
            return this.name;
        }

        void addVote() {
            this.votes++;
        }

        void clearVotes() {
            this.votes = 0;
        }

        int getVotes() {
            return this.votes;
        }

        int getNumber () {
            return this.number;
        }

        public int compareTo(Candidate another) {
            if (this.votes < another.getVotes())
                return -1;
            if (this.votes > another.getVotes())
                return 1;
            return 0;
        }
    }
}
