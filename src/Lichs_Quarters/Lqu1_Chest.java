package Lichs_Quarters;

import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * Player's items are sent here after being captured in the Attic.
 * Currently this isn't used. Items sent to prison cabinet instead.
 * @see Attic.Att1#dialog()
 * @author Kevin Rapa
 */
public class Lqu1_Chest extends SearchableFurniture 
        implements Openable, Moveable 
{
    //-------------------------------------------------------------------------
    public Lqu1_Chest () {
        super();
        
        this.description = "It's a dark hickory chest.";
        this.searchDialog = "You open the chest.";

        this.addNameKeys("(?:dark )?(?:hickory |wooden )?chest");
    }
    //------------------------------------------------------------------------- 
}


