package Torture_Chamber;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * This item must be used in SEW4 to give access to the metal pipe in order to
 * replace the missing piece.
 * 
 * When this item is used, it places itself as furniture in the room and removes
 * itself from the player inventory. When said furniture is picked up, it removes
 * itself from the room and is placed in the player's inventory.
 * 
 * @see Tunnels.Sew4_Pipe
 * @author Kevin Rapa
 */
public class Metal_Ladder extends Item {
    private final Metal_Ladder_Furniture LADDER_FURNITURE;
    // ========================================================================
    public Metal_Ladder(String name) {
        super(name, 
              "It's an old extendable metal ladder. It must rise maybe 20 feet total...",
              "You stand the ladder up in the room." 
              );

        this.LADDER_FURNITURE = new Metal_Ladder_Furniture(this);
    }
    // ========================================================================
    @Override public String useEvent() {
        Player.getInv().remove(this);
        Player.getPos().addFurniture(LADDER_FURNITURE);
        Player.printInv();
        
        if (! Player.getPosId().equals(Id.SEW4))
            return this.useDialog;
        else {
            return "You extend the ladder and lean it up against the tunnel wall.\n"
                 + "It just reaches the top.";
        }
    }
    // ========================================================================
    // ************************************************************************
    // ========================================================================
    private class Metal_Ladder_Furniture extends Furniture {
        private final Item LADDER_ITEM;
        // ========================================================================
        public Metal_Ladder_Furniture (Item ladderItem) {
            super();
            
            this.LADDER_ITEM = ladderItem;

            this.description = "The old metal ladder stands in the center of the room, going nowhere.";
            this.actDialog = "You climb up the ladder. \"There's really not much\n"
                           + "need to be up here,\" you think to yourself, and climb down.";

            this.addNameKeys("(?:old )?(?:metal )?ladder");
            this.addActKeys(GETPATTERN);
            this.addActKeys("climb", "use");
        }
        // ====================================================================  
        @Override public String interact(String key) {     
            if (key.equals("climb") || key.equals("use")) {
                AudioPlayer.playEffect(47);
                if (! Player.getPosId().equals(Id.SEW4))
                    return this.actDialog;
                else
                    return "You climb high up the ladder to the pipe on the ceiling.";
            }
            else {
                Player.getPos().removeFurniture(this);
                Player.getInv().add(LADDER_ITEM);
                return "You pick up the ladder.";
            }
        }
        // ====================================================================    
        @Override public String getDescription() {
            if (! Player.getPosId().equals(Id.SEW4))
                return this.description;
            else
                return "The metal ladder stands extended against the tunnel wall.\n"
                     + "It just reaches the pipe at the top.";
        }
    }
    // ========================================================================
    // ************************************************************************
    // ========================================================================
}
