package board.moveshandlers;

import pieces.Piece;
import request.moverequests.ClassicMoveRequest;
import squares.Square;
import rules.validation.ValidationHandler;
import tools.Calculate;
import tools.Find;

import java.util.ArrayList;

public class MovementHandler {
    private ValidationHandler validationHandler;
    private Square[][] squares;
    private ArrayList<Piece> pieces;

    public MovementHandler(Square[][] squares, ArrayList<Piece> pieces){
        this.squares = squares;
        this.pieces = pieces;

        validationHandler = new ValidationHandler();
    }


    public boolean move(ClassicMoveRequest request) throws Exception {
        boolean validMove = validationHandler.validateMove((request));
        if(validMove){
            int[] newPosRowColumn = Calculate.getRowColumnFromPos(request.getNewSquareName());
            int[] curPosRowColumn = Calculate.getRowColumnFromPos(request.getCurrentSquareName());
            Piece movingPiece = Find.getPieceOnSquare(request.getCurrentSquareName());
            removeFromPieces(newPosRowColumn);
            fillSquare(newPosRowColumn);
            movingPiece.setPosition(request.getNewSquareName());
            makeSquareEmpty(curPosRowColumn);
        }
        return validMove;
    }
    private void removeFromPieces(int[] position){
        Piece unwantedPiece = Find.getPieceOnSquare(squares[position[0]][position[1]]);
        pieces.remove(unwantedPiece);
    }
    private void fillSquare(int[] position){
        Square square = Find.getSquareFromPos(position);
        square.makeNotEmpty();
    }
    private void makeSquareEmpty(int[] position){
        Square square = Find.getSquareFromPos(position);
        square.makeEmpty();
    }
}
