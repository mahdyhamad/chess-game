public enum ChessAllowedMoves implements MoveValidator {
    CAN_MOVE_ONE_STEP,
    CAN_MOVE_TWO_STEPS,
    CAN_MOVE_FORWARD,
    CAN_MOVE_HORIZONTALLY,
    CAN_MOVE_VERTICALLY,
    CAN_MOVE_DIAGONALLY,
    CAN_MOVE_L_SHAPE,
    CAN_JUMP,
    SHOULD_MOVE_TO_SAFE_POSITION;

    @Override
    public boolean validate(GameBoard board, GamePiece piece, String from, String to) {
        boolean valid = false;
        switch (valueOf(name())){
            case CAN_MOVE_ONE_STEP:
                valid = isValidOneStepMove(board, piece, from, to);
            case CAN_MOVE_TWO_STEPS:
                valid = isValidTwoStepMove(board, piece, from, to);
            case CAN_MOVE_FORWARD:
                valid = isValidForwardMove(board, piece, from, to);
            case CAN_MOVE_HORIZONTALLY:
                valid = isValidHorizontalMove(board, piece, from, to);
            case CAN_MOVE_VERTICALLY:
                valid = isValidVerticalMove(board, piece, from, to);
            case CAN_MOVE_DIAGONALLY:
                valid = isValidDiagonalMove(board, piece, from, to);
            case CAN_MOVE_L_SHAPE:
                valid = isValidLShapeMove(board, piece, from, to);
            case CAN_JUMP:
                valid = isValidJumpMove(board, piece, from, to);
            case SHOULD_MOVE_TO_SAFE_POSITION:
                valid = isSafePositionMove(board, piece, from, to);
        }

        if(!valid && name().startsWith("SHOULD")){
            throw new RuntimeException("Invalid");
        }
        return valid;
    }

    private boolean isValidOneStepMove(GameBoard board, GamePiece piece, String from, String to){
        return true;
    }
    private boolean isValidTwoStepMove(GameBoard board, GamePiece piece, String from, String to){
        return true;
    }
    private boolean isValidForwardMove(GameBoard board, GamePiece piece, String from, String to){
        return true;
    }
    private boolean isValidHorizontalMove(GameBoard board, GamePiece piece, String from, String to){
        return true;
    }
    private boolean isValidVerticalMove(GameBoard board, GamePiece piece, String from, String to){
        return true;
    }
    private boolean isValidDiagonalMove(GameBoard board, GamePiece piece, String from, String to){
        return true;
    }
    private boolean isValidLShapeMove(GameBoard board, GamePiece piece, String from, String to){
        return true;
    }
    private boolean isValidJumpMove(GameBoard board, GamePiece piece, String from, String to){
        return true;
    }
    private boolean isSafePositionMove(GameBoard board, GamePiece piece, String from, String to){
        return true;
    }
}
