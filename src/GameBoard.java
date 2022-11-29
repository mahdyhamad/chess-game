public class GameBoard implements GameBoardInterface {
    GamePiece[][] gamePieces;

    protected void setPieceOnBoard(GamePiece piece, String pos){
        int[] position = getPositionFromString(pos);
        int row, col;
        row = position[0];
        col = position[1];
        this.gamePieces[row][col] = piece;
    }
    @Override
    public boolean isPositionValid(String pos){
        pos = pos.toLowerCase();
        if (pos.length() != 2)
            return false;
        else return pos.charAt(0) - 'a' + 1 <= 8;
    }
    @Override
    public int[] getPositionFromString(String pos){
        pos = pos.toLowerCase();
        assert isPositionValid(pos): "Invalid Position " + pos;
        int row = (pos.charAt(0) - 'a');
        int col = Character.getNumericValue(pos.charAt(1)) - 1;
        return new int[]{row, col};
    }

    @Override
    public GamePiece getPieceFromBoard(String pos){
        int[] position = getPositionFromString(pos);
        int row, col;
        row = position[0];
        col = position[1];
        return this.gamePieces[row][col];
    }

    @Override
    public GamePiece movePiece(String from, String to){
        GamePiece piece = getPieceFromBoard(from);
        GamePiece eatenPiece = getPieceFromBoard(to);

        setPieceOnBoard(null, from);
        setPieceOnBoard(piece, to);

        return eatenPiece;
    }

    @Override
    public void print(){};
}
