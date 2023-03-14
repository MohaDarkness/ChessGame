package rules.boardrules;

import squares.ClassicSquare;
import squares.Square;

public class ClassicalBoard implements BoardComponent {
    public Square[][] createBoard(){
        Square[][] board = new Square[8][8];
        char c = 'a';
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++)
                board[j][i] = new ClassicSquare((char)(c+i) + String.valueOf(j+1));
        }
        return board;
    }
}
