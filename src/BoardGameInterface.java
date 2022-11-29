
public interface BoardGameInterface extends GameInterface {
    public void play(Player player, String from, String to);
    public Player getPlayerTurn();
};
