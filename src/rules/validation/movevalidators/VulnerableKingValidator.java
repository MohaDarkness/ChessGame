package rules.validation.movevalidators;//package rules.validation.movevalidators;
//
//
//import pieces.*;
//import players.Player;
//import request.moverequests.ClassicMoveRequest;
//import squares.Square;
//import rules.validation.ValidationHandler;
//import rules.validation.Validator;
//import virtualizer.Virtualizer;
//
//import java.util.ArrayList;
//
//public class VulnerableKingValidator extends Validator {
//
//    private String kingPos;
//    private ArrayList<Piece> pieces;
//    private Square[][] squares;
//    private int[] currPos;
//    private int[] newPos;
//    private String newPosName;
//    private Player thisPlayer;
//    private ArrayList<Piece> virtualPieces;
//    private Square[][] virtualSquares;
//    @Override
//    protected boolean check(ClassicMoveRequest request) throws Exception {
//        Virtualizer virtualizer = new Virtualizer();
//
//        this.newPosName = request.getNewSquareName();
//        pieces = request.getPieces();
//        squares = request.getSquares();
//        currPos = request.getCurrentPos();
//        newPos = request.getNewPos();
//        thisPlayer = request.getPlayer();
//        kingPos = getKingPos();
//
//        virtualPieces = virtualizer.virtualPieces(pieces);
//        virtualSquares = virtualizer.virtualSquares(squares);
//        virtualizeMove();
//        ValidationHandler oppMoveChecker = new ValidationHandler(virtualPieces, virtualSquares);
//
//
//        String newCommand;
//        ClassicMoveRequest newRequest;
//        for(Piece piece : pieces){
//            if(piece.getPlayer() != thisPlayer){
//                newCommand = "move " + piece.getPosition() + " " + kingPos;
//                newRequest = new ClassicMoveRequest(piece.getPlayer(), newCommand);
//                newRequest.setSquares(squares);
//                newRequest.setVirtual(true);
//                if(oppMoveChecker.validateMove(newRequest))
//                    return false;
//            }
//        }
//        return true;
//    }
//    @Override
//    protected void printError(ClassicMoveRequest request) {
//        if(!request.isVirtual())
//            System.out.println("INVALID MOVE ::: Your king is going to be vulnerable...");
//    }
//    private String getKingPos() throws Exception {
//        for(Piece piece : pieces){
//            boolean myPiece = piece.getPlayer().equals(thisPlayer);
//            boolean isKing = piece.getType().equals("king");
//            if(isKing && myPiece){
//                return piece.getPosition();
//            }
//        }
//        throw new Exception("KingValidator ::: Oops you don't have a king!!!");
//    }
//    private void virtualizeMove() throws CloneNotSupportedException {
//        Piece virtualPiece = makeVirtualPiece();
//        virtualPiece = virtualSquares[currPos[0]][currPos[1]].getPiece();
//        removeFromPieces(newPos);
//        virtualPiece.setPosition(newPosName);
//        squares[newPos[0]][newPos[1]].setPiece(virtualPiece);
//        squares[currPos[0]][currPos[1]].makeEmpty();
//    }
//
//    private void removeFromPieces(int[] position){
//        int row = position[0];
//        int column = position[1];
//        Piece unwantedPiece = squares[row][column].getPiece();
//        pieces.remove(unwantedPiece);
//    }
//
//    private Piece makeVirtualPiece() throws CloneNotSupportedException {
//        Piece realPiece = squares[currPos[0]][currPos[1]].getPiece();
//        System.out.println("Virtualizing -> " + realPiece);
//        Piece dumPiece =
//                switch (realPiece.getType()) {
//            case "king"  -> (King) realPiece.clone();
//            case "queen" -> (Queen) realPiece.clone();
//            case "bishop"-> (Bishop) realPiece.clone();
//            case "knight"-> (Knight) realPiece.clone();
//            case "rook"  -> (Rook) realPiece.clone();
//            default -> (Pawn) realPiece.clone();
//        };
//        for(Piece piece : pieces)
//            if(piece.equals(realPiece))
//                System.out.println("LOL WE DO HAVE IT...");
//        int index = pieces.indexOf(realPiece);
//        squares[currPos[0]][currPos[1]].setPiece(dumPiece);
//        pieces.set(index, dumPiece);
//
//        return dumPiece;
//    }
//
//}
