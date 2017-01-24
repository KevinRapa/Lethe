package A_Super;
/**
 * Represents an NPC that you can talk to.
 * 
 * Interacting with the NPC will call <code>converse1</code>, unless the NPC
 * has been talked to before, in which case <code>converse2</code> will be
 * called. More converse methods may be defined.
 * 
 * Converse methods may have differing return types depending on implementation.
 * 
 * @author Kevin Rapa
 */
abstract public class NonPlayerCharacter extends Furniture {
    protected boolean firstTime; // If the player hasn't talked to this before.
    protected static final String ATTACK_PATTERN = "kill|hit|punch|murder",
                                  ATTACK_DIALOG = "You really aren't a natural killer...";
    // ========================================================================
    public NonPlayerCharacter () {
        super();
        this.firstTime = true;
        this.useDialog = ATTACK_DIALOG;
        
        this.addUseKeys(WEAPONS);
        this.addActKeys("speak", "talk", "converse", "chat");
    }
    // ======================================================================== 
    abstract protected<T extends Object> T converse1();
    // ========================================================================   
    abstract protected<T extends Object> T converse2();   
    // ========================================================================  
    public boolean firstTime() {
        return this.firstTime;
    }
    // ========================================================================    
}


