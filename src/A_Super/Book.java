package A_Super;

import A_Main.AudioPlayer;
import A_Main.GUI;
import static A_Main.Names.NL;
import static A_Main.Patterns.YES_NO_P;
import A_Main.Player;
/**
 * Represents a book with one or more pages.
 * 
 * Interacting with a book will take the player to sub prompt where the player
 * may turn pages to read further or close the book.
 * 
 * @author Kevin Rapa
 */
public class Book extends Note {
    protected final String[] PAGE_LIST;
    
    public Book(String name, int num) {
        super(name);
        this.useDialog = "You close the book.";
        this.PAGE_LIST = new String[num];
    }   
/*----------------------------------------------------------------------------*/
    @Override public String getDesc() {
        this.Read();
        GUI.clearDialog();
        return this.useDialog; 
    }          
/*----------------------------------------------------------------------------*/
    @Override public String useEvent() {
        return this.getDesc();
    }
/*----------------------------------------------------------------------------*/
    /**
     * Repeatedly asks player to flip through pages in the book until 'no'
     * or a blank string is entered. Closes the book at end of pages.
     */
    protected void Read() {
        int page = 0;
        String choice;
        
        do {
            AudioPlayer.playEffect(2);
            GUI.clearDialog();
            GUI.resetScroll();
            GUI.out(PAGE_LIST[page]);

            if (page != (PAGE_LIST.length - 1)) {
                
                choice = GUI.askChoice(NL + NL + "Turn the page?", YES_NO_P);

                if (Player.answeredYes(choice)) 
                    page ++;
            }
            else {
                GUI.menOut(NL + NL + "< > Close the book");
                GUI.promptOut(); 
                return;
            }
        } while (Player.answeredYes(choice));      
    }
/*----------------------------------------------------------------------------*/   
}
