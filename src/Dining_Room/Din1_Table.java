package Dining_Room;

import A_Main.AudioPlayer;
import A_Super.Item;
import A_Super.SearchableFurniture;
        
public class Din1_Table extends SearchableFurniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din1_Table(Item... items) {
        super(items);
        
        this.description = "The table must be twenty feet long! A scarlet\n"
                         + "tablecloth coats its dark polished surface.";
        
        this.actDialog = "You give the table a nudge. It gives only slightly; the table is formidable.";
        this.searchDialog = "You look on the table's surface.";
        
        this.addActKeys(MOVEPATTERN);
        this.addActKeys(JOSTLEPATTERN);
        this.addNameKeys("(?:long )?table");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {              
        if (key.matches(MOVEPATTERN)) {
            AudioPlayer.playEffect(41);
            return "Gathering some momentum, you push into the table, sliding it some.";
        }
        else
            return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
}
