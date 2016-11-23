package Servants_Hall;

import Super.Item;

public class Wood_Chunk extends Item {
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wood_Chunk(String name, Item forms) {
        super(name, forms, "battering ram", 3);
        this.description = "It's a fat hunk of oak, you'd know anywhere.\n"
                         + "A hole is bored through each end, and you can\n"
                         + "see small fibers inside each."
                         + "There's an\ninscription on the side. It says:\n\n"
                         + "-Bashmaster Batterworks-\n"
                         + "    -Quality battering rams since 1288-";
    }
/*----------------------------------------------------------------------------*/            
}
