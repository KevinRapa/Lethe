package Ancient_Archives;

import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Aarc_Desk extends Aarc_Furniture {
//-------------------------------------------------------------------------
    public Aarc_Desk (Item... items) {
        super(items);

        this.description = "One of the objects in the wood rubble resembles "
                         + "an old desk. Though seeming once pristine and "
                         + "of luxury quality, the desk now lies crooked "
                         + "with two legs missing.";
        this.searchDialog = "You look inside the old desk.";
        this.actDialog = "You give it a jostle. 'Hmph. Perhaps at one point this "
                       + "was a fine piece of artistry, but it has lost its charm.'";

        this.addActKeys(JOSTLEPATTERN);
        this.addNameKeys("(?:old )?(?:wooden )?(?:drawered )?desk", "drawers?");
    }
    //-------------------------------------------------------------------------   
}


