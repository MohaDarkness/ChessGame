package rules.validation.movevalidators;

import request.moverequests.ClassicMoveRequest;
import squares.Square;
import rules.validation.Validator;
import tools.Calculate;

public class EmptySquareValidator extends Validator {
    @Override
    protected boolean check(ClassicMoveRequest request) {
        int row = Calculate.getRowFromPos(request.getCurrentSquareName());
        int column = Calculate.getColumnFromPos(request.getCurrentSquareName());

        Square playerSquare = request.getSquares()[row][column];

        return !playerSquare.isEmpty();
    }

    @Override
    protected void printError(ClassicMoveRequest request) {
        if(!request.isVirtual())
            System.out.println("INVALID INPUT ::: There's no piece on square " + request.getCurrentSquareName());
    }
}
