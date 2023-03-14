package players;

import color.Color;

import java.util.Objects;
import java.util.Scanner;
public class Player {
    private final int ID;
    private final Color color;
    private final String name;
    private String status = "normal";

    public Player(int num, Color color){
        this.ID = num;
        this.color = color;
        Scanner sc = new Scanner(System.in);
        System.out.print("Player " + (num+1) + ".. Enter you name: ");
        this.name = sc.nextLine();
        System.out.println("");
    }
    public String getName(){
        return name;
    }
    public Color getColor(){
        return color;
    }
    public int getID(){
        return ID;
    }
    public boolean isLost(){
        return Objects.equals(status, "lost");
    }
    public String getInput(){
        System.out.print(name+"'s turn: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Player c)) {
            return false;
        }

        return ID == c.getID()
                && name.equals(c.getName())
                && color.equals(c.getColor());
    }

    @Override
    public String toString(){
        return "Player " + ID + " named " + name + " with color " + color;
    }
}
