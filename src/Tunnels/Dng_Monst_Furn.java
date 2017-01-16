package Tunnels;

import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Dng_Monst_Furn extends Furniture {
    private final String CANT_SEE_IT = "You can't hear or see it from here.";
    // ========================================================================
    public Dng_Monst_Furn () {
        super();
        this.searchable = false;
        
        this.description = "A disfigured corpse-like creature is roaming the tunnels.\n"
                         + "It holds a dangling chain wrapped around itself several times\n"
                         + "and drags its bare feet as it walks crookedly. ";
        this.actDialog = "You wouldn't ever think of going near that thing...";
        this.searchDialog = this.actDialog;

        this.addNameKeys("(?:disfigured )?(?:corpse-like )?(?:creature|monster)");
        this.addActKeys(".{2,}");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        String result;
        
        if (Player.getPosId().matches(Id.CRY1+"|"+Id.CRY2+"|"+Id.DKCH+"|"+Id.TORC)) {
            result = CANT_SEE_IT;
        }
        else if (Player.getPosId().substring(0, 3).matches("ESC")) {
            result = "It's lurking around somewhere above your head... You can't hear it though.";
        }
        else if ((Dungeon_Monst.getPos().matches("CIS\\d") && ! Player.getPosId().matches("CIS\\d|OUB1|AARC")) ||
                 (Dungeon_Monst.getPos().matches("SEW\\d") && ! Player.getPosId().matches("SEW[0-5P]|PRIS|INTR"))) {
            result = CANT_SEE_IT;
        }
        else {
            switch (Dungeon_Monst.getPos()) {
                case Id.SEW0: case Id.SEW1: case Id.SEW2:
                    result = "It's lurking at the east end of the tunnel.";
                    break;
                case Id.SEW3: case Id.SEW4: case Id.SEW5:
                    result = "It's lurking at the west end of the tunnel.";
                    break;
                case Id.CIS1: case Id.CIS2:
                    result = "It's lurking in the north end of the cistern walkway.";
                    break;
                default:
                    result = "It's lurking in the south end of the cistern walkway.";
            }
        }
        return this.description.concat("\t\t\t\t\t\t\t" + result);
    }
    // ========================================================================   
}


