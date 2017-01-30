package Catacomb_Entrance;

import static A_Main.NameConstants.HAND_TORCH;
import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cs35_Torches extends Furniture {
    // ========================================================================
    public Cs35_Torches () {
        super();

        this.description = "The tall obelisks burn brightly with a blue flame.";
        this.actDialog = "There's no way you are going to touch that fire.";
        this.useDialog = "Your torch is still lit, despite the fact that you've\n"
                       + "been carrying it all this time.";
        
        this.addNameKeys("(?:standing )?torch(?:es)?", "(?:bright )?(?:blue )?flame");
        this.addActKeys(GETKEYS);
        this.addActKeys("touch");
        this.addUseKeys(HAND_TORCH);
    }
    // ========================================================================  
    @Override public String interact(String key) {
        if (key.equals("touch"))
            return this.actDialog;
        else
            return "It's a standing torch. It's too large and heavy to pick up.";
    }
    // ========================================================================         
}

