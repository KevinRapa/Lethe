package A_Super;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Menus;
import static A_Main.Patterns.NO;
import static A_Main.Patterns.YES;
/**
 * Represents a book with one or more pages.
 * 
 * Interacting with a book will take the player to sub prompt where the player
 * may turn pages to read further or close the book.
 * 
 * @author Kevin Rapa
 */
public class Book extends Note {
    protected final int PAGES;
    protected final String[] PAGE_LIST;
    
    public Book(String name, int num) {
        super(name);
        this.useDialog = "You close the book.";
        this.PAGES = num;
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
    protected void Read() {
        int page = 0;
        String choice;
        
        do {
            AudioPlayer.playEffect(2);
            GUI.out(this.PAGE_LIST[page] + "\n");

            if (page != (this.PAGES - 1)) {
                
                choice = GUI.askChoice(Menus.BOOK_MEN, "[yn]|yes|no|");

                if (YES.matcher(choice).matches()) 
                    page ++;
                else
                    choice = "no";
            }
            else {
                GUI.menOut("\n\n< > Close the book");
                GUI.promptOut(); 
                choice = "no"; 
            }
        } while (! NO.matcher(choice).matches());      
    }
/*----------------------------------------------------------------------------*/   
}
