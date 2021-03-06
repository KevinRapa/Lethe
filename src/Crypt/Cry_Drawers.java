package Crypt;

import A_Main.GUI;
import A_Main.Inventory;
import A_Main.Main;
import A_Main.Menus;
import static A_Main.Names.BRAIN;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Openable;
import static A_Main.Patterns.ONE_TO_HUNDRED_P;
import A_Super.Item;
import A_Super.Liquid;
/**
 * The player can search any of the cabinets, but only one of them has
 * the brain in a jar.
 * This drawer is selected randomly when a new game is made.
 * 
 * @author Kevin Rapa
 */
public class Cry_Drawers extends Furniture implements Openable {
    private final Inventory[] DRAWERS = new Inventory[100];
    private final Item 
            BRAIN_REF = new Liquid(BRAIN, "The preserved brain in the glass jar "
                                + "is not something you're used to holding.", 10);
    public final int DRAWER_NUM; // Note given by zombie needs to know this number.
    //-------------------------------------------------------------------------
    public Cry_Drawers () {
        super();

        this.DRAWER_NUM = Main.getRandomUnder(99) + 1;
        
        for (int i = 0; i < 100; i++) 
            this.DRAWERS[i] = new Inventory();

        DRAWERS[DRAWER_NUM - 1].add(BRAIN_REF);
        
        this.description = "The drawers are most likely being used to hold the "
                         + "dead. Who exactly, you don't know. The drawers are "
                         + "each labeled a with a number from 1 to 100.";
        
        this.searchDialog = "You pull the knob on the drawer. The door swings "
                          + "open revealing a dessicated corpse inside.";

        this.addActKeys("slide", "pull", "remove");
        this.addNameKeys("drawers?", "knobs?", "numerous drawers");
    }
    //------------------------------------------------------------------------- 
    @Override public String interact(String key) {
        return this.getSearchDialog();
    }
    //-------------------------------------------------------------------------   
    @Override public String getSearchDialog() {
        GUI.out("The drawers are labeled from 1 to 100. Search which drawer?");
        String ans = GUI.askChoice(Menus.CRY_DRWRS, ONE_TO_HUNDRED_P);

        if (! ans.isEmpty()) {
            GUI.out(this.searchDialog);
            Player.search(this.DRAWERS[Integer.parseInt(ans) - 1]); 
        }
        
        return NOTHING;
    }
    //-------------------------------------------------------------------------     
}


