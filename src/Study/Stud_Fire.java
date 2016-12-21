package Study;

import Super.Fireplace;
import Super.Item;

public class Stud_Fire extends Fireplace {
     
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Stud_Fire(boolean isLit, Item bckt) {       
        super(isLit, bckt);
        this.useDialog = "That's probably not a good idea. It's the only thing lighting this room.";
        this.descLit = "It's a small, fancy marble fireplace. The edges are an\n"
                     + "ornate wood. 'Magnificent!' you think to yourself. Its\n"
                     + "glow tones the room in a warm sepia.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
}
