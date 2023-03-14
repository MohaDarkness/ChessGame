package pieces.positionsrules;

import pieces.Piece;
import pieces.pieces.*;
import players.Player;

import java.util.ArrayList;

public class CustomPositions implements Positions{
    private final ArrayList<Piece> pieces = new ArrayList<Piece>();

    public CustomPositions(Player[] players){
        Player player1 = players[0];
        Player player2 = players[1];

        String[] positions;
//____________________________________________________PLAYER1___________________________________________________________
//        positions = new String[] {"a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2"};
//        for(String pos : positions) pieces.add(new Pawn(player1, pos));


        positions = new String[] {"e1"};
        for(String pos : positions) pieces.add(new King(player1, pos));

        positions = new String[] {"d1"};
        for(String pos : positions) pieces.add(new Queen(player1, pos));

        positions = new String[] {"a1", "h1"};
        for(String pos : positions) pieces.add(new Rook(player1, pos));

        positions = new String[] {"c1", "f1"};
        for(String pos : positions) pieces.add(new Bishop(player1, pos));

        positions = new String[] {"b1", "g1"};
        for(String pos : positions) pieces.add(new Knight(player1, pos));
//____________________________________________________PLAYER2___________________________________________________________
//        positions = new String[] {"a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7"};
//        for(String pos : positions) pieces.add(new Pawn(player2, pos));
        pieces.add(new Mohannad(player2, "e5"));
        positions = new String[] {"e8"};
        for(String pos : positions) pieces.add(new King(player2, pos));

        positions = new String[] {"d8"};
        for(String pos : positions) pieces.add(new Queen(player2, pos));

        positions = new String[] {"a8", "h8"};
        for(String pos : positions) pieces.add(new Rook(player2, pos));

        positions = new String[] {"c8", "f8"};
        for(String pos : positions) pieces.add(new Bishop(player2, pos));

        positions = new String[] {"b8", "g8"};
        for(String pos : positions) pieces.add(new Knight(player2, pos));
    }
    public ArrayList<Piece> generatePieces(){
        return pieces;
    }
}
