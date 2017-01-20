package West_Outer_Wall;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Id;
import A_Main.Inventory;
import A_Super.Room;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Furniture;
import A_Super.Item;

public class Wow3 extends Room {
    private final Item LDDRITEM_REF;
    private final Furniture WOW2LDDR_REF;
    private final Inventory FLR_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow3(String name, String ID, Furniture wow2lddr, 
                Inventory flrInv, Item Ilddr) {
        super(name, ID);
        this.WOW2LDDR_REF = wow2lddr;
        this.LDDRITEM_REF = Ilddr;
        this.FLR_REF = flrInv;
        this.description = "You stand atop the small balcony overlooking the\n" +
                           "west outer wall. You feel claustrophobic. A large\n" +
                           "wood shelf blocks a door to the north. Immediately\n" +
                           "to your east, there's another door covered in gashes\n"
                         + "and splinters.";
    }
/*----------------------------------------------------------------------------*/        
    @Override public String getBarrier(Direction dir) {
        switch (dir) {
            case NORTH:
                AudioPlayer.playEffect(6);
                return "There's a large shelf in the way.";
            case WEST:
                return "There's a railing there, and that drop looks intimidating.";
            default:
                return bumpIntoWall();
        }
    }
/*----------------------------------------------------------------------------*/  
    @Override public String triggeredEvent() {
        if (Player.getLastVisited().equals(Id.WOW2)) {
            if (Player.hasVisited(this.ID)) {
                if (! this.hasFurniture("ladder"))
                    this.addFurniture(new Wow2_Stairs(Direction.DOWN));
                GUI.out("The ladder creaks with instability. You were more\n"
                      + "careful in scaling the ladder this time.");
            }
            else {
                Player.getRoomObj(Id.WOW2).removeFurniture(WOW2LDDR_REF);
                FLR_REF.add(LDDRITEM_REF);
                AudioPlayer.playEffect(31);
                GUI.out("You successfully scale the ladder, but you accidentally\n"
                      + "knock it down with your final step, you uncoordinated oaf.");
            }               
        }
        
        return STD_RM_OUT;
    }
/*----------------------------------------------------------------------------*/    
}
