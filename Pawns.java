

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
public class Pawns extends Pieces
{
    private int enPassantdamage;
    public ImageIO thisguy;
    public Pawns(boolean input)
    {
        super(3,1,1,1,input);
        enPassantdamage = 2;
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
                sprite = ImageIO.read(new File("Images/Black Pawn Board.png"));
            }
            else
            {
                sprite = ImageIO.read(new File("Images/White Pawn Board.png"));
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
    
    public void EnPassant(Pieces other)
    {
        if (other instanceof Pawns)
        {
            if (!other.blocking)
            {
                other.damage += this.enPassantdamage;
            }
            else
            {
                other.blocking = false;
            }
        }
        else
        {
            if (!other.blocking)
            {
                other.damage += this.attack;
            }
            else
            {
                other.blocking = false;
            }
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
            enPassantdamage += 1;
        }
    }
    
    public void die(Pieces other)
    {
        super.die(other);
    }
}
