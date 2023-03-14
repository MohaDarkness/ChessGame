package pieces.pieces;

import pieces.Piece;
import players.Player;
import color.colors.*;

public class Pawn extends Piece {
    public Pawn(Player player, String position){
        this.color = player.getColor();
        setPosition(position);
        this.type = "pawn";
    }

    @Override
    public boolean checkMoveRule(String newPosition){
        if(newPosition.equals(position))
            return false;

        int[] currentPos = getColumnRow(position); // {column, row}
        int[] newPos = getColumnRow(newPosition);  // {column, row}

        if(color instanceof White){
            if(currentPos[1] == 1)
                if(newPos[1] == currentPos[1]+2)
                    return Math.abs(currentPos[0] - newPos[0]) == 0;

            if(newPos[1] == currentPos[1]+1)
                return Math.abs(currentPos[0] - newPos[0]) <= 1;
        }


        if(color instanceof Black){
            if(currentPos[1] == 6)
                if(newPos[1] == currentPos[1]-2)
                    return Math.abs(currentPos[0] - newPos[0]) == 0;

            if(newPos[1] == currentPos[1]-1)
                return Math.abs(currentPos[0] - newPos[0]) <= 1;
        }

        return false;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Pawn c)) {
            return false;
        }

        return  color.equals(c.getColor())
                && position.equals(c.getPosition());
    }

}
