public interface GameBoardInterface {
    public GamePiece movePiece(String from, String to);

    public GamePiece getPieceFromBoard(String pos);

    public boolean isPositionValid(String pos);

    public int[] getPositionFromString(String pos);

    public void print();

}
