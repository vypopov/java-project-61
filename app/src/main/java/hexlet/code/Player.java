package hexlet.code;

public final class Player {
    private String name;

    public Player(String playerName) {
        this.name = playerName;
    }
    public String getName() {
        return name;
    }
    public void setName(String playerName) {
        this.name = playerName;
    }
}
