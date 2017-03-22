package Attic;

import static A_Main.Names.LAB_COAT;
import A_Super.Clothing;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * Contains the needed lab coat.
 * 
 * @see Laboratory.Labo_CoatNote
 * @author Kevin Rapa
 */
public class Att2_LabCoatCase extends SearchableFurniture implements Openable {
    // ========================================================================
    public Att2_LabCoatCase () {
        super(new Clothing(LAB_COAT, "A white lab coat", "You wear the lab coat. Now you feel ready for chemistry.", 0));
        
        this.description = "Hidden behind a few boxes in the studded suitcase.";
        this.searchDialog = "You find the suitcase behind a few boxes tucked in the front of the attic. You open it.";

        this.addNameKeys("(?:studded brown|brown studded) (?:suitcase|case)", 
                "(?:studded |brown )(?:suitcase|case)");
    }
    // ======================================================================== 
}


