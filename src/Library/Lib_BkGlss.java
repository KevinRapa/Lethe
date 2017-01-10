package Library;

import A_Super.Book;

public class Lib_BkGlss extends Book {
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Lib_BkGlss(String name) {
        super(name, 3);
        
        PAGE_LIST[0] = "The Master Glasser\n" +
                       "-- Lasi Lasinen\n";
        
        PAGE_LIST[1] = "Hah! You have pick this book up. That means\n" +
                       "you have come into defeat by glass blowing.\n" +
                       "Do not be embarrased. For you not need to\n" +
                       "blow into glass to be master glassman. As\n" +
                       "fact, today you need four thing to do glass\n" +
                       "yourself: sand, potash, kiln, and casting\n" +
                       "table. Any such sand will do. We concern\n" +
                       "ourselves with melting silicon dioxide. Into\n" +
                       "kiln throw the sand. Do not be shy! You need\n" +
                       "however hotten kiln sufficiently! About 1,500\n" +
                       "celcius will do. Now, we need potash to lower\n" +
                       "melting point of sand to sufficient level. ";
        
        PAGE_LIST[2] = "Throw potash into kiln. No need to be too\n" +
                       "careful. We allow mixture to sit and melt\n" +
                       "into glass for a short while. Now its time\n" +
                       "to prepare casting table. Most important\n" +
                       "matter to keep in mind is to have clean\n" +
                       "surface! We do not want particles in glass!\n" +
                       "Ok, enough time has passed. Take crucible \n" +
                       "out of kiln and pour carefully on casting\n" +
                       "table. Not before long we have fresh glass!\n" +
                       "Now you may call yourself as \"proper glass-\n" +
                       "man!\" We did not discuss extra details. In\n" +
                       "addition to necessary steps, you may choose\n" +
                       "to add dye to mixture for colored glass. For\n" +
                       "many shapes, be free to use templates! Glass\n" +
                       "is still art, despite you being idiot at\n" +
                       "blowing glass. It's ok!";
    }
/*----------------------------------------------------------------------------*/
}


