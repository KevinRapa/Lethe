package Library;

import A_Super.Furniture;
import A_Super.Moveable;

public class Lib4_Globe extends Furniture implements Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib4_Globe() {
        super();
 
        this.description = "The globe looks antique, but on a closer look, it "
                         + "seems fairly modern. Early 1920s you guess.";
        this.actDialog = "You think to yourself, 'when I get out of here, I'd like "
                    + "to stay this adventurous but be three times as safe.' You "
                    + "spin the globe and blindly stop it on a country, intending "
                    + "to take take a well-earned vacation after this ordeal is "
                    + "through. You stop on the Soviet Union. 'Well, maybe I'll "
                    + "wait a few years for all that nonsense to end over there'.";
        this.addNameKeys("globe", "large globe");
        this.addActKeys("spin", "rotate", "turn");
    }
/*----------------------------------------------------------------------------*/
}
