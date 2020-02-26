package tournament;

class Match {
    private Actions contenderActions;
    private Actions opponentActions;
    private Fighter contender;
    private Fighter opponent;
    private Tournament tournament;
    private volatile Recap recap;

    private int currentRound = 1;
    private int contenderRoundsWon = 0;

    Match(Fighter contender, Fighter opponent) {
        this.recap = new Recap();
        this.tournament = Tournament.getInstance();
        this.opponent = opponent;
        this.contender = contender;

        recap.setContender(contender);
        recap.setOpponent(opponent);
    }

    void startCombat() {
        View.printCurrentRound(currentRound, this);

        contenderActions = new Actions(contender, opponent, this);
        opponentActions = new Actions(opponent, contender, this);

        contenderActions.setOpponentsActions(opponentActions);
        opponentActions.setOpponentsActions(contenderActions);

        opponentActions.start();
        contenderActions.start();

        try {
            contenderActions.join();
            opponentActions.join();
        } catch (InterruptedException e) {
            System.out.println("Joining error");
            e.printStackTrace();
        }
        endRound();
    }

    void endRound() {
        currentRound++;

        if (contender.getHealth() > 0) {
            View.printRoundWinner(contender);
            contenderRoundsWon++;
        } else if (opponent.getHealth() > 0) {
            View.printRoundWinner(opponent);
        }

        resetHealth();

        if (currentRound <= 3) {                    // Runs the fight again until three rounds played
            Menu.rounds(this);
        } else {
            Fighter winner;
            if (contenderRoundsWon >= 2) {          // Checks for winning fighter and sends winner back to tournament
                winner = contender;
            } else {
                winner = opponent;
            }
            recap.setWinner(winner);                // Adds winner to Recap
            ScoreBoard.addRecap(recap);
            tournament.matchEnded(winner);
        }
    }

    private void resetHealth() {
        contender.resetHealth(100);
        opponent.resetHealth(100);
    }

    Recap getRecap() {
        return recap;
    }

    int getCurrentRound() {
        return currentRound;
    }

    Fighter getContender() {
        return contender;
    }

    Fighter getOpponent() {
        return opponent;
    }
}

