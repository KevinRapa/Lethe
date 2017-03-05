package A_Main;

import A_Super.*;          import static A_Main.NameConstants.*;

import Vestibule.*;        import Closet.*;             import Foyer.*;
import Back_Balcony.*;     import Rotunda.*;            import Lookout.*; 
import West_Outer_Wall.*;  import West_Balcony.*;       import Servants_Quarters.*;
import Servants_Hall.*;    import Ransacked_Quarters.*; import Courtyard.*;
import Front_Balcony.*;    import Scorched_Room.*;      import Study.*; 
import Marble_Hall.*;      import Library.*;            import East_Outer_Wall.*; 
import Secret_Archives.*;  import Workshop.*;           import Dining_Room.*; 
import Drawing_Room.*;     import Trophy_Room.*;        import Kitchen.*; 
import West_Antechamber.*; import Iron_Hall.*;          import Gallery.*;
import Observatory.*;      import Dungeon_Stairs.*;     import Parlor.*;
import Chapel_Stairs.*;    import Chapel.*;             import Back_Hall.*;
import Jade_Hall.*;        import Secret_Stairs.*;      import Garden.*;
import Catacombs.*;        import Caves.*;              import Tomb.*;
import Oubliette.*;        import Ancient_Tomb.*;       import Tunnels.*;
import Catacomb_Entrance.*;import Mystical_Chamber.*;   import Attic.*;
import Laboratory.*;       import Cistern.*;            import Cell.*;
import Escape_Tunnel.*;    import Strange_Pool.*;       import Prison.*;
import Torture_Chamber.*;  import Crypt.*;              import Ancient_Archives.*;
import Keeper_Chamber.*;   import Vault.*;              import Tower.*;
import Black_Staircase.*;  import Top_Balcony.*;        import Lichs_Quarters.*;
import Soul_Chamber.*;  

import java.awt.Color;      import java.util.Random;    import javax.swing.ImageIcon;   
import javax.swing.JFrame;  import javax.swing.JLabel;  import javax.swing.JPanel;

/**
 * Creates a 3 dimensional array of rooms representing the game map.
 * This class is used only when a new game is started.
 * 
 * @author Kevin Rapa
 */
public class Map {
    private final static String PATH = "img" + System.getProperty("file.separator");
    
    private static final JLabel MAP_LABEL = new JLabel();
    private static final JPanel MAP_PANEL = new JPanel();
    private static final JFrame MAP_FRAME = new JFrame("Map");
    
    static {
        MAP_FRAME.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        MAP_FRAME.getContentPane().add(MAP_PANEL);
        MAP_FRAME.setResizable(false);
        MAP_FRAME.setAlwaysOnTop(true);
        
        MAP_PANEL.setBackground(Color.BLACK);
        MAP_PANEL.add(MAP_LABEL);
    }
    
    //==========================================================================
    /**
     * Displays a map for when the player enters 'm'.
     * Displays current floor.
     */
    public static void displayMap() {
        updateMap();

        if (! MAP_FRAME.isVisible()) {
            AudioPlayer.playEffect(2);
            MAP_FRAME.setVisible(true);
        }
    }
    //==========================================================================
    public static void disposeMap() {
        if (MAP_FRAME != null)
            MAP_FRAME.dispose();
    }
    //==========================================================================
    public static void updateMap() {
        ImageIcon icon;

        if (Player.floor() == 6)
            if (Player.getPosId().equals(Id.MS65) 
                    || Player.getPosId().equals(Id.MS66))
                icon = new ImageIcon(PATH + "MS.jpg");
            else    
                icon = new ImageIcon(PATH + "CAVE.jpg");
        else {
            icon = new ImageIcon(PATH + Player.getPosId() + ".jpg");
            
            if (icon.getImage().getWidth(MAP_LABEL) == -1)
                icon = new ImageIcon(PATH + "UNKN.jpg");
        }

        MAP_LABEL.setIcon(icon);
        MAP_FRAME.pack();
    }
    //==========================================================================
    public static Room[][][] createMap() {

        //**********************************************************************
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE ROOMS, FURNITURE, ITEMS">
        //
        // Every room, furniture, and item is instantiated here. For each area, 
        // each room is instantiated, then each item is, then each furniture
        // is and the items are added to the respective furniture. 
        //**********************************************************************  
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE PHYLACTERIES">

        Item studBkPhy = new Stud_BookPhylactery(BOOK_PHYL);
        Item kitcFrtPhy = new Kitc_FrtPhy("glowing pristine fruit");
        Item factumPhy = new Factum(FACTUM);
        Item vauChlPhy = new Vau_ChalicePhylactery("glowing chalice");
        Item towScptrPhy = new Tow_ScepterPhylactery(GLOWING_SCEPTER);

        // </editor-fold>
        // ---------------------------------------------------------------------  
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE KEYS AND GENERIC FURNITURE">
        Key studKey = new Key("crude molded key", Id.STUD);        
        Key gal1Key = new Key("key with a bearded face on its bow", Id.GAL1);       
        Key eow3Key = new Key("workshop key", Id.WORK);       
        Key par2Key = new Key("key with a rose on its bow", Id.PAR2);      
        Key kitcKey = new Key("kitchen key", Id.KITC);
        Key closKey = new Key("closet key", Id.CLOS);
        Key wow2Key = new Key("rusty key", Id.WOW2);
        Key sha1CbtKey = new Key("tiny key", Id.CBNT);
        Key gal5CbtKey = new Key("small golden key", Id.GCBT);
        Key servKey = new Key("servant's quarters key", "XXXX");
        Key dngnKey = new Key("key with a skull on its bow", "XXXX");
        Key drwKey = new Key("drawing room key", Id.DRAR);
        Key chs1Key = new Key("key with a cross on its bow", Id.CHS1);
        Key ou62Key = new Key("oubliette key", Id.OU62);
        Key archKey = new Key("dungeon-keeper key", Id.DKCH);
        Key bal1Key = new Key("key with a chalice on its bow", Id.TOW1); 
        Key rotuKey = new Key("key with a cobra head on its bow", Id.ROTU);   

        Door northDoor = new Door(Direction.NORTH); // Generic directional doors.
        Door southDoor = new Door(Direction.SOUTH);
        Door eastDoor = new Door(Direction.EAST);
        Door westDoor = new Door(Direction.WEST);
        Furniture genDoor = new GenDoor();// Generic door, for rooms with multiple doors.
        Furniture wallEx = new ExteriorWall(); // Generic exterior castle wall.
        Furniture clng = new Ceiling(); // Generic ceiling

        // </editor-fold>
        // --------------------------------------------------------------------- 


        // ---------------------------------------------------------------------  
        // <editor-fold defaultstate="collapsed" desc="AREA 1: CASTLE FRONT">

        Item bckt = new Item(METAL_BUCKET, "It's an empty metal bucket."); // Used with all fireplaces
        Item vial = new Item(EMPTY_VIAL, "It's a small glass vial for holding samples");
        Item ram = new Weapon(BATTERING_RAM, "You've restored the old battering ram back to its former glory.");

        // <editor-fold defaultstate="collapsed" desc="Mandragora set">
        // Instantiated before courtyard because soil can be found in the courtyard.
        Item mndrk = new Item(MANDRAGORA, "The potato-shaped vegetable looks disturbingly life-like.");
        Item hlyWtr = new Liquid(HOLY_WATER, "Clear, salty, and boiled like hell.", mndrk, 2);
        Item pttdMndrk = new Item(POTTED_MANDRAGORA, "You have gently positioned the bulb under the soil.", mndrk, 2);
        Item mndrkBlb = new Item("mandragora bulb", "It's a baby mandragora!", pttdMndrk, 2);
        Item mndrkPt = new Item(POTTED_SOIL_AND_FERTILIZER, "The fertile soil mixture is packed gently into the pot. ", pttdMndrk, 2);
        Item pot = new Item("clay pot", "It's a medium-sized clay pot for holding plants.", mndrkPt, 2);
        Item mxtr = new Item(FERTILIZED_SOIL, "It's a fertile mixture of soil, sand, and fertilizer", mndrkPt, 2);
        Item snd = new Item(SAND, "You have a pocket full of sand. It's grainy and uncomfortable.", mxtr, 3);
        Item sl = new Item(SOIL, "It's a soft pile of soil", mxtr, 3);
        Item frt = new Item(FERTILIZER, "It's a handful of mysterious gardening wizardry.", mxtr, 3);
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="INITIALIZE WEST ANTECHAMBER">
        Furniture foy1Gt = new Foy_Gate(false, Direction.WEST);
        Furniture foy2Gt = new Foy_Gate(true, Direction.NORTH);
        Furniture foy2Bttn = new Foy2_Button(foy1Gt, foy2Gt);
        //-----------------------------THE ROOM---------------------------------
        Room foyw = new Want("in an antechamber", Id.FOYW);     
        //-----------------------------FURNITURE--------------------------------        
        Furniture wantLvr = new Want_Lever();
        Furniture wantStat = new Want_Statue();
        Furniture wantPllrs = new Want_Pillars();
        Furniture wantTrchs = new Want_Torches();
        Furniture wWW = new Wall("It's made of big sandstone bricks");
        Furniture wantF = new Floor("A sandstone tiled floor.");
        Furniture wantRmp = new Want_Ramp();
        Furniture wantDr = new Want_Door(Direction.WEST);
        Furniture wantGt = new Want_Gate(Direction.EAST);
        Furniture wantBttn = new Want_Button(foy2Bttn);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE BACK BALCONY">
        //-----------------------------THE ROOM---------------------------------
        Room foyb = new Bba1("on the back balcony", Id.FOYB);
        Room foyc = new Bba2("on the back balcony", Id.FOYC);      
        //-------------------------------ITEMS----------------------------------        
        Item bbaNote = new Bba_Note("note from a visitor");
        //-----------------------------FURNITURE--------------------------------                       
        Furniture bbaF = new Floor("It's a shale tile floor.");
        Furniture bbaClmns = new Bba_Columns();   
        Furniture bbaRlng = new Bba_Rlng();  
        Furniture bbaVllg = new Bba_Village();
        Furniture bbaScnc = new Bba_Sconce();   
        Furniture bbaBnch = new Bba_Bench(bbaNote);
        Furniture bbaClff = new Bba_Cliff();
        Furniture bbaShrln = new Bba_Shoreline();
        Furniture bbaSea = new Bba_Sea();
        Furniture bba2Dr = new Bba2_Door(Direction.SOUTH);
        Furniture bba1Gt = new Want_Gate(Direction.SOUTH);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE FOYER">
        //-----------------------------THE ROOM---------------------------------
        Room foy1 = new Foy1("in the foyer", Id.FOY1);
        Room foy2 = new Foy2("at the grand staircase", Id.FOY2); 
        Room foy3 = new Foy3("on the second floor landing", Id.FOY3);
        Room foy4 = new Foy4("on the third floor landing", Id.FOY4); 
        //-------------------------------ITEMS----------------------------------        
        Item foy1Note = new Foy1_Note("short letter");
        Item cndlStck = new Weapon("brass candlestick", "The candle is missing. Well, at least no one can club you behind the head with it now.");
        Item bskt = new Item("wicker basket", "A decorative wicker basket. Probably not very useful for you right now.");
        //-----------------------------FURNITURE--------------------------------    
        Furniture foyW = new Wall("A dark wood-paneled wall.");
        Furniture foyF = new Floor("Salmon-colored tiled marble. Its glint stuns you.");
        Furniture foyFrntDr = new Entr_Door(Direction.SOUTH);

        Furniture foy1Chnd = new Foy_Chandelier();
        Furniture foy1Tbl = new Foy1_Table(bskt, foy1Note, cndlStck);
        Furniture foy1Crpt = new Foy1_Carpet();
        Furniture foy1Strs = new Foy1_Stairs();    

        Furniture foy2Stat = new Foy2_Stat(foy2Bttn);
        Furniture foy2Alc = new Foy2_Alcove(foy2Stat);
        Furniture foy2Strcs = new Foy2_Staircase(Direction.UP);

        Furniture foy3Strs = new Foy3_Stairs();
        Furniture foy3F = new Floor("The floor is a salmon-colored tile run with a red carpet, which continues along the staircase.");
        Furniture foy34Crpt = new Foy34_Carpet();

        Furniture foy4Strs = new Foy2_Staircase(Direction.DOWN);
        Furniture foy4F = new Floor("The floor is a salmon-colored tile run with a red carpet, which continues along the staircase.");
        Furniture foy4Dr = new Foy4_Door(Direction.SOUTH);

        // </editor-fold>        
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE VESTIBULE">
        //-----------------------------THE ROOM---------------------------------
        Room vest = new Vest("in a vestibule", Id.VEST); 
        //-------------------------------ITEMS----------------------------------
        Item qllPn = new Item("quill pen", "It's an old matted feather stained with dried ink.");
        Item lttrOpnr = new Item("letter opener", "It's a very dull knife.");
        Item loopedRope = new Item(LOOPED_ROPE, "It's a short rope tied into a noose. It's pretty\n"
                                              + "frayed in the center.", ram, 3);
        //-----------------------------FURNITURE--------------------------------
        Furniture vesOrb = new Vest_Orb();
        Furniture vesFire = new Vest_Fireplace(true, bckt);
        Furniture vesBtn = new Vest_Button(vesFire);
        Furniture vesWin = new Vest_Window(vesFire);
        Furniture vesDr = new Vest_Dr(Direction.WEST);      
        Furniture vesDsk = new Vest_Desk(qllPn, lttrOpnr, loopedRope);
        Furniture vesEtbl = new Vest_EndTable();
        Furniture vesCase = new Vest_Case(rotuKey);
        Furniture vesTpstr = new Vest_Tpstr();
        Furniture vesChr = new Vest_Chair();
        Furniture vesF = new Floor("A cold, shale tile floor. It's slightly dusty.");          
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE COURTYARD">
        //-----------------------------THE ROOM---------------------------------
        Room cou1 = new Cou1("in the northwest courtyard", Id.COU1);
        Room cou2 = new Cou2("in the southwest courtyard", Id.COU2);
        Room cou3 = new Cou3("in the castle courtyard", Id.COU3);
        Room cou4 = new Cou4("at the front gate", Id.COU4);
        Room cou5 = new Cou5("in the southeast courtyard", Id.COU5);
        Room cou6 = new Cou6("in the northeast courtyard", Id.COU6);
        //-------------------------------ITEMS----------------------------------
        Item krnsPlt = new Obs1_Plate("brass plate, \"Saturn\"", "The small plate bears an engraving: \"Saturn\"");
        Item soldMed = new Item(STONE_DISK, "The smooth disk is about four or five inches across.\n"
                                            + "Its craftmanship is precise, although there's a\n"
                                            + "chip on its edge. On its surface is an embossment\n"
                                            + "of a soldier.");
        Item rck = new Item(ROCK, "It's a piece of the courtyard fountain.");
        Item grss = new Item(GRASS, "It's some dark green grass that you pulled from the ground.");
        Item clvr = new Item("clover", "It's some clover you pulled from the ground.");
        Item trs = new Item("statue torso", "It's a stone torso, probably from the courtyard statue");
        Item hd = new Item("statue head", "It's a stone head with a chiseled male face.");
        Item sprcExtrct = new Liquid(SPRUCE_EXTRACT, "Evergreens are widely known to be resistant to burning.");
        Item brrs = new Item("bright red berries", "They look firm and juicy", "You realize, the brightest, reddest berries are the most poisonous of all.");
        Item pnCn = new Item("pinecone", "It's scaley but smooth, and is shaped like a pickle. Yes, undoubtedly a spruce pinecone!", "This looks painful to eat...");
        //-----------------------------FURNITURE--------------------------------
        Furniture couCstl = new Cou_Castle();
        Furniture couW = new Wall("The castle walls are several stories tall and made of granite blocks.");
        Furniture couStps = new Cou_Steps();
        Furniture coutWlkwy = new Cou_Tiles();

        Furniture cou1Bnch = new Cou1_Bench();
        Furniture cou1Thrns = new Cou1_Thorns();
        Furniture cou1Hl = new Cou1_Hole(krnsPlt);
        Furniture cou1F = new Cou1_Floor(sl, grss, clvr, cou1Hl, sl, sl, sl);

        Furniture cou2Fntn = new Cou2_Fountain(rck, rck, rck, rck);
        Furniture cou2Bshs = new Cou2_Bushes(brrs, brrs, brrs, brrs, brrs);
        Furniture cou2F = new Cou_Floor(sl, grss, clvr, sl, sl, sl);

        Furniture cou3Stps = new Cou3_Steps(Direction.UP);
        Furniture cou3Ivy = new Cou3_Ivy();
        Furniture cou3Gt = new Cou3_Gate();
        Furniture cou3F = new Cou_Floor(sl, grss, clvr, sl, sl);

        Furniture cou4Gt = new Cou4_Gate();
        Furniture cou4Frst = new Cou4_Forest();
        Furniture cou4Trl = new Cou4_Trail();

        Furniture cou5Fntn = new Cou5_Fountain(rck, soldMed, rck);
        Furniture cou5Sprc = new Cou5_Spruce(vial, sprcExtrct, pnCn, pnCn, pnCn);
        Furniture cou56F = new Cou_Floor(sl, grss, clvr, trs, sl, hd, sl);

        Furniture cou6Stat = new Cou6_Statue();
        Furniture cou6Ghst = new Cou6_BlackJackGhost();
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE ENTRANCE">
        //-----------------------------THE ROOM---------------------------------
        Room cou7 = new Entr("on the front balcony", Id.COU7);  
        //-----------------------------FURNITURE--------------------------------
        Furniture entrF = new Floor("The balcony is layed with a brown shale tile.");
        Furniture entrBlcny = new Entr_Balcony();
        Furniture entrClmns = new Entr_Columns();
        Furniture entrRf = new Entr_Roof();
        Furniture entrStats = new Entr_Statues();
        Furniture entrDr = new Entr_Door(Direction.NORTH);
        Furniture entrStps = new Cou3_Steps(Direction.DOWN);
        // </editor-fold>

        // </editor-fold>
        // ---------------------------------------------------------------------     
        // <editor-fold defaultstate="collapsed" desc="AREA 2: WEST WING">

        Item brRam = new Item("broken battering ram", "It's a battering ram, but without the other rope to hold it with, it's useless.", "It's useless now.");
        Item rdFcs = new Focus(RED_FOCUS, "It's a cool brass ring holding a red lens.");   

        // <editor-fold defaultstate="collapsed" desc="INITIALIZE ROTUNDA">
        //-----------------------------THE ROOM---------------------------------
        Room rotu = new Rotu("in the rotunda", Id.ROTU);      
        //-------------------------------ITEMS----------------------------------
        Item crmcShrd = new Weapon("ceramic shard", "It's a broken piece of ceramic. A useable, but inefficient weapon.");
        //-----------------------------FURNITURE-------------------------------- 
        Furniture rotuFntn = new Rotu_Fountain();
        Furniture rotuW = new Wall("A clean white marble wall.");
        Furniture rotuF = new Floor("It's a dirty white-tiled floor littered with plant matter.", crmcShrd, crmcShrd);
        Furniture rotuPlnts = new Rotu_Plants(sl);
        Furniture rotuHl = new Rotu_Hole();
        Furniture rotuStat = new Rotu_Statue();
        Furniture rotuScnc = new Rotu_Sconce();
        Furniture rotuFrms = new Rotu_Frames();
        Furniture rotuSky = new Rotu_Sky();
        Furniture rotuRock = new Rotu_Rock();
        // </editor-fold>        
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE LOOKOUT">
        //-----------------------------THE ROOM--------------------------------- 
        Room look = new Look("on the lookout", Id.LOOK);       
        //-----------------------------FURNITURE-------------------------------- 
        Furniture lookVlv = new Look_Valve(rotuFntn);
        Furniture lookLghths = new Look_Lighthouse();
        Furniture lookClff = new Look_Cliff();
        Furniture lookRlng = new Look_Railing();
        Furniture lookF = new Floor("Just a wet shale floor.");
        // </editor-fold> 
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE IRON HALL">
        //-----------------------------THE ROOM---------------------------------
        Room iha1 = new Iha1("in a north side hall", Id.IHA1);
        Room iha2 = new Iha2("in a south side hall", Id.IHA2);
        //-------------------------------ITEMS----------------------------------
        Item iha2plArm = new Weapon(POLEARM, "It looks like an old medieval polearm.");
        //-----------------------------FURNITURE--------------------------------
        Furniture iha1Lvr = new Iha1_Lever();
        Furniture iha1Armr = new Iha1_Armor();
        Furniture iha2Armr = new Iha2_Armor(iha2plArm);     
        Furniture ihaF = new Floor("A sandstone tiled floor.");
        Furniture ihaWndw = new Iha_Window();
        Furniture iha1Bwl = new Iha1_Bowl(ihaF, wow2Key);
        Furniture iha2Bwl = new Iha2_Bowl();
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE WEST OUTER WALL">
        //-----------------------------THE ROOM---------------------------------
        Room wow1 = new Wow1("in the west outer wall", Id.WOW1);
        Room wow2 = new Wow2("in the west outer wall", Id.WOW2);
        //-------------------------------ITEMS----------------------------------
        Item vinegar = new Liquid(BOTTLE_OF_VINEGAR, "A bottle of yellow liquid. Printed on the label is \"C2H4O2\"");
        Item wowLddr = new Item(FIXED_LADDER, "The spoke sits in there a bit awkwardly, but it\n"
                              + "seems like a good ladder. It may even support your heft.");   
        Item wow1Spk = new Item(WHEEL_SPOKE, "It's a wooden rod, about a foot long.", wowLddr, 3);
        Item clngSoln = new Liquid("cleaning solution", "It smells lemony fresh, unlick the rest of this room.");
        Item rppdBrlp = new Item("piece of ripped burlap", "It must have belonged to the broken cart in the west wing.");
        Item actn = new Liquid(ACETONE, "It's a strong-smelling solvent in an opaque jar.");
        //-----------------------------FURNITURE--------------------------------
        Furniture wow2Lddr = new Wow2_Ladder(Direction.UP); // Not in WOW2 to start.
        Furniture wow2Armr = new Wow2_Armor();
        Furniture wow1Crt = new Wow1_Cart(wow1Spk, rppdBrlp);
        Furniture wow1F = new Floor("A sandstone tiled floor.");
        Furniture wow2Blcny = new Wow2_Balcony(wow2Lddr, wowLddr); // Fixed ladder can be used on this.
        Furniture wow2F = new Wow2_Floor(wow2Lddr, wowLddr); // Fixed ladder can be used on this.
        Furniture wow2Dr = new Wow2_Door(Direction.EAST);
        Furniture wow2Hole = new Wow2_Hole();
        Furniture wowWndw = new Wow_Window();
        Furniture wowHrth= new Wow_Hearth(true, bckt);
        Furniture wow2Strcs = new Wow2_Stairs(); 
        Furniture wow1NDr = new Sha_Door(Direction.NORTH);
        Furniture wow1Shlvs = new Wow1_Shelves(vial, vinegar, clngSoln, actn);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE WEST BALCONY">
        //-----------------------------THE ROOM---------------------------------
        Room wbal = new Wbal("on the west balcony", Id.WBAL);   
        //-------------------------------ITEMS----------------------------------
        Item wbalch = new Item("chunk of wood", "It's a rotted chunk of wood.");
        Item wbalsp = new Item("wood splinter", "It's a splinter of wood.");
        Item wbalbr = new Item("branch", "A plain branch.");
        Item wbalBrg = new Item("broken rod", "It looks like it belonged to a ladder.");
        Item wbalRng = new Item("wooden rod", "It's a wooden rod, about a foot long.", wowLddr, 3);
        //-----------------------------FURNITURE--------------------------------
        Furniture wbalF = new Floor("A shale tile floor. Many pieces of wood\nlitter it.", 
                                    wbalch, wbalbr, wbalBrg, wbalsp, wbalsp, wbalRng, wbalbr, wbalch, wbalch);
        Furniture wbalBcn = new Wbal_Beacon();
        Furniture wbalFrst = new Wbal_Forest();
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE SERVANTS QUARTERS">
        //-----------------------------THE ROOM---------------------------------
        Room squa = new Squa("in a servant's quarters", Id.SQUA);
        //-------------------------------ITEMS----------------------------------
        Item squaLddr = new Squa_Ladder("broken ladder", wowLddr, 3);
        Item squaJrnl = new Note("note: ladder", "Need to get that ladder fixed. Too busy with the cart.\n"
                + "Don't ask mages to fix, they've been busy lately. I'll keep it under my bed for now.");
        Item rags = new Clothing("worn rags", "Some dirty worn rags.", "You are perfectly content with the clothes you have on now.");
        Item aprn = new Clothing("kitchen apron", "It's a kitchen apron.", "You are perfectly content with the clothes you have on now.");
        Item shs = new Shoes("moccasins", "A pair of worn leather mocassins.", "You put on the moccasins. They're quite uncomfortable.");
        //-----------------------------FURNITURE--------------------------------
        Furniture squaF = new Floor("A sandstone tiled floor.");
        Furniture squaDr = new Sha_Door(Direction.EAST);
        Furniture squaBd = new Squa_Bed(squaLddr);
        Furniture squaDsk = new Squa_Desk(squaJrnl, sha1CbtKey);
        Furniture squaWndw = new Squa_Window();
        Furniture squaCndl = new Squa_Candle();
        Furniture squaWrdrb = new Squa_Wardrobe(rags, rags, aprn, shs);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE CLOSET">
        //-----------------------------THE ROOM---------------------------------
        // Used to be called "Groundskeeper's quarters"
        Room clos = new Clos("in a groundskeeping closet", Id.CLOS);
        //-------------------------------ITEMS----------------------------------
        Item closCrwbr = new Weapon(CROWBAR, "A sweet iron crowbar.");
        Item shvl = new Weapon(SHOVEL, "A sturdy shovel for the digging of holes.");
        Item hmmr = new Weapon(HAMMER, "It's a small handheld nailing device.");
        Item sd = new Item(SEED, "It's a handful of mysterious gardening wizardry.");
        Item gl = new Liquid("glue bottle", "It's a bottle of sticky glue.");
        Item closGlv = new Clothing("gloves", "Some old gardening gloves", "They don't fit on your enormous hands.");
        Item closStrw = new Item("straw", "It's just straw");
        Item scrw1 = new Screw("1mm screw", rdFcs, 3);
        Item scrw2 = new Item("2mm screw", "Just a small screw.");
        Item scrw5 = new Item("5mm screw", "Just a small screw.");
        //-----------------------------FURNITURE--------------------------------
        Furniture closDr = new Wow2_Door(Direction.WEST);
        Furniture closLddr = new Gqua_Ladder(Direction.DOWN);
        Furniture closClng = new Gqua_Ceiling();
        Furniture closF = new Floor("It's a cold, hard, cobblestone floor", closStrw);
        Furniture closScks = new Gqua_Sacks(sd, sd, sd, frt, frt, frt, snd, snd, snd, snd, snd);
        Furniture closShlf = new Gqua_Shelf(bckt, closGlv, vial, shvl, pot, pot);
        Furniture closWrkbnch = new Gqua_Workbench(gl, hmmr, scrw2, scrw1, scrw2, scrw5, scrw5, scrw1);
        Furniture closStl = new Gqua_Stool();
        Furniture closBrrl = new Gqua_Barrel();
        Furniture closW = new Wall("It's a plain cobblestone wall.");
        Furniture closSkltn = new Gqua_Skeleton(closCrwbr);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE WEST OUTER WALL BALCONY">
        //-----------------------------THE ROOM---------------------------------
        Room wow3 = new Wow3("on the west outer wall balcony", Id.WOW3, wow2Lddr, wow2F.getInv(), wowLddr);
        //-------------------------------ITEMS----------------------------------
        Item wowRope = new Item("rope", "It's a short coiled rope.", ram, 3);
        //-----------------------------FURNITURE--------------------------------
        Furniture wow3Shlf = new Wow3_Shelf(wowRope, closKey);
        Furniture wow3F = new Floor("A sandstone tiled floor.");
        Furniture wow3NDr = new Wow3_NorthDoor();
        Furniture wow3Dr = new Wow3_Door(Direction.EAST);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE RANSACKED QUARTERS">
        //-----------------------------THE ROOM---------------------------------
        Room shar = new Rqua("in ransacked quarters", Id.SHAR);
        //-------------------------------ITEMS----------------------------------
        Item cmb = new Item("comb", "A plain hair comb.", "You comb your beard for several seconds until it's nice and kept.");
        Item cndlStk = new Weapon("candlestick", "A small brass candlestick.");
        Item sht = new Item("sheet", "A white bedsheet.");
        //-----------------------------FURNITURE--------------------------------
        Furniture rquaBd = new Rqua_Bed();
        Furniture rquaMttrss = new Rqua_Mattress();
        Furniture rquaTbl = new Rqua_Table();
        Furniture rquaDrssr = new Rqua_Dresser();
        Furniture rquaF = new Floor("A sandstone tiled floor.", rags, cmb, rags, sht, cndlStk, rags, shs);
        Furniture rquaPnl = new Rqua_Panel(studKey, rquaBd);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE SERVANTS HALL">
        //-----------------------------THE ROOM---------------------------------
        Room sha2 = new Sha2("in the north servant's hall", Id.SHA2);
        Room sha1 = new Sha1("in the south servant's hall", Id.SHA1);
        //-------------------------------ITEMS----------------------------------
        Item wdChnk = new Wood_Chunk("wood log", ram, 3);       
        Item shaMp = new Item(MOP, "It's a classic mop.", "Yes, let's just make this a game about cleaning some madman's castle.");
        Item shaSpng = new Item("sponge", "It's a quintessential yellow sponge.", "I'm a lumberjack, not a maid!");
        //-----------------------------FURNITURE--------------------------------       
        Furniture sha2Cbnt = new Sha2_Cabinet(wdChnk, shaSpng, shvl, shaMp, bckt);
        Furniture shaF = new Floor("A sandstone tiled floor.");
        Furniture sha2Dr = new Sha_Door(Direction.WEST);
        Furniture sha1SDr = new Sha_Door(Direction.SOUTH);
        Furniture sha1Trch = new Torch();
        Furniture sha2Trch = new Torch();
        Furniture sha1Dr = new Sha1_Door(ram, brRam, genDoor);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE SCORCHED ROOM">
        //-----------------------------THE ROOM---------------------------------
        Room cous = new Cous("in a scorched room", Id.COUS);
        //-------------------------------ITEMS----------------------------------
        Item wrhmmr = new Item(WARHAMMER, "It's an old medieval warhammer. The head looks extremely worn and dull.");
        Item ash = new Item(ASH, "You're sure there are people mixed in with this...");
        Item wd = new Item("charred wood", "It's a piece of burnt wood");
        //-----------------------------FURNITURE-------------------------------- 
        Furniture searFssr = new Sear_Fissure();
        Furniture searDr = new Sear_Door();
        Furniture searAsh = new Sear_Ash(ash);
        Furniture searWood = new Sear_Wood(wd);
        Furniture searSkltn = new Sear_Skeleton(closCrwbr);
        Furniture searLddr = new Gqua_Ladder(Direction.UP);
        Furniture searF = new Floor("It's a cold, hard, cobblestone floor", ash, wd, ash, wrhmmr, wd, ash);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE STUDY">
        //-----------------------------THE ROOM---------------------------------
        Room stud = new Stud("in the study", Id.STUD);
        //-------------------------------ITEMS----------------------------------
        Item studBkPi = new Stud_PiBook("book, 'An Essential Pi'");
        Item studNote = new Stud_Note("personal note");
        Item pen = new Item("pen", "It's a fancy ballpoint pen", "If only you had your diary with you to write down your feelings.");
        Item ppr = new Item("parchment", "Some old brown parchment", "You don't feel the need to write anything down.");
        //-----------------------------FURNITURE-------------------------------- 
        Furniture studSafe = new Stud_Safe("367", studBkPhy, gal1Key);
        Furniture studF = new Floor("The floors are a weathered dark hickory. How nice!");
        Furniture studPrtrt = new Stud_Portrait(studSafe);
        Furniture studFire = new Stud_Fireplace(true, bckt);
        Furniture studDsk = new Stud_Desk(pen, pen, ppr, servKey, studNote);
        Furniture studBkCs = new Stud_BookCase(studBkPi);
        Furniture studCch = new Stud_Couch();
        Furniture studCrpt = new Stud_Carpet();
        // </editor-fold>

        // </editor-fold>
        // ---------------------------------------------------------------------     
        // <editor-fold defaultstate="collapsed" desc="AREA 3: EAST WING">

        // <editor-fold defaultstate="collapsed" desc="INITIALIZE TROPHY ROOM">
        //-----------------------------THE ROOM---------------------------------
        Room gal5 = new Gal5("in a trophy room", Id.GAL5);
        //-------------------------------ITEMS----------------------------------
        Item zsPlt = new Obs1_Plate("brass plate, \"Jupiter\"", "The small plate bears an engraving: \"Jupiter\"");
        Item emrld = new Item(GLOWING_EMERALD, "The emerald pulses with a blue glow.", "This belongs to someone important.");
        Item aqmrn = new Item(AQUAMARINE, "It's a beautiful blue gem.");
        Item rby1 = new Item(RUBY, "The ruby is well cut and clean, having been protected in the case for so long.");
        //-----------------------------FURNITURE--------------------------------
        Furniture gal5Dr = new Gal4_Door(Direction.SOUTH);
        Furniture gal5Dsply = new Gal5_Display(rby1, emrld, aqmrn);
        Furniture gal5Chndlr = new Gal5_Chandelier();
        Furniture gal5Cbwbs = new Cobweb();
        Furniture gal5Clng = new Gal5_Ceiling();
        Furniture gal5F = new Floor("The floor is a black and white checkered tile.");
        Furniture gal5W = new Wall("The walls are just plain granite brick.");
        Furniture gal5Cbt = new Gal5_Cabinet(zsPlt);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE GALLERY">
        //-----------------------------THE ROOM---------------------------------    
        Room gal1 = new Gal1("in the first floor gallery", Id.GAL1);
        Room gal2 = new Gal2("in the gallery central chamber", Id.GAL2);      
        Room gal3 = new Gal3("in the second floor gallery", Id.GAL3);
        Room gal4 = new Gal4("on the second floor gallery balcony", Id.GAL4);
        Room gal6 = new Gal6("in the gallery loft", Id.GAL6);
        Room gal7 = new Gal7("in the gallery loft", Id.GAL7);
        //-------------------------------ITEMS----------------------------------
        Item blFcs = new Focus(BLUE_FOCUS, "It's a cool brass ring holding a blue lens.");
        Item yllwFcs = new Focus(YELLOW_FOCUS, "It's a cool brass ring holding a yellow lens.");
        Item drkFcs = new Focus(DARK_FOCUS, "It's a cool brass ring holding a tinted lens.");
        Item fnnyOrb = new Item(CRYSTAL_ORB, "It's extremely clean, and it contains a peculiar\n"
                                             + "gas, the color of which you cannot quite describe.");
        Item bxThngy = new Item(BOX_THINGY, "This small black metal box has some surprising weight\n"
                                            + "to it. It's a bit to big to fix in your palm. A small\n"
                                            + "red light is on top and shiny metal strips are attached\n"
                                            + "to each side.");
        //-----------------------------FURNITURE--------------------------------         
        Furniture gal7Stat = new Gal7_Statue();
        Furniture gal4Stat = new Gal4_Statue(gal7Stat);
        Furniture gal2Stat = new Gal2_Statue(gal4Stat);

        Furniture gal1Dr = new Bba2_Door(Direction.NORTH);
        Furniture gal1Drgn = new Gal1_Dragon(gal2Stat, yllwFcs);
        ((Gal2_Statue)gal2Stat).addDragonRef(gal1Drgn);
        Furniture gal1KtnFurn = new Gal1_KatanaFurniture();
        Furniture gal1Swtch = new Gal1_Switch(gal1Drgn);
        Furniture gal1Bttn = new Gal1_Button(gal1Drgn);
        Furniture gal1Lghts = new Gal1_Lights();
        Furniture gal1Scr = new Gal1_Scroll(gal1Bttn);
        Furniture gal1Scrn = new Gal1_Screen(gal1Swtch);
        Furniture gal1Armr = new Gal1_Armor();
        Furniture gal1F = new Floor("The floor is a dark hardwood.");
        Furniture gal1W = new Wall("The wall is tiled a dark green and purple. Interesting choice...");
        Furniture gal1Sclptrs = new Gal1_Sculptures();
        Furniture gal1Pntngs = new Gal1_Paintings();
        Furniture gal1Pntng3 = new Gal1_Painting3();
        Furniture gal1Pntng2 = new Gal1_Painting2();
        Furniture gal1Pntng = new Gal1_Painting1();
        Furniture gal1Hrth = new Gal1_Hearth(true, bckt);

        Furniture gal3Ttm = new Gal3_Totem(gal4Stat);
        Furniture gal3Peg = new Gal3_Peg(gal3Ttm);
        Furniture gal3Sgmnt = new Gal3_Segment(gal3Ttm);
        Furniture gal3Lddr = new Gal3_Ladder(Direction.UP);
        Furniture gal3Rp = new Gal3_Rope(gal3Lddr);
        Furniture gal3Swtch = new Gal3_Switch();
        Furniture gal3InstFurn = new Gal3_KoraFurniture();
        Furniture gal3Msk = new Gal3_Mask1();
        Furniture gal3Msk2 = new Gal3_Mask2();
        Furniture gal3Msk3 = new Gal3_Mask3();
        Furniture gal3Msks = new Gal3_Masks();
        Furniture gal3Hrth = new Gal3_Hearth(true, bckt);
        Furniture gal3F = new Floor("The floor is a dark hardwood.");
        Furniture gal3W = new Wall("The wall a yellow plaster, giving it a warm appearance.");
        Furniture gal3Art = new Gal3_Artifact1();
        Furniture gal3Art2 = new Gal3_Artifact2();
        Furniture gal3Art3 = new Gal3_Artifact3();
        Furniture gal3Arts = new Gal3_Artifacts();
        Furniture gal3Htch = new Gal3_Hatch();
        Furniture gal3Hl = new Gal3_Hole();

        Furniture galDm = new Gal_Dome();
        Furniture gal2Clmns = new Gal2_Columns();
        Furniture galBalc = new Gal_Balcony();
        Furniture gal2F = new Floor("This room's floor is magnificent. It's solid marble and resembles a compass.");
        Furniture gal2W = new Wall("The wall here is ornate white-paneled wood.");
        Furniture gal4Dr = new Gal4_Door(Direction.NORTH);
        Furniture gal4Lft = new Gal4_Loft();
        Furniture gal2Strcs = new Gal2_Staircase(Direction.UP);
        Furniture gal4Strcs = new Gal2_Staircase(Direction.DOWN);

        Furniture gal6Htch = new Gal6_Hatch();
        Furniture gal6Cnn = new Gal6_Canon(gal7Stat);
        Furniture gal6Lddr = new Gal6_Ladder(Direction.DOWN);
        Furniture gal6Hlmt = new Gal6_Helmet();
        Furniture gal6Mchn = new Gal6_Machine();
        Furniture gal6Bttn = new Gal6_Button();
        Furniture gal6App = new Gal6_Apparatus(bxThngy);
        Furniture gal6F = new Floor("The floor is a dark hardwood.");
        Furniture gal6W = new Wall("The wall is paneled in classy mahogany.");
        Furniture gal6Tech = new Gal6_Technology();
        Furniture gal6Elec = new Gal6_Technology();
        Furniture gal6Tbl = new Gal6_Table();
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE DINING ROOM">
        //-----------------------------THE ROOM---------------------------------
        Room din1 = new Din1("in the dining room", Id.DIN1);  
        Room din2 = new Din2("on the dining room balcony", Id.DIN2);
        //-------------------------------ITEMS----------------------------------
        Item aphrdtPlt = new Obs1_Plate("brass plate, \"Venus\"", "The small plate bears an engraving: \"Venus\"");
        Item frk = new Item("fork", "It's a nice silver fork.", "You comb your beard with the fork until it's straight and tidy.");
        Item plt = new Item("plate", "It's fancy ceramic plate.");
        Item spn = new Item("spoon", "It's a nice silver spoon.", "You attempt to comb your beard with the spoon, but it's not working so well.");
        Item npkn = new Item("napkin", "A white cloth napkin.", "You wipe the sweat off your forehead. Carrying all these items has taken its toll on you.");
        //-----------------------------FURNITURE--------------------------------  
        Furniture din1Clmns = new Din1_Columns();
        Furniture din1Blcny = new Din1_Balcony();
        Furniture din1Wndw = new Din1_Window();
        Furniture din1Chrs = new Din1_Chairs();
        Furniture din1Tbl = new Din1_Table(frk, spn, plt, npkn, cndlStck, frk, spn, plt, npkn, cndlStck);
        Furniture din1Chndlr = new Din1_Chandelier();
        Furniture din1Mnlght = new Din1_Moonlight();
        Furniture din1Crvc = new Din1_Crevice(aphrdtPlt);
        Furniture din1Tpstry = new Din1_Tapestry(din1Crvc);
        Furniture din1Strs = new Din1_Stairs(Direction.UP);
        Furniture din1Crpt = new Din1_Carpet();
        Furniture din1F = new Floor("The floor is a light gray stone. A large rectangular\n"
                                  + "lavender carpet covers much of it.");
        Furniture din1W = new Wall("The walls of this room are gray stone with dark wood paneling at the bottom.");
        Furniture din1Dr = new Din1_Door(Direction.WEST);

        Furniture din2F = new Floor("The floor is a light gray stone.");
        Furniture din2W = new Wall("The walls up here are a gray stone.");
        Furniture din2Pntng = new Din2_Painting();
        Furniture din2Strs = new Din1_Stairs(Direction.DOWN);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE MARBLE HALL">
        //-----------------------------THE ROOM---------------------------------
        Room mha1 = new Mha1("in the north marble hall", Id.MHA1);
        Room mha2 = new Mha2("in the marble hall", Id.MHA2);
        Room mha3 = new Mha3("in the south marble hall", Id.MHA3);
        //-------------------------------ITEMS----------------------------------       
        Item angMed = new Item(ANGEL_MEDALLION, "It's a beautiful gold disk about four or five inches\n"
                                                + "across. On its surface is an embossment of an angel.");
        Item horMed = new Item(HORSE_MEDALLION, "It's a silver disk about four or five inches across.\n"
                                                + "On its surface is an embossment of a galloping horse.");
        //-----------------------------FURNITURE--------------------------------  
        Furniture mhaChndlr = new Mha_Chandelier();
        Furniture mhaF = new Floor("The floor is green tiled marble. Expensive!");
        Furniture mhaW = new Wall("The walls are plain white granite. All that occupy them are the tall windows.");
        Furniture mhaNWndw1 = new Mha1_Window();
        Furniture mhaNWndw2 = new Mha1_Window();
        Furniture mhaSWndw = new Mha3_Window();
        Furniture mhaNChaDr = new Mha1_Door(Direction.EAST);
        Furniture mhaNDr = new Mha_Door(Direction.NORTH);
        Furniture mhaSDr = new Mha_Door(Direction.SOUTH);
        Furniture mhaWDr = new Mha_Door(Direction.WEST);
        Furniture mha3KitcDr = new Mha3_Door(Direction.EAST);
        Furniture mhaMDr = new Mha2_Door(din1, Direction.EAST);
        Furniture mha1Plnt = new Mha_Plant(sl);
        Furniture mha2Plnt = new Mha_Plant(sl);
        Furniture mha3Plnt = new Mha_Plant(sl);
        Furniture mhaChr = new Mha_Chair();
        Furniture mhaRStat = new Mha2_RightStatue(angMed);
        Furniture mhaLStat = new Mha2_LeftStatue();
        Furniture mhaStats = new Mha2_Statues(mhaRStat);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE WORKSHOP">
        //-----------------------------THE ROOM---------------------------------
        Room work = new Work("in the workshop", Id.WORK);
        //-------------------------------ITEMS----------------------------------
        Item redLns = new Item("red lens", "It's a proper lens tinted red.\n"
                             + "Maybe you should pick up the glass trade!", rdFcs, 3);
        Item rdDy = new Item(RED_DYE, "You have a handful of soft red powdered dye.");
        Item blDy = new Item(BLUE_DYE, "You have a handful of soft blue powdered dye.");
        Item yllwDy = new Item(YELLOW_DYE, "You have a handful of soft yellow powdered dye.");
        Item stncl = new Item(LENS_TEMPLATE, "It's a sheet of metal with a small hole cut in it.");
        Item wrkNt = new Wrk_Note("disturbing momento");
        Item ptsh = new Item(POTASH, "Good old K-rich potash salts!");
        //-----------------------------FURNITURE--------------------------------
        Furniture wrkF = new Floor("A sandstone tiled floor.");
        Furniture wrkBrl = new Wrk_Barrel(rdDy, rdDy, blDy, blDy, yllwDy, yllwDy);
        Furniture wrkCbnt = new Wrk_Cbnt(hmmr, gl, ptsh, ptsh);
        Furniture wrkCstTbl = new Wrk_CastingTable(wrkBrl.getInv(), closScks.getInv(), 
                redLns, snd, rdDy, blDy, yllwDy, ptsh, wrkCbnt.getInv());
        Furniture wrkKln = new Wrk_Kiln();
        Furniture wrkBnch = new Gqua_Workbench(stncl, wrkNt);        
        Furniture wrkAnvl = new Wrk_Anvil();
        Furniture wrkFrg = new Wrk_Forge();
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE EAST OUTER WALL">
        //-----------------------------THE ROOM---------------------------------
        Room eow1 = new Eow1("in the east outer wall", Id.EOW1);
        Room eow2 = new Eow2("in the east outer wall", Id.EOW2);
        Room eow4 = new Eow4("on the east outer wall balcony", Id.EOW4);
        //-------------------------------ITEMS----------------------------------
        Item wtrBckt = new Liquid(BUCKET_OF_WATER, "It's a metal bucket filled with water.");
        Item eowSwrd1 = new Weapon("silver sword", "The sword is finely polished and sharp. Ornamental possibly.");
        Item eowSwrd2 = new Weapon("rusty sword", "The sword is rusty and a little dull, but still somewhat effective.");
        Item eowSwrd3 = new Weapon("broken sword", "This sword is broken halfway down the blade. This is a mark of poor craftsmanship.");
        Item eowSSpr = new Weapon(SILVER_SPEAR, "This is beautiful! It's solid metal with a silvery shine.");
        Item woodSpr = new Weapon("wooden spear", "This looks like a plain wooden spear. A bit primitive looking.");
        Item eowPlArm = new Weapon(POLEARM, "This is a typical polearm.");
        Item eowAx = new Weapon("war axe", "This is your kind of tool! You could probably wield this."); 
        Item eowBtlAx = new Weapon("battle axe", "This like a hand axe, but longer. Better for chopping trees.");
        //-----------------------------FURNITURE--------------------------------
        Furniture eowF = new Floor("It's a sandstone tiled floor.");

        Furniture eow1Dr = new Eow1_Door(Direction.WEST);
        Furniture eow1Rck = new Eow1_Rack(eowSwrd1, eowBtlAx, eowSwrd2, eowSwrd3, eowSwrd2, eowAx);
        Furniture eow1Bskt = new Eow1_Basket(eowPlArm, woodSpr, woodSpr, eowPlArm);
        Furniture eow1Trch = new Torch();

        Furniture eow2Fntn = new Eow2_Fountain();
        Furniture wtr = new Water(wtrBckt);
        Furniture eow2Rck = new Eow1_Rack(eowSwrd1, eowSwrd2, eowSSpr, woodSpr, eowBtlAx);
        Furniture eow2Strs = new Eow2_Stairs(Direction.UP);
        Furniture eow2Blcny = new Eow2_Balcony();
        Furniture eow2Cbnt = new Eow2_Cabinet(bckt, shaMp, shvl, vinegar);
        Furniture eow2Trch = new Torch();

        Furniture eow4F = new Floor("It's a sandstone tiled floor.");
        Furniture eow4Strs = new Eow2_Stairs(Direction.DOWN);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE LIBRARY">
        Furniture lib4Tbl = new Lib4_Table("table", fnnyOrb);
        //-----------------------------THE ROOM---------------------------------
        Room lib2 = new Lib2("in the north library", Id.LIB2);
        Room lib3 = new Lib3("in the south library", Id.LIB3);
        Room lib4 = new Lib4("in the north upper library", Id.LIB4, lib4Tbl);
        Room lib5 = new Lib5("in the south upper library", Id.LIB5);
        //-------------------------------ITEMS----------------------------------
        Item cndl = new Item(CANDLE, "It's a white candle. Must have been burning for some time.");
        Item shs1 = new Shoes(LEATHER_SHOES, "A fancy pair of shiny leather shoes.", 
                                  "You put on the shoes. They're a little big, but comfortable!");
        Item shs2 = new Shoes("worn shoes", "A worn, dull pair of leather shoes.",
                                  "You put on the shoes. These aren't too comfortable.");
        Item shs3 = new Shoes(NIGHT_SLIPPERS, "A brown pair of cotton night slippers.",
                                  "You wear the slippers. You could wear these all day!");
        Item shs4 = new Shoes("work boots", "A rugged pair of boots.",
                                  "You put on the boots. You feel like you're at work.");
        Item fin = new Lib_FinnishBook("language, 'The Essential Finnish'");
        Item bbl = new Lib_GenesisBook("biblical tome, 'The Book of Genesis'");
        Item ody = new Lib_OdysseyBook("epic tome, 'The Odyssey'");
        Item ili = new Lib_IlliadBook("greek tome, 'The Iliad'");
        Item inf = new Lib_DantesInfernoBook("infernal tome, 'Dante's Inferno'");
        Item par = new Lib_ParadiseLostBook("divine tome, 'Paradise Lost'");
        Item bkGlss = new Lib_GlassBook("guide, 'The Master Glasser'");
        Item bkNts = new Lib_NotesBook("self help, 'Note To Self'");
        Item bkGlsswr = new Labo_GlasswareBook("manual, 'You Aren't Chemist'");
        //-----------------------------FURNITURE--------------------------------
        Furniture libLF = new Floor("The floor is a rough, dark blue stone.");
        Furniture libUF = new Floor("The floor is a rough, dark blue stone.");
        Furniture libW = new Wall("A classy mahogany paneled wall. Mahogany, having the highest IQ of any wood");
        Furniture libCch = new Lib_Couch();
        Furniture libBkShlf = new Lib_BookShelf();
        Furniture libScncs = new Lib_Sconces();

        Furniture lib3Stat = new Lib3_Statue(horMed);

        Furniture lib2ShRck = new Lib2_ShoeRack(shs3, shs2, shs1, shs4);
        Furniture lib2Stat = new Lib2_Statue();
        Furniture lib2Frplc = new Lib2_Fireplace(true, bckt);
        Furniture lib2Bttn = new Lib2_Button(lib2Frplc, lib3Stat);
        Furniture lib2WrFr = new Lib2_WarefareShelf(inf, fin);
        Furniture lib2Wndw = new Lib2_Window();

        Furniture lib3Pllr = new Lib_Pillar();
        Furniture lib3Strs = new Lib3_Stairs();
        Furniture lib3Crtn = new Lib3_CreationShelf(ody, bkGlsswr);
        Furniture lib3Blcny = new Lib_Balcony();
        Furniture lib3Wndw = new Lib3_Window();
        Furniture lib3Pntng = new Lib3_Painting();

        Furniture lib4Frplc = new Lib2_Fireplace(true, bckt);
        Furniture lib4Bttn = new Lib4_Button(lib4Frplc, lib3Stat);
        Furniture lib4Prdtn = new Lib4_PerditionShelf(ili, bkNts);
        Furniture lib4Glb = new Lib4_Globe();
        Furniture lib4Stat = new Lib4_Statue();
        Furniture lib4Strs = new Lib4_Stairs();

        Furniture lib5Bnshmnt = new Lib5_BanishmentShelf(bbl);
        Furniture lib5Cndlbr = new Lib5_Candelabra(cndl);

        Furniture lib2Vyg = new Lib2_VoyageShelf(lib2WrFr, lib3Crtn, lib4Prdtn, lib5Bnshmnt, par, bkGlss);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE SECRET ARCHIVES">
        //-----------------------------THE ROOM---------------------------------
        Room lib1 = new Lib1("in the secret archives", Id.LIB1);
        //-------------------------------ITEMS----------------------------------
        Item lib1Schmtc = new Lib1_Schematic("schematic");
        Item lib1Nt2 = new Lib1_Note2("account, page 1");
        Item lib1Nt3 = new Lib1_Note3("journal page 1, Rhadamanthus");
        Item lib1Nt4 = new Lib1_Note4("account, page 2");
        Item lib1Nt5 = new Lib1_Note5("account, page 3");
        Item lib1Nt6 = new Lib1_Note6("account, page 4");
        Item lib1Nt7 = new Lib1_Note7("journal page 2, Rhadamanthus");
        Item lib1ImpNt = new Lib1_ImportantNote("momento- lens");
        Item lib1Pln = new Lib1_Plan("vessel schematic");
        Item brkLns = new Item("cracked lens", "The red-tinted lens is cracked all the way through.", "You think this has lost its purpose by now.");
        Item brssRng = new Item("brass ring", "It's an unhinged shiny brass ring. Looks like a screw is missing.", rdFcs, 3);
        //-----------------------------FURNITURE--------------------------------
        Furniture lib1Docs = new Lib1_Documents();
        Furniture lib1F = new Floor("It's a dusty wood parquet floor.", lib1Nt2);
        Furniture lib1W = new Wall("The walls are just horizontal wood slats.\n");
        Furniture lib1Art = new Lib1_Artifact(blFcs);
        Furniture lib1Dsk = new Lib1_Desk(lib1Art, lib1Schmtc, lib1Nt3, lib1ImpNt);
        Furniture lib1Rg = new Lib1_Rug();
        Furniture lib1Rck = new Lib1_Rack(lib1Nt4, lib1Nt6, lib1Nt5, lib1Nt7);
        Furniture lib1Tbl = new Lib1_Table(lib1Pln);
        Furniture lib1Lght = new Lib1_Light();
        Furniture lib1Mrrr = new Lib1_Mirror();
        Furniture lib1Wndw = new Lib1_Window();
        Furniture lib1Sf = new Lib1_Safe("712", eow3Key, brkLns, brssRng);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE DRAWING ROOM">
        //-----------------------------THE ROOM---------------------------------
        Room drar = new Drar("in the drawing room", Id.DRAR);
        //-------------------------------ITEMS----------------------------------
        Item wine = new Liquid(BOTTLE_OF_WINE, "A very old bottle of red wine. The date says \"1822\"");
        Item rk = new Item("rook", "the small figure resembles a brick tower.", "You have no idea how to play chess.");
        Item knght = new Item("knight", "the small figure resembles a horse.", "You have no idea how to play chess.");
        Item bshp = new Item("bishop", "the small figure resembles... well... a bishop.", "You have no idea how to play chess.");
        Item qn = new Item("queen", "the small figure resembles... well... a queen.", "Isn't this the strongest piece?");
        Item kng = new Item("king", "the small figure resembles... well... a king.", "You have no idea how to play that.");
        Item pwn = new Item("pawn", "the small figure resembles... something.", "This is the weakest piece right? Hmph. Better not ask a chess player that.");
        Item rdBl = new Item(RED_BALL, "It's just a plain, heavy red ball. How in the world do you play with this?", "This is nonsense. Where are the numbers?");
        Item cBl = new Item(CUE_BALL, "It's a plain white ball. This IS the cue ball, right?", "You'd rather break a window with this and jump out rather than play this witchcraft.");
        //-----------------------------FURNITURE--------------------------------
        Furniture drarGhst = new Drar_Ghost(drkFcs, kitcKey, emrld);
        Furniture drarF = new Floor("This room's floor is carpeted lavender with an intricate design.");
        Furniture drarW = new Wall("This is the first time you've seen wallpaper.\nIt's striped vertical in purple and lavender.");
        Furniture drarWndw = new Lib3_Window();
        Furniture drarBr = new Drar_Bar(drarGhst, wine, wine, wine);
        Furniture drarBllrds = new Drar_Billiards(drarGhst, rdBl, cBl, cBl);
        Furniture drarChss = new Drar_Chess(drarGhst, rk, knght, bshp, qn, kng, bshp, knght, rk, pwn, pwn, pwn, pwn, pwn, pwn, pwn, pwn);
        Furniture drarCch = new Drar_Couch(drarGhst);
        Furniture drarTbl = new Drar_Table(drarGhst);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE KITCHEN"> 
        //-----------------------------THE ROOM---------------------------------
        Room kitc = new Kitc("in the kitchen", Id.KITC);
        //-------------------------------ITEMS----------------------------------
        Item spng = new Item("sponge", "A plain old yellow kitchen sponge.");
        Item rtnFrt = new Item("rotten fruit", "Was this an apple? Or ... plum once?", "Whatever you expect him to do with that, he isn't going to.");
        Item petFrt = new Item("petrified vegetable", "Looks like a rock ... in the shape of a carrot.", "Whatever you expect him to do with that, he isn't going to.");
        Item brly = new Item("barley", "It doesn't smell so great. Even grain doesn't keep this long.");
        Item rye = new Item("rye", "It doesn't smell so great. Even grain doesn't keep this long.");
        Item cpprPt = new Weapon(COPPER_POT, "It's small and crudely fashioned. It was definitely hammered into shape.");
        Item cpprPn = new Weapon(COPPER_PAN, "It's an old copper pan, crudely fashioned and hammered into shape.");
        //-----------------------------FURNITURE--------------------------------
        Furniture kitcTrch = new Kitc_Torch();
        Furniture kitcF = new Floor("The floor is dirty brown stone, composed of differently sized crudely cut bricks.");
        Furniture kitcW = new Wall("The wall is made of large, differently sized bricks.");
        Furniture kitcWndw = new Kitc_Window();
        Furniture kitcDr = new Mha3_Door(Direction.WEST);
        Furniture kitcRck = new Kitc_Rack(drwKey, par2Key, dngnKey);
        Furniture kitcPts = new Kitc_Pots(cpprPt, cpprPn, cpprPt, cpprPn, cpprPt, cpprPn);
        Furniture kitcHrth = new Kitc_Hearth(wbalch, wbalch, wbalch, wbalch);
        Furniture kitcBrls = new Kitc_Barrels(brly, brly, brly, rye, rye, rye);
        Furniture kitcPntry = new Kitc_Pantry(rtnFrt, rtnFrt, petFrt, kitcFrtPhy, petFrt);
        Furniture kitcShlf = new Kitc_Shelf(wine, wine, wine, wine, wine, wine, wine);
        Furniture kitcCntr = new Kitc_Cntr(spng, vinegar, vial, vial);   
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE DUNGEON STAIRCASE">
        //-----------------------------THE ROOM---------------------------------
        Room dst1 = new Dst1("in an eerie chamber", Id.DST1);
        //-----------------------------FURNITURE--------------------------------
        Furniture dst1Dr = new Eow1_Door(Direction.EAST);
        Furniture dst1Strs = new Dst1_Stairs(Direction.DOWN);
        Furniture dstW = new Wall("The walls in here are a mossy cobblestone.");
        Furniture dst1F = new Floor("The stone floor is mossy and dank.");
        Furniture dst1Lntrn = new Dst1_Lantern();
        // </editor-fold>

        // </editor-fold>
        // ---------------------------------------------------------------------     
        // <editor-fold defaultstate="collapsed" desc="AREA 4: CASTLE REAR">

        // <editor-fold defaultstate="collapsed" desc="INITIALIZE OBSERVATORY"> 
        //-----------------------------THE ROOM---------------------------------
        Room obs1 = new Obs1("in the observatory", Id.OBS1);
        Room obs2 = new Obs2("on the observatory balcony", Id.OBS2);
        Room obs3 = new Obs3("on the observatory aerie", Id.OBS3);
        //-------------------------------ITEMS----------------------------------  
        Item hlsPlt = new Obs1_Plate("brass plate, \"Sol\"", "The small plate bears an engraving: \"Sol\"");
        Item hrmsPlt = new Obs1_Plate("brass plate, \"Mercury\"", "The small plate bears an engraving: \"Mercury\"");
        Item gaeaPlt = new Obs1_Plate("brass plate, \"Terra\"", "The small plate bears an engraving: \"Terra\"");
        Item aresPlt = new Obs1_Plate("brass plate, \"Mars\"", "The small plate bears an engraving: \"Mars\"");
        Item urnsPlt = new Obs1_Plate("brass plate, \"Caelus\"", "The small plate bears an engraving: \"Caelus\"");
        Item psdnPlt = new Obs1_Plate("brass plate, \"Neptune\"", "The small plate bears an engraving: \"Neptune\"");

        Item rby2 = new Item(RUBY, "The ruby is well cut and clean.");
        Item gr = new Item("small gear", "The small delicate gear fell right out of the telescope.");
        Item glssLns = new Item("glass lens", "The small lens once belonged to the telescope in the observatory.");
        Item mchnPc = new Item("machine piece", "You aren't sure what it does... It's an oddly shaped piece of aluminium.");
        Item obs1Nt = new Obs1_Note("scribbly note");
        Item obsBk = new Obs2_Book("tome, 'Planets and Myth'");
        Item obs2Nt = new Obs2_Note("journal page, Factum");
        Item obs3Nt = new Note("momento: plate locations", "It's only been a day since we discovered that artifact from the well, and\n"
                + "already I don't want to be around it. Perhaps we can hide it in the chandelier up there;\n"
                + "we need a use for that compartment. I'll determine new areas to store those brass plates,\n"
                + "and keep the locations in the picture frame back there...");
        //-----------------------------FURNITURE--------------------------------
        Furniture obs3Chndlr = new Obs3_Chandelier("chandelier", cndl, cndl, cndl, rby2, cndl, cndl);
        Furniture obsStats = new Obs1_Statues(obs3Chndlr);
        Furniture obsSlts = new Obs1_Slots(hlsPlt, obsStats);
        Furniture obsF = new Floor("The floor in here is gray and dark blue checkered tile.");
        Furniture obsW = new Wall("The walls are mahogany wood paneled, with each panel bearing a large round cavity displaying a painted constellation.");
        Furniture obsWndw = new Obs_Window();
        Furniture obs1Strs = new Obs13_Stairs(Direction.UP);
        Furniture obs1Tlscp = new Obs1_Telescope(gr, mchnPc, glssLns);
        Furniture obs1Lmp = new Obs1_Lamp();
        Furniture obs1St = new Obs1_Seat(obs1Nt);

        Furniture obsBlcny = new Obs_Balcony();
        Furniture obs2Strs = new Obs2_Stairs();
        Furniture obs2BkShlf = new Obs2_BkShlf(obsBk, obs2Nt, obs3Nt);
        Furniture obs2Pntng = new Obs2_Painting();
        Furniture obs2Rlng = new Obs2_Railing();
        Furniture obs2Chr = new Obs2_Chair();
        Furniture obs2Tbl = new Bha1_Table(lttrOpnr, pen, ppr);
        Furniture obs2Lmp = new Obs2_Lamp();
        Furniture obs2F = new Floor("The balconies are layed with polished wood.");

        Furniture obs3Strs = new Obs13_Stairs(Direction.DOWN);
        Furniture obs3Chst = new Obs3_Chest(psdnPlt);
        Furniture obs3Tlscps = new Obs3_Telescopes();
        Furniture obs3F = new Floor("The balconies are layed with polished wood.");

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE JADE HALL"> 
        //-----------------------------FURNITURE--------------------------------  
        Furniture jhaLntrn = new Jha_Lantern();
        Furniture jha1Pntng = new Jha1_Painting();
        Furniture jhaF = new Floor("The floor is a polished reddish birch.");
        Furniture jhaW = new Wall("These walls look expensive and one-of-a-kind. The lower third is a reddish birch wainscoting\n"
                                + "and the upper part is solid rock resembling jade or marble.");
        Furniture jhaJd = new Jha_Jade();
        Furniture jha1Ln = new Jha_Lion();
        Furniture jha2Ln = new Jha_Lion();
        //-----------------------------THE ROOM---------------------------------
        Room jha1 = new Jha1("in a jade hallway", Id.JHA1);
        Room jha2 = new Jha2("in a jade hallway", Id.JHA2, jha1Ln, jha2Ln); // Adds hidden door to room

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE GARDENS"> 
        //-----------------------------THE ROOM---------------------------------
        Room gar1 = new Gar1("on a rooftop garden", Id.GAR1);
        Room gar2 = new Gar2("on a rooftop garden", Id.GAR2);
        Room gar3 = new Gar3("on a rooftop garden", Id.GAR3);
        Room gar4 = new Gar4("on a rooftop garden", Id.GAR4);   
        //-------------------------------ITEMS----------------------------------
        Item hose = new Item(LEATHER_HOSE, "The roughly 30-foot old hose is cracked and rotted. It's certainly non-functional, but is still sturdy.");
        Item brknHose = new Item("broken hose", "The hose has broken in half, but it served a worthy final purpose.");
        Item hoe = new Item(HOE, "A rusty iron hoe for gardening.");
        Item trowel = new Item(TROWEL, "It's a small handheld shovel.");
        //-----------------------------FURNITURE-------------------------------- 
        Furniture gar13Plntr = new Gar13_Planter(sl, mndrkBlb, sl);
        Furniture gar1Stat = new Gar1_Statue();
        Furniture gar2BrknHose = new Gar2_BrokenHose();
        Furniture gar2Hs = new Gar2_Hose(gar2BrknHose, brknHose);
        Furniture gar2Hl = new Gar2_Hole(gar2Hs);
        Furniture garF = new Floor("The floor out here is made of large shale slabs. It's a miracle this castle's architecture can hold this area up.");
        Furniture gar2Clmn = new Gar2_Columns();
        Furniture gar2Dm = new Gar2_Dome();
        Furniture gar3Chst = new Gar3_Chest(hoe, trowel, hose, sd);
        Furniture gal3Fntn = new Gal3_Fountain();
        Furniture gar4Plq = new Gar4_Plaque();
        Furniture gar4Plntr = new Gar4_Planter(gar4Plq, urnsPlt, urnsPlt, sl, sl);
        Furniture gar24Scnc = new Gar24_Sconce();

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE PARLOR"> 
        //-----------------------------THE ROOM---------------------------------
        Room par2 = new Par2("on the parlor loft", Id.PAR2);
        Room par1 = new Par1("in the first floor parlor", Id.PAR1); 
        //-------------------------------ITEMS----------------------------------   
        Item bttl = new Item(GLASS_BOTTLE, "It's a regular clear glass bottle.");
        Item enchntdBttl = new Item("enchanted bottle", "The bottle is now coated in glowing... stuff");
        Item stlWr = new Item("steel wire", "It's some broken piano wire.");
        Item hndDrll = new Item(HAND_DRILL, "It's a drill for boring holes in wood.\n"
                              + "You can drill into almost anything you want now!");
        Item fthr = new Item(RAVEN_FEATHER, "It's a long, elegant feather.");
        Item athr = new Item(AETHER_VIAL, "This looks expensive!");
        Item frSlts = new Item(FIRE_SALTS, "Seems to be just red ashes...");
        Item parNt = new Par_VialNote("note: vials");
        Item parBkMndrk = new Par_MandrakeBook("tome, 'The Care of Mandragora'");
        Item parBkEncht = new Par_EnchantingBook("tome, 'Enchanting for the Naive'");
        Item parNtBttl = new Par_BottleRecipe("'Novice Enchanting: Bottles'");
        Item parNtShs = new Par_ShoeRecipe("'Novice Enchanting: Footwear'");
        Item parNtWpn = new Par_WeaponRecipe("'Expert Enchanting: Weaponry'");
        Item parNtKey = new Par_KeyRecipe("'Expert Enchanting: Skeleton Keys'");
        Item parLchNt = new Note("note: binding","I think the binding worked... Part of my soul, and this book, are one. The book will be stored in\n"
                               + "Rhadamanthus' safe in the study, he won't be needing it anymore. Don't forget where! The book said not to.");
        //-----------------------------FURNITURE--------------------------------  
        Furniture parLft = new Par_Loft();

        Furniture par1Orb = new Par1_Orb();
        Furniture par1F = new Floor("It's a sandstone tiled floor.");
        Furniture par1FrPlc = new Par1_FirePlace(bckt);
        Furniture par1Dr = new Par1_Door(enchntdBttl, Direction.NORTH);
        Furniture par1EnchntTbl = new Par1_EnchantingTable(enchntdBttl, bttl, chs1Key, parLchNt);
        Furniture par1Strs = new Par_Stairs(Direction.UP);
        Furniture par1Pllrs = new Par1_Pillars();
        Furniture par1Hrp = new Par1_Harp(par1Orb);
        Furniture par1Shlf = new Wow3_Shelf(fthr, hndDrll, athr, parBkEncht, frSlts);
        Furniture par1Cshn = new Par1_Cushion(aresPlt);

        Furniture par2F = new Floor("It's a sandstone tiled floor.");
        Furniture par2Wndw = new Par2_Window();
        Furniture par2Strs = new Par_Stairs(Direction.DOWN);
        Furniture par2Bwl = new Par2_Bowl();
        Furniture par2Frplc = new Par2_Fireplace();
        Furniture par2Pno = new Par2_Piano(par1Orb, stlWr);
        Furniture par2Shlf = new Wow3_Shelf(vial, parNt, parNtShs, parNtWpn, parNtBttl, parBkMndrk, parNtKey, gaeaPlt);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE SECRET STAIRS"> 
        //-----------------------------THE ROOM---------------------------------
        Room sst1 = new Sst1("in the secret stairwell", Id.SST1);
        Room sst2 = new Sst2("on a small landing", Id.SST2);  
        //-----------------------------FURNITURE--------------------------------  
        Furniture sst1Strs = new Sst_Stairs(Direction.UP);
        Furniture sst2Strs = new Sst_Stairs(Direction.DOWN);
        Furniture sstLndng = new Sst_Landing();
        Furniture sst1F = new Floor("The flooring in here is rudimentary. Just gray weathered planks of wood.");
        Furniture sst2F = new Floor("The flooring in here is rudimentary. Just gray weathered planks of wood.");
        Furniture sstWndw = new Sst_Window();
        Furniture sst1Dr = new Jha_HiddenDoor(Direction.EAST);
        Furniture sst2Dr = new Sst_Door(Direction.EAST);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE LABORATORY"> 
        //-----------------------------THE ROOM---------------------------------
        Room labo = new Labo("in the laboratory", Id.LABO);
        //-------------------------------ITEMS---------------------------------- 
        Item rbbrTube = new Item(RUBBER_HOSE, "It's a yellow rubber hose, about 8 feet long.");
        Item tstTb = new Item(TEST_TUBE, "A glass tube for transferring liquids.");
        Item bkr = new Item(BEAKER, "It's just an empty glass beaker for quick measuring.");
        Item strkr = new Item(STRIKER, "It's a metal tool for creating sparks.");
        Item scale = new Item("scale", "A machine for the weighing of things.");
        Item balance = new Item("balance", "You seem to remember these being called triple-beam balances in middle school.", "Oh boy! You could weigh just about anything with this!");
        Item flrcFlsk = new Item(FLORENCE_FLASK, "It's a piece of chemistry glassware. Has a bulbous bottom and a thin shaft");
        Item laboCtNt = new Labo_CoatNote("scientist momento");
        Item laboBrnrBk = new Labo_BurnerManual("manual, 'Playing With Fire'");
        Item laboRcp = new Labo_PhaseDoorRecipe("phase door potion recipe");
        Item laboIngNt = new Labo_IngredientsNote("note: missing ingredients");
        Item labDstllrNt = new Labo_DistillerNote("note: contraption");
        //-----------------------------FURNITURE--------------------------------  
        Furniture iceBrrl = new Labo_DryIce(flrcFlsk);
        Furniture laboRck = new Labo_Shelf(vial, laboRcp, tstTb, laboIngNt, vial, tstTb, bkr, tstTb, laboBrnrBk, actn);
        Furniture laboGsPipe = new Labo_GasPipe();
        Furniture cndsr = new Labo_Condenser(bkr);
        Furniture laboDstllr = new Labo_Distiller(laboGsPipe, cndsr, tstTb, vial);
        Furniture laboDspnsrs = new Labo_Dispensers(vial, tstTb);
        Furniture laboBrtt = new Labo_Burette(vial, tstTb);
        Furniture laboStpCck = new Labo_StopCock();
        Furniture laboF = new Floor("It's black and white checkered tile. A predictable floor for a laboratory.", tstTb);
        Furniture laboSnk = new Labo_Sink(vial, bkr);
        Furniture laboCntrptn = new Labo_Contraption();
        Furniture laboTbl = new Labo_Table();
        Furniture laboDvcs = new Labo_Devices();
        Furniture laboCntr = new Labo_Counter(strkr, labDstllrNt, scale, rbbrTube, laboCtNt, balance);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE ATTIC"> 
        Furniture lqu1Chst = new Lqu1_Chest();
        //-----------------------------THE ROOM---------------------------------
        Room att1 = new Att1("in the attic", Id.ATT1, lqu1Chst.getInv());       
        Room att2 = new Att2("in the attic", Id.ATT2);    
        //-----------------------------FURNITURE--------------------------------  
        Furniture attW = new Wall("The gray wood plank walls in here angle up forming a roof.");
        Furniture attF = new Floor("The flooring in here is rudimentary. Just gray weathered planks of wood.");
        Furniture att2Dr = new Sst_Door(Direction.WEST);
        Furniture attCss = new Att_Cases();
        Furniture attBxs = new Att_Boxes();
        Furniture attVnts = new Att_Vents();
        Furniture attClng = new Att_Ceiling();
        Furniture att2CtCs = new Att2_LabCoatCase();

        // </editor-fold>        
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE BACK HALL"> 
        //-----------------------------THE ROOM---------------------------------
        Room bha1 = new Bha1("in a demonic hallway", Id.BHA1);
        Room bha2 = new Bha2("somewhere in the hallway", Id.BHA2);
        Room bha3 = new Bha3("in a demonic hallway", Id.BHA3);
        //-------------------------------ITEMS----------------------------------   
        Item tblLg = new Weapon("broken table leg", "A short wooden post about 3 feet long. It looks like it belonged to a table.");
        Item orgMttr = new Item("organic matter", "You can't tell what it is. It has a non-solid texture and feels organic.");
        Item bhaNt = new Bha_Note("note: plates");
        //-----------------------------FURNITURE--------------------------------  
        Furniture bha1Hrzn = new Bha1_Horizon();
        Furniture bha1Plnt = new Bha1_Plant(sl);
        Furniture bha1Tbl = new Bha1_Table(hrmsPlt);
        Furniture bhaW = new Wall("The walls are covered in a brown and red vertically striped wallpaper with wainscoting on the bottom.");
        Furniture bha1F = new Floor("The wood-plank floor bends with the hallway. Some of the planks have pryed themselves loose because of it");

        Furniture bha2F = new Floor("The floor has changed. Most of the wood planks have been removed\n"
                                  + "revealing a dirt-like ground below... But it's not dirt.", wbalsp, wbalch, orgMttr, orgMttr, tblLg, wbalsp);
        Furniture bha2W = new Wall("The walls are still intact, though some of the wallpaper has been ripped off, revealing wood planks.");
        Furniture bha2Frm = new Bha2_Frame(gal5CbtKey, bhaNt);

        Furniture bha3Wndw = new Bha3_Window();
        Furniture bha3F = new Floor("The wood-plank floor bends with the hallway. Some of the planks have pryed themselves loose because of it.");

        // </editor-fold>

        // </editor-fold>
        // ---------------------------------------------------------------------     
        // <editor-fold defaultstate="collapsed" desc="AREA 5: SUB-LEVELS">

        Furniture sewDrN = new Sew_Door(Direction.NORTH);
        Furniture sewDrS = new Sew_Door(Direction.SOUTH);
        Furniture sewDrE = new Sew_Door(Direction.EAST);
        Furniture sewDrW = new Sew_Door(Direction.WEST);   
        Furniture dngnW = new Wall("The walls are rough gray stone brick, covered in moss and wet to the touch from the humid air.");
        Furniture dungMonst = new DungeonMonsterFurniture();

        // Dungeon
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE TUNNELS">
        Item pipePc = new Weapon(PIECE_OF_PIPE, "It's a piece of metal piping, about 2 feet long.");
        Furniture sew1Rvr = new Sew1_River(pipePc, wtrBckt);
        Furniture sew4Pp = new Sew4_Pipe(sew1Rvr, pipePc); // RESETABLE
        //-----------------------------THE ROOMS--------------------------------
        Room sew0 = new Sew0("at the tunnel's end", Id.SEW0);
        Room sew1 = new Sew1("in an underground tunnel", Id.SEW1);
        Room sew2 = new Sew2("in an underground tunnel", Id.SEW2);
        Room sew3 = new Sew3("in an underground tunnel", Id.SEW3);
        Room sew4 = new Sew4("in an underground tunnel", Id.SEW4, sew4Pp);
        Room sew5 = new Sew5("at the tunnel's end", Id.SEW5);
        //-----------------------------FURNITURE-------------------------------- 
        Furniture sewF = new Dungeon_Floor();

        Furniture sewTnnl = new Sew_Tunnel();
        Furniture sewRvr = new Sew2345_River(sew1Rvr.getInv(), wtrBckt);
        Furniture sewMss = new Sew_Moss();

        Furniture sew0Trch = new Torch();
        Furniture sew0Strs = new Sew0_Stairs();

        Furniture sew15Gt = new Sew15_Gate();
        Furniture sew1Trch = new Torch();

        Furniture sew2Vlvs = new Sew2_Valves(); // RESETABLE
        Furniture sew2Trch = new Torch();
        Furniture sew2BrdgW = new Sew_Bridge(Direction.WEST);
        Furniture sew2Pp = new Sew235_Pipe(2);

        Furniture sew3Trch = new Torch();
        Furniture sew3BrdgN = new Sew_Bridge(Direction.NORTH);
        Furniture sew3BrdgE = new Sew_Bridge(Direction.EAST);
        Furniture sew3Pp = new Sew235_Pipe(3);

        Furniture sew4Trch = new Torch();

        Furniture sew5Trch = new Torch();
        Furniture sew5BrdgE = new Sew_Bridge(Direction.EAST);
        Furniture sew5Pp = new Sew235_Pipe(5);
        Furniture sew5Vlv = new Sew5_Valve(sew2Vlvs, sew4Pp);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE ANCIENT CISTERN">
        //-----------------------------THE ROOMS--------------------------------
        Room cis1 = new Cis1("in a huge cistern", Id.CIS1); // RESETABLE
        Room cis2 = new Cis2("in a huge cistern", Id.CIS2);
        Room cis3 = new Cis3("in a huge cistern", Id.CIS3);
        Room cis4 = new Cis4("in a huge cistern", Id.CIS4); 
        //-----------------------------FURNITURE-------------------------------- 
        Furniture cis1Trch = new Torch();
        Furniture cis3Trch = new Torch();
        Furniture cis4Trch = new Torch();
        Furniture cisF = new Dungeon_Floor();
        Furniture cisWtr = new Cis_Water(wtrBckt);
        Furniture cisClmns = new Cis_Columns();
        Furniture cisDrknss = new Cis_Darkness();

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE TORTURE CHAMBER">
        //-----------------------------THE ROOM---------------------------------
        Room torc = new Torc("in a torture chamber", Id.TORC);
        //-----------------------------FURNITURE-------------------------------- 
        Furniture torcF = new Dungeon_Floor();
        Furniture torcTrchs = new Torch();
        Furniture torcSwhrses = new Torc_Sawhorses(torc); // RESETABLE
        Furniture torcRck = new Torc_Rack();
        Furniture torcCgs = new Torc_Cages();
        Furniture torcWhl = new Torc_Wheel();
        Furniture torcWd = new Torc_Wood();
        Furniture torcTls = new Torc_Tools();
        Furniture torcScythF = new Torc_ScytheFurniture(); // RESETABLE

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE CRYPT">
        //-----------------------------THE ROOM---------------------------------
        Room cry2 = new Cry2("in the crypt", Id.CRY2);
        Room cry1 = new Cry1("in the crypt", Id.CRY1);
        //-------------------------------ITEMS----------------------------------      
        Item drdFlwr = new Item("dried flower", "It's a brown, dried-up rose.");
        Item ncklc = new Item("silver necklace", "A fine necklace made of silver. A blue jewel dangles from it.");
        Item brnzCn = new Item("bronze coin", "It's some sort of extinct or exotic currency.");
        //-----------------------------FURNITURE-------------------------------- 
        Furniture cryF = new Dungeon_Floor();
        Furniture cryDummy = new Cry_Dummy();
        Furniture cryDrwrs = new Cry_Drawers();
        Furniture cry1Crvng = new Cry1_Carving();
        Furniture cryLghts = new Cry_Lights();
        Furniture cry2Engrvng = new Cry2_Engraving();
        Furniture cry2Altr = new Cry2_Altar(drdFlwr, ncklc, brnzCn, brnzCn);
        Furniture cry1Stat = new Cry1_Statue(torcScythF); // RESETABLE
        Furniture cry2Psswd = new Cry2_Password(cry1Stat);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE CELL">
        //-----------------------------THE ROOM---------------------------------
        Room intr = new Intr("in a noisy chamber", Id.INTR);      
        //-----------------------------FURNITURE-------------------------------- 
        Furniture intrF = new Intr_Floor(); // RESETABLE
        Furniture intrGrt = new Intr_Grate(); // RESETABLE
        Furniture intrTrch = new Intr_Torch(); // RESETABLE
        Furniture intrWhl = new Intr_Wheel();
        Furniture intrGrs = new Intr_Gears();
        Furniture intrDr = new Intr_Door();
        Furniture intrWtr = new Intr_Water();

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE SUB-TUNNELS">
        //-----------------------------THE ROOMS--------------------------------
        Room esc1 = new Esc1("in a small tunnel", Id.ESC1);
        Room esc2 = new Esc("in a small tunnel", Id.ESC2, "The tunnel turns sharply to the north here.");
        Room esc3 = new Esc("in a small tunnel", Id.ESC3, "The small tunnel turns yet again back to the east here.");
        Room esc4 = new Esc("in a small tunnel", Id.ESC4, "The crammed hallway continues to the east here.");
        Room esc5 = new Esc("in a small tunnel", Id.ESC5, "The tunnel turns sharply to the south here.");
        Room esc6 = new Esc("in a small tunnel", Id.ESC6, "You've reached the tunnel's end. In front of you is a metal ladder leading up.");       
        //-----------------------------FURNITURE-------------------------------- 
        Furniture esc1Lddr = new Esc1_Ladder(); // RESETABLE
        Furniture esc6Grt = new Esc6_Grate(); // RESETABLE
        Furniture esc6Lddr = new Esc6_Ladder(esc6Grt); // RESETABLE

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE CATACOMBS ACCESS">
        //-----------------------------THE ROOM---------------------------------
        Room cas1 = new Cas1("in catacombs access", Id.CAS1);      
        //-----------------------------FURNITURE-------------------------------- 
        Furniture casW = new Wall("The walls are large granite blocks illuminated in a flickering bluish hue from the flame.");
        Furniture casStrs = new Cas_Stairs(Direction.DOWN);
        Furniture casF = new Floor("The floor is comprised of many large blocks, illuminated blue from the fire.");

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE OUBLIETTE">
        //-----------------------------THE ROOM---------------------------------
        Room oub1 = new Oub1("in an oubliette", Id.OUB1);       
        //-----------------------------FURNITURE--------------------------------  
        Furniture oub1F = new Dungeon_Floor();
        Furniture oub1Pt = new Oub1_Pit();

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE PRISON">
        //-----------------------------THE ROOM---------------------------------
        Room pris = new Pris("in some kind of prison", Id.PRIS);
        //-------------------------------ITEMS----------------------------------   
        Item prisNt = new Pris_Note("barely legible note");
        //-----------------------------FURNITURE--------------------------------  
        Furniture prisClls = new Pris_Cells();
        Furniture prisF = new Dungeon_Floor();
        Furniture prisCndlbrs = new Pris_Candelabra(cndl);
        Furniture prisTbl = new Pris_Table(ou62Key, prisNt);
        Furniture prisGts = new Pris_Gates();
        Furniture prisCbnt = new Pris_Cabinet();

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE DUNGEON KEEPER CHAMBER">
        //-----------------------------THE ROOM---------------------------------
        Room dkch = new Dkch("in the dungeon-keeper's chamber", Id.DKCH);
        //-------------------------------ITEMS---------------------------------- 
        Item dkchNt = new Dkch_Note("short verse");
        Item lngChn = new Weapon("chain", "It's a chain, about 10 feet long.");
        Item dkchNt2 = new Note("illegible note", "This note is gibberish. Unreadable.");
        //-----------------------------FURNITURE-------------------------------- 
        Furniture dkchF = new Dungeon_Floor();
        Furniture dkchBd = new Dkch_Bed(lngChn);
        Furniture dkchAxl = new Dkch_Axle();
        Furniture dkchDsk = new Dkch_Desk(dkchNt, dkchNt2);
        Furniture dkchClng = new Dkch_Ceiling();

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE STRANGE POOL">
        Furniture[] resetables = {intrF, intrGrt, intrTrch, sew2Vlvs, torcSwhrses,
                torcScythF, cry1Stat, esc6Grt, sew4Pp, esc6Lddr};
        //-----------------------------THE ROOM---------------------------------
        Room sewp = new Sewp("next to a pool of water", Id.SEWP, prisCbnt.getInv(), resetables);        
        //-----------------------------FURNITURE--------------------------------  
        Furniture sewpCl = new Sewp_Ceiling();
        Furniture sewpGrt = new Sewp_Grate();
        Furniture sewpWtr = new Sewp_Water(wtrBckt);
        Furniture sewpTrch = new Torch();
        Furniture sewpF = new Dungeon_Floor();
        Furniture sewpTnnl = new Sewp_Tunnel();

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE ANCIENT ARCHIVES">
        //-----------------------------THE ROOM---------------------------------
        Room aarc = new Aarc("in ruined archives", Id.AARC);
        //-------------------------------ITEMS----------------------------------
        Item algBk = new Item("algae covered book", "The book is wet and slimy. Its pages have nearly fused.", "This is completely unreadable.");
        Item rndBk = new Item("ruined book", "This book is damp, moldy, and covered in dirt.", "Whatever knowledge this book held is now lost.");
        Item stnBlck = new Item(STONE_BLOCK, "This is a piece of the now broken floor in the ancient archives.");
        Item slmyAlg = new Item("slimy algae", "Ugh... why are you holding this?");
        Item aarcNt = new Aarc_Note("note: Factum");
        //-----------------------------FURNITURE--------------------------------  
        Furniture aarcAlg = new Aarc_Algae(slmyAlg);
        Furniture aarcBks = new Aarc_Books(rndBk, algBk, slmyAlg, rndBk);
        Furniture aarcChndlr = new Aarc_Chandelier();
        Furniture aarcDsk = new Aarc_Desk(wbalch, archKey, aarcNt, rndBk);
        Furniture aarcF = new Aarc_Floor(algBk, wbalch, stnBlck, algBk, slmyAlg, algBk, stnBlck);
        Furniture aarcW = new Aarc_Wall();
        Furniture aarcWd = new Aarc_Wood(wbalch);
        Furniture aarcShlvs = new Aarc_Shelves(slmyAlg, wbalch, wbalch);

        // </editor-fold>

        // Catacombs and caves
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE CATACOMBS"> 
        // ROOMS --------------------------------------------------------------
        Room cs35 = new Cs35("at the catacombs entrance", Id.CS35);
        Room ou62 = new Ou62("in the bottom of the oubliette", Id.OU62);
        Room my18 = new My18("in a round sandstone chamber", Id.MY18);

        Room tm16 = new Tmb1(Id.TM16);
        Room tm66 = new Tmb2(Id.TM66);
        Room tm32 = new Tmb3(Id.TM32);

        Room an55 = new An55("in an ancient tomb", Id.AN55);
        Room an65 = new An65("in an ancient tomb", Id.AN65);

        Room ct11 = new Catacomb(Id.CT11); Room ct12 = new Catacomb(Id.CT12);
        Room ct13 = new Catacomb(Id.CT13); Room ct14 = new Catacomb(Id.CT14);
        Room ct15 = new Catacomb(Id.CT15); Room ct17 = new Catacomb(Id.CT17);
        Room ct21 = new Catacomb(Id.CT21); Room ct22 = new Catacomb(Id.CT22);
        Room ct23 = new Catacomb(Id.CT23); Room ct24 = new Catacomb(Id.CT24);
        Room ct25 = new Catacomb(Id.CT25); Room ct26 = new Catacomb(Id.CT26);
        Room ct27 = new Catacomb(Id.CT27); Room ct28 = new Catacomb(Id.CT28);
        Room ct31 = new Catacomb(Id.CT31); Room ct33 = new Catacomb(Id.CT33);
        Room ct34 = new Catacomb(Id.CT34); Room ct36 = new Catacomb(Id.CT36);
        Room ct37 = new Catacomb(Id.CT37); Room ct38 = new Catacomb(Id.CT38);
        Room ct41 = new Catacomb(Id.CT41); Room ct42 = new Catacomb(Id.CT42);
        Room ct43 = new Catacomb(Id.CT43); Room ct44 = new Catacomb(Id.CT44);
        Room ct45 = new Catacomb(Id.CT45); Room ct46 = new Catacomb(Id.CT46);
        Room ct47 = new Catacomb(Id.CT47); Room ct48 = new Catacomb(Id.CT48);
        Room ct51 = new Catacomb(Id.CT51); Room ct52 = new Catacomb(Id.CT52);
        Room ct53 = new Catacomb(Id.CT53); Room ct54 = new Catacomb(Id.CT54);
        Room ct56 = new Catacomb(Id.CT56); Room ct57 = new Catacomb(Id.CT57);
        Room ct58 = new Catacomb(Id.CT58); Room ct61 = new Catacomb(Id.CT61);
        Room ct63 = new Catacomb(Id.CT63); Room ct64 = new Catacomb(Id.CT64);
        Room ct67 = new Catacomb(Id.CT67); Room ct68 = new Catacomb(Id.CT68);

        Room[] list = {ct11, ct12, ct13, ct14, ct15, ct17, ct21, ct22, ct23,
                       ct24, ct25, ct26, ct27, ct28, ct31, ct33, ct34, ct36,
                       ct37, ct38, ct41, ct42, ct43, ct44, ct45, ct46, ct47, 
                       ct48, ct51, ct52, ct53, ct54, ct56, ct57, ct58, ct61, 
                       ct63, ct64, ct67, ct68};

        //-------------------------------ITEMS----------------------------------
        Item coin = new Item("stone coins", "A small collection of ancient coins. Many archaic markings decorate their surfaces, with holes bored in the centers.", "Where do you expect to spend these?");
        Item ring = new Item("bronze ring", "It's a tarnished ring. Some of the tarnish rubs off and stains your hand green.", "Now is not the time for dress-up.");
        Item nckLc = new Item("beaded neclace", "A lackluster necklace made with wooden beads.", "Now is not the time for dress-up.");
        Item jwl = new Item(IRIDESCENT_JEWEL, "The polished stone feels warm to the touch, and is constantly shifting color among red, black, and green.");
            String medString = "It's an archaic stone key. It has a disc-shaped head and a long protruding shaft bearing a few large teeth. ";
        Item med1 = new Item(KEY_OF_ANCESTRY, medString + "Engraved on its head is a depiction of the sun.");
        Item med2 = new Item(KEY_OF_INTELLECT, medString + "An eye is engraved on its head.");
        Item med3 = new Item(KEY_OF_CONTINUITY, medString + "The number '8' is engraved on its head.");
            Random rand = new Random();
            int index = rand.nextInt(list.length);
            list[index].getFurnishings().get(0).getInv().add(jwl);  
            int y = Math.abs(list[index].getCoords()[1] - 7);
            String result = (list[index].getCoords()[2] + ", " + y + ", " + -2);
        Item tmbNt = new Note("torn parchment", "In the center, written in large scribbly handwriting are the numbers: \"" + result + "\".");
        Item strw = new Item("straw", "It's just a handful of straw.");
        //-----------------------------FURNITURE-------------------------------- 
        Furniture catDrN = new Ct_Door(Direction.NORTH);
        Furniture catDrS = new Ct_Door(Direction.SOUTH);
        Furniture catDrE = new Ct_Door(Direction.EAST);
        Furniture catDrW = new Ct_Door(Direction.WEST);

        // Tombs
        Furniture tmb1Cskt = new Tmb1_Casket(med1);
        Furniture tm1Vs = new Tmb_Vases(coin, ring, coin, coin);
        Furniture tm1Bwl = new Tmb1_Bowl();
        Furniture tm1Effgy = new Tmb1_Effigy();
        Furniture tmb2Cskt = new Tmb2_Casket(med2);
        Furniture tm2Vs = new Tmb_Vases(nckLc, coin, coin, ring);
        Furniture tm2Orb = new Tmb2_Light();
        Furniture tmb3Cskt = new Tmb3_Casket(med3);
        Furniture tm3Vs = new Tmb_Vases(coin, coin, coin, nckLc);
        Furniture tm3Tpstry = new Tmb3_Tapestry();
        Furniture tm3Cndl = new Tmb3_Cndl();
        Furniture tm1F = new Floor("It's a damp dirt floor.");
        Furniture tm2F = new Floor("It's a damp dirt floor.");
        Furniture tm3F = new Floor("It's a damp dirt floor.");
        Furniture catW = new Wall("The walls are wet and rocky.");

        // Oubliette
        Furniture oubStrw = new Ou62_Straw();
        Furniture oubSpk = new Ou62_Spike();
        Furniture oub2F = new Dungeon_Floor(strw, strw, strw);

        // Ancient tomb
        Furniture antNPC = new Ant_Zombie();
        Furniture antCskt = new Ant_Casket(tmbNt);
        Furniture antF = new Floor("The floor in here is dusty sandstone.");
        Furniture antW = new Wall("They are carved sandstone.");
        Furniture antCskts = new Ant_Caskets();
        Furniture ant1Trch = new Torch();
        Furniture ant2Trch = new Torch();
        Furniture antClng = new Ant_Ceiling();

        // Round chamber
        Furniture my18F = new Floor("The floor is brick with a round seam circling around the central pedestal.");
        Furniture my18Pdstl = new My18_Pedestal();
        Furniture my18Clng = new My18_Ceiling();

        // Catacomb entrance
        Furniture cs35Dr = new Cs35_Door(Direction.WEST);
        Furniture ct34Dr = new Cs35_Door(Direction.EAST);
        ct34.removeFurniture(ct34.getFurnishings().get(0)); // Removes old door from catacombs.
        Furniture cs35F = new Floor("The floor is comprised of many large blocks, illuminated blue from the fire.");
        Furniture cs35Trchs = new Cs35_Torches();
        Furniture cs35Stat = new Cs35_Statue();
        Furniture cs35Strs = new Cas_Stairs(Direction.UP);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE CAVES"> 
        //-----------------------------THE ROOMS--------------------------------
        Room cv34 = new CV34("at an ancient well", Id.CV34);
        Room ms65 = new Deep_Chamber("aykl xvldml fwe", Id.MS65);
        Room ms66 = new Deep_Chamber("d5 rl x:!e ifxJ", Id.MS66);

        Room cv18 = new Cave(Id.CV18); Room cv11 = new Cave(Id.CV11);
        Room cv12 = new Cave(Id.CV12); Room cv13 = new Cave(Id.CV13);
        Room cv14 = new Cave(Id.CV14); Room cv15 = new Cave(Id.CV15);
        Room cv16 = new Cave(Id.CV16); Room cv17 = new Cave(Id.CV17);
        Room cv21 = new Cave(Id.CV21); Room cv22 = new Cave(Id.CV22);
        Room cv23 = new Cave(Id.CV23); Room cv24 = new Cave(Id.CV24);
        Room cv25 = new Cave(Id.CV25); Room cv26 = new Cave(Id.CV26);
        Room cv27 = new Cave(Id.CV27); Room cv28 = new Cave(Id.CV28);
        Room cv31 = new Cave(Id.CV31); Room cv32 = new Cave(Id.CV32);
        Room cv33 = new Cave(Id.CV33); Room cv35 = new Cave(Id.CV35);
        Room cv36 = new Cave(Id.CV36); Room cv37 = new Cave(Id.CV37);
        Room cv38 = new Cave(Id.CV38); Room cv41 = new Cave(Id.CV41);
        Room cv42 = new Cave(Id.CV42); Room cv43 = new Cave(Id.CV43);
        Room cv44 = new Cave(Id.CV44); Room cv45 = new Cave(Id.CV45);
        Room cv46 = new Cave(Id.CV46); Room cv47 = new Cave(Id.CV47);
        Room cv48 = new Cave(Id.CV48); Room cv51 = new Cave(Id.CV51);
        Room cv52 = new Cave(Id.CV52); Room cv53 = new Cave(Id.CV53);
        Room cv54 = new Cave(Id.CV54); Room cv55 = new Cave(Id.CV55);
        Room cv56 = new Cave(Id.CV56); Room cv57 = new Cave(Id.CV57);
        Room cv58 = new Cave(Id.CV58); Room cv61 = new Cave(Id.CV61);
        Room cv62 = new Cave(Id.CV62); Room cv63 = new Cave(Id.CV63);
        Room cv67 = new Cave(Id.CV67); Room cv68 = new Cave(Id.CV68);
        Room cv64 = new Cave(Id.CV64);
        //-----------------------------FURNITURE-------------------------------- 
        Furniture cv18Strs = new My18_Stairs(Direction.UP);
        Furniture omnDr = new OminousDoor(Direction.EAST);
        Furniture dmmyFurniture = new Dummy_Furniture();
        Furniture factum = new FactumDummy(factumPhy);
        Furniture cvWell = new Cv_Well();
        // </editor-fold>

        // </editor-fold>
        // ---------------------------------------------------------------------     
        // <editor-fold defaultstate="collapsed" desc="AREA 6 VAULT">

        // <editor-fold defaultstate="collapsed" desc="INITIALIZE CHAPEL STAIRS"> 
        //-----------------------------THE ROOM---------------------------------
        Room chs1 = new Chs1("in the chapel stairwell", Id.CHS1);  
        Room chs3 = new Chs3("on the tower's top landing", Id.CHS3);  
        //-----------------------------FURNITURE-------------------------------- 
        Furniture chsWndws = new Chs_Windows("windows");
        Furniture chsW = new Wall("The white and pale orange paneled wall is decorated in gold lining.");

        Furniture chs1Strs = new Chs1_Stairs(Direction.UP);
        Furniture chs1F = new Floor("The dark red carpet covers the whole floor. It's a bit dusty from neglect.");
        Furniture chs1Stat = new Chs1_Statue("statue");

        Furniture chs3Strs = new Chs1_Stairs(Direction.DOWN);
        Furniture chs3F = new Floor("The dark red carpet covers the whole floor. It's a bit dusty from neglect.");

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE CHAPEL"> 
        //-----------------------------THE ROOM---------------------------------
        Room cha1 = new Cha1("in the chapel nave", Id.CHA1);
        Room cha2 = new Cha2("at the chancel altar", Id.CHA2);
        //-------------------------------ITEMS---------------------------------- 
        Item chaNt = new Cha_Note("malevolent note");
        Item gldUrn = new Item("gold urn", "the stone urn is fitted with a gold plate depicting a shining chalice.");
        //-----------------------------FURNITURE-------------------------------- 
        Furniture chaF = new Floor("The floor is made of dark, dusty floorboards.");
        Furniture chaW = new Wall("The walls are mostly carved wood paneling. Several religious scenes are painted at fixed distances along the wall.");
        Furniture chaPws = new Cha_Pews();
        Furniture chaHz = new Cha_Haze();
        Furniture chaCrpt = new Cha_Carpet();
        Furniture chaWndws = new Cha_Windows();
        Furniture chaClng = new Cha_Ceiling();

        Furniture cha1Cylx = new Cha1_Cylix();
        Furniture cha1Wtr = new Cha1_Water(hlyWtr);
        Furniture cha1Cndlbr = new Cha1_Candelabra(cndl);

        Furniture cha2Alt = new Cha2_Altar(gldUrn, chaNt);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE VAULT">  
        Furniture vau1Tbl = new Vau1_Table(vauChlPhy, bal1Key);
        //-----------------------------THE ROOM---------------------------------
        Room vau1 = new Vau1("in the vault", Id.VAU1, vau1Tbl);
        Room vau2 = new Vau2("in the vault", Id.VAU2, vau1Tbl);
        Room vaue = new Vaue("in front of a curious wall", Id.VAUE);
        //-------------------------------ITEMS---------------------------------- 
        Item grl = new Item("grail", "It's treasure. A gold-plated grail studded with rubies. Where is all this from?");
        Item cns = new Item("coins", "It's treasure. A handful of golden coins... Not currency you've ever seen though.");
        Item crwn = new Item("crown", "It's treasure. It's the crown of a king. But the crown of whom exactly?");
        Item brclt = new Item("bracelet", "It's treasure. A jade bracelet.");
        Item rng = new Item("ring", "It's treasure. It's a small bronze ring set with an aquamarine.");
        Item dmnd = new Item("diamond", "It's treasure. A sparkling diamond.");
        Item jdStat = new Item("jade statue", "It's treasure. This piece is a small statue made of jade.");
        //-----------------------------FURNITURE-------------------------------- 
        Furniture vau1Chsts = new Vau_Chsts(grl, cns, crwn, brclt, rng, dmnd, jdStat);
        Furniture vau2Chsts = new Vau_Chsts(rng, cns, cns, dmnd, crwn, jdStat, dmnd);
        Furniture vauF = new Floor("The floors are sandstone blocks and covered in treasure.", cns, rng, cns, cns, brclt, dmnd, grl, cns, cns, dmnd, crwn);
        Furniture vauTrsr = new Vau_Treasure(cns, cns, crwn, jdStat, dmnd, rng, cns, rng, brclt);
        Furniture vauBwls = new Vau_Bowls();
        Furniture vauClng = new Vau_Ceiling();
        Furniture vaueF = new Floor("The floors are made of ancient sandstone blocks.");
        Furniture vauW = new Wall("The walls are made of sandstone blocks.");
        Furniture vaueBttns = new Vaue_Door();

        // </editor-fold>

        // </editor-fold>
        // ---------------------------------------------------------------------     
        // <editor-fold defaultstate="collapsed" desc="AREA 7: TOWER">

        // <editor-fold defaultstate="collapsed" desc="INITIALIZE BLACK STAIRCASE">
        //-----------------------------THE ROOM---------------------------------
        Room bls1 = new Bls1("in a black atrium", Id.BLS1);
        Room bls2 = new Bls2("on the second-floor atrium", Id.BLS2); 
        //-----------------------------FURNITURE-------------------------------- 
        Furniture blsWndw = new Bls_Windows();
        Furniture blsBlcny = new Bls_Balcony();

        Furniture bls1Stat = new Bls1_Statue();
        Furniture bls1Dr = new AtriumDoor(Direction.EAST);
        Furniture bls1Strs = new Bls_Staircase(Direction.UP);
        Furniture bls1_Plnts = new Bls1_Plants(sl);
        Furniture bls1F = new Floor("The floor is a gray mosaic formed from many tiny pieces of glossy ceramic.");

        Furniture bls2Strs = new Bls_Staircase(Direction.DOWN);
        Furniture bls2F = new Floor("The floor is iron lattice.");

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE TOWER">
        Furniture tow1Pdstl = new Tow1_Pedestal(towScptrPhy);
        //-----------------------------THE ROOM---------------------------------
        Room tow1 = new Tow1("in a tower", Id.TOW1, tow1Pdstl);
        Room tow2 = new Tow2("in the upper-tower", Id.TOW2);
        //-----------------------------FURNITURE-------------------------------- 
        Furniture towWndw = new Tow_Windows();
        Furniture towBlcny = new Tow_Balcony();
        Furniture towSphr = new Tow_Sphere();

        Furniture tow1F = new Floor("The floor is checkered white and blue, and very clean.");
        Furniture tow1Dr = new Foy4_Door(Direction.NORTH);
        Furniture tow1BlckDr = new AtriumDoor(Direction.WEST);

        Furniture tow2DrN = new Tow2_NorthDoor(Direction.NORTH);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE LICH'S QUARTERS">
        //-----------------------------THE ROOM---------------------------------
        Room lqu1 = new Lqu1("in the lich's quarters", Id.LQU1);
        Room lqu2 = new Lqu2("at the lich's bed", Id.LQU2);
        //-------------------------------ITEMS----------------------------------
        Item lquaStf = new Item(DAMPENING_STAFF, "It resembles the smooth branch of an oak tree with some kind of coil wrapped around it. It feels lifeless of power.");
        //-----------------------------FURNITURE-------------------------------- 
        Furniture lquF = new Floor("The floor around the carpet is hard and cold stone.");
        Furniture lquW = new Wall("The walls are clean smooth stone and decorated with faux columns.");

        Furniture lqu1Wrdrb = new Lqu1_Wardrobe();
        Furniture lqu1Mrrr = new Lqu1_Mirror();
        Furniture lqu1Cbnt = new Lqu1_Cabinet(lquaStf);
        Furniture lqu1_Bd = new Lqu1_Bed();
        Furniture lqu_Crpt = new Lqu_Carpet();

        Furniture lqu2Lvr = new Lqu2_Lever(cou3Gt);
        Furniture lqu2Bd = new Lqu2_Bed();

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE TOP BALCONY">
        //-----------------------------THE ROOM---------------------------------
        Room tbal = new Tbal("on a high balcony", Id.TBAL);
        //-----------------------------FURNITURE--------------------------------
        Furniture tbalStrs = new Tbal_Stairs();
        Furniture tbalPllr = new Tbal_Pillar();
        Furniture tbalDrS = new Tow2_NorthDoor(Direction.SOUTH);
        Furniture tbalF = new Floor("The floor is a gray mosaic formed from many tiny pieces of glossy ceramic.");
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE SOUL CHAMBER">
        //-----------------------------THE ROOM---------------------------------
        Room soul = new Soul("in the soul chamber", Id.SOUL, towSphr, lqu1, tow1, tow2);
        //-----------------------------FURNITURE-------------------------------- 
        Furniture soulPl = new Soul_Pool();
        Furniture soulStat = new Soul_Statues();
        Furniture soulF = new Floor("It's a light-gray tiled floor.");
        Furniture soulWndw = new Soul_Window();

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE END ROOM">

        Room endg = new Endg("", Id.ENDG);

        // </editor-fold>

        // </editor-fold>
        //**********************************************************************
        // </editor-fold>  
        //**********************************************************************


        //**********************************************************************
        // <editor-fold defaultstate="collapsed" desc="CREATE CASTLE ARRAY">
        //
        /** The castle map is a 3D array composed of seven 8 x 10 2D arrays. 
         * The map behaves as a graph in that each room has an ID. That ID is
         * mapped to an array of other ID's which represent adjacent rooms.
         * Though this implementation uses up more space than it needs to due 
         * to the numerous 'NULL' elements, it provides a good visualization.
        //*********************************************************************/

        Room ____ = new Room(Id.NULL, Id.NULL); // Represents unreachable space.

        Room[][][] newMap = {                        

            // <editor-fold defaultstate="collapsed" desc="FLOOR 4 [0]">    
            //  0    1    2    3    4    5    6    7    8    9
            {{____,____,____,____,____,____,____,____,____,____}, //0
             {____,____,____,____,____,soul,____,____,____,____}, //1
             {____,____,____,____,____,tbal,____,____,____,____}, //2
             {____,____,____,____,bls2,tow2,lqu1,lqu2,____,____}, //3
             {____,____,____,____,____,____,____,____,____,____}},//4

            // </editor-fold>    
            // <editor-fold defaultstate="collapsed" desc="FLOOR 3 [1]">
            //  0    1    2    3    4    5    6    7    8    9  
            {{____,____,____,____,____,____,____,____,____,____}, //0
             {____,____,____,____,____,____,____,____,____,____}, //1
             {____,____,obs3,att1,labo,foy4,gal6,gal7,____,____}, //2
             {____,____,sst2,att2,bls1,tow1,____,____,chs3,____}, //3
             {____,____,____,____,____,____,____,____,cha1,____}, //4
             {____,____,____,____,____,____,____,____,cha2,____}, //5
             {____,____,____,____,____,____,____,____,____,____}},//6

            // </editor-fold>   
            // <editor-fold defaultstate="collapsed" desc="FLOOR 2 [2]">
            //  0    1    2    3    4    5    6    7    8    9  
            {{____,____,____,____,____,____,____,____,____,____}, //0
             {____,____,____,____,____,____,____,gal5,lib4,____}, //1
             {____,____,obs2,jha1,par2,foy3,gal3,gal4,lib5,____}, //2
             {____,____,sst1,jha2,____,____,____,____,____,____}, //3
             {____,____,gar1,gar2,____,____,____,____,din2,____}, //4
             {____,____,gar3,gar4,____,____,____,____,drar,____}, //5
             {____,____,____,wow3,clos,____,____,work,eow4,____}, //6
             {____,____,____,____,____,____,____,____,____,____}},//7
            // </editor-fold>   
            // <editor-fold defaultstate="collapsed" desc="FLOOR 1 [3]">
            //  0    1    2    3    4    5    6    7    8    9  
            {{____,____,____,____,____,____,____,____,____,____}, //0
             {____,____,bha1,bha2,bha3,foyb,foyc,lib1,lib2,____}, //1
             {____,____,obs1,stud,par1,foy2,gal1,gal2,lib3,____}, //2
             {____,____,look,rotu,foyw,foy1,vest,mha1,chs1,____}, //3
             {____,squa,sha2,iha1,cou1,cou7,cou6,mha2,din1,____}, //4
             {____,shar,sha1,iha2,cou2,cou3,cou5,mha3,kitc,____}, //5
             {____,wbal,wow1,wow2,cous,cou4,dst1,eow1,eow2,____}, //6
             {____,____,____,____,____,endg,____,____,____,____}},//7
            // </editor-fold>   
            // <editor-fold defaultstate="collapsed" desc="TUNNELS [4]">
            //  0    1    2    3    4    5    6    7    8    9  
            {{____,____,____,____,____,____,____,____,____,____}, //0
             {____,esc3,esc4,esc5,____,____,____,____,____,____}, //1
             {____,esc2,esc1,esc6,____,____,____,____,____,____}, //2
             {____,____,____,____,____,cas1,cry2,____,vau1,____}, //3
             {____,cis2,cis1,sew5,pris,torc,cry1,____,vau2,____}, //4
             {____,cis3,aarc,sew4,sew3,sew2,sew1,____,vaue,____}, //5
             {____,cis4,oub1,intr,sewp,dkch,sew0,____,____,____}, //6    
             {____,____,____,____,____,____,____,____,____,____}},//7
            // </editor-fold>   
            // <editor-fold defaultstate="collapsed" desc="CATACOMBS [5]">
            //  0    1    2    3    4    5    6    7    8    9  
            {{____,____,____,____,____,____,____,____,____,____}, //0
             {____,ct11,ct12,ct13,ct14,ct15,tm16,ct17,my18,____}, //1
             {____,ct21,ct22,ct23,ct24,ct25,ct26,ct27,ct28,____}, //2
             {____,ct31,tm32,ct33,ct34,cs35,ct36,ct37,ct38,____}, //3
             {____,ct41,ct42,ct43,ct44,ct45,ct46,ct47,ct48,____}, //4
             {____,ct51,ct52,ct53,ct54,an55,ct56,ct57,ct58,____}, //5
             {____,ct61,ou62,ct63,ct64,an65,tm66,ct67,ct68,____}, //6
             {____,____,____,____,____,____,____,____,____,____}},//7 
            // </editor-fold>   
            // <editor-fold defaultstate="collapsed" desc="CAVES [6]">
            //  0    1    2    3    4    5    6    7    8    9  
            {{____,____,____,____,____,____,____,____,____,____}, //0
             {____,cv11,cv12,cv13,cv14,cv15,cv16,cv17,cv18,____}, //1
             {____,cv21,cv22,cv23,cv24,cv25,cv26,cv27,cv28,____}, //2
             {____,cv31,cv32,cv33,cv34,cv35,cv36,cv37,cv38,____}, //3
             {____,cv41,cv42,cv43,cv44,cv45,cv46,cv47,cv48,____}, //4
             {____,cv51,cv52,cv53,cv54,cv55,cv56,cv57,cv58,____}, //5
             {____,cv61,cv62,cv63,cv64,ms65,ms66,cv67,cv68,____}, //6
             {____,____,____,____,____,____,____,____,____,____}} //7
            // </editor-fold>   

        };

        //**********************************************************************
        // </editor-fold> 
        //********************************************************************** 


        //**********************************************************************
        // <editor-fold defaultstate="collapsed" desc="PUT FURNITURE IN ROOMS">
        //*********************************************************************/  

        // <editor-fold defaultstate="collapsed" desc="AREA 1: CASTLE FRONT">

        foy1.addFurniture(genDoor, foy1Gt, foyFrntDr, foyF, foyW, foy1Chnd, eastDoor, foy1Tbl, foy1Crpt, foy1Strs, clng);
        foy2.addFurniture(foy2Gt, foy2Stat, foy2Alc, foyF, foyW, foy2Strcs, clng);
        foy3.addFurniture(foy3Strs, westDoor, foyW, foy3F, foy34Crpt, clng);
        foy4.addFurniture(foy4Strs, foyW, foy4F, foy34Crpt, foy4Dr, clng);
        vest.addFurniture(vesFire, vesBtn, vesWin, vesDsk, vesEtbl, vesCase, vesTpstr, vesChr, vesF, vesDr, wallEx, vesOrb);
        foyb.addFurniture(bbaF, wallEx, bbaClmns, bbaRlng, bbaVllg, clng, bbaBnch, bbaScnc, bbaClff, bbaShrln, bbaSea, bba1Gt, wantBttn);
        foyc.addFurniture(bbaF, wallEx, bbaClmns, bbaRlng, bbaVllg, clng, bbaScnc, bbaClff, bbaShrln, bbaSea, bba2Dr);
        cou1.addFurniture(couStps, cou1Bnch, cou1Thrns, couW, cou1F, couCstl);
        cou2.addFurniture(couW, cou2F, cou2Bshs, cou2Fntn, couCstl, coutWlkwy);
        cou5.addFurniture(couW, cou56F, cou2Bshs, cou5Fntn, couCstl, cou5Sprc, coutWlkwy);
        cou6.addFurniture(couStps, cou1Bnch, cou1Thrns, couW, cou56F, cou6Stat, couCstl, cou6Ghst);
        cou3.addFurniture(cou3F, couW, cou3Stps, cou3Gt, cou3Ivy, couCstl);
        cou4.addFurniture(cou3F, couW, cou4Gt, cou4Frst, cou4Trl, couCstl);
        cou7.addFurniture(couCstl, entrF, entrDr, entrStats, entrClmns, bbaRlng, entrRf, entrStps, entrBlcny);
        foyw.addFurniture(genDoor, wantStat, wantTrchs, wantLvr, wantPllrs, wWW, wantF, wantRmp, wantDr, wantGt, wantBttn, clng);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="AREA 2: WEST WING">    

        rotu.addFurniture(genDoor, rotuFntn, rotuW, rotuF, rotuPlnts, rotuHl, rotuStat, rotuScnc, rotuFrms, rotuSky, rotuRock, clng);
        look.addFurniture(lookVlv, lookLghths, lookClff, lookRlng, lookF, wallEx, eastDoor, iha1Lvr, bbaSea);
        iha1.addFurniture(northDoor, wWW, ihaF, iha1Armr, iha1Bwl, ihaWndw, iha1Lvr, clng);
        iha2.addFurniture(southDoor, wWW, ihaF, iha2Armr, iha2Bwl, ihaWndw, clng);
        wow1.addFurniture(genDoor, wWW, westDoor, wow1NDr, wow1Crt, wow1F, wowWndw, wowHrth, wow1Shlvs, clng);
        wow2.addFurniture(genDoor, wWW, wow2Armr, wow2Blcny, wow2F, wow2Dr, northDoor, wow2Hole, wowWndw, wowHrth, wow2Strcs, clng);
        wbal.addFurniture(wallEx, eastDoor, lookLghths, lookClff, lookRlng, wbalF, wbalBcn, wbalFrst, bbaSea);
        squa.addFurniture(wWW, squaF, squaBd, squaDsk, squaWndw, lookLghths, lookClff, bbaSea, squaWrdrb, squaCndl, squaDr, clng);
        wow3.addFurniture(genDoor, wWW, wow3Shlf, wow3F, wow3Dr, bbaRlng, wow3NDr, clng);
        sha1.addFurniture(wWW, shaF, sha1Trch, sha1Dr, sha1SDr, clng);
        sha2.addFurniture(wWW, sha2Cbnt, shaF, sha2Dr, sha2Trch, clng);
        clos.addFurniture(closW, closF, closShlf, closStl, closBrrl, closWrkbnch, closLddr, closScks, closClng, closSkltn, closDr);  
        cous.addFurniture(searFssr, searDr, searLddr, searAsh, searSkltn, searF, searAsh, closW, clng, searWood);
        shar.addFurniture(wWW, rquaF, rquaBd, rquaTbl, rquaMttrss, rquaDrssr, squaWndw, lookLghths, lookClff, bbaSea, rquaPnl, clng);
        stud.addFurniture(wWW, studF, studPrtrt, studFire, studDsk, vesChr, studCch, studBkCs, studCrpt, southDoor, iha1Lvr, clng);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="AREA 3: EAST WING">     

        gal1.addFurniture(gal1Dr, gal1F, gal1W, gal1Drgn, gal1KtnFurn, gal1Pntng, gal1Pntng2, gal1Pntng3, gal1Armr, gal1Scr, gal1Scrn, gal1Pntngs, gal1Lghts, gal1Sclptrs, gal1Hrth, clng);
        gal2.addFurniture(genDoor, gal2Stat, gal2Strcs, gal2F, gal2W, galBalc, gal1Lghts, rotuSky, galDm, gal2Clmns, mhaSDr, eastDoor);
        gal3.addFurniture(gal3Ttm, gal3Peg, gal3Hl, gal3Sgmnt, gal3Htch, gal3Lddr, gal3Rp, gal3Swtch, gal3InstFurn, gal3Msk, gal3Msk2, gal3Msk3, gal3Msks, gal3Hrth, gal3F, gal3W, gal3Art, gal3Art2, gal3Art3, gal3Arts, clng);
        gal4.addFurniture(gal4Strcs, galBalc, rotuSky, gal2W, galDm, gal4Dr, gal2Clmns, gal4Lft);
        gal6.addFurniture(gal6Cnn, gal6Lddr, gal6Mchn, gal6Hlmt, gal6Bttn, gal6App, gal6F, gal6W, gal6Htch, gal6Tech, gal6Elec, gal6Tbl, clng);
        gal7.addFurniture(wWW);
        mha1.addFurniture(genDoor, mhaChndlr, mhaChr, mha1Plnt, mhaF, mhaW, mhaNWndw1, mhaNDr, mhaNChaDr, clng);
        mha2.addFurniture(mhaChndlr, mhaChr, mha2Plnt, mhaF, mhaW, mhaNWndw2, mhaMDr, mhaRStat, mhaLStat, mhaStats, clng);
        mha3.addFurniture(genDoor, mhaChndlr, mhaChr, mha3Plnt, mhaF, mhaW, mhaSWndw, mha3KitcDr, mhaSDr, clng);
        lib2.addFurniture(libLF, libW, libCch, lib2ShRck, lib2Stat, lib2Frplc, lib2Bttn, lib2WrFr, lib2Vyg, libBkShlf, libScncs, lib2Wndw, clng);
        lib3.addFurniture(libLF, libW, westDoor, lib3Strs, libCch, lib3Stat, lib3Crtn, libScncs, lib3Blcny, lib3Wndw, lib3Pllr, lib3Pntng);
        lib4.addFurniture(libUF, libW, libCch, lib4Frplc, lib4Bttn, lib4Prdtn, libScncs, lib3Pllr, lib4Stat, lib4Glb, lib3Blcny, lib4Tbl, lib4Strs, clng);
        lib5.addFurniture(libUF, libW, lib5Bnshmnt, libScncs, lib3Pllr, lib5Cndlbr, clng);
        eow1.addFurniture(genDoor, wWW, eowF, eow1Dr, eow1Rck, eow1Bskt, eow1Trch, wowWndw, mhaNDr, clng);
        eow2.addFurniture(wWW, eowF, eow2Fntn, wtr, eow2Rck, wowWndw, eow2Strs, eow2Blcny, eow2Cbnt, eow2Trch);
        eow4.addFurniture(wWW, eow4F, eow4Strs, bbaRlng, westDoor, clng);
        dst1.addFurniture(dst1F, dstW, dst1Strs, dst1Dr, dst1Lntrn, clng);
        lib1.addFurniture(lib1F, lib1W, vesChr, lib1Dsk, lib1Art, lib1Docs, lib1Rg, lib1Wndw, lib1Rck, lib1Tbl, lib1Lght, lib1Mrrr, lib1Sf, clng);
        work.addFurniture(wWW, wrkF, eastDoor, wowWndw, wrkBrl, wrkCstTbl, wrkKln, wrkBnch, wrkCbnt, wrkFrg, wrkAnvl, clng);
        din1.addFurniture(din1Clmns, din1Blcny, din1Tbl, din1Tpstry, din1F, din1W, din1Wndw, din1Chrs, din1Chndlr, din1Mnlght, din1Strs, din1Crpt, din1Dr);
        din2.addFurniture(din2W, din2F, southDoor, din2Pntng, din2Strs, clng);
        drar.addFurniture(northDoor, drarGhst, drarF, drarW, din1Mnlght, drarChss, drarBr, drarBllrds, drarWndw, drarCch, drarTbl, clng);
        gal5.addFurniture(gal5Dsply, gal5Chndlr, gal5Cbwbs, gal5F, gal5W, gal5Clng, gal5Cbt, gal5Dr, clng);
        kitc.addFurniture(kitcTrch, kitcF, kitcW, kitcWndw, kitcDr, kitcRck, kitcPts, kitcHrth, kitcBrls, kitcPntry, kitcShlf, kitcCntr, laboSnk, clng);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="AREA 4: CASTLE REAR">

        par2.addFurniture(genDoor, wWW, par2F, par2Wndw, westDoor, eastDoor, par2Strs, parLft, par2Bwl, par2Frplc, par2Pno, par2Shlf);
        par1.addFurniture(par1F, par1Dr, par1FrPlc, wWW, par1EnchntTbl, par1Strs, parLft,
                          par1Pllrs, par1Orb, par1Hrp, par1Shlf, lib1Rg, par1Cshn, vesChr, clng);
        bha3.addFurniture(southDoor, bha1Hrzn, bha1Plnt, bha1Tbl, bha1F, bhaW, clng);
        bha2.addFurniture(bha2F, bha2W, bha2Frm, clng);
        bha1.addFurniture(bha3F, bhaW, southDoor, bha3Wndw, clng);
        jha1.addFurniture(eastDoor, jhaF, jhaW, par2Wndw, jha1Pntng, jhaLntrn, jhaJd, jha1Ln, clng);
        jha2.addFurniture(southDoor, jhaF, jhaW, jhaLntrn, jhaJd, jha2Ln, clng);
        sst1.addFurniture(wallEx, sst1Strs, sstLndng, sst1F, sst1Dr, clng);
        sst2.addFurniture(wallEx, sst2Strs, sstLndng, sst2F, sstWndw, sst2Dr);
        gar1.addFurniture(lookClff, bbaSea, wallEx, bbaRlng, garF, gar1Stat, gar13Plntr);
        gar2.addFurniture(wallEx, gar2Hl, northDoor, garF, gar2Dm, gar2Clmn, gar24Scnc);
        gar3.addFurniture(lookClff, bbaSea, wallEx, bbaRlng, garF, gar13Plntr, gar3Chst, gal3Fntn, wtr, gar2Dm, gar2Clmn);
        gar4.addFurniture(wallEx, southDoor, gar4Plq, gar4Plntr, garF, gar24Scnc);
        obs1.addFurniture(obsSlts, obsStats, obsF, obsW, obsWndw, obs1Strs, obs1Tlscp, obs1Lmp, lib4Glb, obs1St, obsBlcny, northDoor);
        obs2.addFurniture(obsW, obs2F, obsWndw, obs2Strs, obsBlcny, obs2BkShlf, obs2Pntng, obs2Rlng, obs2Chr, obs2Tbl, obs2Lmp);
        obs3.addFurniture(obs3Chndlr, obsW, obs3F, obsWndw, obs3Strs, obsBlcny, obs2Rlng, obs3Chst, obs3Tlscps, clng);
        att1.addFurniture(attF, attW, sst2Dr, attCss, attBxs, gal5Cbwbs, attVnts, attClng);
        att2.addFurniture(attF, attW, att2Dr, attBxs, attCss, gal5Cbwbs, attVnts, att2CtCs, attClng);
        labo.addFurniture(laboF, att2Dr, wallEx, laboStpCck, laboBrtt, laboGsPipe, laboCntr, iceBrrl, 
                          laboRck, laboDspnsrs, laboDstllr, laboSnk, laboCntrptn, cndsr, laboTbl, laboDvcs, clng); 

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="AREA 5: SUB-LEVELS">

        // <editor-fold defaultstate="collapsed" desc="Tunnels and dungeon">

        sew0.addFurniture(sew0Strs, dngnW, sewF, sew0Trch, sewTnnl, sewMss);
        sew1.addFurniture(sew1Rvr, sewF, dngnW, sewTnnl, sew15Gt, sew1Trch, sewMss);
        sew2.addFurniture(sewRvr, sewF, dngnW, sewTnnl, sew2Trch, sewMss, sew2BrdgW, sew2Pp, sew2Vlvs);
        sew3.addFurniture(sewRvr, sewF, sewDrN, dngnW, sewTnnl, sew3Trch, sewMss, sew3BrdgE, sew3BrdgN, sew3Pp);
        sew4.addFurniture(sewRvr, sewF, dngnW, sewTnnl, sew4Trch, sewMss, sew4Pp);
        sew5.addFurniture(genDoor, sewRvr, sewF, sewDrW, sewDrE, dngnW, sewTnnl, sew15Gt, sew5Trch, sewMss, sew5BrdgE, sew5Pp, sew5Vlv);
        cis1.addFurniture(cis1Trch, dngnW, sewDrE, cisF, cisWtr, cisClmns, cisDrknss);
        cis2.addFurniture(dngnW, cisF, cisWtr, cisClmns, cisDrknss);
        cis3.addFurniture(cis3Trch, dngnW, sewDrE, cisF, cisWtr, cisClmns, cisDrknss);
        cis4.addFurniture(cis4Trch, dngnW, sewDrE, cisF, cisWtr, cisClmns, cisDrknss);
        oub1.addFurniture(sewDrW, tm1Bwl, oub1F, dngnW, oub1Pt, dungMonst, clng);
        intr.addFurniture(intrDr, intrWhl, intrGrs, intrF, dngnW, intrGrt, intrWtr, intrTrch, dungMonst, clng);
        esc1.addFurniture(esc1Lddr);
        esc6.addFurniture(esc6Grt, esc6Lddr);
        cas1.addFurniture(casW, casStrs, casF, cs35Trchs, cs35Stat, sewDrE, clng);
        sewp.addFurniture(genDoor, sewpCl, sewpGrt, sewpWtr, sewpF, dngnW, sewDrE, sewDrW, sewpTrch, sewpTnnl);
        pris.addFurniture(genDoor, prisClls, dngnW, sewDrS, sewDrW, prisF, prisCndlbrs, prisTbl, prisCbnt, prisGts, dungMonst, clng);
        torc.addFurniture(genDoor, sewDrE, sewDrW, dngnW, torcF, torcTrchs, torcSwhrses, torcScythF, torcRck, torcCgs, torcWhl, torcWd, torcTls, dungMonst, clng);
        cry1.addFurniture(sewDrW, dngnW, cryF, cry1Stat, cryDrwrs, cry1Crvng, cryLghts, dungMonst, cryDummy, clng);
        cry2.addFurniture(dngnW, cryF, cryDrwrs, cryLghts, cry2Engrvng, cry2Altr, dungMonst, cry2Psswd, cryDummy, clng);
        aarc.addFurniture(sewDrW, aarcF, aarcW, aarcWd, aarcBks, aarcChndlr, aarcDsk, aarcAlg, aarcShlvs, dungMonst, clng);
        dkch.addFurniture(sewDrW, dkchF, dngnW, dkchBd, dkchAxl, dkchDsk, squaCndl, dkchClng, dungMonst);

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Catacombs and caves">

        tm16.addFurniture(tmb1Cskt, catW, tm1F, catDrS, tm1Vs, tm1Bwl, tm1Effgy, clng);
        tm66.addFurniture(tmb2Cskt, catW, tm2F, catDrE, tm2Vs, tm2Orb, clng);
        tm32.addFurniture(tmb3Cskt, catW, tm3F, catDrW, tm3Vs, tm3Tpstry, tm3Cndl, clng);
        ou62.addFurniture(catDrN, oubSpk, oubStrw, oub2F, dngnW, tm1Bwl);
        an65.addFurniture(catW, antF, antCskt, antNPC, antClng, antCskts, ant2Trch, antW);
        an55.addFurniture(catW, antF, antCskt, catDrN, antClng, antCskts, ant1Trch, antW);
        my18.addFurniture(antW, my18F, my18Pdstl, tm1Bwl, my18Clng);
        ct34.addFurniture(ct34Dr);
        cv18.addFurniture(cv18Strs);
        cv34.addFurniture(cvWell);
        cs35.addFurniture(cs35Dr, cs35F, cs35Trchs, casW, cs35Stat, cs35Strs);
        cv64.addFurniture(omnDr);
        ms65.addFurniture(dmmyFurniture);
        ms66.addFurniture(factum, dmmyFurniture);

        //</editor-fold>

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="AREA 6: CHAPEL AND VAULT">

        chs1.addFurniture(chs1Strs, chsWndws, chs1F, chsW, din1Mnlght, chs1Stat, mhaWDr);
        chs3.addFurniture(chs3Strs, chsWndws, chsW, din1Mnlght, chs3F, southDoor, clng);
        cha1.addFurniture(cha1Cylx, cha1Wtr, northDoor, chaW, chaF, din1Mnlght, chaPws, cha1Cndlbr, chaHz, chaCrpt, chaWndws, chaClng);
        cha2.addFurniture(chaF, chaW, din1Mnlght, chaPws, chaHz, chaCrpt, chaWndws, cha2Alt, chaClng);
        vau1.addFurniture(vau1Chsts, vauF, vauBwls, vau1Tbl, vauTrsr, vauClng);
        vau2.addFurniture(vau2Chsts, vauF, vauBwls, vauTrsr, vauClng);
        vaue.addFurniture(vaueF, vauBwls, vaueBttns, vauW, clng);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="AREA 7: TOWER">

        tow1.addFurniture(tow1F, wallEx, towWndw, towBlcny, tow1Pdstl, tow1Dr, tow1BlckDr, towSphr);
        tow2.addFurniture(genDoor, towWndw, wallEx, towBlcny, eastDoor, towSphr, tow2DrN, clng);
        bls1.addFurniture(bls1Dr, bls1Strs, bls1_Plnts, blsWndw, bls1F, bls1Stat);
        bls2.addFurniture(eastDoor, bls2Strs, blsWndw, bls2F, blsBlcny);
        tbal.addFurniture(genDoor, tbalStrs, bbaSea, tbalPllr, northDoor, tbalDrS, tbalF);
        lqu1.addFurniture(westDoor, lqu1Wrdrb, lquF, lqu1Chst, lqu1Mrrr, lquW, lqu1Cbnt, lqu1_Bd, lqu_Crpt, clng);
        lqu2.addFurniture(lquF, lquW, lqu_Crpt, lqu2Lvr, lqu2Bd, clng);
        soul.addFurniture(soulPl, soulStat, soulF, wallEx, soulWndw, clng);

        // </editor-fold>

        //**********************************************************************
        // </editor-fold>  
        //**********************************************************************


        //**********************************************************************
        // <editor-fold defaultstate="collapsed" desc="LOCK ROOMS">
        //*********************************************************************/  

        rotu.lock(); stud.lock(); gal5.lock(); gal1.lock(); par2.lock();
        clos.lock(); din1.lock(); kitc.lock(); ou62.lock(); chs1.lock();
        work.lock(); tow1.lock(); tbal.lock(); sewp.lock(); dkch.lock();
        vau2.lock(); wow2.lock();

        //**********************************************************************
        // </editor-fold> 
        //********************************************************************** 

        return newMap;
    }
    //==========================================================================
}
