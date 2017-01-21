package Courtyard;

import A_Main.GUI;
import A_Main.NameConstants;
import A_Main.Player;
import java.util.HashMap;
import A_Super.Item;
import A_Super.NonPlayerCharacter;
/**
 * This is an in-game non-player character that plays blackjack with the player.
 * The player may play as many times as her/she wants each encounter, and the
 * player keeps the cards in his/her inventory after no more games are to be played.
 * This NPC is a ghost. The ghost acts as the dealer.
 * 
 * @author Kevin Rapa
 */
public class Cou6_BlackJackGhost extends NonPlayerCharacter {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou6_BlackJackGhost() {
        super();
        this.searchDialog = "The ghost won't appreciate that.";
        this.actDialog = "\"Come back if you want to play again!";
        this.description = "Leaning nonchalantely against the castle wall is a\n"
                         + "ghostly figure shuffling what seem to be cards. The apparition\n"
                         + "is garbed in distinctive clothing- a vest and a full-brimmed hat.";
        this.addActKeys("play", "chat");
        this.addNameKeys("ghost", "apparition", "spirit", "ghostly apparition");
    }
/*----------------------------------------------------------------------------*/
    /**
     * Initiates dialog with the ghost player. 
     * The ghost talks to you, then asks you if you would like to play blackjack.
     * @param key The action the player typed to interact with this.
     * @return End dialog with the ghost.
     */
    @Override public String interact(String key) {
        String rep = this.actDialog;
        
        if (this.firstTime) {
            if(this.converse1())
                rep = rep.concat(" Hey why don't you keep those cards? I can make more! Hah!");
            this.firstTime = false;
        }
        else if (this.converse2())
            rep = rep.concat(" Hey why don't you keep those cards? I can make more! Hah!");

        return rep;
    }
/*----------------------------------------------------------------------------*/
    /**
     * Starts dialog with the ghost.
     * Returns true or false, if the player has played the ghost at least once.
     */
    @Override protected Boolean converse1() {
        GUI.menOut("\n\n<enter> Continue...");
        GUI.out("You approach the apparition loitering in the courtyard. Before\n"
              + "you can accost it, its mouth opens to speak...");
        GUI.promptOut();
        
        GUI.out("The ghost speaks in a heavy Australian accent. \"Finally!\n"
              + "Another soul to play. It has been a while since I've\n"
              + "seen anyone to play cards with. Would you like to play? It's\n"
              + "called blackjack...\"");
        GUI.promptOut();
        
        GUI.out("\"... well not at all! ... Does it look like I need money in\n"
              + "my state? Come on stranger, yes or no....\"");
        GUI.menOut("<'yes'>\n<'no'>");
        
        return this.askToPlay();
    }
/*----------------------------------------------------------------------------*/
    /**
     * Starts dialog with the ghost after he has be talked to a second time.
     * Returns true or false, if the player has played the ghost at least once.
     */
    @Override protected Boolean converse2() {
        GUI.out("Back to play?");
        return this.askToPlay();
    }
/*----------------------------------------------------------------------------*/
    /**
     * Asks the player if he/she would like to play a game of blackjack.
     * After each game, if the player wants to play again, the cards are
     * cleared from the player's inventory. If not, the player keeps the cards.
     */
    private boolean askToPlay() {
        String ans;
        boolean played = false; // If the player has played at least once.
        
        do {
            ans = GUI.askChoice("\nPlay?\n<'y'/'n'>", "yes|no|[yn]|");
            
            if (ans.matches("y|yes")) {
                played = true;
                Player.getInv().remove(NameConstants.CARD); // Removes all cards from player inventory.
                GUI.clearDialog();
                this.playCards(); // Starts the game. 
            }
            Player.printInv();
            
        } while (! ans.matches("n|no"));
        
        GUI.clearDialog();
        
        return played;
    }
/*----------------------------------------------------------------------------*/ 
    /**
     * The main algorithm for the blackjack game.
     * Game outcomes are mapped to by integers which display after each game.
     * The first integer is 1 if the outcome happens immediately or 2 otherwise.
     * The second represents the ghost (1), player (2), or both (3).
     * The third represents the reason- bust (1), blackjack (2), or score (3).
     * 
     * A new deck is made for each game. The NPC is a ghost, and thus uses ghost
     * cards, so more are made by the ghost. The benefit of this is that the
     * player may keep the cards and use them for something later, perhaps.
     * 
     * If a player busts, the game also prints how many points that player is over.
     * Whatever the ghost draws is printed in the console (For testing).
     */
    private void playCards() {
        // Maps outcomes to dialogs.
        HashMap<Integer, String> results = new HashMap();
        results.put(122, "How lucky. You got a blackjack already! ... Want to play again?");
        results.put(112, "Hah! I have blackjack already. I win... Want to play again?");
        results.put(132, "We both got blackjack... So a tie, how boring... Want to play again?");
        results.put(211, "Agh... % too far over. I lose... Want to play again?");
        results.put(233, "Hm... a tie. How boring... Want to play again?");
        results.put(223, "You won. Good luck, mate, you need it tonight... Want to play again?");
        results.put(213, "Looks like I won, mate, fair and square... Want to play again?");
        results.put(221, "Looks like you busted! % too many! ... Want to play again?");
        
        int ghostVal = 0, yourVal = 0; // The scores.
        Deck deck = new Deck();
        deck.shuffle();

        // Deals the initial two cards to the dealer.
        Card card1 = deck.draw();
        GUI.out("The ghost reveals:\t\t" + card1);
        ghostVal += this.evalHit(card1.getVal(), ghostVal); 
        ghostVal += this.evalHit(deck.draw().getVal(), ghostVal);
        
        // Deals the initial two cards to the player.
        Card plyrCard1 = deck.draw();
        Card plyrCard2 = deck.draw();
        Player.getInv().add(plyrCard1);
        Player.getInv().add(plyrCard2);
        yourVal += this.evalHit(plyrCard1.getVal(), yourVal); 
        yourVal += this.evalHit(plyrCard2.getVal(), yourVal);
        Player.printInv();
        
        System.out.println("\nGhost's starting score: " + ghostVal);
        
        // Checks for immediate blackjacks.
        if (this.blackJack(ghostVal) || this.blackJack(yourVal)) {
            int v = this.blackJack(yourVal) && this.blackJack(ghostVal) ? 132 :
                    this.blackJack(yourVal) ? 122 : 112;
            
            GUI.out(results.get(v));
            return;
        }

        yourVal = this.playerTurn(yourVal, deck); // You take your turn.
        
        // Evaluates if you have busted.
        if (this.bust(yourVal)) {
            GUI.out(results.get(221).replaceFirst("%", String.valueOf(yourVal - 21)));
            return;
        }
        
        ghostVal = this.ghostTurn(ghostVal, deck); // Ghost takes turn.
        
        // Evaluates if the dealer has busted.
        if (this.bust(ghostVal)) {
            GUI.out(results.get(211).replaceFirst("%", String.valueOf(ghostVal - 21)));
            return;
        }
        
        // Compares the players' scores of nothing special happened.
        int val = (yourVal == ghostVal) ? 233 : 
                  ((ghostVal > yourVal) ? 213 : 223);
        
        GUI.out(results.get(val));
    }
/*----------------------------------------------------------------------------*/ 
    /**
     * This method lets you hit as many times as you want, or stand.
     * If you bust, your turn is over and the loop ends.
     * @param score The player's current score.
     * @param deck A reference to the Deck object.
     * @return The player's new current score.
     */
    private int playerTurn(int score, Deck deck) {
        String ans;
        
        do {
            GUI.menOut("Your total is " + score + ".\n" +
                       "Would you like to hit or stand?\n"
                     + "<'hit'>\n<'stand'>");
            ans = GUI.promptOut();
            
            if (ans.equals("hit")) {
                Card current = deck.draw();
                Player.getInv().add((Item) current);
                Player.printInv();
                score += this.evalHit(current.getVal(), score);
                
                if (this.bust(score))
                    ans = "stand";
            }
            
        } while (! ans.matches("s(tand|tay)"));
        
        return score;
    }
/*----------------------------------------------------------------------------*/ 
    /**
     * The ghost hits as many times as possible until busting or over 17.
     * @param ghostScore The ghost's current score.
     * @param deck A reference to the Deck object.
     * @return The ghost's new score.
     */
    private int ghostTurn(int ghostScore, Deck deck) {
        while (ghostScore < 17) {
            Card card = deck.draw();
            ghostScore += this.evalHit(card.getVal(), ghostScore);
            System.out.println("Ghost draws a " + card + "\nGhost new score: " + ghostScore); //FOR TESTING
        }
        return ghostScore;
    }
/*----------------------------------------------------------------------------*/     
    /**
     * Evaluates a hit action by calculating the new score.
     * @param card A Card object.
     * @param score a current score.
     * @return The new score for the player who hit.
     */
    private int evalHit(int val, int score) {
        if (val == 1)
            return (score + 11 <= 21) ? 11 : 1;
        else
            return val;
    }
/*----------------------------------------------------------------------------*/ 
    /**
     * Checks if a bust has occurred.
     * @param score A current score.
     * @return If the score is over 21.
     */
    private boolean bust(int score) {
        return score > 21;
    }
/*----------------------------------------------------------------------------*/ 
    /**
     * Checks if a blackjack has occurred.
     * @param score A current score.
     * @return If the score equals 21.
     */
    private boolean blackJack(int score) {
        return score == 21;
    }
/*----------------------------------------------------------------------------*/  
}