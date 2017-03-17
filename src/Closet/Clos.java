package Closet;

import A_Super.Room;
/**
 * The room contains a few items that the player needs to solve other puzzles.
 * Contains a crowbar, screws, and fertilizer which are required items.
 * 
 * @author Kevin Rapa
 */
public class Clos extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Clos(String name, String ID) {
        super(name, ID);
        this.description =
               "You step into a dimly lit cobblestone chamber with a\n" +
               "low arched ceiling. Right away, you are surprised by a\n"
             + "skeleton lying at your feet! Facing east, a large\n" +
               "wooden shelf and a barrel sit against the opposite\n" +
               "wall. Against the wall on your left sits a workbench\n"
             + "and stool. Behind you are various sacks of material.\n" +
               "On the floor in the back left corner is a ladder\n"
             + "leading down below.";
    }
/*----------------------------------------------------------------------------*/
}