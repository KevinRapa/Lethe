package Library;

import A_Super.Book;

public class Lib_Inf extends Book {
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Lib_Inf(String name) {
        super(name, 5);
        
        PAGE_LIST[0] = "Dante's Inferno is the first of a trilogy making up\n" +
                       "the 14th century work \"Divine Comedy\" by the Italian\n" +
                       "Dante Alighieri. It details the events of the\n" +
                       "character Dante's journey through Hell.\n";
        
        PAGE_LIST[1] = "In the midway 1 of this our mortal life,\n" +
                       "I found me in a gloomy wood, astray\n" +
                       "Gone from the path direct: and e’en to tell,\n" +
                       "It were no easy task, how savage wild\n" +
                       "That forest, how robust and rough its growth,\n" +
                       "Which to remember only, my dismay\n" +
                       "Renews, in bitterness not far from death.\n" +
                       "Yet, to discourse of what there good befel,\n" +
                       "All else will I relate discover’d there.\n" +
                       "How first I enter’d it I scarce can say,\n" +
                       "Such sleepy dulness in that instant weigh’d	\n" +
                       "My senses down, when the true path I left;\n" +
                       "But when a mountain’s foot I reach’d, where closed\n" +
                       "The valley that had pierced my heart with dread,\n" +
                       "I look’d aloft, and saw his shoulders broad\n" +
                       "Already vested with that planet’s beam, 2\n" +
                       "Who leads all wanderers safe through every way.\n" +
                       "Then was a little respite to the fear,\n" +
                       "That in my heart’s recesses deep had lain\n" +
                       "All of that night, so pitifully past:\n" +
                       "And as a man, with difficult short breath,\n" +
                       "Forespent with toiling, ’scaped from sea to shore,\n" +
                       "Turns to the perilous wide waste, and stands\n" +
                       "At gaze; e’en so my spirit, that yet fail’d,\n" +
                       "Struggling with terror, turn’d to view the straits\n" +
                       "That none hath passed and lived. My weary frame\n" +
                       "After short pause recomforted, again\n" +
                       "I journey’d on over that lonely steep,\n" +
                       "The hinder foot 3 still firmer. Scarce the ascent\n" +
                       "Began, when, lo! a panther, 4 nimble, light,\n" +
                       "And cover’d with a speckled skin, appear’d;\n" +
                       "Nor, when it saw me, vanish’d; rather strove\n" +
                       "To check my onward going; that oft-times,\n" +
                       "With purpose to retrace my steps, I turn’d.";
        
        PAGE_LIST[2] = "The hour was morning’s prime, and on his way\n" +
                       "Aloft the sun ascended with those stars, 5\n" +
                       "That with him rose when Love Divine first moved\n" +
                       "Those its fair works: so that with joyous hope\n" +
                       "All things conspired to fill me, the gay skin\n" +
                       "Of that swift animal, the matin dawn,\n" +
                       "And the sweet season. Soon that joy was chased.\n" +
                       "And by new dread succeeded, when in view\n" +
                       "A lion came, ’gainst me as it appear’d,\n" +
                       "With his head held aloft and hunger-mad,\n" +
                       "That e’en the air was fear-struck. A she-wolf\n" +
                       "Was at his heels, who in her leanness seem’d\n" +
                       "Full of all wants, and many a land hath made\n" +
                       "Disconsolate ere now. She with such fear\n" +
                       "O’erwhelm’d me, at the sight of her appall’d,\n" +
                       "That of the height all hope I lost. As one,\n" +
                       "Who, with his gain elated, sees the time\n" +
                       "When all unawares is gone, he inwardly\n" +
                       "Mourns with heart-griping anguish; such was I,\n" +
                       "Haunted by that fell beast, never at peace,\n" +
                       "Who coming o’er against me, by degrees\n" +
                       "Impell’d me where the sun in silence rests.\n" +
                       "While to the lower space with backward step\n" +
                       "I fell, my ken discern’d the form of one\n" +
                       "Whose voice seem’d faint through long disuse of speech.\n" +
                       "When him in that great desert I espied,\n" +
                       "“Have mercy on me,” cried I out aloud,\n" +
                       "“Spirit! or living man! whate’er thou be.”\n" +
                       "He answered: “Now not man, man once I was,\n" +
                       "And born of Lombard parents, Mantuans both\n" +
                       "By country, when the power of Julius yet\n" +
                       "Was scarcely firm. At Rome my life was past,\n" +
                       "Beneath the mild Augustus, in the time\n" +
                       "Of fabled deities and false. A bard\n" +
                       "Was I, and made Anchises’ upright son\n" +
                       "The subject of my song, who came from Troy,\n" +
                       "When the flames prey’d on Ilium’s haughty towers.";
        
        PAGE_LIST[3] = "But thou, say wherefore to such perils past\n" +
                       "Return’st thou? wherefore not this pleasant mount\n" +
                       "Ascendest, cause and source of all delight?”\n" +
                       "“And art thou then that Virgil, that well-spring,\n" +
                       "From which such copious floods of eloquence\n" +
                       "Have issued?” I with front abash’d replied.\n" +
                       "“Glory and light of all the tuneful train!\n" +
                       "May it avail me, that I long with zeal\n" +
                       "Have sought thy volume, and with love immense\n" +
                       "Have conn’d it o’er. My master thou, and guide!\n" +
                       "Thou he from whom alone I have derived\n" +
                       "That style, which for its beauty into fame\n" +
                       "Exalts me. See the beast, from whom I fled.\n" +
                       "O save me from her, thou illustrious sage!\n" +
                       "For every vein and pulse throughout my frame\n" +
                       "She hath made tremble.” He, soon as he saw\n" +
                       "That I was weeping, answer’d, “Thou must needs\n" +
                       "Another way pursue, if thou wouldst ’scape\n" +
                       "From out that savage wilderness. This beast,\n" +
                       "At whom thou criest, her way will suffer none\n" +
                       "To pass, and no less hinderance makes than death:\n" +
                       "So bad and so accursed in her kind,\n" +
                       "That never sated is her ravenous will,\n" +
                       "Still after food more craving than before.\n" +
                       "To many an animal in wedlock vile\n" +
                       "She fastens, and shall yet to many more,\n" +
                       "Until that greyhound 6 come, who shall destroy\n" +
                       "Her with sharp pain. He will not life support\n" +
                       "By earth nor its base metals, but by love,\n" +
                       "Wisdom, and virtue; and his land shall be\n" +
                       "The land ’twixt either Feltro. 7 In his might\n" +
                       "Shall safety to Italia’s plains arise,\n" +
                       "For whose fair realm, Camilla, virgin pure,\n" +
                       "Nisus, Euryalus, and Turnus fell.";
        
        PAGE_LIST[4] = "He, with incessant chase, through every town\n" +
                       "Shall worry, until he to hell at length\n" +
                       "Restore her, thence by envy first let loose.\n" +
                       "I, for thy profit pondering, now devise\n" +
                       "That thou mayst follow me; and I, thy guide,\n" +
                       "Will lead thee hence through an eternal space,\n" +
                       "Where thou shalt hear despairing shrieks, and see\n" +
                       "Spirits of old tormented, who invoke\n" +
                       "A second death; 8 and those next view, who dwell\n" +
                       "Content in fire, 9 for that they hope to come,\n" +
                       "Whene’er the time may be, among the blest,\n" +
                       "Into whose regions if thou then desire\n" +
                       "To ascend, a spirit worthier 10 than I\n" +
                       "Must lead thee, in whose charge, when I depart,\n" +
                       "Thou shalt be left; for that Almighty King,\n" +
                       "Who reigns above, a rebel to His law\n" +
                       "Adjudges me; and therefore hath decreed\n" +
                       "That, to His city, none through me should come.\n" +
                       "He in all parts hath sway; there rules, there holds\n" +
                       "His citadel and throne. O happy those,\n" +
                       "Whom there He chuses!” I to him in few:\n" +
                       "“Bard! by that God, whom thou didst not adore,\n" +
                       "I do beseech thee (that this ill and worse\n" +
                       "I may escape) to lead me where thou said’st,\n" +
                       "That I Saint Peter’s gate 11 may view, and those\n" +
                       "Who, as thou tell’st, are in such dismal plight.”\n" +
                       "Onward he moved, I close his steps pursued." +
                       "... Wait. You didn't come to this castle just to read, did you?";
    }
/*----------------------------------------------------------------------------*/
}
