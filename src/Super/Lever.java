package Super;

import Main.AudioPlayer;

/**
 * Defines the mechanisms of a generic lever.
 * 
 * @author Kevin Rapa
 */
abstract public class Lever extends Furniture {
    protected boolean isOn;
    // ========================================================================
    public Lever() {
        super();
        this.searchable = false;
        this.isOn = false;
        this.addActKeys("pull", "push", "flick", "hit", "move");
    }
    // ========================================================================
    @Override public String interact(String key) {
        this.swtch();
        AudioPlayer.playEffect(12);
        return this.event(key);
    } 
    // ========================================================================
    /**
     * Switches the state, plays a noise, then initiates the child-specific event.
     */
    protected void swtch() {
        this.isOn = ! this.isOn;
    }
    // ========================================================================
    abstract protected String event(String key);
    // ========================================================================
}


