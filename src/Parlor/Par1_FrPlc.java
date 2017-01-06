package Parlor;

import A_Super.Fireplace;
import A_Super.Item;
import A_Main.Player;

public class Par1_FrPlc extends Fireplace {
    private final Item SCRDFR_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/           
    public Par1_FrPlc(Item bckt) {       
        super(true, bckt);
        this.SCRDFR_REF = new Item("sacred fire", "The fire burns enigmatically inside "
                                 + "the bottle. To your surprise, the fire gives off no heat.");
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
        if (item.toString().matches("bucket of water")) {
            Player.getInv().remove(item);
            Player.getInv().add(BCKT_REF);
            return "The water steams aggressively upon contact, but fails to\n"
                 + "douse the flames.";
        }
        else if(item.toString().matches("enchanted bottle")) {
            Player.getInv().remove(item);
            Player.getInv().add(SCRDFR_REF);
            return this.useDialog;
        }
        else
            return "You manage to do nothing but burn your hand. What were you thinking?";
    }
/*----------------------------------------------------------------------------*/
}
