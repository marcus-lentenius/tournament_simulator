package tournament;

import java.util.ArrayList;

class ScoreBoard {
    private static ArrayList<Recap> recapList = new ArrayList<>();

    private static Fighter tournamentWinner;

    static Fighter getTournamentWinner() {
        return tournamentWinner;
    }

    static void setTournamentWinner(Fighter tournamentWinner) {
        ScoreBoard.tournamentWinner = tournamentWinner;
    }

    static void addRecap(Recap recap) {
        recapList.add(recap);
    }

    static ArrayList<Recap> getRecapList() {
        return recapList;
    }
}
