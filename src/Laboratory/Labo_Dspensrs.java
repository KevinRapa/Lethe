package Laboratory;

import A_Main.GUI;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Ingredient;
/**
 * Dispenses various types of chemicals to be used in alchemy.
 * 
 * @see Laboratory.Labo for solution
 * @author Kevin Rapa
 */
public class Labo_Dspensrs extends Furniture {
    private final Item VIAL_REF, TUBE_REF;
    // ========================================================================
    public Labo_Dspensrs (Item emptyVial, Item testTube) {
        super();
        
        this.searchable = false;
        
        this.VIAL_REF = emptyVial;
        this.TUBE_REF = testTube;
        this.description = "The series of six opaque dispensers are\n"
                         + "lined up next to eachother over a sink. At the bottom\n"
                         + "of each one is a rotating stopcock.";
        this.actDialog = "You need a vial or test tube to dispense into!";

        this.addNameKeys("(?:opaque )?dispensers?", "dispenser stopcock");
        this.addUseKeys("empty vial", "test tube");
        this.addActKeys("use", "dispense", "open", "drain", "rotate", "turn", "twist", "empty");
    }
    // ========================================================================  
    @Override public String getSearchDialog() {
        return this.interact("use");
    }
    // ========================================================================   
    @Override public String interact(String key) {   
        if (Player.hasItem("lab coat")) {
            if (Player.hasItem("test tube")) {
                if (askToDispense()) {
                    Player.getInv().remove(TUBE_REF);
                    Player.getInv().add(dispense());
                }
                return "none";
            }
            else if (Player.hasItem("empty vial")) {
                if (askToDispense()) {
                    Player.getInv().remove(VIAL_REF);
                    Player.getInv().add(dispense());
                }
                return "none";
            }
            else {
                return this.actDialog;
            }
        }
        else
            return "You know, it really wouldn't be safe to fool around with this dangerous "
                 + "science equipment without first putting on a lab coat. Better find a lab coat first.";
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        return this.interact("use");
    }
    // ========================================================================  
    private Item dispense() {
        GUI.out("There are six dispensers on the wall. You cannot see inside them,\n"
              + "but each bears a label. From left to right, the labels read: \t\t1 - H2CO3   2 - Br "
              + "         3 - Ae      4 - HF          5 - NACL    6 - C20H14O4 \t\t\t\t\tDispense which one?");
        
        GUI.menOut("\n\n<#> Dispense");
        String ans = GUI.promptOut();
        
        while (! ans.matches("[1-6]")) {
            GUI.menOut("\nThat's not a valid choice.\n"
                     + "        <#> Dispense.");
            
            ans = GUI.promptOut();
        }
        
        GUI.out("Liquid will be dispensed in 5 mL increments. Press enter to start titrating. Press enter to stop titrating.");
        GUI.menOut("Press enter...");
        GUI.promptOut();
        
        int volume = TitrationTask.titrate();
        
        switch(Integer.parseInt(ans)) {
            case 1:
                return new Ingredient("H2CO3 " + volume + "mL", "The vial holds a clear mundane liquid.");
            case 2:
                return new Ingredient("Br " + volume + "mL", "The vial holds a odd rusty liquid. It's evaporating aggressively.");
            case 3:
                return new Ingredient("ae " + volume + "mL", "The vial holds a pale blue, aromatic liquid.");
            case 4:
                return new Ingredient("HF " + volume + "mL", "It's bubbling. Better be careful with this.");
            case 5:
                return new Ingredient("NaCl " + volume + "mL", "The vial holds a clear mundane liquid.");
            default:
                return new Ingredient("C20H14O4 " + volume + "mL", "The vial holds a funny pink liquid.");
        }
    }
    // ========================================================================  
    private boolean askToDispense() {
        GUI.out("You have something to dispense into. Would you like to dispense liquid?");
        GUI.menOut("\nDispense?\n<'y'/'n'>");
        String ans = GUI.promptOut();
        
        while (! ans.matches("[yn]|yes|no")) {
            GUI.out("Please type a valid answer");
            ans = GUI.promptOut();
        }
        return ans.matches("y|yes");
    }
    // ========================================================================  
    // ************************************************************************
    // ========================================================================  
}


