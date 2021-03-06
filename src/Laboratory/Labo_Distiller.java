package Laboratory;

import A_Main.AudioPlayer;
import A_Main.Player;
import static A_Main.Names.*;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Moveable;
/**
 * @see Laboratory.Labo for solution
 * @author Kevin Rapa
 */
public class Labo_Distiller extends Furniture implements Moveable {
    private final int PIPE_ID;
    private final Item TUBE_REF, VIAL_REF;
    private final Furniture HOSE_REF;
    private final Labo_Flask FLORENCE_FLASK_REF;
    //-------------------------------------------------------------------------
    public Labo_Distiller (Furniture pipe, Furniture cndnsr, Item tstTube, Item vial) {
        super();

        this.PIPE_ID = pipe.getID();
        this.TUBE_REF = tstTube;
        this.VIAL_REF = vial;
        this.FLORENCE_FLASK_REF = new Labo_Flask(cndnsr.getID(), TUBE_REF, VIAL_REF);
        this.HOSE_REF = new Labo_Hose();

        this.actDialog = "There doesn't seem to be much to work on with your hands. You "
                       + "will need some tools to interact with this.";
        this.searchDialog = "The contraption is comprised of many alchemical components. "
                          + "Though they're alien to you, you note nothing out of the ordinary.";
        this.description = "It's one half of a larger alchemical contraption in the room. "
                         + "On the table is a metal flask rack and a bunsen burner "
                         + "under it. Above the setup is a curved glass tube connecting it "
                         + "to the condenser on the other side of the table.";

        this.addActKeys("use|distill|boil", "strike", "light");
        this.addNameKeys("distillery?", "(?:bunsen )?burner", "(?:flask )?rack", "distillation tube");
        this.addUseKeys(RUBBER_HOSE, FLORENCE_FLASK, STRIKER, HAND_TORCH, 
                        BEAKER, TEST_TUBE, EMPTY_VIAL, COPPER_POT, COPPER_PAN);
    }
    //------------------------------------------------------------------------- 
    @Override public String getDescription() {
        return Player.getPos().hasFurniture(FLORENCE_FLASK) ?
                "The flask now rests nicely on the rack in between the burner and the distillation tube." :
                this.description;
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {
        if (key.equals("strike") || key.equals("light")) {
            if (Player.hasItem(STRIKER))
                return useEvent(new Item(STRIKER, "", 0));
            else
                return "You have nothing in your possession to get that task done.";
        }
        else
            return this.actDialog;
    }
    //-------------------------------------------------------------------------   
    @Override public String useEvent(Item item) {
        String name = item.toString();

        if (name.equals(RUBBER_HOSE)) {
            Player.getInv().remove(item);
            Player.getPos().addFurniture(HOSE_REF);
            return "You connect the hose to the bunsen burner nozzle and the other end to the gas pipe.";
        }
        else if (name.equals(FLORENCE_FLASK)) {
            Player.getInv().remove(item);
            Player.getPos().addFurniture(FLORENCE_FLASK_REF);
            return "You place the florence flask onto the rack.";
        }
        else if (name.matches(HAND_TORCH)) {
            return "An ingenious idea by our clever player, "
                    + "but the torch's flame is unfortunately too weak for that.";
        }
        else if (name.matches("beaker|test tube|empty vial|copper pot|copper pan")) {
            return "That type of vessel was not designed for boiling chemicals! Put it down before you set the room on fire.";
        }
        else {
            Labo_GasPipe p = (Labo_GasPipe)Player.getPos().getFurnRef(PIPE_ID);
                    
            if (p.isOn() && Player.getPos().hasFurniture("hose")) {
                if (Player.getPos().hasFurniture(FLORENCE_FLASK_REF.getID())) {
                    AudioPlayer.playEffect(45);
                    FLORENCE_FLASK_REF.distill();
                    return NOTHING;
                }
                else {
                    AudioPlayer.playEffect(45);
                    return "You strike the top of the burner. For a minute, it burns "
                         + "with an intense flame under open space before dying out.";
                }
            }
            else if (p.isOn() && ! Player.getPos().hasFurniture("hose")) {
                AudioPlayer.playEffect(32);
                return "As you squeeze the striker, a big poof of fire ignites and singes your face. "
                     + "The smell of gas fades momentarily and slowly comes back.";
            }
            else
                return "You strike the burner with no effect.";
        }
    }
    //-------------------------------------------------------------------------     
    @Override public String moveIt() {
        return "The contraption looks pretty fragile. You think it best to leave it where it is.";
    }
    //-------------------------------------------------------------------------
}


