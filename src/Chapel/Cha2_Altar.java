package Chapel;

import A_Main.Id;
import static A_Main.NameConstants.FACTUM;
import A_Main.Player;
import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Cha2_Altar extends SearchableFurniture {
    private final String URN_DESC = " In the center sits a decorated stone and gold urn.";
    // ========================================================================
    public Cha2_Altar (Item... items) {
        super(items);
        
        this.description = "The altar rests atop a small riser in front of the\n"
                         + "rows of pews. The altar is a tan marble table bearing\n"
                         + "a row of lit candles.";
        this.actDialog = "No hitting things! This is a sacred place.";
        this.searchDialog = "You look on the chapel altar.";
        this.useDialog = "You've just moved...";

        this.addActKeys(JOSTLEPATTERN);
        this.addNameKeys("(?:tan )?(?:marble )?altar");
        this.addUseKeys(FACTUM);
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


