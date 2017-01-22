package Chapel;

import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;
import static A_Main.NameConstants.*;
/**
 * Contains holy water that the player needs to grow the mandragora for the
 * enchanted bottle.
 * 
 * @see Parlor.Par1_EnchantingTable
 * @author Kevin Rapa
 */
public class Cha1_Water extends Furniture {
    private final Item REF_HOLY_WATER;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Cha1_Water(Item hlyWtr) {
        super();
        this.REF_HOLY_WATER = hlyWtr;
        this.searchable = false;
        this.description = "It's seems to be just water, but it's most likely the holy kind.";
        this.searchDialog = "You can't pick this up with your bare hands.";
        this.useDialog = "You fill the small vial with the holy water.";
        this.addActKeys("drink", "swim");
        this.addNameKeys("water", HOLY_WATER, "clear water");
        this.addUseKeys(METAL_BUCKET, EMPTY_VIAL, GLASS_BOTTLE);
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (item.toString().matches(EMPTY_VIAL)) {
            Player.getInv().remove(item);
            Player.getInv().add(REF_HOLY_WATER);
            return this.useDialog;
        }
        else if (item.toString().equals(METAL_BUCKET))
            return "The bucket is too large to dip into the cylix.";
        else
            return "The bottle is small enough to fit in, but the bottle is too\n"
                 + "wide to submerge the neck.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) { 
        if (key.matches("swim"))
            return "How in the world are you going to fit in there??";
        else
            return "This water isn't for drinking.";
    }
/*----------------------------------------------------------------------------*/
}
