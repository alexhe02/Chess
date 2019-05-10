

/**
 * Abhinav Chowdavarapu and Alex He
 * 5/2/19
 */
import javax.imageio.ImageIO;
public class Knight extends Pieces
{
    private int trampledamage;
    public Knight()
    {
        super(5,2,2,3);
        trampledamage = 2;
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
