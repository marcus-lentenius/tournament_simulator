package tournament;

public abstract class Fighter {
    private String name;
    private int health;
    private int power;
    private int blockValue;
    private String quote;
    private Roster roster = Roster.getInstance();

    public Fighter(String name, int health, int power, int blockValue, String quote) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.blockValue = blockValue;
        this.quote = quote;
        roster.addFighter(this);
    }

    String getName() {
        return name;
    }

    int getPower() {
        return power;
    }

    int getHealth() {
        return health;
    }

    void doDamage(int damage) {
        if (this.health - damage < 0) {
            this.health = 0;
        } else {
            this.health -= damage;
        }
    }

    int getBlockValue() {
        return blockValue;
    }

    String getQuote() {
        return quote;
    }

    void resetHealth(int health) {
        this.health = health;
    }
}