package Rotunda;

import Super.Furniture;

public class Rotu_Stat extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Stat(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "The cloaked statue glooms over you with an angry\n"
                         + "stare. 'What a magnificent beard...' you think to\n"
                         + "yourself.";
        this.searchDialog = "The statue appears to hide nothing.";
        this.interactDialog = "You feel the statue, but you feel discomforted in thinking\n"
                    + "that somehow, the other statues may be watching you.";
        this.addNameKeys("statue", "glaring statues");
        this.addActKeys("touch", "grab", "feel");
    }
/*----------------------------------------------------------------------------*/
}