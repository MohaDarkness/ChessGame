package pieces.pieces;

import pieces.Piece;
import players.Player;

public class Knight extends Piece {
    public Knight(Player player, String position){
        this.color = player.getColor();
        setPosition(position);
        this.type = "knight";
    }

    @Override
    public boolean checkMoveRule(String newPosition){
        if(newPosition == position)
            return false;

        int[] currentPos = getColumnRow(position); // {column, row}
        int[] newPos = getColumnRow(newPosition);  // {column, row}

        if(Math.abs(currentPos[0] - newPos[0]) == 2 || Math.abs(currentPos[1] - newPos[1]) == 2)
            return (Math.abs(currentPos[0] - newPos[0]) == 1 || Math.abs(currentPos[1] - newPos[1]) == 1);

        return false;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Knight c)) {
            return false;
        }

        return  color.equals(c.getColor())
                && position.equals(c.getPosition());
    }

}
