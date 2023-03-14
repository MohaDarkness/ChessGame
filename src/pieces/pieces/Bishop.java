package pieces.pieces;

import pieces.Piece;
import players.Player;

public class Bishop extends Piece {
    public Bishop(Player player, String position){
        this.color = player.getColor();
        this.type = "bishop";
        setPosition(position);
    }

    @Override
    public boolean checkMoveRule(String newPosition){
        if(newPosition == position)
            return false;

        int[] currentPos = getColumnRow(position); // {column, row}
        int[] newPos = getColumnRow(newPosition);  // {column, row}

        return (Math.abs(currentPos[0] - newPos[0]) == Math.abs(currentPos[1] - newPos[1]));
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Bishop c)) {
            return false;
        }

        return  color.equals(c.getColor())
                && position.equals(c.getPosition());
    }

}
