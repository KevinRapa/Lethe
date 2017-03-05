package Parlor;

import A_Main.AudioPlayer;
import A_Super.Fireplace;
import A_Super.Item;
import A_Main.Player;
import static A_Main.NameConstants.*;
import A_Super.Liquid;
/**
 * Gives the player sacred fire if the player uses the enchanted bottle on
 * this.
 * 
 * @see Parlor.Par1_EnchantingTable
 * @see Parlor.Par1_Door
 * @author Kevin Rapa
 */
public class Par1_FirePlace extends Fireplace {
    private final Item SCRDFR_REF, ENCHT_BTTL_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/           
    public Par1_FirePlace(Item bckt, Item bttl) {       
        super(true, bckt);
        this.ENCHT_BTTL_REF = bttl;
        this.SCRDFR_REF = new Liquid(SACRED_FIRE, "The fire burns enigmatically inside "
                                 + "the bottle. To your surprise, the fire gives off no heat.");
        this.descLit = "It's a large sandstone fireplace, about your height.\n"
                     + "Its mantle is supported on both sides by short columns\n"
                     + "carved into angelic figures. The fire burns aggressively,\n"
                     + "but to your amazement, gives off no heat.";
        this.descUnlit = "A cold, unlit fireplace.";
        this.useDialog = "Holding the magical bottle over the fire, some of the flames seep\n"
                       + "inside. You quickly cork the bottle and stare at it, mesmerized.";
        this.addUseKeys(GLASS_BOTTLE, ENCHANTED_BOTTLE);
    }
/*----------------------------------------------------------------------------*/
    @Override public String getIt() {
        if (Player.getInv().contains(ENCHT_BTTL_REF)) {
            Player.getInv().remove(ENCHT_BTTL_REF);
            Player.getInv().add(SCRDFR_REF);
            return this.useDialog;
        }
        else
            return super.getIt();
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        switch (item.toString()) {
            case BUCKET_OF_WATER:
                Player.getInv().remove(item);
                Player.getInv().add(BCKT_REF);
                AudioPlayer.playEffect(39);
                return "The water steams aggressively upon contact, but fails to\n"
                     + "douse the flames.";
            case ENCHANTED_BOTTLE:
                Player.getInv().remove(item);
                Player.getInv().add(SCRDFR_REF);
                return this.useDialog;
            default:
                return "You manage to do nothing but burn your hand. What were you thinking?";
        }
    }
/*----------------------------------------------------------------------------*/
}
