package pieces.pieces;

import pieces.Piece;
import players.Player;

import java.util.Objects;

public class King extends Piece {
    private boolean check = false;
    public King(Player player, String position){
        this.color = player.getColor();
        setPosition(position);
        this.type = "king";
    }
    public void toggleCheck(){
        check = !check;
    }
    public boolean getCheck(){
        return check;
    }

    @Override
    public boolean checkMoveRule(String newPosition){
        if(Objects.equals(newPosition, position))
            return false;

        int[] currentPos = getColumnRow(position); // {column, row}
        int[] newPos = getColumnRow(newPosition);  // {column, row}
        return Math.abs(currentPos[0] - newPos[0]) <= 1 && Math.abs(currentPos[1] - newPos[1]) <= 1;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof King c)) {

            return false;
        }
        System.out.println("KING EQUAL ::: WE HAVE A KING  WITH COLOR:"+c.color);

        return  color.equals(c.getColor())
                && position.equals(c.getPosition());
    }

}
