/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Javi
 */
public class BadStuff {
    
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death; 
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    
    public BadStuff(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        specificHiddenTreasures.addAll(tVisible);
        specificVisibleTreasures.addAll(tHidden);
        
    }
            
            
    public BadStuff(String text, int levels, int nVisible, int nHidden){
        this.text = text;
        this.levels = levels;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
        
    }
    
    public BadStuff(String text, boolean death){
        this.text = text;
        this.death = death;
    }
    
   
    @Override
    public String toString(){
return "\n  Text = " + text + "\n   Levels = " + Integer.toString(levels) +"\n  VisibleTreasures = " + Integer.toString(nVisibleTreasures) +
        "\n HiddenTreasures = " + Integer.toString(nHiddenTreasures) + "\n  Death = " + death + "\n SpecificVisibleTreasures = " + specificHiddenTreasures +
        "\n SpecificHiddenTreasures" + specificVisibleTreasures;
}
    
    public String getText(){
        return text;
    }
    public int getLevels(){
        return levels;
    }
    public int getnVisible(){
        return nVisibleTreasures;
    }
    public void setnVisible(int n){
        nVisibleTreasures=n;
    }
    public int getnHidden(){
        return nHiddenTreasures;
    }
    public void setnHidden(int n){
        nHiddenTreasures=n;
    }
    public boolean getdeath(){
        return death;
    }
    
    public ArrayList<TreasureKind> getVT(){
        return specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getHT(){
        return specificHiddenTreasures;
    }
    
    public boolean isEmpty(){
    
         if (nVisibleTreasures==0 && nHiddenTreasures ==0 && specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty() ){
             return true;
         }
         else
             return false;
     }
     
     
     
     public void substractVisibleTreasure(Treasure t){
         if(this.nVisibleTreasures!=0){
             this.nVisibleTreasures = this.nVisibleTreasures-1;
         }
         else
             this.specificVisibleTreasures.remove(t.getType());
         
     }
     
     public void substractHiddenTreasure (Treasure t){
         if(this.nHiddenTreasures!=0){
             this.nHiddenTreasures = this.nHiddenTreasures-1;
         }
         else
             this.specificHiddenTreasures.remove(t.getType());
         
     }
     
     public BadStuff adjustToFitTreasureLists ( ArrayList<Treasure> vext, ArrayList<Treasure> hext){
         ArrayList<Treasure> v=new ArrayList();
         ArrayList<Treasure> h=new ArrayList();
         v.addAll(vext);
         h.addAll(hext);
         BadStuff miBS=this;
         //Si la perdida es solo Númerica
         if(this.nHiddenTreasures==-1){
             miBS.nHiddenTreasures=h.size();
             return miBS;
         }
         
         if(this.nVisibleTreasures==-1){
             miBS.nVisibleTreasures=v.size();
             return miBS;
         }
         if(this.nHiddenTreasures > 0 || this.nVisibleTreasures>0){
             if(this.nHiddenTreasures!=0){
                 if(h.size()<nHiddenTreasures){
                    miBS.nHiddenTreasures=h.size();
                    return miBS;
                 }
                 else
                     return miBS;
                 
                     
             }
             else{
                 if(v.size() < nVisibleTreasures){
                     miBS.nVisibleTreasures=v.size();
                     return miBS;
                     
                 }
                 else
                     return miBS;
                           
                 
             }
             
             
         }
         else{  //Si la perdida es de tipos de tesoro
             boolean control=true;
             
             if(!specificHiddenTreasures.isEmpty()){
                 for(int i=0; i < specificHiddenTreasures.size();i++){
                     control=true;
                     for(int j=0; j < h.size() && control;j++){
                         if(h.get(j).getType()==specificHiddenTreasures.get(i)){
                              h.remove(j);
                              control=false;
                         }
                     }
                     if(control){
                          miBS.specificHiddenTreasures.remove(i);
                          
                     }
                 
              }
             
             }
             
             
             if(!specificVisibleTreasures.isEmpty()){
                 for(int i=0; i < specificVisibleTreasures.size();i++){
                     control=true;
                     for(int j=0; j < v.size() && control;j++){
                         if(v.get(j).getType()==specificVisibleTreasures.get(i)){
                              v.remove(j);
                              control=false;
                         }
                     }
                     if(control){
                          miBS.specificVisibleTreasures.remove(i);
                          
                     }
                 
              }
             
             }
                 
             }
         
         return miBS;
             }
             
         
         
     
     
     public boolean myBadStuffisDeath(){
         if(death==true)
             return true;
         else
             return false;
     }
     
     
}
