package pieces;


import color.Color;
import players.Player;
import squares.Square;
import tools.Calculate;
import tools.Find;

public abstract class Piece implements Cloneable{
    protected String type;
    protected Color color;
    protected String position;

    public void setPosition(String pos){
        position = pos;
        Square distSquare = Find.getSquareFromPos(pos);
        distSquare.makeNotEmpty();
    }
    public String getType(){
        return type;
    }
    public Color getColor(){
        return color;
    }
    public String getPosition(){
        return position;
    }

    public int[] getColumnRow(String pos){
        int[] rowColumn = Calculate.getRowColumnFromPos(pos);
        return new int[] {rowColumn[1], rowColumn[0]};
    }

    @Override
    public String toString() {
        return this.color.getColorName() + " " + this.type + " " + "at " + this.position;
    }


    public abstract boolean checkMoveRule(String newPos);

}
