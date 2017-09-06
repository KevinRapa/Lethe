package West_Outer_Wall;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Id;
import A_Super.Room;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Furniture;
import A_Super.Item;

public class Wow3 extends Room {
    private final Item LDDRITEM_REF;
    private final int WOW2LDDR_ID, FLR_ID;
    private final Furniture WOW3LDDR_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow3(String name, String ID, Furniture wow2lddr, 
                Furniture flr, Item Ilddr) {
        super(name, ID);
        
        this.WOW3LDDR_REF = new Wow2_Ladder(Direction.DOWN, Id.WOW2);
        this.WOW2LDDR_ID = wow2lddr.getID();
        this.LDDRITEM_REF = Ilddr;
        this.FLR_ID = flr.getID();
    }
//-----------------------------------------------------------------------------        
    @Override public String getBarrier(Direction dir) {
        switch (dir) {
            case NORTH:
                AudioPlayer.playEffect(6);
                return "There's a rather large shelf in the way.";
            case WEST:
                return "There's a railing there, and that drop looks intimidating.";
            default:
                return bumpIntoWall();
        }
    }
//-----------------------------------------------------------------------------  
    @Override public String triggeredEvent() {
        if (Player.getLastVisited().equals(Id.WOW2)) {
            if (Player.hasVisited(this.ID)) {
                if (! this.hasFurniture(WOW3LDDR_REF.getID()))
                    this.addFurniture(WOW3LDDR_REF);
                
                GUI.out("The ladder creaks with instability. You were more "
                      + "careful in scaling the ladder this time.");
            }
            else {
                Room wow2 = Player.getRoomObj(Id.WOW2);
                wow2.removeFurniture(WOW2LDDR_ID);
                wow2.getFurnRef(FLR_ID).getInv().add(LDDRITEM_REF);
                AudioPlayer.playEffect(31);
                GUI.out("You successfully scale the ladder, but you accidentally "
                      + "knock it down with your final step, you uncoordinated oaf.");
            }               
        }
        
        return NAME;
    }
//-----------------------------------------------------------------------------    
}
