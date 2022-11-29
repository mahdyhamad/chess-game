public class ChessPieceSymbolFactory {
    private static final int whiteKing = 2654;
    private static final int blackKing = 0x265A;

    public static char getSymbol(ChessPiece piece) {
        if (piece.getColor() == PieceColor.WHITE) {
            return (char) (getUnicodeForPieceType(piece.getType(), PieceColor.WHITE));
        } else {
            return (char) (getUnicodeForPieceType(piece.getType(), PieceColor.BLACK));
        }
    }

    public static int getUnicodeForPieceType(PieceType type, PieceColor color){
        int unicode = 0x0000;

        if (type == PieceType.KING)
            unicode = 0x2654;
        else if (type == PieceType.QUEEN)
            unicode = 0x2655;
        else if (type == PieceType.ROOK)
            unicode = 0x2656;
        else if (type == PieceType.BISHOP)
            unicode = 0x2657;
        else if (type == PieceType.KNIGHT)
            unicode = 0x2658;
        else if (type == PieceType.PAWN)
            unicode = 0x2659;

        if (color == PieceColor.WHITE)
            unicode += 6;

        return unicode;

    }
}