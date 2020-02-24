package tournament;

public class View {
    private static String addToRecap;

    // Round printouts

    static void printRoundWinner(Fighter fighter) {
        System.out.println("-------------------------------------------------------------");
        System.out.println(fighter.getName() + " wins the round and shouts \"" + fighter.getQuote() + "\n");
    }

    static void printCurrentRound(int round, Match match) {
        String printRound = "Round " + round + " begins!";

        match.getRecap().addToRecap(printRound);

        System.out.println(printRound);
    }

    // Bracket printouts

    static void printBracketEnded(String bracket) {
        System.out.println(bracket + " ended");
    }


    // Menu printouts

    static void printBracketMenu(String bracket, int matchesLeft) {
        System.out.println(bracket + "\n" +
                "Matches left: " + matchesLeft + "\n" +
                "1. Start next match\n" +
                "2. Quit");
    }

    static void printRoundMenu(int round) {
        System.out.print("Press Enter to start round " + round);
    }

    static void printMainMenu() {
        System.out.println("Main menu\n" +
                "1. Start tournament\n" +
                "2. Quit\n" +
                "3. Show fighters");
    }


    static void printRecapMenu() {
        System.out.println("Recap menu\n" +
                "1. Enter the name of the fighters\n" +
                "2. Back");
    }

    // Action printouts

    static void printActionAttack(String contenderName, int contenderPower, String opponentName, int opponentHealth, Match match) {
        addToRecap = String.format("%-7s punches %-7s with a power of %s, %-7s health remaining = %s",
                contenderName, opponentName, contenderPower, opponentName, opponentHealth);

        match.getRecap().addToRecap(addToRecap);
        System.out.println(addToRecap);
    }

    static void printActionDodge(String contenderName, String opponentName, Match match) {
        addToRecap = String.format("%-7s punches but %s dodged",
                contenderName, opponentName);

        match.getRecap().addToRecap(addToRecap);
        System.out.println(addToRecap);
    }

    static void printActionBlock(String contenderName, int contenderPower, String opponentName, int opponentBlockValue, Match match) {
        addToRecap = String.format("%-7s punches %s with %-7d damage, %-7s blocks and mitigates %-7d of the damage",
                contenderName, opponentName, contenderPower, opponentName, opponentBlockValue);

        match.getRecap().addToRecap(addToRecap);

        System.out.println(addToRecap);
    }

    // Recap printouts
    public static void printMatchRecap(String contender, String opponent) {
        ScoreBoard.getRecapList().stream()
                .filter(recap -> recap.getContender().getName().equalsIgnoreCase(contender)
                        && recap.getOpponent().getName().equalsIgnoreCase(opponent))
                .forEach(recap -> recap.getRecap()
                        .forEach(System.out::println));
    }

    public static void recapMenuEnterContender() {
        System.out.println("Enter the name of the contender");
    }

    public static void recapMenuEnterOpponent() {
        System.out.println("Enter the name of the opponent");
    }

    static void printTournamentWinner() {
        System.out.println("Ultimate champion = " + ScoreBoard.getTournamentWinner().getName());
    }

    static void printBracketResults() {

        System.out.println("\nWinners:");

        ScoreBoard.getRecapList().forEach(recap -> System.out.printf("" +
                        "%-20s %-7s vs %-7s | Winner: %s\n",
                recap.getRound(),
                recap.getContender().getName(),
                recap.getOpponent().getName(),
                recap.getWinner().getName()));
    }

    // Fighter info

    static void printFighterStats() {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s\n",
                "Name:",
                "Health:",
                "Power:",
                "Block:",
                "Quote:");
        Roster.getFighters().forEach(fighter -> {
            System.out.printf("%-10s %-10s %-10s %-10s %-10s\n",
                    fighter.getName(),
                    fighter.getHealth(),
                    fighter.getPower(),
                    fighter.getBlockValue(),
                    fighter.getQuote());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println();
    }

    // Match printouts

    public static void printMatchWinner(Fighter fighter) {
        System.out.println("_________________________________________________________________________");
        System.out.println(fighter.getName() + " wins the match and shouts \"" + fighter.getQuote() + "\n");
    }

    // Tournament printouts

    static void printEndOfTournament(String winner) {
        System.out.println("Ultimate champion = " + winner);
    }

    public static void printEndOfTournamentMenu() {
        System.out.println("Tournament ended\n" +
                "1. Show tournament winner\n" +
                "2. Show bracket results\n" +
                "3. Get a fight recap\n" +
                "4. Exit");
    }

    // Others

    public static void tryAgain() {
        System.out.println("Try again");
    }
}
