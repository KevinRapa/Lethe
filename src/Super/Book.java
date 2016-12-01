package Super;

import Core.GUI;

public class Book extends Note {
    protected final int numPages;
    protected String[] pageList;
    
    public Book(String name, int num) {
        super(name);
        this.useDialog = "You close the book";
        this.numPages = num;
        this.pageList = new String[num];
    }   
/*----------------------------------------------------------------------------*/
    @Override public String getDesc() {
        this.Read();
        GUI.clearDialog();
        return this.useDialog; 
    }          
/*----------------------------------------------------------------------------*/
    @Override public String useEvent() {
        this.Read();
        GUI.clearDialog();
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
    protected void Read() {
        int page = 0;
        String choice = "";
        
        do {
            GUI.out(this.pageList[page] + "\n");

            if (page != (this.numPages - 1)) {
                do {
                    GUI.menOut("Turn page?\n<'yes'> Turn the page\n<'no'> Close the book");
                    choice = GUI.promptOut();
                } while (! (choice.matches("yes") || choice.matches("no")));
                
                if (choice.matches("yes")) 
                    page ++;
            }
            else {
                GUI.menOut("<enter> Close the book");
                GUI.promptOut(); 
                choice = "no"; 
            }
            
        } while (! choice.matches("no"));      
        
    }
/*----------------------------------------------------------------------------*/   
}
