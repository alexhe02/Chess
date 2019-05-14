

/**
 * Abhinav Chowdavarapu and Alex He
 * 5/6/19
 */

import java.awt.*; 
import java.applet.*; 
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.imageio.ImageIO;
public class Board extends Applet implements MouseListener {
    public static Pieces[][] boardstate = new Pieces[8][8];
    
    public static void main(String[] args)
    {
        for (int i = 0; i < boardstate.length; i++)
        {
            boardstate[1][i] = new Pawns();
            boardstate[6][i] = new Pawns();
        }
        boardstate[1][0] = new Knight();
        boardstate[1][7] = new Knight();
        boardstate[6][0] = new Knight();
        boardstate[6][7] = new Knight();
        boardstate[0][0] = new Rook();
        boardstate[0][7] = new Rook();
        boardstate[7][0] = new Rook();
        boardstate[7][7] = new Rook();
<<<<<<< HEAD
        boardstate[2][0] = new Bishop();
        
        boardstate[2][7] = new Bishop();
        boardstate[5][2] = new Bishop();
        boardstate[5][7] = new Bishop();
        boardstate[3][0] = new King();
        boardstate[3][7] = new King();
        boardstate[4][0] = new Queen();
        boardstate[4][7] = new Queen();
=======
        boardstate[0][2] = new Bishop();
        boardstate[7][2] = new Bishop();
        boardstate[0][5] = new Bishop();
        boardstate[7][5] = new Bishop();
        boardstate[0][3] = new King();
        boardstate[7][3] = new King();
        boardstate[0][4] = new Queen();
        boardstate[7][4] = new Queen();
>>>>>>> parent of b3b6f44... Fixed some issues with the images
    }
    
    public void mouseClicked(MouseEvent m)
    {
        repaint();
    }
    
    public void mousePressed(MouseEvent m)
    {
        repaint();
    }
    
    public void mouseReleased(MouseEvent m)
    {
    }
    
    public void mouseEntered(MouseEvent m)
    {
    }
    
    public void mouseExited(MouseEvent m)
    {
    }
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
                {
                    if (boardstate[row][col] == null)
                    {
                        Color Black = new Color(13,13,13);
                        g.setColor(Black);
                    }
                    else
                    {
                        
                    }
                }
                else
                {
                    if(boardstate[row][col] == null)
                    {
                        g.setColor(Color.GRAY); 
                        g.fillRect(x, y, 60, 60);
                    }
                }
            } 
        } 
    } 
} 