package A_Super;

import static A_Main.Names.HAND_TORCH;

/**
 * @author Kevin Rapa
 */
abstract public class Chandelier extends Furniture {
//-----------------------------------------------------------------------------
    public Chandelier () {
        super();

        this.searchDialog = "You are pretty sure you can't jump that high.";
        this.useDialog = "The chandelier is lit already.";
        this.actDialog = "That would not be a very civilized thing to do.";
        
        this.addNameKeys("chandelier");
        this.addUseKeys(HAND_TORCH);
        this.addActKeys("swing", "pull", "hang", "light");
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {              
        if (key.equals("pull"))
            return "It suffices to say the chandelier is mounted solidly "
                    + "to the ceiling and isn't unusual in any way.";
        else if (key.equals("light"))
            return this.useDialog;
        else
            return this.actDialog;
    }
//----------------------------------------------------------------------------- 
}


