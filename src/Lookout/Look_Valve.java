package Lookout;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import Rotunda.Rotu_Fountain;
import A_Super.Furniture;
import Rotunda.Rotu_Wheel;
/**
 * Drains the fountain in the rotunda.
 * 
 * @see Rotunda.Rotu_Fountain
 * @author Kevin Rapa
 */
public class Look_Valve extends Furniture{
    private final Rotu_Fountain FNTN_REF;
    private boolean loosened;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Look_Valve(Furniture fntn) {
        super();

        this.searchDialog = "There's nothing here. Honestly, you never expected\n"
                          + "to find anything.";
        this.description = "A big rusty valve. There's a small pipe sticking out\n"
                         + "of the wall next to it.";
        this.loosened = false;
        this.actDialog = "As you turn the valve, you hear rushing water. Immediately,\n"
                    + "a gush of water flows from the nearby pipe and off of the\n"
                    + "balcony.";
        this.FNTN_REF = (Rotu_Fountain) fntn;
        this.addNameKeys("valve", "(?:big )?(?:rusty )?valve");
        this.addActKeys(VALVEPATTERN);
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(String key) {
        if (! FNTN_REF.isDrained()) {
            FNTN_REF.drain();
            AudioPlayer.playEffect(20);
            Player.getRoomObj(Id.ROTU).addFurniture(new Rotu_Wheel());
            loosened = true; 
        }
        else {
            AudioPlayer.playEffect(17);
            loosened = ! loosened; 
            
            if (loosened) 
                return "You tighten back up the valve";
            else 
                return "You loosen the valve, but nothing happens.";         
        }       
        return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
    
}