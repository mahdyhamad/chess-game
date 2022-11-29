import java.util.Stack;

public class ChessGame extends BoardGame {

    ChessBoard board;
    Stack<ChessPieceMoveRecord> movesHistory;

    public static ChessGame create(String whitePlayer, String blackPlayer){
        // static factory method
        return new ChessGame(whitePlayer, blackPlayer);
    }

    private ChessGame(String whitePlayer, String blackPlayer){
        this.board = ChessBoard.create();
        this.movesHistory = new Stack<>();
        this.gameOver = false;
        this.moves = 0;
        createPlayers(whitePlayer, blackPlayer);

        printGameIntro();
        board.print();
    }

    protected void createPlayers(String whitePlayerName, String blackPlayerName){
        Player whitePlayer = Player.create(PieceColor.WHITE, whitePlayerName);
        Player blackPlayer = Player.create(PieceColor.BLACK, blackPlayerName);
        this.players = new Player[BoardGame.MAX_NUMBER_OF_PLAYERS];
        this.players[0] = whitePlayer;
        this.players[1] = blackPlayer;
    }

    @Override
    public void printGameIntro(){
        System.out.println("Welcome to the chess game!");
        System.out.println("How to play?");
        System.out.println(
            "To move a piece from one location to another, " +
            "write the row character and the column number (ex: A1) as the current position \n" +
            "And on another line, write the target position in the same way"
        );
    }

    private void onPieceMoved(Player player, String from, String to){
        incrementMoves();
        ChessPiece eatenPiece = (ChessPiece) board.movePiece(from, to);
        ChessPieceMoveRecord moveRecord = ChessPieceMoveRecord.create(moves, board, from, to, player, eatenPiece);
        movesHistory.push(moveRecord);
    }

    private void undoLastMove(){
        assert movesHistory.empty();
        ChessPieceMoveRecord lastMoveRecord = movesHistory.pop();
        board.reverseMove(lastMoveRecord);
        lastMoveRecord = null; // to be deleted by the java garbage collector
        decrementMoves();
    }

    @Override
    public void play(Player player, String from, String to){
        boolean successfullyPlayed = false;
        ChessPiece toBeMovedPiece = (ChessPiece) board.getPieceFromBoard(from);
        ChessPiece eatenPiece = (ChessPiece) board.getPieceFromBoard(to);

        // general validation for the move
        // make sure the first move is for the white player
        if (moves == 0 && player.getColor() == PieceColor.BLACK){
            throw new IllegalArgumentException();
        }
        else if (toBeMovedPiece == null){
            throw new RuntimeException("Piece not found at " + from);
        }
        else if (toBeMovedPiece.getColor() != player.getColor()){
            throw new RuntimeException("Can not move piece at " + from);
        } else if (eatenPiece != null && eatenPiece.getColor() == player.getColor()) {
            throw new RuntimeException("Can not eat piece at " + to);
        }

        ChessMoveValidator moveValidator = ChessValidator.getMoveValidator();
        // check for checkmate, and give the player a chance to resolve it
        if(ChessValidator.checkmateFound(board)){
            boolean isMoveValid = moveValidator.validate(board, toBeMovedPiece, from, to);
            if (!isMoveValid){
                throw new RuntimeException("Invalid move");
            }
            onPieceMoved(player, from, to);
            if (ChessValidator.checkmateFound(board)){
                undoLastMove();
                board.print();
                System.out.println("Checkmate is not resolved, please try again");
            }
            else
                successfullyPlayed = true;
        }
        else{
            boolean isMoveValid = moveValidator.validate(board, toBeMovedPiece, from, to);
            if (!isMoveValid){
                throw new RuntimeException("Invalid move");
            }
            onPieceMoved(player, from, to);
            successfullyPlayed = true;
            board.print();
        }

        // check if the game has ended after every successful move
        if (successfullyPlayed){
            PieceColor oppositeColor = player.getColor() == PieceColor.WHITE? PieceColor.BLACK: PieceColor.WHITE;
            if (ChessValidator.cannotEscapeCheckmate(board, oppositeColor)){
                gameOver = true;
            }
        }

    }

    public void playWhite(String move){
        String from, to;
        from = move.split("\\s")[0];
        to = move.split("\\s")[1];
        Player player = getPlayerOfColor(PieceColor.WHITE);
        play(player, from, to);
    }

    public void playBlack(String move){
        String from, to;
        from = move.split("\\s")[0];
        to = move.split("\\s")[1];
        Player player = getPlayerOfColor(PieceColor.BLACK);
        play(player, from, to);
    }

    public Player getPlayerTurn(){
        return getPlayerOfColor(moves%2 == 0? PieceColor.WHITE: PieceColor.BLACK);
    }

    private Player getPlayerOfColor(PieceColor color){
        return color == PieceColor.WHITE? players[0]: players[1];
    }

    public boolean isWhiteTurn(){
        return getPlayerTurn().getColor() == PieceColor.WHITE;
    }

}
