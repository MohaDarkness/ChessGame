package squares;

public class ClassicSquare extends Square{
    private final String index;
    private boolean empty = true;

    public ClassicSquare(String index){

        this.index = index;
    }
    public String getIndex(){
        return index;
    }
    public String getType(){
        return "classic";
    }
    public void makeEmpty(){
        empty = true;
    }
    public void makeNotEmpty(){
        empty = false;
    }
    public boolean isEmpty(){
        return empty;
    }
}
