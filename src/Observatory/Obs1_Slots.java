package Observatory;

import A_Main.AudioPlayer;
import A_Super.Furniture;
import java.util.ArrayList;
import java.util.HashMap;
import A_Main.GUI;
import A_Main.Menus;
import static A_Main.Names.PLATE;
import A_Main.Player;
import A_Super.Item;
import static A_Main.Patterns.OBS_SLOTS_A_TO_I;
/**
 * Before being able to move the statues in the observatory, the player
 * must find 8 brass plates and fit them in their correct spots.
 * 
 * @see Observatory.Obs1_Statues
 * @see Back_Hall.Bha2_Frame
 * @author Kevin Rapa
 */
public class Obs1_Slots extends Furniture {
    private final ArrayList<Obs1_Slot> SLOTS = new ArrayList<>();
    private final HashMap<Character, Integer> MAP = new HashMap<>();
    private final Obs1_Statues STATS_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Obs1_Slots(Item hlsPlt, Furniture stats) {
        super();

        SLOTS.add(new Obs1_Slot("I", "Sol",       "Inside the slot: \"Helios\""));
        SLOTS.add(new Obs1_Slot("A", "Mercury",   "Inside the slot: \"Hermes\""));
        SLOTS.add(new Obs1_Slot("B", "Venus",     "Inside the slot: \"Aphrodite\""));
        SLOTS.add(new Obs1_Slot("C", "Terra",     "Inside the slot: \"Gaea\""));
        SLOTS.add(new Obs1_Slot("D", "Mars",      "Inside the slot: \"Ares\""));
        SLOTS.add(new Obs1_Slot("E", "Jupiter",   "Inside the slot: \"Zeus\""));
        SLOTS.add(new Obs1_Slot("F", "Saturn",    "Inside the slot: \"Kronos\""));
        SLOTS.add(new Obs1_Slot("G", "Caelus",    "Inside the slot: \"Uranus\""));
        SLOTS.add(new Obs1_Slot("H", "Neptune",   "Inside the slot: \"Posiedon\""));
        
        MAP.put('i', 0); MAP.put('a', 1); MAP.put('b', 2); MAP.put('c', 3); 
        MAP.put('e', 5); MAP.put('f', 6); MAP.put('g', 7); MAP.put('h', 8); 
        MAP.put('d', 4); 
        
        this.SLOTS.get(0).getInv().contents().add(hlsPlt);
        
        this.description = "It's an array of brass indentations on the floor."
                         + "Each one bears an inscription.";
        this.searchDialog = "You inspect the array of slots.";
        this.useDialog = "There are eight slots here. Perhaps you should search among "
                 + "them the one in which to place that.";
        this.STATS_REF = (Obs1_Statues)stats;
        
        this.addUseKeys(ANYTHING);
        this.addNameKeys("(?:brass )?(?:slots?|indentations?)");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (item.getType().equals(PLATE))
            return this.useDialog;
        else
            return "That doesn't belong there.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String choice;
        
        do {
            GUI.out(this.getArray() + "\t\t\t\t\t\t" + this.description); 

            choice = GUI.askChoice(Menus.OBS_SLOT_EX, OBS_SLOTS_A_TO_I);
           
            if (Player.isNonEmptyString(choice))
                GUI.descOut(SLOTS.get(MAP.get(choice.charAt(0))).getDescription());

        } while (Player.isNonEmptyString(choice));
        
        GUI.descOut(Player.getPos().getDescription());
        
        return NOTHING;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        String rep = "", choice;
        
        do {
            GUI.out(this.getArray() + "\t\t\t\t\t\t" + this.description); 

            choice = GUI.askChoice(Menus.OBS_SLOT_SE, OBS_SLOTS_A_TO_I);
           
            if (Player.isNonEmptyString(choice)) {
                Furniture slot = SLOTS.get(MAP.get(choice.charAt(0)));
                Player.trySearch(slot);
                
                if (checkSolved() && ! areSlotsLocked()) {
                    rep = "A luminescence from an unknown source begins seeping through the seams "
                        + "in the floor and under each statue. You hear a click. Something has been activated.";
                    lockSlots();
                    choice = NOTHING;
                }
                else if (areSlotsLocked()) {
                    rep = "The " + slot + " has locked itself in place.";
                    choice = NOTHING;
                }
            }
            Player.printInv();

        } while (Player.isNonEmptyString(choice));
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    private String getArray() {
        
        String a = SLOTS.get(1).toString();
        String b = SLOTS.get(2).toString();
        String c = SLOTS.get(3).toString();
        String d = SLOTS.get(4).toString();
        String e = SLOTS.get(5).toString();
        String f = SLOTS.get(6).toString();
        String g = SLOTS.get(7).toString();
        String h = SLOTS.get(8).toString();
        String i = SLOTS.get(0).toString();
        
        return "\t\t\t\t\t     {"+a+"}   " +
               "\t\t        {"+h+"}       {"+b+"} " +
               "\t\t         \t\t           "
             + "{"+g+"}    {"+i+"}    {"+c+"} " +
               "\t\t\t     \t             "
             + "{"+f+"}       {"+d+"} " +
               "                    {"+e+"}";
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
        
        for (Obs1_Slot s : this.SLOTS) 
            if (! s.isCorrect())
                isSolved = false;  
        
        if (isSolved)
            this.STATS_REF.unlock(); 
        
        return isSolved;
    }
/*----------------------------------------------------------------------------*/
    private void lockSlots() {
        AudioPlayer.playEffect(43);
        
        SLOTS.stream().forEach((s) -> {
            s.lock();
        });
    }
/*----------------------------------------------------------------------------*/
    private boolean areSlotsLocked() {
        return (! this.SLOTS.get(0).isSearchable());
    }
/*----------------------------------------------------------------------------*/
}
