package Chapel;

import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;
import static A_Main.Names.*;
import A_Super.Gettable;
/**
 * Contains holy water that the player needs to grow the mandragora for the
 * enchanted bottle.
 * 
 * @see Parlor.Par1_EnchantingTable
 * @author Kevin Rapa
 */
public class Cha1_Water extends Furniture implements Gettable {
    private final Item REF_HOLY_WATER;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Cha1_Water(Item hlyWtr) {
        super();
        this.REF_HOLY_WATER = hlyWtr;
        this.description = "It's seems to be just water, but it's most likely the holy kind.";
        this.searchDialog = "You can't pick this up with your bare hands.";
        this.useDialog = "You fill the small vial with a sample of holy water.";
        this.addActKeys("drink", "swim", GETPATTERN);
        this.addNameKeys("water", HOLY_WATER, "clear water");
        this.addUseKeys(METAL_BUCKET, EMPTY_VIAL, GLASS_BOTTLE);
    }
//-----------------------------------------------------------------------------
    @Override public String useEvent(Item item) {
        if (item.toString().matches(EMPTY_VIAL)) {
            Player.getInv().remove(item);
            Player.getInv().add(REF_HOLY_WATER);
            return this.useDialog;
        }
        else if (item.toString().equals(METAL_BUCKET))
            return "The bucket is too large to dip into the cylix.";
        else
            return "The bottle is small enough to fit in, but the bottle is too wide to submerge the neck.";
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) { 
        if (key.equals("swim"))
            return "How in the world are you going to fit in there??";
        else if (key.equals("drink"))
            return "This water isn't for drinking.";
        else
            return getIt();
    }
//-----------------------------------------------------------------------------
    @Override public String getIt() {
        if (Player.hasItem(EMPTY_VIAL)) {
            Item i = null; // Vial must be in inventory at this point.
            
            for (Item j : Player.getInv())
                if (j.toString().equals(EMPTY_VIAL))
                    i = j;
            
            Player.getInv().remove(i);
            Player.getInv().add(REF_HOLY_WATER);
            return "You dip the vial in and collect some holy water.";
        }
        else if (Player.hasItem(METAL_BUCKET) || Player.hasItem(GLASS_BOTTLE))
            return "The vessel you're carrying is too big to fit in the cylix.";
        else
            return "You have nothing suitable in which to hold the holy water.";
    }
//-----------------------------------------------------------------------------
}
