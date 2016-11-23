package Study;

import Super.Fireplace;
import Super.Item;
import Core.Inventory;

public class Stud_Fire extends Fireplace {
     
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Stud_Fire(String NAME, boolean isLit, Item bckt, Inventory inv) {       
        super(NAME, isLit, bckt, inv);
        this.descLit = "It's a small, fancy marble fireplace. The edges are an\n"
                     + "ornate wood. 'Magnificent!' you think to yourself. Its\n"
                     + "glow tones the room in a warm sepia.";
        this.descUnlit = "A cold, unlit fireplace.";
    }
/*----------------------------------------------------------------------------*/
}
