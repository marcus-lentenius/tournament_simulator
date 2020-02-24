package tournament;

import java.util.ArrayList;

public class Recap {
    private Fighter contender;
    private Fighter opponent;
    private ArrayList<String> recap;
    private Fighter winner;
    private String round;
    private boolean tournamentWinner = false;

    Recap() {
        this.recap = new ArrayList<>();
    }

    public boolean isTournamentWinner() {
        return tournamentWinner;
    }

    public void setTournamentWinner(boolean tournamentWinner) {
        this.tournamentWinner = tournamentWinner;
    }

    void setBracket(String round) {
        this.round = round;
    }

    void addToRecap(String action) {
        recap.add(action);
    }

    void setContender(Fighter contender) {
        this.contender = contender;
    }

    void setOpponent(Fighter opponent) {
        this.opponent = opponent;
    }

    void setWinner(Fighter winner) {
        this.winner = winner;
    }

    Fighter getWinner() {
        return winner;
    }

    public String getRound() {
        return round;
    }

    void setRound(String round) {
        this.round = round;
    }

    public Fighter getContender() {
        return contender;
    }

    public Fighter getOpponent() {
        return opponent;
    }

    public ArrayList<String> getRecap() {
        return recap;
    }
}
