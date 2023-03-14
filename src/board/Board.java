package board;

import board.moveshandlers.MovementHandler;
import gamedata.GameData;
import pieces.Piece;
import request.moverequests.ClassicMoveRequest;
import request.Request;
import squares.Square;

import java.util.ArrayList;

public class Board {
    private final MovementHandler movementHandler;
    private final Square[][] squares;
    private final ArrayList<Piece> pieces;

    public Board() throws Exception {
        GameData data = GameData.getInstance();
        this.pieces = data.getPieces();
        this.squares = data.getSquares();

        movementHandler = new MovementHandler(squares, pieces);
    }

    public boolean handleRequest(Request request) throws Exception {
        String commandType = request.getRequestType();

        switch (commandType){
            case "move":
                return move((ClassicMoveRequest) request);
            case "printBoard":
                printBoardInfo(); return true;
            case "invalid":
                printInvalid(); return true;
            default: return true;
        }

    }

    private boolean move(ClassicMoveRequest request) throws Exception {
        request.setSquares(squares);
        request.setPieces(pieces);
        boolean moveDone = movementHandler.move(request);
        if(moveDone){
            printBoardInfo();
            return false;
        }

        System.out.println("Board : Invalid Move! try again..");
        return true;
    }

public void printBoardInfo() throws Exception {
    System.out.println("\n---------------------------------------------------------------------------------------------------");

    System.out.println();
    for(int i = squares.length -1; i >= 0; i--){
        Square[] squareLine = squares[i];
        System.out.print(squareLine[0].getIndex().toCharArray()[1]+ "\t");
        for(Square square : squareLine)
            if(!square.isEmpty()){
                Piece pieceOnSquare = null;
                for(Piece piece : pieces){
                    if(piece.getPosition().equals(square.getIndex())){
                        pieceOnSquare = piece;
                        break;
                    }
                }
                if(pieceOnSquare == null) throw new Exception("Piece == null while print board!");

                char color = pieceOnSquare.getColor().getColorName().charAt(0);
                String pieceName = pieceOnSquare.getType() + "(" + color +")";
                String tabs = pieceName.length() < 8? "\t\t" : "\t";
                System.out.print(pieceName + tabs);
            }
            else
                System.out.print("  X\t\t\t");
        System.out.println("\n\n");
    }
    char a = 'a';
    System.out.print("\t");
    for(int i = 0; i < squares[0].length; i++) System.out.print(a++ + "\t\t\t");
    System.out.println("\n---------------------------------------------------------------------------------------------------");
}

    private void printInvalid(){
        System.out.println("Board: Invalid command!\ntry using \"help\"");
    }

}
