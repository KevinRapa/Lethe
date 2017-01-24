package Drawing_Room;

import A_Main.AudioPlayer;
import A_Super.NonPlayerCharacter;
import A_Super.Item;
import A_Super.Key;
import A_Main.GUI;
import A_Main.Id;
import static A_Main.NameConstants.GLOWING_EMERALD;
import A_Main.Player;
/**
 * NPC which assigns a task to the player in exchange for a couple items.
 * Requests that player find an emerald from the trophy room.
 * Gives key to kitchen as a reward and also a dark focus for the Gallery puzzle.
 * 
 * @see Gallery.LghtMchn
 * @see Trophy_Room.Gal5_Dsply
 * @see Kitchen.Kitc
 * @author Kevin Rapa
 */
public class Drar_Ghost extends NonPlayerCharacter {
    private final Item DRKFCS_REF, EMRLD_REF;
    private final Key KITCKEY_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Drar_Ghost(Item drkFcs, Key kitcKey, Item glwEm) {
        super();
        this.DRKFCS_REF = drkFcs;
        this.KITCKEY_REF = kitcKey;
        this.EMRLD_REF = glwEm;
        this.searchDialog = "The ghost won't appreciate that.";
        this.actDialog = "The apparition returns to sipping from the ghostly cup.";
        this.description = "The white apparition resembles a male dressed in\n"
                         + "robes wearing the hat of a scolar. His face is\n"
                         + "disfigured and horribly wrinkly.";
        this.addNameKeys("ghost", "apparition", "white apparition");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.matches(ATTACK_PATTERN))
            return ATTACK_DIALOG;
        
        else if (this.firstTime) {
            this.converse1();
            this.firstTime = false;
        }
        else if (! Player.hasItem(GLOWING_EMERALD)) {
            this.converse2();
        }
        else {
            this.converse3();       
            return "The apparition fades away into nothing."; 
        }
        return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override protected<Void> Void converse1() {
        
        GUI.out("As you open your mouth to speak, the apparition interrupts\n" +
                "and begins to talk to you....");
        GUI.menOut("\n\nPress enter...");
        GUI.promptOut();
        
        GUI.out("\"You are the first living soul I have seen in 6 centuries.\n" +
                "Well, excluding my brother Eurynomos, though he is not really\n" +
                "alive anymore. Do you know of whom I speak of? What is\n" +
                "your name even?...\"");
        GUI.promptOut();
        
        GUI.out("\"Is that so? Not a name I have heard before.\n" +
                "Certainly never during my time.\"");
        GUI.menOut("\n\nPress enter...");
        GUI.promptOut();
        
        GUI.out("\"My name is Asterion. I used to live here with my two\n"
              + "brothers. We provided great services to this kingdom, if kingdom\n"
              + "is what you still call it. We provided our intellectual services to\n"
              + "its people. So, why on Earth are you here?\"");
        GUI.promptOut();
        
        GUI.out("\"You aren't sure? That doesn't make any sense!\n" +
                "But then again, that does answer some questions now.\n" +
                "I keep wondering how Eurynomos could still be walking\n"
              + "at this point. He is a lich, and has been for too long.\n"
              + "His mind should have melted to a pulp by now. Perhaps\n"
              + "he wished to use your life energy to fuel his.\"");
        GUI.promptOut();
        
        GUI.out("\"But this probably doesn't interest you. You are\n" +
                "concerned with escape. I would like to help you,\n" +
                "but I would also like you to do something for me.\"");
        GUI.promptOut();
        
        GUI.out("I was bound by Eurynomos to an emerald. Our discovery, the\n"
              + "Factum, drove him mad. He killed my brother and I, and possessed\n"
              + "many others in the castle. Many fled, others perished, I stayed.\n"
              + "I wish you to bring me the emerald. I will not leave this place,\n"
              + "but at least them I may be sure my soul is safe with me.\"");
        GUI.promptOut();
        
        GUI.out("\"I know enough to say that the\n" +
                "trophy room is off the second floor gallery.\n" +
                "I have something that is connected to\n" +
                "the unlocking mechanism. Please have it....\"");
        GUI.promptOut();
        
        Player.getInv().add(this.DRKFCS_REF);
        Player.printInv();
        GUI.out("The apparition hands you a dark tinted lens...");
        GUI.promptOut();
        
        GUI.toMainMenu();
        GUI.out("\"Please come back when you have the gem.\"\n");

        return null;
    }
/*----------------------------------------------------------------------------*/
    @Override protected<Void> Void converse2() {
        GUI.out("\"Do you have the emerald yet? It's so\n" +
                "important to me. I will to repay you.\"");
        
        return null;
    }
/*----------------------------------------------------------------------------*/    
    private void converse3() {       
        
        GUI.menOut("\n\nPress enter...");
        GUI.out("\"Oh, you have found it! You have no idea what\n" +
                "this means to me. Oh, well I suppose you do.\n" +
                "As promised, I will help you find a way out\n" +
                "of here....\"");
        Player.getInv().remove(this.EMRLD_REF);
        GUI.promptOut();
        
        GUI.out("\"There is a rack of keys in the kitchen. I'm not sure\n"
              + "there's one that will get you out of here, but it will\n" +
                "open up more doors for you, quite literally. The kitchen\n"
              + "is locked, and I have the key.\"");
        GUI.promptOut();
        
        GUI.out("\"Eurynomos keeps a phylactery of his in the kitchen; a fruit. He split\n"
              + "\"his soul among 5 objects, you know. One other is a scepter he\n"
              + "took from Rhadamanthus. The other three, well I don't rightfully know.\"");
        GUI.promptOut();
        
        GUI.out("The apparition drops a key into your palm...");
        Player.getKeys().add(KITCKEY_REF);
        AudioPlayer.playEffect(3);
        Player.printInv();
        GUI.promptOut();
        
        GUI.out("\"Goodbye, my friend...\"");
        GUI.promptOut();
        GUI.toMainMenu();
        Player.getRoomObj(Id.DRAR).removeFurniture(this);  
        Player.describeRoom();
    }
/*----------------------------------------------------------------------------*/       
}
