package Laboratory;

import A_Super.Book;
/**
 * @author Kevin Rapa
 */
public class Labo_BurnerManual extends Book {

// CONSTRUCTOR ================================================================
    public Labo_BurnerManual(String name) {
        super(name, 4);

        PAGE_LIST[0] = "\"Playing With Fire, the Safe Way\"";
        
        PAGE_LIST[1] = "The Bunsen burner is perhaps one of the most useful tools " +
                       "in the typical chemistry laboratory. The level of danger " +
                       "in handling a burner falls somewhere between filling a " +
                       "buret with hydroflouric acid from a beaker and putting " +
                       "your shoes on. It's a wide range. Thus, we realize the " +
                       "unpredictability of the quintessential gas-powered " +
                       "bunsen burner. However, the knowledge of correct burner " +
                       "usage is imperative for alchemical experiments, and this " +
                       "book will supply that knowledge.";
        
        PAGE_LIST[2] = "You can never light a Bunsen burner without gas to burn. " +
                       "Your lab will have a gas supplier somewhere. There will " +
                       "be nozzles on both the supplier and the burner. First, " +
                       "ensure that your supplier is not leaking gas, for operating " +
                       "a striker in a room full of natural gas will surely end in " +
                       "consequence. Second, connect the supplier to the burner. " +
                       "At this point, ensure that your boiling " +
                       "flask is rested over the burner. Release the gas from the " +
                       "supplier so that the burner has access to it. Lastly, hold " +
                       "your striker over the burner and give a squeeze or two. " +
                       "If the oxygen supply is ample, your flame will burn continuously.";
        
        PAGE_LIST[3] = "If your flame only stays lit shortly, do not worry, for the " +
                       "lighting of bunsen burners is a skill achieved through " +
                       "experience and safety only. It is up to you to practice.";
    }
// ============================================================================
}

