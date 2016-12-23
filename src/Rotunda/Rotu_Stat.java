package Rotunda;

import A_Super.Statue;

public class Rotu_Stat extends Statue {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Stat() {
        super();
        this.description = "The cloaked statue glooms over you with an angry\n"
                         + "stare. 'What a magnificent beard...' you think to\n"
                         + "yourself.";
        this.actDialog = "You feel the statue, but you feel discomforted in thinking\n"
                       + "that somehow, the other statues may be watching you.";
        this.addNameKeys("glaring statues");
    }
/*----------------------------------------------------------------------------*/
}