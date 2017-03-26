package West_Antechamber;

import A_Super.Statue;

public class Want_Statue extends Statue {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Want_Statue() {
        super();
        this.description = "Inspecting each statue, you discover each to be " +
                           "depicting an Egyptian god. There's Anubis, god " +
                           "of the dead, Isis, goddess of magic, Thoth, god of " +
                           "wisdom, and Wadjet, goddess of protection. You " +
                           "notice what appears to be a lever attached to " +
                           "the base of one of them.";
        this.searchDialog = "They are plain statues. Upon closer inspection "
                          + "of one though, you find a lever hidden.";
        this.actDialog = "You feel a statue, but you are discomforted in thinking "
                       + "that somehow, the other statues may be watching you.";
        this.addNameKeys("statues");
    }
/*----------------------------------------------------------------------------*/
}
