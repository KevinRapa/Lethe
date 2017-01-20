package Trophy_Room;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;
import A_Super.Openable;

public class Gal5_Cabinet extends Furniture implements Openable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal5_Cabinet(Item... items) {
        super(items);
        this.searchable = false;
        this.actDialog = "The tiny gold key fits perfectly. You turn it and the\n"
                            + "cabinet makes a satisfying *click*.";
        this.description = "It's a large wooden double-doored cabinet. It is fancily\n"
                         + "carved and looks as though it holds something valuable.";
        this.searchDialog = "The cabinet is locked. Looks like you'll need a key.";
        this.addActKeys("unlock");
        this.addNameKeys("(?:large )?(?:wood(?:en)? )?(?:double-doored )?(?:curio )?cabinet");
    }    
//*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {            
        if (Player.hasKey(Id.GCBT) && ! this.searchable) {
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
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (Player.hasKey(Id.GCBT) && ! this.searchable) {
            AudioPlayer.playEffect(13);
            this.searchable = true;
            return this.actDialog;
        }
        else if (this.searchable)
            return  "You look inside the cabinet.";
        
        else {
            AudioPlayer.playEffect(4);
            return this.searchDialog;
        }
    }
/*----------------------------------------------------------------------------*/
}

