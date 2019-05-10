

/**
 * Abhinav Chowdavarapu and Alex He
 * 5/3/19
 */
import javax.imageio.ImageIO;
public class Queen extends Pieces
{
    private double defendPercent;
    public Queen()
    {
        super(5,4,4,1);
        defendPercent = 0.1;
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
