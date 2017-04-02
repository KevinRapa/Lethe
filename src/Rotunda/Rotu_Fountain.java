package Rotunda;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Unmoveable;
/**
 * Can be drained by a valve in Look which gives access to a wheel which
 * rotates the Rotunda.
 * 
 * 
 * @see Lookout.Look_Valve
 * @author Kevin Rapa
 */
public class Rotu_Fountain extends Furniture implements Unmoveable {
    private boolean drained;
    private int valvesTurned;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Rotu_Fountain() {       
        super();
        
        this.valvesTurned = 0;
        this.drained = false;
        this.description = "It's rounded and carefully carved from a smooth rock. "
                         + "It looks quite beautiful, except that it's filled "
                         + "with opaque brown water.";
        this.actDialog = "Are you really that desperate for a drink? There must be some cleaner water in here somewhere...";
        this.searchDialog = "You can't see anything through the brown water.";
        this.addActKeys("drink", "swim", "drain", "empty");
        this.addNameKeys("(?:round )?(?:marble )?fountain");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
    if (key.equals("drink"))
        return (this.drained) ? 
            "The disgusting water has already been drained." :
            this.actDialog;
    else if (key.equals("swim"))
        return (this.drained) ? 
            "The disgusting water has already been drained." :
            "An absolutely smashing idea. You'll be out of here in no time.";
    else
        return (this.drained) ?
            "The disgusting water has already been drained." :
            "You have nothing useful with which to empty it.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {        
        return (this.drained) ?
           "Looking inside the bowl, you find decaying plant matter "
         + "resting on the bottom. A curious stone wheel wraps around "
         + "the base of the fountain inside the bowl."
                : this.searchDialog; 
    }
/*----------------------------------------------------------------------------*/     
    @Override public String getDescription() {
        return (this.drained) ?
           "With the fountain drained, you find decaying plant matter "
         + "resting on the bottom. A curious stone wheel wraps around "
         + "the base of the fountain inside the bowl." 
                : this.description; 
    }
/*----------------------------------------------------------------------------*/     
    public void drain() {
        this.drained = true;   
        AudioPlayer.playEffect(20);
        Player.getRoomObj(Id.ROTU).addFurniture(new Rotu_Wheel());
    }
/*----------------------------------------------------------------------------*/
    public String loosen(int amount) {
        this.valvesTurned += amount;
        
        if (! drained && valvesTurned == 3) {
            drain();
            return "As you turn the valve, you hear rushing water. Immediately, "
                 + "a gush of water can be heard flowing through the nearby pipe.";
        }
        else
            return NOTHING;
    }
/*----------------------------------------------------------------------------*/
    public boolean isDrained() {
        return this.drained;
    }
/*----------------------------------------------------------------------------*/
}
