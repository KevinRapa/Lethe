package Crypt;

import A_Main.GUI;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * The player can search any of the cabinets, but none of them have anything
 * necessary in them.
 * 
 * @author Kevin Rapa
 */
public class Cry_Drawers extends Furniture implements Openable {
    private final Furniture[] DRAWERS = new Furniture[100];
    // ========================================================================
    public Cry_Drawers () {
        super();
        this.searchable = false;
        
        for (int i = 0; i < 100; i++)
            this.DRAWERS[i] = new Drwr();
        
        this.description = "The drawers are most likely being used to hold the\n"
                         + "dead. Who exactly, you don't know. The drawers are\n"
                         + "each labeled a with a number from 1 to 100.";
        
        this.searchDialog = "You pull the knob on the drawer. The door swings\n"
                          + "open revealing a dessicated corpse inside.";

        this.addNameKeys("drawers?", "knobs?", "numerous drawers");
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        GUI.out("The drawers are labeled from 1 to 100. Search which drawer?");
        String ans = GUI.askChoice("\n<#> Search...\n< > Back", "[1-9][0-9]?|100|");

        if (Player.isNonEmptyString(ans)) {
            GUI.out(this.searchDialog);
            Player.search(this.DRAWERS[Integer.parseInt(ans) - 1]); 
        }
        
        return null;
    }
    // ========================================================================     
    // ************************************************************************
    // ========================================================================   
    private class Drwr extends SearchableFurniture {
        public Drwr() {
            super();
            this.searchDialog = null;
        }
    }
    // ========================================================================  
    // ************************************************************************
    // ========================================================================
}


