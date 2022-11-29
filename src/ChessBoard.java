public class ChessBoard extends GameBoard{


    public static ChessBoard create(){
        // static factory method
        return new ChessBoard();
    }

    private ChessBoard(){
        // initialize the board and place black and white pieces

        ChessPiece[][] blackSide = initPieces(PieceColor.BLACK);
        ChessPiece[][] whitSide =  initPieces(PieceColor.WHITE);

        this.gamePieces = new ChessPiece[8][8];

        this.gamePieces[7] = blackSide[1];
        this.gamePieces[6] = blackSide[0];

        this.gamePieces[0] = whitSide[1];
        this.gamePieces[1] = whitSide[0];
    }

    private ChessPiece[][] initPieces(PieceColor pieceColor){
        ChessPiece[] notPawns = new ChessPiece[8];
        ChessPiece[] pawns = new ChessPiece[8];
        for (int i=0; i<8; i++){
            if (i == 0 || i == 7)
                notPawns[i] = ChessPiece.create(pieceColor, PieceType.ROOK);
            else if (i == 1 || i == 6)
                notPawns[i] = ChessPiece.create(pieceColor, PieceType.KNIGHT);
            else if (i == 2 || i == 5)
                notPawns[i] = ChessPiece.create(pieceColor, PieceType.BISHOP);
            else if (i == 3)
                notPawns[i] = ChessPiece.create(pieceColor, PieceType.QUEEN);
            else if (i == 4)
                notPawns[i] = ChessPiece.create(pieceColor, PieceType.KING);
        }
        for (int i=0; i<8; i++){
            pawns[i] = ChessPiece.create(pieceColor, PieceType.PAWN);
        }

        ChessPiece[][] result = {
            pawns, notPawns
        };
        return result;
    }

    public void reverseMove(ChessPieceMoveRecord moveRecord){
        GamePiece movedPiece = getPieceFromBoard(moveRecord.to);
        setPieceOnBoard(movedPiece, moveRecord.from);
        if (moveRecord.eatenPiece != null){
            setPieceOnBoard(moveRecord.eatenPiece, moveRecord.to);
        }
    }

    @Override
    public void print(){
        System.out.print(" *  1  2  3  4  5  6  7  8");
        for(int i = 0 ; i < 8; i++ ) {
            for (int j = 0; j < 8; j++) {
                if (j == 0) {
                    System.out.println();
                    System.out.print("(" + Character.toString((char) (i+65)) + ")");
                }
                if (gamePieces[i][j] == null) {
                    System.out.print("[ ]");
                } else {
                    System.out.print(
                        "["+ ChessPieceSymbolFactory.getSymbol((ChessPiece) gamePieces[i][j]) + "]"
                    );
                }
            }
        }
        System.out.println();
    }


}
