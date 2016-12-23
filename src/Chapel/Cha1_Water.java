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
        String rep = this.useDialog;
        
        if (item.toString().matches("empty vial")) {
            Player.getInv().remove(item);
            Player.getInv().add(REF);
        }
        else if (item.toString().matches("metal bucket"))
            rep = "The bucket is too large to dip into the cylix.";
        else
            rep = "The bottle is small enough to fit in, but the bottle is too\n"
                + "wide to get the neck into the water.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) { 
        String rep = "This water isn't for drinking.";
        
        if (key.matches("swim"))
            rep = "How in the world are you going to fit in there??";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
