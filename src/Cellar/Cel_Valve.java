package Cellar;

import A_Main.AudioPlayer;
import static A_Main.Names.HAMMER;
import static A_Main.Names.MONKEY_WRENCH;
import Rotunda.Rotu_Fountain;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Unmoveable;
/**
 * Drains the fountain in the rotunda.
 * 
 * @see Rotunda.Rotu_Fountain
 * @author Kevin Rapa
 */
public class Cel_Valve extends Furniture implements Unmoveable {
    private final Rotu_Fountain FNTN_REF;
    protected boolean open, loosened;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cel_Valve(Furniture fntn) {
        super();

        this.FNTN_REF = (Rotu_Fountain)fntn;
        
        this.loosened = false;
        this.open = false;
        
        this.useDialog = "What crazy ideas are going through your head right now?";
        this.searchDialog = 
                "There's nothing hidden near the valve. Honestly, "
                + "you never expected to find anything.";
        this.description = 
                "It's a big rusty valve mounted to the wall. In the "
                + "center is a metal bolt.";
        this.actDialog = "You tighten back up the valve. ";
        
        this.addNameKeys("(?:big )?(?:rusty )?valve", "(?:metal )?bolt");
        this.addUseKeys(HAMMER, MONKEY_WRENCH);
        this.addActKeys(VALVEPATTERN);
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(String key) {
        open = ! open; 
        
        AudioPlayer.playEffect(17);

        return open ? 
                "You loosen the valve. " + FNTN_REF.loosen(1) :
                actDialog + FNTN_REF.loosen(-1); 
    }
/*----------------------------------------------------------------------------*/ 
        @Override public String useEvent(Item item) {
        if (item.toString().equals(MONKEY_WRENCH)) {
            AudioPlayer.playEffect(17);
            this.loosened = true;
            return "You can loosen the bolt a little, though it does not "
                + "seem too necessary at the moment.";
        }
        else
            return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
}