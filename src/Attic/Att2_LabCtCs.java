package Attic;

import A_Super.Container;
import A_Super.Furniture;
import A_Super.Item;
/**
 * Contains the needed lab coat.
 * 
 * @see Laboratory.Labo_CoatNt
 * @author Kevin Rapa
 */
public class Att2_LabCtCs extends Furniture implements Container {

    // ========================================================================
    public Att2_LabCtCs () {
        super(new Item("lab coat", "A white lab coat", "You wear the lab coat. Now you feel ready for chemistry."));
        
        this.description = "Hidden behind a few boxes in the studded suitcase.";
        this.searchDialog = "You find the suitcase behind a few boxes tucked in the front of the attic. You open it.";

        this.addNameKeys("studded brown (?:suitcase|case)", "(?:studded |brown )(?:suitcase|case)");
    }
    // ======================================================================== 
}


