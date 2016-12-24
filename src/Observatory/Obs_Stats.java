package Observatory;

import A_Super.Furniture;
import A_Main.GUI;
import java.util.Scanner;
/** SOLUTION
 *     5
 *  2     0
 * 6       1
 *  3     4
 *     7
 * 
 * @author Kevin Rapa
 */
public class Obs_Stats extends Furniture {
    private final Furniture[] STATS = {
        new Obs_Stat("0", "A beautiful woman stands on this base. She\nstands with long hair and no clothing on \na large sea-shell.", 3),
        new Obs_Stat("1", "The statue depicts a short-haired female\nfigure holding a newborn. She also appears \npregnant.", 2),
        new Obs_Stat("2", "This statue shows a towering older male\nfigure. He wears a glorious beard and poses\ntriumphantly holding a trident.", 1),
        new Obs_Stat("3", "This statue shows a glorious bearded male\nsitting. He is well-built and dressed in a\nheavy robe. He holds a scythe.", 4),
        new Obs_Stat("4", "It shows a tall male figure dressed in \nsoldier's garb. He wears a tall galea\nhelmet and holds a spear and shield.", 5),
        new Obs_Stat("5", "On its base stands a male figure of average\nbuild. He wears sandals, a heavy cloak, and\na winged helmet.", 6),
        new Obs_Stat("6", "A male wearing light armor stands on this\nbase. He holds a staff in\nhis left hand.", 7),
        new Obs_Stat("7", "This statue depicts a glorious bearded male\nstriding forward holding a lightning bolt. You\ncannot contain your tears.", 8),
        new Obs_Stat("8", "The statue depicts a monumental male figure\ncrowned with a radiating halo. He rides in\na chariot pulled by four steeds.", 0),
    };
    private final Obs3_Chndlr CHNDLR_REF;
    private boolean solved = false;
    private boolean locked = true;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Obs_Stats(Furniture chandlr) {
        super();
        this.searchable = false;
        this.description = "An array of 9 statues arranged in a circle. In the\n"
                         + "center stands an additional larger statue looking\n"
                         + "upwards.";
        this.searchDialog = "They don't seem to be hiding anything unusual.\n"
                          + "An inspection of the floor around them reveals\n"
                          + "fine seams in the floor connecting them in various\n"
                          + "ways.";
        this.CHNDLR_REF = (Obs3_Chndlr) chandlr;
        this.addNameKeys("statue", "statues", "ring(?: of statues)?", "gods", "god", "goddess", "goddesses");
        this.addActKeys("move", "turn", "push", "pull", "rotate", "spin");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = "", choice;
        
        GUI.out(this.description + "\n");
        
        do {
            GUI.out(this.getArray() + "\t\t\t\t\t\t" + rep);
            GUI.menOut("<#> Look...\n< > Back");       
            choice = GUI.promptOut();
            
            if (choice.matches("[0-8]"))
                rep = getStatRef(choice).getDescription();
            else if (! choice.matches("")) {
                rep = "That's not a valid choice.";
                choice = "";
            }
            
        } while (! choice.matches(""));
        
        return "";
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
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
                       + "array of light forms on the floor. The chandelier\n"
                       + "high up at the third level descends.";
                    this.solved = true;
                    this.CHNDLR_REF.lower();
                    choice = "";
                }
                
            } while (! choice.matches(""));

            collectToken.close();
        }
        else if (this.locked)
            rep = "The statues aren't budging. Something might be locking\n"
                + "them in place";    
        else        
            rep = "The statues have locked in place once again.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    private String getArray() {
        String a = STATS[0].getValidNames().get(0);
        String b = STATS[1].getValidNames().get(0);
        String c = STATS[2].getValidNames().get(0);
        String d = STATS[3].getValidNames().get(0);
        String e = STATS[4].getValidNames().get(0);
        String f = STATS[5].getValidNames().get(0);
        String g = STATS[6].getValidNames().get(0);
        String h = STATS[7].getValidNames().get(0);
        String i = STATS[8].getValidNames().get(0);
        
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
                this.switchThese(6, 7);
        }
    }
/*----------------------------------------------------------------------------*/
    public int getIndex(String stat) {
        int current = 0, index = 0;
        
        for (Furniture i : this.STATS)
            if (! i.getValidNames().get(0).matches(stat))
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
            if (! i[index].getValidNames().get(0).matches(correctSequence[index]))
                isSolved = false;
        }
        
        return isSolved;
    }
/*----------------------------------------------------------------------------*/
    public void unlock() {
        this.locked = false;
    }
/*----------------------------------------------------------------------------*/
    private Furniture getStatRef(String name) {
        for (Furniture s : this.STATS)
            if (s.getValidNames().get(0).matches(name))
                return s;
        
        return null;
    }
/*----------------------------------------------------------------------------*/
}
