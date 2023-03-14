package gamedata;

import pieces.Piece;
import players.Player;
import color.Color;
import squares.Square;

import java.util.ArrayList;

public class GameData {
    private final Player[] players;
    private final Square[][] squares;
    private  final ArrayList<Piece> pieces;
    private final ArrayList<Color> colors;
    private static GameData soloInstance = null;
    private GameData(Player[] players, Square[][] squares, ArrayList<Piece> pieces, ArrayList<Color> colors){
        System.out.println(">>> Saving data...");
        this.pieces = pieces;
        this.players = players;
        this.squares = squares;
        this.colors = colors;

        System.out.println(">>> Game is ready!");

    }

    public static GameData createSingletonInstance(Player[] players, Square[][] squares, ArrayList<Piece> pieces, ArrayList<Color> colors) throws Exception {
        if(soloInstance != null)
            throw new Exception("This class is singleton and you already have an instance!\nTry GameData.getInstance() instead..");

        soloInstance = new GameData(players, squares, pieces, colors);
        return soloInstance;
    }

    public static GameData getInstance() throws Exception {
        if(soloInstance == null)
            throw new Exception("You have to create a singleton GameData instance first @_@");

        return soloInstance;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Square[][] getSquares() {
        return squares;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public ArrayList<Color> getColors() {
        return colors;
    }
}


