package Rotunda;

import A_Super.Statue;

public class Rotu_Statue extends Statue {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Statue() {
        super();
        this.description = "The cloaked statues gloom over you with angry "
                         + "stares. Perhaps they were happier at one point when "
                         + "this room was cleaner? Surely any normal person would "
                         + "be opposed to keeping such sinister objects in their home.";
        this.actDialog = "You feel the statue, but you feel discomforted in thinking "
                       + "that somehow, the other statues may be watching you.";
        this.addNameKeys("(?:cloaked )?(?:glaring )?statues?");
    }
/*----------------------------------------------------------------------------*/
}