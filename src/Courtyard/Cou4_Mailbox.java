package Courtyard;

import A_Super.Gettable;
import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Cou4_Mailbox extends SearchableFurniture 
        implements Openable, Gettable, Unmoveable
{
    // ========================================================================
    public Cou4_Mailbox (Item... items) {
        super(items);
        
        this.description = 
                "It's a plain white mailbox. It feels quite out of "
                + "place here.";
        this.actDialog = "Mailboxes don't work that way!";
        this.searchDialog = "You open up the mailbox.";

        this.addNameKeys("(?:small )?(?:mail)?box");
        this.addActKeys(GETPATTERN, "lock", "unlock");
    }
    // ========================================================================  
    @Override public String interact(String key) {  
        if (key.equals("lock") || key.equals("unlock"))
            return this.actDialog;
        else
            return getIt();
    }
    // ========================================================================        
}


