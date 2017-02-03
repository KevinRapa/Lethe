package Laboratory;

import A_Main.GUI;
import A_Main.Inventory;
import A_Main.Player;
import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
import static A_Main.Patterns.TITRANT;
/**
 * Used to cool down vials of bromine.
 * Multi-threaded. Runs a thread call Chill_THREAD.
 * 
 * @see Laboratory.Labo for solution
 * @author Kevin Rapa
 */
public class Labo_DryIce extends SearchableFurniture implements Openable {
    private final Item DRY_ICE_REF;
    private transient Chill_Thread chillBromine;
    // ========================================================================
    public Labo_DryIce (Item flask) {
        super();
        
        DRY_ICE_REF = new Item("dry ice", "This stuff is cold! It hurts for you to hold.");
        this.inv = new Ice_Inventory(DRY_ICE_REF, DRY_ICE_REF, flask, DRY_ICE_REF, DRY_ICE_REF);
        
        this.description = "The wooden barrel is wrapped in some kind of foam. It looks insulated.";
        this.searchDialog = "The barrel is filled with dry ice.";

        this.addNameKeys("(?:wooden |foam )?barrel");
    }
    // ========================================================================
    @Override public String getSearchDialog() {
        
        if(chillBromine != null && chillBromine.isAlive()) {
            chillBromine.interrupt();
            
            try { // Allows time for inventory to update before displaying.
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            return null;
        }
        
        if (this.searchable)
            return this.searchDialog;
        else
            return "The rusty liquid is chilling. Better give it more time.";
    }
    // ========================================================================    
    // ************************************************************************
    // ========================================================================   
    /**
     * Chills any chemical if left alone for 25 seconds.
     */
    private class Ice_Inventory extends Inventory {
        public Ice_Inventory(Item ... items) {
            super(items);
        }
    // ========================================================================
        @Override public boolean add(Item item) {
            this.CONTENTS.add(item);
            
            if (TITRANT.matcher(item.toString()).matches()) {
                // Chills the chemical for a bit, seals off barrel.
                chillBromine = new Chill_Thread(item, this);
                chillBromine.start();
                return true;
            }
            return true;
        }
    // ========================================================================
        @Override public void remove(Item item) { 
            if (! item.equals(DRY_ICE_REF))
                this.contents().remove(item);
        }
    }    
    // ========================================================================    
    // ************************************************************************
    // ======================================================================== 
    /**
     * Converts chemical into chilled chemicals in 25 seconds.
     */
    private class Chill_Thread extends Thread {
        private final String ITEM_NAME;
        private final Item BROMINE;
        private final Inventory BARREL_INV;
    // ========================================================================
        public Chill_Thread(Item item, Inventory inv) {
            super();
            this.setDaemon(true);
            this.BROMINE = item;
            this.BARREL_INV = inv;
            this.ITEM_NAME = item.toString();
        }
    // ========================================================================
        @Override public void run() {     
            try {
                synchronized (this) {
                    GUI.out("Better give it some time to chill before taking it out.");
                    this.wait(25000);

                    if (BARREL_INV.contains(BROMINE))
                        GUI.out("The liquid is probably cold enough now. Better go check it.");

                    this.reOpen(false);
                }
            } catch (InterruptedException ex) {
                GUI.out("You opened the barrel up too soon! The chemical hasn't had time to cool.");
                this.reOpen(true);
            }
        }
    // ========================================================================
        public void reOpen(boolean interrupted) {
            if (! interrupted && BARREL_INV.contains(BROMINE)) {
                BARREL_INV.remove(BROMINE);
                BARREL_INV.add(new Ingredient("chilled " + 
                    ITEM_NAME, "the chemical feels cold to the touch."));   
            }
            else if (BARREL_INV.contains(BROMINE)) {
                BARREL_INV.give(BROMINE, Player.getInv());
            }    
        }
    }
    // ========================================================================    
    // ************************************************************************
    // ========================================================================
}


