import java.util.Scanner;
import java.util.Random;
public class Game
{
    private final Player player1;
    private final Player player2;
    private Player activePlayer;
    private int currentPlayer;

    public Game() // Game constructor
    {
        player1 = new Player();
        player2 = new Player();
    }

    public void play()
    {
        Board.populate(); // Populates board with the random number of pieces
        Board.setMaxGuess(); // Sets the max a player can guess

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        currentPlayer = rand.nextInt(2) + 1; // Chooses first player
        // First player logic
        if (currentPlayer == 1)
        {
            activePlayer = player1;
            System.out.println(player1.getName() + " is first");
        }
        else
        {
            activePlayer = player2;
            System.out.println(player2.getName() + " is first");
        }
        while (Board.getPieces() > 1) // Starts game
        {
            int pieces = Board.getPieces();
            int maxGuess = Board.getMaxGuess();
            System.out.println("It is " + activePlayer.getName() + "'s turn.");
            System.out.println("There are " + pieces + " pieces remaining.");
            // Max guess stuff
            if (maxGuess == 1) { System.out.println("You can remove only " + maxGuess + " piece."); }
            else { System.out.println("You can remove up to " + maxGuess + " pieces."); }
            System.out.println("How many pieces would you like to remove?");
            int guess = sc.nextInt();
            if (isValid(guess)) {
                while (isValid(guess)) {
                    System.out.println("Sorry, that isn't a valid value.");
                    System.out.println("Please type a guess up to " + Board.getMaxGuess() + " pieces.");
                    guess = sc.nextInt();
                }
            }
            Board.setPieces(guess);
            Board.setMaxGuess();
            advanceTurn();
        }
        if (currentPlayer % 2 == 0) // Winning logic
        {
            player1.setScore();
            System.out.println(player1.getName() + " won the round!");
        }
        else
        {
            player2.setScore();
            System.out.println(player2.getName() + " won the round!");
        }
        boolean gameDone = isFinished();
        if (!gameDone) { play(); }
        else
        {
            System.out.println(player1.getName() + ": " + player1.getScore());
            System.out.println(player2.getName() + ": " + player2.getScore());
            if (player1.getScore() > player2.getScore()) { System.out.println(player1.getName() + " won the Game of Nim!"); }
            else if (player2.getScore() > player1.getScore()) { System.out.println(player2.getName() + " won the Game of Nim!"); }
            else { System.out.println("It's a tie!"); }
        }
    }

    private boolean isFinished() // Prompts user to play again, if not, it ends the game
    {
        System.out.println("Would you like to play again? (y/n)");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        while (!(userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("y")))
        {
            System.out.println("Input was incorrect. Would you like to play again? (y/n)");
            userInput = sc.nextLine();
        }
        if (userInput.equalsIgnoreCase("N"))
        {
            return true;
        }
        return !userInput.equalsIgnoreCase("Y");
    }

    private void advanceTurn() // Turn logic
    {
        currentPlayer++;
        if (currentPlayer % 2 == 1) { activePlayer = player1; }
        else { activePlayer = player2; }
    }
    // Checks if the number guess is valid against the maximum guess
    private boolean isValid(int num) { return num > Board.getMaxGuess(); }
}
