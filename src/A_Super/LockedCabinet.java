package A_Super;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
/**
 * @author Kevin Rapa
 */
public class LockedCabinet extends SearchableFurniture implements Openable {
    private final String KEY;
    // ========================================================================
    public LockedCabinet(String key, Item ... items) {
        super(items);
        
        this.KEY = key;
        this.searchable = false;

        this.addNameKeys("cabinet");
        this.addActKeys("unlock");
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        if (Player.hasKey(Id.CBNT) && ! this.searchable) {
            AudioPlayer.playEffect(13);
            this.searchable = true;
            return this.actDialog;
        }
        else if (this.searchable)
            return "You look inside the cabinet.";

        else {
            AudioPlayer.playEffect(4);
            return this.searchDialog;
        }
    }
    // ========================================================================   
    @Override public String interact(String key) {            
        if (Player.hasKey(KEY) && ! this.searchable) {
            this.searchable = true; 
            AudioPlayer.playEffect(13);
            return this.actDialog;
        }
        else if (! this.searchable) {
            AudioPlayer.playEffect(4);
            return "The door won't open. You'll need a key.";
        }
        else 
            return "You have unlocked it already.";
    }
    // ========================================================================     
}


