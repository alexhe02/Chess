

/**
 * Abhinav Chowdavarapu and Alex He
 * 5/2/19
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.io.IOException;
public abstract class Pieces
{
    protected int levelcost;
    protected int level;
    protected int experience;
    protected int health;
    protected int damage;
    protected int attack;
    protected int experienceondeath;
    protected boolean blocking;
    protected int numblocks;
    protected boolean dead;
    protected Image sprite;
    public Pieces(int levelcost, int health, int attack, int experienceondeath)
    {
        //stores the information that the subclasses will give it
        level = 1;
        experience = 0;
        this.levelcost = levelcost;
        this.health = health;
        this.damage = 0;
        this.attack = attack;
        this.experienceondeath = experienceondeath;
        blocking = false;
        numblocks = 0;
        dead = false;
        
    }
    
    public void attack(Pieces other)
    {
        //deals damage if not blocking and removes block if blocking
        if (!other.blocking)
        {
            other.damage += attack;
        }
        else
        {
            other.blocking = false;
        }
    }
    
    public void block()
    {
        //blocks and adds one to numblocks if numblocks < 6
        if (numblocks < 6)
        {
            blocking = true;
            numblocks += 1;
        }
    }
    
   
    public void die(Pieces other)
    {
        //checks if dead
        //if true, dies and gives experienceondeath to the piece it was fighting
        if (damage >= health)
        {
            this.dead = true;
            other.experience += this.experienceondeath;
        }
    }
    
    public void draw(Graphics page)
    {
        page.drawImage(sprite, 10, 10, null);
        
    }
}
