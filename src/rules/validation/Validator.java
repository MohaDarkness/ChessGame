package rules.validation;

import request.moverequests.ClassicMoveRequest;


public abstract class Validator {
    private Validator next = null;
    public void setNext(Validator next){
        this.next = next;
    }
    public Validator getNext(){
        return next;
    }
    public boolean validate(ClassicMoveRequest request) throws Exception {
        Validator next = getNext();
        boolean check = check(request);
        if(!check){
            printError(request);
            return false;
        }
        return next == null || next.validate(request);
    }
    protected abstract boolean check(ClassicMoveRequest request) throws Exception;
    protected abstract void printError(ClassicMoveRequest request);
}
