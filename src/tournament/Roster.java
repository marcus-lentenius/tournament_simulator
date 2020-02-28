package tournament;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Roster {
    private static Roster instance = new Roster();
    private static ArrayList<Fighter> fighters = new ArrayList<>();

    private Roster() {
    }

    public static Roster getInstance() {
        return instance;
    }

    public static void shuffleRoster() {
        Collections.shuffle(fighters);
    }

    void addFighter(Fighter fighter) {
        fighters.add(fighter);
    }

    static ArrayList<Fighter> getFighters() {
        return fighters;
    }
}
