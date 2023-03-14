package tools;

public class Calculate extends DevTool{
    public static int getRowFromPos(String pos){
        return pos.charAt(1) % 49;
    }
    public static int getColumnFromPos(String pos){
        return pos.charAt(0) % 97;
    }
    public static int[] getRowColumnFromPos(String pos){
        int row = getRowFromPos(pos);
        int column = getColumnFromPos(pos);
        return new int[] {row, column};
    }
}
