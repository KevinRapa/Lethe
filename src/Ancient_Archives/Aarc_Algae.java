package Ancient_Archives;

import A_Main.Player;
import A_Super.Gettable;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Aarc_Algae extends Aarc_Furniture implements Gettable {
    private final Item ALGAE_REF;
    //-------------------------------------------------------------------------
    public Aarc_Algae (Item algae) {
        super();
        
        this.ALGAE_REF = algae;
        
        this.searchable = false;
        this.description = "You guess that the cistern water had been at a higher "
                         + "level previously, for the walls are slimy a third the "
                         + "way up from algae, and much of the furniture is stained "
                         + "green in areas.";

        this.addActKeys(GETPATTERN, FEELPATTERN, "lick");
        this.addNameKeys("algae");
    }
    //-------------------------------------------------------------------------
    @Override public String interact(String key) {
        if (key.equals("read"))
            return this.actDialog;
        else if (key.equals("lick") || key.matches(FEELPATTERN))
            return "Gross... slimy.";
        else
            return getIt();
    }
    //-------------------------------------------------------------------------   
    @Override public String getIt() {
        if (Player.getInv().add(ALGAE_REF))
            return "You scrape off some of the algae. Yuck.";
        else
            return NOTHING;
    }
    //------------------------------------------------------------------------- 
}


