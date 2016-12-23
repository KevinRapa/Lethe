package A_Super;

import A_Main.AudioPlayer;

public class Note extends Item {
    public Note(String name) {
        super(name);
        this.useID = 1;
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent() {
        AudioPlayer.playEffect(2);
        return this.description;
    }
/*----------------------------------------------------------------------------*/   
    @Override public String getDesc() {
        AudioPlayer.playEffect(2);
        return this.description;
    }
/*----------------------------------------------------------------------------*/   
}
