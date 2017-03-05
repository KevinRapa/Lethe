package Garden;

import static A_Main.NameConstants.LEATHER_HOSE;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Gar2_Hole extends Furniture {
    private final Furniture HOSE_REF;
    // ========================================================================
    public Gar2_Hole (Furniture hose) {
        super();

        this.HOSE_REF = hose;
        this.description = "You peer over the thick granite railing into the\n"
                         + "hole. To your surprise, it's the rotunda you were\n"
                         + "in earlier! It's about a 25 foot drop down.";
        this.actDialog = "The drop is too great. It's about 25 feet down. You'd surely break something.";
        this.searchDialog = this.description;
        this.useDialog = "You tie the end of the hose to the railing and throw\n"
                       + "it over the edge. Hopefully it will support your\n"
                       + "weight.";

        this.addNameKeys("(?:thick )?(?:granite )?railing", "hole");
        this.addUseKeys(LEATHER_HOSE);
        this.addActKeys("jump", "climb", "vault");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        if (Player.getPos().hasFurniture(LEATHER_HOSE))
            return description.concat(" The leather hose, tied around the railing, extends\n"
                                    + "downward and almost touches the floor.");
        else if (Player.getPos().hasFurniture("broken hose"))
            return description.concat(" The broken leather hose is still tied around the railing.");
        else
            return description;
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return this.getDescription();
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        Player.getPos().addFurniture(HOSE_REF); //Player must be in GAR2
        Player.getInv().remove(item);
        
        return this.useDialog;
    }
    // ========================================================================     
}


