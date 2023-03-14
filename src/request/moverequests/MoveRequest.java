package request.moverequests;

import color.Color;
import pieces.Piece;
import request.Request;
import squares.Square;

import java.util.ArrayList;

public interface MoveRequest extends Request {
    public void setPieces(ArrayList<Piece> pieces);
    public void setSquares(Square[][] squares);
    public ArrayList<Piece> getPieces();
    public Square[][] getSquares();
    public String getCurrentSquareName();
    public String getNewSquareName();
    public Color getPlayerColor();

}
