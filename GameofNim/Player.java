import java.util.Scanner;
public class Player 
{
    private final String name;
    private int score;

    public Player()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name: "); name = sc.next();
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
