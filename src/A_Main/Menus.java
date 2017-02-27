package A_Main;

/**
 * Organizes the various menus in the game.
 * 
 * @author Kevin Rapa
 */
public final class Menus {
    public static final String
            INV_MAIN = "<'1'> Inspect item\n"
                     + "<'2'> Use item\n" + 
                       "<'3'> Combine items\n"
                     + "<'4'> Sort inventory\n"
                     + "  < > Back",
            
            INV_INSPECT = "\n"
                        + "<#> Inspect...\n"
                        + "< > Back",
            
            INV_USE = "\n"
                    + "<#> Use...\n"
                    + "< > Back",
            
            INV_USEON = "\n"
                      + "<object> Use on...\n"
                      + "     < > Back",
            
            INV_COMBINE = "\n"
                        + "<#,#,(#)> Combine...\n"
                        + "      < > Back",
            
            EXAMINE_SUB = "\n\n"
                        + "<object> Look at...\n"
                        + "     < > Back",
            
            TRADE_SUB = "\n"
                      + "<'s' #> Store...\n"
                      + "<'t' #> Take...\n"
                      + "    < > Back",
            
            SEARCH_SUB = "\n\n"
                       + "<object> Search\n"
                       + "     < > Back\n",
            
            SAVE_QUIT = "\n"
                      + "<'s'> Save and quit\n"
                      + "<'q'> Quit\n"
                      + "<'r'> Reset game and quit.",
            
            MAIN_MENU = "       <command> Action\n"
                      + "    <'w'/'s'/'a'/'d'> Move\n"
                      + "<'e'> Search    <'c'>    Check\n"
                      + "<'i'> Inventory <'k'>    Keys\n"
                      + "<'h'> Get help  <'quit'> Quit",
            
            HELP_MAIN = "What would you like help on?\n\n" +
                        "     <'1'> Controls\n"
                      + "     <'2'> Your player\n" +
                        "     <'3'> The castle\n"
                      + "       < >  Back",
            
            HELP_SUB1 = "<'1'> The prompt <'2'> Moving\n"
                      + "<'3'> Describing <'4'> Checking\n"
                      + "<'5'> Searching  <'6'> Interacting\n" 
                      + "<'7'> Using      <'8'> Combining\n"
                      + "<'9'> Inspecting   < > Back",
            
            HELP_SUB2 = "\n"
                      + "<'1'> Your inventory\n"
                      + "<'2'> Your key ring\n" 
                      + "<'3'> Your phylacteries\n"
                      + "  < >  Back",
            
            HELP_SUB3 = "\n"
                      + "<'1'> Doors        <'2'> Rooms\n"
                      + "<'3'> Furniture    <'4'> Items\n"
                      + "<'5'> Keys         <'6'> Phylacteries\n"
                      + "  < > Back",
            
            SAFE_MENU = "\n"
                      + "<'1'> Turn dial one\n"
                      + "<'2'> Turn dial two\n"
                      + "<'3'> Turn dial three\n"
                      + "  < > Back\n",
            
            OBS_STAT_MEN = "\n"
                         + "<'r'#> Rotate statue\n"
                         + "<'m'#> Move statue",
            
            OBS_SLOT_EX = "\n"
                        + "<'a-i'> Look...\n"
                        + "    < > Back",
            
            OBS_SLOT_SE = "\n"
                        + "<'a-i'> Search...\n"
                        + "    < > Back",
            
            BOOK_MEN = "\n"
                     + "Turn page?\n"
                     + "<'y'> Turn the page\n"
                     + "<'n'> Close the book",
            
            DOUBLE_ST = "\n"
                      + "There are two flights here.\n"
                      + "<'u'> Go up\n"
                      + "<'d'> Go down",
            
            SEW_VALVE = "\n"
                      + "<#> Turn valve\n"
                      + "< > Back",
            
            VAEU_DOOR = "\n"
                      + "<x, y> Push\n"
                      + "   < > Back",
    
            CRY_DRWRS = "\n"
                      + "<#> Search...\n"
                      + "< > Back",
            
            GAL6_BTTN = "\n"
                      + "<'y'> Push\n"
                      + "<'n'> Don't push\n"
                      + "  < > Back",
            
            GAL6_HELM = "\n"
                      + "<'y'> Wear it\n"
                      + "<'n'> Don't wear it\n"
                      + "  < > Back",
            
            LABO_DSPNSR = "\n"
                        + "Dispense?\n"
                        + "<'y'/'n'>",
            
            BLCK_JCK_GST = "\n"
                         + "  Play?\n"
                         + "<'y'/'n'>";
}
