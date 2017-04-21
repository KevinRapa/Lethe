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
                "The note appears to be an order of ingredients. " +
                "Oddly, it appears to never have been sent out. " +
                "Among the ingredients are many kinds of " +
                "dyes, potassium salts, aluminum, and steel. " +
                "Written last is 'sand, 3 [unit missing]' " +
                "but it has been crossed out with 'ask  " +
                "groundskeeper' written after it.";
    }
//-----------------------------------------------------------------------------
}