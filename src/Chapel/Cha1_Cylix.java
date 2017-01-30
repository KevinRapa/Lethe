package Chapel;

import static A_Main.NameConstants.*;
import A_Super.Furniture;

public class Cha1_Cylix extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cha1_Cylix() {
        super();

        this.description = "The cylix looks like a wide brass bowl.";
        this.useDialog = "You begin banging the container against the bowl, but the\n"
                       + "bowl isn't fitting inside...";
        this.searchDialog = "If your logic holds as well as this bowl holds water,\n"
                          + "you'd guess this vessel was filled with the holy kind.\n"
                          + "You can't pick up the water with your hands though.";
        this.addNameKeys("(?:wide )?(?:brass )?(?:cylix|bowl)");
        this.addUseKeys(EMPTY_VIAL, METAL_BUCKET, GLASS_BOTTLE);
    }
/* -------------------------------------------------------------------------- */
}