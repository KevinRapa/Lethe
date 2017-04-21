package Courtyard;

import A_Main.Names;
import A_Super.Furniture;
import A_Main.AudioPlayer;
import A_Super.Unmoveable;
/**
 * The castle's front gate.
 * 
 * @author Kevin Rapa
 */
public class Cou3_Gate extends Furniture implements Unmoveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou3_Gate() {
        super();

        this.useDialog = "Not even with your exceptional stamina could you drill a hole through this gate with that.";
        this.description = "The monstrous two-story solid oak gate traps you "
                         + "inside.";
        this.actDialog = "It's huge. Even if it were unlocked, you wouldn't be able "
                       + "to budge it alone.";
        
        this.addUseKeys(Names.HAND_DRILL);
        this.addActKeys("open", "use", "knock", "close", "shut");
        this.addNameKeys("(?:monstrous )?(?:two-story )?(?:solid )?(?:oak )?(?:main |front )?gate");
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {
        if (key.equals("open") || key.equals("use"))
            return this.actDialog;
        else if (key.equals("knock")) {
            AudioPlayer.playEffect(55);
            return "You give the gate a knock. To your astonishment, your knock is left unanswered.";
        }
        else
            return "Why would you do that? The PROBLEM is that it's closed!";
    }
//-----------------------------------------------------------------------------
}
