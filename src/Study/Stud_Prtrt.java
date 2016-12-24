package Study;

import A_Main.Player;
import A_Super.Furniture;
import A_Super.Wall_Art;
        
public class Stud_Prtrt extends Wall_Art {
    private final Furniture REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Stud_Prtrt (Furniture safe) {
        super();
        this.REF = safe;
        this.description = "The portrait depicts a bald male with round glasses,\n"
                         + "maybe fifty years old. He looks a bit like an angry\n"
                         + "Bob Gunton. 'Could this be a picture of Erik?' you say\n"
                         + "to yourself. 'Wait, who's Bob Gunton?' you ask, but\n"
                         + "you hear no answer. With the light cast from the\n"
                         + "fireplace, it seems like this picture is not resting\n"
                         + "flush on the wall.";
        this.searchDialog = "There's nothing on this picture. Interestingly, the\n"
                          + "portrait does not rest flush on the wall.";
        this.actDialog = "You lift up the portrait resembling Bob Gunton,\n"
                    + "appropriately revealing a safe.";
        this.addNameKeys("portrait", "picture", "painting");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {  
        if (key.matches("admire"))
            return "Yes, what a beautiful piece of artwork. You take a moment\n"
                 + "to soak in the creative essence. Yes...";
        else {
            if (! Player.getRoomRef("STUD").hasFurniture("safe")) {
                Player.getRoomRef("STUD").addFurniture(REF);
                return this.actDialog;
            }            
            return "You have already discovered the safe.";
        }
    }
/*----------------------------------------------------------------------------*/
}

