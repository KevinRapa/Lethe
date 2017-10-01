package Lichs_Quarters;

import A_Super.Room;
/**
 * Whether or not the lich is alive affects the dialog in these rooms.
 * @author Kevin Rapa
 */
public class Lich_Room extends Room {
    protected boolean lichDead;
//-----------------------------------------------------------------------------    
    public Lich_Room(String name, String ID) {
        super(name, ID);
        this.lichDead = false;
    }
//-----------------------------------------------------------------------------
    public void killLich() {
        this.lichDead = true;
    }
//-----------------------------------------------------------------------------
    public boolean lichIsDead() {
        return lichDead;
    }
//-----------------------------------------------------------------------------
}