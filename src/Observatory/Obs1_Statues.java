package Observatory;

import A_Main.AudioPlayer;
import A_Super.Furniture;
import A_Main.GUI;
import A_Main.Player;
import java.util.Scanner;
/** 
 * The observatory statue puzzle. 
 * Player must first find 8 brass plates around the castle and fit them into
 * their respective indentation. On each plate reads a Greek diety, and its
 * respective latinized equivalent is spelled in an indentation.
 * 
 * Then, player must manipulate statue positions until each statue is in
 * front of its name. A book on the second floor observatory describes each diety.
 * 
 * SOLUTION
 *     5
 *  2     0
 * 6       1
 *  3     4
 *     7
 * 
 * @see Observatory.Obs1_Slots
 * @see Observatory.Obs2_Bk
 * @author Kevin Rapa
 */
public class Obs1_Statues extends Furniture {
    private final Furniture[] STATS = {
        new Obs1_Statue("0", "A beautiful woman stands on this base. She stands with long hair and no clothing on a large sea-shell.", 3),
        new Obs1_Statue("1", "The statue depicts a pregnant short-haired female figure holding a newborn.", 2),
        new Obs1_Statue("2", "On this statue stands a towering older male figure. He wears a glorious beard and poses triumphantly holding a trident.", 1),
        new Obs1_Statue("3", "This statue shows a glorious sitting bearded male. He is well-built and dressed in a heavy robe. He holds a scythe.", 4),
        new Obs1_Statue("4", "It shows a tall male figure dressed in soldier's garb. He wears a tall galea helmet and holds a spear and shield.", 5),
        new Obs1_Statue("5", "On its base stands a male figure of average build. He wears sandals, a heavy cloak, and a winged helmet.", 6),
        new Obs1_Statue("6", "A male wearing light armor stands on this base. He holds a staff in his left hand.", 7),
        new Obs1_Statue("7", "This statue depicts a glorious bearded male striding forward holding a lightning bolt. You cannot contain your tears.", 8),
        new Obs1_Statue("8", "The statue displays a monumental male figure crowned with a radiating halo. He rides in a chariot pulled by four steeds.", 0),
    };
    private final Obs3_Chandelier CHNDLR_REF;
    private boolean solved = false, locked = true;
    private final String[] SOLUTION = {"5", "0", "1", "4", "7", "3", "6", "2"};
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Obs1_Statues(Furniture chandlr) {
        super();

        this.description = "An array of 9 statues arranged in a circle. In the\n"
                         + "center stands an additional larger statue looking\n"
                         + "upwards.";
        this.searchDialog = "They don't seem to be hiding anything unusual.\n"
                          + "An inspection of the floor around them reveals\n"
                          + "fine seams in the floor connecting them in various\n"
                          + "ways.";
        this.CHNDLR_REF = (Obs3_Chandelier) chandlr;
        this.addNameKeys("statue", "statues", "ring(?: of statues)?", "gods?", "goddess(?:es)?");
        this.addActKeys("move", "turn", "push", "pull", "rotate", "spin");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = NOTHING, choice;
        
        GUI.out(this.description + "\n");
        
        do {
            GUI.out(this.getArray() + "\t\t\t\t\t\t" + rep);    
            choice = GUI.askChoice("<#> Look...\n< > Back", "[0-8]|");
            
            if (choice.matches("[0-8]"))
                rep = getStatRef(choice).getDescription();
            
        } while (Player.isNonEmptyString(choice));
        
        return null;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        String choice, action, slot, rep = NOTHING;
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
                    if (Player.isNonEmptyString(choice))
                        GUI.out("Type an action and a statue number."); 
                } 

                if (this.checkSolved()) {
                    rep ="As the statue settles in place, a bright\n"
                       + "array of light forms on the floor. The chandelier\n"
                       + "high up at the third level descends.";
                    this.solved = true;
                    this.CHNDLR_REF.lower();
                    choice = NOTHING;
                }
            } while (Player.isNonEmptyString(choice));

            collectToken.close();
        }
        else if (this.locked) {
            AudioPlayer.playEffect(6);
            rep = "The statues aren't budging. Something might be locking\n"
                + "them in place";  
        }
        else {       
            AudioPlayer.playEffect(6);
            rep = "The statues have locked in place once again.";
        }
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    private String getArray() {
        String a = STATS[0].toString();
        String b = STATS[1].toString();
        String c = STATS[2].toString();
        String d = STATS[3].toString();
        String e = STATS[4].toString();
        String f = STATS[5].toString();
        String g = STATS[6].toString();
        String h = STATS[7].toString();
        String i = STATS[8].toString();
        
        return "\t\t\t\t\t     {"+a+"}¯¯\\" +
               "\t\t        {"+h+"}       {"+b+"}\n" +
               "\t\t        /\t\t           "
             + "{"+g+"}    {"+i+"}    {"+c+"}\n" +
               "\t\t\t    /\t             "
             + "{"+f+"}       {"+d+"}\n" +
               "                 \\__{"+e+"}";
    }
/*----------------------------------------------------------------------------*/
    private void moveStat(String stat) {
        AudioPlayer.playEffect(44);
        int i = this.getIndex(stat);
        
        if (i == 0 || i == 2 || i == 4 || i == 6)
            this.moveThese(0, 2, 4, 6);
        else if (i == 1 || i == 3 || i == 5 || i == 7) 
            this.moveThese(1, 3, 5, 7);    
    }
/*----------------------------------------------------------------------------*/
    private void rotateStat(String stat) {
        AudioPlayer.playEffect(44);
        switch (getIndex(stat)) {
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
        int current = 0;

        for (Furniture i : this.STATS)
            if (! i.toString().matches(stat))
                current++;
            else 
                return current;
             
        return -1;
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
        AudioPlayer.playEffect(44);
        Furniture temp = this.STATS[0];
        this.STATS[0] = this.STATS[7];

        for (int count = 7; count != 1; count--) {
            this.STATS[count] = this.STATS[count - 1];
        }
        this.STATS[1] = temp; 
    }
/*----------------------------------------------------------------------------*/
    private boolean checkSolved() {
        for (int index = 0; index < 8; index++) {
            if (! STATS[index].toString().matches(SOLUTION[index]))
                return false;
        }
        
        return true;
    }
/*----------------------------------------------------------------------------*/
    public void unlock() {
        this.locked = false;
    }
/*----------------------------------------------------------------------------*/
    private Furniture getStatRef(String name) {
        for (Furniture s : this.STATS)
            if (s.toString().matches(name))
                return s;
        
        return null;
    }
/*----------------------------------------------------------------------------*/
}
