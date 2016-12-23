package Garden;

import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Gar2_Hl extends Furniture {
    private final Furniture HOSE_REF;
    // ========================================================================
    public Gar2_Hl (Furniture hose) {
        super();
        this.searchable = false;
        
        this.HOSE_REF = hose;
        this.description = "You peer over the thick granite railing into the\n"
                         + "hole. To your surprise, it's the rotunda you were\n"
                         + "in earlier! It's about a 25 foot drop down.";
        this.actDialog = "The drop is too great. It's about 25 feet down. You'd surely break something.";
        this.searchDialog = this.description;
        this.useDialog = "You tie the end of the hose to the railing and throw\n"
                       + "it over the edge. Hopefully it will support your\n"
                       + "weight.";

        this.addNameKeys("(?:granite) ?railing, hole");
        this.addUseKeys("leather hose");
        this.addActKeys("jump", "climb");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        String rep = this.description;
        
        if (Player.getMapRef()[2][4][3].hasFurniture("leather hose"))
            rep += " The leather hose, tied around the railing, extends\n"
                 + "downward and almost touches the floor.";
        else if (Player.getMapRef()[2][4][3].hasFurniture("broken hose"))
            rep += " The broken leather hose is still tied around the railing.";
        
        return rep;
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return this.getDescription();
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        Player.getMapRef()[2][4][3].addFurniture(HOSE_REF);
        Player.getInv().remove(item);
        
        return this.useDialog;
    }
    // ========================================================================     
}


