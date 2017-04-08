package Laboratory;

import A_Main.GUI;
import A_Main.Menus;
import A_Main.Player;
import static A_Main.Names.*;
import static A_Main.Patterns.LABO_BURET_ONE_OR_TWO;
import A_Super.Furniture;
import A_Super.Item;
/**
 * Used to titrate wine and vinegar for the phase door potion.
 * Uses titrator task.
 * 
 * @author Kevin Rapa
 */
public class Labo_Burette extends Furniture {
    
    //-----------------------------------
    private enum Titrant {
        EMPTY("nothing "), // Shouldn't be dispensed ever.
        WINE("wine "), 
        VINEGAR("vinegar "),
        HOLYWATER("holy water "),
        ACETONE("acetone "),
        WATER("H2O "),
        GLUE("glue "),
        CLEANER("cleaning solution ");

        private final String NAME;

        Titrant(String name) {
            this.NAME = name;
        }
        @Override public String toString() {
            return NAME;
        } 
    }
    //-----------------------------------
    
    private final Item VIAL_REF, TUBE_REF;
    private Titrant mode;
    // ========================================================================
    public Labo_Burette (Item emptyVial, Item testTube) {
        super();

        this.mode = Titrant.EMPTY;
        this.VIAL_REF = emptyVial;
        this.TUBE_REF = testTube;
        this.description = "It's a tall glass tube for dispensing particular quantities of liquids. "
                         + "On the top is an opening to pour a liquid. On the bottom is a nozzle "
                         + "and stopcock for dispensing it. Make sure you have a vial or "
                         + "test tube to catch the liquid with. The burette has ";
        this.actDialog = "You need a vial or test tube to dispense into!";

        this.addNameKeys("(?:glass )?buret(?:te)?", "buret(?:te)? stopcock");
        this.addUseKeys(BOTTLE_OF_WINE, BOTTLE_OF_VINEGAR, TEST_TUBE, EMPTY_VIAL, 
                HOLY_WATER, ACETONE, BUCKET_OF_WATER, CLEANING_SOLUTION, GLUE_BOTTLE);
        this.addActKeys("use", VALVEPATTERN, "dispense", "drain", "empty", "titrate");
    }
    // ========================================================================    
    @Override public String getDescription() {
        return this.description.concat(mode.toString() + "in it.");
    }
    // ========================================================================    
    @Override public String getSearchDialog() {
        return this.interact("use");
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (item.toString().equals(TEST_TUBE) 
                && ! item.toString().equals(EMPTY_VIAL) 
                    && this.mode == Titrant.EMPTY)
            return "The burette has liquid in it already!";

        switch(item.toString()) {
            case BOTTLE_OF_VINEGAR:
                this.mode = Titrant.VINEGAR;    break;
            case BOTTLE_OF_WINE:
                this.mode = Titrant.WINE;       break;
            case HOLY_WATER:
                this.mode = Titrant.HOLYWATER;  break;
            case ACETONE:
                this.mode = Titrant.ACETONE;    break;
            case BUCKET_OF_WATER:
                this.mode = Titrant.WATER;      break;
            case CLEANING_SOLUTION:
                this.mode = Titrant.CLEANER;    break;
            case GLUE_BOTTLE:
                this.mode = Titrant.GLUE;       break;                      
        }

        return this.interact("use");
    }
    // ========================================================================   
    @Override public String interact(String key) {   
        if (key.equals("empty") || key.equals("drain")) {
            this.mode = Titrant.EMPTY;
            return "The burette is now empty.";
        }
        else if (mode != Titrant.EMPTY) {
            GUI.out("Would you like to titrate the " + mode + "or empty the burette?");

            String ans = GUI.askChoice(Menus.LABO_BURET, LABO_BURET_ONE_OR_TWO);

            if (Player.isNonEmptyString(ans)) {
                if (ans.equals("1")) {
                    this.mode = Titrant.EMPTY;
                    return "You empty everything out of the burette.";
                }
                else
                    return dispenseDialog();
            }
            else
                return NOTHING;
        }
        else
            return "The burette is currently empty.";
    }
    // ========================================================================   
    private String dispenseDialog() {
        if (Player.hasItem(TEST_TUBE)) {
            Player.getInv().remove(TUBE_REF);
            Player.getInv().add(dispense());
            return NOTHING;
        }
        else if (Player.hasItem(EMPTY_VIAL)) {
            Player.getInv().remove(VIAL_REF);
            Player.getInv().add(dispense());
            return NOTHING;
        }
        else 
            return this.actDialog;
    }
    // ========================================================================  
    private Item dispense() {
        GUI.out(mode.toString() + "will be dispensed in 5 mL increments. Press "
                + "enter to start titrating and then a second time to stop titrating.");
        GUI.menOut(Menus.ENTER);
        GUI.promptOut();
        
        int volume = TitrationTask.titrate();

        return new Ingredient(mode.toString() + volume + "mL", 
                "The vial holds a small amount of " + mode + ".", 0);
    }
    // ========================================================================  

}


