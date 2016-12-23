package Gallery;

import A_Super.Furniture;
import A_Super.Item;

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
        String rep = this.description;
        
        if (! this.doesThisHaveIt("metal box thingy with wires")) {
            rep = "The weird apparatus looks like a metal platform\n"
                + "with three curved arms projecting out and overtop\n"
                + "of itself. Its lights are off and the *bleeping*\n"
                + "has stopped. Next to the apparatus is a label that\n"
                + "says: \"Plasma induction charger\".";
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() { 
    String rep = this.searchDialog;
    
    if (! this.doesThisHaveIt("metal box thingy with wires")) {
            rep = "The platform in the center is empty.";
        }
        return rep;
    }  
/*----------------------------------------------------------------------------*/  
}
