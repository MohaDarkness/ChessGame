package rules.validation.movevalidators;

import java.util.regex.*;
import request.moverequests.ClassicMoveRequest;
import rules.validation.Validator;

public class InputSyntaxValidator extends Validator {

    @Override
    protected boolean check(ClassicMoveRequest request) {
        boolean checkFirstPos = Pattern.matches("[a-z][\\d]", request.getCurrentSquareName());
        boolean checkSecondPos = Pattern.matches("[a-z][\\d]", request.getNewSquareName());
        return checkFirstPos && checkSecondPos;
    }

    @Override
    protected void printError(ClassicMoveRequest request) {
        if(!request.isVirtual())
            System.out.println("INVALID SYNTAX ::: You're not entering positions properly..");
    }
}
