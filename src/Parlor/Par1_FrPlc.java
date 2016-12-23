package Parlor;

import A_Super.Fireplace;
import A_Super.Item;
import A_Main.Player;

public class Par1_FrPlc extends Fireplace {
    private final Item SCRDFR_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/           
    public Par1_FrPlc(Item bckt, Item scrdFr) {       
        super(true, bckt);
        this.SCRDFR_REF = scrdFr;
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
        Player.getInv().remove(item);
        
        if (item.toString().matches("bucket of water")) {
            rep = "The water steams aggressively upon contact, but fails to\n"
                + "douse the flames.";
            Player.getInv().add(BCKT_REF);
        }
        else if(item.toString().matches("enchanted bottle"))
            Player.getInv().add(SCRDFR_REF);
        else
            rep = "You manage to do nothing but burn your hand. What were you thinking?";
            
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
