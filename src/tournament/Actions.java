package tournament;

import java.util.Random;

class Actions extends Thread {
    private Match match;
    private Fighter contender;
    private Fighter opponent;
    private Actions opponentsActions;

    private boolean blocking = false;
    private boolean dodging = false;

    private Random cooldownTimer = new Random();

    Actions(Fighter contender, Fighter opponent, Match match) {
        this.match = match;
        this.contender = contender;
        this.opponent = opponent;
    }

    @Override
    public void run() {
        sleepTimer(randomNumber(40, 60), "Start of thread Actions.run()"); // Game start contender reaction time

        while (opponent.getHealth() > 0 && contender.getHealth() > 0) {
            int choiceOfAction = randomNumber(1, 6);
            if (choiceOfAction <= 4) {
                attack();
            } else if (choiceOfAction == 5) {
                block();
            } else if (choiceOfAction == 6) {
                dodge();
            }
            sleepTimer(randomNumber(140, 200), "Post action, Actions.run()"); // Action cooldown
        }
    }

    void attack() {
        if (opponentsActions.isBlocking()) {
            opponent.doDamage(contender.getPower() - opponent.getBlockValue());

            View.printActionBlock(contender.getName(),
                    contender.getPower(),
                    opponent.getName(),
                    opponent.getBlockValue(),
                    match);

        } else if (opponentsActions.isDodging()) {
            View.printActionDodge(contender.getName(),
                    opponent.getName(),
                    match);
        } else {
            opponent.doDamage(contender.getPower());
            View.printActionAttack(contender.getName(), contender.getPower(), opponent.getName(), opponent.getHealth(), match);
        }
    }

    void block() {
        blocking = true;
        sleepTimer(250, "From Actions.block()");
        blocking = false;
    }

    void dodge() {
        dodging = true;
        sleepTimer(150, "From Actions.dodge()");
        dodging = false;
    }

    int randomNumber(int min, int max) {
        return cooldownTimer.nextInt((max - min) + 1) + min;
    }

    boolean isBlocking() {
        return blocking;
    }

    boolean isDodging() {
        return dodging;
    }

    void setOpponentsActions(Actions opponentsActions) {
        this.opponentsActions = opponentsActions;
    }

    void sleepTimer(int time, String placeOfError) {
        try {
            sleep(time);
        } catch (InterruptedException e) {
            System.out.println(placeOfError);
        }
    }
}
