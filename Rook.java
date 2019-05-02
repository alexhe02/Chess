

/**
 * Abhinav Chowdavarapu and Alex He
 * 5/2/19
 */
public class Rook extends Pieces
{
    protected double fortifypercent;
    public Rook()
    {
        super(5,1,3,5);
        fortifypercent = .1;
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
