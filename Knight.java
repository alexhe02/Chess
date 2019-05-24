

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
public class Knight extends Pieces
{
    private int trampledamage;
    public Knight(boolean input)
    {
        super(5,2,2,3,input);
        trampledamage = 2;
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
                sprite = ImageIO.read(new File("Images/Black Knight Board.png"));
            }
            else
            {
                sprite = ImageIO.read(new File("Images/White Knight Board.png"));
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
    
    public void Trample(Pieces other)
    {
        if (other.blocking)
        {
            other.blocking = false;
        }
        else if (other.level == 1)
        {
            other.damage += trampledamage;
        }
        else
        {
            other.damage += trampledamage/2;
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
            trampledamage += 1;
        }
    }
    
    public void die(Pieces other)
    {
        super.die(other);
    }
}
