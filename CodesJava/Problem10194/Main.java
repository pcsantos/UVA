import java.util.*;
import java.io.*;

class Main {
    
    private static ArrayList<Team> teams = new ArrayList<>();

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCases; i++) {
	    if (i > 0)
		System.out.println();
            String TournamentName = input.readLine();
            int teamNumber = Integer.parseInt(input.readLine());
            for (int j = 0; j < teamNumber; j++) {
                in = input.readLine();
                Team team = new Team(in);
                teams.add(team);
            }
            int gamesNumber = Integer.parseInt(input.readLine());
            for (int j = 0; j < gamesNumber; j++) {
                in = input.readLine();
                parseGameInformations(in);
            }
            Collections.sort(teams);
            Collections.reverse(teams);
            System.out.println(TournamentName);
            int pos = 1;
            for (Team t : teams) {
                System.out.println((pos++) + ") " + t.getName() + " " + t.getTotalPointsEarned() + "p, " +
                            t.getGamesPlayed() + "g (" + t.getWins() + "-" + t.getTies() +
                            "-" + t.getLosses() + "), " + (t.getGoalsScored() - t.getGoalsAgainst()) +
                            "gd (" + t.getGoalsScored() + "-" + t.getGoalsAgainst() + ")");
            }
            teams.clear();
        }
        input.close();
    }

    private static void parseGameInformations(String in) {
        StringTokenizer st = new StringTokenizer(in, "@");
        String teamA = st.nextToken();
        String teamB = st.nextToken();
        StringTokenizer stTeamA = new StringTokenizer(teamA, "#");
        StringTokenizer stTeamB = new StringTokenizer(teamB, "#");
        
        String teamAName = stTeamA.nextToken();
        int teamAGoals = Integer.parseInt(stTeamA.nextToken());
        
        int teamBGoals = Integer.parseInt(stTeamB.nextToken());
        String teamBName = stTeamB.nextToken();
        
        updateTournamentData(teamAName, teamAGoals, teamBName, teamBGoals);
    }

    private static void updateTournamentData(String tAName, int tAGoals, String tBName, int tBGoals) {
        Team teamA = getTeam(tAName);
        Team teamB = getTeam(tBName);
        if (tAGoals > tBGoals) {
            setPoints(teamA, tAGoals, teamB, tBGoals);
        } else if (tAGoals < tBGoals) {
            setPoints(teamB, tBGoals, teamA, tAGoals); 
        } else {
            teamA.setPointsEarned(1);
            teamA.addGamesPlayed();
            teamA.addTies();
            teamA.setGoalsScored(tAGoals);
            teamA.setGoalsAgainst(tBGoals);
            
            teamB.setPointsEarned(1);
            teamB.addGamesPlayed();
            teamB.addTies();
            teamB.setGoalsScored(tBGoals);
            teamB.setGoalsAgainst(tAGoals);
        }
    
    }

    private static void setPoints(Team winner, int goalsW, Team losser, int goalsL) {
        winner.setPointsEarned(3);
        winner.addGamesPlayed();
        winner.addWins();
        winner.setGoalsScored(goalsW);
        winner.setGoalsAgainst(goalsL);
            
        losser.addGamesPlayed();
        losser.addLosses();
        losser.setGoalsScored(goalsL);
        losser.setGoalsAgainst(goalsW);
    }


    private static Team getTeam(String team) {
        for (Team t : teams)
            if (t.getName().equals(team))
                return t;
        return null;
    }

    static class Team implements Comparable<Team> {
        private String name;
        private int totalPointsEarned;
        private int gamesPlayed;
        private int wins;
        private int ties;
        private int losses;
        private int goalsScored;
        private int goalsAgainst;

        Team(String name) {
            this.name = name;
        }

        String getName() {
            return this.name;
        }

        int getTotalPointsEarned() {
            return this.totalPointsEarned;
        }

        int getGamesPlayed() {
            return this.gamesPlayed;
        }

        int getWins() {
            return this.wins;
        }

        int getTies() {
            return this.ties;
        }

        int getLosses() {
            return this.losses;
        }

        int getGoalsScored() {
            return this.goalsScored;
        }

        int getGoalsAgainst() {
            return this.goalsAgainst;
        }

        void setPointsEarned(int points) {
            this.totalPointsEarned += points;
        }

        void addGamesPlayed() {
            this.gamesPlayed++;
        }

        void addWins() {
            this.wins++;
        }
        
        void addTies() {
            this.ties++;
        }

        void addLosses() {
        this.losses++;
        }
        
        void setGoalsScored(int goals) {
            this.goalsScored += goals;
        }

        void setGoalsAgainst(int goals) {
            this.goalsAgainst += goals;
        }

        public int compareTo(Team another) {
            int i = Integer.compare(this.totalPointsEarned, another.getTotalPointsEarned());
            if (i != 0) return i;
            i = Integer.compare(this.wins, another.getWins());
            if (i != 0) return i;
            int gd = this.goalsScored - this.goalsAgainst;
            int gdAnother = another.getGoalsScored() - another.getGoalsAgainst();
            i = Integer.compare(gd, gdAnother);
            if (i != 0) return i;
            i = Integer.compare(this.goalsScored, another.getGoalsScored());
            if (i != 0) return i;
            if (this.gamesPlayed > another.getGamesPlayed())
                return -1;
            if (this.gamesPlayed < another.getGamesPlayed())
                return 1;
            if (this.name.compareTo(another.getName()) > 0)
                return -1;
            if (this.name.compareTo(another.getName()) < 0)
                return 1;
            return 0;
        }
    }
}
