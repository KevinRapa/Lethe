package Observatory;

import A_Super.Furniture;
import java.util.ArrayList;
import java.util.HashMap;
import A_Main.GUI;
import A_Main.Player;
import A_Super.Item;

public class Obs_Slts extends Furniture {
    private final ArrayList<Obs_Slt> SLOTS = new ArrayList<>();
    private final HashMap<Character, Integer> MAP = new HashMap<>();
    private final Obs_Stats STATS_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Obs_Slts(Item hlsPlt, Furniture stats) {
        super();
        this.searchable = false;
        
        SLOTS.add(new Obs_Slt("I", "Sol", "Inside the slot: \"Helios\""));
        SLOTS.add(new Obs_Slt("A", "Mercury", "Inside the slot: \"Hermes\""));
        SLOTS.add(new Obs_Slt("B", "Venus", "Inside the slot: \"Aphrodite\""));
        SLOTS.add(new Obs_Slt("C", "Terra", "Inside the slot: \"Gaea\""));
        SLOTS.add(new Obs_Slt("D", "Mars", "Inside the slot: \"Ares\""));
        SLOTS.add(new Obs_Slt("E", "Jupiter", "Inside the slot: \"Zeus\""));
        SLOTS.add(new Obs_Slt("F", "Saturn", "Inside the slot: \"Kronos\""));
        SLOTS.add(new Obs_Slt("G", "Caelus", "Inside the slot: \"Uranus\""));
        SLOTS.add(new Obs_Slt("H", "Neptune", "Inside the slot: \"Posiedon\""));
        
        MAP.put('i', 0); MAP.put('a', 1); MAP.put('b', 2); MAP.put('c', 3); 
        MAP.put('e', 5); MAP.put('f', 6); MAP.put('g', 7); MAP.put('h', 8); 
        MAP.put('d', 4); 
        
        this.SLOTS.get(0).getInv().add(hlsPlt);
        
        this.description = "It's an array of 9 brass indentations in the floor at the\n"
                         + "base of each statue. Each one bears an inscription inside.";
        this.searchDialog = "You inspect the array of slots.";
        this.STATS_REF = (Obs_Stats)stats;
        
        this.addNameKeys("(?:brass )?(?:slots?|indentations?)");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = "", choice;
        
        do {
            GUI.out(this.getArray() + "\t\t\t\t\t\t" + this.description + 
                    "\t\t\t\t\t\t\t\tLook at which slot? "); 
            GUI.menOut("<'A-I'> Look...\n< > Back");
            choice = GUI.promptOut();
           
            if (choice.matches("[abcdefghi]"))
                GUI.descOut(SLOTS.get(MAP.get(choice.charAt(0))).getDescription());

        } while (! choice.matches(""));
        
        GUI.descOut(Player.getOcc().getDescription());
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        String rep = "", choice;
        
        do {
            GUI.out(this.getArray() + "\t\t\t\t\t\t" + this.description + 
                    "\t\t\t\t\t\t\t\tSearch which slot? "); 
            GUI.menOut("<'A-I'> Search...\n< > Back");
            choice = GUI.promptOut();
           
            if (choice.matches("[abcdefghi]")) {
                Furniture slot = SLOTS.get(MAP.get(choice.charAt(0)));
                Player.search(slot);
                
                if (checkSolved() && ! areSlotsLocked()) {
                    rep = "A luminescence from an unknown source begins seeping through the seams\n"
                        + "in the floor and under each statue. You hear a click. Something has been activated.";
                    lockSlots();
                    choice = "";
                }
                else if (areSlotsLocked()) {
                    rep = "The " + slot + " has locked itself in place.";
                    choice = "";
                }
            }
            GUI.invOut("You are carrying:\n" + Player.getInv());

        } while (! choice.matches(""));
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    private String getArray() {
        
        String a = SLOTS.get(1).getValidNames().get(0);
        String b = SLOTS.get(2).getValidNames().get(0);
        String c = SLOTS.get(3).getValidNames().get(0);
        String d = SLOTS.get(4).getValidNames().get(0);
        String e = SLOTS.get(5).getValidNames().get(0);
        String f = SLOTS.get(6).getValidNames().get(0);
        String g = SLOTS.get(7).getValidNames().get(0);
        String h = SLOTS.get(8).getValidNames().get(0);
        String i = SLOTS.get(0).getValidNames().get(0);
        
        return "\t\t\t\t\t     {"+a+"}   " +
               "\t\t        {"+h+"}       {"+b+"}\n" +
               "\t\t         \t\t            "
             + "{"+g+"}    {"+i+"}    {"+c+"}\n" +
               "\t\t\t     \t              "
             + "{"+f+"}       {"+d+"}\n" +
               "                     {"+e+"}";
    }
/*----------------------------------------------------------------------------*/
    public int getIndex(String stat) {
        int current = 0;

        for (Furniture i : this.SLOTS)
            if (! i.toString().matches(stat))
                current++;
            else 
                break;
             
        return current;
    }
/*----------------------------------------------------------------------------*/
    public boolean checkSolved() {
        boolean isSolved = true;
        
        for (Obs_Slt s : this.SLOTS) 
            if (! s.isCorrect())
                isSolved = false;  
        
        if (isSolved)
            this.STATS_REF.unlock(); 
        
        return isSolved;
    }
/*----------------------------------------------------------------------------*/
    private void lockSlots() {
        for (Obs_Slt s : SLOTS)
            s.lock();
    }
/*----------------------------------------------------------------------------*/
    private boolean areSlotsLocked() {
        return (! this.SLOTS.get(0).isSearchable());
    }
/*----------------------------------------------------------------------------*/
}
