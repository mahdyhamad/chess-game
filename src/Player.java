public class Player {

    private final PieceColor color;
    private final String name;

    public static Player create(PieceColor color, String name){
        return new Player(color, name);
    }

    Player(PieceColor color, String name){
        this.color = color;
        this.name = name;
    }

    public PieceColor getColor() {
        return color;
    }
    public String getName() {
        return name;
    }

}
