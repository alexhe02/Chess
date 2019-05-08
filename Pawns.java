

/**
 * Abhinav Chowdavarapu and Alex He
 * 5/2/19
 */
public class Pawns extends Pieces
{
    private int enPassantdamage;
    public Picture thisguy;
    public Pawns()
    {
        super(3,1,1,1);
        enPassantdamage = 2;
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
