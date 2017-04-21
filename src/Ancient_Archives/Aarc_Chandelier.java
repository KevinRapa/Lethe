package Ancient_Archives;

import static A_Main.Names.HAND_TORCH;
/**
 * @author Kevin Rapa
 */
public class Aarc_Chandelier extends Aarc_Furniture {
    //-------------------------------------------------------------------------
    public Aarc_Chandelier () {
        super();
        this.searchable = false;
        
        this.description = "The chandelier hangs at an angle and is missing "
                         + "half its candles. The other half of them are heavily "
                         + "melted and nearing the end of their usefulness.";
        this.actDialog = this.useDialog = "The chandelier is broken and too high up.";
        this.searchDialog = "You cannot reach it.";

        this.addNameKeys("(?:unlit )?(?:iron )?(?:chandelier|light)");
        this.addUseKeys(HAND_TORCH);
        this.addActKeys("light", "swing", "hang");
    }
    //-------------------------------------------------------------------------  
    @Override public String interact(String key) {
        if (key.equals("light"))
            return this.actDialog;
        else
            return "That's a very immature thing to do.";
    }
    //-------------------------------------------------------------------------   
}


