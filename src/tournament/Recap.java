package tournament;

import java.util.ArrayList;

class Recap {
    private Fighter contender;
    private Fighter opponent;
    private ArrayList<String> recap;
    private Fighter winner;
    private String bracket;

    Recap() {
        this.recap = new ArrayList<>();
    }

    void setBracket(String bracket) {
        this.bracket = bracket;
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

    String getBracket() {
        return bracket;
    }

    Fighter getContender() {
        return contender;
    }

    Fighter getOpponent() {
        return opponent;
    }

    ArrayList<String> getRecap() {
        return recap;
    }
}
