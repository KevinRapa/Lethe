package A_Main;

import A_Super.*;          import static A_Main.Names.*;

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
import Vault.*;            import Tower.*;              import Kampe_Quarters.*;
import Black_Staircase.*;  import Top_Balcony.*;        import Lichs_Quarters.*;
import Soul_Chamber.*;     import Hades.*;              import Cellar.*;
import Forest.*;

import java.awt.Color;      import java.io.*;
import javax.swing.JPanel;  import javax.swing.ImageIcon;   
import javax.swing.JFrame;  import javax.swing.JLabel;  

/**
 * Creates all rooms, furniture, and items in the game, then serializes each
 * to a file to be read in as it is needed.
 * Also controls a small secondary window which displays a rudimentary
 * image of the room the player is in.
 * 
 * @author Kevin Rapa
 */
public class Map {
    // Room images are located here.
    private final static String 
            PATH = W_DIR + SEP + DATA + SEP + "img" + SEP,
            EXT = ".jpg";
    
    private static final JLabel MAP_LABEL = new JLabel();
    private static final JPanel MAP_PANEL = new JPanel();
    private static final JFrame MAP_FRAME = new JFrame("Map");
    
    static {
        MAP_FRAME.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        MAP_FRAME.getContentPane().add(MAP_PANEL);
        MAP_FRAME.setFocusableWindowState(false);
        MAP_FRAME.setResizable(false);
        
        MAP_PANEL.setBackground(Color.BLACK);
        MAP_PANEL.add(MAP_LABEL);
    }
    
    //-------------------------------------------------------------------------
    /**
     * Displays a map for when the player enters 'm'.
     * Displays current floor.
     */
    public static void displayMap() {
        updateMap();

        if (! MAP_FRAME.isVisible()) {
            GUI.out("Enter 'close' to hide the map.");
            AudioPlayer.playEffect(2);
            MAP_FRAME.setVisible(true);
        }
        else {
            MAP_FRAME.toFront();
        }
    }
    //-------------------------------------------------------------------------
    public static void hideMap() {
        MAP_FRAME.setVisible(false);
    }
    //-------------------------------------------------------------------------
    public static void disposeMap() {
        // Disposes map on game's end
        MAP_FRAME.setVisible(false);
        MAP_FRAME.dispose();
    }
    //-------------------------------------------------------------------------
    /**
     * Displays a new image in the map frame depending on the player's position.
     */
    public static void updateMap() {
        ImageIcon icon;
        String id = Player.getPosId();

        if (Player.getCurrentFloor() == 6) {
            if (id.equals(Id.MS65) || id.equals(Id.MS66))
                icon = new ImageIcon(PATH + "MS" + EXT);
            else    
                icon = new ImageIcon(PATH + "CAVE" + EXT);
        }
        else {
            icon = new ImageIcon(PATH + id + EXT);
            
            if (icon.getImage().getWidth(MAP_LABEL) == -1)
                // Room does not have an associated picture.
                icon = new ImageIcon(PATH + Id.UNKN + EXT);
        }

        MAP_LABEL.setIcon(icon);
        MAP_FRAME.pack();
    }
    //-------------------------------------------------------------------------
    /**
     * Creates everything in the game, then saves them all to files. 
     * Files are organized by floor, then row, then by room. Each room is 
     * serialized with all furniture currently in it and all items in the 
     * furniture. This is only called when a new game starts. When a game 
     * loads, rooms are read in as they are needed.
     */
    public static void createMap() {
        //**********************************************************************
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE ROOMS, FURNITURE, ITEMS">
        //
        // Every room, furniture, and item is instantiated here. For each area, 
        // each room is instantiated, then each item is, then each furniture
        // is and the items are added to the respective furniture. 
        //**********************************************************************  
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE PHYLACTERIES">
        
        // The player may instead keep them as loot and have a different message
        // at the end of the game.
        // TOTAL: 11000 points
        
        Item studBkPhy = new Stud_BookPhylactery(BOOK_PHYL, 2000);
        Item kitcFrtPhy = new Kitc_FrtPhy(GLOWING_FRUIT, 2000);
        Item factumPhy = new Factum(FACTUM, 3000);
        Item vauChlPhy = new Vau_ChalicePhylactery(GLOWING_CHALICE, 2000);
        Item towScptrPhy = new Tow_ScepterPhylactery(GLOWING_SCEPTER, 2000);

        // </editor-fold>
        // ---------------------------------------------------------------------  
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE SPECIAL TREASURE">
        
        // Finding treasure is a secondary objective. All items have value, but
        // these have the highest of all non-phylactery items. Player must put
        // them in the loot sack to raise score. TOTAL: 15 treasures, 9000 points

        // Found in a box in the attic.
        Item attcVln = new BreakableItem(STRADIVARIUS, 
            "A perfectly symmetrical violin, stately in appearance and still "
          + "holding a satin shine. Looking closely, you can see inscribed on "
          + "it, 'Stradivarius'.", "You could never play.", 500);
        
        // Found in a box in Kampe's quarters. Player may opt to give it to the
        // prison ghost for a hint.
        Item watch = new Item(SHINY_WATCH, "A beautiful etched pocket watch with a delicate " +
            "gold chain. It still clicks each second behind the polished crystal face, and you "
          + "can sense many delicate, expensive parts under it's surface.", 500);
        
        // Found in a vase inside a tomb in catacombs.
        Item ring = new Clothing(DIAMOND_RING, 
            "You have no words. The beauty stuns you. To think such a precious "
          + "item was buried down there for so long.", 
            "You slip the beautiful ring on your finger." ,500);
        
        // Found in a skeleton in the oubliette pit.
        Item gldKnf = new Weapon(JEWELED_KNIFE, "The weapon's grand majesty "
            + "stuns you. Its polished blade curves smoothly down to a sparkling "
            + "platinum handle set with peridot gems. ", 500);
        
        // Found on altar in the chapel
        Item gldUrn = new Item(GOLDEN_URN, 
            "The beautiful gold urn is set around the lid with emeralds and sapphires.", 500);

        // Found in the vault in a chest
        Item dmnd = new BreakableItem(LARGE_DIAMOND, 
            "It's treasure. A largely cut and undoubtedly valuable sparkling diamond.", 500);
        
        // Found on drawing room chess table.
        Item qn = new Item(JEWELED_QUEEN, "The small delicate queen is carved in "
            + "ivory and embedded with sapphires around the base. She holds a "
            + "small sparkling staff with a small diamond set at its tip.", 
            "Isn't this the strongest piece?", 500);
        
        // Found on drawing room chess table.
        Item kng = new Item(JEWELED_KING, "The small delicate chess piece is carved in ivory. "
            + "The tiny figure of a king bears a tiny platinum crown holds a "
            + "scepter. Its base is studded with cleanly-cut garnets.", 
            "You have no idea how to play that.", 500);
        
        // Found by entering "take fork" in COU3.
        Item couFrk = new Item(GOLDEN_FORK, "The magnificent fork of gold "
                + "has been carved with the finest attention to detail. "
                + "A large pearl is set into the end of the handle, and many "
                + "small scapolite gems decorate the rest of it.", 500);
        
        // Found on an altar in the crypt
        Item jetSkull = new BreakableItem(JET_SKULL, "This is a polished black "
                + "cup or mug shaped into a detailed skull. A ruby dots each "
                + "of its eyes and its teeth appear to be made of tiny "
                + "clear crystals. Diamonds? Sure, why not!", 500);
        
        // Found by opening the crate in the cellar.
        Item celTblt = new BreakableItem(BRONZE_TABLET, 
                "A list of ten statements appears to be carved on the tablet. "
              + "You cannot read any of them, for they appear to be carved in "
              + "Hebrew. You have a strong feeling this is extremely valuable.", 500);
        
        // Found on a shelf in the second-floor observatory.
        Item astrLabe = new BreakableItem(ASTROLABE,
                "It is a small, intricate disk of shiny metal attached to a"
                + "chain. Small score marks are etched all around its perimeter, "
                + "and countless carvings of celestial bodies under its crystal "
                + "surface decorate it.", 500);
        
        // Found in a protected case in GAL4
        Item monaLisa = new Item(MONA_LISA, 
                "It depicts a woman posing to the left in a chair. She has long "
              + "brown hair and pale, perfect skin, as well as a slight grin. "
              + "Interesting, as you note that she also lacks eyebrows.", 500);
        
        // Obtained by committing suicide, finding it in a pile of bodies, 
        // and returning using the Factum.
        Item typhos = new Item(TYPHOS, "The small golden trophy is protected in "
                + "a red, glowing aura. It depicts a wicked creature- winged, "
                + "with sharp teeth and an many snake-like tendrils where its "
                + "legs would be. This trophy identifies you as a wealthy, "
                + "most cunning adventurer, though it was not your intention.", 1500);
        
        // <editor-fold defaultstate="collapsed" desc="Philosopher's stone set">
        // These items create the philosopher's stone treature.
        // Each is found by watering a potted plant.
        Item philSn = new BreakableItem(PHILOSOPHERS_STONE, 
                "The three pieces have joined into a treasure of nearly unmatched beauty. "
                + "The silver jeweled base now supports the lapis stone in the center, "
                + "capped by the sparkling sapphire lotus.", 1000);
        Item stnBs = new BreakableItem("philosopher's stone base", 
                "A beautiful square base studded with sapphires. Despite it's "
                + "majesty, there appears to be something missing, as there's a "
                + "small metal spoke protruding from the base's center.", philSn, 3, 200);
        Item stnBdy = new BreakableItem("philosopher's stone body", 
                "It's a hand-held stone pyramid made of lapis lazuli. Each convex "
                + "side gently curves to a point at the top. The bottom and "
                + "top each bear a small hole, as if they're missing something.", philSn, 3, 200);
        Item stnHd = new BreakableItem("philosopher's stone head", 
                "It's a silver lotus head studded with sapphires. Despite its "
                + "majesty, there appears to be something missing, as there's a "
                + "small spoke protruding from its bottom", philSn, 3, 200);
        
        // </editor-fold>
        
        // </editor-fold>
        // --------------------------------------------------------------------- 
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE KEYS AND GENERIC FURNITURE">
        Key studKey = new Key("crude molded key", Id.STUD);        
        Key gal1Key = new Key("key with a bearded face on its bow", Id.GAL1);       
        Key eow3Key = new Key("workshop key", Id.WORK);       
        Key par2Key = new Key("key with a rose on its bow", Id.PAR2); 
        Key garChstKey = new Key("chest key", Id.GCHS);
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
        Key archKey = new Key("Kampe's key", Id.DKCH);
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
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE ITEM SETS">
        // These items all go together and must be high up in initialization
        // in order to be distributed around the castle.
        
        // <editor-fold defaultstate="collapsed" desc="Dampening staff set">
        // These create the dampening staff needed to obtain the final phylactery.
        String fragDesc = "The jet black stone is partially smooth and rounded. "
                + "You estimate it's about one-third a full sphere.";
        
        Item lquaStf = new BreakableItem(DAMPENING_STAFF, 
                  "The smooth oak branch now holds the onyx ball inside its wooden "
                + "cradle at the end. You sense power coming from it, "
                          + "but appears otherwise mundane.", 250);
        Item stffHndl = new BreakableItem("dampening staff handle", 
                  "It's a long and smooth branch of oak with a cradle at the tip, "
                + "but whatever the cradle was holding is now gone.", lquaStf, 2, 100);
        Item onyxSphr = new BreakableItem("onyx sphere", 
                "The fragments have magically fused together into a smooth black ball of onyx.", 
                lquaStf, 2, 150);
        Item onyxFrag1 = new Item(ONYX_FRAGMENT, fragDesc, onyxSphr, 3, 50);
        Item onyxFrag2 = new Item(ONYX_FRAGMENT, fragDesc, onyxSphr, 3, 50);
        Item onyxFrag3 = new Item(ONYX_FRAGMENT, fragDesc, onyxSphr, 3, 50);
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Mandragora set">
        // Instantiated before courtyard because soil can be found in the courtyard.
        Item mndrk = new Item(MANDRAGORA, "The potato-shaped vegetable looks disturbingly life-like.", 60);
        Item hlyWtr = new Liquid(HOLY_WATER, "Clear, salty, and boiled like hell.", mndrk, 2, 15);
        Item pttdMndrk = new BreakableItem(POTTED_MANDRAGORA, "You have gently positioned the bulb under the soil.", mndrk, 2, 45);
        Item mndrkBlb = new Item("mandragora bulb", "It's a baby mandragora!", pttdMndrk, 2, 35);
        Item mndrkPt = new BreakableItem(POTTED_SOIL_AND_FERTILIZER, "The fertile soil mixture is packed gently into the pot. ", pttdMndrk, 2, 15);
        Item pot = new BreakableItem("clay pot", "It's a medium-sized clay pot for holding plants.", mndrkPt, 2, 25);
        Item mxtr = new Item(FERTILIZED_SOIL, "It's a fertile mixture of soil, sand, and fertilizer", mndrkPt, 2, 15);
        Item snd = new Item(SAND, "You have a pocket full of sand. It's grainy and uncomfortable.", mxtr, 3, 0);
        Item sl = new Item(SOIL, "It's a soft pile of soil", mxtr, 3, -25);
        Item frt = new Item(FERTILIZER, "It's a handful of mysterious gardening wizardry.", mxtr, 3, 10);
        // </editor-fold>
        
        // </editor-fold>
        // ---------------------------------------------------------------------  
        // <editor-fold defaultstate="collapsed" desc="AREA 1: CASTLE FRONT">

        Item bckt = new Item(METAL_BUCKET, "It's an empty metal bucket.", 25); // Used with all fireplaces
        Item vial = new BreakableItem(EMPTY_VIAL, "It's a small glass vial for holding samples", 25);
        Item ram = new Weapon(BATTERING_RAM, "You've restored the old battering ram back to its former glory.", 35);
        Item torch = new Item(HAND_TORCH, "It's a burning piece of wood. Stay it from your beard!", 0);

        // <editor-fold defaultstate="collapsed" desc="INITIALIZE WEST ANTECHAMBER">
        Furniture foy1Gt = new Foy_Gate(false, Direction.WEST);
        Furniture foy2Gt = new Foy_Gate(true, Direction.NORTH);
        Furniture foy2Bttn = new Foy2_Button(foy1Gt, foy2Gt);
        //-----------------------------THE ROOM---------------------------------
        Room foyw = new Want("Antechamber", Id.FOYW);     
        //-----------------------------FURNITURE--------------------------------        
        Furniture wantLvr = new Want_Lever();
        Furniture wantStat = new Want_Statue();
        Furniture wantPllrs = new Want_Pillars();
        Furniture wantTrchs = new Want_Torches();
        Furniture wWW = new Wall("It's made of heavy sandstone blocks stacked in a staggered fashion.");
        Furniture wantF = new Floor("A sandstone tiled floor. Small, loose grains grind against your shoes as you walk.");
        Furniture wantRmp = new Want_Ramp();
        Furniture wantDr = new Want_Door(Direction.WEST);
        Furniture wantGt = new Want_Gate(Direction.EAST);
        Furniture wantBttn = new Want_Button(foy2Bttn);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE BACK BALCONY">
        //-----------------------------THE ROOM---------------------------------
        Room foyb = new Bba1("Back balcony", Id.FOYB);
        Room foyc = new Bba2("Back balcony", Id.FOYC);      
        //-------------------------------ITEMS----------------------------------        
        Item bbaNote = new Bba_Note("note from a visitor");
        //-----------------------------FURNITURE--------------------------------                       
        Furniture bbaF = new Floor("The floor is built of many lavender and gray shale rocks mortared together.");
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
        Room foy1 = new Foy1("Foyer", Id.FOY1);
        Room foy2 = new Foy2("Grand staircase", Id.FOY2); 
        Room foy3 = new Foy3("Second floor landing", Id.FOY3);
        Room foy4 = new Foy4("Third floor landing", Id.FOY4); 
        //-------------------------------ITEMS---------------------------------- 
        Item lootSack = new LootSack();
        Item foy1Note = new Foy1_Note("short letter");
        Item cndlStck = new Weapon("brass candlestick", 
                "It holds a stubby old candle. Well, at least no one can club you behind the head with it now.", 40);
        Item bskt = new Item("wicker basket", "A decorative wicker basket. Probably not very useful for you right now.", 15);
        Item bwlrHat = new Clothing("wool bowler hat", "A short-brimmed durable hat with a domed top.", 
                "You slip the warm hat on your head.", 30);
        Item umbr = new BreakableItem("umbrella", 
                "A stately black umbrella with a lacquered wood handle.", 
                "It is not raining.", 30);
        //-----------------------------FURNITURE--------------------------------    
        Furniture foyW = new Wall("A dark wood-paneled wall.");
        Furniture foyF = new Floor("Salmon-colored tiled marble. Its glint stuns you.");
        Furniture foyFrntDr = new Entr_Door(Direction.SOUTH);

        Furniture foy1Chnd = new Foy_Chandelier();
        Furniture foy1Tbl = new Foy1_Table(bskt, foy1Note, cndlStck);
        Furniture foy1Crpt = new Foy1_Carpet();
        Furniture foy1Strs = new Foy1_Stairs();    
        Furniture foy1Armr = new Foy1_Armoire(umbr, bwlrHat, lootSack);

        Furniture foy2Stat = new Foy2_Stat(foy2Bttn);
        Furniture foy2Alc = new Foy2_Alcove(foy2Stat);
        Furniture foy2Strcs = new Foy2_Staircase(Direction.UP, Id.FOY3);

        Furniture foy3Strs = new Foy3_Stairs();
        Furniture foy3F = new Floor("The floor is a salmon-colored tile run with a red carpet, "
                + "which continues along the staircase.");
        Furniture foy34Crpt = new Foy34_Carpet();

        Furniture foy4Strs = new Foy2_Staircase(Direction.DOWN, Id.FOY3);
        Furniture foy4F = new Floor("The floor is a salmon-colored tile run with a red carpet, "
                + "which continues along the staircase.");
        Furniture foy4Dr = new Foy4_Door(Direction.SOUTH);

        // </editor-fold>        
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE VESTIBULE">
        //-----------------------------THE ROOM---------------------------------
        Room vest = new Vest("Vestibule", Id.VEST); 
        //-------------------------------ITEMS----------------------------------
        Item pen = new BreakableItem(PEN, "It's a fancy blue ballpoint pen.", 
                "You could write momentos to yourself if you had some paper.", 40);
        Item ppr = new Item(NOTEPAD, "This is a stack of many sheets of brown parchment.", 
                "You could write momentos with this if you had a pen.", 15);
        Item lttrOpnr = new Item("letter opener", "It's a very dull knife.", 30);
        //-----------------------------FURNITURE--------------------------------
        Furniture vesOrb = new Vest_Orb();
        Furniture vesFire = new Vest_Fireplace(bckt);
        Furniture vesBtn = new Vest_Button(vesFire);
        Furniture vesWin = new Vest_Window(vesFire);
        Furniture vesDr = new Vest_Dr(Direction.WEST);      
        Furniture vesDsk = new Vest_Desk(pen, lttrOpnr, ppr);
        Furniture vesEtbl = new Vest_EndTable();
        Furniture vesCase = new Vest_Case(rotuKey);
        Furniture vesTpstr = new Vest_Tpstr();
        Furniture vesChr = new Vest_Chair();
        Furniture vesF = new Floor("A cold, shale tile floor. It's slightly dusty.");          
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE COURTYARD">
        //-----------------------------THE ROOM---------------------------------
        Room cou1 = new Cou1("Northwest courtyard", Id.COU1);
        Room cou2 = new Cou2("Southwest courtyard", Id.COU2);
        Room cou3 = new Cou3("Castle courtyard", Id.COU3);
        Room cou4 = new Cou4("Front gate", Id.COU4);
        Room cou5 = new Room("Southeast courtyard", Id.COU5);
        Room cou6 = new Cou6("Northeast courtyard", Id.COU6);
        Room cou8 = new Cou8("Spruce tree", Id.COU8);
        //-------------------------------ITEMS----------------------------------
        Item krnsPlt = new Obs1_Plate("brass plate, \"Saturn\"", "The small plate bears an engraving: \"Saturn\"");
        Item soldMed = new BreakableItem(STONE_DISK, "The smooth disk is about four or five inches across. "
                + "Its craftsmanship is precise, although there's a chip on its edge. "
                + "On its surface is an embossing of a soldier.", 30);
        Item rck = new Item(ROCK, "It's a chunk of the courtyard fountain. "
                + "Plain except for a braided carving across one edge.", 0);
        Item grss = new Item(GRASS, "It's some dark-green grass that you pulled from the ground.", -25);
        Item clvr = new Item("clover", "It's some clover you pulled from the ground.", -25);
        Item trs = new Item(STATUE_TORSO, "It's a stone torso, once attached to the courtyard statue.", 40);
        Item hd = new Item(STATUE_HEAD, "It's a stone head with a chiseled male face. "
                + "It stares at you blankly as you hold it in your palms.", 40);
        Item sprcExtrct = new Liquid(SPRUCE_EXTRACT, "Evergreens are widely known to be resistant to burning.", 35);
        Item brrs = new Item("bright red berry", "Looks firm and juicy...", 
                "You realize, the brightest, reddest berries are the most poisonous of all.", 0);
        Item pnCn = new Item("pine cone", "It's scaly but smooth, and is shaped like a pickle. "
                + "Yes, undoubtedly a spruce pinecone!", "This looks painful to eat...", 0);
        Item fthr = new Item(RAVEN_FEATHER, "It's elegant- jet-black and long. A smooth "
                + "glean runs across it as you tilt it to the light.", 20);
        Item strng = new Item("string", "A delicate piece of white twine.", 10);
        Item ham = new Item(COOKED_HAM, "A succulent glazed ham, still hot!", 300);
        Item leaflet = new Small_Leaflet("small leaflet");
        //-----------------------------FURNITURE--------------------------------
        Furniture couCstl = new Cou_Castle();
        Furniture couW = new Wall("The castle walls are several stories tall and made of rough granite blocks.");
        Furniture couStps = new Cou_Steps();
        Furniture coutWlkwy = new Cou_Tiles();
        Furniture couRvns = new Cou_Ravens();

        Furniture cou1Bnch = new Cou1_Bench();
        Furniture cou1Thrns = new Cou1_Thorns();
        Furniture cou1Hl = new Cou1_Hole(krnsPlt);
        Furniture cou1F = new Cou1_Floor(sl, grss, clvr, cou1Hl, sl, sl, sl);

        Furniture cou2Fntn = new Cou2_Fountain(rck, rck, rck, rck);
        Furniture cou2Bshs = new Cou2_Bushes(brrs);
        Furniture cou2F = new Cou_Floor(sl, grss, clvr, sl, sl, sl);

        Furniture cou3Stps = new Cou3_Steps(Direction.UP, Id.COU7);
        Furniture cou3Ivy = new Cou3_Ivy();
        Furniture cou3Gt = new Cou3_Gate();
        Furniture cou3F = new Cou_Floor(sl, grss, clvr, sl, sl);
        Furniture cou3Frk = new Cou3_Fork(couFrk);

        Furniture cou4Gt = new Cou4_Gate();
        Furniture cou4Frst = new Cou4_Forest();
        Furniture cou4Trl = new Cou4_Trail();
        Furniture cou4Mlbx = new Cou4_Mailbox(leaflet, ham);

        Furniture cou5Fntn = new Cou5_Fountain(rck, soldMed, rck);
        Furniture cou5Sprc = new Cou5_Spruce(vial, sprcExtrct, pnCn, pnCn, pnCn);
        Furniture cou5F = new Cou_Floor(sl, grss, clvr, hd, sl);

        Furniture cou6F = new Cou_Floor(sl, grss, clvr, sl, clvr, trs);
        Furniture cou6Stat = new Cou6_Statue(cou6F);
        Furniture cou6Ghst = new Cou6_BlackJackGhost();
        
        Furniture cou8Sprc = new Cou8_Spruce(vial, sprcExtrct, pnCn, pnCn, pnCn);
        Furniture cou8Nest = new Cou8_Nest(fthr, strng);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE ENTRANCE">
        //-----------------------------THE ROOM---------------------------------
        Room cou7 = new Entr("Front portico", Id.COU7);  
        //-----------------------------FURNITURE--------------------------------
        Furniture entrF = new Floor("The balcony is laid with a brown shale tile.");
        Furniture entrBlcny = new Entr_Balcony();
        Furniture entrClmns = new Entr_Columns();
        Furniture entrRf = new Entr_Roof();
        Furniture entrStats = new Entr_Statues();
        Furniture entrDr = new Entr_Door(Direction.NORTH);
        Furniture entrStps = new Cou3_Steps(Direction.DOWN, Id.COU3);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE FOREST">
        //-----------------------------THE ROOM---------------------------------
        Room for1 = new For1(Id.FOR1);
        Room for2 = new For2(Id.FOR2);
        Room for3 = new For3(Id.FOR3);
        Room for4 = new Forest(Id.FOR4);
        Room for5 = new For5(Id.FOR5);
        //-------------------------------ITEMS----------------------------------
        Item untrRck = new Item("uninteresting rock", "It's a very uninteresting rock.", -50);
        Item untrBrch = new Item("uninteresting branch", "It's a very uninteresting branch.", -50);
        //-----------------------------FURNITURE--------------------------------
        Furniture forTrs = new For_Trees();
        Furniture forThckt = new For_Thicket();
        Furniture forFrst = new For_Forest();
        Furniture forF = new Cou_Floor(sl, grss, clvr, sl, untrRck, untrBrch, untrRck);
        
        Furniture for2Elk = new For2_Elk();
        
        // </editor-fold>

        // </editor-fold>
        // ---------------------------------------------------------------------     
        // <editor-fold defaultstate="collapsed" desc="AREA 2: WEST WING">

        Item brRam = new Item("broken battering ram", "It's a battering ram, "
                + "but without the other rope to hold it with, it's useless.", "It's useless now.", 5);
        Item rdFcs = new Focus(RED_FOCUS, "It's a cool brass ring holding a red lens.");   

        // <editor-fold defaultstate="collapsed" desc="INITIALIZE ROTUNDA">
        //-----------------------------THE ROOM---------------------------------
        Room rotu = new Rotu("Rotunda", Id.ROTU);      
        //-------------------------------ITEMS----------------------------------
        Item crmcShrd = new Weapon("ceramic shard", "It's a broken piece of ceramic. A usable, but inefficient weapon.", 10);
        //-----------------------------FURNITURE-------------------------------- 
        Furniture rotuFntn = new Rotu_Fountain();
        Furniture rotuW = new Wall("A clean white marble wall, polished smoothed and run with carved molding.");
        Furniture rotuF = new Floor("It's a dirty white-tiled floor littered with plant matter.", crmcShrd, crmcShrd);
        Furniture rotuPlnts = new Rotu_Plants(sl, onyxFrag1);
        Furniture rotuHl = new Rotu_Hole();
        Furniture rotuStat = new Rotu_Statue();
        Furniture rotuScnc = new Rotu_Sconce();
        Furniture rotuFrms = new Rotu_Frames();
        Furniture rotuSky = new Rotu_Sky();
        Furniture rotuRock = new Rotu_Rock();
        // </editor-fold>    
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE CELLAR">
        //-----------------------------THE ROOM---------------------------------
        Room cel1 = new Room("Under the balcony", Id.CEL1);
        Room cel2 = new Room("Cellar", Id.CEL2);
        Room cel3 = new Room("Cellar", Id.CEL3);
        Room cel4 = new Room("Cellar", Id.CEL4);
        Room cel5 = new Room("Cellar", Id.CEL5);
        Room cel6 = new Cel6("Suspended platform", Id.CEL6);
        //-------------------------------ITEMS----------------------------------
        Item hmmr = new Weapon(HAMMER, "It's a small hand-held nailing device.", 30);
        Item greasyRag = new Item("greasy rag", "A small white cloth stained black with grease.", -20);
        Item wrench = new Weapon(MONKEY_WRENCH, "A hefty tool for the turning of many things.", 15);
        Item loopedRope = new Item(LOOPED_ROPE, 
                "It's a short rope tied into a noose. It's pretty frayed in the center.", ram, 3, 25);
        Item coal = new Item(COAL, "A simple lump of coal.", -20);
        //-----------------------------FURNITURE--------------------------------
        Furniture celLntrn = new Cel_Lantern();
        Furniture celPp = new Cel_Pipe();
        Furniture celF = new Floor("This floor is unkept. It's made of old, "
                + "dusty floorboards that reflect nearly no light at all.");
        Furniture nrthCelClng = new Ceiling("The ceiling is arched and made of cobblestone here.");
        Furniture cel2Clng = new Ceiling("Many parallel wooden spines give support "
                + "to the ceiling here.");
        
        
        Furniture cel1Lddr = new Cel_Ladder(Id.LOOK, Direction.UP);
        
        Furniture cel2Shft = new Cel2_Shaft();
        Furniture cel2Vlv = new Cel_Valve(rotuFntn);
        
        Furniture cel3Crt = new Cel3_Crate(celTblt);
        Furniture cel3Vlv = new Cel3_Valve(rotuFntn, wrench);
        
        Furniture cel4Coal = new Cel4_Coal(coal);
        Furniture cel4Wrkbnch = new Gqua_Workbench(hmmr, greasyRag, wrench, loopedRope, vial);
        Furniture cel4Bd = new Cel4_Bed();
        
        Furniture cel5Frnc = new Cel5_Furnace();
        Furniture cel5Lck = new Cel5_Lock();
        Furniture cel5Grt = new Cel5_Grate();
        
        Furniture cel6Pltfrm = new Cel6_Platform();
        Furniture cel6Lddr = new Cel_Ladder(Id.CEL5, Direction.UP);
        Furniture cel6Vlv = new Cel_Valve(rotuFntn);
        Furniture cel6Clmns = new Cel6_Columns();
        Furniture cel6Lghts = new Cel6_Lights();
        Furniture cel6Pp = new Cel6_Pipe();
        
        // </editor-fold>   
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE LOOKOUT">
        //-----------------------------THE ROOM--------------------------------- 
        Room look = new Look("Lookout", Id.LOOK);       
        //-----------------------------FURNITURE-------------------------------- 
        Furniture lookDr = new Look_TrapDoor();
        Furniture lookLghths = new Look_Lighthouse();
        Furniture lookClff = new Look_Cliff();
        Furniture lookRlng = new Look_Railing();
        Furniture lookF = new Floor("Just a wet shale floor.");
        // </editor-fold> 
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE SIDE HALL">
        //-----------------------------THE ROOM---------------------------------
        Room iha1 = new Iha1("North side hall", Id.IHA1);
        Room iha2 = new Iha2("South side hall", Id.IHA2);
        //-------------------------------ITEMS----------------------------------
        Item iha2plArm = new Weapon(POLEARM, 
                "It's an old medieval polearm. It's simple but firm, composed of nothing but a wood staff and forged iron point.", 30);
        //-----------------------------FURNITURE--------------------------------
        Furniture iha1Lvr = new Iha1_Lever();
        Furniture iha1Armr = new Iha1_Armor();
        Furniture iha2Armr = new Iha2_Armor(iha2plArm);     
        Furniture ihaF = new Floor("A sandstone tiled floor. Small, loose grains grind against your shoes as you walk.");
        Furniture ihaWndw = new Iha_Window();
        Furniture iha1Bwl = new Iha1_Bowl(ihaF, wow2Key);
        Furniture iha2Bwl = new Iha2_Bowl();
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE WEST OUTER WALL">
        //-----------------------------THE ROOM---------------------------------
        Room wow1 = new Room("West outer wall", Id.WOW1);
        Room wow2 = new Wow2("West outer wall", Id.WOW2);
        //-------------------------------ITEMS----------------------------------
        Item vinegar = new Liquid(BOTTLE_OF_VINEGAR, "A bottle of yellow liquid. Printed on the label is \"C2H4O2\"", 25);
        Item wowLddr = new BreakableItem(FIXED_LADDER, "The spoke sits in there a bit awkwardly, but it "
                              + "seems like a good ladder. It may even support your heft.", 25);   
        Item wow1Spk = new Item(WHEEL_SPOKE, "It's a wooden rod, about a foot long.", wowLddr, 3, 0);
        Item clngSoln = new Liquid(CLEANING_SOLUTION, "It smells lemony fresh, unlike the rest of this room.", 25);
        Item rppdBrlp = new Item("ripped burlap", "It must have belonged to the broken cart in the west wing.", 5);
        Item actn = new Liquid(ACETONE, "It's a strong-smelling solvent in a glass jar.", 25);
        //-----------------------------FURNITURE--------------------------------
        Furniture wow2Lddr = new Wow2_Ladder(Direction.UP, Id.WOW3); // Not in WOW2 to start.
        Furniture wow2Armr = new Wow2_Armor();
        Furniture wow1Crt = new Wow1_Cart(wow1Spk, rppdBrlp);
        Furniture wow1F = new Floor("A sandstone tiled floor. Small, loose grains grind against your shoes as you walk.");
        Furniture wow2Blcny = new Wow2_Balcony(wow2Lddr, wowLddr); // Fixed ladder can be used on this.
        Furniture wow2F = new Wow2_Floor(wow2Lddr, wowLddr); // Fixed ladder can be used on this.
        Furniture wow2Dr = new Wow2_Door(Direction.EAST);
        Furniture wow2Hole = new Wow2_Hole();
        Furniture wowWndw = new Wow_Window();
        Furniture wowHrth= new Wow_Hearth(bckt);
        Furniture wow2Strcs = new Wow2_Stairs(); 
        Furniture wow1NDr = new Sha_Door(Direction.NORTH);
        Furniture wow1Shlvs = new Wow1_Shelves(vial, vinegar, clngSoln, actn);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE BEACON">
        //-----------------------------THE ROOM---------------------------------
        Room wbal = new Wbal("Beacon", Id.WBAL);   
        //-------------------------------ITEMS----------------------------------
        Item wbalch = new Item("rotted wooden chunk", "It's a rotted chunk of wood.", -50);
        Item wbalsp = new Item("wood splinter", "It's a splinter of wood.", -25);
        Item wbalbr = new Item("branch", "A plain branch from a tree. Nothing too interesting.", -25);
        Item wbalBrg = new Item("broken rod", "It looks like it belonged to a ladder.", -25);
        Item wbalRng = new Item("wooden rod", "It's a wooden rod, about a foot long.", wowLddr, 3, 10);
        //-----------------------------FURNITURE--------------------------------
        Furniture wbalF = new Floor("A shale tile floor. Many pieces of wood litter it.", 
                                    wbalch, wbalbr, wbalBrg, wbalsp, wbalsp, wbalRng, wbalbr, wbalch, wbalch);
        Furniture wbalBcn = new Wbal_Beacon();
        Furniture wbalFrst = new Wbal_Forest();
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE SERVANTS QUARTERS">
        //-----------------------------THE ROOM---------------------------------
        Room squa = new Room("Servant's quarters", Id.SQUA);
        //-------------------------------ITEMS----------------------------------
        Item squaLddr = new Squa_Ladder("broken ladder", wowLddr, 3);
        Item squaJrnl = new Note("note: ladder", 
                "Need to get that ladder fixed. Too busy with the cart. "
                + "Don't ask mages to fix, they've been busy lately. I'll keep it under my bed for now.");
        Item rags = new Clothing("worn rags", "Some dirty worn rags.", 
                "You are perfectly content with the clothes you have on now.", 5);
        Item aprn = new Clothing("kitchen apron", 
                "It's a kitchen apron, stained black in the center from ash.", 
                "You are perfectly content with the clothes you have on now.", 25);
        Item shs = new Shoes("moccasins", 
                "A pair of worn leather moccasins. The leather has worn thin and the seams are separating.", 
                "You put on the moccasins. They're quite uncomfortable.", 10);
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
        Room clos = new Room("Utility closet", Id.CLOS);
        //-------------------------------ITEMS----------------------------------
        Item closCrwbr = new Weapon(CROWBAR, "A sweet iron crowbar.", 30);
        Item shvl = new Weapon(SHOVEL, "A sturdy pointed shovel for the digging of holes.", 30);
        Item sd = new Item(SEED, "It's a handful of mysterious gardening wizardry.", 0);
        Item gl = new Liquid(GLUE_BOTTLE, "It's a glass bottle of sticky glue. It's yellowish tinge clues you that it's the type for wood.", 15);
        Item closGlv = new Clothing(RUBBER_GLOVES, "A pair of thick rubber gloves.", 
                "It's difficult, but you manage to fit them on your hands.", 15);
        Item closStrw = new Item("straw", "It's just straw.", 5);
        Item scrwDrvr = new Item(SCREWDRIVER, "A small phillips-head screwdriver with a plastic handle. "
                + "The tool seems perhaps a tad out of place in an old establishment like this.", 25);
        Item scrw2 = new Item("2mm screw", "Just a small screw.", 15);
        Item scrw5 = new Item("5mm screw", "Just a small screw.", 15);
        //-----------------------------FURNITURE--------------------------------
        Furniture closDr = new Wow2_Door(Direction.WEST);
        Furniture closLddr = new Gqua_Ladder(Direction.DOWN, Id.COUS);
        Furniture closClng = new Gqua_Ceiling();
        Furniture closF = new Floor("It's a cold, hard, cobblestone floor", closStrw);
        Furniture closScks = new Gqua_Sacks(sd, sd, sd, frt, frt, frt, snd, snd, snd, snd, snd);
        Furniture closShlf = new Gqua_Shelf(bckt, closGlv, vial, shvl, pot, pot);
        Furniture closWrkbnch = new Gqua_Workbench(gl, hmmr, scrw2, scrwDrvr, scrw2, scrw5, scrw5);
        Furniture closStl = new Gqua_Stool();
        Furniture closBrrl = new Gqua_Barrel();
        Furniture closW = new Wall("It's a plain cobblestone wall.");
        Furniture closSkltn = new Gqua_Skeleton(closCrwbr);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE WEST OUTER WALL BALCONY">
        //-----------------------------THE ROOM---------------------------------
        Room wow3 = new Wow3("Balcony", Id.WOW3, wow2Lddr, wow2F, wowLddr);
        //-------------------------------ITEMS----------------------------------
        Item wowRope = new Item("rope", "It's a short, coiled rope.", ram, 3, 25);
        //-----------------------------FURNITURE--------------------------------
        Furniture wow3Shlf = new Wow3_Shelf(wowRope, closKey);
        Furniture wow3F = new Floor("A sandstone tiled floor. Small, loose grains grind against your shoes as you walk.");
        Furniture wow3NDr = new Wow3_NorthDoor();
        Furniture wow3Dr = new Wow3_Door(Direction.EAST);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE RANSACKED QUARTERS">
        //-----------------------------THE ROOM---------------------------------
        Room shar = new Room("Ransacked quarters", Id.SHAR);
        //-------------------------------ITEMS----------------------------------
        Item cmb = new Item("comb", "A plain hair comb.", "You comb your beard for several seconds until it's nice and kept.", 25);
        Item cndlStk = new Weapon("candlestick", "A small brass candlestick.", 40);
        Item sht = new Item("sheet", "A plain white bedsheet.", 15);
        //-----------------------------FURNITURE--------------------------------
        Furniture rquaBd = new Rqua_Bed();
        Furniture rquaWmn = new Rqua_WomanNPC();
        Furniture rquaClths = new Rqua_Clothes();
        Furniture rquaMttrss = new Rqua_Mattress();
        Furniture rquaTbl = new Rqua_Table();
        Furniture rquaDrssr = new Rqua_Dresser();
        Furniture rquaF = new Floor("A sandstone tiled floor. Small, loose grains grind against your shoes as you walk.", 
                rags, cmb, rags, sht, cndlStk, rags, shs);
        Furniture rquaPnl = new Rqua_Panel(studKey, rquaBd);
        
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE SERVANTS HALL">
        //-----------------------------THE ROOM---------------------------------
        Room sha2 = new Room("North servant's hall", Id.SHA2);
        Room sha1 = new Sha1("South servant's hall", Id.SHA1);
        //-------------------------------ITEMS----------------------------------
        Item wdChnk = new Wood_Chunk(WOOD_LOG, ram, 3);       
        Item shaMp = new Item(MOP, "It's a classic mop.", "Yes, let's just make this a game about cleaning.", 25);
        Item shaSpng = new Item("sponge", "It's a quintessential square yellow sponge.", "I'm not a maid!", 5);
        //-----------------------------FURNITURE--------------------------------       
        Furniture sha2Cbnt = new Sha2_Cabinet(wdChnk, shaSpng, shvl, shaMp, bckt);
        Furniture shaF = new Floor("A sandstone tiled floor. Small, loose grains grind against your shoes as you walk.");
        Furniture sha2Dr = new Sha_Door(Direction.WEST);
        Furniture sha1SDr = new Sha_Door(Direction.SOUTH);
        Furniture sha1Trch = new Torch_Holder(torch);
        Furniture sha2Trch = new Torch_Holder(torch);
        Furniture sha1Dr = new Sha1_Door(ram, brRam, genDoor);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE SCORCHED ROOM">
        //-----------------------------THE ROOM---------------------------------
        Room cous = new Cous("Scorched room", Id.COUS);
        //-------------------------------ITEMS----------------------------------
        Item wrhmmr = new Item(WARHAMMER, "It's an old medieval warhammer. The head looks extremely worn and dull.", 35);
        Item ash = new Item(ASH, "You're pretty sure there are people mixed in with this.", -30);
        Item wd = new Item("charred wood", "It's a piece of burnt wood", -25);
        //-----------------------------FURNITURE-------------------------------- 
        Furniture searFssr = new Sear_Fissure();
        Furniture searDr = new Sear_Door();
        Furniture searAsh = new Sear_Ash(ash);
        Furniture searWood = new Sear_Wood(wd);
        Furniture searSkltn = new Sear_Skeleton(closCrwbr);
        Furniture searLddr = new Gqua_Ladder(Direction.UP, Id.CLOS);
        Furniture searF = new Floor("It's a cold, hard, cobblestone floor", ash, wd, ash, wrhmmr, wd, ash);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE STUDY">
        //-----------------------------THE ROOM---------------------------------
        Room stud = new Stud("Study", Id.STUD);
        //-------------------------------ITEMS----------------------------------
        Item studBkPi = new Stud_PiBook("book, 'An Essential Pi'");
        Item studNote = new Stud_Note("personal note");
        Item studNote2 = new Note("sketches", 
                "There are four drawings on this sheet of parchment. They're detailed sketches, "
              + "not just simple doodles. You can identify a drawing of a chalice, some kind of "
              + "fruit (A pome perhaps), a thick tome, and a scepter. In the middle, however, is "
              + "just a scribble. A shapeless mass of ink that does not resemble anything at all.");
        //-----------------------------FURNITURE-------------------------------- 
        Furniture studSafe = new Stud_Safe(367, studBkPhy, gal1Key);
        Furniture studF = new Floor("The floor is a weathered dark hickory that creaks slowly as you walk.");
        Furniture studPrtrt = new Stud_Portrait(studSafe);
        Furniture studFire = new Stud_Fireplace(bckt);
        Furniture studDsk = new Stud_Desk(pen, ppr, studNote2, servKey, studNote);
        Furniture studBkCs = new Stud_BookCase(studBkPi);
        Furniture studCch = new Stud_Couch();
        Furniture studCrpt = new Stud_Carpet();
        // </editor-fold>

        // </editor-fold>
        // ---------------------------------------------------------------------     
        // <editor-fold defaultstate="collapsed" desc="AREA 3: EAST WING">

        // <editor-fold defaultstate="collapsed" desc="INITIALIZE TROPHY ROOM">
        //-----------------------------THE ROOM---------------------------------
        Room gal5 = new Room("Trophy room", Id.GAL5);
        //-------------------------------ITEMS----------------------------------
        Item zsPlt = new Obs1_Plate("brass plate, \"Jupiter\"", "The small plate bears an engraving: \"Jupiter\"");
        Item emrld = new BreakableItem(GLOWING_EMERALD, 
                "The emerald pulses with a bright glow. This looks pretty important.", 
                "This belongs to someone important.", 300);
        Item aqmrn = new BreakableItem(AQUAMARINE, 
                "It's a beautiful square blue gem, likely a trophy of sorts and not belonging to a larger object.", 225);
        Item rby1 = new BreakableItem(RUBY, "The ruby is well cut and clean, having been protected in the case for so long.", 200);
        //-----------------------------FURNITURE--------------------------------
        Furniture gal5Dr = new Gal4_Door(Direction.SOUTH);
        Furniture gal5Dsply = new Gal5_Display(rby1, emrld, aqmrn);
        Furniture gal5Chndlr = new Gal5_Chandelier();
        Furniture gal5Cbwbs = new Cobweb();
        Furniture gal5Clng = new Gal5_Ceiling();
        Furniture gal5F = new Floor("The floor is a gray and white checkered tile lightly coated in dust.");
        Furniture gal5W = new Wall("The walls are just plain granite brick, supported by curved wooden struts which meet at the room's apex in an arch.");
        Furniture gal5Cbt = new Gal5_Cabinet(zsPlt);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE GALLERY">
        Furniture gal3Lddr = new Gal3_Ladder();
        Furniture gal3Rp = new Gal3_Rope(gal3Lddr);
        //-----------------------------THE ROOM---------------------------------    
        Room gal1 = new Gal1("First floor gallery", Id.GAL1);
        Room gal2 = new Room("Central chamber", Id.GAL2);      
        Room gal3 = new Gal3("Second floor gallery", Id.GAL3, gal3Rp);
        Room gal4 = new Room("Second floor balcony", Id.GAL4);
        Room gal6 = new Gal6("Gallery loft", Id.GAL6);
        Room gal7 = new Room("Gallery loft", Id.GAL7);
        //-------------------------------ITEMS----------------------------------
        Item scrw1 = new Item("1mm screw", "It's a tiny little screw.", rdFcs, 3, 0);
        Item blFcs = new Focus(BLUE_FOCUS, "It's a cool brass ring holding a blue lens.");
        Item yllwFcs = new Focus(YELLOW_FOCUS, "It's a cool brass ring holding a yellow lens.");
        Item drkFcs = new Focus(DARK_FOCUS, "It's a cool brass ring holding a tinted lens.");
        Item fnnyOrb = new BreakableItem(CRYSTAL_ORB, 
                "It's extremely clean, and it contains a peculiar gas, the color of which you cannot quite describe.", 150);
        Item bxThngy = new BreakableItem(DEAD_BATTERY, "The box has surprising weight. "
                + "A metal strip and single spring are attached to the top."
                + "If you didn't know better, you'd call it a battery, probably "
                + "for auxiliary power. It seems mostly dead of power.", 150);
        //-----------------------------FURNITURE--------------------------------         
        Furniture gal7Stat = new Gal7_Statue();
        Furniture gal4Stat = new Gal4_Statue(gal7Stat);
        Furniture gal2Stat = new Gal2_Statue(gal4Stat);
        Furniture gal2Mchn = new Gal2_Machine(bxThngy);

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
        Furniture gal1W = new Wall("The wall is tiled a dark green and purple. Interesting choice.");
        Furniture gal1Sclptrs = new Gal1_Sculptures();
        Furniture gal1Pntngs = new Gal1_Paintings();
        Furniture gal1Pntng3 = new Gal1_Painting3();
        Furniture gal1Pntng2 = new Gal1_Painting2();
        Furniture gal1Pntng = new Gal1_Painting1();
        Furniture gal1Hrth = new Gal1_Hearth(bckt);

        Furniture gal3Ttm = new Gal3_Totem(gal4Stat);
        Furniture gal3Peg = new Gal3_Peg(gal3Ttm);
        Furniture gal3Sgmnt = new Gal3_Segment(gal3Ttm);
        Furniture gal3Swtch = new Gal3_Switch();
        Furniture gal3InstFurn = new Gal3_KoraFurniture();
        Furniture gal3Msk = new Gal3_Mask1();
        Furniture gal3Msk2 = new Gal3_Mask2();
        Furniture gal3Msk3 = new Gal3_Mask3();
        Furniture gal3Msks = new Gal3_Masks();
        Furniture gal3Hrth = new Gal3_Hearth(bckt);
        Furniture gal3F = new Floor("The floor is a dark hardwood.");
        Furniture gal3W = new Wall("The wall an off-white plaster, creating an atmospheric warmth.");
        Furniture gal3Art = new Gal3_Artifact1();
        Furniture gal3Art2 = new Gal3_Artifact2();
        Furniture gal3Art3 = new Gal3_Artifact3();
        Furniture gal3Arts = new Gal3_Artifacts();
        Furniture gal3Htch = new Gal3_Hatch();
        Furniture gal3Hl = new Gal3_Hole();

        Furniture galDm = new Gal_Dome();
        Furniture gal2Clmns = new Gal2_Columns();
        Furniture galBalc = new Gal_Balcony();
        Furniture gal2F = new Floor("This room's floor is magnificent. It's solid marble and resembles a giant compass.");
        Furniture gal2W = new Wall("The wall here is an ornate white-paneled wood.");
        Furniture gal2Strcs = new Gal2_Staircase(Direction.UP, Id.GAL4);
        
        Furniture gal4Glss = new Gal4_Glass();
        Furniture gal4Cs = new Gal4_Case(monaLisa);
        Furniture gal4Lck = new Gal4_Padlock(gal4Cs);
        Furniture gal4Dr = new Gal4_Door(Direction.NORTH);
        Furniture gal4Lft = new Gal4_Loft();
        Furniture gal4Strcs = new Gal2_Staircase(Direction.DOWN, Id.GAL2);
        Furniture gal4Rdo = new Gal4_Radio(scrw1);
        Furniture gal4F = new Floor("The floor here is checkered gray and tan in a smooth rock. Running along the floor around the balcony is a royal blue carpet-runner.");
        Furniture gal4Crpt = new Gal4_Carpet();
        Furniture gal4Lvr = new Gal4_Lever();

        Furniture gal6Htch = new Gal6_Hatch();
        Furniture gal6Cnn = new Gal6_Canon(gal7Stat);
        Furniture gal6Lddr = new Gal6_Ladder();
        Furniture gal6Hlmt = new Gal6_Helmet();
        Furniture gal6Mchn = new Gal6_Machine();
        Furniture gal6Bttn = new Gal6_Button();
        Furniture gal6App = new Gal6_Apparatus();
        Furniture gal6F = new Floor("The floor is a dark hardwood.");
        Furniture gal6W = new Wall("The wall is paneled in a classy mahogany.");
        Furniture gal6Tech = new Gal6_Technology();
        Furniture gal6Elec = new Gal6_Technology();
        Furniture gal6Tbl = new Gal6_Table();
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE DINING ROOM">
        //-----------------------------THE ROOM---------------------------------
        Room din1 = new Din1("Dining room", Id.DIN1);  
        Room din2 = new Din2("Dining room balcony", Id.DIN2);
        //-------------------------------ITEMS----------------------------------
        Item aphrdtPlt = new Obs1_Plate("brass plate, \"Venus\"", "The small plate bears an engraving: \"Venus\"");
        Item frk = new Item("silver fork", "It's an ornately carved silver fork.", 
                "You comb your beard with the fork until it's straight and tidy.", 75);
        Item plt = new Item("silver platter", "It's shiny silver platter, polished ad nauseum.", 80);
        Item spn = new Item("silver spoon", "It's an ornately carved silver fork.", 
                "You attempt to comb your beard with the spoon, but it's not working so well.", 75);
        Item npkn = new Item("napkin", "A silky white cloth napkin. A luxury napkin indeed.", 
                "You wipe the sweat off your forehead. Carrying all these items has taken its toll on you.", 60);
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
        Furniture din1Strs = new Din1_Stairs(Direction.UP, Id.DIN2);
        Furniture din1Crpt = new Din1_Carpet();
        Furniture din1F = new Floor("The floor is a light gray stone. A large rectangular "
                                  + "lavender carpet covers much of it.");
        Furniture din1W = new Wall("The walls of this room are gray stone with dark wood paneling at the bottom.");
        Furniture din1Dr = new Din1_Door(Direction.WEST);

        Furniture din2F = new Floor("The floor is laid with square light-gray tiles.");
        Furniture din2W = new Wall("The walls up here are smooth rock paneled on the lower half with vertical wooden slats.");
        Furniture din2Pntng = new Din2_Painting();
        Furniture din2Strs = new Din1_Stairs(Direction.DOWN, Id.DIN1);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE MARBLE HALL">
        //-----------------------------THE ROOM---------------------------------
        Room mha1 = new Mha1("North marble hall", Id.MHA1);
        Room mha2 = new Room("Marble hall", Id.MHA2);
        Room mha3 = new Room("South marble hall", Id.MHA3);
        //-------------------------------ITEMS----------------------------------       
        Item angMed = new Item(ANGEL_MEDALLION, 
                "It's a beautiful gold disk about four or five inches across. "
                        + "An angel is embossed on the surface.", 130);
        Item horMed = new Item(HORSE_MEDALLION, 
                "It's a silver disk about four or five inches across. "
                        + "On its surface is an embossing of a galloping horse.", 90);
        //-----------------------------FURNITURE--------------------------------  
        Furniture mhaChndlr = new Mha_Chandelier();
        Furniture mhaF = new Floor("Large tiles running diagonally to the hall cover the floor. "
                + "Their bright green hue is uncanny and must be artificial.");
        Furniture mhaW = new Wall("The walls are plain white granite. All that occupy them are the tall windows.");
        Furniture mhaNWndw1 = new Mha1_Window();
        Furniture mhaNWndw2 = new Mha1_Window();
        Furniture mhaSWndw = new Mha3_Window();
        Furniture mhaNChaDr = new Mha1_Door(Direction.EAST);
        Furniture mhaNDr = new Mha_Door(Direction.NORTH);
        Furniture mhaSDr = new Mha_Door(Direction.SOUTH);
        Furniture mhaWDr = new Mha_Door(Direction.WEST);
        Furniture mha3KitcDr = new Mha3_Door(Direction.EAST);
        Furniture mhaMDr = new Mha2_Door(Direction.EAST);
        Furniture mha1Plnt = new Mha_Plant(sl, stnHd);
        Furniture mha2Plnt = new Mha_Plant(sl, onyxFrag2);
        Furniture mha3Plnt = new Mha_Plant(sl, stnBs);
        Furniture mhaChr = new Mha_Chair();
        Furniture mhaRStat = new Mha2_RightStatue(angMed);
        Furniture mhaLStat = new Mha2_LeftStatue();
        Furniture mhaStats = new Mha2_Statues(mhaRStat);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE WORKSHOP">
        //-----------------------------THE ROOM---------------------------------
        Room work = new Room("Workshop", Id.WORK);
        //-------------------------------ITEMS----------------------------------
        Item redLns = new BreakableItem("red lens", "It's a proper lens tinted red. Maybe you should pick up the glass trade!", rdFcs, 3, 60);
        Item rdDy = new Item(RED_DYE, "You have a handful of soft red powdered dye. It's quite soft and powdery.", 15);
        Item blDy = new Item(BLUE_DYE, "You have a handful of soft blue powdered dye. It's quite soft and powdery.", 15);
        Item yllwDy = new Item(YELLOW_DYE, "You have a handful of soft yellow powdered dye. It's quite soft and powdery.", 15);
        Item stncl = new Item(LENS_TEMPLATE, "It's a sheet of metal with a small hole cut in it.", 20);
        Item wrkNt = new Wrk_Note("ingredient order");
        Item ptsh = new Item(POTASH, "Good old potassium-rich potash salts!", 5);
        //-----------------------------FURNITURE--------------------------------
        Furniture wrkF = new Floor("A sandstone tiled floor, blackened and dirty from ash.", snd);
        Furniture wrkBrl = new Wrk_Barrel(rdDy, rdDy, blDy, blDy, yllwDy, yllwDy);
        Furniture wrkCbnt = new Wrk_Cbnt(hmmr, gl, ptsh, ptsh);
        Furniture wrkCstTbl = new Wrk_CastingTable(wrkBrl, closScks, 
                redLns, snd, rdDy, blDy, yllwDy, ptsh, wrkCbnt);
        Furniture wrkKln = new Wrk_Kiln();
        Furniture wrkBnch = new Gqua_Workbench(stncl, wrkNt);        
        Furniture wrkAnvl = new Wrk_Anvil();
        Furniture wrkFrg = new Wrk_Forge();
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE EAST OUTER WALL">
        //-----------------------------THE ROOM---------------------------------
        Room eow1 = new Room("East outer wall", Id.EOW1);
        Room eow2 = new Room("East outer wall", Id.EOW2);
        Room eow4 = new Eow4("Balcony", Id.EOW4);
        //-------------------------------ITEMS----------------------------------
        Item wtrBckt = new Liquid(BUCKET_OF_WATER, "It's a metal bucket filled with water.", 25);
        Item eowSwrd1 = new Weapon("silver sword", "The sword is finely polished and tapers evenly "
                + "to a fine point at the end. Though possibly ornamental, "
                + "silver is known to be effective against werewolves.", 100);
        Item eowSwrd2 = new Weapon("rusty sword", "The sword is rusty and a little dull, "
                + "but still somewhat effective. The sword has certainly met its fair share of enemy blades in its life.", 20);
        Item eowSwrd3 = new Weapon("broken sword", "This sword is broken halfway down the blade. "
                + "This is a mark of poor craftsmanship. Likely, the metal was "
                + "reheated and cooled too many times during the forging.", 10);
        Item eowSSpr = new Weapon(SILVER_SPEAR, "This is beautiful! It's solid metal with a silvery shine.", 100);
        Item woodSpr = new Weapon("wooden spear", "This looks like a plain wooden spear. "
                + "A bit primitive looking, and probably not built to last.", 15);
        Item eowPlArm = new Weapon(POLEARM, "This is a typical polearm, plain but very functional as a defense implement.", 30);
        Item eowAx = new Weapon("war ax", "This type of tool excites you. Small and sharp for agile use. "
                + "An effective tool for both offense and tree chopping.", 40); 
        Item eowBtlAx = new Weapon("battle ax", "Essentially a long ax with a double sided blade. "
                + "This weapon has so much heft. You wonder if it were ever effective at all in battle.", 40);
        //-----------------------------FURNITURE--------------------------------
        Furniture eowF = new Floor("It's a sandstone tiled floor, just like that of the west wing.");

        Furniture eow1Dr = new Eow1_Door(Direction.WEST);
        Furniture eow1Rck = new Eow1_Rack(eowSwrd1, eowBtlAx, eowSwrd2, eowSwrd3, eowSwrd2, eowAx);
        Furniture eow1Bskt = new Eow1_Basket(eowPlArm, woodSpr, woodSpr, eowPlArm);
        Furniture eow1Trch = new Torch_Holder(torch);

        Furniture eow2Fntn = new Eow2_Fountain();
        Furniture wtr = new Water(wtrBckt);
        Furniture eow2Rck = new Eow1_Rack(eowSwrd1, eowSwrd2, eowSSpr, woodSpr, eowBtlAx);
        Furniture eow2Strs = new Eow2_Stairs(Direction.UP, Id.EOW4);
        Furniture eow2Blcny = new Eow2_Balcony();
        Furniture eow2Cbnt = new Eow2_Cabinet(bckt, shaMp, shvl, vinegar);
        Furniture eow2Trch = new Torch_Holder(torch);

        Furniture eow4F = new Floor("It's a sandstone tiled floor.");
        Furniture eow4Strs = new Eow2_Stairs(Direction.DOWN, Id.EOW2);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE LIBRARY">
        Furniture lib4Tbl = new Lib4_Table("table", fnnyOrb);
        //-----------------------------THE ROOM---------------------------------
        Room lib2 = new Lib2("North library", Id.LIB2);
        Room lib3 = new Lib3("South library", Id.LIB3);
        Room lib4 = new Lib4("North upper library", Id.LIB4, lib4Tbl);
        Room lib5 = new Lib5("South upper library", Id.LIB5);
        //-------------------------------ITEMS----------------------------------
        Item cndl = new BreakableItem(CANDLE, 
                "It's a white candle. Must have been burning for some time.", 15);
        Item shs1 = new Shoes(LEATHER_SHOES, 
                "A fancy pair of shiny leather shoes.", 
                "You put on the shoes. They're a little big, but comfortable!", 60);
        Item shs2 = new Shoes("worn shoes", 
                "A worn, dull pair of leather shoes.", 
                "You put on the shoes. These aren't too comfortable.", 10);
        Item shs3 = new Shoes(NIGHT_SLIPPERS, 
                "A brown pair of cotton night slippers.", 
                "You wear the slippers. You could wear these all day!", 60);
        Item shs4 = new Shoes(WORK_BOOTS, 
                "A pair of boots with thick rubber insulating soles.", 
                "You put on the boots.", 15);
        Item fin = new Lib_FinnishBook("language, 'The Essential Finnish'");
        Item bbl = new Lib_GenesisBook(BIBLE);
        Item ody = new Lib_OdysseyBook(ODYSSEY);
        Item ili = new Lib_IlliadBook(ILIAD);
        Item inf = new Lib_DantesInfernoBook(DANTES_INFERNO);
        Item par = new Lib_ParadiseLostBook(PARADISE_LOST);
        Item bkGlss = new Lib_GlassBook("guide, 'The Master Glasser'");
        Item bkNts = new Lib_NotesBook("self help, 'Note To Self'");
        Item bkGlsswr = new Labo_GlasswareBook("manual, 'You Aren't Chemist'");
        //-----------------------------FURNITURE--------------------------------
        Furniture libLF = new Floor("The floor is a rough, dark blue stone.");
        Furniture libUF = new Floor("The floor is a rough, dark blue stone.");
        Furniture libW = new Wall("A classy mahogany paneled wall. Mahogany, having the highest IQ of any wood.");
        Furniture libCch = new Lib_Couch();
        Furniture libBkShlf = new Lib_BookShelf();
        Furniture libScncs = new Lib_Sconces();

        Furniture lib3Stat = new Lib3_Statue(horMed);

        Furniture lib2ShRck = new Lib2_ShoeRack(shs3, shs2, shs1, shs4);
        Furniture lib2Stat = new Lib2_Statue();
        Furniture lib2Frplc = new Lib2_Fireplace(bckt);
        Furniture lib2Bttn = new Lib2_Button(lib2Frplc, lib3Stat);
        Furniture lib2WrFr = new Lib2_WarefareShelf(inf, fin);
        Furniture lib2Wndw = new Lib2_Window();

        Furniture lib3Pllr = new Lib_Pillar();
        Furniture lib3Strs = new Lib_Stairs(Direction.UP, Id.LIB4);
        Furniture lib3Crtn = new Lib3_CreationShelf(ody, bkGlsswr);
        Furniture lib3Blcny = new Lib_Balcony();
        Furniture lib3Wndw = new Lib3_Window();
        Furniture lib3Pntng = new Lib3_Painting();

        Furniture lib4Frplc = new Lib2_Fireplace(bckt);
        Furniture lib4Bttn = new Lib4_Button(lib4Frplc, lib3Stat);
        Furniture lib4Prdtn = new Lib4_PerditionShelf(ili, bkNts);
        Furniture lib4Glb = new Lib4_Globe();
        Furniture lib4Stat = new Lib4_Statue();
        Furniture lib4Strs = new Lib_Stairs(Direction.DOWN, Id.LIB3);

        Furniture lib5Bnshmnt = new Lib5_BanishmentShelf(bbl);
        Furniture lib5Cndlbr = new Lib5_Candelabra(cndl);

        Furniture lib2Vyg = new Lib2_VoyageShelf(lib2WrFr, lib3Crtn, lib4Prdtn, lib5Bnshmnt, par, bkGlss);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE SECRET ARCHIVES">
        //-----------------------------THE ROOM---------------------------------
        Room lib1 = new Room("Secret archives", Id.LIB1);
        //-------------------------------ITEMS----------------------------------
        Item lib1Schmtc = new Lib1_Schematic("architectural plan");
        Item lib1Nt1 = new Lib1_Note1("account, page 1");
        Item lib1Nt2 = new Lib1_Note2("account, page 2");
        Item lib1Nt3 = new Lib1_Note3("account, page 3");
        Item lib1Nt4 = new Lib1_Note4("account, page 4");
        Item lib1Lst = new Lib1_List("artifact report");
        Item lib1ImpNt = new Lib1_ImportantNote("schematic: disc");
        Item lib1Pln = new Lib1_Plan("schematic: vessel");
        Item brkLns = new Item("cracked lens", "The red-tinted lens is cracked all the way through.", 
                "You think this has lost its purpose by now.", 5);
        Item brssRng = new Item("brass ring", "It's an unhinged shiny brass ring with a groove lining the inside. "
                + "There's a small hole in each end, about 1mm diameter. Looks like a screw is missing.", rdFcs, 3, 25);
        //-----------------------------FURNITURE--------------------------------
        Furniture lib1Docs = new Lib1_Documents();
        Furniture lib1F = new Floor("It's a dusty wood parquet floor. Years of neglect "
                + "have reduced its shine to a dull matte finish.", lib1Nt1);
        Furniture lib1W = new Wall("The walls are just horizontal wood slats, separated "
                + "slightly as to see the underlying structural rock.");
        Furniture lib1Art = new Lib1_Artifact(blFcs);
        Furniture lib1Dsk = new Lib1_Desk(lib1Art, lib1Schmtc, ppr, pen, lib1Lst, lib1ImpNt);
        Furniture lib1Rg = new Lib1_Rug();
        Furniture lib1Rck = new Lib1_Rack(lib1Nt2, lib1Nt4, lib1Nt3);
        Furniture lib1Tbl = new Lib1_Table(lib1Pln);
        Furniture lib1Lght = new Lib1_Light();
        Furniture lib1Mrrr = new Lib1_Mirror();
        Furniture lib1Wndw = new Lib1_Window();
        Furniture lib1Sf = new Lib1_Safe(712, eow3Key, brkLns, brssRng);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE DRAWING ROOM">
        //-----------------------------THE ROOM---------------------------------
        Room drar = new Drar("Drawing room", Id.DRAR);
        //-------------------------------ITEMS----------------------------------
        Item wine = new Liquid(BOTTLE_OF_WINE, "A very old bottle of red wine. "
                + "The date says \"1722\". It has likely lost its taste by now", 15);
        Item rk = new Item("rook", "the small figure resembles a brick tower.", 
                "You have no idea how to play chess.", 30);
        Item knght = new Item("knight", "The small figure resembles a horse.", 
                "You have no idea how to play chess.", 30);
        Item bshp = new Item("bishop", "The small figure resembles... something.", 
                "You have no idea how to play chess.", 30);
        Item pwn = new Item("pawn", "The small figure resembles... something.", 
                "This is the weakest piece right? Hmph. Better not ask a chess player that.", 15);
        Item rdBl = new Item(RED_BALL, "It's just a plain, heavy red ball. Where's the number on this?", 
                "This is nonsense. Where are the numbers?", 30);
        Item cBl = new Item(CUE_BALL, "It's a plain white ball. This IS the cue ball, right?", 
                "You'd rather break a window with this and jump out rather than play this witchcraft.", 30);
        //-----------------------------FURNITURE--------------------------------
        Furniture drarBr = new Drar_Bar(wine, wine, wine);
        Furniture drarGhst = new Drar_Ghost(drkFcs, kitcKey, emrld, drarBr);
        Furniture drarF = new Floor("The room is carpeted in lavender with tenuous gold lines curving intricately along the edges.");
        Furniture drarW = new Wall("This is the first time you've seen wallpaper in here. It's striped vertical in purple and lavender.");
        Furniture drarWndw = new Lib3_Window();
        Furniture drarBllrds = new Drar_Billiards(drarGhst, rdBl, cBl, cBl);
        Furniture drarChss = new Drar_Chess(drarGhst, rk, knght, bshp, qn, kng, bshp, knght, rk, pwn, pwn, pwn, pwn, pwn, pwn, pwn, pwn);
        Furniture drarCch = new Drar_Couch(drarGhst);
        Furniture drarTbl = new Drar_Table(drarGhst);
        Furniture drarPno = new Drar_Piano();
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE KITCHEN"> 
        Furniture kitcTrch = new Kitc_Torch(torch);
        //-----------------------------THE ROOM---------------------------------
        Room kitc = new Kitc("Kitchen", Id.KITC, kitcTrch);
        //-------------------------------ITEMS----------------------------------
        Item rtnFrt = new Item("rotten fruit", "Was this an apple or a plum?", 
                "Whatever you expect him to do with that, he isn't going to.", -50);
        Item petFrt = new Item("petrified vegetable", "Looks like a rock ... in the shape of a carrot.", 
                "Whatever you expect him to do with that, he isn't going to.", -50);
        Item brly = new Item("barley", "It doesn't smell so great. Even grain doesn't keep this long.", -50);
        Item rye = new Item("rye", "It doesn't smell so great. Even grain doesn't keep this long.", -50);
        Item cpprPt = new Weapon(COPPER_POT, "It's small and crudely fashioned. It was definitely hammered into shape.", 30);
        Item cpprPn = new Weapon(COPPER_PAN, "It's an old copper pan, crudely fashioned and hammered into shape.", 30);
        //-----------------------------FURNITURE--------------------------------
        Furniture kitcF = new Floor("The floor is dirty brown stone, composed of differently sized bricks. "
                + "The bricks are nicked all over, as if pelted numerous times with heavy objects.");
        Furniture kitcW = new Wall("The wall is mostly cobblestone supported by wooden vertical beams along the walls.");
        Furniture kitcWndw = new Kitc_Window();
        Furniture kitcDr = new Mha3_Door(Direction.WEST);
        Furniture kitcRck = new Kitc_Rack(drwKey, par2Key, dngnKey);
        Furniture kitcPts = new Kitc_Pots(cpprPt, cpprPn, cpprPt, cpprPn, cpprPt, cpprPn);
        Furniture kitcHrth = new Kitc_Hearth(wbalch, wbalch, wbalch, wbalch);
        Furniture kitcBrls = new Kitc_Barrels(brly, brly, brly, rye, rye, rye);
        Furniture kitcPntry = new Kitc_Pantry(rtnFrt, rtnFrt, petFrt, kitcFrtPhy, petFrt);
        Furniture kitcShlf = new Kitc_Shelf(wine, wine, wine, wine, wine, wine, wine);
        Furniture kitcCntr = new Kitc_Cntr(shaSpng, vinegar, vial, vial);   
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE DUNGEON STAIRCASE">
        //-----------------------------THE ROOM---------------------------------
        Room dst1 = new Dst1("Eerie chamber", Id.DST1);
        //-----------------------------FURNITURE--------------------------------
        Furniture dst1Dr = new Eow1_Door(Direction.EAST);
        Furniture dst1Strs = new Dst1_Stairs();
        Furniture dstW = new Wall("The walls in here are a mossy cobblestone.");
        Furniture dst1F = new Floor("The stone floor is mossy and dank from the humidity.");
        Furniture dst1Lntrn = new Dst1_Lantern();
        // </editor-fold>

        // </editor-fold>
        // ---------------------------------------------------------------------     
        // <editor-fold defaultstate="collapsed" desc="AREA 4: CASTLE REAR">

        // <editor-fold defaultstate="collapsed" desc="INITIALIZE OBSERVATORY"> 
        //-----------------------------THE ROOM---------------------------------
        Room obs1 = new Room("Observatory", Id.OBS1);
        Room obs2 = new Obs2("Observatory balcony", Id.OBS2);
        Room obs3 = new Obs3("Aerie", Id.OBS3);
        //-------------------------------ITEMS----------------------------------  
        Item hlsPlt = new Obs1_Plate("brass plate, \"Sol\"", "The small plate bears an engraving: \"Sol\"");
        Item hrmsPlt = new Obs1_Plate("brass plate, \"Mercury\"", "The small plate bears an engraving: \"Mercury\"");
        Item gaeaPlt = new Obs1_Plate("brass plate, \"Terra\"", "The small plate bears an engraving: \"Terra\"");
        Item aresPlt = new Obs1_Plate("brass plate, \"Mars\"", "The small plate bears an engraving: \"Mars\"");
        Item urnsPlt = new Obs1_Plate("brass plate, \"Caelus\"", "The small plate bears an engraving: \"Caelus\"");
        Item psdnPlt = new Obs1_Plate("brass plate, \"Neptune\"", "The small plate bears an engraving: \"Neptune\"");

        Item rby2 = new BreakableItem(RUBY, "The ruby is well cut and clean.", 200);
        Item gr = new Item("small gear", 
                "The small delicate gear fell right out of the telescope.", 15);
        Item glssLns = new BreakableItem("glass lens", 
                "The small lens once belonged to the telescope in the observatory.", 30);
        Item mchnPc = new Item("machine piece", 
                "You aren't sure what it does... It's an oddly shaped piece of aluminum.", 15);
        Item obs1Nt = new Obs1_Note("scribbly note");
        Item obsBk = new Obs2_Book("tome, 'Planets and Myth'");
        Item obs2Nt = new Obs2_Note("journal page, Factum");
        Item obs3Nt = new Note("momento: plate locations", 
                "It's only been a day since we discovered that artifact from the well, and "
                + "already I don't want to be around it. Perhaps we can hide it in the chandelier up there; "
                + "we need a use for that compartment. I'll determine new areas to store those brass plates, "
                + "and keep the locations in the picture frame back there...");
        //-----------------------------FURNITURE--------------------------------
        Furniture obs3Chndlr = new Obs3_Chandelier("chandelier", cndl, cndl, cndl, rby2, cndl, cndl);
        Furniture obsStats = new Obs1_Statues(obs3Chndlr);
        Furniture obsSlts = new Obs1_Slots(hlsPlt, obsStats);
        Furniture obsF = new Floor("The floor in here is gray and dark blue checkered "
                + "tile with thin veins of gold running between them.");
        Furniture obsW = new Wall("The walls are mahogany wood paneled, "
                + "with each panel bearing a large round cavity displaying a painted constellation.");
        Furniture obsWndw = new Obs_Window();
        Furniture obs1Strs = new Obs13_Stairs(Direction.UP, Id.OBS2);
        Furniture obs1Tlscp = new Obs1_Telescope(gr, mchnPc, glssLns);
        Furniture obs1Lmp = new Obs1_Lamp();
        Furniture obs1St = new Obs1_Seat(obs1Nt);

        Furniture obsBlcny = new Obs_Balcony();
        Furniture obs2Strs = new Obs2_Stairs();
        Furniture obs2BkShlf = new Obs2_BkShlf(obsBk, obs2Nt, astrLabe, obs3Nt);
        Furniture obs2Pntng = new Obs2_Painting();
        Furniture obs2Rlng = new Obs2_Railing();
        Furniture obs2Chr = new Obs2_Chair();
        Furniture obs2Tbl = new Bha1_Table(lttrOpnr, pen, ppr);
        Furniture obs2Lmp = new Obs2_Lamp();
        Furniture obs2F = new Floor("The balconies are laid with polished brightly stained wood.");

        Furniture obs3Strs = new Obs13_Stairs(Direction.DOWN, Id.OBS2);
        Furniture obs3Chst = new Obs3_Chest(psdnPlt);
        Furniture obs3Tlscps = new Obs3_Telescopes();
        Furniture obs3F = new Floor("The balconies are laid with polished brightly stained wood.");

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE JADE HALL">
        //-----------------------------THE ROOM---------------------------------
        Room jha1 = new Room("Jade hallway", Id.JHA1);
        Room jha2 = new Jha2("Jade hallway", Id.JHA2); // Adds hidden door to room
        //-----------------------------FURNITURE--------------------------------  
        Furniture jhaLntrn = new Jha_Lantern();
        Furniture jha1Pntng = new Jha1_Painting();
        Furniture jhaF = new Floor("The floor is a polished birch stained a rust color. It gives off a pleasant fragrance.");
        Furniture jhaW = new Wall("These walls look expensive and one-of-a-kind. The lower third is a reddish birch wainscoting "
                                + "and the upper part is solid rock resembling jade or marble.");
        Furniture jhaJd = new Jha_Jade();
        Furniture jha1Ln = new Jha_Lion();
        Furniture jha2Ln = new Jha_Lion();
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE GARDENS"> 
        //-----------------------------THE ROOM---------------------------------
        Room gar1 = new Gar1("Rooftop garden", Id.GAR1);
        Room gar2 = new Room("Rooftop garden", Id.GAR2);
        Room gar3 = new Gar3("Rooftop garden", Id.GAR3);
        Room gar4 = new Gar4("Rooftop garden", Id.GAR4);   
        //-------------------------------ITEMS----------------------------------
        Item hose = new Item(LEATHER_HOSE, "The roughly 30-foot old hose is cracked and rotted. "
                + "It's certainly non-functional, but is still sturdy.", 5);
        Item brknHose = new Item("broken hose", "The hose has broken in half, but it served a worthy final purpose.", 5);
        Item hoe = new Item(HOE, "A rusty iron hoe for gardening. "
                + "The long wood handle is beginning to split along the grain.", 30);
        Item trowel = new Item(TROWEL, "It's like a small hand-held shovel. "
                + "Cute, and functional to the extent of digging only smaller holes.", 30);
        //-----------------------------FURNITURE-------------------------------- 
        Furniture gar13Plntr = new Gar13_Planter(sl, mndrkBlb, sl);
        Furniture gar1Stat = new Gar1_Statue();
        Furniture gar2Hs = new Gar2_Hose(brknHose);
        Furniture gar2Hl = new Gar2_Hole(gar2Hs);
        Furniture garF = new Floor("The floor out here is made of large shale slabs. "
                + "It's a miracle this castle's architecture can hold this area up.");
        Furniture gar2Clmn = new Gar2_Columns();
        Furniture gar2Dm = new Gar2_Dome();
        Furniture gar3Chst = new Gar3_Chest(hoe, trowel, hose, sd);
        Furniture gal3Fntn = new Gar3_Fountain(garChstKey);
        Furniture gar4Plq = new Gar4_Plaque();
        Furniture gar4Plntr = new Gar4_Planter(gar4Plq, urnsPlt, urnsPlt, sl, sl);
        Furniture gar24Scnc = new Gar24_Sconce();

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE PARLOR"> 
        //-----------------------------THE ROOM---------------------------------
        Room par2 = new Par2("Parlor loft", Id.PAR2);
        Room par1 = new Par1("Parlor", Id.PAR1); 
        //-------------------------------ITEMS----------------------------------   
        Item bttl = new BreakableItem(GLASS_BOTTLE, 
                "It's a regular clear glass bottle, about 5 inches wide with a stubby neck.", 25);
        Item enchntdBttl = new BreakableItem(ENCHANTED_BOTTLE, 
                "The bottle is now coated in glowing... stuff.", 70);
        Item stlWr = new Item(STEEL_WIRE, 
                "It's some broken piano wire, snapped about a quarter the way down.", 5);
        Item hndDrll = new Item(HAND_DRILL, 
                "It's a drill for boring holes in wood. You can drill into almost anything you want now!", 25);
        Item athr = new Liquid(AETHER_VIAL, "The small delicate vial holds a bluish cloudy substance; "
                + "a gas, but flowing like a liquid.", 60);
        Item frSlts = new Item(FIRE_SALTS, "Seems to be just rust-colored ashes in a plain wooden bowl. "
                + "They give off an unexplainable ambient warmth and smell of burning.", 70);
        Item parNt = new Par_VialNote("notice: vials");
        Item parBkMndrk = new Par_MandrakeBook("tome, 'The Care of Mandragora'");
        Item parBkEncht = new Par_EnchantingBook("tome, 'Enchanting for the Naive'");
        Item parNtBttl = new Par_BottleRecipe("'Novice Enchanting: Bottles'");
        Item parNtShs = new Par_ShoeRecipe("'Novice Enchanting: Footwear'");
        Item parNtWpn = new Par_WeaponRecipe("'Expert Enchanting: Weaponry'");
        Item parNtKey = new Par_KeyRecipe("'Expert Enchanting: Skeleton Keys'");
        Item parLchNt = new Note("note: binding",
                "A first attempt at a soul bind has worked. Though binding to such "
              + "a weak object such a book is not recommended, it is certainly "
              + "easier... and a decent subject to practice on...");
        //-----------------------------FURNITURE--------------------------------  
        Furniture parLft = new Par_Loft();

        Furniture par1Orb = new Par1_Orb();
        Furniture par1F = new Floor("It's a sandstone tiled floor, much like that in the west wing. "
                + "The floor here does appear noticeably cleaner and more refined, however.");
        Furniture par1FrPlc = new Par1_FirePlace(bckt, enchntdBttl);
        Furniture par1Dr = new Par1_Door(enchntdBttl, Direction.NORTH);
        Furniture par1EnchntTbl = new Par1_EnchantingTable(enchntdBttl, bttl, chs1Key, parLchNt);
        Furniture par1Strs = new Par_Stairs(Direction.UP, Id.PAR2);
        Furniture par1Pllrs = new Par1_Pillars();
        Furniture par1Hrp = new Par1_Harp(par1Orb);
        Furniture par1Shlf = new Wow3_Shelf(hndDrll, athr, parBkEncht, frSlts);
        Furniture par1Cshn = new Par1_Cushion(aresPlt);

        Furniture par2F = new Floor("It's a sandstone tiled floor, much like that in the west wing. "
                + "The floor here does appear noticeably cleaner and more refined, however.");
        Furniture par2Wndw = new Par2_Window();
        Furniture par2Strs = new Par_Stairs(Direction.DOWN, Id.PAR1);
        Furniture par2Bwl = new Par2_Bowl();
        Furniture par2Frplc = new Par2_Fireplace();
        Furniture par2Pno = new Par2_Piano(par1Orb, stlWr);
        Furniture par2Shlf = new Wow3_Shelf(vial, parNt, parNtShs, parNtWpn, 
                parNtBttl, parBkMndrk, parNtKey, gaeaPlt);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE SECRET STAIRS"> 
        //-----------------------------THE ROOM---------------------------------
        Room sst1 = new Room("Secret stairwell", Id.SST1);
        Room sst2 = new Room("Small landing", Id.SST2);  
        //-----------------------------FURNITURE--------------------------------  
        Furniture sst1Strs = new Sst_Stairs(Direction.UP, Id.SST2);
        Furniture sst2Strs = new Sst_Stairs(Direction.DOWN, Id.SST1);
        Furniture sstLndng = new Sst_Landing();
        Furniture sst1F = new Floor("The flooring in here is rudimentary. Just gray weathered planks of wood.");
        Furniture sst2F = new Floor("The flooring in here is rudimentary. Just gray weathered planks of wood.");
        Furniture sstWndw = new Sst_Window();
        Furniture sst1Dr = new Jha_HiddenDoor(Direction.EAST);
        Furniture sst2Dr = new Sst_Door(Direction.EAST);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE LABORATORY"> 
        //-----------------------------THE ROOM---------------------------------
        Room labo = new Labo("Laboratory", Id.LABO);
        //-------------------------------ITEMS---------------------------------- 
        Item rbbrTube = new Item(RUBBER_HOSE, "It's a yellow rubber hose, about 8 feet long.", 25);
        Item tstTb = new BreakableItem(TEST_TUBE, "A small glass tube with a rounded "
                + "bottom and a smooth rounded lip at the other end.", 25);
        Item bkr = new BreakableItem(BEAKER, "The vessel is straight on the edges and wide. "
                + "Painted in wide intervals on the sides are white marks with numeric measurements.", 25);
        Item strkr = new Item(STRIKER, "It's a weird metal tool. You squeeze it a "
                + "couple times and a few sparks fly from the metal cap at the one end.", 30);
        Item scale = new BreakableItem("scale", 
                "A machine for the weighing of things, comprised of a metal bed "
                + "and a base comprised of many small mechanical parts.", 30);
        Item balance = new BreakableItem("balance", 
                "You seem to remember these being called triple-beam balances in middle school.", 
                "Oh boy! You could weigh just about anything with this!", 30);
        Item flrcFlsk = new BreakableItem(FLORENCE_FLASK, 
                "It's a piece of chemistry glassware. "
                + "Has a bulbous bottom and a thin shaft with an opening at the top.", 25);
        Item laboBrnrBk = new Labo_BurnerManual("manual, 'Playing With Fire'");
        Item laboRcp = new Labo_PhaseDoorRecipe("phase door potion recipe");
        Item laboIngNt = new Labo_IngredientsNote("note: missing ingredients");
        Item labDstllrNt = new Labo_DistillerNote("note: contraption");
        //-----------------------------FURNITURE--------------------------------  
        Furniture iceBrrl = new Labo_IceBarrel(flrcFlsk);
        Furniture laboRck = new Labo_Shelf(vial, laboRcp, tstTb, laboIngNt, vial, tstTb, bkr, tstTb, laboBrnrBk, actn);
        Furniture laboGsPipe = new Labo_GasPipe();
        Furniture cndsr = new Labo_Condenser(bkr);
        Furniture laboDstllr = new Labo_Distiller(laboGsPipe, cndsr, tstTb, vial);
        Furniture laboDspnsrs = new Labo_Dispensers(vial, tstTb);
        Furniture laboBrtt = new Labo_Burette(vial, tstTb);
        Furniture laboStpCck = new Labo_StopCock();
        Furniture laboF = new Floor("It's a black and white checkered tile. A predictable floor for a laboratory. "
                + "A few burn marks taint the floor just at the foot of the counter to the north.", tstTb);
        Furniture laboSnk = new Labo_Sink(vial, bkr, bckt, wtr);
        Furniture laboCntrptn = new Labo_Contraption();
        Furniture laboTbl = new Labo_Table();
        Furniture laboDvcs = new Labo_Devices();
        Furniture laboCntr = new Labo_Counter(strkr, labDstllrNt, scale, rbbrTube, balance);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE ATTIC"> 
        Furniture prisCbnt = new Pris_Cabinet();
        //-----------------------------THE ROOM---------------------------------
        Room att1 = new Att1("Attic", Id.ATT1, prisCbnt);       
        Room att2 = new Att2("Attic", Id.ATT2);    
        //-------------------------------ITEMS----------------------------------  
        Item attcDll = new Item("doll", "A rag doll in a dress with one eye hanging out. Very creepy.", 15);
        Item attcSphn = new BreakableItem("sousaphone", 
                "You never even thought these things were real!", 
                "You can't fit it around your waist.", 35);
        Item attcAntLmp = new BreakableItem("antique lamp", 
                "A brass table lamp with a green lampshade. Its bulb is missing.", 5);
        Item attcMrrr = new BreakableItem("mirror", "It's a dusty mirror.", 
                "You're afraid to look in it.", 50);
        Item attcGlb = new BreakableItem("globe", 
                "This thing doesn't at all look like a modern globe. Where's Prussia?", 35);
        Item attcGChSt = new Clothing("green checkered suit", "Who would wear this?", 
                "Maybe if it were red-plaid, you'd wear it.", 40);
        Item attcDrss = new Clothing("dress", "It's a violet dress", 
                "You aren't too accustomed to wearing dresses.", 15);
        Item attcOldRgs = new Item("old rags", "Just some assorted pieces of fabric", 0);
        Item attcTrchCt = new Clothing("black trench coat", "It's a long, black wool trench coat.", 
                "There's no time for dress up right now.", 15);
        Item attcStPt = new Clothing("suit pants", "Some dark gray pinstripe pants", 
                "You really don't feel like removing your pants right now.", 25);
        //-----------------------------FURNITURE--------------------------------  
        Furniture attW = new Wall("The gray wood plank walls in here angle up forming a roof.");
        Furniture attF = new Floor("The flooring in here is rudimentary. Just gray weathered planks of wood with rot in a few areas.");
        Furniture att2Dr = new Sst_Door(Direction.WEST);
        Furniture attCss = new Att_Cases(attcTrchCt, attcGChSt, attcDrss, attcOldRgs, attcStPt);
        Furniture attBxs = new Att_Boxes(attcSphn, attcMrrr, attcGlb, attcDll, attcVln, attcAntLmp);
        Furniture att2Bxs = new Att_Boxes(attcSphn, attcMrrr, attcGlb, attcDll, attcAntLmp);
        Furniture attVnts = new Att_Vents();
        Furniture attClng = new Att_Ceiling();

        // </editor-fold>        
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE BACK HALL"> 
        //-----------------------------THE ROOM---------------------------------
        Room bha1 = new Room("Demonic hallway", Id.BHA1);
        Room bha2 = new Bha2("???", Id.BHA2);
        Room bha3 = new Room("Demonic hallway", Id.BHA3);
        //-------------------------------ITEMS----------------------------------   
        Item tblLg = new Weapon("broken table leg", "A short wooden post about 3 feet long. "
                + "It looks like it belonged to a table.", -25);
        Item orgMttr = new Item("organic matter", "An unknown gray substance. "
                + "It has a non-solid texture and feels organic. Its color appears "
                + "to shift ever so slightly, giving it an oily appearance.", 10);
        Item bhaNt = new Bha_Note("note: plates");
        //-----------------------------FURNITURE--------------------------------  
        Furniture bha1Hrzn = new Bha1_Horizon();
        Furniture bha1Plnt = new Bha1_Plant(sl, stnBdy);
        Furniture bha1Tbl = new Bha1_Table(hrmsPlt);
        Furniture bhaW = new Wall("The walls are covered in a brown and red vertically "
                + "striped wallpaper with wainscoting on the bottom. The wallpaper "
                + "has torn and peeled at the seams it some areas.");
        Furniture bha1F = new Floor("The wood-plank floor bends with the hallway. "
                + "The planks bend with it without prying up. Could this all be an illusion?");

        Furniture bha2F = new Floor("The floor has changed. Most of the wood planks have been removed "
                + "revealing a dirt-like ground below... But it's not dirt.", 
                wbalsp, wbalch, orgMttr, orgMttr, tblLg, wbalsp);
        Furniture bha2W = new Wall("The walls are still intact, though much more of the wallpaper has been ripped off.");
        Furniture bha2Frm = new Bha2_Frame(gal5CbtKey, bhaNt);

        Furniture bha3Wndw = new Bha3_Window();
        Furniture bha3F = new Floor("The wood-plank floor bends with the hallway. "
                + "The planks bend with it without prying up. Could this all be an illusion?");

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
        
        Item oar = new Item(WOODEN_OAR, "The two halves have been taped together.", "You will need to be in a boat to use this.", 10);
        
        // Dungeon
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE TUNNELS">
        Item pipePc = new Weapon(PIECE_OF_PIPE, "It's a piece of rough metal piping, about 2 feet long. It's covered in rust and slime.", 15);
        Furniture sew1Rvr = new Sew1_River(pipePc, wtrBckt);
        Furniture sew4Pp = new Sew4_Pipe(sew1Rvr, pipePc); // RESETABLE
        //-----------------------------THE ROOMS--------------------------------
        Room sew0 = new Dungeon_Tunnel("Tunnel's end", Id.SEW0);
        Room sew1 = new Sew1("Underground tunnel", Id.SEW1);
        Room sew2 = new Sew2("Underground tunnel", Id.SEW2);
        Room sew3 = new Dungeon_Tunnel("Underground tunnel", Id.SEW3);
        Room sew4 = new Sew4("Underground tunnel", Id.SEW4, sew4Pp);
        Room sew5 = new Sew5("Tunnel's end", Id.SEW5);
        //-----------------------------FURNITURE-------------------------------- 
        Furniture sewF = new Dungeon_Floor();

        Furniture sewTnnl = new Sew_Tunnel();
        Furniture sewRvr = new Sew2345_River(sew1Rvr, wtrBckt);
        Furniture sewMss = new Sew_Moss();

        Furniture sew0Trch = new Torch_Holder(torch);
        Furniture sew0Strs = new Sew0_Stairs();

        Furniture sew15Gt = new Sew15_Gate();
        Furniture sew1Trch = new Torch_Holder(torch);

        Furniture sew2Vlvs = new Sew2_Valves(); // RESETABLE
        Furniture sew2Trch = new Torch_Holder(torch);
        Furniture sew2BrdgW = new Sew_Bridge(Direction.WEST);
        Furniture sew2Pp = new Sew235_Pipe(2);

        Furniture sew3Trch = new Torch_Holder(torch);
        Furniture sew3BrdgN = new Sew_Bridge(Direction.NORTH);
        Furniture sew3BrdgE = new Sew_Bridge(Direction.EAST);
        Furniture sew3Pp = new Sew235_Pipe(3);

        Furniture sew4Trch = new Torch_Holder(torch);

        Furniture sew5Trch = new Torch_Holder(torch);
        Furniture sew5BrdgE = new Sew_Bridge(Direction.EAST);
        Furniture sew5Pp = new Sew235_Pipe(5);
        Furniture sew5Vlv = new Sew5_Valve(sew2Vlvs, sew4Pp);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE ANCIENT CISTERN">
        //-----------------------------THE ROOMS--------------------------------
        Room cis1 = new Cis1("Fetid cistern", Id.CIS1); // RESETABLE
        Room cis2 = new Cis2("Fetid cistern", Id.CIS2);
        Room cis3 = new Cis3("Fetid cistern", Id.CIS3);
        Room cis4 = new Cis4("Fetid cistern", Id.CIS4); 
        Room cis5 = new Cis5("Secret platform", Id.CIS5);
        //-------------------------------ITEMS----------------------------------  
        Item oarTl = new Item("broken wood handle", "It appears to be one half of an oar that was split in two.", oar, 3, 5);
        Item pdLck = new Item("broken padlock", "... Was this possibly the padlock you broke earlier?", -10);
        //-----------------------------FURNITURE-------------------------------- 
        Furniture cis2Bt = new Cis2_Boat(oarTl);
        Furniture cis1Trch = new Torch_Holder(torch);
        Furniture cis3Trch = new Torch_Holder(torch);
        Furniture cis4Trch = new Torch_Holder(torch);
        Furniture cis5F = new Floor("The floor here is the same as the rest of the cistern.", pdLck);
        Furniture cis5Fgr = new Cis5_FigureNPC();
        Furniture cisF = new Dungeon_Floor();
        Furniture cisWtr = new Cis_Water(wtrBckt);
        Furniture cisClmns = new Cis_Columns();
        Furniture cisDrknss = new Cis_Darkness();

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE TORTURE CHAMBER">
        //-----------------------------THE ROOM---------------------------------
        Room torc = new Torc("Torture chamber", Id.TORC);
        //------------------------------ITEMS-----------------------------------
        Item thmScrws = new Item("odd clamp", 
                "Two small blocks of wood connected with a couple threaded bolts "
                + "comprise the small device. It's slightly larger than your palm.", 35);
        //-----------------------------FURNITURE-------------------------------- 
        Furniture torcF = new Dungeon_Floor();
        Furniture torcTrchs = new Torch_Holder(torch);
        Furniture torcSwhrses = new Torc_Sawhorses(torc); // RESETABLE
        Furniture torcRck = new Torc_Rack(thmScrws);
        Furniture torcCgs = new Torc_Cages(ou62Key);
        Furniture torcWhl = new Torc_Wheel();
        Furniture torcWd = new Torc_Wood();
        Furniture torcTls = new Torc_Tools();
        Furniture torcScythF = new Torc_ScytheFurniture(); // RESETABLE

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE CRYPT">
        //-----------------------------THE ROOM---------------------------------
        Room cry2 = new Cry2("Crypt", Id.CRY2);
        Room cry1 = new Room("Crypt", Id.CRY1);
        //-------------------------------ITEMS----------------------------------      
        Item drdFlwr = new Item("dried flower", "It's a brown, dried-up rose, "
                + "perhaps given as a memorial or offering to an arcane spirit or diety.", 10);
        Item ncklc = new Clothing("silver necklace", 
                "A thin, fine necklace made of silver. A blue jewel dangles from it.", 
                "You put it around your neck. The heavy coldness fills you with feelings of luxury.", 170);
        Item brnzCn = new Item("bronze coin", 
                "It's some sort of extinct and exotic currency. A round hole is bored through the center, "
                        + "and remaining surface has visible but worn decorative etchings.", 50);
        Item knife = new Weapon("knife", 
                "A plain steel knife, wrapped in cloth on the handle and "
                        + "stained with what must be blood.", 20);
        //-----------------------------FURNITURE-------------------------------- 
        Furniture cryF = new Dungeon_Floor();
        Furniture cryDummy = new Cry_Dummy();
        Furniture cryDrwrs = new Cry_Drawers();
        Furniture cry1Crvng = new Cry1_Carving();
        Furniture cryLghts = new Cry_Lights();
        Furniture cry2Engrvng = new Cry2_Engraving();
        Furniture cry2Altr = new Cry2_Altar(drdFlwr, jetSkull, knife, ncklc, brnzCn);
        Furniture cry1Stat = new Cry1_Statue(torcScythF); // RESETABLE
        Furniture cry2Psswd = new Cry2_Password(cry1Stat);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE CELL">
        //-----------------------------THE ROOM---------------------------------
        Room intr = new Intr("Noisy chamber", Id.INTR);      
        //-----------------------------FURNITURE-------------------------------- 
        Item mtlBt = new Item("metal bit", "It's a small scrap of metal. You have no idea what it's for.", 0);
        Item scrw = new Item("screw", "A degraded piece of metal resembling a screw. The threads have worn away and bits of metal rub off on your hand.", 0);
        Item sgyWdChnk = new Item("soggy wood chunk", "It's a rotted, wet chunk of wood.", 0);
        //-----------------------------FURNITURE-------------------------------- 
        Furniture intrF = new Dungeon_Floor(sgyWdChnk, scrw, scrw, mtlBt); 
        Furniture intrGrt = new Intr_Grate(); // RESETABLE
        Furniture intrTrch = new Intr_Torch(torch); // RESETABLE
        Furniture intrWhl = new Intr_Wheel();
        Furniture intrGrs = new Intr_Gears();
        Furniture intrDr = new Intr_Door();
        Furniture intrWtr = new Intr_Water(); // RESETABLE

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE SUB-TUNNELS">
        //-----------------------------THE ROOMS--------------------------------
        Room esc1 = new Esc("Small tunnel", Id.ESC1);
        Room esc2 = new Esc("Small tunnel", Id.ESC2);
        Room esc3 = new Esc("Small tunnel", Id.ESC3);
        Room esc4 = new Esc("Small tunnel", Id.ESC4);
        Room esc5 = new Esc("Small tunnel", Id.ESC5);
        Room esc6 = new Esc("Small tunnel", Id.ESC6);       
        //-----------------------------FURNITURE-------------------------------- 
        Furniture esc1Lddr = new Esc1_Ladder(); // RESETABLE
        Furniture esc6Grt = new Esc6_Grate(); // RESETABLE
        Furniture esc6Lddr = new Esc6_Ladder(esc6Grt); // RESETABLE

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE CATACOMBS ACCESS">
        //-----------------------------THE ROOM---------------------------------
        Room cas1 = new Cas1("Catacombs access", Id.CAS1);      
        //-----------------------------FURNITURE-------------------------------- 
        Furniture casW = new Wall("The walls are large granite blocks reflecting a flickering bluish hue from the flame.");
        Furniture casStrs = new Cas_Stairs(Direction.DOWN, Id.CS35);
        Furniture casF = new Floor("The floor is comprised of many large blocks, illuminated blue from the fire.");

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE OUBLIETTE">
        //-----------------------------THE ROOM---------------------------------
        Room oub1 = new Room("Oubliette", Id.OUB1);       
        //-----------------------------FURNITURE--------------------------------  
        Furniture oub1F = new Dungeon_Floor();
        Furniture oub1Pt = new Oub1_Pit();

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE PRISON">
        //-----------------------------THE ROOM---------------------------------
        Room pris = new Pris("Prison", Id.PRIS);
        //-------------------------------ITEMS----------------------------------   
        Item oarHd = new Item("broken wood paddle", "It appears to be one half of an oar that was split in two.", oar, 3, 5);
        //-----------------------------FURNITURE--------------------------------  
        Furniture prisClls = new Pris_Cells();
        Furniture prisF = new Dungeon_Floor();
        Furniture prisCndlbrs = new Pris_Candelabra(cndl);
        Furniture prisTbl = new Pris_Table(oarHd);
        Furniture prisGts = new Pris_Gates();
        Furniture prisFgr = new Pris_Ghost();

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="KAMPE'S QUARTERS">
        //-----------------------------THE ROOM---------------------------------
        Room dkch = new Room("Kampe's quarters", Id.DKCH);
        //-------------------------------ITEMS---------------------------------- 
        Item tape = new Item("duck tape", "State-of-the-art fabric tape made from cotton duck cloth. This is strong.", oar, 3, 15);
        Item whip = new Weapon("leather whip", "A stylishly braided leather whip.", 25);
        Item lthrHat = new Clothing("shiny leather hat", "A worn but polished leather stetson-style hat.", "You put it on.", 25);
        Item shoeBx = new Kampe_Box(tape, whip, lthrHat, watch);
        Item lngChn = new Weapon("chain", "It's a chain, about 10 feet long.", 35);
        Item dkchNt2 = new Note("illegible note", "This note is gibberish. Unreadable.");
        //-----------------------------FURNITURE-------------------------------- 
        Furniture dkchF = new Dungeon_Floor();
        Furniture dkchBd = new Dkch_Bed(lngChn, shoeBx);
        Furniture dkchAxl = new Dkch_Axle();
        Furniture dkchDsk = new Dkch_Desk(dkchNt2);
        Furniture dkchClng = new Dkch_Ceiling();

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE STRANGE POOL">
        int[] resetables = {intrWtr.getID(), intrGrt.getID(), intrTrch.getID(), 
            sew2Vlvs.getID(), torcSwhrses.getID(), torcScythF.getID(), 
            cry1Stat.getID(), esc6Grt.getID(), sew4Pp.getID(), esc6Lddr.getID()};
        String[] ids = {Id.INTR, Id.INTR, Id.INTR, Id.SEW2, Id.TORC, Id.TORC, 
            Id.CRY1, Id.ESC6, Id.SEW4, Id.ESC6};
        //-----------------------------THE ROOM---------------------------------
        Room sewp = new Sewp("Pool of water", Id.SEWP, prisCbnt, resetables, ids);        
        //-----------------------------FURNITURE--------------------------------  
        Furniture sewpCl = new Sewp_Ceiling();
        Furniture sewpGrt = new Sewp_Grate();
        Furniture sewpWtr = new Sewp_Water(wtrBckt);
        Furniture sewpTrch = new Torch_Holder(torch);
        Furniture sewpF = new Dungeon_Floor();
        Furniture sewpTnnl = new Sewp_Tunnel();

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE ANCIENT ARCHIVES">
        //-----------------------------THE ROOM---------------------------------
        Room aarc = new Aarc("Ruined archives", Id.AARC);
        //-------------------------------ITEMS----------------------------------
        Item algBk = new Item("algae covered book", 
                "The book is wet and slimy. Its pages have nearly fused.", 
                "This is completely unreadable.", -30);
        Item rndBk = new Item("ruined book", 
                "This book is damp, moldy, and covered in dirt.", 
                "Whatever knowledge this book held is now lost.", -30);
        Item stnBlck = new BreakableItem(STONE_BLOCK, 
                "This is a remnant of the collapsed floor in the ancient archives.", 10);
        Item slmyAlg = new Item("slimy algae", "Why are you holding this?", -35);
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
        Room cs35 = new Room("Catacombs entrance", Id.CS35);
        Room ou62 = new Room("Oubliette", Id.OU62);
        Room my18 = new My18("Sandstone chamber", Id.MY18);

        Room tm16 = new Tomb(Id.TM16);
        Room tm66 = new Tomb(Id.TM66);
        Room tm32 = new Tomb(Id.TM32);

        Room an55 = new An55("Ancient tomb", Id.AN55);
        Room an65 = new An65("Ancient tomb", Id.AN65);
        
        Furniture c = new Ceiling() {{this.description = "It's a dripping, rocky ceiling.";}};
        Furniture w = new Wall("The walls are wet and rocky.");

        Room // Instantiate all catacomb rooms --------------------------------
        ct11 = new Catacomb(Id.CT11, w, c), ct12 = new Catacomb(Id.CT12, w, c),
        ct13 = new Catacomb(Id.CT13, w, c), ct14 = new Catacomb(Id.CT14, w, c),
        ct15 = new Catacomb(Id.CT15, w, c), ct17 = new Catacomb(Id.CT17, w, c),
        ct21 = new Catacomb(Id.CT21, w, c), ct22 = new Catacomb(Id.CT22, w, c),
        ct23 = new Catacomb(Id.CT23, w, c), ct24 = new Catacomb(Id.CT24, w, c),
        ct25 = new Catacomb(Id.CT25, w, c), ct26 = new Catacomb(Id.CT26, w, c),
        ct27 = new Catacomb(Id.CT27, w, c), ct28 = new Catacomb(Id.CT28, w, c),
        ct31 = new Catacomb(Id.CT31, w, c), ct33 = new Catacomb(Id.CT33, w, c),
        ct34 = new Catacomb(Id.CT34, w, c), ct36 = new Catacomb(Id.CT36, w, c),
        ct37 = new Catacomb(Id.CT37, w, c), ct38 = new Catacomb(Id.CT38, w, c),
        ct41 = new Catacomb(Id.CT41, w, c), ct42 = new Catacomb(Id.CT42, w, c),
        ct43 = new Catacomb(Id.CT43, w, c), ct44 = new Catacomb(Id.CT44, w, c),
        ct45 = new Catacomb(Id.CT45, w, c), ct46 = new Catacomb(Id.CT46, w, c),
        ct47 = new Catacomb(Id.CT47, w, c), ct48 = new Catacomb(Id.CT48, w, c),
        ct51 = new Catacomb(Id.CT51, w, c), ct52 = new Catacomb(Id.CT52, w, c),
        ct53 = new Catacomb(Id.CT53, w, c), ct54 = new Catacomb(Id.CT54, w, c),
        ct56 = new Catacomb(Id.CT56, w, c), ct57 = new Catacomb(Id.CT57, w, c),
        ct58 = new Catacomb(Id.CT58, w, c), ct61 = new Catacomb(Id.CT61, w, c),
        ct63 = new Catacomb(Id.CT63, w, c), ct64 = new Catacomb(Id.CT64, w, c),
        ct67 = new Catacomb(Id.CT67, w, c), ct68 = new Catacomb(Id.CT68, w, c);

        Room[] list = {
            ct11, ct12, ct13, ct14, ct15, ct17, ct21, ct22, ct23, ct24, ct25, 
            ct26, ct27, ct28, ct31, ct33, ct34, ct36, ct37, ct38, ct41, ct42, 
            ct43, ct44, ct45, ct46, ct47, ct48, ct51, ct52, ct53, ct54, ct56, 
            ct57, ct58, ct61, ct63, ct64, ct67, ct68};

        //-------------------------------ITEMS----------------------------------
        Item coin = new Item("stone coins", 
                "A small collection of ancient coins. Many archaic markings decorate "
                + "their surfaces, with holes bored in the centers.", 
                "Where do you expect to spend these?", 35);
        Item nckLc = new Clothing("beaded necklace", 
                "A lackluster necklace made with wooden beads.", 
                "You fit the old ceremonial necklace over your head.", 40);
        Item jwl = new BreakableItem(IRIDESCENT_JEWEL, 
                "The polished glassy pebble feels warm to the touch, "
                + "and is constantly shifting color among red, black, and green.", 250);
        String medString = "It's an archaic stone key. It has a thick disc-shaped "
                + "head and a long protruding shaft bearing a few fat teeth. ";
        Item med1 = new BreakableItem(KEY_OF_ANCESTRY, 
                medString + "Engraved on its head is a depiction of the sun.", 35);
        Item med2 = new BreakableItem(KEY_OF_INTELLECT, 
                medString + "An eye is engraved on its head.", 35);
        Item med3 = new BreakableItem(KEY_OF_CONTINUITY, 
                medString + "The number '8' is engraved on its head.", 35);
        
        // <editor-fold desc="Randomly calculate jewel location" defaultstate="collapsed">
            int index = Main.getRandomUnder(list.length);                       // generate random index into catacomb list
            list[index].getFurnishings().get(0).getInv().add(jwl);               // add the jewel to that room.
            int y = Math.abs(list[index].getCoords()[1] - 7);                    // get y-coord of that room.
            String result = (list[index].getCoords()[2] + ", " + y + ", " + -2); // make the message that appears on the casket note.
        // </editor-fold>
        Item tmbNt = new Note("torn parchment", "In the center, written in large scribbly handwriting are the numbers: \"" + result + "\".");
        //-----------------------------FURNITURE-------------------------------- 
        Furniture catDrN = new Ct_Door(Direction.NORTH);
        Furniture catDrS = new Ct_Door(Direction.SOUTH);
        Furniture catDrE = new Ct_Door(Direction.EAST);
        Furniture catDrW = new Ct_Door(Direction.WEST);

        // <editor-fold desc="TOMB FURNITURE" defaultstate="collapsed">
        Furniture tmb1Cskt = new Tmb1_Casket(med1);
        Furniture tm1Vs = new Tmb_Vases(coin);
        Furniture tm1Bwl = new Tmb1_Bowl();
        Furniture tm1Effgy = new Tmb1_Effigy();
        Furniture tmb2Cskt = new Tmb2_Casket(med2);
        Furniture tm2Vs = new Tmb_Vases(nckLc, coin, ring);
        Furniture tm2Orb = new Tmb2_Light();
        Furniture tmb3Cskt = new Tmb3_Casket(med3);
        Furniture tm3Vs = new Tmb_Vases(coin, nckLc);
        Furniture tm3Tpstry = new Tmb3_Tapestry();
        Furniture tm3Cndl = new Tmb3_Cndl();
        Furniture tm1F = new Floor("It's a damp dirt floor.");
        Furniture tm2F = new Floor("It's a damp dirt floor.");
        Furniture tm3F = new Floor("It's a damp dirt floor.");
        Furniture catW = new Wall("The walls are wet and rocky.");
        // </editor-fold>
        // <editor-fold desc="OUBLIETTE FURNITURE" defaultstate="collapsed">
        Furniture oubStrw = new Ou62_Straw();
        Furniture oubSpk = new Ou62_Spike();
        Furniture oubSkltn = new Ou62_Skeleton(gldKnf);
        Furniture oub2F = new Dungeon_Floor(closStrw, closStrw, closStrw);
        // </editor-fold>
        // <editor-fold desc="ANCIENT TOMB FURNITURE" defaultstate="collapsed">
        Furniture antF = new Floor("The floor in here is dusty sandstone.");
        Furniture antNPC = new Ant_Zombie(antF, ((Cry_Drawers)cryDrwrs).DRAWER_NUM);
        Furniture antCskt = new Ant_Casket(tmbNt);
        Furniture antW = new Wall("They are carved sandstone.");
        Furniture antCskts = new Ant_Caskets();
        Furniture ant1Trch = new Torch_Holder(torch);
        Furniture ant2Trch = new Torch_Holder(torch);
        Furniture antClng = new Ant_Ceiling();
        // </editor-fold>
        // <editor-fold desc="MYSTICAL CHAMBER FURNITURE" defaultstate="collapsed">
        Furniture my18F = new Floor("The floor is brick with a round seam circling around the central pedestal.");
        Furniture my18Pdstl = new My18_Pedestal();
        Furniture my18Clng = new My18_Ceiling();
        // </editor-fold>
        // <editor-fold desc="CATACOMB AND CAVE FURNITURE" defaultstate="collapsed">
        Furniture cs35Dr = new Cs35_Door(Direction.WEST);
        Furniture ct34Dr = new Cs35_Door(Direction.EAST);
        ct34.removeFurniture(ct34.getFurnishings().get(0).getID()); // Removes old door from catacombs.
        Furniture cs35F = new Floor("The floor is comprised of many large blocks, illuminated blue from the fire.");
        Furniture cs35Trchs = new Cs35_Torches();
        Furniture cs35Stat = new Cs35_Statue();
        Furniture cs35Strs = new Cas_Stairs(Direction.UP, Id.CAS1);
        // </editor-fold>

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE CAVES"> 
        //-----------------------------THE ROOMS--------------------------------
        Furniture cw = new Wall("The wall is damp, plain rock.");
        Furniture cc = new Ceiling() {{this.description = "It's a dripping, rocky ceiling.";}};
        
        Room cv34 = new CV34("Ancient well", Id.CV34, cw, cc);
        Room ms65 = new Deep_Chamber("aykl xvldml fwe", Id.MS65);
        Room ms66 = new Deep_Chamber("d5 rl x:!e ifxJ", Id.MS66);

        Room // Instantiate all caves ------------------------------------
        cv18 = new Cave(Id.CV18, cw, cc), cv11 = new Cave(Id.CV11, cw, cc),
        cv12 = new Cave(Id.CV12, cw, cc), cv13 = new Cave(Id.CV13, cw, cc),
        cv14 = new Cave(Id.CV14, cw, cc), cv15 = new Cave(Id.CV15, cw, cc),
        cv16 = new Cave(Id.CV16, cw, cc), cv17 = new Cave(Id.CV17, cw, cc),
        cv21 = new Cave(Id.CV21, cw, cc), cv22 = new Cave(Id.CV22, cw, cc),
        cv23 = new Cave(Id.CV23, cw, cc), cv24 = new Cave(Id.CV24, cw, cc),
        cv25 = new Cave(Id.CV25, cw, cc), cv26 = new Cave(Id.CV26, cw, cc),
        cv27 = new Cave(Id.CV27, cw, cc), cv28 = new Cave(Id.CV28, cw, cc),
        cv31 = new Cave(Id.CV31, cw, cc), cv32 = new Cave(Id.CV32, cw, cc),
        cv33 = new Cave(Id.CV33, cw, cc), cv35 = new Cave(Id.CV35, cw, cc),
        cv36 = new Cave(Id.CV36, cw, cc), cv37 = new Cave(Id.CV37, cw, cc),
        cv38 = new Cave(Id.CV38, cw, cc), cv41 = new Cave(Id.CV41, cw, cc),
        cv42 = new Cave(Id.CV42, cw, cc), cv43 = new Cave(Id.CV43, cw, cc),
        cv44 = new Cave(Id.CV44, cw, cc), cv45 = new Cave(Id.CV45, cw, cc),
        cv46 = new Cave(Id.CV46, cw, cc), cv47 = new Cave(Id.CV47, cw, cc),
        cv48 = new Cave(Id.CV48, cw, cc), cv51 = new Cave(Id.CV51, cw, cc),
        cv52 = new Cave(Id.CV52, cw, cc), cv53 = new Cave(Id.CV53, cw, cc),
        cv54 = new Cave(Id.CV54, cw, cc), cv55 = new Cave(Id.CV55, cw, cc),
        cv56 = new Cave(Id.CV56, cw, cc), cv57 = new Cave(Id.CV57, cw, cc),
        cv58 = new Cave(Id.CV58, cw, cc), cv61 = new Cave(Id.CV61, cw, cc),
        cv62 = new Cave(Id.CV62, cw, cc), cv63 = new Cave(Id.CV63, cw, cc),
        cv67 = new Cave(Id.CV67, cw, cc), cv68 = new Cave(Id.CV68, cw, cc),
        cv64 = new Cave(Id.CV64, cw, cc);
        //-----------------------------FURNITURE-------------------------------- 
        Furniture cv18Strs = new My18_Stairs(Direction.UP, Id.MY18);
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
        Room chs1 = new Room("Chapel stairwell", Id.CHS1);  
        Room chs3 = new Chs3("Top landing", Id.CHS3);  
        //-----------------------------FURNITURE-------------------------------- 
        Furniture chsWndws = new Chs_Windows("windows");
        Furniture chsW = new Wall("The walls are clean, paneled in white and orange with gold leaf accents.");

        Furniture chs1Strs = new Chs1_Stairs(Direction.UP, Id.CHS3);
        Furniture chs1F = new Floor("The dark red carpet covers the whole floor. It's a bit dusty from neglect.");
        Furniture chs1Stat = new Chs1_Statue();

        Furniture chs3Strs = new Chs1_Stairs(Direction.DOWN, Id.CHS1);
        Furniture chs3F = new Floor("The dark red carpet covers the whole floor. It's a bit dusty from neglect.");

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE CHAPEL"> 
        //-----------------------------THE ROOM---------------------------------
        Room cha1 = new Room("Nave", Id.CHA1);
        Room cha2 = new Room("Chancel", Id.CHA2);
        //-------------------------------ITEMS---------------------------------- 
        Item chaNt = new Cha_Note("malevolent note");
        //-----------------------------FURNITURE-------------------------------- 
        Furniture chaF = new Floor("Faded, dusty boards line the length of the floor from north to south.");
        Furniture chaW = new Wall("The walls are mostly carved wood paneling. "
                + "Several religious scenes are painted at fixed distances along the wall.");
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
        Room vau1 = new Vau1("Vault", Id.VAU1, vau1Tbl);
        Room vau2 = new Vau2("Vault", Id.VAU2, vau1Tbl);
        Room vaue = new Room("Curious wall", Id.VAUE);
        //-------------------------------ITEMS---------------------------------- 
        Item grl = new Item("grail", 
                "It's treasure. A gold-plated grail studded with rubies. Where is all this from?", 300);
        Item cns = new Item("leather coin bag", 
                "It's treasure. A handful of golden coins... Not currency you've ever seen though.", 300);
        Item crwn = new Clothing("crown", 
                "It's treasure. It's the crown of a king. Exactly who's crown, you cannot guess.", 
                "You position the crown on your head. You've never felt so wealthy.", 300);
        Item brclt = new Clothing("bracelet", "It's treasure. A thick jade bracelet, cold and heavy.", 
                "You put the bracelet on your wrist.", 300);
        Item jdStat = new BreakableItem("jade statue", 
                "It's treasure. A small statuette made of jade depicting a sitting female.", 300);
        //-----------------------------FURNITURE-------------------------------- 
        Furniture vau2Chsts = new Vau_Chsts(cns, dmnd, jdStat);
        Furniture vauF = new Floor("The floors are sandstone blocks and covered in treasure.", brclt, grl, crwn);
        Furniture vauBwls = new Vau_Bowls();
        Furniture vauClng = new Vau_Ceiling();
        Furniture vaueF = new Floor("The walls here are sandstone blocks, much like those in the west wing, but seemingly older.");
        Furniture vauW = new Wall("The walls here are sandstone blocks, much like those in the west wing, but seemingly older.");
        Furniture vaueBttns = new Vaue_Door();

        // </editor-fold>

        // </editor-fold>
        // ---------------------------------------------------------------------     
        // <editor-fold defaultstate="collapsed" desc="AREA 7: TOWER">

        // <editor-fold defaultstate="collapsed" desc="INITIALIZE BLACK STAIRCASE">
        //-----------------------------THE ROOM---------------------------------
        Room bls1 = new Room("Atrium", Id.BLS1);
        Room bls2 = new Bls2("Second-floor atrium", Id.BLS2); 
        //-----------------------------FURNITURE-------------------------------- 
        Furniture blsWndw = new Bls_Windows();
        Furniture blsBlcny = new Bls_Balcony();

        Furniture bls1Stat = new Bls1_Statue();
        Furniture bls1Dr = new AtriumDoor(Direction.EAST);
        Furniture bls1Strs = new Bls_Staircase(Direction.UP, Id.BLS2);
        Furniture bls1_Plnts = new Bls1_Plants(sl, onyxFrag3);
        Furniture bls1F = new Floor("The floor is a gray mosaic formed from many tiny pieces of glossy ceramic.");

        Furniture bls2Strs = new Bls_Staircase(Direction.DOWN, Id.BLS1);
        Furniture bls2F = new Floor("The floor is iron lattice.");

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE TOWER">
        Furniture tow1Pdstl = new Tow1_Pedestal(towScptrPhy);
        //-----------------------------THE ROOM---------------------------------
        Room tow1 = new Tow1("Tower", Id.TOW1, tow1Pdstl);
        Room tow2 = new Tow2("Upper-tower", Id.TOW2);
        //-----------------------------FURNITURE-------------------------------- 
        Furniture towWndw = new Tow_Windows();
        Furniture towBlcny = new Tow_Balcony();
        Furniture towSphr = new Tow_Sphere();

        Furniture tow1F = new Floor("The floor is checkered white and blue, and very clean.");
        Furniture tow1Dr = new Foy4_Door(Direction.NORTH);
        Furniture tow1BlckDr = new AtriumDoor(Direction.WEST);

        Furniture tow2DrN = new Tow2_NorthDoor(Direction.NORTH);
        Furniture tow2F = new Floor("An iron cage-like material forms the floor and railings of the circular balcony.");

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE LICH'S QUARTERS">
        //-----------------------------THE ROOM---------------------------------
        Room lqu1 = new Lqu1("Lich's quarters", Id.LQU1);
        Room lqu2 = new Room("Lich's bed", Id.LQU2);
        //-------------------------------ITEMS----------------------------------
        // Items for the dampening staff are at higher up in this method.
        Item lchClths = new Clothing("lich clothes", 
                "These are long black robes; the kind Lichs wear, you suppose.", 
                "You really don't feel comfortable putting these on.", 150);
        //-----------------------------FURNITURE-------------------------------- 
        Furniture lquF = new Floor("The floor around the carpet is hard and cold stone.");
        Furniture lquW = new Wall("The walls are clean smooth stone and decorated with faux columns.");

        Furniture lqu1Mrrr = new Lqu1_Mirror();
        Furniture lqu1Cbnt = new Lqu1_Cabinet(stffHndl);
        Furniture lqu1_Bd = new Lqu1_Bed();
        Furniture lqu_Crpt = new Lqu_Carpet();
        Furniture lqu1Lvr = new Lqu2_Lever(cou3Gt);
        
        Furniture lqu2Bd = new Lqu2_Bed(lchClths);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE TOP BALCONY">
        //-----------------------------THE ROOM---------------------------------
        Room tbal = new Tbal("High balcony", Id.TBAL);
        //-----------------------------FURNITURE--------------------------------
        Furniture tbalStrs = new Tbal_Stairs();
        Furniture tbalPllr = new Tbal_Pillar();
        Furniture tbalDrS = new Tow2_NorthDoor(Direction.SOUTH);
        Furniture tbalF = new Floor("The floor is a gray mosaic formed from many tiny pieces of glossy ceramic.");
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE SOUL CHAMBER">
        //-----------------------------THE ROOM---------------------------------
        Room soul = new Room("Soul chamber", Id.SOUL);
        //-----------------------------FURNITURE-------------------------------- 
        Furniture soulPl = new Soul_Pool(towSphr, lqu1, tow1, tow2);
        Furniture soulStat = new Soul_Statues();
        Furniture soulF = new Floor("It's a light-gray tiled floor.");
        Furniture soulWndw = new Soul_Window();

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE END ROOM">

        /*
            The game ends once the player enters this room. Player must exit
            the game manually at this point. Game data is automatically
            erased at this point also.
        */
        Room endg = new Endg("", Id.ENDG);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="INITIALIZE HADES">

        /*
            If the player dies, the player ends up here where the game stops
            progressing.
        */
        //-----------------------------THE ROOM---------------------------------
        Room hads = new Hades("Entrance to Hades", Id.HADS);
        //-------------------------------ITEMS----------------------------------
        Item leg = new Item("mangled leg", "It's a disembodied rotting leg, dirty, and awful smelling.", -1000);
        Item torso = new Item("mangled torso", "It's a disembodied rotting torso, dirty, and awful smelling.", -1000);
        Item hand = new Item("mangled hand", "It's a disembodied rotting hand, dirty, and awful smelling.", -1000);
        Item arm = new Item("mangled arm", "It's a disembodied rotting arm, dirty, and awful smelling.", -1000);
        //-----------------------------FURNITURE-------------------------------- 
        Furniture hadsCrpses = new Hads_Corpses(leg, torso, hand, leg, typhos ,arm, torso, hand);
        Furniture hadsSprts = new Hads_Spirits();
        Furniture hadsVcs = new Hads_Voices();
        Furniture hadsGtwy = new Hads_Gateway();
        Furniture hadsF = new Floor("The scorched brimstone burns beneath your feet.");
        Furniture hadsW = new Wall("High rock walls hopelessly bar you from escape.");

        // </editor-fold>

        // </editor-fold>
        //**********************************************************************
        // </editor-fold>  
        //**********************************************************************


        //**********************************************************************
        // <editor-fold defaultstate="collapsed" desc="PUT FURNITURE IN ROOMS">
        //*********************************************************************/  

        // <editor-fold defaultstate="collapsed" desc="AREA 1: CASTLE FRONT">

        for1.addFurniture(forTrs, rotuSky, forThckt, forFrst, cou4Trl, forF);
        for2.addFurniture(forTrs, for2Elk, rotuSky, forThckt, forFrst, cou4Trl, forF);
        for3.addFurniture(forTrs, rotuSky, forThckt, forFrst, cou4Trl, forF);
        for4.addFurniture(forTrs, rotuSky, forThckt, forFrst, cou4Trl, forF);
        foy1.addFurniture(foyFrntDr, genDoor, foy1Gt, foy1Armr, foyF, foyW, 
                foy1Chnd, eastDoor, foy1Tbl, foy1Crpt, foy1Strs, clng);
        foy2.addFurniture(foy2Gt, foy2Stat, foy2Alc, foyF, foyW, foy2Strcs, clng);
        foy3.addFurniture(foy3Strs, westDoor, foyW, foy3F, foy34Crpt, clng);
        foy4.addFurniture(foy4Strs, foyW, foy4F, foy34Crpt, foy4Dr, clng);
        vest.addFurniture(vesFire, vesBtn, vesWin, vesDsk, vesEtbl, vesCase, 
                vesTpstr, vesChr, vesF, vesDr, wallEx, vesOrb);
        foyb.addFurniture(bbaF, wallEx, bbaClmns, bbaRlng, bbaVllg, clng, bbaBnch, 
                bbaScnc, bbaClff, bbaShrln, bbaSea, bba1Gt, wantBttn);
        foyc.addFurniture(bbaF, wallEx, bbaClmns, bbaRlng, bbaVllg, clng, bbaScnc, 
                bbaClff, bbaShrln, bbaSea, bba2Dr);
        cou1.addFurniture(couStps, cou1Bnch, cou1Thrns, couW, cou1F, couCstl, couRvns);
        cou2.addFurniture(couW, cou2F, cou2Bshs, cou2Fntn, couCstl, coutWlkwy, couRvns);
        cou5.addFurniture(couW, cou5F, cou2Bshs, cou5Fntn, couCstl, cou5Sprc, coutWlkwy, couRvns);
        cou6.addFurniture(couStps, cou1Bnch, cou1Thrns, couW, cou6F, cou6Stat, couCstl, cou6Ghst, couRvns);
        cou3.addFurniture(cou3F, couW, cou3Stps, cou3Gt, cou3Ivy, cou3Frk, couCstl, couRvns);
        cou4.addFurniture(cou3F, couW, cou4Gt, cou4Frst, cou4Mlbx, cou4Trl, couCstl, couRvns);
        cou7.addFurniture(couCstl, entrF, entrDr, entrStats, entrClmns, bbaRlng, entrRf, 
                entrStps, entrBlcny, couRvns);
        cou8.addFurniture(cou8Nest, cou8Sprc, couW);
        foyw.addFurniture(genDoor, wantStat, wantTrchs, wantLvr, wantPllrs, wWW, wantF, 
                wantRmp, wantDr, wantGt, wantBttn, clng);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="AREA 2: WEST WING">    

        rotu.addFurniture(genDoor, rotuFntn, rotuW, rotuF, rotuPlnts, rotuHl, rotuStat, 
                rotuScnc, rotuFrms, rotuSky, rotuRock, clng);
        cel1.addFurniture(cel1Lddr, celLntrn, wallEx, celPp, celF, clng);
        cel2.addFurniture(cel2Vlv, celLntrn, cel2Shft, wallEx, celPp, celF, cel2Clng);
        cel3.addFurniture(cel3Vlv, celLntrn, cel3Crt, wallEx, celPp, celF, nrthCelClng);
        cel4.addFurniture(celLntrn, cel4Wrkbnch, cel4Bd, wallEx, celPp, cel4Coal, celF, nrthCelClng);
        cel5.addFurniture(cel5Grt, cel5Lck, celLntrn, wallEx, celPp, celF, cel5Frnc, nrthCelClng);
        cel6.addFurniture(cel6Vlv, cel6Lddr, cel6Pltfrm, cel6Clmns, cel6Pp, cisDrknss, cel6Lghts, clng);
        look.addFurniture(lookDr, lookLghths, lookClff, lookRlng, lookF, wallEx, eastDoor, iha1Lvr, bbaSea);
        iha1.addFurniture(northDoor, wWW, ihaF, iha1Armr, iha1Bwl, ihaWndw, iha1Lvr, clng);
        iha2.addFurniture(southDoor, wWW, ihaF, iha2Armr, iha2Bwl, ihaWndw, clng);
        wow1.addFurniture(genDoor, wWW, westDoor, wow1NDr, wow1Crt, wow1F, wowWndw, wowHrth, wow1Shlvs, clng);
        wow2.addFurniture(genDoor, wow2Blcny, wow2Armr, wow2F, wow2Dr, northDoor, 
                wow2Hole, wowWndw, wowHrth, wow2Strcs, clng);
        wbal.addFurniture(wallEx, eastDoor, lookLghths, lookClff, lookRlng, wbalF, wbalBcn, wbalFrst, bbaSea);
        squa.addFurniture(wWW, squaF, squaBd, squaDsk, squaWndw, lookLghths, lookClff, 
                bbaSea, squaWrdrb, squaCndl, squaDr, clng);
        wow3.addFurniture(genDoor, wWW, wow3Shlf, wow3F, wow3Dr, bbaRlng, wow3NDr, clng);
        sha1.addFurniture(wWW, shaF, sha1Trch, sha1Dr, sha1SDr, clng);
        sha2.addFurniture(wWW, sha2Cbnt, shaF, sha2Dr, sha2Trch, clng);
        clos.addFurniture(closW, closF, closShlf, closStl, closBrrl, closWrkbnch, 
                closLddr, closScks, closClng, closSkltn, closDr);  
        cous.addFurniture(searFssr, searDr, searLddr, searAsh, searSkltn, searF, 
                searAsh, closW, clng, searWood);
        shar.addFurniture(wWW, rquaF, rquaBd, rquaTbl, rquaMttrss, rquaDrssr, squaWndw, 
                rquaWmn, lookLghths, lookClff, bbaSea, rquaPnl, clng, rquaClths);
        stud.addFurniture(wWW, studF, studPrtrt, studFire, studDsk, vesChr, studCch, 
                studBkCs, studCrpt, southDoor, iha1Lvr, clng);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="AREA 3: EAST WING">     

        gal1.addFurniture(gal1Dr, gal1F, gal1W, gal1Drgn, gal1KtnFurn, gal1Pntng, 
                gal1Pntng2, gal1Pntng3, gal1Armr, gal1Scr, gal1Scrn, gal1Pntngs, 
                gal1Lghts, gal1Sclptrs, gal1Hrth, clng);
        gal2.addFurniture(genDoor, gal2Stat, gal2Strcs, gal2Mchn, gal2F, gal2W, galBalc, 
                gal1Lghts, rotuSky, galDm, gal2Clmns, mhaSDr, eastDoor);
        gal3.addFurniture(gal3Ttm, gal3Peg, gal3Hl, gal3Sgmnt, gal3Htch, gal3Lddr, 
                gal3Rp, gal3Swtch, gal3InstFurn, gal3Msk, gal3Msk2, gal3Msk3, gal3Msks, 
                gal3Hrth, gal3F, gal3W, gal3Art, gal3Art2, gal3Art3, gal3Arts, clng);
        gal4.addFurniture(gal4Strcs, galBalc, rotuSky, gal2W, galDm, gal4Lck,  gal2Clmns, 
                gal4Dr, gal4Glss, gal4Cs, gal4Lft, gal4Rdo, gal4F, gal4Crpt, gal4Lvr);
        gal6.addFurniture(gal6Cnn, gal6Lddr, gal6Mchn, gal6Hlmt, gal6Bttn, gal6App, 
                gal6F, gal6W, gal6Htch, gal6Tech, gal6Elec, gal6Tbl, clng);
        gal7.addFurniture(wWW);
        mha1.addFurniture(genDoor, mhaChndlr, mhaChr, mha1Plnt, mhaF, mhaW, 
                mhaNWndw1, mhaNDr, mhaNChaDr, clng);
        mha2.addFurniture(mhaChndlr, mhaChr, mha2Plnt, mhaF, mhaW, mhaNWndw2, 
                mhaMDr, mhaRStat, mhaLStat, mhaStats, clng);
        mha3.addFurniture(genDoor, mhaChndlr, mhaChr, mha3Plnt, mhaF, mhaW, 
                mhaSWndw, mha3KitcDr, mhaSDr, clng);
        lib2.addFurniture(libLF, libW, libCch, lib2ShRck, lib2Stat, lib2Frplc, lib2Bttn, 
                lib2WrFr, lib2Vyg, libBkShlf, libScncs, lib2Wndw, clng);
        lib3.addFurniture(libLF, libW, westDoor, lib3Strs, libCch, lib3Stat, lib3Crtn, 
                libScncs, lib3Blcny, lib3Wndw, lib3Pllr, lib3Pntng);
        lib4.addFurniture(libUF, libW, libCch, lib4Frplc, lib4Bttn, lib4Prdtn, libScncs, 
                lib3Pllr, lib4Stat, lib4Glb, lib3Blcny, lib4Tbl, lib4Strs, clng);
        lib5.addFurniture(libUF, libW, lib5Bnshmnt, libScncs, lib3Pllr, lib5Cndlbr, clng);
        eow1.addFurniture(genDoor, wWW, eowF, eow1Dr, eow1Rck, eow1Bskt, eow1Trch, wowWndw, mhaNDr, clng);
        eow2.addFurniture(wWW, eowF, eow2Fntn, wtr, eow2Rck, wowWndw, 
                eow2Strs, eow2Blcny, eow2Cbnt, eow2Trch);
        eow4.addFurniture(wWW, eow4F, eow4Strs, bbaRlng, westDoor, clng);
        dst1.addFurniture(dst1F, dstW, dst1Strs, dst1Dr, dst1Lntrn, clng);
        lib1.addFurniture(lib1F, lib1W, vesChr, lib1Dsk, lib1Art, lib1Docs, lib1Rg, 
                lib1Wndw, lib1Rck, lib1Tbl, lib1Lght, lib1Mrrr, lib1Sf, clng);
        work.addFurniture(wWW, wrkF, eastDoor, wowWndw, wrkBrl, wrkCstTbl, wrkKln, 
                wrkBnch, wrkCbnt, wrkFrg, wrkAnvl, clng);
        din1.addFurniture(din1Clmns, din1Blcny, din1Tbl, din1Tpstry, din1F, din1W, 
                din1Wndw, din1Chrs, din1Chndlr, din1Mnlght, din1Strs, din1Crpt, din1Dr);
        din2.addFurniture(din2W, din2F, southDoor, din2Pntng, din2Strs, clng);
        drar.addFurniture(northDoor, drarGhst, drarF, drarW, din1Mnlght, drarChss, 
                drarBr, drarPno, drarBllrds, drarWndw, drarCch, drarTbl, clng);
        gal5.addFurniture(gal5Dsply, gal5Chndlr, gal5Cbwbs, gal5F, gal5W, gal5Clng, gal5Cbt, gal5Dr, clng);
        kitc.addFurniture(kitcTrch, kitcF, kitcW, kitcWndw, kitcDr, kitcRck, kitcPts, 
                kitcHrth, kitcBrls, kitcPntry, kitcShlf, kitcCntr, laboSnk, clng);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="AREA 4: CASTLE REAR">

        par2.addFurniture(genDoor, wWW, par2F, par2Wndw, westDoor, eastDoor, par2Strs, 
                parLft, par2Bwl, par2Frplc, par2Pno, par2Shlf);
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
        obs1.addFurniture(obsSlts, obsStats, obsF, obsW, obsWndw, obs1Strs, 
                obs1Tlscp, obs1Lmp, lib4Glb, obs1St, obsBlcny, northDoor);
        obs2.addFurniture(obsW, obs2F, obsWndw, obs2Strs, obsBlcny, obs2BkShlf, 
                obs2Pntng, obs2Rlng, obs2Chr, obs2Tbl, obs2Lmp);
        obs3.addFurniture(obs3Chndlr, obsW, obs3F, obsWndw, obs3Strs, 
                obsBlcny, obs2Rlng, obs3Chst, obs3Tlscps, clng);
        att1.addFurniture(attF, attW, sst2Dr, attCss, attBxs, gal5Cbwbs, attVnts, attClng);
        att2.addFurniture(attF, attW, att2Dr, att2Bxs, attCss, gal5Cbwbs, attVnts, attClng);
        labo.addFurniture(laboF, att2Dr, wallEx, laboStpCck, laboBrtt, laboGsPipe, 
                laboCntr, iceBrrl, laboRck, laboDspnsrs, laboDstllr, laboSnk, 
                          laboCntrptn, cndsr, laboTbl, laboDvcs, clng); 

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="AREA 5: SUB-LEVELS">

        // <editor-fold defaultstate="collapsed" desc="Tunnels and dungeon">

        sew0.addFurniture(sew0Strs, dngnW, sewF, sew0Trch, sewTnnl, sewMss);
        sew1.addFurniture(sew1Rvr, sewF, dngnW, sewTnnl, sew15Gt, sew1Trch, sewMss);
        sew2.addFurniture(sewRvr, sewF, dngnW, sewTnnl, sew2Trch, sewMss, sew2BrdgW, sew2Pp, sew2Vlvs);
        sew3.addFurniture(sewRvr, sewF, sewDrN, dngnW, sewTnnl, sew3Trch, sewMss, sew3BrdgE, sew3BrdgN, sew3Pp);
        sew4.addFurniture(sewRvr, sewF, sew4Pp, dngnW, sewTnnl, sew4Trch, sewMss);
        sew5.addFurniture(genDoor, sewRvr, sewF, sewDrW, sewDrE, dngnW, sewTnnl, 
                sew15Gt, sew5Trch, sewMss, sew5BrdgE, sew5Pp, sew5Vlv);
        cis1.addFurniture(cis1Trch, dngnW, sewDrE, cisF, cisWtr, cisClmns, cisDrknss);
        cis2.addFurniture(dngnW, cisF, cisWtr, cis2Bt, cisClmns, cisDrknss);
        cis3.addFurniture(cis3Trch, dngnW, sewDrE, cisF, cisWtr, cisClmns, cisDrknss);
        cis4.addFurniture(cis4Trch, dngnW, sewDrE, cisF, cisWtr, cisClmns, cisDrknss);
        cis5.addFurniture(cis2Bt, cis5Fgr, cisClmns, cisDrknss, cisWtr, cis5F);
        oub1.addFurniture(sewDrW, tm1Bwl, oub1F, dngnW, oub1Pt, dungMonst, clng);
        intr.addFurniture(intrDr, intrWhl, intrGrs, intrF, dngnW, intrGrt, 
                intrWtr, intrTrch, dungMonst, clng);
        esc1.addFurniture(esc1Lddr);
        esc6.addFurniture(esc6Grt, esc6Lddr);
        cas1.addFurniture(casW, casStrs, casF, cs35Trchs, cs35Stat, sewDrE, clng);
        sewp.addFurniture(genDoor, sewpCl, sewpGrt, sewpWtr, sewpF, dngnW, 
                sewDrE, sewDrW, sewpTrch, sewpTnnl);
        pris.addFurniture(genDoor, prisClls, prisFgr, dngnW, sewDrS, sewDrW, prisF, 
                prisCndlbrs, prisTbl, prisCbnt, prisGts, dungMonst, clng);
        torc.addFurniture(genDoor, sewDrE, sewDrW, dngnW, torcF, torcTrchs, torcSwhrses, 
                torcScythF, torcRck, torcCgs, torcWhl, torcWd, torcTls, dungMonst, clng);
        cry1.addFurniture(sewDrW, dngnW, cryF, cry1Stat, cryDrwrs, cry1Crvng, 
                cryLghts, dungMonst, cryDummy, clng);
        cry2.addFurniture(dngnW, cryF, cryDrwrs, cryLghts, cry2Engrvng, 
                cry2Altr, dungMonst, cry2Psswd, cryDummy, clng);
        aarc.addFurniture(sewDrW, aarcF, aarcW, aarcWd, aarcBks, aarcChndlr, 
                aarcDsk, aarcAlg, aarcShlvs, dungMonst, clng);
        dkch.addFurniture(sewDrW, dkchF, dngnW, dkchBd, dkchAxl, dkchDsk, 
                squaCndl, dkchClng, dungMonst);

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Catacombs and caves">

        tm16.addFurniture(tmb1Cskt, catW, tm1F, catDrS, tm1Vs, tm1Bwl, tm1Effgy, clng);
        tm66.addFurniture(tmb2Cskt, catW, tm2F, catDrE, tm2Vs, tm2Orb, clng);
        tm32.addFurniture(tmb3Cskt, catW, tm3F, catDrW, tm3Vs, tm3Tpstry, tm3Cndl, clng);
        ou62.addFurniture(catDrN, oubSpk, oubStrw, oub2F, dngnW, tm1Bwl, oubSkltn);
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
        cha1.addFurniture(cha1Cylx, cha1Wtr, northDoor, chaW, chaF, din1Mnlght, chaPws, 
                cha1Cndlbr, chaHz, chaCrpt, chaWndws, chaClng);
        cha2.addFurniture(chaF, chaW, din1Mnlght, chaPws, chaHz, chaCrpt, chaWndws, cha2Alt, chaClng);
        vau1.addFurniture(vauF, vauBwls, vau1Tbl, vauClng);
        vau2.addFurniture(vau2Chsts, vauF, vauBwls, vauClng);
        vaue.addFurniture(vaueF, vauBwls, vaueBttns, vauW, clng);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="AREA 7: TOWER">

        tow1.addFurniture(tow1F, wallEx, towWndw, towBlcny, tow1Pdstl, tow1Dr, tow1BlckDr, towSphr);
        tow2.addFurniture(genDoor, towWndw, wallEx, towBlcny, eastDoor, towSphr, tow2DrN, clng, tow2F);
        bls1.addFurniture(bls1Dr, bls1Strs, bls1_Plnts, blsWndw, bls1F, bls1Stat);
        bls2.addFurniture(eastDoor, bls2Strs, blsWndw, bls2F, blsBlcny);
        tbal.addFurniture(genDoor, tbalStrs, bbaSea, tbalPllr, northDoor, tbalDrS, tbalF);
        lqu1.addFurniture(westDoor, lquF, lqu1Mrrr, lqu1Lvr, lquW, lqu1Cbnt, lqu1_Bd, lqu_Crpt, clng);
        lqu2.addFurniture(lquF, lquW, lqu_Crpt, lqu2Bd, clng);
        soul.addFurniture(soulPl, soulStat, soulF, wallEx, soulWndw, clng);
        hads.addFurniture(hadsVcs, hadsGtwy, hadsSprts, hadsCrpses, hadsF, hadsW);

        // </editor-fold>

        //**********************************************************************
        // </editor-fold>  
        //**********************************************************************


        //**********************************************************************
        // <editor-fold defaultstate="collapsed" desc="LOCK ROOMS">
        //********************************************************************** 
        for (Room r : new Room[] {rotu, stud, gal5, gal1, par2, clos, din1, 
            kitc, ou62, chs1, work, tow1, sewp, dkch, wow2, vau2, cou4}) 
        { 
            r.setLocked(true);
        }
        //**********************************************************************
        // </editor-fold> 
        //********************************************************************** 
        

        //**********************************************************************
        // <editor-fold defaultstate="collapsed" desc="WRITE ROOMS TO FILES">
        // This is done so rooms don't remain in main memory when you haven't
        // visited them yet in the current game instance.
        //********************************************************************** 
        Room[] allRooms = {                        
            cel5,cel6,soul,hads,cel3,cel4,tbal,cel1,cel2,bls2,tow2,lqu1,lqu2,
            obs3,att1,labo,foy4,gal6,gal7,sst2,att2,bls1,tow1,chs3,for1,for2,
            for3,for4,cha2,for5,gal5,lib4,obs2,jha1,par2,foy3,gal3,gal4,lib5,
            sst1,jha2,gar1,gar2,din2,gar3,gar4,cou8,drar,wow3,clos,work,eow4,
            bha1,bha2,bha3,foyb,foyc,lib1,lib2,obs1,stud,par1,foy2,gal1,gal2,
            lib3,look,rotu,foyw,foy1,vest,mha1,chs1,squa,sha2,iha1,cou1,cou7,
            cou6,mha2,din1,shar,sha1,iha2,cou2,cou3,cou5,mha3,kitc,wbal,wow1,
            wow2,cous,cou4,dst1,eow1,eow2,endg,esc3,esc4,esc5,cis5,esc2,esc1,
            esc6,cas1,cry2,vau1,cis2,cis1,sew5,pris,torc,cry1,vau2,cis3,aarc,
            sew4,sew3,sew2,sew1,vaue,cis4,oub1,intr,sewp,dkch,sew0,ct11,ct12,
            ct13,ct14,ct15,tm16,ct17,my18,ct21,ct22,ct23,ct24,ct25,ct26,ct27,
            ct28,ct31,tm32,ct33,ct34,cs35,ct36,ct37,ct38,ct41,ct42,ct43,ct44,
            ct45,ct46,ct47,ct48,ct51,ct52,ct53,ct54,an55,ct56,ct57,ct58,ct61,
            ou62,ct63,ct64,an65,tm66,ct67,ct68,cv11,cv12,cv13,cv14,cv15,cv16,
            cv17,cv18,cv21,cv22,cv23,cv24,cv25,cv26,cv27,cv28,cv31,cv32,cv33,
            cv34,cv35,cv36,cv37,cv38,cv41,cv42,cv43,cv44,cv45,cv46,cv47,cv48,
            cv51,cv52,cv53,cv54,cv55,cv56,cv57,cv58,cv61,cv62,cv63,cv64,ms65,
            ms66,cv67,cv68,cha1, new Room(Id.NULL, Id.NULL)
        };
        
        String base = "data" + SEP + "rooms" + SEP;
        
        for (Room room : allRooms) {
            int[] i = room.getCoords();
            String path = base + "lvl_" + i[0] + SEP + "row_" + i[1] + SEP + room.getID() + ".data";
            File f = new File(path);
            
            if (f.exists())
                f.delete();
            
            try (ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(f))) 
            {
                oos.writeObject(room);
            }
            catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        //**********************************************************************
        // </editor-fold> 
        //********************************************************************** 
    }
}
