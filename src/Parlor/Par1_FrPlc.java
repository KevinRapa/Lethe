package Parlor;

import Super.Fireplace;
import Super.Item;
import Main.Inventory;

public class Par1_FrPlc extends Fireplace {
    private final Item REF3;
/* CONSTRUCTOR ---------------------------------------------------------------*/           
    public Par1_FrPlc(Item bckt, Item scrdFr, Inventory inv) {       
        super(true, bckt, inv);
        this.REF3 = scrdFr;
        this.descLit = "It's a large sandstone fireplace, about your height.\n"
                     + "It's mantle is supported on both sides by short columns\n"
                     + "carved into angelic figures. The fire burns aggressively,\n"
                     + "but to your amazement, gives off no heat.";
        this.descUnlit = "A cold, unlit fireplace.";
        this.useDialog = "Holding the bottle over the fire, some the flames seep\n"
                       + "inside. You quickly cork the bottle and stare at it mesmerized.";
        this.addUseKeys("glass bottle", "enchanted bottle");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        String rep = this.useDialog;
        REF2.remove(item);
        
        if (item.toString().matches("bucket of water")) {
            rep = "The water steams aggressively upon contact, but fails to\n"
                + "douse the flames.";
            this.REF2.add(REF);
        }
        else if(item.toString().matches("enchanted bottle"))
            this.REF2.add(REF3);
        else
            rep = "You manage to do nothing but burn your hand. What were you thinking?";
            
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
