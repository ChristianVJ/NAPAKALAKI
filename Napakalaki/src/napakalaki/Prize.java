/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Javi
 */
public class Prize {
    
    private int treasures;
    private int level;
    
    Prize(int treasures, int level){
        this.treasures = treasures;
        this.level= level;
    }    
    
    
    @Override
    public String toString(){
return "Treasures = " + Integer.toString(treasures) + " level = " + Integer.toString(level);
}
    
     public int getTreasures(){
         return treasures;
    }
     
     public int getLevel(){
         return level;
     }
     
     }
