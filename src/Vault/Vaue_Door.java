package Vault;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Id;
import A_Main.Menus;
import static A_Main.Patterns.VAUE_DOOR_COORDS_P;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Vaue_Door extends Furniture implements Unmoveable {
    //--------------------------------------
    private enum State {
        ON("[o]"), OFF("[ ]");
        
        private final String STATE;
        
        State(String state) {
            this.STATE = state;
        }
        @Override public String toString() {
            return this.STATE;
        }
    }
    //--------------------------------------
    
    private final State[][] BUTTONS = {
        {State.ON,State.ON,State.OFF,State.ON},
        {State.OFF,State.OFF,State.OFF,State.ON},
        {State.ON,State.ON,State.ON,State.OFF},
        {State.OFF,State.ON,State.OFF,State.OFF}
    };
    //-------------------------------------------------------------------------
    public Vaue_Door () {
        super();

        this.description = "Standing before you is an interesting wall resembling "
                         + "a sliding door. On it is a 4 by 4 grid of buttons. Drawn "
                         + "on each is a dark circular rune";
        this.searchDialog = "The only curiosity is the grid of buttons on the front.";
        
        this.addNameKeys("buttons?", "(?:sliding )?door", "(?:interesting |curious )?wall");
        this.addActKeys("push", "activate", "solve", "open");
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {            
        String ans;
        
        do {
            GUI.out(this.printButtons());

            ans = GUI.askChoice(Menus.VAEU_DOOR, VAUE_DOOR_COORDS_P);
            
            if (! ans.isEmpty()) {
                String[] crds = ans.split(" ?, ?");
                this.switchButtons(Integer.parseInt(crds[0]) - 1, 
                        4 - Integer.parseInt(crds[1]));
            }
            
            if (solved()) {
                Player.getRoomObj(Id.VAU2).setLocked(false);
                Player.getPos().removeFurniture(this.getID());
                AudioPlayer.playEffect(37);
                return "As you push the last button, all the runes become lit. "
                     + "The wall recedes into the floor slowly. "
                     + "As the dust settles, a long room filled with treasure is revealed.";
            }
        } while (! ans.isEmpty());
        
        return this.actDialog;
    }
    //-------------------------------------------------------------------------      
    private String printButtons() {
        int row = 4;
        StringBuilder b = new StringBuilder("\t\t\t\t\t");

        for (State[] i : BUTTONS) {
            b.append(row--);
            
            for (State j : i)
                b.append(j.toString());
            
            b.append("\t\t\t");
        }
        b.append("  1  2  3  4 \t\t\t");
        
        return b.toString();
    }
    //-------------------------------------------------------------------------      
    private void switchButtons(int x, int y) {
        flip(x, y);
        flip(x + 1, y);
        flip(x - 1, y);
        flip(x, y + 1);
        flip(x, y - 1);
        
        AudioPlayer.playEffect(43);
    }
    //-------------------------------------------------------------------------  
    private void flip(int x, int y) {
        try {
            switch (BUTTONS[y][x]) {
                case ON:
                    BUTTONS[y][x] = State.OFF;
                    break;
                default:
                    BUTTONS[y][x] = State.ON;
                    break;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {}
    }
    //-------------------------------------------------------------------------  
    private boolean solved() {
        for (State[] i : this.BUTTONS)
            for (State j : i)
                if (j == State.OFF)
                    return false;
        
        return true;    
    }
    //-------------------------------------------------------------------------  
}


