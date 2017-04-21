package Observatory;

import A_Super.Furniture;
import A_Super.Moveable;
/**
 * @author Kevin Rapa
 */
public class Obs2_Chair extends Furniture implements Moveable {
    //-------------------------------------------------------------------------
    public Obs2_Chair () {
        super();

        this.description = "The tall lavender lounge chair looks quite comfortable "
                         + "to sit in.";
        this.actDialog = "You sit down for a moment, pondering various worldly mysteries. "
                       + "The chair is as comfortable as it looks, and you feel almost at home.";
        this.searchDialog = "The chair isn't hiding anything unusual.";

        this.addNameKeys("(?:tall )?(?:lavender )?(?:lounge )?chair");
        this.addActKeys(SITPATTERN);
    }
    //-------------------------------------------------------------------------    
}


