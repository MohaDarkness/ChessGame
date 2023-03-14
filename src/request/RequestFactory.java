package request;

import players.Player;
import request.invalidrequests.InvalidRequest;
import request.moverequests.ClassicMoveRequest;
import request.printrequests.printBoardRequest;

public class RequestFactory {


    public Request getInstance(Player player, String userInput){
        String[] splitInput = userInput.split(" ");
        String requestType = splitInput[0];
        String requestBody = splitInput.length > 1 ? userInput.split(" ")[1] : "";

        switch(requestType){
            case ("move"): return new ClassicMoveRequest(player, userInput);
            case ("print"):{
                if(requestBody.equals("board")) return new printBoardRequest();
                return new InvalidRequest();
            }
            default: return new InvalidRequest();
        }
    }
}
