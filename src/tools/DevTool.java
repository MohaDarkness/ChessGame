package tools;

import pieces.Piece;
import squares.Square;

import java.util.ArrayList;

public class DevTool {
    protected static Square[][] squares;
    protected static ArrayList<Piece> pieces;

    public static void setPieces(ArrayList<Piece> pieces){
        DevTool.pieces = pieces;
    }
    public static void setSquares(Square[][] squares){
        DevTool.squares = squares;
    }
}
