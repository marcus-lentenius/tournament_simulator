package tournament;

import java.util.ArrayList;

public class Roster {
    private static Roster instance = new Roster();
    private static ArrayList<Fighter> fighters = new ArrayList<>();

    private Roster() {
    }

    public static Roster getInstance() {
        return instance;
    }

    void addFighter(Fighter fighter) {
        fighters.add(fighter);
    }

    static ArrayList<Fighter> getFighters() {
        return fighters;
    }
}
