package Laboratory;

import A_Super.Book;
/**
 * @author Kevin Rapa
 */
public class Labo_GlasswareBook extends Book {
// CONSTRUCTOR ================================================================
    public Labo_GlasswareBook(String name) {
        super(name, 7);

        PAGE_LIST[0] = "\"You Aren't Chemist,\" by Lasi Lasinen";
        
        PAGE_LIST[1] = "Perhaps you've read my other book, \"The Master Glasser\". " +
                        "If you have, you may not know glass has as much function " +
                        "as it does art! Think you that we blow whichever shape " +
                        "we feel that day when we glass? \"Oh, I'm feeling like a " +
                        "triangle today, I will blow glass into triangle! Who cares?\" " +
                        "I will tell you- everybody does. You aren't chemist if you " +
                        "transfer liquids with beaker. You aren't chemist if you " +
                        "boil liquid in erlenmeyer flask. You are a casual chef... " +
                        "Ei, but a common kitchen peasant if you boil chemical " +
                        "in whatever container you feel like. It's important to know " +
                        "chemistry glassware well!";
        
        PAGE_LIST[2] = "The most well-know chemistry glass is beaker! The beaker is " +
                        "wide and straight along sides. If accuracy is not important " +
                        "in measuring, pour or condense into beaker. The wide opening " +
                        "at top prevents the missing of liquid! If you pour acid into " +
                        "water, which you should ALWAYS do (never water into acid), pour into beaker.";
        
        PAGE_LIST[3] = "The Erlenmeyer flask the the triangle shape chemistry glass. " +
                        "What is best virtue of Erlenmeyer flask? The triangle shape " +
                        "prevents tipping over! Hold any chemicals you need for later " +
                        "in Erlenmeyer flask. Like beaker, Erlenmeyer flask is  " +
                        "inaccurate for measure. A similar glass is the Buchner flask, " +
                        "which has triangle shape but also a nozzle on side for sucking " +
                        "out air and making VACUUM!";
        
        PAGE_LIST[4] = "The test tube and vial have similar purpose- to transfer liquids " +
                        "between vessels. The vial has added benefit of a cork to prevent " +
                        "spilling, but only use this for storing liquid, not transferring.";
        
        PAGE_LIST[5] = "The florence flask, oho, now this you may not know! The florence flask " +
                        "has bulbous base for uniform heat's distribution. Great for " +
                        "distillation! Use with rack, and never store liquids in here! The " +
                        "florence flask's shape will allow it to tip easily.";
        
        PAGE_LIST[6] = "The buret (or burette) is special kind of glass! Suppose you want " +
                        "of ACCURATE measurement, or perhaps you are using phenolphthalein to " +
                        "neutralize acid. A buret is used in titration to add a known quantity " +
                        "of liquid to a vessel. Make sure to measure both before and after you " +
                        "titrate, or else you will have no idea how much liquid you dispensed from " +
                        "buret! The device to toggle liquid flow is called as stopcock.";
    }
//-----------------------------------------------------------------------------
}

