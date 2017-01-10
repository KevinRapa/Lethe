package Laboratory;

import A_Main.GUI;
import A_Main.Inventory;
import A_Super.Furniture;
import A_Super.Container;
import A_Super.Ingredient;
import A_Super.Item;
/**
 * @see Laboratory.Labo for solution
 * @author Kevin Rapa
 */
public class Labo_DryIce extends Furniture implements Container {
    private final Item DRY_ICE;
    // ========================================================================
    public Labo_DryIce (Item flask) {
        super();
        
        DRY_ICE = new Item("dry ice", "This stuff is cold! It hurts for you to hold.");
        this.inv = new Ice_Inventory(DRY_ICE, DRY_ICE, flask, DRY_ICE, DRY_ICE);
        
        this.description = "The wooden barrel is wrapped in some kind of foam. It looks insulated.";
        this.searchDialog = "The barrel is filled with dry ice.";

        this.addNameKeys("(?:wooden |foam )?barrel");
    }
    // ========================================================================
    @Override public String getSearchDialog() {
        if (this.searchable)
            return this.searchDialog;
        else
            return "The rusty liquid is chilling. Better give it more time.";
    }
    // ========================================================================    
    // ************************************************************************
    // ========================================================================   
    private class Chill extends Thread {
        String volume;
        
        public Chill(String volume) {
            super();
            this.volume = volume;
        }
        // ==========================================
        @Override public void run() {
            Labo_DryIce.this.searchable = false;
            
            try {
                synchronized (this) {
                    GUI.out("Better give it some time to chill before taking it out.");
                    this.wait(30000);
                    GUI.out("The rusty liquid is probably cold enough now. Better go check it.");
                    this.reOpen();
                }
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        // ==========================================
        public void reOpen() {
            for (Item i : Labo_DryIce.this.getInv())
                if (i.toString().matches("Br \\d{1,2}mL"))
                    Labo_DryIce.this.getInv().remove(i);
            
            Labo_DryIce.this.getInv().add(new Ingredient("chilled " + volume, "the rusty liquid is cold and has stopped evaporating."));
            Labo_DryIce.this.searchable = true;
        }
    }
    // ========================================================================    
    // ************************************************************************
    // ========================================================================    
    private class Ice_Inventory extends Inventory {
        boolean busy;
        // ==========================================
        public Ice_Inventory(Item ... items) {
            super(items);
            this.busy = false;
        }
        // ==========================================
        @Override public boolean add(Item item) {
            if (! busy && item.toString().matches("Br \\d{1,2}mL")) {
                // Chills the bromine for a bit, seals off barrel.
                Chill chillBromine = new Chill(item.toString());
                busy = true;
                chillBromine.start();
                busy = false;
                return true;
            }
            else if (! busy) {
                this.CONTENTS.add(item);
                return true;
            }
            else {
                GUI.invOut("You're chilling something right now. Better leave it alone.");
                return false;
            }
        }
        // ==========================================
        @Override public void remove(Item item) { 
            if (item.equals(DRY_ICE))
                ; // Player can never remove all the dry ice;
            else
                this.contents().remove(item);
        }
    }    
    // ========================================================================    
    // ************************************************************************
    // ========================================================================        
}


