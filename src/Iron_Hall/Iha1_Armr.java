package Iron_Hall;

import Super.Furniture;
import Super.Room;

public class Iha1_Armr extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Iha1_Armr(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "It's plate armor holding a polearm. It stands\n"
                         + "gazing out the window.";
        this.searchDialog = "You find a long polearm, but the gauntlet is\n"
                          + "gripping it too tightly to be pryed open.";
        this.addActKeys("equip", "wear");
        this.addNameKeys("armor", "suit of armor", "armor suit", "plate armor");
    }    
//*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {     
        interactDialog = "You will probably get hurt trying to do that.";
        return interactDialog;
    }
/*----------------------------------------------------------------------------*/
}
