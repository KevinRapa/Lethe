package Lichs_Quarters;

import A_Super.Direction;
/**
 * Contains a display case holding the dampening staff, needed to obtain the 
 * fifth phylactery, and a chest holding the player's items after being captured.
 * 
 * @see Attic.Att1#dialog() 
 * @see Lichs_Quarters.Lqu1_Chest
 * @see Lichs_Quarters.Lqu1_Cabinet
 * @author Kevin Rapa
 */
public class Lqu1 extends Lich_Room {
//-----------------------------------------------------------------------------    
    public Lqu1(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.EAST)
            return "You shouldn't get to close to that thing over there...";
        else
            return bumpIntoWall();
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        String modifier = this.lichDead ? "lifeless" : "breathing";
        
        return super.getDescription().replaceFirst("%", modifier);
    }
//-----------------------------------------------------------------------------
}