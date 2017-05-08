package Catacomb_Entrance;

import static A_Main.Names.HAND_TORCH;
import A_Super.Furniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Cs35_Torches extends Furniture implements Unmoveable {
    //-------------------------------------------------------------------------
    public Cs35_Torches () {
        super();

        this.searchDialog = "There's nothing behind the obelisks.";
        this.description = "The tall obelisks burn brightly with a blue flame.";
        this.actDialog = "There's no way you are going to touch that fire.";
        this.useDialog = "Your torch is still lit, despite the fact that you've "
                       + "been carrying it all this time.";
        
        this.addNameKeys("(?:standing )?torch(?:es)?", 
                "(?:bright )?(?:blue )?flame", "(?:tall )?obelisks");
        this.addActKeys(GETPATTERN, "touch");
        this.addUseKeys(HAND_TORCH);
    }
    //-------------------------------------------------------------------------  
    @Override public String interact(String key) {
        if (key.equals("touch"))
            return this.actDialog;
        else
            return "It's a standing torch. Too large and heavy to pick up.";
    }
    //-------------------------------------------------------------------------         
}


