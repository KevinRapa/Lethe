package A_Super;

import static A_Main.NameConstants.RUBBER_HOSE;
import static A_Main.NameConstants.LOOPED_ROPE;
import static A_Main.NameConstants.LEATHER_HOSE;

/**
 * @author Kevin Rapa
 */
abstract public class Railing extends Furniture {
    // ========================================================================
    public Railing () {
        super();

        this.actDialog = "You lean against the railing and rest a bit. All this\n"
                       + "walking has nearly bested you.";
        this.useDialog = "Hopefully you aren't thinking that you can just climb\n"
                       + "down with something that short...";

        this.addNameKeys("railing");
        this.addUseKeys(LOOPED_ROPE, LEATHER_HOSE, RUBBER_HOSE);
        this.addActKeys("hold", "grab", "lean", "vault", "jump");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.equals("lean"))
            return this.actDialog;
        else if (key.equals("hold") || key.equals("grab"))
            return "You grab the railing. There's no fear of falling over, right?";
        else
            return "Why are you trying to kill yourself?";
    }
    // ========================================================================        
}


