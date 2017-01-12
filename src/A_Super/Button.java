package A_Super;

import A_Main.AudioPlayer;
/**
 * Defines the mechanisms of a generic button.
 * Pushing a button causes an event, but does not have an on or off state.
 * 
 * @author Kevin Rapa
 */
abstract public class Button extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Button() {
        super();
        this.searchable = false;
        this.searchDialog = "There's a sword here! No not really, just a button.";
        this.addActKeys("push", "hit", "activate");
        this.addNameKeys("button"); 
    }
/*----------------------------------------------------------------------------*/   
    @Override public String interact(String key) {
        AudioPlayer.playEffect(11);
        return this.event(key);
    }
/*----------------------------------------------------------------------------*/   
    abstract protected String event(String key);
/*----------------------------------------------------------------------------*/   
}
