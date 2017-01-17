package Vault;

import A_Main.GUI;
import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Vaue_Dr extends Furniture {
    // =====================================
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
    // =====================================
    
    private final State[][] BUTTONS = new State[4][4];
    // ========================================================================
    public Vaue_Dr () {
        super();
        this.searchable = false;
        this.description = "Standing before you is an interesting wall resembling\n"
                         + "a sliding door. On it is a 4 by 4 grid of buttons. Drawn\n"
                         + "on each is a dark circular rune";
        this.actDialog = null;
        this.searchDialog = "The only curiosity is the grid of buttons on the front.";
        
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                BUTTONS[i][j] = State.OFF;
        
        this.addNameKeys("buttons?", "(?:sliding )?door", "(?:interesting |curious )?wall");
        this.addActKeys("push", "activate", "solve", "open");
    }
    // ========================================================================   
    @Override public String interact(String key) {            
        String ans;
        
        do {
            GUI.out(this.printButtons());
            GUI.menOut("\n<x, y> Push\n< > Back");
            ans = GUI.promptOut();
            
            while (! ans.matches("(?:[1-4]\\s*,\\s*[1-4])|")) {
                GUI.menOut("\nThat's not a valid choice.\n<#,#> Push\n< > Back");
                ans = GUI.promptOut();
            }
            
            if (! ans.equals("")) {
                String[] crds = ans.split("\\s*,\\s*");
                this.switchButtons(Integer.parseInt(crds[0]) - 1, 
                        4 - Integer.parseInt(crds[1]));
            }
            
            if (solved()) {
                Player.getRoomObj(Id.VAU2).unlock();
                Player.getPos().removeFurniture(this);
                return "As you push the last button, all the runes become lit.\n"
                     + "The wall recedes into the floor slowly.\n"
                     + "As the dust settles, a long room filled with treasure is revealed.";
            }
        } while (! ans.matches(""));
        
        return this.actDialog;
    }
    // ========================================================================      
    private String printButtons() {
        int row = 4;
        String result = "\t\t\t\t\t";
        
        for (State[] i : BUTTONS) {
            result += row;
            
            for (State j : i)
                result = result.concat(j.toString());
            
            result = result.concat("\t\t\t");
            row--;
        }
        
        return result.concat("  1  2  3  4 \t\t\t");
    }
    // ========================================================================      
    private void switchButtons(int x, int y) {
        flip(x, y);
        flip(x + 1, y);
        flip(x - 1, y);
        flip(x, y + 1);
        flip(x, y - 1);
    }
    // ========================================================================  
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
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Button does not exists!");
        }
    }
    // ========================================================================  
    private boolean solved() {
        for (State[] i : this.BUTTONS)
            for (State j : i)
                if (j == State.OFF)
                    return false;
        
        return true;    
    }
    // ========================================================================  
}


