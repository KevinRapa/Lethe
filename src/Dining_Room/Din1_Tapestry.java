package Dining_Room;

import A_Main.Id;
import A_Main.Player;
import A_Super.WallArt;
import A_Super.Furniture;

public class Din1_Tapestry extends WallArt {
    private final Furniture CRVC_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din1_Tapestry(Furniture crevice) {
        super();
        this.CRVC_REF = crevice;
        this.description = "A large, renaissance-era tapestry. A well-dressed male " +
                           "and female sit together on a log in a grove. Between " +
                           "them is a chalice bearing an unexplainable blue glow.";
        this.searchDialog = "Lifting the tapestry, you discover a crevice in the "
                          + "wall behind it.";
        this.actDialog = this.searchDialog;
        this.addNameKeys("(?:large )?tapestry");
    }
//-----------------------------------------------------------------------------
    @Override public String getSearchDialog() {
        if (! Player.getRoomObj(Id.DIN1).hasFurniture("crevice")) {
            Player.getRoomObj(Id.DIN1).addFurniture(CRVC_REF);
            return this.searchDialog;
        }
        else 
            return "Yes, the hole in the wall is still there";  
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {
        if (key.equals("admire"))
            return "Yes, what a beautiful piece of artwork. You take a moment "
                 + "to soak in the creative essence. Yes...";
        else 
            return this.getSearchDialog();
    } 
//-----------------------------------------------------------------------------
}

