package A_Main;

import static A_Main.Names.NL;
/**
 * Organizes the various menus in the game.
 * 
 * @author Kevin Rapa
 */
public final class Menus {
    public static final String
        INV_MAIN = NL
                 + "<'1'> Inspect item" + NL
                 + "<'2'> Use item" + NL
                 + "<'3'> Combine items" + NL
                 + "<'4'> Sort inventory" + NL
                 + "<'5'> Write a momento" + NL
                 + " < >  Back",

        INV_INSPECT = NL
                    + "<item> Inspect..." + NL
                    + "< > Back",

        INV_USE = NL
                + "<item> Use..." + NL 
                + "< > Back",

        INV_USEON = NL
                  + "<object> Use on..." + NL
                  + "< >      Back",

        INV_COMBINE = NL
                    + "<list> Combine..." + NL
                    + "< >    Back",

        TRADE_SUB = NL
                  + "<'s' list>  Store..." + NL
                  + "<'t' list>  Take..." + NL
                  + "<'c' item>  Inspect" + NL
                  + "<'loot'>    Loot!!!" + NL
                  + "< >         Back",

        SAVE_QUIT = NL + NL
                  + "<'s'> Save and quit" + NL
                  + "<'q'> Quit" + NL
                  + "<'r'> Reset game and quit.",

        MAIN_MENU = "      Enter a command or" + NL + NL
                  + "    <'w'/'s'/'a'/'d'> Move" + NL
                  + "<'i'>  Inventory  <'k'>  Keys" + NL
                  + "<'h'>  Get help   <'n'>  Note" + NL
                  + "<'m'>  Show Map   <'l'>  Loot" + NL
                  + "<'save'> Save    <'quit'> Quit",

        HELP_MAIN = NL
                  + "What would you like help on?" + NL
                  + "<'1'> Controls" + NL
                  + "<'2'> Your player" + NL 
                  + "<'3'> The castle" + NL
                  + " < >   Back",

        HELP_SUB1 = NL
                  + "<'1'> The prompt <'2'> Moving" + NL
                  + "<'3'> Describing <'4'> Examining" + NL
                  + "<'5'> Searching  <'6'> Commands" + NL 
                  + "<'7'> Using      <'8'> Combining" + NL
                  + "<'9'> Inspecting <'10'> Notes" + NL
                  + " < >  Back",

        HELP_SUB2 = NL
                  + "<'1'> Your inventory" + NL
                  + "<'2'> Your key ring" + NL 
                  + "<'3'> Your phylacteries" + NL
                  + " < >  Back",

        HELP_SUB3 = NL
                  + "<'1'> Doors      <'2'> Rooms" + NL
                  + "<'3'> Furniture  <'4'> Items" + NL
                  + "<'5'> Keys       <'6'> Phylacteries" + NL
                  + " < >  Back",

        SAFE_MENU = NL
                  + "<'1'> Turn dial one" + NL
                  + "<'2'> Turn dial two" + NL
                  + "<'3'> Turn dial three" + NL
                  + " < >  Back\n",

        OBS_STAT_MEN = NL
                     + "<'r'#> Rotate statue" + NL
                     + "<'m'#> Move statue",

        OBS_SLOT_EX = NL
                    + "<'a-i'> Look..." + NL
                    + "  < >   Back",

        OBS_SLOT_SE = NL
                    + "<'a-i'> Search..." + NL
                    + "  < >   Back",

        DOUBLE_ST = NL
                  + "There are two flights" + NL
                  + "    <'u'> Go up" + NL
                  + "    <'d'> Go down",

        SEW_VALVE = NL
                  + "<#> Turn valve" + NL
                  + "< > Back",

        VAEU_DOOR = NL
                  + "<x,y> Push" + NL
                  + " < >  Back",

        CRY_DRWRS = NL
                  + "<#> Search..." + NL
                  + "< > Back",

        GAL6_BTTN = NL
                  + "<'y'> Push" + NL
                  + "<'n'> Don't push" + NL
                  + "< >   Back",

        GAL6_HELM = NL
                  + "<'y'> Wear it" + NL
                  + "<'n'> Don't wear it" + NL
                  + "< >   Back",
            
        OBS_STATS = NL
                  + "<#> Look..." + NL
                  + "< > Back",
            
        LABO_BURET = NL
                   + "<1> Empty" + NL
                   + "<2> Titrate" + NL
                   + "< > Back",
            
        LABO_DISP = NL
                  + "<#> Dispense" + NL
                  + "< > Back",
            
        GAL_TOTEM = NL
                  + "<#> Turn head" + NL
                  + "< > Back",
        
        ENTER = NL + NL + "Press enter...";
}
