package Lichs_Quarters;

import A_Super.Direction;
/**
 * @author Kevin Rapa
 */
public class Lqu1 extends Lich_Room {
// ============================================================================    
    public Lqu1(String name, String ID) {
        super(name, ID);
        this.description= "You have made your way into the west end of a large\n" +
                          "bedroom. On the far eastern side, you can see a %\n" +
                          "body laying on a bed. On your side of the room, a\n" +
                          "mirror and wardobe furnish the north wall. A wood\n" +
                          "chest and tall display cabinet stand against the south\n" +
                          "wall. A large lavender carpet lies on the floor.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.EAST)
            return "You shouldn't get to close to that thing over there...";
        else
            return bumpIntoWall();
    }
// ============================================================================
    @Override public String getDescription() {
        String modifier = this.lichDead ? "lifeless" : "breathing";
        
        return this.description.replaceFirst("%", modifier);
    }
// ============================================================================
}