package tournament;

enum Brackets {
    FINALS("Finals"),
    SEMIFINALS("Semi-Finals"),
    QUARTERFINALS("Quarter-Finals");

    private String s;

    Brackets(String s) {
        this.s = s;
    }

    String getBracket() {
        return s;
    }
}
