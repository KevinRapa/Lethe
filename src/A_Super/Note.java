package A_Super;

import A_Main.AudioPlayer;
/**
 * Represents a piece of paper with writing on it. 
 * Plays a paper noise when inspected or used.
 * 
 * @author Kevin Rapa
 */
public class Note extends Item {
/*----------------------------------------------------------------------------*/    
    public Note(String name) {
        super(name);
        this.useID = 1;
    }
/*----------------------------------------------------------------------------*/    
    public Note(String name, String desc) {
        super(name, desc);
        this.useID = 1;
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent() {
        AudioPlayer.playEffect(2);
        return this.description;
    }
/*----------------------------------------------------------------------------*/   
    @Override public String getDesc() {
        return this.useEvent();
    }
/*----------------------------------------------------------------------------*/   
}
