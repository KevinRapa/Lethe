package Laboratory;

import A_Super.Note;

public class Labo_DistillerNote extends Note {
/* CONSTRUCTOR ---------------------------------------------------------------*/
    public Labo_DistillerNote(String name) {
        super(name);
        this.description = "The switch on the condenser needs replacing soon.\n"
                         + "I'm finding it too difficult to open up the distillation\n"
                         + "tube. Also, where did the flask for that distiller go?";
    }
/*----------------------------------------------------------------------------*/
}