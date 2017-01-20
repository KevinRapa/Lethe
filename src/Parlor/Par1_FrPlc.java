package Parlor;

import A_Super.Fireplace;
import A_Super.Item;
import A_Main.Player;
import static A_Main.NameConstants.*;

public class Par1_FrPlc extends Fireplace {
    private final Item SCRDFR_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/           
    public Par1_FrPlc(Item bckt) {       
        super(true, bckt);
        this.SCRDFR_REF = new Item(SACRED_FIRE, "The fire burns enigmatically inside "
                                 + "the bottle. To your surprise, the fire gives off no heat.");
        this.descLit = "It's a large sandstone fireplace, about your height.\n"
                     + "Its mantle is supported on both sides by short columns\n"
                     + "carved into angelic figures. The fire burns aggressively,\n"
                     + "but to your amazement, gives off no heat.";
        this.descUnlit = "A cold, unlit fireplace.";
        this.useDialog = "Holding the bottle over the fire, some of the flames seep\n"
                       + "inside. You quickly cork the bottle and stare at it, mesmerized.";
        this.addUseKeys(GLASS_BOTTLE, "enchanted bottle");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        switch (item.toString()) {
            case BUCKET_OF_WATER:
                Player.getInv().remove(item);
                Player.getInv().add(BCKT_REF);
                return "The water steams aggressively upon contact, but fails to\n"
                     + "douse the flames.";
            case "enchanted bottle":
                Player.getInv().remove(item);
                Player.getInv().add(SCRDFR_REF);
                return this.useDialog;
            default:
                return "You manage to do nothing but burn your hand. What were you thinking?";
        }
    }
/*----------------------------------------------------------------------------*/
}
