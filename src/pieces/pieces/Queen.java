package pieces.pieces;

import pieces.Piece;
import players.Player;

public class Queen extends Piece {
    public Queen(Player player, String position){
        this.color = player.getColor();
        setPosition(position);
        this.type = "queen";
    }

    @Override
    public boolean checkMoveRule(String newPosition){
        if(newPosition == position)
            return false;

        int[] currentPos = getColumnRow(position); // {column, row}
        int[] newPos = getColumnRow(newPosition);  // {column, row}

        if(currentPos[0] - newPos[0] == 0 || currentPos[1] - newPos[1] == 0) //if straight line
            return true;

        return Math.abs(currentPos[0] - newPos[0]) == Math.abs(currentPos[1] - newPos[1]); //if diagonal
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Queen c)) {
            return false;
        }

        return color.equals(c.getColor())
                && position.equals(c.getPosition());
    }

}
