package Servants_Hall;

import A_Super.Item;

public class Wood_Chunk extends Item {
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wood_Chunk(String name, Item forms, int thresh) {
        super(name, forms, thresh);
        this.description = "It's a fat hunk of oak, you'd know anywhere.\n"
                         + "A hole is bored through each end, and you can\n"
                         + "see small fibers inside each."
                         + "There's an inscription on the side. It says: \n"
                         + "-Bashmaster Batterworks-\n"
                         + "    -Quality battering rams since 1288-";
    }
/*----------------------------------------------------------------------------*/            
}
