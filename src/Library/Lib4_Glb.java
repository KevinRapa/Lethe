package Library;

import A_Super.Furniture;

public class Lib4_Glb extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib4_Glb() {
        super();
        this.searchable = false;
        this.description = "The globe looks antique, but on a closer look, it\n"
                         + "seems fairly modern. Early 1920s you guess.";
        this.actDialog = "You think to yourself, 'when I get out of here, I'd like\n"
                    + "to stay this adventurous but be three times as safe.' You\n"
                    + "spin the globe and blindly stop it on a country, intending\n"
                    + "to take take a well-earned vacation after this ordeal is\n"
                    + "through. You stop on the Soviet Union. 'Well, maybe I'll\n"
                    + "wait a few years for all that nonsense to end over there'.";
        this.addNameKeys("globe", "large globe");
        this.addActKeys("spin", "rotate", "turn");
    }
/*----------------------------------------------------------------------------*/
}
