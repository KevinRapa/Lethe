package Gallery;

import A_Super.Furniture;

public class Gal3_Hatch extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Hatch() {
        super();

        this.description = "The hatch leads upwards into another room.";
        this.actDialog = "The hatch is open already.";
        
        this.addNameKeys("hatch");
        this.addActKeys("open", "close", "jump");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.equals("open"))
            return this.actDialog;
        else if (key.equals("jump"))
            return "The hatch is going upward you fool...";
        else
            return "The hatch is too high up. Why do that anyway???";
    }
/*----------------------------------------------------------------------------*/
}
