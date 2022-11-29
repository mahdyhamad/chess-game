import java.io.IOException;

public interface GameInterface {
    public boolean isDone();
    public String readMoveFromConsole() throws IOException;
    public void printGameIntro();

    public Player getWinner();
}
