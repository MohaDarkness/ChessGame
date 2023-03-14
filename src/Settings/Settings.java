package Settings;

public class Settings {
    private int numberOfPlayers;
    private int boardSize;
    private String[] playersColors;
    private String boardMode;
    private String piecesMode;

    public Settings(){
        numberOfPlayers = 2;
        boardSize = 8;
        playersColors = new String[] {"white", "black"};
        boardMode = "classic";
        piecesMode = "classic";
    }

    public void setNumberOfPlayers(int number){
        numberOfPlayers = number;
    }
    public void setBoardSize(int size){
        boardSize = size;
    }
    public void setPlayersColors(String[] colors){
        playersColors = colors;
    }
    public void setBoardMode(String mode){
        boardMode = mode;
    }

    public void setPiecesMode(String piecesMode) {
        this.piecesMode = piecesMode;
    }

    public int getNumberOfPlayers(){
        return numberOfPlayers;
    }
    public int getBoardSize(){
        return boardSize;
    }
    public String[] getPlayersColors(){
        return playersColors;
    }
    public String getBoardMode(){
        return boardMode;
    }

    public String getPiecesMode() {
        return piecesMode;
    }
}
