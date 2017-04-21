package A_Super;

import A_Main.Names;
/**
 * Something with which the player may type 'drink' [this name] at the main prompt.
 * @author Kevin Rapa
 */
public class Liquid extends Item {
    //-------------------------------------------------------------------------
    public Liquid(String name, String desc, int score) {
        super(name, desc, score);
        this.type = Names.LIQUID;
    }
    //-------------------------------------------------------------------------
    public Liquid(String name, String desc, String use, int score) {
        super(name, desc, use, score);
        this.type = Names.LIQUID;
    }
    //-------------------------------------------------------------------------
    public Liquid(String name, String desc, Item forms, int threshold, int score) {
        super(name, desc, forms, threshold, score);
        this.type = Names.LIQUID;
    }
    //-------------------------------------------------------------------------
}
