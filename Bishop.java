

/**
 * Abhinav Chowdavarapu and Alex He
 * 5/2/19
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.applet.*;
import java.lang.*;
import javax.swing.*;
import java.io.IOException;
import java.io.File;
public class Bishop extends Pieces
{
    private int healamount;
    private int numheals;
    public Bishop(boolean input)
    {
        super(3,2,2,3,input);
        setSprite(input);
        healamount = 3;
        numheals = 0;
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
                sprite = ImageIO.read(new File("Images/Black Bishop Board.jpg"));
            }
            else
            {
                sprite = ImageIO.read(new File("Images/White Bishop Board.jpg"));
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
    
    public void heal()
    {
        if (numheals < 4)
        {
            if (damage < healamount)
            {
                damage = 0;
            }
            else
            {
                damage -= healamount;
            }
            numheals += 1;
        }
    }
    
    public void levelUp()
    {
        while (experience >= levelcost)
        {
            level += 1;
            experience -= levelcost;
            attack += 1;
            health += 1;
            healamount += 1;
        }
    }
    
    public void die(Pieces other)
    {
        super.die(other);
    }
}
