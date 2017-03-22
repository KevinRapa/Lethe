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
                "The note appears to be an order of ingredients.\n" +
                "Oddly, it appears to never have been sent out.\n" +
                "Among the ingredients are many kinds of\n" +
                "dyes, potassium salts, aluminum, and steel.\n" +
                "Written last is 'sand, 3 [unit missing]'\n" +
                "but it has been crossed out with 'ask \n" +
                "groundskeeper' written after it.";
    }
/*----------------------------------------------------------------------------*/
}