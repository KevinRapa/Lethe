package Core;
/**
 * This is a text-based adventure game called Salamaa being written as a
 * personal project.
 * <p>
 * You control an unnamed character who is exploring a castle after having 
 * wandered through the woods to it without any apparent reason. As the game
 * progresses, puzzles get steadily more complex and a story develops.
 * <p>
 * Salamaa is a word based in Finnish meaning something along the lines of
 * "secret world," though that concept is not normally expressed this way.
 * 
 * @author Kevin Rapa
 */

// ============================================================================
import Super.Room;
import Super.Trch;         import Library.Lib_Shoes;    import Super.Door; 
import Super.Floor;        import Super.Wall_Ex;        import Super.Item;
import Super.Furniture;    import Super.Key;            import Super.Wall;

import Tool_Closet.*;      import Vestibule.*;          import Foyer.*; 
import Back_Balcony.*;     import Rotunda.*;            import Lookout.*; 
import West_Outer_Wall.*;  import West_Balcony.*;       import Servants_Quarters.*;
import Servants_Hall.*;    import Ransacked_Quarters.*; import Courtyard.*;
import Front_Balcony.*;    import Scorched_Room.*;      import Study.*; 
import Marble_Hall.*;      import Library.*;            import East_Outer_Wall.*; 
import Secret_Archives.*;  import Workshop.*;           import Dining_Room.*; 
import Drawing_Room.*;     import Trophy_Room.*;        import Kitchen.*; 
import West_Antechamber.*; import Iron_Hall.*;          import Gallery.*;
import Observatory.*;      import Dungeon_Stairs.*;     import Parlor.*;
import Chapel_Stairs.*;

import javax.swing.*;      import java.io.*;
// ============================================================================

public class Salamaa {
    private static Player me;
    private static Room[][][] map;
    
    //**************************************************************************
    // <editor-fold desc="MAIN METHOD">
    //**************************************************************************
    
    public static void main(String[] args) {
           
        //**********************************************************************
        // <editor-fold desc="MAKE FRAME">
        //**********************************************************************
        
        GUI panel = new GUI();
        JFrame frame = new JFrame("Salamaa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(panel);
        frame.setResizable(false);
        
        frame.pack();
        frame.setVisible(true);

        //**********************************************************************
        // </editor-fold>  
        //**********************************************************************
        
        
        //**********************************************************************
        // <editor-fold desc="READ IN SAVE FILE OR START NEW GAME">
        //**********************************************************************
        
        Help.constructHelp();
        
        try (ObjectInputStream plyr = new ObjectInputStream(
                                      new FileInputStream("Player.data"));
             ObjectInputStream mp = new ObjectInputStream(
                                    new FileInputStream("Map.data")); 
            ) 
        {
            me = (Player) plyr.readObject();
            map = (Room[][][]) mp.readObject();
            me.mainPrompt(map); // START GAME
        } 
        catch (java.lang.ClassNotFoundException | java.io.IOException e) { 
            System.out.println("Data missing. Creating new game.");
            Room_Refs.constructRoomReferences();
            map = createMap();
            me.startDialog(map); // START GAME
        }
        
        //**********************************************************************
        // </editor-fold>  
        //**********************************************************************
        
        
        //**********************************************************************
        // <editor-fold desc="WRITE GAME DATA TO FILE">
        //**********************************************************************
        
        frame.dispose();
        
        try (ObjectOutputStream plyr = new ObjectOutputStream(
                                       new FileOutputStream(
                                       new File("Player.data")));
             ObjectOutputStream mp = new ObjectOutputStream(
                                     new FileOutputStream(
                                     new File("Map.data")));
            ) 
        {
            plyr.writeObject(me);
            mp.writeObject(map);
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
          
        //**********************************************************************
        // </editor-fold>  
        //**********************************************************************
        
    } 
    
    //**************************************************************************
    // </editor-fold>  
    //**************************************************************************
    
    
    // *************************************************************************
    // <editor-fold desc="CREATE NEW MAP">
    // *************************************************************************    
    
    /**
     * This creates a new castle map for a new game. 
     * The map is a structured reference to every room in the game, and all the
     * objects in each of the room.
     * @return The castle map.
     */
    private static Room[][][] createMap() {
        
        me = new Player();
        
        //**********************************************************************
        // <editor-fold desc="INITIALIZE ROOMS, FURNITURE, ITEMS">
        //
        // Every room and room object is instantiated here.
        //**********************************************************************

        //**********************************************************************
        // <editor-fold desc="INITIALIZE KEYS">
        //**********************************************************************

                Key studKey = new Key("crude molded key", "STUD");        
                Key gal1Key = new Key("key with a bearded face on its bow", "GAL1");       
                Key eow3Key = new Key("workshop key", "EOW3");       
                Key par2Key = new Key("key with a rose on its bow", "PAR2");      
                Key kitcKey = new Key("kitchen key", "KITC");
                Key closKey = new Key("closet key", "GQUA");
                Key wow2Key = new Key("rusty key", "WOW2");
                Key sha1CbtKey = new Key("tiny key", "CBNT");
                Key servKey = new Key("servant's quarters key", "XXXX");
                Key dngnKey = new Key("key with a skull on its bow", "XXXX");
                Key drwKey = new Key("drawing room key", "DRAR");
                Key chs1Key = new Key("key with a cross on its bow", "CHS1");
                
                //Key cas1Key = new Key("cas1 key", "CAS1");
                //Key sew6Key = new Key("sew6 key", "SEW6");
                //Key soulKey = new Key("soul key", "SOUL");
                //Key archKey = new Key("arch key", "ARCH");
                //Key bls1Key = new Key("bls1 key", "BLS1"); 
                

        //**********************************************************************
        // </editor-fold>
        //**********************************************************************

        Door door = new Door("door"); // Generic wooden door.
        Furniture wallEx = new Wall_Ex("wall"); // Generic exterior castle wall.
        
        //----------------------------------------------------------------------              
        // <editor-fold desc="AREA 1: VESTIBULE">
        
        Item bckt = new Item("metal bucket", "It's an empty metal bucket."); // Used with all fireplaces
        
        // <editor-fold desc="INITIALIZE WEST ANTECHAMBER">
        //-----------------------------THE ROOM---------------------------------
        Room want = new Want("in an antechamber", "WANT");     
        //-----------------------------FURNITURE--------------------------------        
        Furniture wantLvr = new Want_Lvr("lever");
        Furniture wantStat = new Want_Stat("statue", wantLvr);
        Furniture wantPllrs = new Want_Pllrs("pillars");
        Furniture wantTrchs = new Want_Trchs("torches");
        Furniture wWW = new Wall("wall", "It's made of big sandstone bricks");
        Furniture wantF = new Floor("floor", "A sandstone tiled floor.");
        Furniture wantRmp = new Want_Rmp("ramp");
        Furniture wantDr = new Want_Dr("door");
        // </editor-fold>
        // <editor-fold desc="INITIALIZE BACK BALCONY">
        //-----------------------------THE ROOM---------------------------------
        Room bba1 = new Bba1("on the back balcony", "BBA1");
        Room bba2 = new Bba2("on the back balcony", "BBA2");      
        //-------------------------------ITEMS----------------------------------        
        Item bbaNote = new Bba_Note("note from a visitor");
        //-----------------------------FURNITURE--------------------------------                       
        Furniture bbaF = new Floor("floor", "It's a shale tile floor.");
        Furniture bbaClmns = new Bba_Clmns("columns");   
        Furniture bbaRlng = new Bba_Rlng("railing");
        Furniture bbaRf = new Bba_Rf("roof");   
        Furniture bbaVllg = new Bba_Vllg("village");
        Furniture bbaScnc = new Bba_Scnc("sconce");   
        Furniture bbaBnch = new Bba_Bnch("bench", bbaNote);
        Furniture bbaWvs = new Bba_Wvs("waves");
        Furniture bbaClff = new Bba_Clff("cliff");
        Furniture bbaShrln = new Bba_Shrln("shoreline");
        Furniture bbaSea = new Bba_Sea("sea");
        Furniture bbaDrp = new Bba_Drop("drop");
        Furniture bba2Dr = new Bba2_Dr("door");
        // </editor-fold>
        // <editor-fold desc="INITIALIZE FOYER">
        //-----------------------------THE ROOM---------------------------------
        Room foy1 = new Foy1("in the foyer", "FOY1", want);
        //-------------------------------ITEMS----------------------------------        
        Item foy1Note = new Foy1_Note("short letter");
        //-----------------------------FURNITURE--------------------------------        
        Furniture foyW = new Wall("wall", "A dark wood-paneled wall.");
        Furniture foyF = new Floor("floor", "Salmon-colored tiled marble. Its glint stuns you.");
        Furniture foy1Gt = new Foy_Gt("gate", false);
        Furniture foy1Chnd = new Foy_Chnd("chandelier");
        Furniture foy1Tbl = new Foy1_Tbl("table", foy1Note);
        Furniture foy1Crpt = new Foy1_Crpt("carpet");
        Furniture foy1Strs = new Foy1_Strs("staircase");       
        // </editor-fold>        
        // <editor-fold desc="INITIALIZE GRAND STAIRCASE">
        //-----------------------------THE ROOM---------------------------------
        Room foy2 = new Foy2("at the grand staircase", "FOY2", bba1);                           
        //-----------------------------FURNITURE--------------------------------           
        Furniture foy2Gt = new Foy_Gt("gate", true);
        Furniture foy2Lvr = new Foy2_Lvr("lever", foy1Gt, foy2Gt);
        Furniture foy2Stat = new Foy2_Stat("statue", foy2Lvr);
        Furniture foy2Alc = new Foy2_Alc("alcove", foy2Stat);
        Furniture foy2Strcs = new Foy2_Strcs("staircase", me, 'u', 1);
        // </editor-fold>
        // <editor-fold desc="INITIALIZE VESTIBULE">
        //-----------------------------THE ROOM---------------------------------
        Room vest = new Vest("in a vestibule", "VEST"); 
        //-------------------------------ITEMS----------------------------------
        Key rotuKey = new Key("key with a cobra head on its bow", "ROTU");    
        //-----------------------------FURNITURE--------------------------------
        Furniture vesFire = new Vest_Frplc("fireplace", true, bckt, me.getINV());
        Furniture vesBtn = new Vest_Bttn("button", vesFire);
        Furniture vesWin = new Vest_Wndw("window", vesFire, vest);
        Furniture vesDr = new Vest_Dr("door");      
        Furniture vesDsk = new Vest_Dsk("desk");
        Furniture vesEtbl = new Vest_Etbl("table");
        Furniture vesCase = new Vest_Case("case", rotuKey);
        Furniture vesTpstr = new Vest_Tpstr("tapestry");
        Furniture vesChr = new Vest_Chr("chair");
        Furniture vesF = new Floor("floor", "A cold, shale tile floor. It's slightly dusty.");          
        // </editor-fold>
        // <editor-fold desc="INITIALIZE COURTYARD">
        //-----------------------------THE ROOM---------------------------------
        Room cou1 = new Cou1("in the courtyard", "COU1");
        Room cou2 = new Cou2("in the courtyard", "COU2");
        Room cou3 = new Cou3("in the courtyard", "COU3");
        Room cou4 = new Cou4("in the courtyard", "COU4");
        Room cou5 = new Cou5("in the courtyard", "COU5");
        Room cou6 = new Cou6("in the courtyard", "COU6");
        //-------------------------------ITEMS----------------------------------
        Item soldMed = new Item("stone disk", "The smooth disk is about four or five inches across.\n"
                                            + "It's craftmanship is precise, although there's a\n"
                                            + "chip on its edge. On its surface is an embossment\n"
                                            + "of a soldier.");
        Item rck = new Item("rock", "It's a piece of the courtyard fountain.");
        Item trs = new Item("statue torso", "It's a stone torso, probably from\nthe courtyard statue");
        Item hd = new Item("statue head", "It's a stone head with a chiseled male face.");
        Item sprcExtrct = new Item("spruce extract", "Evergreens are widely known to be resistant to burning.");
        //-----------------------------FURNITURE--------------------------------
        Furniture cou3Stps = new Cou3_Stps("steps", me, 'u', '1');
        Furniture couStps = new Cou_Stps("steps");
        Furniture cou1Bnch = new Cou1_Bnch("bench");
        Furniture cou1Thrns = new Cou1_Thrns("thorns");
        Furniture couW = new Wall("wall", "The castle walls are several stories\n"
                                + "tall and made of granite blocks.");
        Furniture cou12F = new Floor("ground", "The ground is a mixture of grass\n"
                                   + "weeds, and clover.");
        Furniture cou56F = new Floor("ground", "The ground is a mixture of grass\n"
                                   + "weeds, and clover.", trs, hd);
        Furniture cou3F = new Floor("ground", "The ground is a mixture of grass\n"
                                  + "weeds, and clover.");
        Furniture cou2Fntn = new Cou2_Fntn("fountain", rck, rck, rck, rck);
        Furniture cou2Bshs = new Cou2_Bshs("bushes");
        Furniture cou5Fntn = new Cou5_Fntn("fountain", rck, soldMed, rck);
        Furniture cou5Sprc = new Cou5_Sprc("spruce", me.getINV(), sprcExtrct);
        Furniture cou6Stat = new Cou6_Stat("statue");
        Furniture cou3Gt = new Cou3_Gt("gate");
        Furniture cou4Gt = new Cou4_Gt("gate");
        Furniture cou3Ivy = new Cou3_Ivy("ivy");
        Furniture cou3Fntns = new Cou3_Fntns("fountains");
        Furniture cou4Frst = new Cou4_Frst("forest");
        Furniture cou4Trl = new Cou4_Trl("trail");
        Furniture couCstl = new Cou_Cstl("castle");
        // </editor-fold>
        // <editor-fold desc="INITIALIZE ENTRANCE">
        //-----------------------------THE ROOM---------------------------------
        Room entr = new Entr("on the front balcony", "ENTR");  
        //-----------------------------FURNITURE--------------------------------
        Furniture entrF = new Floor("floor","The balcony is layed with a brown shale tile.");
        Furniture entrClmns = new Entr_Clmns("columns");
        Furniture entrRf = new Entr_Rf("roof");
        Furniture entrStats = new Entr_Stats("statues");
        Furniture entrDr = new Entr_Dr("door");
        Furniture entrStps = new Entr_Stps("steps", me, 'd', 1);
        // </editor-fold>

        // </editor-fold>
        //---------------------------------------------------------------------- 
        // <editor-fold desc="AREA 2: WEST WING">
        
        Item brRam = new Item("broken battering ram", "It's a battering ram, but without the other rope to\nhold it with, it's useless.", "It's useless now.");
        Item ram = new Item("battering ram", "You've restored the old battering ram back to its former glory");
        Item redFcs = new Focus("red focus", "It's a cool brass ring holding a red lens.");   
        Item hndTrch = new Item("hand torch", "It's a burning piece of wood. Stay it from your beard!");
        
        // <editor-fold desc="INITIALIZE ROTUNDA">
        //-----------------------------THE ROOM---------------------------------
        Room rotu = new Rotu("in the rotunda", "ROTU", want);       
        //-----------------------------FURNITURE-------------------------------- 
        Furniture rotuFntn = new Rotu_Fntn("fountain");
        Furniture rotuWhl = new Rotu_Whl("wheel", rotu);
        Furniture rotuW = new Wall("wall", "A clean white marble wall.");
        Furniture rotuF = new Floor("floor", "It's a dirty white-tiled floor, littered with plant\nmatter.");
        Furniture rotuPlnts = new Rotu_Plnts("plants", rotuFntn);
        Furniture rotuHl = new Rotu_Hl("hole");
        Furniture rotuStat = new Rotu_Stat("statue");
        Furniture rotuScnc = new Rotu_Scnc("sconce");
        Furniture rotuDr = new Rotu_Dr("door");
        Furniture rotuFrms = new Rotu_Frms("frames");
        Furniture rotuSky = new Rotu_Sky("sky");
        Furniture rotuRock = new Rotu_Rock("rock");
        // </editor-fold>        
        // <editor-fold desc="INITIALIZE LOOKOUT">
        //-----------------------------THE ROOM--------------------------------- 
        Room look = new Look("on the lookout", "LOOK");       
        //-------------------------------ITEMS----------------------------------
        Item lookRope = new Item("looped rope", "It's a short rope tied into a noose. It's pretty\n"
                               + "frayed in the center from being tied around that\n"
                               + "railing for so long.", ram, "battering ram", 3);
        //-----------------------------FURNITURE-------------------------------- 
        Furniture lookVlv = new Look_Vlv("valve", rotuFntn, rotu, rotuWhl);
        Furniture lookLghths = new Look_Lghths("lighthouse");
        Furniture lookClff = new Look_Clff("cliff");
        Furniture lookRlng = new Look_Rlng("railing", lookRope);
        Furniture lookF = new Floor("floor", "Just a wet shale floor.");
        // </editor-fold> 
        // <editor-fold desc="INITIALIZE IRON HALL">
        //-----------------------------THE ROOM---------------------------------
        Room iha1 = new Iha1("in the iron hall north", "IHA1");
        Room iha2 = new Iha2("in the iron hall south", "IHA2");
        //-------------------------------ITEMS----------------------------------
        Item iha2plArm = new Item("polearm", "It looks like an old medieval polearm.");
        //-----------------------------FURNITURE--------------------------------
        Furniture iha1Armr = new Iha1_Armr("plate armor");
        Furniture iha1Hnd = new Iha1_Hnd("gauntlet");
        Furniture iha2Armr = new Iha2_Armr("plate armor", iha2plArm);
        Furniture iha2Hnd = new Iha2_Hnd("gauntlet", iha2Armr);        
        Furniture iha1F = new Floor("floor", "A sandstone tiled floor.");
        Furniture iha2F = new Floor("floor", "A sandstone tiled floor.");
        Furniture ihaWndw = new Iha_Wndw("window");
        Furniture iha1Bwl = new Iha1_Bwl("bowl", iha1F, wow2Key);
        Furniture iha2Bwl = new Iha2_Bwl("bowl");
        // </editor-fold>
        // <editor-fold desc="INITIALIZE WEST OUTER WALL">
        //-----------------------------THE ROOM---------------------------------
        Room wow1 = new Wow1("in the west outer wall", "WOW1");
        Room wow2 = new Wow2("in the west outer wall", "WOW2");
        //-------------------------------ITEMS----------------------------------
        Item wowLddr = new Item("fixed ladder", "The spoke sits in there a bit awkwardly, but it\n"
                              + "seems like a good ladder. It may even support your heft.");   
        Item wow1Spk = new Item("wheel spoke", "It's a wooden rod, about a foot long.", wowLddr, "ladder", 3);
        //-----------------------------FURNITURE--------------------------------
        Furniture wow2Strs = new Wow2_Strs("ladder", me, 'u', 1); // Not in WOW2 to start.
        Furniture wow2Armr = new Wow2_Armr("plate armor");
        Furniture wow1Crt = new Wow1_Crt("cart", wow1Spk);
        Furniture wow2Blcny = new Wow2_Blcny("balcony", wow2Strs, wow2, me.getINV(), wowLddr);
        Furniture wow2F = new Floor("floor", "A sandstone tiled floor.");
        Furniture wow2Dr = new Wow2_Dr("door");
        Furniture wow2Hole = new Wow2_Hole("hole");
        Furniture wowWndw = new Wow_Wndw("window");
        Furniture wowHrth= new Wow_Hrth("hearth", true, bckt, me.getINV());
        Furniture wow2Strcs= new Wow2_Strcs("staircase"); 
        Furniture wow1Tls= new Wow1_Tls("tools");
        Furniture wow1Shlvs = new Wow1_Shlvs("shelves");
        Furniture wow3Strs = new Wow2_Strs("ladder", me, 'd', 1);
        // </editor-fold>
        // <editor-fold desc="INITIALIZE WEST BALCONY">
        //-----------------------------THE ROOM---------------------------------
        Room wbal = new Wbal("on the west balcony", "WBAL");   
        //-------------------------------ITEMS----------------------------------
        Item wbalch = new Item("chunk of wood", "It's a plain chunk of wood.");
        Item wbalsp = new Item("wood splinter", "It's a splinter of wood.");
        Item wbalbr = new Item("branch", "A plain branch.");
        Item wbalBrg = new Item("broken rod", "It looks like it belonged to a ladder.");
        Item wbalRng = new Item("wooden rod", "It's a wooden rod, about a foot long.", wowLddr, "ladder", 3);
        //-----------------------------FURNITURE--------------------------------
        Furniture wbalF = new Floor("floor", "A shale tile floor. Many pieces of wood\nlitter it.", 
                                    wbalch, wbalbr, wbalBrg, wbalsp, wbalsp, wbalRng, wbalbr, wbalch, wbalch);
        Furniture wbalBcn = new Wbal_Bcn("beacon");
        Furniture wbalFrst = new Wbal_Frst("forest");
        // </editor-fold>
        // <editor-fold desc="INITIALIZE SERVANTS QUARTERS">
        //-----------------------------THE ROOM---------------------------------
        Room squa = new Squa("in a servant's quarters", "SQUA");
        //-------------------------------ITEMS----------------------------------
        Item squaLddr = new Squa_Lddr("broken ladder", wowLddr);
        Item squaJrnl = new Squa_Jrnl("cook's journal");
        Item rags = new Item("worn rags", "Some dirty worn rags.", "You are perfectly content with the clothes you have on\nnow.");
        Item aprn = new Item("kitchen apron", "It's a kitchen apron.", "You are perfectly content with the clothes you have on\nnow.");
        Item shs = new Item("slippers", "A pair of white evening slippers.", "You are perfectly content with the clothes you have on\nnow.");
        //-----------------------------FURNITURE--------------------------------
        Furniture squaF = new Floor("floor", "A sandstone tiled floor.");
        Furniture squaBd = new Squa_Bd("bed", squaLddr);
        Furniture squaDsk = new Squa_Dsk("desk", squaJrnl, sha1CbtKey);
        Furniture squaWndw = new Squa_Wndw("window");
        Furniture squaCndl = new Squa_Cndl("candle");
        Furniture squaWrdrb = new Squa_Wrdrb("wardrobe", rags, rags, aprn, shs);
        // </editor-fold>
        // <editor-fold desc="INITIALIZE CLOSET">
        //-----------------------------THE ROOM---------------------------------
        // Used to be called "Groundskeeper's quarters"
        Room clos = new Gqua("in a tool closet", "GQUA");
        //-------------------------------ITEMS----------------------------------
        Item closCrwbr = new Item("crowbar", "A sweet iron crowbar.");
        Item hmmr = new Item("hammer", "It's a small handheld nailing device.");
        Item frt = new Item("fertilizer", "It's a handful of mysterious gardening wizardry.");
        Item sd = new Item("seed", "It's a handful of mysterious gardening wizardry.");
        Item gl = new Item("glue bottle", "It's a bottle of sticky glue.");
        Item closGlv = new Item("gloves", "Some old gardening gloves", "They don't fit on your enormous hands.");
        Item closStrw = new Item("straw", "It's just straw");
        Item scrw1 = new Scrw("1mm screw", redFcs);
        Item scrw2 = new Item("2mm screw", "A small screw.");
        Item scrw5 = new Item("5mm screw", "A small screw.");
        Item snd = new Item("sand", "You have a pocket full of sand. It's grainy\nand uncomfortable.");
        //-----------------------------FURNITURE--------------------------------
        Furniture closLddr = new Gqua_Lddr("ladder", me, 'd', 1);
        Furniture closClng = new Gqua_Clng("ceiling");
        Furniture closF = new Floor("floor", "It's a cold, hard, cobblestone floor", closStrw);
        Furniture closScks = new Gqua_Scks("sacks", sd, sd, sd, frt, frt, frt, snd, snd, snd, snd, snd);
        Furniture closShlf = new Gqua_Shlf("shelf", bckt, closGlv);
        Furniture closWrkbnch = new Gqua_Wrkbnch("workbench", gl, hmmr, scrw2, scrw1, scrw2, scrw5, scrw5, scrw1);
        Furniture closStl = new Gqua_Stl("stool");
        Furniture closBrrl = new Gqua_Brrl("barrel");
        Furniture closW = new Wall("wall", "It's a plain cobblestone wall.");
        Furniture closSkltn = new Gqua_Skltn("skeleton", closCrwbr);
        // </editor-fold>
        // <editor-fold desc="INITIALIZE WEST OUTER WALL BALCONY">
        //-----------------------------THE ROOM---------------------------------
        Room wow3 = new Wow3("on the west outer wall balcony", "WOW3", me, wow2Strs, wow2F, wow3Strs, wowLddr);
        //-------------------------------ITEMS----------------------------------
        Item wowRope = new Item("rope", "It's a short coiled rope.", ram, "battering ram", 3);
        //-----------------------------FURNITURE--------------------------------
        Furniture wow3Shlf = new Wow3_Shlf("shelf", wowRope, closKey);
        Furniture wow3F = new Floor("floor", "A sandstone tiled floor.");
        Furniture wow3Dr = new Wow3_Dr("door");
        // </editor-fold>
        // <editor-fold desc="INITIALIZE RANSACKED QUARTERS">
        //-----------------------------THE ROOM---------------------------------
        Room rqua = new Rqua("in ransacked quarters", "RQUA");
        //-------------------------------ITEMS----------------------------------
        Item cmb = new Item("comb", "A plain hair comb.", "You comb your beard for several seconds until it's nice and kept.");
        Item cndlStk = new Item("candlestick", "A small brass candlestick.");
        Item sht = new Item("sheet", "A white bedsheet.");
        //-----------------------------FURNITURE--------------------------------
        Furniture rquaBd = new Rqua_Bd("bed");
        Furniture rquaMttrss = new Rqua_Mttrss("mattress");
        Furniture rquaTbl = new Rqua_Tbl("table");
        Furniture rquaDrssr = new Rqua_Drssr("dresser");
        Furniture rquaF = new Floor("floor", "A sandstone tiled floor.", rags, cmb, rags, sht, cndlStk, rags, shs);
        Furniture rquaPnl = new Rqua_Pnl("tile", studKey, rqua, me.getKEYS(), rquaBd);
        // </editor-fold>
        // <editor-fold desc="INITIALIZE SERVANTS HALL">
        //-----------------------------THE ROOM---------------------------------
        Room sha2 = new Sha2("in the north servant's hall", "SHA2");
        Room sha1 = new Sha1("in the south servant's hall", "SHA1");
        //-------------------------------ITEMS----------------------------------
        Item wdChnk = new Wood_Chunk("wood log", ram);       
        Item shaMp = new Item("mop", "It's a classic mop.", "Yes, let's just make this a game about\n"
                                                              + "cleaning some madman's castle.");
        Item shaSpng = new Item("sponge", "It's a quintessential yellow sponge.", "I'm a lumberjack, not a maid!");
        //-----------------------------FURNITURE--------------------------------       
        Furniture sha2Cbnt = new Sha2_Cbnt("cabinet", me, wdChnk, shaSpng, shaMp, bckt);
        Furniture shaF = new Floor("floor", "A sandstone tiled floor.");
        Furniture sha2Dr = new Sha2_Dr("door");
        Furniture sha1Trch = new Trch("torch", hndTrch, me.getINV());
        Furniture sha2Trch = new Trch("torch", hndTrch, me.getINV());
        Furniture sha1Dr = new Sha1_Dr("door", sha1, ram, brRam, me.getINV());
        // </editor-fold>
        // <editor-fold desc="INITIALIZE SCORCHED ROOM">
        //-----------------------------THE ROOM---------------------------------
        Room sear = new Sear("in a scorched room", "SEAR");
        //-------------------------------ITEMS----------------------------------
        Item wrhmmr = new Item("warhammer", "It's an old medieval warhammer. The head looks\n"
                                          + "extremely worn and dull.");
        Item brWrHmr = new Item("broken warhammer", "It's snapped in half. Warhammers: not\nmeant for walls.", "Well, it's useless now.");
        Item ash = new Item("ash", "I'm sure there's people mixed in with this...");
        Item wd = new Item("charred wood", "It's a piece of burnt wood");
        //-----------------------------FURNITURE-------------------------------- 
        Furniture searFssr = new Sear_Fssr("fissure", sear, me.getINV(), brWrHmr);
        Furniture searDr = new Sear_Dr("door");
        Furniture searAsh = new Sear_Ash("ash");
        Furniture searWood = new Sear_Ash("wood");
        Furniture searSkltn = new Sear_Skltn("skeleton", closCrwbr);
        Furniture searLddr = new Gqua_Lddr("ladder", me, 'u', 1);
        Furniture searW = new Wall("wall", "It's a plain cobblestone wall.");
        Furniture searF = new Floor("floor", "It's a cold, hard, cobblestone floor", ash, wd, ash, wrhmmr, wd, ash);
        // </editor-fold>
        // <editor-fold desc="INITIALIZE STUDY">
        //-----------------------------THE ROOM---------------------------------
        Room stud = new Stud("in the study", "STUD");
        //-------------------------------ITEMS----------------------------------
        Item studBkPhy = new Stud_BookPhy("glowing book, \"A Young Mind's Guide to Lichery\"");
        Item studBkPi = new Stud_PiBk("book, \"An Essential Pi\"");
        Item studNote = new Stud_Note("personal note");
        Item pen = new Item("pen", "It's a fancy ballpoint pen", "If only you had your diary with you\nto write down your feelings.");
        Item ppr = new Item("parchment", "Some old brown parchment", "You don't feel the need to write anything down.");
        //-----------------------------FURNITURE-------------------------------- 
        Furniture studSafe = new Stud_Safe("safe", "367", studBkPhy, gal1Key);
        Furniture studF = new Floor("floor", "The floors are a weathered dark hickory. How nice!");
        Furniture studPrtrt = new Stud_Prtrt("portrait", studSafe);
        Furniture studFire = new Stud_Fire("fireplace", true, bckt, me.getINV());
        Furniture studDsk = new Stud_Dsk("desk", pen, pen, ppr, servKey, studNote);
        Furniture studBkCs = new Stud_BkCs("bookcase", studBkPi);
        Furniture studCch = new Stud_Cch("couch");
        Furniture studCrpt = new Stud_Crpt("carpet");
        // </editor-fold>

        // </editor-fold>
        //---------------------------------------------------------------------- 
        // <editor-fold desc="AREA 3: EAST WING">

        // <editor-fold desc="INITIALIZE TROPHY ROOM">
        //-----------------------------THE ROOM---------------------------------
        Room gal5 = new Gal5("in Erik's trophy room", "GAL5");
        //-------------------------------ITEMS----------------------------------
        Item emrld = new Item("glowing emerald", "The emerald pulses with a blue glow.", "This belongs to somebody important.");
        Item aqmrn = new Item("aquamarine", "The emerald pulses with a blue glow.", "This belongs to somebody important.");
        Item rby1 = new Item("ruby", "The ruby is well cut and clean, having been protected in the case for so long.");
        //-----------------------------FURNITURE--------------------------------
        Furniture gal5Dsply = new Gal5_Dsply("display", rby1, emrld, aqmrn);
        Furniture gal5Chndlr = new Gal5_Chndlr("chandelier");
        Furniture gal5Cbwbs = new Gal5_Cbwbs("cobwebs");
        Furniture gal5Clng = new Gal5_Clng("ceiling");
        Furniture gal5F = new Floor("floor", "The floor is a black and white checkered tile.");
        Furniture gal5W = new Wall("wall", "The walls are just plain granite brick.");
        // </editor-fold>
        // <editor-fold desc="INITIALIZE GALLERY">
        //-----------------------------THE ROOM---------------------------------    
        Room gal1 = new Gal_1W("in the first floor gallery", "GAL1");
        Room gal2 = new Gal_1E("in the gallery central chamber", "GAL2");      
        Room gal3 = new Gal_2W("in the second floor gallery", "GAL3");
        Room gal4 = new Gal_2E("on the second floor gallery balcony", "GAL4");
        Room gal6 = new Gal_3W("in the gallery loft", "GAL6");
        Room gal7 = new Room("in the gallery loft", "GAL7");
        //-------------------------------ITEMS----------------------------------
        Item blFcs = new Focus("blue focus", "It's a cool brass ring holding a blue lens.");
        Item yllwFcs = new Focus("yellow focus", "It's a cool brass ring holding a yellow lens.");
        Item drkFcs = new Focus("dark focus", "It's a cool brass ring holding a tinted lens.");
        Item fnnyOrb = new Item("crystal orb", "It's extremely clean, and it contains a peculiar\n"
                                             + "gas, the color of which you cannot quite describe.");
        Item bxThngy = new Item("box thingy", "This small black metal box has some surprising weight\n"
                                            + "to it. It's a bit to big to fix in your palm. A small\n"
                                            + "red light is on top and shiny metal strips are attached\n"
                                            + "to each side.");
        Item gal1Ktn = new Item("katana", "This looks expensive and dangerous! Of course,\n"
                                        + "you do know your way around sharp tools.");
        Item gal3Inst = new Gal3_Inst("kora");
        //-----------------------------FURNITURE--------------------------------         
        Furniture gal7Stat = new Gal_3E_Stat("statue", gal5, gal7);
        Furniture gal4Stat = new Gal_2E_Stat("statue", gal7, gal4, gal7Stat);
        Furniture gal2Stat = new Gal_1E_Stat("statue", gal4, me.getINV(), gal4Stat);

        Furniture gal1Drgn = new Gal1_Drgn("dragon", gal2Stat, me.getINV(), yllwFcs);
        Furniture gal1KtnFurn = new Gal1_KtnFurn("katana", me.getINV(), gal1Ktn);
        Furniture gal1Swtch = new Gal1_Swtch("lever", gal1Drgn);
        Furniture gal1Bttn = new Gal1_Bttn("button", gal1Drgn);
        Furniture gal1Lghts = new Gal1_Lghts("lights");
        Furniture gal1Scr = new Gal1_Scr("chinese scroll", gal1Bttn);
        Furniture gal1Scrn = new Gal1_Scrn("screen", gal1Swtch);
        Furniture gal1Armr = new Gal1_Armr("armor");
        Furniture gal1F = new Floor("floor", "The floor is a dark hardwood.");
        Furniture gal1W = new Wall("wall", "The wall is tiled a dark green and purple.\nInteresting choice...");
        Furniture gal1Sclptrs = new Gal1_Sclptrs("sculptures");
        Furniture gal1Pntngs = new Gal1_Pntngs("paintings");
        Furniture gal1Pntng3 = new Gal1_Pntng3("korean painting");
        Furniture gal1Pntng2 = new Gal1_Pntng2("tibetan painting");
        Furniture gal1Pntng = new Gal1_Pntng("indian painting");
        Furniture gal1Hrth = new Gal1_Hrth("hearth", true, bckt, me.getINV());

        Furniture gal3Ttm = new Gal3_Ttm("totem", gal4Stat, me.getINV());
        Furniture gal3Peg = new Gal3_Peg("peg", gal3Ttm);
        Furniture gal3Sgmnt = new Gal3_Sgmnt("segments", gal3Ttm);
        Furniture gal3Lddr = new Gal3_Lddr("ladder", me, 'u', 1);
        Furniture gal3Rp = new Gal3_Rp("rope", me, gal3Lddr);
        Furniture gal3Swtch = new Gal3_Swtch("switch");
        Furniture gal3InstFurn = new Gal3_InstFurn("instrument", me.getINV(), gal3Inst);
        Furniture gal3Msk = new Gal3_Msk("gabonese mask");
        Furniture gal3Msk2 = new Gal3_Msk2("malian mask");
        Furniture gal3Msk3 = new Gal3_Msk3("burkinabe mask");
        Furniture gal3Msks = new Gal3_Msks("masks");
        Furniture gal3Hrth = new Gal3_Hrth("hearth", true, bckt, me.getINV());
        Furniture gal3F = new Floor("floor", "The floor is a dark hardwood.");
        Furniture gal3W = new Wall("wall", "The wall a yellow plaster, giving it a warm appearance.");
        Furniture gal3Art = new Gal3_Art("zambian statuette");
        Furniture gal3Art2 = new Gal3_Art2("deformed statue");
        Furniture gal3Art3 = new Gal3_Art3("nigerian trinket");
        Furniture gal3Arts = new Gal3_Arts("masks");
        Furniture gal3Htch = new Gal3_Htch("hatch");
        Furniture gal3Hl = new Gal3_Hl("hole");

        Furniture galDm = new Gal_Dm("dome");
        Furniture gal2Clmns = new Gal2_Clmns("columns");
        Furniture galBalc = new Gal_Balc("balcony");
        Furniture gal2F = new Floor("floor", "This room's floor is magnificent. It's solid marble\nand resembles a compass.");
        Furniture gal2W = new Wall("wall", "The wall here is of an ornate white-paneled wood.");
        Furniture gal4Dr = new Gal4_Dr("doors");
        Furniture gal4Lft = new Gal4_Lft("loft");
        Furniture gal2Strcs = new Gal2_Strcs("stairs", me, 'u', 1);
        Furniture gal4Strcs = new Gal2_Strcs("stairs", me, 'd', 1);

        Furniture gal6Htch = new Gal6_Htch("hatch");
        Furniture gal6Cnn = new Gal6_Cnn("cannon", gal7Stat, me.getINV());
        Furniture gal6Swtch = new Gal6_Swtch("switch", gal6Cnn);
        Furniture gal6Lddr = new Gal6_Lddr("ladder", me, 'd', 1);
        Furniture gal6Hlmt = new Gal6_Hlmt("helmet");
        Furniture gal6Mchn = new Gal6_Mchn("machine");
        Furniture gal6Bttn = new Gal6_Bttn("button", me);
        Furniture gal6App = new Gal6_App("apparatus", bxThngy);
        Furniture gal6F = new Floor("floor", "The floor is a dark hardwood.");
        Furniture gal6W = new Wall("wall", "The wall a classy mahogany panel.");
        Furniture gal6Tech = new Gal6_Tech("technology");
        Furniture gal6Elec = new Gal6_Tech("electronics");
        Furniture gal6Tbl = new Gal6_Tbl("table");
        // </editor-fold>
        // <editor-fold desc="INITIALIZE DINING ROOM">
        //-----------------------------THE ROOM---------------------------------
        Room din1 = new Din1("in the dining room", "DIN1", me);  
        Room din2 = new Din2("on the dining room balcony", "DIN2");
        //-------------------------------ITEMS----------------------------------
        Item frk = new Item("fork", "It's a nice silver fork.", "You comb your beard with the fork until it's straight and tidy.");
        Item plt = new Item("plate", "It's fancy ceramic plate.");
        Item spn = new Item("spoon", "It's a nice silver spoon.");
        Item npkn = new Item("napkin", "A white cloth napkin.", "You wipe the sweat off your forehead. Carrying all\nthese items has taken its toll on you.");
        //-----------------------------FURNITURE--------------------------------  
        Furniture din1Clmns = new Din1_Clmns("columns");
        Furniture din1Blcny = new Din1_Blcny("balcony");
        Furniture din1Wndw = new Din1_Wndw("window");
        Furniture din1Chrs = new Din1_Chrs("chairs");
        Furniture din1Tbl = new Din1_Tbl("table", frk, spn, plt, npkn, frk, spn, plt, npkn);
        Furniture din1Chndlr = new Din1_Chndlr("chandelier");
        Furniture din1Mnlght = new Din1_Mnlght("moonlight");
        Furniture din1Tpstry = new Din1_Tpstry("tapestry");
        Furniture din1Strs = new Din1_Strs("stairs", me, 'u', 1);
        Furniture din1Crpt = new Din1_Crpt("carpet");
        Furniture din1F = new Floor("floor", "The floor is a light gray stone. A large rectangular\n"
                                  + "lavender carpet covers much of it.");
        Furniture din1W = new Wall("wall", "The walls of this room are a gray stone\nwith dark wood paneling at the bottom.");
        Furniture din1Dr = new Din1_Dr("door");

        Furniture din2F = new Floor("floor", "The floor is a light gray stone.");
        Furniture din2W = new Wall("wall", "The walls up here are a gray stone.");
        Furniture din2Pntng = new Din2_Pntng("painting");
        Furniture din2Strs = new Din1_Strs("stairs", me, 'd', 1);
        // </editor-fold>
        // <editor-fold desc="INITIALIZE MARBLE HALL">
        //-----------------------------THE ROOM---------------------------------
        Room mha1 = new Mha1("in the north marble hall", "MHA1", me);
        Room mha2 = new Mha2("in the marble hall", "MHA2");
        Room mha3 = new Mha3("in the south marble hall", "MHA3");
        //-------------------------------ITEMS----------------------------------       
        Item angMed = new Item("angel medallion", "It's a beautiful gold disk about four or five inches\n"
                                                + "across. On its surface is an embossment of an angel.");
        Item horMed = new Item("horse medallion", "It's a silver disk about four or five inches across.\n"
                                                + "On its surface is an embossment of a galloping horse.");
        //-----------------------------FURNITURE--------------------------------  
        Furniture mhaChndlr = new Mha_Chndlr("chandelier");
        Furniture mhaF = new Floor("floor", "The floor is green tiled marble. Expensive!");
        Furniture mhaW = new Wall("wall", "The walls are plain white granite. All that\ndecorate them are the tall windows.");
        Furniture mhaNWndw1 = new MhaN_Wndw("window");
        Furniture mhaNWndw2 = new MhaN_Wndw("window");
        Furniture mhaSWndw = new MhaS_Wndw("window");
        Furniture mhaNDr = new MhaN_Dr("door");
        Furniture mhaSDr = new MhaS_Dr("door");
        Furniture mhaMDr = new MhaM_Dr("doors", din1, me.getINV());
        Furniture mhaPlnt = new Mha_Plnt("plant");
        Furniture mhaChr = new Mha_Chr("chair");
        Furniture mhaRStat = new Mha_RStat("right statue", me.getINV(), angMed);
        Furniture mhaLStat = new Mha_LStat("left statue");
        Furniture mhaStats = new Mha_Stats("statues", mhaRStat);
        // </editor-fold>
        // <editor-fold desc="INITIALIZE WORKSHOP">
        //-----------------------------THE ROOM---------------------------------
        Room eow3 = new Eow3("in the workshop", "EOW3");
        //-------------------------------ITEMS----------------------------------
        Item redLns = new Item("red lens", "It's a proper lens tinted red.\n"
                             + "Maybe you should pick up the glass trade!", redFcs, "red focus", 3);
        Item blLns = new Item("blue lens", "You made a blue lens. Good job, but was this the right color?",
                                               "Wait... was this the color you were supposed to make?");
        Item yllwLns = new Item("yellow lens", "You made a yellow lens. Good job, but was this the right color?", 
                                                   "Wait... was this the color you were supposed to make?");
        Item rdDy = new Item("red dye", "You have a handful of soft red powdered dye.");
        Item blDy = new Item("blue dye", "You have a handful of soft blue powdered dye.");
        Item yllwDy = new Item("yellow dye", "You have a handful of soft yellow powdered dye.");
        Item mltnGlssR = new Item("molten red glass", "It's a crucible of molten red glass. Be careful!");
        Item mltnGlssB = new Item("molten blue glass", "It's a crucible of molten blue glass. Be careful!");
        Item mltnGlssY = new Item("molten yellow glass", "It's a crucible of molten yellow glass. Be careful!");
        Item glssSht = new Item("glass sheet", "Wait... this isn't right. Weren't you supposed to make a lens?");
        Item stncl = new Item("lens template", "It's a sheet of metal with a small hole cut in it.\n");
        Item wrkNt = new Wrk_Nt("momento- glass");
        Item ptsh = new Item("potash", "Good old potassium-rich potash salts!");
        //-----------------------------FURNITURE--------------------------------
        Furniture wrkF = new Floor("floor", "A sandstone tiled floor.");
        Furniture wrkBrl = new Wrk_Brl("barrel", rdDy, rdDy, blDy, blDy, yllwDy, yllwDy);
        Furniture wrkCbnt = new Wrk_Cbnt("cabinet", hmmr, gl, ptsh, ptsh);
        Furniture wrkCstTbl = new Wrk_CstngTbl("casting table", wrkBrl.getInv(), closScks.getInv(), me.getINV(), glssSht,
                                                redLns, blLns, yllwLns, snd, rdDy, blDy, yllwDy, ptsh, wrkCbnt.getInv());
        Furniture wrkKln = new Wrk_Kln("kiln", me.getINV(), mltnGlssR, mltnGlssY, mltnGlssB);
        Furniture wrkBnch = new Gqua_Wrkbnch("workbench", stncl, wrkNt);        
        Furniture wrkAnvl = new Wrk_Anvl("anvil");
        Furniture wrkFrg = new Wrk_Frg("forge");
        // </editor-fold>
        // <editor-fold desc="INITIALIZE EAST OUTER WALL">
        //-----------------------------THE ROOM---------------------------------
        Room eow1 = new Eow1("in the east outer wall", "EOW1");
        Room eow2 = new Eow2("in the east outer wall", "EOW2");
        Room eow4 = new Eow4("on the east outer wall balcony", "EOW4");
        //-------------------------------ITEMS----------------------------------
        Item wtrBckt = new Item("bucket of water", "It's a metal bucket filled with water.");
        Item eowSwrd1 = new Item("silver sword", "The sword is finely polished and sharp.\nOrnamental probably.");
        Item eowSwrd2 = new Item("rusty sword", "The sword is rusty and a little dull, but still\nsomewhat effective.");
        Item eowSwrd3 = new Item("broken sword", "This sword is broken halfway down the blade.\nThis is a mark of poor craftsmanship.");
        Item eowSSpr = new Item("silver spear", "This is beautiful! It's solid metal with a silvery shine.");
        Item woodSpr = new Item("wooden spear", "This looks like a plain wooden spear. A bit primitive looking.");
        Item eowPlArm = new Item("polearm", "This is a typical polearm.");
        Item eowAx = new Item("war axe", "This is your kind of tool! You could probably wield this."); 
        Item eowBtlAx = new Item("battle axe", "This like a hand axe, but longer. You don't care for it.");
        //-----------------------------FURNITURE--------------------------------
        Furniture eowF = new Floor("floor", "It's a sandstone tile floor.");

        Furniture eow1Dr = new Eow1_Dr("door");
        Furniture eow1Rck = new Eow1_Rck("rack", eowSwrd1, eowBtlAx, eowSwrd2, eowSwrd3, eowSwrd2, eowAx);
        Furniture eow1Bskt = new Eow1_Bskt("basket", eowPlArm, woodSpr, woodSpr, eowPlArm);
        Furniture eow1Trch = new Trch("torches", hndTrch, me.getINV());

        Furniture eow2Fntn = new Eow2_Fntn("fountain");
        Furniture eow2Wtr = new Water("water", me.getINV(), wtrBckt);
        Furniture eow2Rck = new Eow1_Rck("rack", eowSwrd1, eowSwrd2, eowSSpr, woodSpr, eowBtlAx);
        Furniture eow2Strs = new Eow2_Strs("stairs", me, 'u', 1);
        Furniture eow2Blcny = new Eow2_Blcny("balcony");
        Furniture eow2Cbnt = new Eow2_Cbnt("cabinet", bckt, shaMp);
        Furniture eow2Trch = new Trch("torches", hndTrch, me.getINV());

        Furniture eow4F = new Floor("floor", "It's a sandstone tile floor.");
        Furniture eow4Strs = new Eow2_Strs("stairs", me, 'd', 1);
        // </editor-fold>
        // <editor-fold desc="INITIALIZE LIBRARY">
        Furniture lib4Tbl = new Lib4_Tbl("table", fnnyOrb);
        //-----------------------------THE ROOM---------------------------------
        Room lib2 = new Lib2("in the north library", "LIB2");
        Room lib3 = new Lib3("in the south library", "LIB3");
        Room lib4 = new Lib4("in the upper library north", "LIB4", lib4Tbl);
        Room lib5 = new Lib5("in the upper library south", "LIB5");
        //-------------------------------ITEMS----------------------------------
        Item shs1 = new Lib_Shoes("leather shoes", "A fancy pair of shiny leather shoes.", 
                                  "You put on the shoes. They're a little big, but\ncomfortable!");
        Item shs2 = new Lib_Shoes("worn shoes", "A worn, dull pair of leather shoes.",
                                  "You put on the shoes. These aren't too comfortable.");
        Item shs3 = new Lib_Shoes("night slippers", "A brown pair of cotton night slippers.",
                                  "You wear the slippers. You could wear these all day!");
        Item shs4 = new Lib_Shoes("work boots", "A rugged pair of boots.",
                                  "You put on the boots. You feel like you're at work.");
        Item fin = new Lib_BkFin("book, 'The Essential Finnish'");
        Item bbl = new Lib_Bbl("biblical tome, 'The Book of Genesis'");
        Item ody = new Lib_Ody("epic tome, 'The Odyssey'");
        Item ili = new Lib_Ill("greek tome, 'The Iliad'");
        Item inf = new Lib_Inf("infernal tome, 'Dante's Inferno");
        Item par = new Lib_Par("divine tome, 'Paradise Lost'");
        Item glss = new Lib_BkGlss("guide, 'The Master Glasser'");
        //-----------------------------FURNITURE--------------------------------
        Furniture libLF = new Floor("floor", "The floor is a rough, dark blue stone.");
        Furniture libUF = new Floor("floor", "The floor is a rough, dark blue stone.");
        Furniture libW = new Wall("wall", "A classy mahogany paneled wall. Mahogany, having\nthe highest IQ of any wood");
        Furniture libCch = new Lib_Cch("couch");
        Furniture libBkShlf = new Lib_BkShlf("bookshelf");
        Furniture libScncs = new Lib_Scncs("sconces");

        Furniture lib3Stat = new Lib3_Stat("statue", horMed);

        Furniture lib2ShRck = new Lib2_ShRck("rack", shs3, shs2, shs1, shs4);
        Furniture lib2Stat = new Lib2_Stat("statue");
        Furniture lib2Frplc = new Lib2_Frplc("fireplace", true, bckt, me.getINV());
        Furniture lib2Bttn = new Lib2_Bttn("button", lib2Frplc, lib3Stat);
        Furniture lib2WrFr = new Lib2_WrFr("warfare", inf, fin);
        Furniture lib2Wndw = new Lib2_Wndw("window");

        Furniture lib3Pllr = new Lib_Pllr("pillar");
        Furniture lib3Strs = new Lib3_Strs("stairs", me, shs1);
        Furniture lib3Crtn = new Lib3_Crtn("creation", ody);
        Furniture lib3Blcny = new Lib_Blcny("balcony");
        Furniture lib3Wndw = new Lib3_Wndw("window");

        Furniture lib4Frplc = new Lib2_Frplc("fireplace", true, bckt, me.getINV());
        Furniture lib4Bttn = new Lib4_Bttn("button", lib4Frplc, lib3Stat);
        Furniture lib4Prdtn = new Lib4_Prdtn("perdition", ili, glss);
        Furniture lib4Glb = new Lib4_Glb("globe");
        Furniture lib4Stat = new Lib4_Stat("statue");
        Furniture lib4Strs = new Lib4_Strs("stairs", me, shs1);

        Furniture lib5Bnshmnt = new Lib5_Bnshmnt("banishment", bbl);
        Furniture lib5Cndlbr = new Lib5_Cndlbr("candelabra");

        Furniture lib2Vyg = new Lib2_Vyg("voyage", lib2WrFr, lib3Crtn, lib4Prdtn, lib5Bnshmnt, par);
        // </editor-fold>
        // <editor-fold desc="INITIALIZE SECRET ARCHIVES">
        //-----------------------------THE ROOM---------------------------------
        Room lib1 = new Lib1("in Erik's secret archives", "LIB1");
        //-------------------------------ITEMS----------------------------------
        Item lib1Schmtc = new Lib1_Schmtc("schematic");
        Item lib1Nt2 = new Lib1_Nt2("Journal page 1");
        Item lib1Nt3 = new Lib1_Nt3("Journal page 2");
        Item lib1Nt4 = new Lib1_Nt4("Journal page 3");
        Item lib1Nt5 = new Lib1_Nt5("Journal page 4");
        Item lib1Nt6 = new Lib1_Nt6("Journal page 5");
        Item lib1ImpNt = new Lib1_ImpNt("momento- lens");
        Item lib1Pln = new Lib1_Pln("vessel schematic");
        Item brkLns = new Item("cracked lens", "The red-tinted lens is cracked all the way through.", "You think this has lost its purpose by now.");
        Item brssRng = new Item("brass ring", "It's an unhinged shiny brass ring. Looks like a screw is missing.", redFcs, "red focus", 3);
        //-----------------------------FURNITURE--------------------------------
        Furniture lib1Docs = new Lib1_Docs("documents");
        Furniture lib1F = new Floor("floor", "It's a dusty wood parquet floor.", lib1Nt2);
        Furniture lib1W = new Wall("wall", "The walls are just horizontal wood slats.\n");
        Furniture lib1Art = new Lib1_Art("artifact", me.getINV(), blFcs);
        Furniture lib1Dsk = new Lib1_Dsk("desk", lib1Art, lib1Schmtc, lib1Nt3, lib1ImpNt);
        Furniture lib1Rg = new Lib1_Rg("rug");
        Furniture lib1Rck = new Lib1_Rck("rack",  lib1Nt4, lib1Nt6, lib1Nt5);
        Furniture lib1Tbl = new Lib1_Tbl("table", lib1Pln);
        Furniture lib1Lght = new Lib1_Lght("light");
        Furniture lib1Mrrr = new Lib1_Mrrr("mirror");
        Furniture lib1Wndw = new Lib1_Wndw("window");
        Furniture lib1Sf = new Lib1_Sf("safe", "712", eow3Key, brkLns, brssRng);
        // </editor-fold>
        // <editor-fold desc="INITIALIZE DRAWING ROOM">
        //-----------------------------THE ROOM---------------------------------
        Room drar = new Drar("in the drawing room", "DRAR", me);
        //-------------------------------ITEMS----------------------------------
        Item rk = new Item("rook", "the small figure resembles a brick tower", "You have no idea how to play chess.");
        Item knght = new Item("knight", "the small figure resembles a horse", "You have no idea how to play chess.");
        Item bshp = new Item("bishop", "the small figure resembles... well... a bishop", "You have no idea how to play chess.");
        Item qn = new Item("queen", "the small figure resembles... well... a queen", "Isn't this the strongest piece? Huh...");
        Item kng = new Item("king", "the small figure resembles... well... a king", "You have no idea how to play that.");
        Item pwn = new Item("pawn", "the small figure resembles a brick tower", "This is the weakest piece right? Hmph.\nBetter not ask a chess player that.");
        Item rdBl = new Item("red ball", "It's just a plain, heavy red ball. How\nin the world do you play with this?", "This is nonsense. Where are the numbers?");
        Item cBl = new Item("cue ball", "It's a plain white ball. This is a cue ball, right?", "You'd rather break a window with this and jump out\rather than play this witchcraft.");
        //-----------------------------FURNITURE--------------------------------
        Furniture drarGhst = new Drar_Ghst("apparition", me, drkFcs, kitcKey, emrld);
        Furniture drarF = new Floor("floor", "This room's floor is carpeted lavender with an intricate design.");
        Furniture drarW = new Wall("wall", "This is the first time you've seen wallpaper.\nIt's striped vertical in purple and lavender.");
        Furniture drarWndw = new Lib3_Wndw("window");
        Furniture drarBr = new Drar_Br("bar", drarGhst);
        Furniture drarBllrds = new Drar_Bllrds("billiard table", drarGhst, rdBl, cBl, cBl);
        Furniture drarChss = new Drar_Chss("chess table", drarGhst, rk, knght, bshp, qn, kng, bshp, knght, rk, pwn, pwn, pwn, pwn, pwn, pwn, pwn, pwn);
        Furniture drarCch = new Drar_Cch("couch", drarGhst);
        Furniture drarTbl = new Drar_Tbl("table", drarGhst);
        // </editor-fold>
        // <editor-fold desc="INITIALIZE KITCHEN"> 
        //-----------------------------THE ROOM---------------------------------
        Room kitc = new Kitc("in the kitchen", "KITC");
        //-------------------------------ITEMS----------------------------------
        Item kitcFrtPhy = new Kitc_FrtPhy("pristine fruit");
        Item rtnFrt = new Item("rotten fruit", "Was this an apple? Or ... plum once?", "Whatever you expect him to do with that,\nhe isn't going to.");
        Item rtnFrt2 = new Item("rotten fruit", "Was this an apple? Or ... plum once?", "Whatever you expect him to do with that,\nhe isn't going to.");
        Item petFrt = new Item("petrified vegetable", "Looks like a rock ... in the shape of a carrot.", "Whatever you expect him to do with that,\nhe isn't going to.");
        //-----------------------------FURNITURE--------------------------------
        Furniture kitcTrch = new Kitc_Trch("holder", hndTrch, me.getINV(), kitc);
        Furniture kitcF = new Floor("floor", "The floor is dirty brown stone,\ncomposed of differently sized bricks.");
        Furniture kitcW = new Wall("wall", "The wall is made of large, differently sized bricks.");
        Furniture kitcWndw = new Kitc_Wndw("window");
        Furniture kitcDr = new Kitc_Dr("door");
        Furniture kitcRck = new Kitc_Rck("rack", drwKey, par2Key, dngnKey);
        Furniture kitcPts = new Kitc_Pts("pots");
        Furniture kitcHrth = new Kitc_Hrth("hearth", me.getINV(), bckt); //UNFINISHED
        Furniture kitcBrls = new Kitc_Brls("barrels"); // EMPTY
        Furniture kitcPntry = new Kitc_Pntry("pantry", rtnFrt, rtnFrt, petFrt, kitcFrtPhy, petFrt, rtnFrt2);
        Furniture kitcShlf = new Kitc_Shlf("shelf"); // EMPTY
        Furniture kitcCntr = new Kitc_Shlf("counter"); // EMPTY     
        // </editor-fold> // HAS EMPTY STUFF
        // <editor-fold desc="INITIALIZE DUNGEON STAIRCASE">
        //-----------------------------THE ROOM---------------------------------
        Room dst1 = new Dst1("in an eerie chamber", "DST1");
        //-----------------------------FURNITURE--------------------------------
        Furniture dst1Strs = new Dst1_Strs("stairs", me, 'd', 1);
        Furniture dstW = new Wall("wall", "The walls in here are a mossy\ncobblestone.");
        Furniture dstF = new Floor("floor", "The stone floor is mossy and dank.");
        Furniture dst1Lntrn = new Dst1_Lntrn("lantern");
        // </editor-fold>

        // </editor-fold>
        //---------------------------------------------------------------------- 
        // <editor-fold desc="AREA 4: CASTLE REAR">
        
        Item hlyWtr = new Item("holy water", "Clear, salty, and boiled like hell.");
        
        // <editor-fold desc="INITIALIZE SECOND FLOOR LANDING"> 
        //-----------------------------THE ROOM---------------------------------
        Room foy3 = new Foy3("on the second floor landing", "FOY3");
        //-------------------------------ITEMS----------------------------------        
        //-----------------------------FURNITURE--------------------------------  
        Furniture foy3Strs = new Foy3_Strcs("staircase", me, 'u', 1);
        
        // </editor-fold>
        // <editor-fold desc="INITIALIZE OBSERVATORY"> 
        //-----------------------------THE ROOM---------------------------------
        Room obs1 = new Room("in the observatory", "OBS1");
        Room obs2 = new Room("on the observatory second floor", "OBS2");
        Room obs3 = new Room("on the observatory third floor", "OBS3");
        //-------------------------------ITEMS----------------------------------  
        Item hlsPlt = new Obs_Plt("brass plate, \"Sol\"", "The small plate bears an engraving: \"Sol\"");
        Item hrmsPlt = new Obs_Plt("brass plate, \"Mercury\"", "The small plate bears an engraving: \"Mercury\"");
        Item gaeaPlt = new Obs_Plt("brass plate, \"Terra\"", "The small plate bears an engraving: \"Terra\"");
        Item aphrdtPlt = new Obs_Plt("brass plate, \"Venus\"", "The small plate bears an engraving: \"Venus\"");
        Item aresPlt = new Obs_Plt("brass plate, \"Mars\"", "The small plate bears an engraving: \"Mars\"");
        Item krnsPlt = new Obs_Plt("brass plate, \"Saturn\"", "The small plate bears an engraving: \"Saturn\"");
        Item zsPlt = new Obs_Plt("brass plate, \"Jupiter\"", "The small plate bears an engraving: \"Jupiter\"");
        Item urnsPlt = new Obs_Plt("brass plate, \"Caelus\"", "The small plate bears an engraving: \"Caelus\"");
        Item psdnPlt = new Obs_Plt("brass plate, \"Neptune\"", "The small plate bears an engraving: \"Neptune\"");
        
        Item rby2 = new Item("ruby", "The ruby is well cut and clean, having been protected in the case for so long.");
        Item cndl = new Item("candle", "It's a white candle. It looks new!");
        //-----------------------------FURNITURE--------------------------------
            Furniture obs3Chndlr = new Obs3_Chndlr("chandelier", cndl, cndl, cndl, rby2, cndl, cndl);
        
            Furniture obsHls = new Obs_Stat("8", "The statue depicts a monumental male figure\ncrowned with a radiating halo. He rides in\na chariot pulled by four steeds.", 0);
            Furniture obsHrms = new Obs_Stat("5", "On its base stands a male figure of average\nbuild. He wears sandals, a heavy cloak, and\na winged helmet.", 6);
            Furniture obsGaea = new Obs_Stat("1", "The statue depicts a short-haired female\nfigure holding a newborn. She also appears \npregnant.", 2);
            Furniture obsAphrdt = new Obs_Stat("0", "A beautiful woman stands on this base. She\nstands with long hair and no clothing on \na large sea-shell.", 3);
            Furniture obsAres = new Obs_Stat("4", "It shows a tall male figure dressed in \nsoldier's garb. He wears a tall galea\nhelmet and holds a spear and shield.", 5);
            Furniture obsKrns = new Obs_Stat("3", "This statue shows a glorious bearded male\nsitting. He is well-built and dressed in a\nheavy robe. He holds a scythe.", 4);
            Furniture obsZs = new Obs_Stat("7", "This statue depicts a glorious bearded male\nstriding forward holding a thunderbolt. You\ncannot contain your tears.", 8);
            Furniture obsUrns = new Obs_Stat("6", "A male wearing light armor stands on this\nbase. He's clean-cut and holds a staff in\nhis left hand.", 7);
            Furniture obsPsdn = new Obs_Stat("2", "This statue shows a towering older male\nfigure. He wears a glorious beard and poses\ntriumphantly holding a trident.", 1);
            Furniture obsStats = new Obs_Stats("statues", me, obs3Chndlr, obsAphrdt, obsGaea, obsPsdn,  obsKrns, obsAres, obsHrms, obsUrns, obsZs, obsHls);

            Furniture hlsSlt = new Obs_Slt("I", "Sol", "Inside the slot: \"Helios\"");
            Furniture hrmsSlt = new Obs_Slt("A", "Mercury", "Inside the slot: \"Hermes\"");
            Furniture gaeaSlt = new Obs_Slt("C", "Terra", "Inside the slot: \"Gaea\"");
            Furniture aphrdtSlt = new Obs_Slt("B", "Venus", "Inside the slot: \"Aphrodite\"");
            Furniture aresSlt = new Obs_Slt("D", "Mars", "Inside the slot: \"Ares\"");
            Furniture krnsSlt = new Obs_Slt("F", "Saturn", "Inside the slot: \"Kronos\"");
            Furniture zsSlt = new Obs_Slt("E", "Jupiter", "Inside the slot: \"Zeus\"");
            Furniture urnsSlt = new Obs_Slt("G", "Caelus", "Inside the slot: \"Uranus\"");
            Furniture psdnSlt = new Obs_Slt("H", "Neptune", "Inside the slot: \"Posiedon\"");
            Furniture obsSlts = new Obs_Slts("slots", me, hlsPlt, obsStats, hlsSlt, hrmsSlt, aphrdtSlt, gaeaSlt, aresSlt, zsSlt, krnsSlt, urnsSlt, psdnSlt, hlsSlt);

        // </editor-fold>
        // <editor-fold desc="INITIALIZE JADE HALL"> 
        //-----------------------------THE ROOM---------------------------------
        Room jha1 = new Room("jade hall", "JHA1");
        Room jha2 = new Room("jade hall", "JHA2");
        //-------------------------------ITEMS----------------------------------   
        
        //-----------------------------FURNITURE--------------------------------  
        
        
        // </editor-fold>
        // <editor-fold desc="INITIALIZE GARDENS"> 
        //-----------------------------THE ROOM---------------------------------
        Room gar1 = new Room("gardens", "GAR1");
        Room gar2 = new Room("gardens", "GAR2");
        Room gar3 = new Room("gardens", "GAR3");
        Room gar4 = new Room("gardens", "GAR4");   
        //-------------------------------ITEMS----------------------------------
        Item mndrk = new Item("mandrake root", "The potato-shaped vegetable looks disturbingly life-like.");
        Item sl = new Item("soil", "The soft, dark pile of dirt still looks quite fertile");
        //-----------------------------FURNITURE--------------------------------  
        
        // </editor-fold>
        // <editor-fold desc="INITIALIZE PARLOR"> 
        //-----------------------------THE ROOM---------------------------------
        Room par2 = new Par2("on the parlor loft", "PAR2", me, foy3);
        Room par1 = new Par1("in the first floor parlor", "PAR1"); 
        //-------------------------------ITEMS----------------------------------   
        Item bttl = new Item("glass bottle", "It's a regular clear glass bottle.");
        Item scrdFr = new Item("sacred fire", "The fire burns enigmatically inside "
                             + "the bottle. To your surprise, the fire gives off no heat.");
        Item enchntdBttl = new Item("enchanted bottle", "The bottle is now coated in a " );
        Item stlWr = new Item("steel wire", "It's some broken piano wire");
        Item hndDrll = new Item("hand drill", "It's a drill for boring holes in wood.\n"
                              + "You can drill into almost anything you want now!");
        Item vlAcd = new Item("vial of acetic acid", "It's a small vial of acid. Not the kind that burns... you think.");
        Item fthr = new Item("raven's feather", "It's a long, elegant feather");
        Item athr = new Item("aether vial", "This looks expensive!");
        Item frSlts = new Item("fire salts", "Seems to be just red ashes...");
        //-----------------------------FURNITURE--------------------------------  
        Furniture parLft = new Par_Lft("loft");
        
        Furniture par1Orb = new Par1_Orb("orb");
        Furniture par1F = new Floor("floor", "A sandstone tiled floor.");
        Furniture par1FrPlc = new Par1_FrPlc("fireplace", bckt, scrdFr, me.getINV());
        Furniture par1Dr = new Par1_Dr("door", par1, enchntdBttl, me);
        Furniture par1EnchntTbl = new Par1_EnchtTbl("enchanting table", me.getINV(), enchntdBttl, frSlts, sprcExtrct, mndrk, bttl, bttl, chs1Key);
        Furniture par1Strs = new Par_Strs("stairs", me, 'u', 1);
        Furniture par1Pllrs = new Par1_Pllrs("pillars");
        Furniture par1Hrp = new Par1_Hrp("harp", par1Orb);
        Furniture par1Shlf = new Wow3_Shlf("shelf", vlAcd, fthr, hndDrll, athr, frSlts);
        Furniture par1Cshn = new Par1_Cshn("cushion");
        
        Furniture par2F = new Floor("floor", "A sandstone tiled floor.");
        Furniture par2Wndw = new Par2_Wndw("window");
        Furniture par2Strs = new Par_Strs("stairs", me, 'd', 1);
        Furniture par2Bwl = new Par2_Bwl("bowl");
        Furniture par2Frplc = new Par2_Frplc("fireplace");
        Furniture par2Pno = new Par2_Pno("piano", par1Orb, stlWr);
        Furniture par2Shlf = new Wow3_Shlf("shelf"); // Populate
        
        // </editor-fold>
        // <editor-fold desc="INITIALIZE SECRET STAIRS"> 
        //-----------------------------THE ROOM---------------------------------
        Room sst1 = new Room("secret stairwell", "SST1");
        Room sst2 = new Room("secret stairwell landing", "SST2");
        //-------------------------------ITEMS----------------------------------        
        //-----------------------------FURNITURE--------------------------------  
        
        // </editor-fold>
        // <editor-fold desc="INITIALIZE LABORATORY"> 
        //-----------------------------THE ROOM---------------------------------
        Room labo = new Room("laboratory", "LABO");
        //-------------------------------ITEMS----------------------------------        
        //-----------------------------FURNITURE--------------------------------  
        
        // </editor-fold>
        // <editor-fold desc="INITIALIZE ATTIC"> 
        //-----------------------------THE ROOM---------------------------------
        Room att1 = new Room("attic", "ATT1");       
        Room att2 = new Room("attic", "ATT2");
        //-------------------------------ITEMS----------------------------------        
        //-----------------------------FURNITURE--------------------------------  
        
        // </editor-fold>        
        // <editor-fold desc="INITIALIZE BACK HALL"> 
        //-----------------------------THE ROOM---------------------------------
        Room bha1 = new Room("back hall", "BHA1");
        Room bha2 = new Room("back hall", "BHA2");
        Room bha3 = new Room("back hall", "BHA3");
        //-------------------------------ITEMS----------------------------------        
        //-----------------------------FURNITURE--------------------------------  
        
        // </editor-fold>

        // </editor-fold>
        //---------------------------------------------------------------------- 
        // <editor-fold desc="AREA 5: SUB-LEVELS">
                
        // INITIALIZE BASEMENT ROOMS -------------------------------------------

        Room cas1 = new Room("catacombs access", "CAS1");
        Room cry2 = new Room("crypt", "CRY2");
        Room sew7 = new Room("ancient cistern", "SEW7");
        Room sew6 = new Room("ancient cistern", "SEW6");
        Room sew5 = new Room("sewers", "SEW5");
        Room pris = new Room("prison", "PRIS");
        Room torc = new Room("torture chamber", "TORC");
        Room cry1 = new Room("crypt", "CRY1");
        Room sew8 = new Room("ancient cistern", "SEW8");
        Room aarc = new Room("ancient archives", "AARC");
        Room sew4 = new Room("sewers", "SEW4");
        Room sew3 = new Room("sewers", "SEW3");
        Room sew2 = new Room("sewers", "SEW2");
        Room sew1 = new Room("sewers", "SEW1");
        Room sew9 = new Room("ancient cistern", "SEW9");
        Room oub1 = new Room("oubliette", "OUB1");
        Room intr = new Room("interrogation room", "INTR");
        Room strp = new Room("strange pool", "STRP");
        Room arch = new Room("archives", "ARCH");
        Room dst2 = new Room("dungeon stairs lower landing", "DST2");
        
        // INITIALIZE SUB-LEVEL ROOMS ------------------------------------------
        
        Room cas2 = new Room("catacombs entrance", "CAS2");
        Room oub2 = new Room("bottom of the oubliette", "OUB2");
        Room cat1 = new Room("catacombs", "CAT1");
        Room cat2 = new Room("catacombs", "CAT2");
        Room cat3 = new Room("catacombs", "CAT3");
        Room cat4 = new Room("catacombs", "CAT4");
        Room cat5 = new Room("catacombs", "CAT5");
        Room cat6 = new Room("tomb 1", "CAT6");
        Room cat7 = new Room("catacombs", "CAT7");
        Room cat9 = new Room("catacombs", "CAT9");
        Room ca10 = new Room("catacombs", "CA10");
        Room ca11 = new Room("catacombs", "CA11");
        Room ca12 = new Room("catacombs", "CA12");
        Room ca13 = new Room("catacombs", "CA13");
        Room ca14 = new Room("catacombs", "CA14");
        Room ca15 = new Room("catacombs", "CA15");
        Room ca16 = new Room("catacombs", "CA16");
        Room ca17 = new Room("catacombs", "CA17");
        Room ca18 = new Room("tomb 3", "CA18");
        Room ca19 = new Room("catacombs", "CA19");
        Room ca20 = new Room("catacombs", "CA20");
        Room ca22 = new Room("catacombs", "CA22");
        Room ca23 = new Room("catacombs", "CA23");
        Room ca24 = new Room("catacombs", "CA24");
        Room ca25 = new Room("catacombs", "CA25");
        Room ca26 = new Room("catacombs", "CA26");
        Room ca27 = new Room("catacombs", "CA27");
        Room ca28 = new Room("catacombs", "CA28");
        Room ca29 = new Room("catacombs", "CA29");
        Room ca30 = new Room("catacombs", "CA30");
        Room ca31 = new Room("catacombs", "CA31");
        Room ca32 = new Room("catacombs", "CA32");
        Room ca33 = new Room("catacombs", "CA33");
        Room ca34 = new Room("catacombs", "CA34");
        Room ca35 = new Room("catacombs", "CA35");
        Room ca36 = new Room("catacombs", "CA36");
        Room ca38 = new Room("catacombs", "CA38");
        Room ca39 = new Room("catacombs", "CA39");
        Room ca40 = new Room("catacombs", "CA40");
        Room ca41 = new Room("catacombs", "CA41");
        Room ca43 = new Room("catacombs", "CA43");
        Room ca44 = new Room("catacombs", "CA44");
        Room ca46 = new Room("tomb 2", "CA46");
        Room ca47 = new Room("catacombs", "CA47");
        Room ca48 = new Room("catacombs", "CA48");
        Room myst = new Room("mysterious chamber", "MYST");
        Room ant1 = new Room("ancient tomb", "ANT1");
        Room ant2 = new Room("ancient tomb", "ANT2");
        
        // INITIALIZE CAVE ROOMS ------------------------------------------
        
        Room cv11 = new Room("caves", "CV11");
        Room cv12 = new Room("caves", "CV12");
        Room cv13 = new Room("caves", "CV13");
        Room cv14 = new Room("caves", "CV14");
        Room cv15 = new Room("caves", "CV15");
        Room cv16 = new Room("caves", "CV16");
        Room cv17 = new Room("caves", "CV17");
        Room mys2 = new Room("caves entrance", "MYS2");
        Room cv21 = new Room("caves", "CV21");
        Room cv22 = new Room("caves", "CV22");
        Room cv23 = new Room("caves", "CV23");
        Room cv24 = new Room("caves", "CV24");
        Room cv25 = new Room("caves", "CV25");
        Room cv26 = new Room("caves", "CV26");
        Room cv27 = new Room("caves", "CV27");
        Room cv28 = new Room("caves", "CV28");
        Room cv31 = new Room("caves", "CV31");
        Room cv32 = new Room("caves", "CV32");
        Room cv33 = new Room("caves", "CV33");
        Room foun = new Room("ancient well", "FOUN");
        Room cv35 = new Room("caves", "CV35");
        Room cv36 = new Room("caves", "CV36");
        Room cv37 = new Room("caves", "CV37");
        Room cv38 = new Room("caves", "CV38");
        Room cv41 = new Room("caves", "CV41");
        Room cv42 = new Room("caves", "CV42");
        Room cv43 = new Room("caves", "CV43");
        Room cv44 = new Room("caves", "CV44");
        Room cv45 = new Room("caves", "CV45");
        Room cv46 = new Room("caves", "CV46");
        Room cv47 = new Room("caves", "CV47");
        Room cv48 = new Room("caves", "CV48");
        Room cv51 = new Room("caves", "CV51");
        Room cv52 = new Room("caves", "CV52");
        Room cv53 = new Room("caves", "CV53");
        Room cv54 = new Room("caves", "CV54");
        Room cv55 = new Room("caves", "CV55");
        Room cv56 = new Room("caves", "CV56");
        Room cv57 = new Room("caves", "CV57");
        Room cv58 = new Room("caves", "CV58");
        Room cv61 = new Room("caves", "CV61");
        Room cv62 = new Room("caves", "CV62");
        Room cv63 = new Room("caves", "CV63");
        Room cv64 = new Room("caves", "CV64");
        Room mas1 = new Room("mass grave", "MAS1");
        Room mas2 = new Room("mass grave", "MAS2");
        Room cv67 = new Room("caves", "CV67");
        Room cv68 = new Room("caves", "CV68");


        // </editor-fold>
        //---------------------------------------------------------------------- 
        // <editor-fold desc="AREA 6 VAULT">
        
        // <editor-fold desc="INITIALIZE CHAPEL STAIRS"> 
        //-----------------------------THE ROOM---------------------------------
        Room chs1 = new Chs1("in the chapel stairwell", "CHS1");  
        Room chs3 = new Chs3("on the tower's top landing", "CHS3");
        //-------------------------------ITEMS----------------------------------        
        //-----------------------------FURNITURE-------------------------------- 
        Furniture chsWndws = new Chs_Wndws("windows");
        Furniture chsW = new Wall("wall", "The white and pale orange paneled wall is decorated in gold lining.");
        
        Furniture chs1Strs = new Chs1_Strs("staircase", me, 'u', 2);
        Furniture chs1F = new Floor("carpet", "The dark red carpet covers the whole floor. It's a bit dusty from neglect.");
        Furniture chs1Stat = new Chs1_Stat("statue");
        
        Furniture chs3Strs = new Chs1_Strs("staircase", me, 'd', 2);
        Furniture chs3F = new Floor("carpet", "The dark red carpet covers the whole floor. It's a bit dusty from neglect.");
        
        // </editor-fold>
        // <editor-fold desc="INITIALIZE CHAPEL"> 
        //-----------------------------THE ROOM---------------------------------
        Room cha1 = new Room("chapel", "CHA1");
        Room cha2 = new Room("chancel", "CHA2");
        //-------------------------------ITEMS----------------------------------        
        //-----------------------------FURNITURE-------------------------------- 
        // </editor-fold>
        // <editor-fold desc="INITIALIZE VAULT ACCESS"> 
        //-----------------------------THE ROOM---------------------------------
        Room vauh = new Room("vault access", "VAUH");
        Room vaue = new Room("vault entrance", "VAUE");
        //-------------------------------ITEMS----------------------------------        
        //-----------------------------FURNITURE-------------------------------- 
        // </editor-fold>
        // <editor-fold desc="INITIALIZE VAULT"> 
        //-----------------------------THE ROOM---------------------------------
        Room vau3 = new Room("vault", "VAU3");
        Room vau2 = new Room("vault", "VAU2");
        Room vau1 = new Room("vault", "VAU1");
        Room vau4 = new Room("inner vault", "VAU4");
        //-------------------------------ITEMS----------------------------------        
        //-----------------------------FURNITURE-------------------------------- 
        // </editor-fold>
        
        // </editor-fold>
        //---------------------------------------------------------------------- 
        // <editor-fold desc="AREA 7: UPPER CASTLE">

        Room foy4 = new Room("grand staircase top landing", "FOY4"); 
        Room bls1 = new Room("black staircase", "BLS1");
        Room bal1 = new Room("ballroom", "BAL1");
        Room bal2 = new Room("ballroom", "BAL2");
        Room dusc = new Room("dusty closet", "DUSC");
        Room ranr = new Room("rancid room", "RANR");

        Room soul = new Room("soul chamber", "SOUL");
        Room tbal = new Room("top balcony", "TBAL");
        Room bls2 = new Room("black staircase upper landing", "BLS2");
        Room thr1 = new Room("throneroom", "THR1");
        Room lqua = new Room("lich's quarters", "LQUA");
        Room thr2 = new Room("throneroom", "THR2");

        // </editor-fold>
        //---------------------------------------------------------------------- 

        //**********************************************************************
        // </editor-fold>  
        //**********************************************************************


        //**********************************************************************
        // <editor-fold desc="CREATE CASTLE ARRAY">
        //
        // MAIN CASTLE MAP. SEVEN ARRAYS OF 8 X 10 TWO DIMENSIONAL ARRAYS. 
        // EACH PRIMARY ARRAY CORRESPONDS TO ONE FLOOR. 
        //**********************************************************************

        Room ____ = new Room("NULL", "NULL");

        Room[][][] newMap =                         

        //  0    1    2    3    4    5    6    7    8    9
        {{{____,____,____,____,____,____,____,____,____,____}, //0 FLOOR 4 [0]
          {____,____,____,____,____,soul,____,____,____,____}, //1
          {____,____,____,____,____,tbal,____,____,____,____}, //2
          {____,____,____,____,bls2,thr1,lqua,____,____,____}, //3
          {____,____,____,____,____,thr2,____,____,____,____}, //4
          {____,____,____,____,____,____,____,____,____,____}, //5
          {____,____,____,____,____,____,____,____,____,____}, //6
          {____,____,____,____,____,____,____,____,____,____}},//7
        //  0    1    2    3    4    5    6    7    8    9  
         {{____,____,____,____,____,____,____,____,____,____}, //0 FLOOR 3 [1]
          {____,____,____,____,____,____,____,____,____,____}, //1
          {____,____,obs3,att1,labo,foy4,gal6,gal7,____,____}, //2
          {____,____,sst2,att2,bls1,bal1,bal2,____,chs3,____}, //3
          {____,____,____,____,____,dusc,____,____,cha1,____}, //4
          {____,____,____,____,____,ranr,____,____,cha2,____}, //5
          {____,____,____,____,____,____,____,____,____,____}, //6
          {____,____,____,____,____,____,____,____,____,____}},//7
        //  0    1    2    3    4    5    6    7    8    9  
         {{____,____,____,____,____,____,____,____,____,____}, //0 FLOOR 2 [2]
          {____,____,____,____,____,____,____,gal5,lib4,____}, //1
          {____,____,obs2,jha1,par2,foy3,gal3,gal4,lib5,____}, //2
          {____,____,sst1,jha2,____,____,____,____,____,____}, //3
          {____,____,gar1,gar2,____,____,____,____,din2,____}, //4
          {____,____,gar3,gar4,____,____,____,____,drar,____}, //5
          {____,____,____,wow3,clos,____,____,eow3,eow4,____}, //6
          {____,____,____,____,____,____,____,____,____,____}},//7
        //  0    1    2    3    4    5    6    7    8    9  
         {{____,____,____,____,____,____,____,____,____,____}, //0 FLOOR 1 [3]
          {____,____,bha1,bha2,bha3,bba1,bba2,lib1,lib2,____}, //1
          {____,____,obs1,stud,par1,foy2,gal1,gal2,lib3,____}, //2
          {____,____,look,rotu,want,foy1,vest,mha1,chs1,____}, //3
          {____,squa,sha2,iha1,cou1,entr,cou6,mha2,din1,____}, //4
          {____,rqua,sha1,iha2,cou2,cou3,cou5,mha3,kitc,____}, //5
          {____,wbal,wow1,wow2,sear,cou4,dst1,eow1,eow2,____}, //6
          {____,____,____,____,____,____,____,____,____,____}},//7
        //  0    1    2    3    4    5    6    7    8    9  
         {{____,____,____,____,____,____,____,____,____,____}, //0 BASEMENT [4]
          {____,____,____,____,____,____,____,vau4,vau3,____}, //1
          {____,____,____,____,____,____,____,____,vau2,____}, //2
          {____,____,____,____,____,cas1,cry2,____,vau1,____}, //3
          {____,sew7,sew6,sew5,pris,torc,cry1,____,vauh,____}, //4
          {____,sew8,aarc,sew4,sew3,sew2,sew1,____,vaue,____}, //5
          {____,sew9,oub1,intr,strp,arch,dst2,____,____,____}, //6
          {____,____,____,____,____,____,____,____,____,____}},//7
        //  0    1    2    3    4    5    6    7    8    9  
         {{____,____,____,____,____,____,____,____,____,____}, //0 CATACOMBS [5]
          {____,cat1,cat2,cat3,cat4,cat5,cat6,cat7,myst,____}, //1
          {____,cat9,ca10,ca11,ca12,ca13,ca14,ca15,ca16,____}, //2
          {____,ca17,ca18,ca19,ca20,cas2,ca22,ca23,ca24,____}, //3
          {____,ca25,ca26,ca27,ca28,ca29,ca30,ca31,ca32,____}, //4
          {____,ca33,ca34,ca35,ca36,ant1,ca38,ca39,ca40,____}, //5
          {____,ca41,oub2,ca43,ca44,ant2,ca46,ca47,ca48,____}, //6
          {____,____,____,____,____,____,____,____,____,____}},//7
        //  0    1    2    3    4    5    6    7    8    9  
         {{____,____,____,____,____,____,____,____,____,____}, //0 CAVES [6]
          {____,cv11,cv12,cv13,cv14,cv15,cv16,cv17,mys2,____}, //1
          {____,cv21,cv22,cv23,cv24,cv25,cv26,cv27,cv28,____}, //2
          {____,cv31,cv32,cv33,foun,cv35,cv36,cv37,cv38,____}, //3
          {____,cv41,cv42,cv43,cv44,cv45,cv46,cv47,cv48,____}, //4
          {____,cv51,cv52,cv53,cv54,cv55,cv56,cv57,cv58,____}, //5
          {____,cv61,cv62,cv63,cv64,mas1,mas2,cv67,cv68,____}, //6
          {____,____,____,____,____,____,____,____,____,____}} //7                
        };
        
        //**********************************************************************
        // <editor-fold desc="LOCK ROOMS">
        //**********************************************************************

        sear.lock(); rotu.lock(); stud.lock(); gal1.lock(); gal5.lock();
        par2.lock(); clos.lock(); din1.lock(); kitc.lock();
        chs1.lock(); eow3.lock(); bls1.lock(); soul.lock(); sew6.lock();
        cas1.lock(); arch.lock(); vau4.lock(); wow2.lock(); want.lock();
   
        //**********************************************************************        
        // </editor-fold>        
        //********************************************************************** 
        
        //**********************************************************************
        // </editor-fold> 
        //********************************************************************** 


        //**********************************************************************
        // <editor-fold desc="POPULATE ROOMS">
        // Fills every room with furniture.
        //**********************************************************************  
        
        //---------------------------------------------------------------------- 
        // <editor-fold desc="AREA 1">
        foy1.addFurniture(foy1Gt, foyF, foyW, foy1Chnd, door, foy1Tbl, foy1Crpt, foy1Strs);
        foy2.addFurniture(foy2Lvr, foy2Gt, foy2Stat, foy2Alc, foyF, foyW, foy2Strcs);
        vest.addFurniture(vesFire, vesBtn, vesWin, vesDsk, vesEtbl, vesCase, vesTpstr, vesChr, vesF, vesDr, wallEx);
        bba1.addFurniture(bbaF, wallEx, bbaClmns, bbaRlng, bbaVllg, bbaRf, bbaBnch, bbaScnc, bbaWvs, bbaClff, bbaShrln, bbaSea, bbaDrp, door);
        bba2.addFurniture(bbaF, wallEx, bbaClmns, bbaRlng, bbaVllg, bbaRf, bbaScnc, bbaWvs, bbaClff, bbaShrln, bbaSea, bbaDrp, bba2Dr);
        cou1.addFurniture(couStps, cou1Bnch, cou1Thrns, couW, cou12F, couCstl);
        cou2.addFurniture(couW, cou12F, cou2Bshs, cou2Fntn, couCstl);
        cou5.addFurniture(couW, cou56F, cou2Bshs, cou5Fntn, couCstl, cou5Sprc);
        cou6.addFurniture(couStps, cou1Bnch, cou1Thrns, couW, cou56F, cou6Stat, couCstl);
        cou3.addFurniture(cou3F, couW, cou3Stps, cou3Gt, cou3Ivy, cou3Fntns, couCstl);
        cou4.addFurniture(cou3F, couW, cou4Gt, cou4Frst, cou4Trl, couCstl);
        entr.addFurniture(couCstl, entrF, entrDr, entrStats, entrClmns, bbaRlng, entrRf, entrStps);
        // </editor-fold>  // Vestibule
        //---------------------------------------------------------------------- 
        // <editor-fold desc="AREA 2">    
        rotu.addFurniture(rotuFntn, rotuWhl, rotuW, rotuF, rotuPlnts, rotuHl, rotuStat, rotuScnc, rotuDr, rotuFrms, rotuSky, rotuRock);
        look.addFurniture(lookVlv, lookLghths, lookClff, lookRlng, lookF, wallEx, door);
        want.addFurniture(wantStat, wantLvr, wantTrchs, wantPllrs, wWW, wantF, wantRmp, wantDr);
        iha1.addFurniture(door, wWW, iha1F, iha1Armr, iha1Hnd, iha1Bwl, ihaWndw);
        iha2.addFurniture(door, wWW, iha2F, iha2Armr, iha2Hnd, iha2Bwl, ihaWndw);
        wow1.addFurniture(wWW, door, wow1Crt, wow2F, wowWndw, wowHrth, wow1Tls, wow1Shlvs);
        wow2.addFurniture(wWW, wow2Armr, wow2Blcny, wow2F, wow2Dr, wow2Hole, wowWndw, wowHrth, wow2Strcs);
        wbal.addFurniture(wallEx, door, lookLghths, lookClff, lookRlng, wbalF, wbalBcn, wbalFrst, bbaSea);
        squa.addFurniture(wWW, squaF, squaBd, squaDsk, squaWndw, lookLghths, lookClff, bbaSea, squaWrdrb, squaCndl, sha2Dr);
        wow3.addFurniture(wWW, wow3Shlf, wow3F, wow3Dr, bbaRlng);
        sha1.addFurniture(wWW, shaF, sha1Trch, sha1Dr);
        sha2.addFurniture(wWW, sha2Cbnt, shaF, sha2Dr, sha2Trch);
        clos.addFurniture(closW, closF, closShlf, closStl, closBrrl, closWrkbnch, closLddr, closScks, closClng, closSkltn);  
        sear.addFurniture(searFssr, searDr, searLddr, searAsh, searSkltn, searF, searW, searWood, closW);
        rqua.addFurniture(wWW, rquaF, rquaBd, rquaTbl, rquaMttrss, rquaDrssr, squaWndw, lookLghths, lookClff, bbaSea, rquaPnl);
        stud.addFurniture(wWW, studF, studPrtrt, studFire, studDsk, vesChr, studCch, studBkCs, studCrpt, door);
        // </editor-fold>  // West wing
        //---------------------------------------------------------------------- 
        // <editor-fold desc="AREA 3">     
        gal1.addFurniture(door, gal1F, gal1W, gal1Drgn, gal1KtnFurn, gal1Pntng, gal1Pntng2, gal1Pntng3, gal1Armr, gal1Scr, gal1Scrn, gal1Pntngs, gal1Lghts, gal1Sclptrs, gal1Hrth);
        gal2.addFurniture(gal2Stat, gal2Strcs, gal2F, gal2W, galBalc, gal1Lghts, rotuSky, galDm, gal2Clmns, mhaNDr);
        gal3.addFurniture(gal3Ttm, gal3Peg, gal3Hl, gal3Sgmnt, gal3Htch, gal3Lddr, gal3Rp, gal3Swtch, gal3InstFurn, gal3Msk, gal3Msk2, gal3Msk3, gal3Msks, gal3Hrth, gal3F, gal3W, gal3Art, gal3Art2, gal3Art3, gal3Arts);
        gal4.addFurniture(gal4Strcs, galBalc, rotuSky, gal2W, galDm, gal4Dr, gal2Clmns, gal4Lft);
        gal6.addFurniture(gal6Cnn, gal6Swtch, gal6Lddr, gal6Mchn, gal6Hlmt, gal6Bttn, gal6App, gal6F, gal6W, gal6Htch, gal6Tech, gal6Elec, gal6Tbl);
        gal7.addFurniture(wWW);
        mha1.addFurniture(mhaChndlr, mhaChr, mhaPlnt, mhaF, mhaW, mhaNWndw1, mhaNDr);
        mha2.addFurniture(mhaChndlr, mhaChr, mhaPlnt, mhaF, mhaW, mhaNWndw2, mhaMDr, mhaRStat, mhaLStat, mhaStats);
        mha3.addFurniture(mhaChndlr, mhaChr, mhaPlnt, mhaF, mhaW, mhaSWndw, mhaSDr);
        lib2.addFurniture(libLF, libW, libCch, lib2ShRck, lib2Stat, lib2Frplc, lib2Bttn, lib2WrFr, lib2Vyg, libBkShlf, libScncs, lib2Wndw);
        lib3.addFurniture(libLF, libW, door, lib3Strs, libCch, lib3Stat, lib3Crtn, libBkShlf, libScncs, lib3Blcny, lib3Wndw, lib3Pllr);
        lib4.addFurniture(libUF, libW, libCch, lib4Frplc, lib4Bttn, lib4Prdtn, libBkShlf, libScncs, lib3Pllr, lib4Stat, lib4Glb, lib3Blcny, lib4Tbl, lib4Strs);
        lib5.addFurniture(libUF, libW, lib5Bnshmnt, libBkShlf, libScncs, lib3Pllr, lib5Cndlbr);
        eow1.addFurniture(wWW, eowF, eow1Dr, eow1Rck, eow1Bskt, eow1Trch, wowWndw);
        eow2.addFurniture(wWW, eowF, eow2Fntn, eow2Wtr, eow2Rck, wowWndw, eow2Strs, eow2Blcny, eow2Cbnt, eow2Trch);
        eow4.addFurniture(wWW, eow4F, eow4Strs, bbaRlng, door);
        dst1.addFurniture(dstF, dstW, dst1Strs, door, dst1Lntrn);
        lib1.addFurniture(lib1F, lib1W, vesChr, lib1Dsk, lib1Art, lib1Docs, lib1Rg, lib1Wndw, lib1Rck, lib1Tbl, lib1Lght, lib1Mrrr, lib1Sf);
        eow3.addFurniture(wWW, wrkF, door, wowWndw, wrkBrl, wrkCstTbl, wrkKln, wrkBnch, wrkCbnt, wrkFrg, wrkAnvl);
        din1.addFurniture(din1Clmns, din1Blcny, din1Tbl, din1Tpstry, din1F, din1W, din1Wndw, din1Chrs, din1Chndlr, din1Mnlght, din1Strs, din1Crpt, din1Dr);
        din2.addFurniture(din2W, din2F, door, din2Pntng, din2Strs);
        drar.addFurniture(door, drarGhst, drarF, drarW, din1Mnlght, drarChss, drarBr, drarBllrds, drarWndw, drarCch, drarTbl);
        gal5.addFurniture(gal5Dsply, gal5Chndlr, gal5Cbwbs, gal5F, gal5W, gal5Clng);
        kitc.addFurniture(kitcTrch, kitcF, kitcW, kitcWndw, kitcDr, kitcRck, kitcPts, kitcHrth, kitcBrls, kitcPntry, kitcShlf, kitcCntr);

        // </editor-fold>  // East wing
        //---------------------------------------------------------------------- 
        // <editor-fold desc="AREA 4">
        foy3.addFurniture(foy3Strs);
        par2.addFurniture(wWW, par2F, par2Wndw, door, par2Strs, parLft, par2Bwl, par2Frplc, par2Pno, par2Shlf);
        par1.addFurniture(par1F, par1Dr, par1FrPlc, wWW, par1EnchntTbl, par1Strs, parLft,
                          par1Pllrs, par1Orb, par1Hrp, par1Shlf, lib1Rg, par1Cshn, vesChr);
        obs1.addFurniture(obsSlts, hlsSlt, hrmsSlt, gaeaSlt, aphrdtSlt, aresSlt, krnsSlt, zsSlt, urnsSlt, psdnSlt, 
                          obsStats, obsHls, obsHrms, obsGaea, obsAphrdt, obsAres, obsKrns, obsZs, obsUrns, obsPsdn);
        obs3.addFurniture(obs3Chndlr);
        // </editor-fold>  // Castle rear
        //---------------------------------------------------------------------- 
        // <editor-fold desc="AREA 5">

        // </editor-fold>  // Sub-levels
        //---------------------------------------------------------------------- 
        // <editor-fold desc="AREA 6">
        chs1.addFurniture(chs1Strs, chsWndws, chs1F, chsW, din1Mnlght, chs1Stat, mhaNDr);
        chs3.addFurniture(chs3Strs, chsWndws, chsW, din1Mnlght, chs3F, door);
        // </editor-fold>  // Chapel and vault
        //---------------------------------------------------------------------- 
        // <editor-fold desc="AREA 7">

        // </editor-fold>  // Top floors
        //---------------------------------------------------------------------- 
        
        //**********************************************************************
        // </editor-fold>  
        //**********************************************************************
        
        me.setOccupies(chs1);
        //me.getINV().add();
        return newMap;
    }
    
    // *************************************************************************
    // </editor-fold> 
    // *************************************************************************   
    
// ============================================================================
}