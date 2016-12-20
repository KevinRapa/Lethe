package Super;

import Main.AudioPlayer;
import Main.GUI;

public class Safe extends Furniture {
    protected final String COMBO;
    protected final int[] DIALS; 
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Safe (String combo, Item... items) {
        super(items);
        this.COMBO = combo;
        this.DIALS = new int[3];
        this.DIALS[0] = (int)(Math.random() * 10.0);
        this.DIALS[1] = (int)(Math.random() * 10.0);
        this.DIALS[2] = (int)(Math.random() * 10.0);
        this.interactDialog = "The safe is still locked.";
        this.searchDialog = this.interactDialog;
        this.searchable = false;
        this.addActKeys("open", "use", "spin", "twist", "smash");
        this.addNameKeys("safe", "stringbox");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        String rep = this.searchDialog;
       
        if (! this.searchable) {
            GUI.out("The safe is locked.");
            this.openSub();
        }
        if (this.searchable)
            rep = "The safe is unlocked!";
            
        return rep;
    }
/*----------------------------------------------------------------------------*/
    private void openSub() {
        boolean successful;
        String action;
        
        GUI.menOut("<'1'> Turn dial one\n<'2'> Turn dial two\n<'3'> Turn dial three\n" +
                          "< > Back\n");
        do {
            GUI.out("\t  [" + DIALS[0] + "][" + DIALS[1] + "][" + DIALS[2] + "]");      

            action = GUI.promptOut();
            
            if (action.matches("[123]")) {
                successful = this.turnDial(Integer.parseInt(action) - 1);
                
                if (successful) {
                    this.searchable = true;
                    GUI.menOut("You here a click."); 
                }
                else {
                    this.searchable = false;
                    GUI.menOut("<'1'> Turn dial one\n<'2'> Turn dial two\n<'3'> Turn dial three\n" +
                               "< > Back\n");
                }
            } 
        } while (! action.matches(""));
    }
/*----------------------------------------------------------------------------*/
    private boolean turnDial(int i) {
        AudioPlayer.playEffect(10);
        if (this.DIALS[i] == 9)
            DIALS[i] = 0;
        else
            DIALS[i]++;
        
        return this.check();
    }
/*----------------------------------------------------------------------------*/
    private boolean check() {
        String currentCombo = "";
        
        for (int dial : this.DIALS)
            currentCombo += Integer.toString(dial);
                  
        return currentCombo.matches(this.COMBO);
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {              
        String rep = this.interactDialog;
        
        if (key.matches("smash"))
            rep = "Now you WOULD like to do that, wouldn't you?";
        
        else if (! this.searchable) {
            GUI.out("The safe has a combination lock.");
            this.openSub();
            
            if (this.searchable)
                rep = "The safe is unlocked!";
        }
        else
            rep = "The safe is already open. Perhaps you\n"
                + "should search it.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
