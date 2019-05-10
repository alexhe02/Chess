

/**
 * Abhinav Chowdavarapu and Alex He
 * 5/3/19
 */
import javax.imageio.ImageIO;
public class King extends Pieces
{
    private double damageReduction;
    private int tempattack;
    public King()
    {
        super(16,3,1,2);
        damageReduction = 0.1;
        tempattack = attack;
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
