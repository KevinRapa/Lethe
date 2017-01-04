package A_Super;

import A_Main.AudioPlayer;
import A_Main.GUI;

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
                do {
                    GUI.menOut("Turn page?\n<'y'> Turn the page\n<'n'> Close the book");
                    choice = GUI.promptOut();
                } while (! choice.matches("[yn]|yes|no|"));
                
                if (choice.matches("yes|y")) 
                    page ++;
                else
                    choice = "no";
            }
            else {
                GUI.menOut("< > Close the book");
                GUI.promptOut(); 
                choice = "no"; 
            }
        } while (! choice.matches("no"));      
    }
/*----------------------------------------------------------------------------*/   
}
