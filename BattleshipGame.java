import java.util.*;

// Member variables
public class BattleshipGame {
  private Player thePlayer;
  private CPU opponent;
  private boolean gameOver;
  private Set<String> selectedCoordinates;
  
  // Constructors
  public BattleshipGame() {
    gameOver = false;
    thePlayer = new Player();
    opponent = new CPU();
    selectedCoordinates = new HashSet<>();
  } 

  // Preconditions: None
  // Postconditions: Clears all text from the console
  public void clearScreen() {
    System.out.println("\033[H\033[2J");
    System.out.flush();  
  }
  
  // Preconditions: None
  // Postconditions: Prints instructions on how to play the game
  public void printInstructions() {
    System.out.println("\nIn this game, you will be playing against the computer in a game of battleship.\nYou will be able to see your 10 x 10 grid, composed of your 5 ships that have been randomly placed on the grid.\n\nEach player has: 1 large ship (5 spaces), 1 medium ship (3 spaces) 1 medium-ish ship (2 spaces) and 2 small ships (1 space each). Ships are marked with an 'X'\n\nYou and the computer will take turns firing shots at each other's grid, without seeing each other's ship placement.\n\nThe goal is to destroy all 5 of your opponent's ships! \nOnce either you or the CPU wins, both boards will be displayed to reveal possible leftover ships of your opponent. Good luck and have fun!\n\nReady to play? (y)");
  }

  // Preconditions: None
  // Postconditions: Prints a greeting, with the option to read instructions
  public void greet() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to battleship!\nWould you like to read the instructions? (y) or (n)");
    String ans = sc.next();
    if (ans.equals("y")) {
      printInstructions();
      String ans2 = sc.next();
    }
    else {
      System.out.println("\nHere we go!");
      // Delay 1 second
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }

  // Preconditions: prompt is not null
  // Postconditions: Repeatedly asks user for input until they input an int
  public int getInt(String prompt) {
    Scanner sc = new Scanner(System.in);
    System.out.print(prompt);
    // If user inputs something other than an int, loop until they do
    while (!sc.hasNextInt()) {      
      System.out.println("Enter a whole number:");
      sc.next();
    }
    return sc.nextInt();
  }
  
  // Preconditions: Player and opponent variables must be initialized with their respective class
  // Postconditions: Game loop, handles coordinate input and generates CPU's points until game is over
  public void play() {
    Scanner sc = new Scanner(System.in);
    clearScreen();
    
    // Greeting message
    greet();

    // Create game board for player AND CPU opponent
    thePlayer.initializeBoard();
    opponent.initializeBoard();

    // Variables for whose turn it is, and who's the winner:
    boolean playerTurn = true;
    boolean playerWins = true;
    clearScreen();

    // Create a 2d boolean array to keep track of what coordinates
    // CPU has already hit, so it can generate a new random point every time.
    // All spots are false to start. Whenever CPU generates a point, it
    // turns that point to "true" in this array
    boolean selected[][] = new boolean[10][10];
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        selected[i][j] = false;
      }
    }
    
    // Main game loop
    while (!gameOver) {
      
      // User's turn
      if (playerTurn) {  

        // Print both boards
        thePlayer.displayBoard();
        System.out.println("\n");
        opponent.displayHiddenBoard();

        // User attacks CPU
        System.out.println("\nTime to attack! \nGive coordinates of where you want to fire on the opponent's grid: ");

        int attackX = 0;
        int attackY = 0;
        boolean validChoice = false;


        // Loop until user gives a valid coordinate point & will not allow the user to repeat the
        // same coordinate point twice. Also does not allow the user to input string.
        while (!validChoice) {
          attackX = getInt("Row: ");
          attackY = getInt("Column: ");

          // Bad input
          if (attackX >= 10 || attackX < 0 || attackY >= 10 || attackY < 0) {
            validChoice = false;
            System.out.println("That's not a valid point! Try again");
          }
            
          // Already fired there
          else {
            String coordinate = attackX + "-" + attackY;
            if (selectedCoordinates.contains(coordinate)) {
              System.out.println("You have already attacked those coordinates. Please try again.");
            }
            else {
              selectedCoordinates.add(coordinate);
              validChoice = true;
            }
          }
        }
        
        opponent.receiveAttack(attackX, attackY);
        playerTurn = false;
      }

      // CPU's turn
      else {     
        int attackX = (int)(Math.random() * 9);
        int attackY = (int)(Math.random() * 9);

        // If point has already been selected, try again
        while (selected[attackX][attackY] == true) {
          attackX = (int)(Math.random() * 9);
          attackY = (int)(Math.random() * 9);
        }

        selected[attackX][attackY]= true;
        
        thePlayer.receiveAttack(attackX, attackY);
        
        playerTurn = true;
      }

      // Check for a winner
      if (thePlayer.numUnits == 0 || opponent.numUnits == 0) {
        gameOver = true;
        if (thePlayer.numUnits == 0) {
          playerWins = false;
        }
      }

      // Refresh screen
      clearScreen();
    }
    

    // Game's over, display who wins
    if (playerWins) {
      System.out.println("You win!! Good job!\nHere are the final grids:\n");
    }
    else {
      System.out.println("You lose...\nHere are the final grids:\n");
    }
    
    thePlayer.displayBoard();
    System.out.print("\n");
    opponent.displayBoard();
    
  }
}
