package pieces;

import players.Player;
import pieces.positionsrules.*;

import java.util.ArrayList;

public class PiecesFactory {
    public ArrayList<Piece> createPieces(String boardMode, Player[] players) throws Exception {
        return switch (boardMode) {
            case "classic" -> new ClassicalPositions(players).generatePieces();
            case "custom" -> new CustomPositions(players).generatePieces();
//@@YOU CAN case "newCustomMode" -> new NewCustomModePositioning();
            default -> throw new Exception("boardMode is not valid!");
        };
    }
}
