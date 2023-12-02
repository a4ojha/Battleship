public class CPU extends Player {

  // Preconditions: The 'board' variable must be initialized with valid data representing the opponent's grid.
  // Postconditions: The opponent's final grid, represented by the 'board' variable, is displayed on the console with all the cells visible, including ships and empty spaces. The grid is formatted with row and column headers.
  public void displayBoard() {
    System.out.println("Opponent final grid:\n");
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

  // Preconditions: The 'board' variable must be initialized with valid data representing the opponent's grid.
  // Postconditions: The opponent's grid is displayed on the console, hiding the ships and replacing them with '□', while other cells are shown as per their original values.
  public void displayHiddenBoard() {
    System.out.println("Opponent grid:\n");
    System.out.println("   0 1 2 3 4 5 6 7 8 9");
    for (int i = 0; i < 10; i++) {    
      System.out.print(i + "  ");
      for (int j = 0; j < 10; j++) {
        
        // We don't want to reveal the opponent's ships, so replace X's with normal grid
        if (!board[i][j].equals("X")) {      
          System.out.print(board[i][j] + " ");
        }
        else {
          System.out.print("□" + " ");
        }
        
      }
      // Moves the cursor to the next line before the next row.
      System.out.print("\n");
    }
  }
  
}