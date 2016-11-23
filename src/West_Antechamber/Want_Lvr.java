package West_Antechamber;

import Super.Room;
import Super.Furniture;
import Rotunda.Rotu;

public class Want_Lvr extends Furniture {
    private boolean discovered;
    public Want_Lvr(String name) {
        super(name);
        this.discovered = false;
        this.searchable = false;
        this.description = "It's a black iron lever resting on the plinth of the\n"
                         + "statue.";
        this.searchDialog = "There's a pile of gold! No, not really, just a lever.";
        this.interactDialog = "You pull the lever. The room you are in vibrates and you\n"
                    + "here a prolonged rumble past the wall to your west.";
        this.addActKeys("pull", "push", "flick", "hit");
        this.addNameKeys("lever", "iron lever");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(Room[][][] map, String key) {
        Rotu ref = (Rotu) map[3][3][3];
        String rep = this.interactDialog;
        
        if (this.discovered) {
            if (ref.getState().matches("EW"))
                rep = "You pull the lever, but nothing happens except a faint\n"
                    + "-click- sounding past the wall to your west.";
            else if (ref.getState().matches("NS"))
                ref.rotate();
        }
        else
            rep = "You don't see a lever in here.";
                     
        return rep;
    }
/*----------------------------------------------------------------------------*/
    public void discover() {
        this.discovered = true;
    }
}
