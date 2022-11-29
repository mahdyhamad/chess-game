// Java program to demonstrate BufferedReader
import java.io.IOException;

public class TestDemo {

    public static void main(String[] args) throws IOException {

        ChessGame game = ChessGame.create("Mahdy", "Mohammad");
        boolean isValidMove = false;

        while (!game.isDone()){
            while (!isValidMove){
                String move = game.readMoveFromConsole();
                try{
                    if (game.isWhiteTurn())
                        game.playWhite(move);
                    else
                        game.playBlack(move);
                    isValidMove = true;
                }
                catch (Exception e){
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Please try again!");
                    isValidMove = false;
                }
            }

            isValidMove = false;

        }
    }
}
