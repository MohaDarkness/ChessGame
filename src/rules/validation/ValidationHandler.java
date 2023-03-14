package rules.validation;

import request.moverequests.ClassicMoveRequest;
import rules.validation.movevalidators.*;

// Client Class of the chain responsibility pattern
public class ValidationHandler {
    public ValidationHandler(){
    }
    public boolean validateMove(ClassicMoveRequest request) throws Exception {
        Validator v1 = new InputSyntaxValidator();
        Validator v2 = new WithinBoardValidator();
        Validator v3 = new EmptySquareValidator();
        Validator v4 = new PieceTeamValidator();
        Validator v5 = new MovementRuleValidator();
        Validator v6 = new CellLandingValidator();
        Validator v7 = new BlockedMoveValidator();


        v1.setNext(v2);
        v2.setNext(v3);
        v3.setNext(v4);
        v4.setNext(v5);
        v5.setNext(v6);
        v6.setNext(v7);


        return v1.validate(request);
    }
}
