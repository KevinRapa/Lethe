package Attic;

import static A_Main.NameConstants.LAB_COAT;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;
/**
 * Contains the needed lab coat.
 * 
 * @see Laboratory.Labo_CoatNote
 * @author Kevin Rapa
 */
public class Att2_LabCoatCase extends Furniture implements Openable {
    // ========================================================================
    public Att2_LabCoatCase () {
        super(new Item(LAB_COAT, "A white lab coat", "You wear the lab coat. Now you feel ready for chemistry."));
        
        this.description = "Hidden behind a few boxes in the studded suitcase.";
        this.searchDialog = "You find the suitcase behind a few boxes tucked in the front of the attic. You open it.";

        this.addNameKeys("studded brown (?:suitcase|case)", "(?:studded |brown )(?:suitcase|case)");
    }
    // ======================================================================== 
}


