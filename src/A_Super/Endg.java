package A_Super;

import A_Main.GUI;
import A_Main.Id;
import A_Main.Main;
import A_Main.Menus;
import A_Main.Player;

/**
 * @author Kevin Rapa
 */
public class Endg extends Room {
    private final String earlyWinDesc;
// ============================================================================    
    public Endg(String name, String ID) {
        super(name, ID);
        
        this.description = 
            "You step out of the castle's front wall and into the forest. A\n" +
            "ray of sunlight finds the back of your neck, and you feel warmth.\n" +
            "At the same time, scattered light penetrates the forest canopy\n" +
            "and illuminates your path. You continue treading away from\n" +
            "the castle, but not too quickly, for you almost feel as though\n" +
            "you are being accompanied, but you are not afraid.";
        
        this.earlyWinDesc = 
            "By an magnificant unforeseen display of self\n" +
            "control, you turn your back to the ghastly\n" +
            "castle and backtrack along the path you came.\n" +
            "Your family is surely in worry and anxiously\n" +
            "awaits your return. Congratulations! You win\n" +
            "the game!";
    }
// ============================================================================
    @Override public String getDescription() {
        if (Player.getRoomObj(Id.COU4).isLocked())
            return this.earlyWinDesc;
        else
            return this.description;
    }
// ============================================================================
    @Override public String triggeredEvent() {
        GUI.clearDialog();
        GUI.menOut(Menus.ENTER);
        GUI.invOut("");
        int s = Player.getScore();
        GUI.promptOut();
        
        if (s >= 7000)
            GUI.out("You have amassed a grand fortune which will certainly, should you "
                  + "return, grant you any Earthly desire.");
        else if (s >= 5500)
            GUI.out("You have amassed a grand fortune which would earn you the respect "
                  + "of all kings, queens, popes, and the like.");
        else if (s >= 4500)
            GUI.out("Your riches would earn you the respect of all kings.");
        else if (s >= 3500)
            GUI.out("Your taste is luxury is formidible.");
        else if (s >= 2500)
            GUI.out("You're skilled in the hunt for treasure, though "
                  + "you have so much more room to grow.");
        else if (s >= 1500)
            GUI.out("Your riches will earn you the respect of many.");
        else if (s >= 1000)
            GUI.out("Your eye for wealth is strong. You will likely have much "
                  + "to pawn off, should you return.");
        else if (s >= 500)
            GUI.out("You abide by your manly ethics to work hard and provide "
                  + "for your family. Although, the thought of wealth visits you frequently.");
        else if (s >= 250)
            GUI.out("You are rich in character, a true fortune to be respected. "
                  + "Material possession are secondary, of course.");
        else if (s >= 0)
            GUI.out("You have a humble spirit, and long not for possessions. "
                  + "Your only wish, of course, is only to return home.");
        else
            GUI.out("You have eccentric, perplexing tastes. But so long "
                  + "as hope of returning home lingers, you spirit remains strong.");

        GUI.promptOut();
        Main.exitGame();
        return null;
    }
// ============================================================================
}