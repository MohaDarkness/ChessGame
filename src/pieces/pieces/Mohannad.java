package pieces.pieces;

import pieces.Piece;
import players.Player;

public class Mohannad extends Piece
{
    public Mohannad(Player player, String position){
        this.color = player.getColor();
        setPosition(position);
        this.type = "mohannnad";
    }

    @Override
    public boolean checkMoveRule(String newPos) {
        return true;
    }
}
