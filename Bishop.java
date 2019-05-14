

/**
 * Abhinav Chowdavarapu and Alex He
 * 5/2/19
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.applet.*;
import java.lang.*;
import javax.swing.*;
public class Bishop extends Pieces
{
    private int healamount;
    private int numheals;
    public Bishop()
    {
        super(3,2,2,3,getImage(getDocumentBase(),"Black Bishop Board"));
        healamount = 3;
        numheals = 0;
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
