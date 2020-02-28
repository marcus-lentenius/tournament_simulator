package tournament;

import java.util.ArrayList;
import java.util.Scanner;

class Menu {
    private static String input;
    private static Scanner scanner = new Scanner(System.in);

    private static Tournament tournament = Tournament.getInstance();
    private static ArrayList<Fighter> fighters = Roster.getFighters();

    static void main() {
        Roster.shuffleRoster();
        tournament.fillRounds(fighters);

        do {
            View.printMainMenu();

            input = scanner.nextLine();

            switch (input) {
                case "1":
                    brackets();
                    break;
                case "2":
                    System.out.println("Exit");
                case "3":
                    View.printFighterStats();
                    break;
                default:
                    System.out.println("Try again");
            }
        } while (!input.equalsIgnoreCase("2"));
    }

    static void brackets() {
        // Prints current bracket and matches left

        do {
            View.printBracketMenu();

            input = scanner.nextLine();

            switch (input) {
                case "1":
                    tournament.startNextMatch();
                    break;
                case "2":
                    View.printTournamentStatus();
                    break;
                case "3":
                    System.exit(0);
                default:
                    View.tryAgain();
            }
        } while (!input.equalsIgnoreCase("3"));
    }

    static void rounds(Match match) {
        View.printRoundMenu(match.getCurrentRound());

        input = scanner.nextLine();

        match.startCombat();
    }

    static void endOfTournament() {
        do {
            View.printEndOfTournamentMenu();

            input = scanner.nextLine();

            switch (input) {
                case "1":
                    View.printTournamentWinner();
                    break;
                case "2":
                    View.printBracketResults();
                    break;
                case "3":
                    recapMenu();
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    View.tryAgain();
            }
        } while (!input.equalsIgnoreCase("4"));
    }

    static void recapMenu() {
        do {
            View.printRecapMenu();

            input = scanner.nextLine();

            switch (input) {
                case "1":
                    View.recapMenuEnterContender();
                    String contender = scanner.nextLine();
                    View.recapMenuEnterOpponent();
                    String opponent = scanner.nextLine();
                    View.printMatchRecap(contender, opponent);
                    break;
                case "2":
                    endOfTournament();
                    break;
                default:
                    View.tryAgain();
            }
        } while (!input.equalsIgnoreCase("2"));
    }
}
