import java.util.*;

public class Ship {
  public int size;
  public boolean vertical;
  public int x;
  public int y;

  // Default constructor
  public Ship(int s) {
    this.size = s;
    Random rd = new Random(); 
    // if vertical is true.. ship is vertical. and vice versa
    this.vertical = rd.nextBoolean();  

    // Different cases... give appropriate starting positions for each 
    // ship based on its size and orientation so it can fit on the 10x10 board
    if (vertical) {
      if (size == 2) {
        this.x = (int)(Math.random() * 8);
      }
      else if (size == 3) {
        this.x = (int)(Math.random() * 7);
      }
      else if (size == 5) {
        this.x = (int)(Math.random() * 5);
      }
      else {
        this.x = (int)(Math.random() * 10);
      }
      this.y = (int)(Math.random()*9);
    }

    // horizontal
    else {
      if (size == 2) {
        this.y = (int)(Math.random() * 8);
      }
      else if (size == 3) {
        this.y = (int)(Math.random() * 7);
      }
      else if (size == 5) {
        this.y = (int)(Math.random() * 5);
      }
      else {
        this.y = (int)(Math.random() * 10);
      }
      this.x = (int)(Math.random()*9);
    }
    
  }
}