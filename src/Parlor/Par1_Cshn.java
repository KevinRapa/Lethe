package Parlor;

import Super.Furniture;

public class Par1_Cshn extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Par1_Cshn() {
        super();
        this.searchable = false;
        this.description = "It's a lavender tassled cushion for sitting on.";
        this.searchDialog = "You lift the cushion, but find just rug.";
        this.interactDialog = "Now is not the time for that!";
        this.addNameKeys("cushion", "lavender cushion");
        this.addActKeys("sit", "relax");
    }
}