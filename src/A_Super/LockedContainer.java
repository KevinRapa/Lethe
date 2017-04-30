package A_Super;

import A_Main.AudioPlayer;
import A_Main.Player;
/**
 * Represents a locked container (Cabinet, chest, etc.) That requires a key to
 * to be opened. These keys have a unique type that do not match any room ID.
 * Container is opened by 'unlocking' or 'opening' it with the corresponding
 * key in possession. This is otherwise unsearchable before being unlocked.
 *
 * @author Kevin Rapa
 */
abstract public class LockedContainer extends SearchableFurniture 
        implements Openable, Moveable 
{
    private final String KEY;
    //-------------------------------------------------------------------------
    public LockedContainer(String key, Item ... items) {
        super(items);
        
        this.KEY = key; // ID of the key (type) used to unlock this.
        this.searchable = false; // Starts locked, need a key to make searchable.

        this.addActKeys("unlock");
    }
    //-------------------------------------------------------------------------   
    @Override public String getSearchDialog() {
        if (Player.hasKey(KEY) && ! this.searchable)
            return this.unlock();
        else if (this.searchable)
            return "You open it and look inside.";
        else
            return denyEntry();
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {            
        if (Player.hasKey(KEY) && ! this.searchable)
            return this.unlock();
        else if (this.searchable)
            return "Seems that you have already unlocked it.";
        else 
            return denyEntry();
    }
    //------------------------------------------------------------------------- 
    private String unlock() {
        this.searchable = true; 
        AudioPlayer.playEffect(13);
        return this.actDialog;
    }
    //------------------------------------------------------------------------- 
    private String denyEntry() {
        AudioPlayer.playEffect(4);
        return this.searchDialog;
    }
    //------------------------------------------------------------------------- 
}


