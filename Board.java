
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
            if((boardstate[newx][newy] == null) || (boardstate[newx][newy] != null && boardstate[newx][newy].type != currentpiece.type))
            {
                if(currentpiece instanceof Pawns)
                {
                    if(!currentpiece.type)//checks type of pawn
                    {
                        if(boardstate[newx][newy] == null)//checks if moves to empty space
                        {
                            if((currentx == 1 && (newx - 2) == currentx && newy == currenty && boardstate[2][currenty] == null))//double move for first move
                            {
                                boardstate[newx][newy] = currentpiece;
                                boardstate[currentx][currenty] = null;
                                currentpiece = null;
                                turn = !turn;
                            }
                            else if(((newx - 1) == currentx && newy == currenty))//single move otherwise
                            {
                                boardstate[newx][newy] = currentpiece;
                                boardstate[currentx][currenty] = null;
                                currentpiece = null;
                                turn = !turn;
                            }
                            else//resets if invalid
                            {
                                currentpiece = null;
                            }
                        }
                        else//if trying to take a piece
                        {
                            if(currenty == 0)//checks if top piece
                            {
                                if((newx - 1) == currentx && (newy - 1) == currenty)//attack once ready
                                {//checks if piece is diagonal below to take
                                    boardstate[newx][newy] = currentpiece;
                                    boardstate[currentx][currenty] = null;
                                    currentpiece = null;
                                    turn = !turn;
                                }
                                else
                                {//resets otherwise
                                    currentpiece = null;
                                }
                            }
                            else if (currenty == 7)//checks if bottom piece
                            {
                                if((newx - 1) == currentx && (newy + 1) == currenty)//attack once ready
                                {//checks if piece is diagonal above to take
                                    boardstate[newx][newy] = currentpiece;
                                    boardstate[currentx][currenty] = null;
                                    currentpiece = null;
                                    turn = !turn;
                                }
                                else
                                {//resets otherwise
                                    currentpiece = null;
                                }
                            }
                            else//if not top or bottom pawn
                            {
                                if(((newx - 1) == currentx && (newy + 1) == currenty) || ((newx - 1) == currentx && (newy - 1) == currenty))//attack once ready
                                {//checks if piece is diagonal above to take
                                    boardstate[newx][newy] = currentpiece;
                                    boardstate[currentx][currenty] = null;
                                    currentpiece = null;
                                    turn = !turn;
                                }
                                else
                                {//resets otherwise
                                    currentpiece = null;
                                }
                            }
                        }
                    }
                    else
                    {//repeats with black pieces
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
                            else
                            {
                                if(((newx + 1) == currentx && (newy + 1) == currenty) || ((newx + 1) == currentx && (newy - 1) == currenty))
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
                    if((Math.abs(currentx-newx) == 2 && Math.abs(currenty-newy) == 1) || (Math.abs(currentx-newx) == 1 && Math.abs(currenty - newy) == 2))
                    {//checks if knight is moving in an l shape
                        if(boardstate[newx][newy] == null)//just moves if empty
                        {
                            boardstate[newx][newy] = currentpiece;
                            boardstate[currentx][currenty] = null;
                            currentpiece = null;
                            turn = !turn;
                        }
                        else//attack once ready
                        {
                            boardstate[newx][newy] = currentpiece;
                            boardstate[currentx][currenty] = null;
                            currentpiece = null;
                            turn = !turn;
                        }
                    }
                    else
                    {//resets otherwise
                        currentpiece = null;
                    }
                }
                else if(currentpiece instanceof Bishop)
                {
                    if((Math.abs(currentx-newx) == Math.abs(currenty-newy)))
                    {
                        boolean unobstructed = true;
                        //next couple loops check if the bishop is unobstructed
                        if(currentx < newx && currenty < newy)
                        {
                            for(int i = currentx + 1, j = currenty + 1; i < newx; i++, j++)
                            {
                                if(boardstate[i][j] != null)
                                {
                                    unobstructed = false;
                                }
                            }
                        }
                        else if(currentx > newx && currenty > newy)
                        {
                            for(int i = currentx - 1, j = currenty - 1; i > newx; i--, j--)
                            {
                                if(boardstate[i][j] != null)
                                {
                                    unobstructed = false;
                                }
                            }
                        }
                        else if(currentx > newx && currenty < newy)
                        {
                            for(int i = currentx - 1, j = currenty + 1; i > newx; i--, j++)
                            {
                                if(boardstate[i][j] != null)
                                {
                                    unobstructed = false;
                                }
                            }
                        }
                        else if(currentx < newx && currenty > newy)
                        {
                            for(int i = currentx + 1, j = currenty - 1; i < newx; i++, j--)
                            {
                                if(boardstate[i][j] != null)
                                {
                                    unobstructed = false;
                                }
                            }
                        }
                        if(unobstructed)
                        {
                            if(boardstate[newx][newy] == null)
                            {//moves to square
                                boardstate[newx][newy] = currentpiece;
                                boardstate[currentx][currenty] = null;
                                currentpiece = null;
                                turn = !turn;
                            }
                            else
                            {//attack once ready
                                boardstate[newx][newy] = currentpiece;
                                boardstate[currentx][currenty] = null;
                                currentpiece = null;
                                turn = !turn;
                            }
                        }
                        else
                        {//resets if obstructed
                            currentpiece = null;
                        }
                    }
                    else
                    {//resets otherwise
                        currentpiece = null;
                    }
                }
            
                else if(currentpiece instanceof Rook)
                {
                    if(Math.abs(currentx-newx) == 0 || Math.abs(currenty-newy) == 0)
                    {//checks if moving horizontal or vertical
                        boolean unobstructed = true;
                        //next loops check if piece is unobstructed
                        if(currentx > newx)
                        {
                            for(int i = currentx - 1; i > newx; i--)
                            {
                                if(boardstate[i][currenty] != null)
                                {
                                    unobstructed = false;
                                }
                            }
                        }
                        else if(currentx < newx)
                        {
                            for(int i = currentx + 1; i < newx; i++)
                            {
                                if(boardstate[i][currenty] != null)
                                {
                                    unobstructed = false;
                                }
                            }
                        }
                        else if(currenty > newy)
                        {
                            for(int i = currenty - 1; i > newy; i--)
                            {
                                if(boardstate[currentx][i] != null)
                                {
                                    unobstructed = false;
                                }
                            }
                        }
                        else if(currenty < newy)
                        {
                            for(int i = currenty + 1; i < newy; i++)
                            {
                                if(boardstate[currentx][i] != null)
                                {
                                    unobstructed = false;
                                }
                            }
                        }
                        if(unobstructed)
                        {
                            if(boardstate[newx][newy] == null)
                            {
                                boardstate[newx][newy] = currentpiece;
                                boardstate[currentx][currenty] = null;
                                currentpiece = null;
                                turn = !turn;
                            }
                            else
                            {//attack once ready
                                boardstate[newx][newy] = currentpiece;
                                boardstate[currentx][currenty] = null;
                                currentpiece = null;
                                turn = !turn;
                            }
                        }
                        else
                        {
                            currentpiece = null;
                        }
                    }
                    else
                    {//resets otherwise
                        currentpiece = null;
                    }
                }
                else if(currentpiece instanceof Queen)
                {
                    if(newx == currentx || newy == currenty || (Math.abs(newx-currentx) == Math.abs(newy-currenty)))
                    {
                        boolean unobstructed = true;
                        if(newx == currentx && newy > currenty)
                        {
                            for(int i = currenty + 1; i < newy; i++)
                            {
                                if(boardstate[currentx][i] != null)
                                {
                                    unobstructed = false;
                                }
                            }
                        } 
                        else if(newx == currentx && newy < currenty)
                        {
                            for(int i = currenty - 1; i > newy; i--)
                            {
                                if(boardstate[currentx][i] != null)
                                {
                                    unobstructed = false;
                                }
                            }
                        }
                        else if(newy == currenty && newx < currentx)
                        {
                            for(int i = currentx - 1; i > newx; i--)
                            {
                                if(boardstate[i][currenty] != null)
                                {
                                    unobstructed = false;
                                }
                            }
                        }
                        else if(newy == currenty && newx > currentx)
                        {
                            for(int i = currentx + 1; i < newx; i++)
                            {
                                if(boardstate[i][currenty] != null)
                                {
                                    unobstructed = false;
                                }
                            }
                        }
                        else if(newx > currentx && newy > currenty)
                        {
                            for(int i = currentx + 1, j = currenty + 1; i < newx; i++,j++)
                            {
                                if(boardstate[i][j] != null)
                                {
                                    unobstructed = false;
                                }
                            }
                        }
                        else if(newx < currentx && newy < currenty)
                        {
                            for(int i = currentx - 1, j = currenty - 1; i > newx; i--,j--)
                            {
                                if(boardstate[i][j] != null)
                                {
                                    unobstructed = false;
                                }
                            }
                        }
                        else if(newx > currentx && newy < currenty)
                        {
                            for(int i = currentx + 1, j = currenty - 1; i < newx; i++,j--)
                            {
                                if(boardstate[i][j] != null)
                                {
                                    unobstructed = false;
                                }
                            }
                        }
                        else if(newx < currentx && newy > currenty)
                        {
                            for(int i = currentx - 1, j = currenty + 1; i > newx; i--, j++)
                            {
                                if(boardstate[i][j] != null)
                                {
                                    unobstructed = false;
                                }
                            }
                        }
                        if(unobstructed)
                        {
                            if(boardstate[newx][newy] == null)
                            {
                                boardstate[newx][newy] = currentpiece;
                                boardstate[currentx][currenty] = null;
                                currentpiece = null;
                                turn = !turn;
                            }
                            else
                            {//attack once ready
                                boardstate[newx][newy] = currentpiece;
                                boardstate[currentx][currenty] = null;
                                currentpiece = null;
                                turn = !turn;
                            }
                        }
                        else
                        {
                            currentpiece = null;
                        }
                    }
                    else
                    {
                        currentpiece = null;
                    }
                }
                else if(currentpiece instanceof King)
                {
                    if(Math.abs(currentx-newx) <= 1 && Math.abs(currenty-newy) == 1)
                    {
                        if(boardstate[newx][newy] == null)
                        {
                            boardstate[newx][newy] = currentpiece;
                            boardstate[currentx][currenty] = null;
                            currentpiece = null;
                            turn = !turn;
                        }
                        else
                        {//attack once ready
                            boardstate[newx][newy] = currentpiece;
                            boardstate[currentx][currenty] = null;
                            currentpiece = null;
                            turn = !turn;
                        }
                    }
                    else
                    {
                        currentpiece = null;
                    }
                }
            }
            else
            {//resets if trying to take own piece
                currentpiece = null;
            }
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
                            Color Black = new Color(13,13,13);
                            g.setColor(Black);
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
                            g.setColor(Color.GRAY); 
                            g.fillRect(x, y, 60, 60);
                            g.drawImage(boardstate[row][col].getSprite(),row*60,col*60,null);
                        }
                    }
                } 
            }
        }
    } 
} 