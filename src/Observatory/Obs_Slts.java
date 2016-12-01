package Observatory;

import Super.Furniture;
import java.util.Scanner;
import Core.GUI;
import Core.Player;
import Super.Item;

public class Obs_Slts extends Furniture {
    private final Furniture[] SLOTS;
    private final Obs_Stats REF2;
    private final Player REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Obs_Slts(String NAME, Player plyr, Item hlsPlt, Furniture stats, Furniture ... slots) {
        super(NAME);
        this.description = "An array of 9 slots.";
        this.searchDialog = "You inspect the array of slots.";
        this.SLOTS = slots;
        this.REF = plyr;
        this.REF2 = (Obs_Stats)stats;
        this.inv = new Slt_Inv(this);
        this.inv.add(hlsPlt);
        this.addNameKeys("slot", "slots");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = "", choice;
        
        do {
            GUI.out(this.getArray() + "\t\t\t\t\t\t" + this.description + 
                    "\t\tLook at which slot? "); 
            GUI.menOut("<'A-I'> Look...\n< > Back");
            choice = GUI.promptOut();
           
            if (this.REF.getOcc().hasFurniture(choice))
                GUI.descOut(this.REF.getFurnitureObject(choice).getDescription());

        } while (! choice.matches(""));
        
        GUI.descOut(this.REF.getOcc().getDescription());
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    private String getArray() {
        
        String a = this.SLOTS[1].toString();
        String b = this.SLOTS[2].toString();
        String c = this.SLOTS[3].toString();
        String d = this.SLOTS[4].toString();
        String e = this.SLOTS[5].toString();
        String f = this.SLOTS[6].toString();
        String g = this.SLOTS[7].toString();
        String h = this.SLOTS[8].toString();
        String i = this.SLOTS[0].toString();
        
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
    public void checkSolved() {
        boolean isSolved = true;
        String correct, plateName;
        Obs_Slt slot;
        Scanner getName;
        int index = 0;
        
        if (this.inv.getInv().size() == 9) 
            for (Item i : this.inv.getInv()) {
                getName = new Scanner(i.toString());
                plateName = getName.findInLine("(?<=\")\\w[a-z]+\\w(?=\")"); // Matches a word inside quotes. Omits the quotes.

                slot = (Obs_Slt)this.SLOTS[index];
                correct = slot.getCorrect();

                if (! plateName.matches(correct)) {
                    isSolved = false;
                }
                index ++;
                getName.close();
            }
        else
            isSolved = false;       

        if (isSolved) {
            GUI.out("As you press the last plate in the slot, a luminescence\n"
                     + "from an unknown source begins seeping through the seams\n"
                     + "in the floor. Something has been activated.");
            this.REF2.unlock(); 
        }

    }
/*----------------------------------------------------------------------------*/
    public Furniture[] getSlots() {
        return this.SLOTS;
    }
/*----------------------------------------------------------------------------*/
}
