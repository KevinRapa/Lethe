package Study;

import A_Super.Fireplace;
import A_Super.Item;

public class Stud_Fireplace extends Fireplace {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Stud_Fireplace(Item bckt) {       
        super(bckt);
        this.useDialog = "That's probably not a good idea. It's the only thing lighting this room.";
        this.descLit = "It's a small, fancy marble fireplace. The edges are an "
                     + "ornate wood. 'Magnificent!' you think to yourself. Its "
                     + "glow tones the room in a warm sepia.";
    }
//-----------------------------------------------------------------------------
    @Override public String useEvent(Item item) {
        return this.useDialog;
    }
//-----------------------------------------------------------------------------
}
