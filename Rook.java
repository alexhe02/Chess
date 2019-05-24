

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
public class Rook extends Pieces
{
    protected double fortifypercent;
    public Rook(boolean input)
    {
        super(5,1,3,5,input);
        fortifypercent = .1;
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
                sprite = ImageIO.read(new File("Images/Black Rook Board.png"));
            }
            else
            {
                sprite = ImageIO.read(new File("Images/White Rook Board.png"));
            }
        }catch (IOException e){
        }

    }
    public void attack (Pieces other)
    {
        super.attack(other);
    }
    
    public void block()
    {
        super.block();
    }
    
    public void levelUp()
    {
        while(experience >= levelcost)
        {
            experience -= levelcost;
            level += 1;
            attack += 1;
            health += 1;
            fortifypercent += 0.05;
        }
    }
    
    public void die(Pieces other)
    {
        super.die(other);
    }
}
