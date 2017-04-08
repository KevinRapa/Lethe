package Marble_Hall;

import static A_Main.Names.WEAPON;
import A_Super.Item;
import A_Super.SearchableFurniture;

public class Mha2_LeftStatue extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Mha2_LeftStatue() {
        super();
        this.description = "The angel poses majestically with an indifferent "
                         + "gaze upwards. It holds a silver spear in its hand "
                         + "and points it upwards over the right angel. In its "
                         + "hollow base is an open compartment.";
        this.searchDialog = "You look into the compartment inside its base.";
        this.useDialog = "You start jamming it into the angel's hand "
                       + "before realizing that the angel is already holding "
                       + "a spear.";
        this.actDialog = "Such an impressive work of artistry deserves not to be "
                       + "tainted by your touch.";
        
        this.addNameKeys("left (?:statue|one|angel|hand|palm)", "(?:left )?(?:open )?compartment");
        this.addActKeys(HOLDPATTERN);
        this.addUseKeys(ANYTHING);
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (item.getType().equals(WEAPON))
            return this.useDialog;
        else
            return "It doesn't seem like that belongs there.";
    }
/*----------------------------------------------------------------------------*/
}
