public class BoardGamePieceMoveRecord implements PieceMoveRecord{
    public final int id;
    public final String from;
    public final String to;
    private final GameBoard board;
    public final Player player;

    static BoardGamePieceMoveRecord create(int id, GameBoard board, String from, String to, Player player){
        return new BoardGamePieceMoveRecord(id, board, from, to, player);
    }
    BoardGamePieceMoveRecord(int id, GameBoard board, String from, String to, Player player){
        this.id = id;
        this.board = board;
        this.from = from;
        this.to = to;
        this.player = player;
    }
}
