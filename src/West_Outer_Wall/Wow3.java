package West_Outer_Wall;

import A_Main.AudioPlayer;
import A_Super.Room;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Furniture;
import A_Super.Item;

public class Wow3 extends Room {
    private final Item LDDRITEM_REF;
    private final Furniture WOW2LDDR_REF, FLR_REF, WOW3LDDR_REF;
    private boolean triggerHppnd;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow3(String name, String ID, Furniture wow2lddr, 
                Furniture flr, Furniture wow3Lddr, Item Ilddr) {
        super(name, ID);
        this.WOW2LDDR_REF = wow2lddr;
        this.LDDRITEM_REF = Ilddr;
        this.FLR_REF = flr;
        this.WOW3LDDR_REF = wow3Lddr;
        this.triggerHppnd = false;
        this.description = "You stand atop the small balcony overlooking the\n" +
                           "west outer wall. You feel claustrophobic. A large\n" +
                           "wood shelf blocks a door to the north. Immediately\n" +
                           "to your east, there's another door covered in gashes\n"
                         + "and splinters.";
    }
/*----------------------------------------------------------------------------*/        
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.NORTH) {
            AudioPlayer.playEffect(6);
            return "There's a large shelf in the way.";
        }
        else if (dir == Direction.WEST)
            return "There's a railing there, and that drop looks intimidating.";
        
        AudioPlayer.playEffect(6);
        return "There's a wall in the way.";
    }
/*----------------------------------------------------------------------------*/  
    @Override public String triggeredEvent() {
        Room wow2 = Player.getRoomRef("WOW2");
                
        if (! Player.getLastVisited().matches("GQUA")) {
            if (this.triggerHppnd) {
                if (! this.hasFurniture("ladder"))
                    this.addFurniture(WOW3LDDR_REF);
                return "The ladder creaks with instability. You were more\n"
                     + "careful in scaling the ladder this time.";
            }
            else {
                wow2.removeFurniture(WOW2LDDR_REF);
                FLR_REF.getInv().add(LDDRITEM_REF);
                this.triggerHppnd = true;
                return "You successfully scale the ladder, but you accidentally\n"
                    + "knock it down with your final step, you uncoordinated oaf.";
            }               
        }
        else
            return "You are " + this;
    }
/*----------------------------------------------------------------------------*/    
}
