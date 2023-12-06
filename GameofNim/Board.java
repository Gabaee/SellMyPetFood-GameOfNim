import java.util.Random;
public class Board 
{
    private static int pieces;
    private static int maxGuess;

    public static void populate() 
    {
        Random rand = new Random();
        int pileSize = rand.nextInt(50 - 10 + 1) + 10;
        pieces = pileSize;
        System.out.println("Number of pieces: " + pieces);
    }

    public static int getPieces() 
    {
        return pieces;
    }
    public static void setPieces(int p) 
    {
        pieces -= p;
    }
    public static int getMaxGuess() 
    {
        return maxGuess;
    }
    public static void setMaxGuess()
    {
        maxGuess = pieces / 2;
        if (pieces == 1) { maxGuess = 1; }
    }
}
