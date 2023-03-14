package rules.validation.movevalidators;

import pieces.Piece;
import request.moverequests.ClassicMoveRequest;
import squares.Square;
import rules.validation.Validator;
import tools.Calculate;
import tools.Find;

import java.util.Objects;

public class PieceTeamValidator extends Validator {
    @Override
    protected boolean check(ClassicMoveRequest request) {
        int row = Calculate.getRowFromPos(request.getCurrentSquareName());
        int column = Calculate.getColumnFromPos(request.getCurrentSquareName());

        Square[][] squares = request.getSquares();
        Piece playerPiece = Find.getPieceOnSquare(squares[row][column]);

        return Objects.equals(playerPiece.getColor(), request.getPlayerColor());
    }

    @Override
    protected void printError(ClassicMoveRequest request) {
        if(!request.isVirtual())
            System.out.println("INVALID INPUT ::: The piece on square " + request.getCurrentSquareName() + " is not yours!!");
    }
}
