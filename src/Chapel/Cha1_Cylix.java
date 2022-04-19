package Chapel;

import static A_Main.Names.*;
import A_Super.Furniture;
import A_Super.Moveable;

public class Cha1_Cylix extends Furniture implements Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cha1_Cylix() {
        super();

        this.description = "The cylix resembles a wide brass bowl decorated with many angular etchings.";
        this.actDialog = "The cylix isn't portable enough to simply take.";
        this.useDialog = "You begin banging the container against the bowl, but the "
                       + "bowl isn't fitting inside.";
        this.searchDialog = "You logicize that all you'd find is water.";
        
        this.addActKeys(GETPATTERN, "drink");
        this.addNameKeys("(?:wide )?(?:brass )?(?:cylix|bowl)");
        this.addUseKeys(EMPTY_VIAL, METAL_BUCKET, GLASS_BOTTLE);
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {
        if (key.equals("drink"))
            return "You can't imagine that holy water is very palatable.";
        else
            return this.actDialog;
    }
//-----------------------------------------------------------------------------
}
