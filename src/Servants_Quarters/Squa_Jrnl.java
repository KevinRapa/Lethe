package Servants_Quarters;

import A_Super.Book;

public class Squa_Jrnl extends Book{
    private final String pg1, pg2, pg3, pg4;

/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Squa_Jrnl(String name) {
        super(name, 4);
        
        pg1 = "12 Sept, 1685 -\n\n" +
              "Francis took his life last night. None of us\n" +
              "could find him all day, till Solomon found him\n" +
              "off the balcony hanging by a rope whilst draining\n" +
              "the fountain. I think it not surprising, though.\n" +
              "Francis has become increasingly lethargic,\n" +
              "to no explanation.\n\nOver the past six months,\n" +
              "Erik has been spiraling down into dementia. This\n" +
              "place has become a prison. He does not let us leave,\n" +
              "and keeps the outside doors locked all the time.\n" +
              "Solomon, Agatha and I all fear Francis' fate\n" +
              "follows us, but if we can escape from here, it\n" +
              "shall not. The only way out is the front gate, for\n" +
              "this place is surrounded on all sides by sea.";
        
        pg2 = "14 Sept, 1685 -\n\n" +
              "Solomon has brewed up some sort of acid that he\n" +
              "proclaims will weaken the mortar in his wall.\n" +
              "I thought these walls were impermeable, but it's\n" +
              "only clay in between these stones in the wall.\n" +
              "Nonetheless, Solomon tells me it shall take at\n" +
              "least a week to dissolve the mortar enough to\n" +
              "start breaking these blocks away. After that, the\n" +
              "three of us together should be able to push open\n" +
              "the front gate. I have taken to lighting the\n" +
              "beacon every night, against Erik's word. Perhaps\n" +
              "that lighthouse keeper will notice. I hide the\n"
            + "ladder under my bed for now.";
        
        pg3 = "20 Sept, 1685\n\n" +
              "Solomon tells me that the wall is ready to be\n" +
              "broken down! It has been a little under a week,\n" +
              "so our time is well. We will use the warhammer,\n" +
              "the one from the armor suit, to break it down.\n" +
              "But it must be covert. Everything must be as\n" +
              "normal during the daytime. Agatha has been\n" +
              "acting strangely lately. She has, well, been\n" +
              "more tired than usual. The same as Francis.\n" +
              "She tells me she has a key made that will allow\n" +
              "her access to Erik's study. He keeps there a\n" +
              "valuable emerald that would serve us well\n" +
              "financially on the outside. In the meantime,\n" +
              "she keeps the key hidden under her bed.";
        
        pg4 = "September 25, 1685 \n\n" +
              "I am quite uneasy. Agatha is not acting herself.\n" +
              "She seems to be losing her mind, and she is losing\n" +
              "it faster and faster. Her room is a mess, and she\n" +
              "has been talking to herself of violence while\n" +
              "ignoring us most of the time! She denies her\n" +
              "wanting to leave, and insists she knows nothing of\n" +
              "Erik's study. I fear Francis' fate has caught up\n" +
              "to Agatha. I just hope she is with us as we escape\n" +
              "tonight.";
               
        this.PAGE_LIST[0] = this.pg1;
        this.PAGE_LIST[1] = this.pg2;
        this.PAGE_LIST[2] = this.pg3;
        this.PAGE_LIST[3] = this.pg4;
    }
/*----------------------------------------------------------------------------*/
}
