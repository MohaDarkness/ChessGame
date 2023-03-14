package request.moverequests;

import color.Color;
import pieces.Piece;
import players.Player;
import squares.Square;

import java.util.ArrayList;

public class ClassicMoveRequest implements MoveRequest{
    private boolean isVirtual = false;
    private final String currentSquareName;
    private final String newSquareName;
    private final Player player;
    private ArrayList<Piece> pieces;
    private Square[][] squares;

    public ClassicMoveRequest(Player player, String command){
        this.player = player;
        String[] tmpCommand = command.split(" ");
        currentSquareName = tmpCommand[1].toLowerCase();
        newSquareName = tmpCommand[2].toLowerCase();
    }

    @Override
    public String getRequestType() {
        return "move";
    }

    @Override
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    @Override
    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }

    @Override
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    @Override
    public Square[][] getSquares() {
        return squares;
    }

    @Override
    public String getCurrentSquareName(){
        return currentSquareName;
    }
    @Override
    public String getNewSquareName(){
        return newSquareName;
    }

    public void setVirtual(boolean bool){
        isVirtual = bool;
    }
    public boolean isVirtual(){
        return isVirtual;
    }

    public Color getPlayerColor(){
        return player.getColor();
    }
}
