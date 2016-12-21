package Parlor;

import Super.Furniture;
import Super.Item;

public class Par1_Cshn extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Par1_Cshn(Item ... items) {
        super(items);
        this.description = "It's a lavender tassled cushion for sitting on.";
        this.searchDialog = "You lift the cushion.";
        this.interactDialog = "Now is not the time for that!";
        this.addNameKeys("cushion", "lavender cushion");
        this.addActKeys("sit", "relax");
    }
}