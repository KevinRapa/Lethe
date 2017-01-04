package Drawing_Room;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Key;
import A_Main.GUI;
import A_Main.Player;

public class Drar_Ghst extends Furniture {
    private final Item DRKFCS_REF, EMRLD_REF;
    private final Key KITCKEY_REF;
    private boolean firstTime;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Drar_Ghst(Item drkFcs, Key kitcKey, Item glwEm) {
        super();
        this.searchable = false;
        this.DRKFCS_REF = drkFcs;
        this.KITCKEY_REF = kitcKey;
        this.EMRLD_REF = glwEm;
        this.firstTime = true;
        this.searchDialog = "The ghost won't appreciate that.";
        this.actDialog = "The apparition returns to sipping from the ghostly cup.";
        this.description = "The white apparition resembles a female\n" +
                           "dressed in the clothing of a servant. She\n" +
                           "sits at the bar with a ghostly cup in her\n" +
                           "hand looking at you.";
        this.addActKeys("speak", "talk", "converse");
        this.addNameKeys("ghost", "apparition", "white apparition");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        String rep = this.actDialog;
        
        if (this.firstTime) {
            this.converse1();
            this.firstTime = false;
        }
        else if (! Player.hasItem("glowing emerald"))
            this.converse2();
          
        else if (Player.hasItem("glowing emerald")) {
            this.converse3();
            Player.getRoomRef("DRAR").removeFurniture(this);           
            rep = "The apparition fades away into nothing."; 
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
    private void converse1() {
        
        GUI.out("As you open your mouth to speak, the apparition interrupts\n" +
                "and begins to talk to you....");
        GUI.menOut("\n\nPress enter...");
        GUI.promptOut();
        
        GUI.out("\"You are the first living soul I have seen in over 200\n" +
                   "years. Well, excluding Erik, though he is not really\n" +
                   "alive anymore. Do you know of whom I speak of? What is\n" +
                   "your name even?...\"");
        GUI.promptOut();
        
        GUI.out("\"Is that so? Not a name I have heard before.\n" +
                   "Certainly never two centuries ago. If you\n" +
                   "know Erik, than you know to evade him. Though\n" +
                   "I believe he is sleeping now. Still, tread\n" +
                   "quietly....\"");
        GUI.menOut("\n\nPress enter...");
        GUI.promptOut();
        
        GUI.out("\"My name is Agatha. I was once a maid here.\n" +
                   "That role eventually turned to prisoner. I\n" +
                   "almost made it out of here ... but not quite...\n" +
                   "In fact, I don't quite remember my moments before\n" +
                   "death. The last thing I remember was tying a\n" +
                   "rope around my neck and throwing myself off\n" +
                   "the balcony in the west wing. But, I would have\n" +
                   "never done that...\"");
        GUI.promptOut();
        
        GUI.out("\"No, I spend my time roaming the east wing. It's\n" +
                   "nicer here than the west wing...\"");
        GUI.promptOut();
        
        GUI.out("\"Well, yes, the woodwork is nice! But even so,\n" +
                   "why would you spend even a moment here? There\n" +
                   "is no reason to be in this place....\"");
        GUI.promptOut();
        
        GUI.out("\"You aren't sure? That doesn't make any sense!\n" +
                   "But then again, that does justify many mysteries now.\n" +
                   "Erik seems to have some sort of... influence.\n" +
                   "But I would never think so now. He is on a\n" +
                   "steady descent into dementia....\"");
        GUI.promptOut();
        
        GUI.out("\"But this probably doesn't interest you. You are\n" +
                   "concerned with escape. I would like to help you,\n" +
                   "but I would also like you to do something for me;\n" +
                   "something to help me leave....\"");
        GUI.promptOut();
        
        GUI.out("\"I cannot leave without my essence. Erik has\n" +
                   "bound it to an emerald which he keeps in his trophy\n" +
                   "room. I would like you to get it for me. I\n" +
                   "wish I knew how to get inside, so you\n" +
                   "may find more information in Erik's secret\n" +
                   "archives that are hidden in the library somewhere....\"");
        GUI.promptOut();
        
        GUI.out("\"Oh! I'm sorry. I know enough to say that his\n" +
                   "trophy room is off the second floor gallery.\n" +
                   "I have something that I think is connected to\n" +
                   "the unlocking mechanism. Please have it....\"");
        GUI.promptOut();
        
        Player.getInv().add(this.DRKFCS_REF);
        GUI.invOut("You are carrying:\n" + Player.getInv());
        GUI.out("The apparition hands you a dark tinted lens...");
        GUI.promptOut();
        
        GUI.clearMenu();
        GUI.out("\"Please come back when you have the gem.\"\n");

    }
/*----------------------------------------------------------------------------*/
    private void converse2() {
        GUI.out("\"Do you have the emerald yet? Please, it's so\n" +
                "important to me. I promise to repay you.\"");
    }
/*----------------------------------------------------------------------------*/    
    private void converse3() {       
        
        GUI.menOut("\n\nPress enter...");
        GUI.out("\"Oh, you have found it! You have no idea what\n" +
                   "this means to me! Oh, well I suppose you do.\n" +
                   "As promised, I will help you find a way out\n" +
                   "of here....\"");
        Player.getInv().remove(this.EMRLD_REF);
        GUI.promptOut();
        
        GUI.out("\"I used to spend most of my time in the west\n" +
                   "wing with some of the other castle employees,\n" +
                   "Solomon, Francis, and Dolores the cook. If I\n" +
                   "remember correctly, we attempted to break a\n" +
                   "hole in the wall in Solomon's quarters. You\n" +
                   "may be able to finish our work and get out!...\"");
        GUI.promptOut();
        
        GUI.out("\"... You already did that? I would hate to\n" +
                   "think that was in vain. Well, I have\n" +
                   "something else for you. I held a copy of\n" +
                   "the kitchen key along with Dolores. I don't\n" +
                   "think you can escape from there, but I\n" +
                   "remember a rack in there that held many more\n" +
                   "of the castle keys. There may be one to get\n" +
                   "you out. Please have the kitchen key....\"");
        GUI.promptOut();
        
        GUI.out("The apparition drops a key into your palm...");
        Player.getInv().add(KITCKEY_REF);
        GUI.promptOut();
        
        GUI.clearMenu();
        GUI.out("\"Goodbye, my friend.\"\n");
    }
/*----------------------------------------------------------------------------*/    
    public boolean firstTime() {
        return this.firstTime;
    }
/*----------------------------------------------------------------------------*/    
}
