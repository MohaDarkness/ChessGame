package rules.validation.movevalidators;

import request.moverequests.ClassicMoveRequest;
import rules.validation.Validator;
import tools.Calculate;

public class WithinBoardValidator extends Validator {
    @Override
    protected boolean check(ClassicMoveRequest request) {
        int currentRow = Calculate.getRowFromPos(request.getCurrentSquareName());
        int currentColumn = Calculate.getColumnFromPos(request.getCurrentSquareName());
        int newRow = Calculate.getRowFromPos(request.getNewSquareName());
        int newColumn = Calculate.getColumnFromPos(request.getNewSquareName());

        boolean validCurRow = currentRow >= 0 && currentRow < 8;
        boolean validCurColumn = currentColumn >= 0 && currentColumn < 8;
        boolean validNewRow = newRow >= 0 && newRow < 8;
        boolean validNewColumn = newColumn >= 0 && newColumn < 8;

        return validCurRow && validCurColumn && validNewRow && validNewColumn;
    }

    @Override
    protected void printError(ClassicMoveRequest request) {
        if(!request.isVirtual())
            System.out.println("INVALID INPUT ::: The square you're trying to reach is not on board!");
    }
}
