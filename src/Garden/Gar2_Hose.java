package Garden;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Gar2_Hose extends Furniture {
    private final Item BRKNHOSE_REF;
    private final Furniture BRKNHOSE_REF2;
    // ========================================================================
    public Gar2_Hose (Furniture brokenHoseFurn, Item brokenHoseItem) {
        super();
        this.searchable = false;
        this.BRKNHOSE_REF = brokenHoseItem;
        this.BRKNHOSE_REF2 = brokenHoseFurn;
        
        this.description = "The cracked leather hose dangles down into the room\n"
                         + "below. It's only a short drop from the bottom.\n"
                         + "Hopefully it will take your weight.";
        this.actDialog = "Slowly, you climb down the hose. The maintains itself,\n"
                       + "however only feet from the bottom, the hose splits in half\n"
                       + "and falls to the floor. Only minimally hurt, you stand\n"
                       + "back up and peer at the other half, still tied to the\n"
                       + "railing.";

        this.addNameKeys("(?:leather )?hose");
        this.addActKeys("climb");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        Player.setOccupies(Id.ROTU);
        AudioPlayer.playEffect(36);
        Player.getRoomObj(Id.GAR2).removeFurniture(this);
        Player.getRoomObj(Id.GAR2).addFurniture(BRKNHOSE_REF2);
        Player.getRoomObj(Id.FOY3).unlock();
        Player.getInv().add(BRKNHOSE_REF);
        
        return this.actDialog;
    }
    // ========================================================================     
}


