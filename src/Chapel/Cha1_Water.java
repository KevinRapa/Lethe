package Chapel;

import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;

public class Cha1_Water extends Furniture {
    private final Item REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Cha1_Water(Item hlyWtr) {
        super();
        this.REF = hlyWtr;
        this.searchable = false;
        this.description = "It's seems to be just water, but it's most likely the holy kind.";
        this.searchDialog = "You can't pick this up with your bare hands.";
        this.useDialog = "You fill the small vial with the holy water.";
        this.addActKeys("drink", "swim");
        this.addNameKeys("water", "holy water", "clear water");
        this.addUseKeys("metal bucket", "empty vial", "glass bottle");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (item.toString().matches("empty vial")) {
            Player.getInv().remove(item);
            Player.getInv().add(REF);
            return this.useDialog;
        }
        else if (item.toString().matches("metal bucket"))
            return "The bucket is too large to dip into the cylix.";
        else
            return "The bottle is small enough to fit in, but the bottle is too\n"
                 + "wide to get the neck into the water.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) { 
        
        if (key.matches("swim"))
            return "How in the world are you going to fit in there??";
        
        return "This water isn't for drinking.";
    }
/*----------------------------------------------------------------------------*/
}
