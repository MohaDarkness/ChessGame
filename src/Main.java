import java.util.Scanner;
public class Main {

    private static final ChessGame chessGame = new ChessGame();
    public static void main(String[] args) throws Exception {
        printMainMenu();
        pressButton();
    }

    static void printMainMenu(){
        System.out.println("-------------------");
        System.out.println("1- Start!");
        System.out.println("2- Settings");
        System.out.print(":: ");
    }
    static void pressButton() throws Exception {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        while(true){
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid!!");
                printMainMenu();
                continue;
            }
            if(option == 1){
                chessGame.start();
                break;
            }
            if(option == 2)
                chessGame.settings();
            else
                System.out.println("Invalid!!");
            printMainMenu();
        }
        System.out.println("Game ended ^_^");
    }
}
