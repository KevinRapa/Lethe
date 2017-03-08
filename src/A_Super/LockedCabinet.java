package A_Super;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
/**
 * @author Kevin Rapa
 */
abstract public class LockedCabinet extends SearchableFurniture implements Openable {
    private final String KEY;
    // ========================================================================
    public LockedCabinet(String key, Item ... items) {
        super(items);
        
        this.KEY = key; // ID of the key (type) used to unlock this.
        this.searchable = false; // Starts locked, need a key to make searchable.

        this.addNameKeys("cabinet");
        this.addActKeys("unlock");
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        if (Player.hasKey(KEY) && ! this.searchable)
            return this.unlock();
        else if (this.searchable)
            return "You open it and look inside.";
        else {
            AudioPlayer.playEffect(4);
            return this.searchDialog;
        }
    }
    // ========================================================================   
    @Override public String interact(String key) {            
        if (Player.hasKey(KEY) && ! this.searchable)
            return this.unlock();
        else if (! this.searchable) {
            AudioPlayer.playEffect(4);
            return "It won't open. You'll need a key.";
        }
        else 
            return "Seems that you have already unlocked it.";
    }
    // ======================================================================== 
    private String unlock() {
        this.searchable = true; 
        AudioPlayer.playEffect(13);
        return this.actDialog;
    }
    // ======================================================================== 
}

