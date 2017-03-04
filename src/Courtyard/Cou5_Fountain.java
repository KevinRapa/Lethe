package Courtyard;

import A_Super.Gettable;
import A_Super.Item;
/**
 * Contains the stone disk, needed for the door in the marble hall
 * 
 * @see Marble_Hall.Mha_Dr
 * @author Kevin Rapa
 */
public class Cou5_Fountain extends Courtyard_Fountain implements Gettable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou5_Fountain(Item... items) {
        super(items);
        this.description = "This fountain is in better shape than the one at the\n"
                         + "west. A slender statue of a helmed female figure\n"
                         + "holding a staff and shield stands in the center.\n"
                         + "She resembles a soldier.";
        this.addActKeys(GETPATTERN);
        this.addNameKeys("(?:slender |helmed )?(?:female )?statue", "staff|shield|soldier");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.equals("drink") || key.equals("swim"))
            return this.actDialog;
        else
            return getIt();
    }
/*----------------------------------------------------------------------------*/
    @Override public String getIt() {
        return "Well... It's made of stone and attached to the fountain, so\n"
             + "you're going to have to live without that.";
    }
/*----------------------------------------------------------------------------*/
}
