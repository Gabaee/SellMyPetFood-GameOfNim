import java.util.Random;
public class Board {
    private static int pieces;
    private static int maxGuess;

    public static void populate() {
        Random pileSize = new Random();
        pileSize.nextInt(50 - 10 + 1);
    }

    public static int getPieces() {
        return pieces;
    }

    public static int getMaxGuess() {
        return maxGuess;
    }

    public static void removePieces(int p) {
        pieces -= p;
    }

    public static void setMaxGuess()
    {
        maxGuess = (int) (pieces / 2);
        if (pieces == 1) { maxGuess = 1; }
    }
}
