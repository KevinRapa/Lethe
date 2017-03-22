package Observatory;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Inventory;
import A_Main.Names;
import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * Holds the brass plates for observatory statue puzzle.
 * 
 * @see Observatory.Obs_Slts
 * @author Kevin Rapa
 */
public class Obs1_Slot extends SearchableFurniture {
    private final String CORRECT;
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Obs1_Slot(String NAME, String correct, String desc, Item ... items) {
        super();
        this.CORRECT = correct;
        this.description = desc;
        this.searchDialog = "This indentation in the floor reads, " + desc.substring(17) + "."; 
        this.addNameKeys(NAME, NAME.toLowerCase());
        this.inv = new Slt_Inv(items);
    }
/*----------------------------------------------------------------------------*/
    public boolean isCorrect() {
        if (this.inv.size() == 1) {
            String plateName = this.inv.get(0).toString().substring(14).replaceAll("\"", NOTHING);
            return this.CORRECT.matches(plateName);
        }
        else return false;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (this.inv.size() == 1 && this.searchable)
            return "A plate has been fit into the slot.";
        else
            return this.searchDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (this.inv.size() == 1)
            return "The " + this.inv.get(0) + " has been fit into the slot.";
        else
            return this.description;
    }
/*----------------------------------------------------------------------------*/
    public void lock() {
        this.searchable = false;
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/     
/*----------------------------------------------------------------------------*/
    private class Slt_Inv extends Inventory {
        public Slt_Inv(Item ... items) {
            super(items);
        }
        /*--------------------------------------------------------------------*/
        @Override public boolean add(Item item) {
            if (this.size() == 0) {
                if (item.getType().equals(Names.PLATE)) {
                    AudioPlayer.playEffect(43);
                    this.CONTENTS.add(item);
                    return true;
                }
                else
                    GUI.out("It doesn't seem like that belongs here.");
            }
            else
                GUI.out("There's already a plate in here.");
            
            return false;
        }
    }    
/*----------------------------------------------------------------------------*/
/******************************************************************************/    
/*----------------------------------------------------------------------------*/
}