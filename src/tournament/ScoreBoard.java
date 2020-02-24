package tournament;

import java.util.ArrayList;

class ScoreBoard {
    private static ArrayList<Recap> recapList = new ArrayList<>();
    private static Fighter tournamentWinner;

    public static Fighter getTournamentWinner() {
        return tournamentWinner;
    }

    public static void setTournamentWinner(Fighter tournamentWinner) {
        ScoreBoard.tournamentWinner = tournamentWinner;
    }

    public static void addRecap(Recap recap) {
        recapList.add(recap);
    }

    public static ArrayList<Recap> getRecapList() {
        return recapList;
    }
}
