

/**
 * Abhinav Chowdavarapu and Alex He
 * 5/3/19
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.applet.*;
import java.lang.*;
import javax.swing.*;
import java.io.IOException;
import java.io.File;
public class Queen extends Pieces
{
    private double defendPercent;
    public Queen(boolean input)
    {
        super(5,4,4,1,input);
        defendPercent = 0.1;
        setSprite(input);
    }
    
    /**
     * With help from Henry
     */
    public void setSprite(boolean input)
    {
        try
        {
            if(input)
            {
                sprite = ImageIO.read(new File("Images/Black Queen Board.png"));
            }
            else
            {
                sprite = ImageIO.read(new File("Images/White Queen Board.png"));
            }
        }catch (IOException e){
        }

    }
    
    public void attack(Pieces other)
    {
        super.attack(other);
    }
    
    public void block()
    {
        super.block();
    }
    
    public void levelUp()
    {
        while (experience >= levelcost)
        {
            experience -= levelcost;
            level += 1;
            attack += 1;
            health += 1;
            defendPercent += 0.05;
        }
    }
}
