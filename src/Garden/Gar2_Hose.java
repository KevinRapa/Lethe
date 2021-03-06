package Garden;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Climbable;
import A_Super.Direction;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Gar2_Hose extends Furniture implements Climbable {
    private final Item BRKNHOSE_REF;
    private final Furniture BRKNHOSE_REF2;
    //-------------------------------------------------------------------------
    public Gar2_Hose (Item brokenHoseItem) {
        super();

        this.BRKNHOSE_REF = brokenHoseItem;
        this.BRKNHOSE_REF2 = new Gar2_BrokenHose();
        
        this.description = "The cracked leather hose dangles down into the room "
                         + "below. It's only a short drop from the bottom. "
                         + "Hopefully it will take your weight.";
        this.actDialog = "Slowly, you climb down the hose. The hose maintains itself, "
                       + "however only feet from the bottom, the hose splits in half "
                       + "and falls to the floor. Only minimally hurt, you stand "
                       + "back up and peer at the other half, still tied to the "
                       + "railing.";

        this.addNameKeys("(?:leather )?hose");
        this.addActKeys(CLIMBPATTERN);
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {              
        Player.setOccupies(Id.ROTU);
        AudioPlayer.playEffect(36);
        Player.getRoomObj(Id.GAR2).removeFurniture(this.getID());
        Player.getRoomObj(Id.GAR2).addFurniture(BRKNHOSE_REF2);
        Player.getRoomObj(Id.FOY3).setLocked(false);
        Player.getInv().add(BRKNHOSE_REF);
        Player.printInv();
        
        return this.actDialog;
    }
    //-------------------------------------------------------------------------   
    @Override public Direction getDir() {
       return Direction.DOWN;
    }
    //-------------------------------------------------------------------------     
}


