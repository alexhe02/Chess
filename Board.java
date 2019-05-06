

/**
 * Abhinav Chowdavarapu and Alex He
 * 5/6/19
 */
import java.awt.*; 
import java.applet.*; 
  

public class Board extends Applet { 
    
    
    //painting the board copied from https://www.geeksforgeeks.org/draw-a-chessboard-in-java-applet/
    //shortened code a little, changed the number of rows and columns to 8, and changed the size of the rectangles
    public void paint(Graphics g) 
    { 
        int x, y; 
        for (int row = 0; row < 8; row++) { 
  
            for (int col = 0; col < 8; col++) { 
                x = row * 60; 
                y = col * 60; 
                if ((row % 2 == 0) == (col % 2 == 0)) 
                    g.setColor(Color.BLACK); 
                else
                    g.setColor(Color.WHITE); 
                g.fillRect(x, y, 60, 60); 
            } 
        } 
    } 
} 