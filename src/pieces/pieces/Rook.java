package pieces.pieces;

import pieces.Piece;
import players.Player;

public class Rook extends Piece {
    public Rook(Player player, String position){
        this.color = player.getColor();
        setPosition(position);
        this.type = "rook";
    }

    @Override
    public boolean checkMoveRule(String newPosition){
        if(newPosition == position)
            return false;

        int[] currentPos = getColumnRow(position); // {column, row}
        int[] newPos = getColumnRow(newPosition);  // {column, row}

        return (currentPos[0] - newPos[0] == 0 || currentPos[1] - newPos[1] == 0);

    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Rook c)) {
            return false;
        }

        return  color.equals(c.getColor())
                && position.equals(c.getPosition());
    }

}
