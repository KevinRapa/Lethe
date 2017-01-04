package Rotunda;

import A_Super.Furniture;

public class Rotu_Fntn extends Furniture {
    private boolean drained;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Rotu_Fntn() {       
        super();
        this.searchable = false;
        this.drained = false;
        this.description = "It's rounded and carefully carved from a smooth rock.\n"
                         + "It looks quite beautiful, except that it's filled\n"
                         + "with opaque brown water.";
        this.searchDialog = "You can't see anything through the brown water.";
        this.addNameKeys("fountain", "marble fountain");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {        
        if (this.drained) {
            return "Looking inside the bowl, you find decaying plant matter\n"
                 + "resting on the bottom. A curious stone wheel wraps around\n"
                 + "the base of the fountain inside the bowl."; 
        }
        return this.searchDialog; 
    }
/*----------------------------------------------------------------------------*/     
    @Override public String getDescription() {
        if (this.drained) {
            return "With the fountain drained, you find decaying plant matter\n"
                 + "resting on the bottom. A curious stone wheel wraps around\n"
                 + "the base of the fountain inside the bowl."; 
        }
        return this.description; 
    }
/*----------------------------------------------------------------------------*/     
    public void drain() {
        this.drained = true;        
    }
/*----------------------------------------------------------------------------*/
    public boolean isDrained() {
        return this.drained;
    }
/*----------------------------------------------------------------------------*/
}
