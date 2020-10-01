package napakalaki;  
    
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;  
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
    
/*  
 * To change this license header, choose License Headers in Project Properties.  
 * To change this template file, choose Tools | Templates  
 * and open the template in the editor.  
 */
    
/**  
 *  
 * @author Miguel Keane  
 */
public class Player {  
    private boolean dead=true;  
    private String name;  
    private int level=1; 
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();  
    private ArrayList<Treasure> visibleTreasures = new ArrayList();  
    private BadStuff pendingBadStuff= new BadStuff("",false);  
    private Object in;
        
    Player(String nombre){  
        name=nombre;  
    }  
    
    public Player(Player p){ //Constructor de copia
        name=p.name;
        dead=p.dead;
        level=p.level;
        hiddenTreasures.addAll(p.hiddenTreasures);
        visibleTreasures.addAll(p.visibleTreasures);
        pendingBadStuff=p.pendingBadStuff;       
    }
    
    public int getOponentLevel(Monster m){
        return m.getBasicValue();
    }
    
    public int getLevel(){
        return level;
    }
      
    @Override
    public String toString(){ 
    return "\n\nName = " + name + "\nLevel = " + Integer.toString(level)+"\n\n  Visible Treasures"+visibleTreasures+"\n\n   Hidden Treasures"+hiddenTreasures; 
      
} 
        
    public boolean shouldConvert(){
        Dice dado = Dice.getInstance();
        if (dado.nextNumber()==6)
            return true;
        else
            return false;    
    }
    
    public String getName(){
         return name;
    }
    
    
    public ArrayList<Treasure> getVST(ArrayList<String> st){
        ArrayList<Treasure> tr = new ArrayList();
        for(int a=0; a<st.size(); a++){
        
        for(int j=0; j < visibleTreasures.size(); j++){
            if((visibleTreasures.get(j).getName()).equals(st.get(a))){
                tr.add(visibleTreasures.get(j));
            }
                
        }
        }
        
        return tr;
    }
    
    public ArrayList<Treasure> getHST(ArrayList<String> st){
        ArrayList<Treasure> tr = new ArrayList();
        for(int a=0; a<st.size(); a++){
        for(int i=0; i < hiddenTreasures.size(); i++){
            if((hiddenTreasures.get(i).getName()).equals(st.get(a))){
                tr.add(hiddenTreasures.get(i));
            }
                
        }
        
        }
        
        return tr;
    }
    
    
    public boolean isDead(){  
          return dead; 
    }  
    
    public void setLevel(int a){
        level=a;
    }
        
    public int getCombatLevel(){  
        int lev=this.level; 
        boolean neck=false; 
        for (int i=0; i<visibleTreasures.size(); i++) 
            if (howManyVisibleTreasures(TreasureKind.necklace)>=1) {
                neck=true; 
            }
        if (neck==true) {
            for (int i=0; i<visibleTreasures.size(); i++) 
                lev=lev+visibleTreasures.get(i).getMaxBonus(); 
        }
        else{
            for (int i=0; i<visibleTreasures.size(); i++) 
                lev=lev+visibleTreasures.get(i).getMinBonus(); 
        }
        return lev; 
               
    }  
        
    public ArrayList<Treasure> getVisibleTreasures(){  
        return visibleTreasures;  
    }  
        
    public ArrayList<Treasure> getHiddenTreasures(){  
        return hiddenTreasures;  
    }  
        
    private void bringToLife(){  
        dead=false; 
    }  
        
    private void incrementLevels(int l){  
        level=level+l; 
           
    }  
        
    private void decrementLevels (int l){  
        if(l>=level)
            level=1;
        else
            level=level-l;
    }  
        
    private void setPendingBadStuff(BadStuff b){  
        pendingBadStuff=b; 
    }  
        
    private void die(){  
        setLevel(1);
        CardDealer dealer= CardDealer.getInstance();
        Iterator<Treasure> viter = visibleTreasures.iterator();
        Iterator<Treasure> hiter = hiddenTreasures.iterator();
        for (int i =0; i <visibleTreasures.size(); i++){
           
            dealer.giveTreasureBack(viter.next());
        }
        visibleTreasures.clear();
        for (int i =0; i <hiddenTreasures.size(); i++){
            
            dealer.giveTreasureBack(hiter.next());
        }
        hiddenTreasures.clear();
        dieIfNoTreasures();
        
            
    }  
        
    private void discardNecklaceIfVisible(){  
        for (int i=0; i<visibleTreasures.size(); i++) 
            if ((visibleTreasures.get(i)).getType()==TreasureKind.necklace){ 
                CardDealer dealer= CardDealer.getInstance();
                dealer.giveTreasureBack(visibleTreasures.get(i));   // Estรก mal, pero no se que objeto de CardDealer tengo que llamar  
                visibleTreasures.remove(i); 
                  
            } 
                          
    }  
        
    private void dieIfNoTreasures(){  
          if (hiddenTreasures.isEmpty() && visibleTreasures.isEmpty() ) 
                dead=true; 
    }  
        
    private int computeGoldCoinsValue (ArrayList<Treasure> t){  
        int gold=0; 
        for(int i=0; i<t.size();i++){ 
            gold=gold + (t.get(i)).getGoldCoins(); 
        } 
        int l=gold/1000; 
        return l; 
    }  
        
    private boolean canIBuyLevels(int l){  
          if((level+l)<10) 
              return true; 
          else
              return false; 
            
                
    }  
        
    private void applyPrize(Monster m){  
        int nLevels = m.getLevelsGained();
        this.incrementLevels(nLevels);
        int nTreasures = m.getTreasuresGained();
        if (nTreasures > 0){
           CardDealer dealer=CardDealer.getInstance();
           Treasure mitesoro;
           for(int i =0; i<nTreasures;i++){
               mitesoro=dealer.nextTreasure();
               hiddenTreasures.add(mitesoro);
           }
        } 
    }  
        
    public CombatResult combat(Monster m){  
        CombatResult mycr;
        int myLevel = this.getCombatLevel();
        int monsterLevel= this.getOponentLevel(m);
        if(myLevel > monsterLevel){
            System.out.println("\nHas vencido al Monstruo !!!\n");
            this.applyPrize(m);
            if(level>=10){
                mycr =CombatResult.WinAndWinGame;
            }
            else
                mycr =CombatResult.Win;
            
        }
        
        else{
            System.out.println("\nHas perdido contra el Monstruo !!!!");
            Dice dice=Dice.getInstance();
            int escape = dice.nextNumber();
            if(escape < 5){
                boolean amIDead=m.kills();
                if(amIDead){
                    System.out.println("\nY MUERES !!!!");
                    die();
                    mycr =CombatResult.LoseAndDie;
                }
                else{
                    System.out.println("\nY padeces el Bad Stuff");
                    BadStuff bad= m.getBS();
                    mycr =CombatResult.Lose;
                    applyBadStuff(m.getBS());
                    if(shouldConvert()){
                        System.out.println("\nTe has convertido en Sectario !!");
                        mycr = CombatResult.LoseAndConvert;
                    }
                }
                
            }
            else{
                System.out.println("\nHas escapado por los pelos...corre niñita...corre");
                mycr = CombatResult.LoseAndEscape;
            }
        }
        discardNecklaceIfVisible();
        return mycr;    
    }  
        
    private void applyBadStuff (BadStuff bad){  
        
        int nLevels=bad.getLevels();
        this.decrementLevels(nLevels);
        bad.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadStuff(bad);
    }  
    

        
    public void makeTreasureVisible(Treasure t){   
            boolean canI=canMakeTreasureVisible(t);
            
	    if(canI){
                visibleTreasures.add(t);
                hiddenTreasures.remove(t);
            }
            
} 
        
    private boolean canMakeTreasureVisible (Treasure t){ 
        
            boolean control=false;
          if (t.getType()!=TreasureKind.bothHand && t.getType()!=TreasureKind.oneHand){      
              if(howManyVisibleTreasures(t.getType())==0)
                   control=true;
          }
          if (t.getType()==TreasureKind.bothHand){
              if(howManyVisibleTreasures(t.getType())==0 && howManyVisibleTreasures(TreasureKind.oneHand)==0)
                   control=true;
          }
          if (t.getType()==TreasureKind.oneHand){
              if(howManyVisibleTreasures(t.getType())<2 && howManyVisibleTreasures(TreasureKind.bothHand)==0)
                   control=true;
          }
          
           return control;
            
    }  
      
    private int howManyVisibleTreasures(TreasureKind tKind){ 
        int cont=0; 
        for(int i=0; i<visibleTreasures.size(); i++){ 
            if(visibleTreasures.get(i).getType()==tKind) 
                cont++; 
        } 
        return cont;         
    } 
      
    public void discardVisibleTreasure(Treasure t){  
            
        visibleTreasures.remove(t);
        if(!(pendingBadStuff.isEmpty())){
            pendingBadStuff.substractVisibleTreasure(t);
            
        }
        dieIfNoTreasures();
    }  
        
    public void discardHiddenTreasure(Treasure t){  
           
        hiddenTreasures.remove(t);
        if(pendingBadStuff!=null && !(pendingBadStuff.isEmpty())){
            pendingBadStuff.substractHiddenTreasure(t);
            
        }
        dieIfNoTreasures();
    }  
        
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){  
        int levelsMayBought = this.computeGoldCoinsValue(visible);
        levelsMayBought =levelsMayBought + this.computeGoldCoinsValue(hidden);
        boolean canl = this.canIBuyLevels (levelsMayBought);
        if(canl){
            this.incrementLevels(levelsMayBought);
        }
        visibleTreasures.removeAll(visible);
        hiddenTreasures.removeAll(hidden);
        CardDealer dealer= CardDealer.getInstance();
        Iterator<Treasure> viter = visible.iterator();
        Iterator<Treasure> hiter = hidden.iterator();
        for (int i =0; i <visible.size(); i++){
            Treasure mitesoro=viter.next();
            dealer.giveTreasureBack(mitesoro);
        }
        
        for (int i =0; i <hidden.size(); i++){
            Treasure mitesoro=hiter.next();
            dealer.giveTreasureBack(mitesoro);
        }
        
        
        return canl;
            
    }  
        
    public boolean validState(){
        
          if(hiddenTreasures.size()<=4 && pendingBadStuff.isEmpty()) {
              
              return true; 
          }
          else{
              
              return false;
          }
              
    }  
        
    public void initTreasures(){  
          CardDealer dealer = CardDealer.getInstance();
          Dice dice=Dice.getInstance();
          bringToLife();
          
          Treasure t= dealer.nextTreasure();
          hiddenTreasures.add(t);
          int number= dice.nextNumber();
          
          if(number>1){
              t=dealer.nextTreasure();
              hiddenTreasures.add(t);
          }
          
          if(number==6){
                t=dealer.nextTreasure();
                hiddenTreasures.add(t);
          }

            
    }  
        
    public boolean hasVisibleTreasures(){  
          if (getVisibleTreasures().isEmpty()) 
              return false; 
          else
              return true; 
            
    }  
        
    
      
      
        
        
        
}  
