package Workshop;

import A_Super.Note;
/**
 * Helps player locate ingredients for making the red lens.
 * @author Kevin Rapa
 */
public class Wrk_Note extends Note {
/* CONSTRUCTOR ---------------------------------------------------------------*/
    public Wrk_Note(String name) {
        super(name);
        this.description = 
                "The note is an order of ingredients, " +
                "oddly never sent out. " +
                "Among the ingredients are many kinds of " +
                "dyes, potassium salts, aluminum, and steel. " +
                "Written last is 'sand' " +
                "but it has been crossed out with 'ask " +
                "groundskeeper' written after it.";
    }
//-----------------------------------------------------------------------------
}