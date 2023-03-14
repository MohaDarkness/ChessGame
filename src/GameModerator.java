import board.Board;
import gamedata.GameData;
import players.Player;
import request.Request;
import request.RequestFactory;

// Singleton class
public class GameModerator {
    private Player[] players;
    private Board board;
    public GameModerator() throws Exception {
        GameData data = GameData.getInstance();
        this.players = data.getPlayers();
        this.board = new Board();
    }

    public void start() throws Exception {
        RequestFactory reqFact = new RequestFactory();
        printStarter();
        int turn = 1;
        int player = 0;


        while(!gameEnded()){
            player %= players.length;
            boolean turnNotEnded;

            do{
                String playerInput = takePlayerInput(turn, player);
                Request request = reqFact.getInstance(players[player], playerInput);
                turnNotEnded = board.handleRequest(request);
            } while(turnNotEnded);

            turn++;
            player++;
        }
    }
    private boolean gameEnded(){
        for(Player player : players)
            if(player.isLost()){
                printEnding();
                return true;
            }
        return false;
    }
    private String takePlayerInput(int turn, int player){
        System.out.println("### Turn num: " + turn);
        String input = players[player].getInput();
        System.out.println();
        return input;
    }
    private void printStarter() throws Exception {
        System.out.print(players[0].getName());
        for(int i = 1; i < players.length; i++){
            System.out.print(" vs " + players[i].getName());
        }
        System.out.println("\nLET THE BATTLE BEGIN !!!");
        board.printBoardInfo();
    }
    private void printEnding(){
        System.out.println("The winner is ###");
    }
}
