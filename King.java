

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
public class King extends Pieces
{
    private double damageReduction;
    private int tempattack;
    public King(boolean input)
    {
        super(16,3,1,2,input);
        damageReduction = 0.1;
        tempattack = attack;
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
                sprite = ImageIO.read(new File("Images/Black King Board.png"));
            }
            else
            {
                sprite = ImageIO.read(new File("Images/White King Board.png"));
            }
        }catch (IOException e){
        }

    }
    
    
    public void block()
    {
        super.block();
    }
    
    public void charge()
    {
        tempattack *= 2;
    }
    
    public void attack(Pieces other)
    {
        if (other.blocking)
        {
            tempattack = attack;
            other.blocking = false;
        }
        else
        {
            other.damage += tempattack;
            tempattack = attack;
        }
    }
    
    public void levelUp()
    {
        while (experience >= levelcost)
        {
            experience -= levelcost;
            level += 1;
            attack += 1;
            health += 1;
            damageReduction += 0.05;
        }
    }
}
