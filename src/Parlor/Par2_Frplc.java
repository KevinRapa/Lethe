/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parlor;

import Super.Furniture;

public class Par2_Frplc extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Par2_Frplc(String NAME) {
            super(NAME);
            this.searchable = false;
            this.addNameKeys("fireplace", "hearth");
            this.description = "The fireplace crackles down below. Who keeps these\n"
                             + "things lit?";
            this.searchDialog = "It's much too far awy to do that...";
    }
/*----------------------------------------------------------------------------*/    
}
