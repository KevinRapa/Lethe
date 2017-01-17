package Gallery;

import static A_Main.NameConstants.BOX_THINGY;
import A_Super.Furniture;
import A_Super.Item;
/**
 * Holds the box thingy; the battery for the GAL6 cannon
 * 
 * @see Gallery.Gal6_Cnn
 * @author KEvin Rapa
 */
public class Gal6_App extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_App(Item... items) {
        super(items);
        this.searchable = true;
        this.searchDialog = "The only thing to take is the funny box in the center.";
        this.description = "The weird apparatus looks like a metal platform\n"
                         + "with three curved arms projecting out and overtop\n"
                         + "of itself. Wires run all over the thing, and lights\n"
                         + "on it go *bleep bleep bleep*. The machine emits\n"
                         + "some sort of blue light and in the center sits a\n"
                         + "metal box thingy. Next to the apparatus is a label\n"
                         + "that says: \"Plasma induction charger\".";
        this.addNameKeys("apparatus", "unknown apparatus", "plasma induction");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (! this.containsItem(BOX_THINGY)) {
            return "The weird apparatus looks like a metal platform\n"
                 + "with three curved arms projecting out and overtop\n"
                 + "of itself. Its lights are off and the *bleeping*\n"
                 + "has stopped. Next to the apparatus is a label that\n"
                 + "says: \"Plasma induction charger\".";
        }
        return this.description;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() { 
        if (! this.containsItem(BOX_THINGY)) 
            return "The platform in the center is empty.";
        
        return this.searchDialog;
    }  
/*----------------------------------------------------------------------------*/  
}
