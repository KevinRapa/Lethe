package Laboratory;

import A_Super.Book;
/**
 * @author Kevin Rapa
 */
public class Labo_BrnrBk extends Book {

// CONSTRUCTOR ================================================================
    public Labo_BrnrBk(String name) {
        super(name, 4);

        PAGE_LIST[0] = "\"Playing With Fire, the Safe Way\"";
        
        PAGE_LIST[1] = "The Bunsen burner is perhaps one of the most useful tools\n" +
                       "in the typical chemistry laboratory. The level of danger\n" +
                       "in handling a burner falls somewhere between filling a\n" +
                       "buret with hydroflouric acid from a beaker and putting\n" +
                       "your shoes on. It's a wide range. Thus, we realize the \n" +
                       "unpredictability of the quintessential gas-powered\n" +
                       "bunsen burner. However, the knowledge of correct burner\n" +
                       "usage is imperative for alchemical experiments, and this\n" +
                       "book will supply that knowledge.";
        
        PAGE_LIST[2] = "You can never light a Bunsen burner without gas to burn.\n" +
                       "Your lab will have a gas supplier somewhere. There will\n" +
                       "be nozzles on both the supplier and the burner. First,\n" +
                       "ensure that your supplier is not leaking gas, for operating\n" +
                       "a striker in a room full of natural gas will surely end in\n" +
                       "consequence. Second, connect the supplier to the burner.\n" +
                       "At this point, ensure that your florence of other boiling\n" +
                       "flask is rested over the burner. Release the gas from the\n" +
                       "supplier so that the burner has access to it. Lastly, hold\n" +
                       "your striker over the burner and give a squeeze or too.\n" +
                       "If the oxygen supply is ample, your flame will burn continuously.";
        
        PAGE_LIST[3] = "If your flame only stays lit shortly, do not worry, for the\n" +
                       "lighting of bunsen burners is a skill achieved through\n" +
                       "experience and safety only. It is up to you to practice. ";
    }
// ============================================================================
}

