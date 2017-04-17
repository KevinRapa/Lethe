package Gallery;

import A_Main.GUI;
import A_Main.Inventory;
import A_Super.Gettable;
import A_Super.Item;
import A_Super.SearchableFurniture;
import A_Super.BreakableItem;
import static A_Main.Names.CHARGED_BATTERY;
import static A_Main.Names.DEAD_BATTERY;
/**
 * Player must use this to charge the dead battery before using it on the cannon
 * 
 * @see Gallery.Gal6_Cnn
 * @author Kevin Rapa
 */ 
public class Gal6_Apparatus extends SearchableFurniture implements Gettable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Apparatus() {
        super();
        
        this.inv = new Apparatus_Inventory();
        
        this.searchDialog = "You look on the platform.";
        this.actDialog = "The device appears to be powered by some invisible source and lacks an off switch.";
        this.description = "The weird apparatus looks like a metal platform "
                         + "with three curved arms projecting out and over its top "
                         + "of itself. Wires run all over the thing, and lights "
                         + "on it go *bleep bleep bleep*. The machine emits "
                         + "some sort of blue light. Next to the apparatus is a label "
                         + "that reads: \"Plasma induction charger\".";
        
        this.addActKeys(GETPATTERN, "turn", "repair|fix");
        this.addNameKeys("(?:unknown )?apparatus", "(?:plasma induction )?charger");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.equals("turn"))
            return this.actDialog;
        else if (key.equals("repair") || key.equals("fix"))
            return "I don't think that device is broken.";
        return getIt("This device is too big and heavy to put in your pockets.");
    }
// ============================================================================    
// ****************************************************************************
// ============================================================================   
    /**
     * Charges the battery for 25 seconds.
     */
    private class Apparatus_Inventory extends Inventory {
        private transient Charge_Thread chargeThread;
    // ========================================================================
        @Override public boolean add(Item item) {
            this.CONTENTS.add(item);
            
            if (item.toString().equals(DEAD_BATTERY)) {
                // Charges the battery.
                chargeThread = new Charge_Thread(item, this);
                chargeThread.start();
            }
            
            return true;
        }
     // ========================================================================
        @Override public void remove(Item removeThis) {
            this.CONTENTS.remove(removeThis);
            
            if (removeThis.toString().equals(DEAD_BATTERY) && chargeThread != null)
                chargeThread.interrupt();
        }
    }    
    // ========================================================================    
    // ************************************************************************
    // ======================================================================== 
    /**
     * Converts chemical into chilled chemicals in 25 seconds.
     */
    private static class Charge_Thread extends Thread {
        private final Item DEAD_BATTERY;
        private final Inventory APPARATUS_INV;
    // ========================================================================
        public Charge_Thread(Item battery, Inventory inv) {
            super();
            this.setDaemon(true);
            this.DEAD_BATTERY = battery;
            this.APPARATUS_INV = inv;
        }
    // ========================================================================
        @Override public void run() {     
            try {
                synchronized (this) {
                    GUI.out("The battery appears to be charging. Better give it some time.");
                    this.wait(25000);

                    if (APPARATUS_INV.contains(DEAD_BATTERY))
                        GUI.out("The battery has likely charged enough at this point.");

                    this.reOpen();
                }
            } catch (InterruptedException ex) {
                GUI.out("Your impatience has interrupted the charging cycle.");
            }
        }
    // ========================================================================
        public void reOpen() {
            if (APPARATUS_INV.contains(DEAD_BATTERY)) {
                APPARATUS_INV.remove(DEAD_BATTERY);
                APPARATUS_INV.add(new BreakableItem(CHARGED_BATTERY, 
                        "The heavy metal box is now warm to the touch.", 160));
            }   
        }
    }
// ============================================================================
// ****************************************************************************
// ============================================================================
}
