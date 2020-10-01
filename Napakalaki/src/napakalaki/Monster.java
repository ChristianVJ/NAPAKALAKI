
/* 
 * To change this template, choose Tools | Templates 
 * and open the template in the editor. 
 */
package napakalaki; 
  
/** 
 * 
 * @author Javi 
 */
public class Monster implements Card{ 
      
    private String name; 
    private int combatLevel; 
    private Prize monPrize; 
    private BadStuff monBS; 
    private int levelChangeAgainstCultistPlayer;
      
    Monster(String name, int level, BadStuff bc, Prize price, int levelCultist){ 
        this.name =name; 
        combatLevel = level; 
        monBS = bc; 
        monPrize = price; 
        levelChangeAgainstCultistPlayer = levelCultist;
          
    } 
      
    @Override
    public String toString(){ 
return "\n\nName = " + name + "\nCombatLevel = " + Integer.toString(combatLevel)+"\n\nBadStuff \n"+monBS+"\n\nPrize\n"+monPrize; 
      
} 
      
    public int getBasicValue(){
        return getcombatLevel();
        
    }
    
    public int getSpecialValue(){
        return getBasicValue()+levelChangeAgainstCultistPlayer;
        
    }
    
    public BadStuff getBS(){
        return monBS;
    }
      
    public Prize getPrize(){ 
        return monPrize; 
    } 
      
    public String getname(){ 
        return name; 
    } 
    public int getcombatLevel(){ 
        return combatLevel; 
    } 
      
    public boolean kills(){ 
          
        if (monBS.myBadStuffisDeath()) 
            return true; 
        else        
            return false; 
          
          
    } 
    
    public int getLevelsGained(){
        return monPrize.getLevel();
    }
    public int getTreasuresGained(){
        return monPrize.getTreasures();
    }
    
      
} 