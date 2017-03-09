package Servants_Quarters;

import A_Main.AudioPlayer;
import A_Super.Furniture;
import A_Super.Gettable;
        
public class Squa_Candle extends Furniture implements Gettable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Squa_Candle () {
        super();

        this.description = "A lit candle. The wax has hardly melted!";
        this.actDialog = "Ouch! That's really hot!";
        this.addNameKeys("(?:lit )?(?:wax )?candle");
        this.addActKeys(GETPATTERN, HOLDPATTERN);
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.matches(HOLDPATTERN)) {
            AudioPlayer.playEffect(39, -10);
            return this.actDialog;
        }
        else
            return getIt();
    }
/*----------------------------------------------------------------------------*/
    @Override public String getIt() {
        return "You attempt to blow out the flame before taking it. As though\n"
             + "part of some elaborate prank, the flame refuses to die and thwarts\n"
             + "your intention.";
    }
/*----------------------------------------------------------------------------*/
}