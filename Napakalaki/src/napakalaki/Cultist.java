/* 
 * To change this template, choose Tools | Templates 
 * and open the template in the editor. 
 */
package napakalaki; 
  
/** 
 * 
 * @author Christian 
 */
public class Cultist implements Card{ 
      
    private String name; 
    private int gainedLevels; 
      
    public Cultist (String name, int gainedLevels){ 
        this.name = name; 
        this.gainedLevels = gainedLevels; 
    } 
      
    public String getName(){ 
        return name; 
    } 
      
    public int getBasicValue(){ 
        return gainedLevels; 
    } 
      
    public int getSpecialValue(){ 
        return getBasicValue()*CultistPlayer.getTotalCultistPlayers(); 
    } 
} 


