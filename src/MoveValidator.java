public interface MoveValidator {
    boolean validate(GameBoard board, GamePiece piece, String from, String to);
}
