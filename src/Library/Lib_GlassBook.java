package Library;

import A_Super.Book;

public class Lib_GlassBook extends Book {
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Lib_GlassBook(String name) {
        super(name, 3);
        
        PAGE_LIST[0] = "The Master Glasser " +
                       "-- Lasi Lasinen ";
        
        PAGE_LIST[1] = "Hah! You have pick this book up. That means " +
                       "you have come into defeat by glass blowing. " +
                       "Do not be embarrased. For you not need to " +
                       "blow into glass to be master glassman. As " +
                       "fact, today you need four thing to do glass " +
                       "yourself: sand, potash, kiln, and casting " +
                       "table. Any such sand will do. We concern " +
                       "ourselves with melting silicon dioxide. Into " +
                       "kiln throw the sand. Do not be shy! You need " +
                       "however hotten kiln sufficiently! About 1,500 " +
                       "celcius will do. Now, we need potash to lower " +
                       "melting point of sand to sufficient level. ";
        
        PAGE_LIST[2] = "Throw potash into kiln. No need to be too " +
                       "careful. We allow mixture to sit and melt " +
                       "into glass for a short while. Now its time " +
                       "to prepare casting table. Most important " +
                       "matter to keep in mind is to have clean " +
                       "surface! We do not want particles in glass! " +
                       "Ok, enough time has passed. Take crucible " +
                       "out of kiln and pour carefully on casting " +
                       "table. Not before long we have fresh glass! " +
                       "Now you may call yourself as \"proper glass- " +
                       "man!\" We did not discuss extra details. In " +
                       "addition to necessary steps, you may choose " +
                       "to add dye to mixture in kiln for colored glass. For " +
                       "many shapes, be free to use templates! Glass " +
                       "is still art, despite you being idiot at " +
                       "blowing glass. It's ok!";
    }
//-----------------------------------------------------------------------------
}


