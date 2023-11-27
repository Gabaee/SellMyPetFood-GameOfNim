import java.util.Random;
public class Board
{
    public static int populate()
    {
        Random pileSize = new Random();
        return pileSize.nextInt(50 - 10 + 1) + 10;
    }
}
