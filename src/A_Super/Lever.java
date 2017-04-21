package A_Super;

import A_Main.AudioPlayer;

/**
 * Defines the mechanisms of a generic lever.
 * Levers, unlike buttons, can be on or off.
 * 
 * <code>event</code> defines what the lever does.
 * 
 * @author Kevin Rapa
 */
abstract public class Lever extends Furniture {
    protected boolean isOn;
    //-------------------------------------------------------------------------
    public Lever() {
        super();
        this.isOn = false;
        this.addActKeys("pull", "push", "flick", "hit", "move");
    }
    //-------------------------------------------------------------------------
    @Override public String interact(String key) {
        this.swtch();
        AudioPlayer.playEffect(12);
        return this.event(key);
    } 
    //-------------------------------------------------------------------------
    protected void swtch() {
        this.isOn = ! this.isOn;
    }
    //-------------------------------------------------------------------------
    abstract protected String event(String key);
    //-------------------------------------------------------------------------
}


