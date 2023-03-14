package rules.validation.movevalidators;

import pieces.Piece;
import request.moverequests.ClassicMoveRequest;
import rules.validation.Validator;
import tools.Find;


public class MovementRuleValidator extends Validator {

    protected boolean check(ClassicMoveRequest request){
        Piece movingPiece = Find.getPieceOnSquare(request.getCurrentSquareName());
        return movingPiece.checkMoveRule(request.getNewSquareName());
    }
    @Override
    protected void printError(ClassicMoveRequest request){
        Piece movingPiece = Find.getPieceOnSquare(request.getCurrentSquareName());
        if(!request.isVirtual())
            System.out.println("INVALID MOVE ::: You can't move a " + movingPiece + " this way!");
    }
}
