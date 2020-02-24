package tournament;

import java.util.ArrayList;

public class Tournament {
    private static Tournament instance = new Tournament();

    private ArrayList<Fighter> qualifiers = new ArrayList<>();
    private ArrayList<Match> matches = new ArrayList<>();

    private Match currentMatch;
    private String bracket = "null?";
    private Fighter winner;

    private Tournament() {
    }

    public static Tournament getInstance() {
        return instance;
    }

    void fillRounds(ArrayList<Fighter> fighters) {
        for (int i = 0; i < fighters.size(); i += 2) {
            matches.add(new Match(fighters.get(i), fighters.get(i + 1)));
        }
        setBracketString();
    }

    void startNextMatch(){
        currentMatch = matches.get(0);
        currentMatch.getRecap().setBracket(bracket);
        currentMatch.startCombat();
    }

    void matchEnded(Fighter winner){
        this.winner = winner;

        // Prints winner
        View.printMatchWinner(winner);

        // Sets winner as qualifier for next tier match
        qualifiers.add(winner);
        // Removes the match played
        matches.remove(0);

        // Ends the tier(eg. Quarter-Finals) if all matches in tier been played
        if (getMatchesLeft() != 0) {
            Menu.brackets();
        } else {
            endBracket();
        }
    }

    // Ends curernt tier
    private void endBracket(){

        // Checks if Finals been played and ends tournament, else returns to menu
        if (bracket.equalsIgnoreCase("finals")) {
            endTournament();
        } else {
            View.printBracketEnded(bracket);
            fillRounds(qualifiers);
            qualifiers.clear();
            Menu.brackets();
        }
    }

    private void endTournament() {
        ScoreBoard.setTournamentWinner(winner);

        View.printEndOfTournament(winner.getName());
        Menu.endOfTournament();
    }

    public String getBracket() {
        return bracket;
    }

    void setBracketString() {
        try {
            switch (matches.size()) {
                case 1:
                    bracket = "Finals";
                    break;
                case 2:
                    bracket = "Semi-Finals";
                    break;
                case 4:
                    bracket = "Quarter-Finals";
                    break;
                case 8:
                    bracket = "Octo-Finals";
                    break;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("getTournamentRound");
            e.printStackTrace();
        }
    }

    int getMatchesLeft() {
        return matches.size();
    }
}
