package upd.dev.usurtprojecthr.logistic;

public enum PlayerRank {
    TRAINEE("Новичёк"),
    SPECIALIST("Специалист"),
    EXPERT("Эксперт"),
    PROFESSIONAL("Профи"),
    DEPARTMENT_HEAD("ОТЕЦ");

    private final String rank;
    PlayerRank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }
}
