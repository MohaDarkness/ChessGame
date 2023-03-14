package rules.validation.movevalidators;

import pieces.Piece;
import request.moverequests.ClassicMoveRequest;
import squares.Square;
import rules.validation.Validator;
import tools.Calculate;
import tools.Find;

public class CellLandingValidator extends Validator {

    protected boolean check(ClassicMoveRequest request){
        int row = Calculate.getRowFromPos(request.getNewSquareName());
        int column = Calculate.getColumnFromPos(request.getNewSquareName());

        Square[][] squares = request.getSquares();
        Square destinationSquare = squares[row][column];

        boolean isEmpty = destinationSquare.isEmpty();
        boolean isEnemyPiece = false;
        if(!isEmpty){
            Piece pieceOnDist = Find.getPieceOnSquare(destinationSquare);
            isEnemyPiece = !pieceOnDist.getColor().equals(request.getPlayerColor());
        }
        Piece movingPiece = Find.getPieceOnSquare(request.getCurrentSquareName());

        if(movingPiece.getType().equals("pawn")) {
            if (column != Calculate.getColumnFromPos(request.getCurrentSquareName())) {
                if (isEmpty) return false;
                if (!isEnemyPiece) return false;
            } else {
                if (!isEmpty) return false;
            }
        }
         return isEnemyPiece || isEmpty;
    }
    protected void printError(ClassicMoveRequest request){
        if(!request.isVirtual())
            System.out.println("INVALID MOVE ::: You can't kill/move one/to square located at " + request.getNewSquareName() + "..");
    }

}
