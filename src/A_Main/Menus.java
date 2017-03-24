package A_Main;

/**
 * Organizes the various menus in the game.
 * 
 * @author Kevin Rapa
 */
public final class Menus {
    public static final String
        INV_MAIN = "\n"
                 + "<'1'> Inspect item\n"
                 + "<'2'> Use item\n" + 
                   "<'3'> Combine items\n"
                 + "<'4'> Sort inventory\n"
                 + "<'5'> Write a momento\n"
                 + " < >  Back",

        INV_INSPECT = "\n"
                    + "<item> Inspect...\n"
                    + "< > Back",

        INV_USE = "\n"
                + "<item> Use...\n"
                + "< > Back",

        INV_USEON = "\n"
                  + "<object> Use on...\n"
                  + "< >      Back",

        INV_COMBINE = "\n"
                    + "<list> Combine...\n"
                    + "< >    Back",

        TRADE_SUB = "\n"
                  + "<'s' list>  Store...\n"
                  + "<'t' list>  Take...\n"
                  + "<'loot'>    Loot!!!\n"
                  + "< >         Back",

        SAVE_QUIT = "\n\n"
                  + "<'s'> Save and quit\n"
                  + "<'q'> Quit\n"
                  + "<'r'> Reset game and quit.",

        MAIN_MENU = "      Enter a command or\n\n"
                  + "    <'w'/'s'/'a'/'d'> Move\n"
                  + "<'i'>  Inventory  <'k'>  Keys\n"
                  + "<'h'>  Get help   <'n'>  Note\n"
                  + "<'m'>  Show Map   <'l'>  Loot\n"
                  + "<'save'> Save    <'quit'> Quit",

        HELP_MAIN = "\nWhat would you like help on?\n" +
                    "<'1'> Controls\n"
                  + "<'2'> Your player\n" +
                    "<'3'> The castle\n"
                  + " < >   Back",

        HELP_SUB1 = "\n"
                  + "<'1'> The prompt <'2'> Moving\n"
                  + "<'3'> Describing <'4'> Examining\n"
                  + "<'5'> Searching  <'6'> Commands\n" 
                  + "<'7'> Using      <'8'> Combining\n"
                  + "<'9'> Inspecting <'10'> Notes\n"
                  + " < >  Back",

        HELP_SUB2 = "\n"
                  + "<'1'> Your inventory\n"
                  + "<'2'> Your key ring\n" 
                  + "<'3'> Your phylacteries\n"
                  + " < >  Back",

        HELP_SUB3 = "\n"
                  + "<'1'> Doors      <'2'> Rooms\n"
                  + "<'3'> Furniture  <'4'> Items\n"
                  + "<'5'> Keys       <'6'> Phylacteries\n"
                  + " < >  Back",

        SAFE_MENU = "\n"
                  + "<'1'> Turn dial one\n"
                  + "<'2'> Turn dial two\n"
                  + "<'3'> Turn dial three\n"
                  + " < >  Back\n",

        OBS_STAT_MEN = "\n"
                     + "<'r'#> Rotate statue\n"
                     + "<'m'#> Move statue",

        OBS_SLOT_EX = "\n"
                    + "<'a-i'> Look...\n"
                    + "  < >   Back",

        OBS_SLOT_SE = "\n"
                    + "<'a-i'> Search...\n"
                    + "  < >   Back",

        DOUBLE_ST = "\n"
                  + "There are two flights\n"
                  + "    <'u'> Go up\n"
                  + "    <'d'> Go down",

        SEW_VALVE = "\n"
                  + "<#> Turn valve\n"
                  + "< > Back",

        VAEU_DOOR = "\n"
                  + "<x,y> Push\n"
                  + " < >  Back",

        CRY_DRWRS = "\n"
                  + "<#> Search...\n"
                  + "< > Back",

        GAL6_BTTN = "\n"
                  + "<'y'> Push\n"
                  + "<'n'> Don't push\n"
                  + "< >   Back",

        GAL6_HELM = "\n"
                  + "<'y'> Wear it\n"
                  + "<'n'> Don't wear it\n"
                  + "< >   Back",
            
        OBS_STATS = "\n<#> Look..."
                  + "\n< > Back",
            
        LABO_BURET = "\n<1> Empty"
                   + "\n<2> Titrate"
                   + "\n< > Back",
            
        LABO_DISP = "\n<#> Dispense"
                  + "\n< > Back",
            
        GAL_TOTEM = "\n<#> Turn head"
                  + "\n< > Back",
        
        ENTER = "\n\nPress enter...";
}
