package Jade_Hall;

import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Jha_Ln extends Furniture {
    private boolean hasRuby;
    private final String DESC2;
    // ========================================================================
    public Jha_Ln () {
        super();
        this.searchable = false;
        this.hasRuby = false;
        
        this.description = "It's a menacing jade statue of a lion. A sparkling\n"
                         + "ruby sits in one of its eye sockets. The other socket\n"
                         + "is empty. Strange that someone decided to display\n"
                         + "them way back here where no one can see them.\n";
        this.DESC2 = "It's a menacing jade statue of a lion. Sparkling\n"
                          + "rubies sit in both its eye sockets. Strange that\n"
                          + "someone decided to display them way back here where\n"
                          + "no one can see them.";
        this.searchDialog = "There doesn't seem to be any secret compartments\n"
                          + "on this statue. Although, one of the rubies sitting\n"
                          + "in its eye sockets has hone missing.";
        this.useDialog = "You place the ruby into the lion's eye socket. The ruby\n"
                       + "glints and stays in place. ";

        this.addNameKeys("jade statue", "lion statue", "statue", "jade lion statue");
        this.addUseKeys("ruby", "aquamarine");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return hasRuby ? this.DESC2 : this.description;
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return hasRuby ? "There doesn't seem to be any secret compartments\n"
                       + "on this statue." : this.searchDialog;
    }
    // ========================================================================   
    @Override public String useEvent(Item item) {
        if (! hasRuby) {
            if (item.toString().matches("aquamarine"))
                return "You insert the blue gem into the socket, but it sits\n"
                     + "there only momentarily before falling out.";
            else {
                this.hasRuby = true;
                Player.getInv().remove(item);
                return this.useDialog + ((Jha2)Player.getRoomRef("JHA2")).lionCheck();
            }
        }
        else
            return "There's no place to put the " + item + ".";
    }
    // ========================================================================     
    public boolean hasRuby() {
        return this.hasRuby;
    }
    // ========================================================================    
}


