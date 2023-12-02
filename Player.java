public class Player {

  // Member variables
  public Ship[] ships;
  public String[][] board;
  public int boardSize;
  public int numUnits;

  // Constructor
  public Player() {
    this.numUnits = 12;    // should be 12 X's on the board (5+3+2+1+1)
    this.ships = new Ship[5];
    board = new String[10][10];
  }

  // Preconditions: The 'board' variable must be initialized with valid data representing the opponent's grid.
  // Postconditions: The player's own grid, represented by the 'board' variable, is displayed on the console with all the cells visible, including ships and empty spaces. The grid is formatted with row and column headers.
  public void displayBoard() {
    System.out.println("Your grid:\n");
    System.out.println("   0 1 2 3 4 5 6 7 8 9");
    for (int i = 0; i < 10; i++) {    
      System.out.print(i + "  ");
      for (int j = 0; j < 10; j++) {
        System.out.print(board[i][j] + " ");
      }
      // Moves the cursor to the next line before the next row.
      System.out.print("\n");
    }
  }
  
  // Preconditions: The 'board' variable must be initialized with valid data representing the opponent's grid. Ship[] array must also be initialized with size 5.
  // Postconditions: Generates 5 random ships, and puts them on the board without overlap
  public void deployShips() {
    
    // Count will track how many X's are on the board
    int count = 0;

    // If there is overlap of ships, keep trying new configurations of 5 new ships 
    // until there are 12 X's on the board 
    while (count < 12) {
      // Reset board
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
          board[i][j] = "□";
        }
      }
    
      // Reset count to 0 X's
      count = 0;
      
      // Fill ship array with 5 ships
      ships[0] = new Ship(1);    // size 1 
      ships[1] = new Ship(1);    // size 1 
      ships[2] = new Ship(2);    // size 2  
      ships[3] = new Ship(3);    // size 3  
      ships[4] = new Ship(5);    // size 5  
      
      // Put the ships on the board
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < ships[i].size; j++) {
          if (ships[i].vertical == true) {
            board[ships[i].x + j][ships[i].y] = "X";
          }
          else {
            board[ships[i].x][ships[i].y + j] = "X";
          }
        }
      }

      // Check how many units were deployed onto grid (how many X's):
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
          if (board[i][j].equals("X")) {
            count++;
          }
        }
      }
      
    }
  }

  // Preconditions: None
  // Postconditions: The 'board' variable is initialized with a blank game board, where each cell is set to "□".
  public void initializeBoard() {
    // Make blank game board
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        board[i][j] = "□";
      }
    }
    
    // Generates 5 random ships, and puts them on the board
    deployShips();
  }

  // Preconditions: The 'board' variable must be initialized with valid data representing the game board. The 'x' and 'y' parameters should be within the valid range of indices for the 'board' array.
  // Postconditions: The cell at coordinates (x, y) on the 'board' variable is updated based on the attack result. If the cell contains "X", indicating a ship, it is updated to "■" to represent a hit, and the 'numUnits' variable is decremented. If the cell does not contain "X", it is updated to "◪" to represent a miss.
  public void receiveAttack(int x, int y) {
    if (board[x][y].equals("X")) {
      // Enemy has hit a ship
      board[x][y] = "■";
      numUnits--;
    }
    else {
      // Missed
      board[x][y] = "◪";
    }
  }

  
}