import Settings.Settings;

import java.util.Scanner;
public class ChessGame {
    private final Settings settings;

    public ChessGame(){
        this.settings = new Settings();
    }

    public void start() throws Exception {
        ComponentsCreator compCreator = new ComponentsCreator();
        compCreator.create(settings);
        GameModerator moderator = new GameModerator();
        moderator.start();
    }
    public void settings() throws Exception {
        System.out.println("-SETTINGS");

        int numberOfPlayers = getNumberOfPlayers();
        settings.setNumberOfPlayers(numberOfPlayers);

        String[] colors = getColorsOfPlayers();
        settings.setPlayersColors(colors);

        int boardSize = getBoardSize();
        settings.setBoardSize(boardSize);

        String boardMode = getBoardMode();
        settings.setBoardMode(boardMode);

        String PiecesMode = getPiecesdMode();
        settings.setPiecesMode(PiecesMode);
    }
    private int getNumberOfPlayers(){
        System.out.println("@@The only available number of players yet, is: 2 ");
        return 2;
    }

    private String[] getColorsOfPlayers(){
        System.out.println("@@The only available colors yet, are: White/Black ");
        return new String[]{"white", "black"};
    }

    private int getBoardSize(){
        System.out.println("@@The only available board size yet, is: 8 ");
        return 8;
    }

    private String getBoardMode(){
        System.out.println("@@The only available boardMode available yet, is: classic ");
        return "classic";
    }

    private String getPiecesdMode() throws Exception {
        System.out.println("--Please choose pieces mode:\n" +
                "--- 1- classic\n" +
                "--- 2- custom");
        Scanner sc = new Scanner(System.in);
        do{
            int mode;
            try{
                mode = sc.nextInt();
            }
            catch(NumberFormatException nfe){
                continue;
            }
            switch(mode){
                case 1: return "classic";
                case 2: return "custom";
                default: continue;
            }
        }while(true);
    }
}
