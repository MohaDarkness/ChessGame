package rules.validation.movevalidators;

import pieces.Piece;
import request.moverequests.ClassicMoveRequest;
import squares.Square;
import rules.validation.Validator;
import tools.Calculate;
import tools.Find;


public class BlockedMoveValidator extends Validator {
    private ClassicMoveRequest request;

    private Square blockingSquare;
    protected boolean check(ClassicMoveRequest request){
        Piece movingPiece = Find.getPieceOnSquare(request.getCurrentSquareName());
        this.request = request;

        if(movingPiece.getType().equals("knight"))
            return true;

        int curRow = Calculate.getRowFromPos(request.getCurrentSquareName());
        int curCol = Calculate.getColumnFromPos(request.getCurrentSquareName());
        int newRow = Calculate.getRowFromPos(request.getNewSquareName());
        int newCol = Calculate.getColumnFromPos(request.getNewSquareName());

        if(curRow - newRow == 0)//Horizontal move
            return checkHorizontal(newCol, curCol, curRow);
        else if (curCol - newCol == 0)//Vertical move
            return checkVertical(newRow, curRow, curCol);
        else
            return checkDiagonal(newRow, curRow, newCol, curCol);
    }
    protected void printError(ClassicMoveRequest request){
        if(!request.isVirtual())
            System.out.println("INVALID MOVE ::: An another piece located at " + blockingSquare.getIndex() + " is blocking this move!");
    }

    private boolean checkHorizontal(int newCol, int curCol, int curRow){
        int min = Math.min(newCol, curCol);
        int max = Math.max(newCol, curCol);

        for(int i = min+1; i < max; i++){
            if(!request.getSquares()[curRow][i].isEmpty()){
                blockingSquare = request.getSquares()[curRow][i];
                return false;
            }
        }
        return true;
    }

    private boolean checkVertical(int newRow, int curRow, int curCol){
        int min = Math.min(newRow, curRow);
        int max = Math.max(newRow, curRow);

        for(int i = min+1; i < max; i++){
            if(!request.getSquares()[i][curCol].isEmpty()){
                blockingSquare = request.getSquares()[i][curCol];
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(int newRow, int curRow, int newCol, int curCol){
        int horizontalStep = curCol < newCol? 1 : -1;
        int verticalStep = curRow < newRow? 1 : -1;
        int row = curRow + verticalStep;
        int column = curCol + horizontalStep;

        while(row != newRow && column != newCol){
            System.out.println("DEBUG: newRow:"+newRow+" newCol:"+newCol+" row:"+row+" column:"+column+
                    " horStep:"+horizontalStep+" verStep:"+verticalStep);
            if(!request.getSquares()[row][column].isEmpty()){
                blockingSquare = request.getSquares()[row][column];
                return false;
            }
            row += verticalStep;
            column += horizontalStep;
        }
        return true;
    }
}
