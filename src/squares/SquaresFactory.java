package squares;

import rules.boardrules.ClassicalBoard;

public class SquaresFactory {

    public Square[][] createBoard(String boardMode) throws Exception {
        if(boardMode == "classic"){
            ClassicalBoard board = new ClassicalBoard();
            return board.createBoard();
        }
        throw new Exception("boardMode is not valid!");
    }

}
