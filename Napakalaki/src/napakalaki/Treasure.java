/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Javi
 */
public class Treasure implements Card {
    
    
    private String name;
    private int goldCoins;
    private int minBonus;
    private int maxBonus;
    private TreasureKind type;
    
    
    
    //Metodos blelbe
    Treasure (){
        name="";
    }
    Treasure (String name,int gold,int min,int max,TreasureKind tipo){
        this.name=name;
        goldCoins=gold;
        minBonus=min;
        maxBonus=max;
        type=tipo;
                
    }
    
    public String getName(){
        return name;
    }
    
    public int getBasicValue(){
        return getMinBonus();
        
    }
    
    public int getSpecialValue(){
        return getMaxBonus();
        
    }
    
    public int getGoldCoins(){
        return goldCoins;
    }
    
    public int getMinBonus(){
        return minBonus;
    }
    
    public int getMaxBonus(){
        return maxBonus;
    }
    
    public TreasureKind getType(){
        return type;
    }
    @Override
    public String toString(){
return "\n\nName = " + name + "\nGold Coins = " + Integer.toString(goldCoins)+"\nMin Bonus: "+Integer.toString(minBonus)+"\nMax Bonus: "+Integer.toString(maxBonus)+"\nType: "+(type);                     
    
}
    
}
