package Chapel;

import A_Super.Carpet;
/**
 * @author Kevin Rapa
 */
public class Cha_Carpet extends Carpet {
    //-------------------------------------------------------------------------
    public Cha_Carpet () {
        super();
        
        this.description = "The long red carpet runs in between the pews. Small "
                         + "puffs of smoke rise up with each step you take on it.";

        this.addNameKeys("(?:long )?(?:red )?carpet(?: runner)?");
    }
    //-------------------------------------------------------------------------   
}


