public class ChessMoveValidator implements MoveValidator {

    private final ChessAllowedMoves[] pawnAllowedMoves = {
        ChessAllowedMoves.CAN_MOVE_ONE_STEP,
        ChessAllowedMoves.CAN_MOVE_TWO_STEPS,
        ChessAllowedMoves.CAN_MOVE_FORWARD,
    };

    private final ChessAllowedMoves[] kingAllowedMoves = {
        ChessAllowedMoves.SHOULD_MOVE_TO_SAFE_POSITION, // required
        ChessAllowedMoves.CAN_MOVE_DIAGONALLY,
        ChessAllowedMoves.CAN_MOVE_VERTICALLY,
        ChessAllowedMoves.CAN_MOVE_HORIZONTALLY,
        ChessAllowedMoves.CAN_MOVE_ONE_STEP,
    };

    private final ChessAllowedMoves[] queenAllowedMoves = {
        ChessAllowedMoves.CAN_MOVE_DIAGONALLY,
        ChessAllowedMoves.CAN_MOVE_VERTICALLY,
        ChessAllowedMoves.CAN_MOVE_HORIZONTALLY,
    };

    private final ChessAllowedMoves[] rookAllowedMoves = {
        ChessAllowedMoves.CAN_MOVE_VERTICALLY,
        ChessAllowedMoves.CAN_MOVE_HORIZONTALLY,
    };

    private final ChessAllowedMoves[] bishopAllowedMoves = {
        ChessAllowedMoves.CAN_MOVE_DIAGONALLY,
    };

    private final ChessAllowedMoves[] knightAllowedMoves = {
        ChessAllowedMoves.CAN_JUMP,
        ChessAllowedMoves.CAN_MOVE_L_SHAPE,
    };

    @Override
    public boolean validate(GameBoard board, GamePiece piece, String from, String to) {

        ChessAllowedMoves[] allowedMoves = getAllowedMovesForType(piece.getType());
        assert allowedMoves != null;
        for (ChessAllowedMoves allowedMove : allowedMoves) {
            if (allowedMove.validate(board, piece, from, to))
                return true;
        }
        return false;
    }

    private ChessAllowedMoves[] getAllowedMovesForType(PieceType type){
        switch(type) {
            case PAWN:
                return this.pawnAllowedMoves;
            case KING:
                return this.kingAllowedMoves;
            case QUEEN:
                return this.queenAllowedMoves;
            case ROOK:
                return this.rookAllowedMoves;
            case BISHOP:
                return this.bishopAllowedMoves;
            case KNIGHT:
                return this.knightAllowedMoves;
            default:
                return null;
        }
    }


}
