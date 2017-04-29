package Laboratory;

import A_Main.GUI;
import A_Main.Menus;
import A_Main.Player;
import static A_Main.Names.*;
import static A_Main.Patterns.YES_NO_P;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Unmoveable;
import static A_Main.Patterns.ONE_TO_SIX;
/**
 * Dispenses various types of chemicals to be used in alchemy.
 * 
 * @see Laboratory.Labo for solution
 * @author Kevin Rapa
 */
public class Labo_Dispensers extends Furniture implements Unmoveable {
    private final Item VIAL_REF, TUBE_REF;
    //-------------------------------------------------------------------------
    public Labo_Dispensers (Item emptyVial, Item testTube) {
        super();

        this.VIAL_REF = emptyVial;
        this.TUBE_REF = testTube;
        
        this.searchDialog = "Many foreign chemical can be dispensed from their containers on the wall.";
        this.description = "The series of six opaque dispensers are "
                         + "lined up next to each other over a sink. At the bottom "
                         + "of each one is a rotating stopcock.";
        this.actDialog = "You need a vial or test tube to dispense into!";

        this.addNameKeys("(?:opaque )?(?:dispensers?|containers?)", 
                "dispenser stopcock", "liquid|chemicals?(?: dispensers?)?");
        this.addUseKeys(EMPTY_VIAL, TEST_TUBE);
        this.addActKeys("use", VALVEPATTERN, GETPATTERN, "dispense|drain|empty|titrate");
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {   
        if (Player.hasItem(TEST_TUBE)) {
            if (askToDispense()) {
                Player.getInv().remove(TUBE_REF);
                Player.getInv().add(dispense());
            }
            return NOTHING;
        }
        else if (Player.hasItem(EMPTY_VIAL)) {
            if (askToDispense()) {
                Player.getInv().remove(VIAL_REF);
                Player.getInv().add(dispense());
            }
            return NOTHING;
        }
        else {
            return this.actDialog;
        }
    }
    //-------------------------------------------------------------------------     
    @Override public String useEvent(Item item) {
        return this.interact("use");
    }
    //-------------------------------------------------------------------------  
    private Item dispense() {
        GUI.out("There are six dispensers on the wall. You cannot see inside them, "
              + "but each bears a label. From left to right, the labels read: \t\t1 - H2CO3   2 - Br "
              + "         3 - Ae      4 - HF          5 - NACL    6 - C20H14O4 \t\t\t\t\tDispense which one?");
        
        String ans = GUI.askChoice(Menus.LABO_DISP, ONE_TO_SIX);
        
        GUI.out("Liquid will be dispensed in 5 mL increments. Press enter to start titrating, then again after a period to stop titrating.");
        GUI.menOut(Menus.ENTER);
        GUI.promptOut();
        
        int volume = TitrationTask.titrate();
        
        switch(Integer.parseInt(ans)) {
            case 1:
                return new Ingredient("H2CO3 " + volume + "mL", "The vial holds a clear mundane liquid.", 0);
            case 2:
                return new Ingredient("Br " + volume + "mL", "The vial holds a odd rusty liquid. It's evaporating aggressively.", volume);
            case 3:
                return new Ingredient("ae " + volume + "mL", "The vial holds a pale blue, aromatic liquid.", volume);
            case 4:
                return new Ingredient("HF " + volume + "mL", "It's bubbling. Better be careful with this.", 0);
            case 5:
                return new Ingredient("NaCl " + volume + "mL", "The vial holds a clear mundane liquid.", 0);
            default:
                return new Ingredient("C20H14O4 " + volume + "mL", "The vial holds a funny pink liquid.", 0);
        }
    }
    //-------------------------------------------------------------------------  
    private boolean askToDispense() {
        GUI.out("You have something to dispense into. Would you like to dispense liquid?");

        String ans = GUI.askChoice(NL + "Dispense a chemical?", YES_NO_P);
        
        return (Player.answeredYes(ans));
    }
    //-------------------------------------------------------------------------  
    // ************************************************************************
    //-------------------------------------------------------------------------  
}


