import java.util.Scanner;
public class Player {
    private final String name;
    private int score;
    public Player()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name: "); name = sc.next();
        System.out.println("Welcome to the Game of Nim!!");
        score = 0;
    }
    public Player(String name)
    {
        this.name = name;
        score = 0;
    }
    public String getName()
    {
        return this.name;
    }
    public int getScore()
    {
        return this.score;
    }
    public void setScore()
    {
        this.score += 1;
    }


}
