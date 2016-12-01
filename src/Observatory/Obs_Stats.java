package Observatory;

import Super.Furniture;
import Core.Player;
import Core.GUI;
import Super.Room;
import java.util.Scanner;

public class Obs_Stats extends Furniture {
    private final Furniture[] STATS;
    private final Player REF;
    private final Obs3_Chndlr REF2;
    private boolean solved = false;
    private boolean locked = false;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Obs_Stats(String NAME, Player plyr, Furniture chandlr, Furniture ... stats) {
        super(NAME);
        this.searchable = false;
        this.description = "An array of 9 statues arranged in a circle. In the\n"
                         + "center stands an additional larger statue looking\n"
                         + "upwards.";
        this.searchDialog = "You find nothing of interest except curious seams\n"
                          + "on the floor around them.";
        this.STATS = stats;
        this.REF = plyr;
        this.REF2 = (Obs3_Chndlr) chandlr;
        this.addNameKeys("statues", "statue");
        this.addActKeys("move", "turn", "push", "pull", "rotate", "spin");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = "", choice;
        
        GUI.out(this.description + "\n");
        
        do {
            GUI.out(this.getArray());
            GUI.menOut("<#> Look...\n< > Back");       
            choice = GUI.promptOut();
            
            if (this.REF.getOcc().hasFurniture(choice))
                GUI.out(this.REF.getFurnitureObject(choice).getDescription());
            else if (! choice.matches("")) {
                rep = "That's not a valid choice.";
                choice = "";
            }
            
        } while (! choice.matches(""));
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {
        String choice, action, slot, rep = "";
        int statNum;
        Scanner collectToken;
        
        if (! this.locked && ! this.solved) {
            do {          
                GUI.out(this.getArray());
                GUI.menOut("<'r'#> Rotate statue\n<'m'#> Move statue");

                choice = GUI.promptOut();
                collectToken = new Scanner(choice).useDelimiter("\\s*");

                try  {
                    action = collectToken.next();            
                    slot = collectToken.next();
                    statNum = Integer.parseInt(slot);

                    if (action.matches("r") && (statNum >= 0) && (statNum < 8)) {       
                        this.rotateStat(slot);
                    }            
                    else if (action.matches("m") && (statNum >= 0) && (statNum < 8)) {
                        this.moveStat(slot);
                    }
                    else if ((action.matches("r") || action.matches("m")) && statNum == 8) {
                        this.spinArray();
                    }
                    else
                        GUI.out("That's not a valid choice.");           
                }
                catch (java.util.NoSuchElementException | java.lang.NumberFormatException e) {
                    if (! choice.matches(""))
                        GUI.out("Type an action and a statue number."); 
                } 

                if (this.checkSolved()) {
                    rep ="As the statue settles in place, a bright\n"
                       + "array of light forms on the floor.";
                    this.solved = true;
                    this.REF2.lower();
                    choice = "";
                }
                
            } while (! choice.matches(""));

            collectToken.close();
        }
        else if (this.locked)
            rep = "The statues aren't budging. Something might be locking\n"
                + "them in place";    
        else        
            rep = "Whatever you just did, you best not undo it at this point.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    private String getArray() {
        String a = this.STATS[0].toString();
        String b = this.STATS[1].toString();
        String c = this.STATS[2].toString();
        String d = this.STATS[3].toString();
        String e = this.STATS[4].toString();
        String f = this.STATS[5].toString();
        String g = this.STATS[6].toString();
        String h = this.STATS[7].toString();
        String i = this.STATS[8].toString();
        
        return "\t\t\t\t\t     {"+a+"}¯¯\\" +
               "\t\t        {"+h+"}       {"+b+"}\n" +
               "\t\t        /\t\t            "
             + "{"+g+"}    {"+i+"}    {"+c+"}\n" +
               "\t\t\t    /\t              "
             + "{"+f+"}       {"+d+"}\n" +
               "                  \\ _{"+e+"}";
    }
/*----------------------------------------------------------------------------*/
    private void moveStat(String stat) {
        int i = this.getIndex(stat);
        
        if (i == 0 || i == 2 || i == 4 || i == 6)
            this.moveThese(0, 2, 4, 6);
        else if (i == 1 || i == 3 || i == 5 || i == 7) 
            this.moveThese(1, 3, 5, 7);    
    }
/*----------------------------------------------------------------------------*/
    private void rotateStat(String stat) {
        int i = this.getIndex(stat);

        switch (i) {
            
        case 0: case 1:
            this.switchThese(0, 1); break;
        case 2: case 3:
            this.switchThese(2, 3); break;
        case 4: case 5:
            this.switchThese(4, 5); break;
        case 6: case 7:
            this.switchThese(6, 7); break;
        }
    }
/*----------------------------------------------------------------------------*/
    public int getIndex(String stat) {
        int current = 0, index = 0;
        
        for (Furniture i : this.STATS)
            if (! i.toString().matches(stat))
                current++;
            else 
                index = current;
             
        return index;
    }

/*----------------------------------------------------------------------------*/
    private void switchThese(int first, int second) {
        Furniture temp = this.STATS[first];
        this.STATS[first] = this.STATS[second];
        this.STATS[second] = temp;
    }
/*----------------------------------------------------------------------------*/
    private void moveThese(int first, int second, int third, int fourth) {
        Furniture temp = this.STATS[first];
        this.STATS[first] = this.STATS[fourth];
        this.STATS[fourth] = this.STATS[third];
        this.STATS[third] = this.STATS[second];
        this.STATS[second] = temp; 
    }
/*----------------------------------------------------------------------------*/
    private void spinArray() {
        Furniture temp = this.STATS[0];
        this.STATS[0] = this.STATS[7];

        for (int count = 7; count != 1; count--) {
            this.STATS[count] = this.STATS[count - 1];
        }
        this.STATS[1] = temp; 
    }
/*----------------------------------------------------------------------------*/
    private boolean checkSolved() {
        Furniture[] i = this.STATS;
        boolean isSolved = true;
        String[] correctSequence = {"5", "0", "1", "4", "7", "3", "6", "2"};
        
        for (int index = 0; index < 8; index++) {
            if (! i[index].toString().matches(correctSequence[index]))
                isSolved = false;
        }
        
        return isSolved;
    }
/*----------------------------------------------------------------------------*/
    public void unlock() {
        this.locked = false;
    }
/*----------------------------------------------------------------------------*/
}
