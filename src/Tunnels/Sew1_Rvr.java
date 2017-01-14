package Tunnels;

import A_Main.GUI;
import A_Main.Inventory;
import A_Super.Item;
/**
 * Items added to any part of the river will be added to this object's inventory
 * instead.
 * The metal piece of pipe, a needed item, can be found here.
 * 
 * @author Kevin Rapa
 */
public class Sew1_Rvr extends Sewer_River {
    // ========================================================================
    public Sew1_Rvr (Item pipe, Item wtr) {
        super(wtr);

        this.inv = new Sew1_River_Inventory(pipe);
        
        this.description = "The river is about 11 feet across and 5 feet deep.\n" +
                           "It flows through an artificial square trench\n" +
                           "constructed into the floor. The water looks clear\n" +
                           "and smells quite clean. You imagine that it was\n" +
                           "a natural spring at some point before being built \n" +
                           "around. It flows briskly and terminates here at\n" +
                           "a metal grate. ";
    }
    // ========================================================================
    // ************************************************************************
    // ========================================================================
    private class Sew1_River_Inventory extends Inventory {
        public Sew1_River_Inventory(Item pipe) {
            super(pipe);
        }
        // ====================================================================
        @Override public boolean add(Item item) {
            this.CONTENTS.add(item);
            GUI.out("You reluctantly drop it in the river.");
            return true;
        }
        // ====================================================================
        @Override public void remove(Item item) {
            this.CONTENTS.remove(item);
            GUI.out("Though your aren't fond of the idea of jumping in, you figure\n"
                  + "that your weight should be enough to keep you on your feet.\n"
                  + "you jump in, holding on to the edge to retrieve the item.");
        }
    }
    // ========================================================================
    // ************************************************************************
    // ========================================================================
}


