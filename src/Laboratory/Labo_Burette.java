package Laboratory;

import A_Main.GUI;
import A_Main.Player;
import static A_Main.NameConstants.*;
import A_Super.Furniture;
import A_Super.Item;
/**
 * Used to titrate wine and vinegar for the phase door potion.
 * Uses titrator task.
 * 
 * @author Kevin Rapa
 */
public class Labo_Burette extends Furniture {
    // ======================================
    private enum Titrant {
        EMPTY("nothing"), 
        WINE("wine"), 
        VINEGAR("vinegar");
        // ==================================
        private final String NAME;
        // ==================================
        Titrant(String name) {
            this.NAME = name;
        }
        // ==================================
        @Override public String toString() {
            return NAME;
        } 
    }
    // ======================================
    private final Item VIAL_REF, TUBE_REF;
    private Titrant mode;
    // ========================================================================
    public Labo_Burette (Item emptyVial, Item testTube) {
        super();
        this.searchable = false;
        this.mode = Titrant.EMPTY;
        this.VIAL_REF = emptyVial;
        this.TUBE_REF = testTube;
        this.description = "It's a tall glass tube for dispensing particular quanities of liquids.\n"
                         + "On the top is an opening to pour a liquid. On the bottom is a nozzle\n"
                         + "and stopcock for dispensing it. Make sure you have a vial or\n"
                         + "test tube to catch the liquid with. The burette has ";
        this.actDialog = "You need a vial or test tube to dispense into!";

        this.addNameKeys("(?:glass )?buret(?:te)?", "buret(?:te)? stopcock");
        this.addUseKeys(BOTTLE_OF_WINE, BOTTLE_OF_VINEGAR, TEST_TUBE, EMPTY_VIAL);
        this.addActKeys("use", "dispense", "open", "drain", "rotate", "turn", "twist", "empty");
    }
    // ========================================================================    
    @Override public String getDescription() {
        return this.description.concat(mode.toString() + " in it.");
    }
    // ========================================================================    
    @Override public String getSearchDialog() {
        return this.interact("use");
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (item.toString().equals(BOTTLE_OF_VINEGAR)) {
            if (this.mode != Titrant.EMPTY)
                return "The burette has liquid in it already!";
            else
                this.mode = Titrant.VINEGAR;
        }
        else if (item.toString().equals(BOTTLE_OF_WINE)) {
            if (this.mode != Titrant.EMPTY)
                return "The burette has liquid in it already!";
            else
                this.mode = Titrant.WINE;
        }
        
        return this.interact("use");
    }
    // ========================================================================   
    @Override public String interact(String key) {   
        if (Player.hasItem(LAB_COAT)) {
            if (mode != Titrant.EMPTY) {
                GUI.out("Would you like to titrate the " + mode + " or empty the burette?");
                GUI.menOut("\n<1> Empty the burette\n<2> Titrate the " + mode + ".\n< > Back");
                String ans = GUI.promptOut();
                
                while (! ans.matches("[12]|")) {
                    GUI.menOut("Pick a valid answer.\n<1> Empty the burette\n<2> Titrate the " + mode + ".\n< > Back");
                    ans = GUI.promptOut();
                }
                if (Player.isNonEmptyString(ans)) {
                    switch (Integer.parseInt(ans)) {
                        case 1:
                            this.mode = Titrant.EMPTY;
                            return "You empty everything out of the burette.";
                        default :
                            return dispenseDialog();
                    }
                }
                else
                    return null;
            }
            else
                return "The burette is empty.";
        }
        else
            return "You know, it really wouldn't be safe to fool around with this dangerous "
                 + "science equipment without first putting on a lab coat. Better find a lab coat first.";
    }
    // ========================================================================   
    private String dispenseDialog() {
        if (Player.hasItem(TEST_TUBE)) {
            Player.getInv().remove(TUBE_REF);
            Player.getInv().add(dispense());
            return null;
        }
        else if (Player.hasItem(EMPTY_VIAL)) {
            Player.getInv().remove(VIAL_REF);
            Player.getInv().add(dispense());
            return null;
        }
        else 
            return this.actDialog;
    }
    // ========================================================================  
    private Item dispense() {
        GUI.out(mode.toString() + " will be dispensed in 5 mL increments. Press enter to start titrating. Press enter to stop titrating.");
        GUI.menOut("Press enter...");
        GUI.promptOut();
        
        int volume = TitrationTask.titrate();
        
        switch(this.mode) {
            case WINE:
                return new Ingredient("wine " + volume + "mL", "The vial holds a small amount of wine.");
            default: // Never EMPTY. Ensured in interact()
                return new Ingredient("vinegar " + volume + "mL", "The vial holds a small amount of vinegar.");
        }
    }
    // ========================================================================  

}


