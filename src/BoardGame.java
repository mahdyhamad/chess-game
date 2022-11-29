import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoardGame implements BoardGameInterface {
    final static int MAX_NUMBER_OF_PLAYERS = 2;
    protected boolean gameOver;
    protected int moves;

    protected Player[] players;

    @Override
    public boolean isDone() {
        return gameOver;
    }

    @Override
    public String readMoveFromConsole() throws IOException {
        System.out.println("Please enter your move");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String from = reader.readLine();
        String to = reader.readLine();
        return from + " " + to;
    }

    public void incrementMoves(){ moves++; }

    public void decrementMoves(){ moves--; }


    public void printGameIntro(){}

    @Override
    public Player getWinner() {
        return null;
    }

    @Override
    public void play(Player player, String from, String to) {

    }

    @Override
    public Player getPlayerTurn(){
        return null;
    }
}
