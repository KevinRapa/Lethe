package A_Super;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Inventory;
import static A_Main.Names.CANDLE;
import static A_Main.Names.HAND_TORCH;
import A_Main.Player;

/**
 * @author Kevin Rapa
 */
abstract public class Candelabra extends SearchableFurniture 
        implements Gettable, Moveable {
    private final Item CANDLE_REF;
    // ========================================================================
    public Candelabra (Item candle) {
        super();
        
        this.CANDLE_REF = candle;
        
        this.actDialog = "Ow! It burns!";
        this.searchDialog = "The candelbra holds some candles.";
        this.useDialog = "The torch is already lit, despite having kept it in\n"
                       + "your pocket this whole time.";

        this.addNameKeys("candles?", "fire");
        this.addUseKeys(HAND_TORCH, CANDLE);
        this.addActKeys(GETPATTERN, "touch", "light");
        
        this.inv = new Candelabra_Inventory();
        
        for (int i = 1; i <= 5; i++)
            this.inv.add(candle);
    }
    // ======================================================================== 
    @Override public String getDescription() {
        if (this.inv.contains(CANDLE_REF))
            return this.description;
        else
            return "The candelabra holds no more candles.";
    }
    // ========================================================================   
    @Override public String useEvent(Item item) {
        if (item.equals(CANDLE_REF)) {
            Player.getInv().remove(item);
            this.inv.add(item);
            return "You store a candle.";
        }
        else
            return this.useDialog;
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        if (this.inv.contains(CANDLE_REF))
            return this.searchDialog;
        else
            return "The candelabra holds no more candles.";
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.equals("touch")) {
            if (this.inv.contains(CANDLE_REF)) {
                AudioPlayer.playEffect(39, 0.3);
                return this.actDialog;
            }
            else
                return "You touch it. Thankfully, the candelabra lacks any "
                        + "burning candles, and thus you avoid burning.";
        }
        else if (key.equals("light"))
            return "Lighting the candelabra surely will get you no closer to freedom.";
        else
            return getIt();
    }
    // ========================================================================     
    @Override public String getIt() {
        if (this.inv.contains(CANDLE_REF))
            if (this.inv.give(CANDLE_REF, Player.getInv()))
                return "You take a candle off the candelabra.";
            else
                return NOTHING;
        else
            return "The candelabra holds no more candles.";
    }
    // ========================================================================     
    // ************************************************************************
    // ========================================================================     
    private class Candelabra_Inventory extends Inventory {
        public Candelabra_Inventory() {
            super();
        }
        // ====================================================================
        @Override public boolean add(Item item) {
            if (item.equals(CANDLE_REF)) {
                this.CONTENTS.add(item);
                return true;
            }
            else {
                GUI.out("Candelabras are not meant to hold such things.");
                return false;
            }
        }
    }
    // ========================================================================     
    // ************************************************************************
    // ========================================================================     
}


