package Cellar;

import A_Main.AudioPlayer;
import static A_Main.Names.WEAPON;
import A_Super.Furniture;
import A_Super.Gettable;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Cel6_Pipe extends Furniture implements Gettable {
    //-------------------------------------------------------------------------
    public Cel6_Pipe () {
        super();
        
        this.description = "The metal pipe feeding all the way down the shaft "
                + "drains here into the blackness.";
        this.actDialog = "You will need to turn the valve to do that.";
        this.useDialog = "Hitting the pipe is futile.";

        this.addUseKeys(ANYTHING);
        this.addNameKeys("(?:metal )?pipe");
        this.addActKeys(GETPATTERN, "open");
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {              
        if (key.equals("open"))
            return this.actDialog;
        else
            return getIt();
    }
    //-------------------------------------------------------------------------   
    @Override public String useEvent(Item item) {
        if (item.getType().equals(WEAPON)) {
            AudioPlayer.playEffect(35);
            return this.useDialog;
        }
        else
            return DEFAULT_USE;
    }
    //-------------------------------------------------------------------------
}


