package Marble_Hall;

import static A_Main.NameConstants.WEAPON;
import A_Super.Item;
import A_Super.SearchableFurniture;

public class Mha2_LeftStatue extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Mha2_LeftStatue() {
        super();
        this.description = "The angel poses majestically with an indifferent\n"
                         + "gaze upwards. It holds a silver spear in its hand\n"
                         + "and points it upwards over the right angel. In its\n"
                         + "hollow base is an open compartment.";
        this.searchDialog = "You look into the compartment inside its base.";
        this.useDialog = "You start jamming it into the angel's hand\n"
                       + "before realizing that the angel is already holding\n"
                       + "a spear.";
        this.actDialog = "Such an impressive work of artistry deserves not to be\n"
                       + "tainted by your touch.";
        
        this.addNameKeys("left (?:statue|one|angel|hand|palm)", "(?:left )?(?:open )?compartment");
        this.addActKeys(HOLDPATTERN);
        this.addUseKeys(".+");
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
