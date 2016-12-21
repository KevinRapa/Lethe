package West_Outer_Wall;

import Super.Room;
import Main.Player;
import Super.Furniture;
import Super.Item;
import Main.GUI;

public class Wow3 extends Room{
    private final Item REF3;
    private final Furniture REF2, REF4, REF5;
    private boolean triggerHppnd;
    
    public Wow3(String name, String ID, Furniture wow2lddr, 
                Furniture Floor, Furniture wow3Lddr, Item Ilddr) {
        super(name, ID);
        this.REF2 = wow2lddr;
        this.REF3 = Ilddr;
        this.REF4 = Floor;
        this.REF5 = wow3Lddr;
        this.triggerHppnd = false;
        this.description = "You stand atop the small balcony overlooking the\n" +
                           "west outer wall. You feel claustrophobic. A large\n" +
                           "wood shelf blocks a door to the north. Immediately\n" +
                           "to your east, there's another door covered in gashes\n"
                         + "and splinters.";
    }
/*----------------------------------------------------------------------------*/        
    @Override public String getBarrier(char dir) {
        String rep = "There's a wall in the way.";
        
        if (dir == 'w')
            rep = "There's a large shelf in the way.";
        if (dir == 'a')
            rep = "There's a railing there, and that drop looks intimidating.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/  
    @Override public String triggeredEvent() {
        GUI.roomOut("You are " + this);
        String rep = "";
        Room wow2 = Player.getMapRef()[3][6][3];
                
        if (! Player.getLastVisited().matches("GQUA")) {
            if (this.triggerHppnd) {
                rep = "The ladder creaks with instability. You were more\n"
                    + "careful in scaling the ladder this time.";
                if (! this.hasFurniture("ladder"))
                    this.addFurniture(REF5);
            }
            else {
                rep = "You successfully scale the ladder, but you accidentally\n"
                    + "knock it down with your final step, you uncoordinated oaf.";
                wow2.removeFurniture(REF2);
                REF4.getInv().add(REF3);
                this.triggerHppnd = true;
            }               
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/    
}
