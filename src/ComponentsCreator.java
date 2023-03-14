import Settings.Settings;
import pieces.PiecesFactory;
import squares.SquaresFactory;
import color.Color;
import color.ColorsCreator;
import gamedata.GameData;
import pieces.Piece;
import players.Player;
import squares.Square;
import tools.DevTool;

import java.util.ArrayList;

public class ComponentsCreator {
    public ComponentsCreator() throws Exception {
    }

    public void create(Settings settings) throws Exception {
        System.out.println(">>> Creating the world..");
        ArrayList<Color> colors = createColors(settings.getPlayersColors());
        Player[]  players = createPlayers(settings.getNumberOfPlayers(), colors);
        Square[][] squares = createSquares(settings.getBoardMode());
        ArrayList<Piece> pieces = createPieces(settings.getPiecesMode(), players);

        GameData.createSingletonInstance(players, squares, pieces, colors);
    }


    private ArrayList<Color> createColors(String[] settingsColors) throws Exception {
        ColorsCreator colorsCreator = new ColorsCreator();
        return colorsCreator.getColors(settingsColors);
    }
    private Player[] createPlayers(int numberOfPlayers, ArrayList<Color> colors){
        Player[] tmpPlayers = new Player[numberOfPlayers];
        for(int i = 0; i < tmpPlayers.length; i++)
            tmpPlayers[i] = new Player(i, colors.get(i));
        return tmpPlayers;
    }
    private Square[][] createSquares(String settingsBoardMode) throws Exception {
        SquaresFactory squaresCreatingModerator = new SquaresFactory();
        Square[][] finalSquares = squaresCreatingModerator.createBoard(settingsBoardMode);
        DevTool.setSquares(finalSquares);
        return finalSquares;
    }

    private ArrayList<Piece> createPieces(String settingsBoardMode, Player[] players) throws Exception {
        PiecesFactory piecesCreatingModerator = new PiecesFactory();
        ArrayList<Piece> finalPieces = piecesCreatingModerator.createPieces(settingsBoardMode, players);
        DevTool.setPieces(finalPieces);
        return finalPieces;
    }
}
