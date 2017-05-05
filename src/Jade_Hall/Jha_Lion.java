package Jade_Hall;

import A_Main.AudioPlayer;
import A_Main.Id;
import static A_Main.Names.AQUAMARINE;
import static A_Main.Names.RUBY;
import A_Main.Player;
import A_Super.Item;
import A_Super.Moveable;
import A_Super.Statue;
/**
 * @author Kevin Rapa
 */
public class Jha_Lion extends Statue implements Moveable {
    private boolean hasRuby;
    private static final String DESC2 =
            "It's a menacing jade statue of a lion. Sparkling "
           + "rubies sit in both its eye sockets. Strange that "
           + "someone decided to display them way back here where "
           + "no one can see them.";
    //-------------------------------------------------------------------------
    public Jha_Lion () {
        super();

        this.hasRuby = false;
        
        this.description = "It's a menacing jade statue of a lion. A sparkling "
                         + "ruby sits in one of its eye sockets. The other socket "
                         + "is empty. Strange that someone decided to display "
                         + "them way back here where no one can see them. ";
        this.searchDialog = "There don't seem to be any secret compartments "
                          + "on this statue. Although, one of the rubies sitting "
                          + "in its eye sockets has gone missing.";
        this.useDialog = "You place the ruby into the lion's eye socket. The ruby "
                       + "glints and stays in place.";

        this.addNameKeys("(?:jade )?(?:lion )?statue", "(?:jade )?lion", "(?:lion'?s? )?eye");
        this.addUseKeys(RUBY, AQUAMARINE);
    }
    //------------------------------------------------------------------------- 
    @Override public String getDescription() {
        return hasRuby ? DESC2 : this.description;
    }
    //-------------------------------------------------------------------------   
    @Override public String getSearchDialog() {
        return hasRuby ? "There doesn't seem to be any secret compartments "
                       + "on this statue." : this.searchDialog;
    }
    //-------------------------------------------------------------------------   
    @Override public String useEvent(Item item) {
        if (! hasRuby) {
            if (item.toString().equals(AQUAMARINE))
                return "You insert the blue gem into the socket, but it sits "
                     + "there only momentarily before falling out.";
            else {
                this.hasRuby = true;
                AudioPlayer.playEffect(43);
                Player.getInv().remove(item);
                return this.useDialog 
                        + ((Jha2)Player.getRoomObj(Id.JHA2)).lionCheck();
            }
        }
        else
            return "There's no place to fit the " + item + ".";
    }
    //-------------------------------------------------------------------------    
}


