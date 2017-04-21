package Gallery;

import A_Super.Furniture;

public class Gal6_Hatch extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Hatch() {
        super();

        this.description = "The hatch leads down into the room below.";
        this.actDialog = "The hatch is open already.";
        
        this.addActKeys("open", "close", "jump");
        this.addNameKeys("hatch");
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {
        if (key.equals("open"))
            return this.actDialog;
        else if (key.equals("jump"))
            return "That sounds dangerous.";
        else
            return "If you do that, you won't be able to leave!";
    }
//-----------------------------------------------------------------------------
}
