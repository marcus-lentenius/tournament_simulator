package tournament;
//FIXME Turnering stats
// - Till exempel vilka kämpar som vann sin sista kamp, ​​och vem kommer de att möta i nästa omgång av turneringen.
// - Visa turnering status före och efter match - X  ROSTER BILD?
// - vilka som är kvar och kommande matcher
//TODO  Unit test - X
public class Main {
    public static void main(String[] args) {
        createFighters();
        Menu.main();
    }

    static void createFighters() {
        new Contender("one", 100, 30, 1, "Hells Yeah");
        new Contender("two", 100, 30, 1, "Hells Yeah");
        new Contender("three", 100, 30, 1, "Hells Yeah");
        new Contender("four", 100, 30, 1, "Hells Yeah");
//        new Contender("five", 100, 233, 10, "Hells Yeah");
//        new Contender("six", 100, 233, 10, "Hells Yeah");
//        new Contender("seven", 100, 233, 10, "Hells Yeah");
//        new Contender("eight", 100, 233, 10, "Hells Yeah");
    }
}

