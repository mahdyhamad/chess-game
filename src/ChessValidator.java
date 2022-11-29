public class ChessValidator extends ChessMoveValidator {
    static ChessMoveValidator getMoveValidator(){
        return new ChessMoveValidator();
    }

    static boolean checkmateFound(GameBoard board){
        // TODO: implement functionality
        return false;
    }

    static boolean cannotEscapeCheckmate(GameBoard board, PieceColor color){
        return false;
    }


}
