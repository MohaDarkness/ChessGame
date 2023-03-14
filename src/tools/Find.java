package tools;

import pieces.Piece;
import squares.Square;


public class Find extends DevTool {
    public static Piece getPieceOnSquare(Square square){
        for(Piece piece : pieces){
            if(piece.getPosition().equals(square.getIndex())){
                return piece;
            }
        }
        return null;
    }

    public static Piece getPieceOnSquare(String square){
        for(Piece piece : pieces){
            if(piece.getPosition().equals(square)){
                return piece;
            }
        }
        return null;
    }

    public static Square getSquareFromPos(String pos){
        pos = pos.toLowerCase();
        int row = pos.charAt(1) % 49;
        int column = pos.charAt(0) % 97;

        return squares[row][column];
    }
    public static Square getSquareFromPos(int[] pos){
        return squares[pos[0]][pos[1]];
    }
}
