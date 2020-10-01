package napakalaki;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Miguel Keane
 */
public class CultistPlayer extends Player{
    private static int totalCultistPlayer=0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
       super (p);
       myCultistCard=c;
       totalCultistPlayer++;
      
    }
    
    @Override
    public String toString(){ 
    return "\n\nName = " + super.getName() + "    || SECTARIO ||"+ "\nLevel = " + Integer.toString(super.getLevel())+"\n\n  Visible Treasures"+super.getVisibleTreasures()+"\n\n   Hidden Treasures"+super.getHiddenTreasures(); 
      
} 
    
    @Override
    public int getCombatLevel(){
        return super.getCombatLevel()+ myCultistCard.getSpecialValue();
    }
    @Override
     public boolean shouldConvert(){ 
        return false; 
    } 
     
     @Override
     public int getOponentLevel (Monster m){ 
        return m.getSpecialValue();
          
    }    
    
     public int computeGoldCoinsValue (ArrayList<Treasure> t){ 
        int gold=0; 
        for(int i=0; i<t.size();i++){ 
            gold=gold + (t.get(i)).getGoldCoins(); 
        } 
        int l=gold*2/1000; 
        return l; 
    } 
      
    public static int getTotalCultistPlayers(){ 
         return totalCultistPlayer; 
          
    } 
      
}
