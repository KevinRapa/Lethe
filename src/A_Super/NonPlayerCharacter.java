package A_Super;

/**
 * Represents an NPC that you can talk to.
 * 
 * @author Kevin Rapa
 */
abstract public class NonPlayerCharacter extends Furniture {
    protected boolean firstTime;
    // ========================================================================
    public NonPlayerCharacter () {
        super();
        this.searchable = false;
        this.firstTime = true;

        this.addActKeys("speak", "talk", "converse");
    }
    // ======================================================================== 
    abstract protected<T extends Object> T converse1(); // First time speaking to this npc.
    // ========================================================================   
    abstract protected<T extends Object> T converse2(); // All other times.  
    // ========================================================================  
    public boolean firstTime() {
        return this.firstTime;
    }
    // ========================================================================    
}


