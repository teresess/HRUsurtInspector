package upd.dev.usurtprojecthr.logistic;

public enum GameMode {
    CAREER("Карьера"),
    TIME_ATTACK("На время"),
    RANDOM_CASES("Случайные задания"),
    COMPETITIVE("Кооператив");


    private final String mode;
    GameMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }
}
