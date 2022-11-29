public class ChessPiece implements GamePiece {

    public PieceType type;
    public PieceColor color;

    public static ChessPiece create(PieceColor color, PieceType type){
        return new ChessPiece(color, type);
    }

    private ChessPiece(PieceColor color, PieceType type){
        this.type = type;
        this.color = color;
    }

    @Override
    public PieceType getType(){
        return this.type;
    }

    @Override
    public PieceColor getColor() {
        return color;
    }
}
