package A_Super;

import A_Main.*;
import Foyer.LootSack;

/**
 * @author Kevin Rapa
 */
public class Endg extends Room {
    private final String earlyWinDesc;
//-----------------------------------------------------------------------------    
    public Endg(String name, String ID) {
        super(name, ID);

        this.earlyWinDesc = 
            "By an magnificent and unforeseen display of self " +
            "control, you turn your back to the ghastly " +
            "castle and backtrack along the path you came. " +
            "Your family is surely in worry and anxiously " +
            "awaits your return. Congratulations! You win " +
            "the game!";
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (Player.getRoomObj(Id.COU4).isLocked())
            return this.earlyWinDesc;
        else
            return super.getDescription();
    }
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {
        GUI.clearDialog();
        GUI.menOut(Menus.ENTER);
        GUI.invOut("");
        int score = Player.getScore();
        int t = 0;
        int p = Player.getInv().countPhylacteries();
        GUI.promptOut();
        
        if (Player.hasItem(Names.LOOT_SACK)) {
            LootSack sack = (LootSack)Player.getInv().get(Names.LOOT_SACK);
            p += sack.countPhylacteries();
            t += sack.countTreasures();
        }
        
        String message;
        
        if (score >= 19000)
            message = "Your wealth transcends all understanding that "
                    + "exists.";
        else if (score >= 15000)
            message = "You possess the wealth, cunning, and power to overcome "
                    + "any holy or unholy force that dare challenge you.";
        else if (score >= 13000)
            message = "Your wealth is beyond the dreams of avarice and "
                    + "will earn you a divine seat in the afterlife.";
        else if (score >= 11000)
            message = "Your wealth is legendary and would bring a tear to Plutus' eye.";
        else if (score >= 9000)
            message = "Your wealth is nearly insurmountable and would "
                    + "stun any man, woman, and God alike.";
        else if (score >= 7750)
            message = "Your wealth is nearly insurmountable and would "
                    + "stun all men and women alike.";
        else if (score >= 6500)
            message = "You have amassed a grand fortune which will certainly "
                    + "grant you any Earthly desire.";
        else if (score >= 5250)
            message = "You have amassed a grand fortune which instills fear in "
                    + "all kings and queens.";
        else if (score >= 4000)
            message = "Your riches would earn you the respect of many kings.";
        else if (score >= 2750)
            message = "You are a top contender in the hunt for treasure.";
        else if (score >= 1500)
            message = "You're skilled in the hunt for treasure, though "
                    + "you have such a long way to go.";
        else if (score >= 750)
            message = "Your eye for wealth is strong. You will likely have much "
                    + "to pawn off, should you return.";
        else if (score >= 500)
            message = "You abide by your manly ethics to work hard and provide "
                    + "for your family. Although, the thought of wealth visits you frequently.";
        else if (score >= 250)
            message = "You are rich in character, a true fortune to be respected. "
                    + "Material possessions are secondary, of course.";
        else if (score >= 0)
            message = "You have a humble spirit, and long not for possessions.";
        else
            message = "You have eccentric, perplexing tastes.";
        
        if (p > 0)
            message += " Watch yourself, for you hold the soul of a powerful mage, "
                    + "and it may warp you the same way it did him.";
        
        GUI.out("Your score is " + score + ". You have discovered " + t + 
                " out of 15 legendary treasures and " + p + 
                " out of 5 phylacteries. " + message);
        
        GUI.out(message);
        GUI.promptOut();

        // Exits the game after player types enter.
        Main.eraseGame();
        Main.endGameProcedure();
        System.exit(0);
        
        return "";
    }
//-----------------------------------------------------------------------------
}