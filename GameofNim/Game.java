import java.util.Scanner;
public class Game {
    public void play()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome!!!");

        Player[] players = new Player[2];
        for (int i = 0; i < 2; i++)
        {
            System.out.println("Player " + (i + 1) + ", enter your name");
            String name = sc.next();
            players[i] = new Player(name);
        }

    }
}
