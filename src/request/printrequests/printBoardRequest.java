package request.printrequests;

public class printBoardRequest implements PrintRequest {
    @Override
    public String getRequestType() {
        return "printBoard";
    }
}
