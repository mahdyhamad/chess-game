public class ChessPieceMoveRecord extends BoardGamePieceMoveRecord {
    public final ChessPiece eatenPiece;

    static ChessPieceMoveRecord create(int id, ChessBoard board, String from, String to, Player player, ChessPiece eatenPiece){
        return new ChessPieceMoveRecord(id, board, from, to, player, eatenPiece);
    }

    ChessPieceMoveRecord(int id, ChessBoard board, String from, String to, Player player, ChessPiece eatenPiece){
        super(id, board, from, to, player);
        this.eatenPiece = eatenPiece;
    }
}
