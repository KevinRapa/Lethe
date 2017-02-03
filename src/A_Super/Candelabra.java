package A_Super;

import A_Main.GUI;
import A_Main.Inventory;
import static A_Main.NameConstants.CANDLE;
import static A_Main.NameConstants.HAND_TORCH;
import A_Main.Player;

/**
 * @author Kevin Rapa
 */
abstract public class Candelabra extends SearchableFurniture 
        implements Gettable {
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
        this.addActKeys(GETPATTERN);
        this.addActKeys("touch");
        
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
            if (this.inv.contains(CANDLE_REF))
                return this.actDialog;
            else
                return "You touch it. The candelabra lacks any candles, so you avoid burning.";
        }
        else
            return getIt();
    }
    // ========================================================================     
    @Override public String getIt() {
        if (this.inv.contains(CANDLE_REF))
            if (Player.getInv().add(CANDLE_REF)) {
                this.inv.remove(CANDLE_REF);
                return "You take a candle off the candelabra.";
            }
            else
                return "You already have a candle.";
        else
            return "The candelabra holds no more candles";
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
                GUI.out("That doesn't belong there!");
                return false;
            }
        }
    }
    // ========================================================================     
    // ************************************************************************
    // ========================================================================     
}


