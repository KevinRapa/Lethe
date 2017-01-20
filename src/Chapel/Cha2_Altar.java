package Chapel;

import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Cha2_Altar extends Furniture {
    private final String URN_DESC = " In the center sits a decorated stone and gold urn.";
    // ========================================================================
    public Cha2_Altar (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "The altar rests atop a small riser in front of the\n"
                         + "rows of pews. The altar is a tan marble table bearing\n"
                         + "a row of lit candles.";
        this.searchDialog = "You look on the chapel altar.";
        this.useDialog = "You've just moved...";

        this.addNameKeys("(?:tan )?(?:marble )?altar");
        this.addUseKeys("the Factum");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return this.containsItem("gold urn") ? this.description.concat(URN_DESC) :
                this.description;
    }
    // ========================================================================      
    @Override public String useEvent(Item item) {
        Player.setOccupies(Id.VAUE);
        return this.useDialog;
    }
    // ======================================================================== 
}


