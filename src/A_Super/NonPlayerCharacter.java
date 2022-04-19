package A_Super;

import static A_Main.Names.WEAPON;

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
abstract public class NonPlayerCharacter extends Furniture implements Moveable {
    protected boolean firstTime; // If the player hasn't talked to this before.
    protected static final String 
            ATTACK_PATTERN = "kill|hit|punch|murder|attack",
            ATTACK_DIALOG = "You really aren't a natural killer...",
            TALK_PATTERN = "speak|talk|converse|chat|greet|listen";
    //-------------------------------------------------------------------------
    public NonPlayerCharacter () {
        super();
        this.firstTime = true;
        this.useDialog = ATTACK_DIALOG;
        
        this.addUseKeys(ANYTHING);
        this.addActKeys(ATTACK_PATTERN, TALK_PATTERN);
    }
    //------------------------------------------------------------------------- 
    abstract protected String converse1();
    //-------------------------------------------------------------------------   
    abstract protected String converse2();   
    //-------------------------------------------------------------------------  
    public boolean firstTime() {
        return this.firstTime;
    }
    //-------------------------------------------------------------------------    
    @Override public String useEvent(Item item) {
        if (item.getType().equals(WEAPON))
            return ATTACK_DIALOG;
        else
            return "It looks like it's faring perfectly well without that.";
    }
    //-------------------------------------------------------------------------    
    @Override public String moveIt() {
        return "It probably wouldn't enjoy that too much.";
    }
    //-------------------------------------------------------------------------    
}


