package Chapel;

import A_Main.Id;
import static A_Main.Names.FACTUM;
import A_Main.Player;
import A_Super.Gettable;
import A_Super.Item;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Cha2_Altar extends SearchableFurniture 
        implements Gettable, Unmoveable 
{
    private final String URN_DESC = " In the center sits a decorated stone and gold urn.";
    //-------------------------------------------------------------------------
    public Cha2_Altar (Item... items) {
        super(items);
        
        this.description = "The altar rests atop a small riser in front of the "
                         + "rows of pews. The altar is a tan marble table bearing "
                         + "a row of lit candles.";
        this.actDialog = "No hitting things. This is a sacred place.";
        this.searchDialog = "You look on the chapel altar.";
        this.useDialog = "You've just moved.";

        this.addActKeys(JOSTLEPATTERN, GETPATTERN, "pray");
        this.addNameKeys("(?:tan )?(?:marble )?altar", "(?:lit )?candles?");
        this.addUseKeys(FACTUM);
    }
    //------------------------------------------------------------------------- 
    @Override public String interact(String key) {
        if (key.equals("pray"))
            return "Praying fails to teleport you anywhere.";
        else if (key.matches(JOSTLEPATTERN))
            return this.actDialog;
        else 
            return getIt("You attempt to blow the flame off one candle before taking it, "
             + "but the flame refuses to die, thwarting your attempt.");
    }
    //------------------------------------------------------------------------- 
    @Override public String getDescription() {
        return this.containsItem("gold urn") ? this.description.concat(URN_DESC) :
                this.description;
    }
    //-------------------------------------------------------------------------      
    @Override public String useEvent(Item item) {
        Player.setOccupies(Id.VAUE);
        return this.useDialog;
    }
    //------------------------------------------------------------------------- 
}


