package Super;

public class Static_Wndw extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Static_Wndw() {
        super();
        this.searchable = false;
        this.interactDialog = "This is a plain barred window. It has no moving parts.";
        this.addActKeys("open", "close");
        this.addNameKeys("window");
    }
/*----------------------------------------------------------------------------*/
}

