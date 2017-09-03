package Study;

import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.WallArt;
        
public class Stud_Portrait extends WallArt {
    private final Furniture SAFE_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Stud_Portrait(Furniture safe) {
        super();
        this.SAFE_REF = safe;
        this.description = "The portrait depicts a bald male with round glasses, "
                         + "maybe fifty years old. He looks a bit like an angry "
                         + "Bob Gunton. 'Could this be a picture of Eurynomos?' you say "
                         + "to yourself. 'Wait, who's Bob Gunton?' you ask, but "
                         + "you hear no answer. With the light cast from the "
                         + "fireplace, it seems like this picture is not resting "
                         + "flush on the wall.";
        this.searchDialog = "There's nothing on this picture. Interestingly, the "
                          + "portrait does not rest flush on the wall.";
        this.actDialog = "You lift up the portrait resembling Bob Gunton, "
                       + "appropriately revealing a safe.";
        this.addNameKeys("portrait", "picture", "painting");
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {  
        if (key.equals("admire"))
            return "Yes, what a beautiful piece of artwork. You take a moment "
                 + "to soak in the creative essence. Yes...";
        else {
            if (! Player.getRoomObj(Id.STUD).hasFurniture("safe")) {
                Player.getRoomObj(Id.STUD).addFurniture(SAFE_REF);
                return this.actDialog;
            }            
            return "You have already discovered the safe.";
        }
    }
//-----------------------------------------------------------------------------
}

