
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
    public static Pieces currentpiece;
    public static int currentx;
    public static int currenty;
    public static int newx;
    public static int newy;
    public static boolean turn;
    public static boolean attacksequence;
    public void init()
    {
        for (int i = 0; i < boardstate.length; i++)
        {
            boardstate[1][i] = new Pawns(false);
            boardstate[6][i] = new Pawns(true);
        }
        boardstate[0][1] = new Knight(false);
        boardstate[7][1] = new Knight(true);
        boardstate[0][6] = new Knight(false);
        boardstate[7][6] = new Knight(true);
        boardstate[0][0] = new Rook(false);
        boardstate[7][0] = new Rook(true);
        boardstate[0][7] = new Rook(false);
        boardstate[7][7] = new Rook(true);
        boardstate[0][2] = new Bishop(false);    
        boardstate[7][2] = new Bishop(true);
        boardstate[0][5] = new Bishop(false);
        boardstate[7][5] = new Bishop(true);
        boardstate[0][3] = new King(false);
        boardstate[7][3] = new King(true);
        boardstate[0][4] = new Queen(false);
        boardstate[7][4] = new Queen(true);
        addMouseListener(this);
        turn = false;
        attacksequence = false;
    }

    public void mouseClicked(MouseEvent m)
    {
        if(currentpiece == null)
        {
            currentx = m.getX()/60;
            currenty = m.getY()/60;
            currentpiece = boardstate[currentx][currenty];
            if(turn != currentpiece.type)
            {
                currentpiece = null;
            }
        }
        else
        {
            newx = m.getX()/60;
            newy = m.getY()/60;
            //if(boardstate[newx][newy] != null && boardstate[newx][newy].type != currentpiece.type)
            //{
                if(currentpiece instanceof Pawns)
                {
                    if(!currentpiece.type)
                    {
                        if(boardstate[newx][newy] == null)
                        {
                            if((currentx == 1 && (newx - 2) == currentx && newy == currenty))
                            {
                                boardstate[newx][newy] = currentpiece;
                                boardstate[currentx][currenty] = null;
                                currentpiece = null;
                                turn = !turn;
                            }
                            else if(((newx - 1) == currentx && newy == currenty))
                            {
                                boardstate[newx][newy] = currentpiece;
                                boardstate[currentx][currenty] = null;
                                currentpiece = null;
                                turn = !turn;
                            }
                            else
                            {
                                currentpiece = null;
                            }
                        }
                        else
                        {
                            if(currenty == 0)
                            {
                                if((newx - 1) == currentx && (newy - 1) == currenty)//attack once ready
                                {
                                    boardstate[newx][newy] = currentpiece;
                                    boardstate[currentx][currenty] = null;
                                    currentpiece = null;
                                    turn = !turn;
                                }
                                else
                                {
                                    currentpiece = null;
                                }
                            }
                            else if (currenty == 7)
                            {
                                if((newx - 1) == currentx && (newy + 1) == currenty)//attack once ready
                                {
                                    boardstate[newx][newy] = currentpiece;
                                    boardstate[currentx][currenty] = null;
                                    currentpiece = null;
                                    turn = !turn;
                                }
                                else
                                {
                                    currentpiece = null;
                                }
                            }
                            else
                            {
                                if(((newx - 1) == currentx && (newy + 1) == currenty) || ((newx - 1) == currentx && (newy - 1) == currenty))
                                {
                                    boardstate[newx][newy] = currentpiece;
                                    boardstate[currentx][currenty] = null;
                                    currentpiece = null;
                                    turn = !turn;
                                }
                                else
                                {
                                    currentpiece = null;
                                }
                            }
                        }
                    }
                    else
                    {
                        if(boardstate[newx][newy] == null)
                        {
                            if((currentx == 6 && (newx + 2) == currentx && newy == currenty) || ((newx + 1) == currentx && newy == currenty))
                            {
                                boardstate[newx][newy] = currentpiece;
                                boardstate[currentx][currenty] = null;
                                currentpiece = null;
                                turn = !turn;
                            }
                            else
                            {
                                currentpiece = null;
                            }
                        }
                        else
                        {
                            if(currenty == 0)
                            {
                                if((newx + 1) == currentx && (newy - 1) == currenty)//attack once ready
                                {
                                    boardstate[newx][newy] = currentpiece;
                                    boardstate[currentx][currenty] = null;
                                    currentpiece = null;
                                    turn = !turn;
                                }
                                else
                                {
                                    currentpiece = null;
                                }
                            }
                            else if (currenty == 7)
                            {
                                if((newx + 1) == currentx && (newy + 1) == currenty)//attack once ready
                                {
                                    boardstate[newx][newy] = currentpiece;
                                    boardstate[currentx][currenty] = null;
                                    currentpiece = null;
                                    turn = !turn;
                                }
                                else
                                {
                                    currentpiece = null;
                                }
                            }
                        }
                    }
                }
                else if(currentpiece instanceof Knight)
                {
                    
                }
                else//for rest of pieces while testing
                {
                    if (newx != currentx || newy != currenty)
                    {
                        boardstate[newx][newy] = currentpiece;
                        boardstate[currentx][currenty] = null;
                        currentpiece = null;
                        turn = !turn;
                    }
                    else
                    {
                        currentpiece = null;
                    }
                }
            //}
            //else
            //{
            //    currentpiece = null;
            //}
        }
        repaint();
    }

    public void mousePressed(MouseEvent m)
    {
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
        if(!attacksequence)
        {
            int x, y; 
            for (int row = 0; row < 8; row++) { 
    
                for (int col = 0; col < 8; col++) { 
                    x = row * 60; 
                    y = col * 60; 
                    if ((row % 2 == 0) == (col % 2 == 0)) 
                    {
                        if(boardstate[row][col] == null)
                        {
                            Color Black = new Color(13,13,13);
                            g.setColor(Black);
                        }
                        else
                        {
                            g.drawImage(boardstate[row][col].getSprite(),row*60,col*60,null);
                        }
                    }
                    else
                    {
                        if(boardstate[row][col] == null)
                        {
                            g.setColor(Color.GRAY); 
                            g.fillRect(x, y, 60, 60);
                        }
                        else
                        {
                            g.drawImage(boardstate[row][col].getSprite(),row*60,col*60,null);
                        }
                    }
                } 
            }
        }
    } 
} 