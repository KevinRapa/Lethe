package Laboratory;

import A_Main.GUI;
import A_Main.Inventory;
import static A_Main.Names.INGREDIENT;
import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Used to cool down ingredients.
 * Multi-threaded. Runs a thread call Chill_Thread.
 * 
 * @see Laboratory.Labo for solution
 * @author Kevin Rapa
 */
public class Labo_IceBarrel extends SearchableFurniture 
        implements Openable, Unmoveable 
{
    private final Item DRY_ICE_REF;
    // ========================================================================
    public Labo_IceBarrel (Item flask) {
        super();

        DRY_ICE_REF = new Item("dry ice", "This stuff is cold! It hurts for you to hold.", 0);
        this.inv = new Ice_Inventory(DRY_ICE_REF, DRY_ICE_REF, flask, DRY_ICE_REF, DRY_ICE_REF);
        
        this.description = "The wooden barrel is wrapped in some kind of foam "
                + "functioning as insulation. There's some writing on the lid: \"25 seconds, no less.\"";
        this.searchDialog = "The barrel is filled with dry ice.";

        this.addNameKeys("(?:unusual )?(?:wooden |foam )?barrel");
    }
    // ========================================================================    
    // ************************************************************************
    // ========================================================================   
    /**
     * Chills any chemical if left alone for 25 seconds.
     * Uses a hash map to keep track of any active threads. A new thread is
     * made whenever an ingredient is added, and threads are canceled when
     * ingredients are removed.
     */
    private class Ice_Inventory extends Inventory {
        // Don't want to try to serialize any threads.
        private transient HashMap<Integer,Chill_Thread> THREAD_MAP;
        
        public Ice_Inventory(Item ... items) {
            super(items);
        }
    // ========================================================================
        @Override public boolean add(Item item) {
            this.CONTENTS.add(item);
            
            if (THREAD_MAP == null)
                THREAD_MAP = new HashMap<>();
            
            if (item.getType().equals(INGREDIENT)) {
                // Chills the chemical for a bit, seals off barrel.
                GUI.out("Better give it some time to chill before taking it out.");
                Chill_Thread t = new Chill_Thread(item, this.CONTENTS);
                int hashCode = item.hashCode();
                THREAD_MAP.put(hashCode, t);
                t.start();
            }
            return true;
        }
    // ========================================================================
        @Override public void remove(Item removeThis) {
            this.CONTENTS.remove(removeThis);
            
            if (THREAD_MAP == null)
                THREAD_MAP = new HashMap<>();
            
            if (THREAD_MAP.containsKey(removeThis.hashCode())) {
                THREAD_MAP.remove(removeThis.hashCode()).interrupt();
                GUI.out("Your impatience has interrupted the cooling.");
            }
        }
    }    
    // ========================================================================    
    // ************************************************************************
    // ======================================================================== 
    /**
     * Converts chemical into chilled chemicals in 25 seconds.
     */
    private class Chill_Thread extends Thread {
        private final Item CHEMICAL;
        private final ArrayList<Item> BARREL_INV;
    // ========================================================================
        public Chill_Thread(Item item, ArrayList<Item> inv) {
            super();
            this.setDaemon(true);
            this.CHEMICAL = item;
            this.BARREL_INV = inv;
        }
    // ========================================================================
        @Override public void run() {     
            try {
                synchronized (this) {
                    this.wait(25000);
                    
                    this.addChilledItem();
                }
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    // ========================================================================
        public void addChilledItem() {
            if (BARREL_INV.contains(CHEMICAL)) {
                // If chilled ingredients are chilled, they become "Super chilled"
                String prefix = (CHEMICAL.toString().charAt(0) == 'c') ? 
                        "super " : "chilled "; 
                
                BARREL_INV.remove(CHEMICAL);
                
                BARREL_INV.add(new Ingredient(prefix + CHEMICAL, 
                        "The chemical feels cold to the touch.", 0));   
            }
        }
    }
    // ========================================================================    
    // ************************************************************************
    // ========================================================================
}


