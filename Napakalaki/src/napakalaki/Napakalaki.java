/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import GUI.NapakalakiView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author Javi
 */
public class Napakalaki {
    
    private Monster currentMonster;
    private CardDealer dealer= CardDealer.getInstance();
    private Player currentPlayer;
    private ArrayList<Player> players;
    
    private static final Napakalaki instance = new Napakalaki();
    
    private Napakalaki(){
    
    }
    
    public static Napakalaki getInstance(){
        return instance;
    }
    
    private void initPlayers (ArrayList<String> names){
        
        players = new ArrayList<Player>();
        for (int i =0; i<names.size(); i++){
            Player aux= new Player(names.get(i));
            players.add(aux);
            }
    }
    
    private Player nextPlayer(){
        
        if(currentPlayer==null){
            Random ran = new Random();
            int x = ran.nextInt(players.size());
            currentPlayer=players.get(x);
            return currentPlayer;
        }
        else{
            if ((players.size()-1) == players.indexOf(currentPlayer)){
                currentPlayer=players.get(0);
                return currentPlayer;
            }
            else{
                currentPlayer=players.get(players.indexOf(currentPlayer)+1);
                return currentPlayer;
            }
        }    
        
    }
    
    public CombatResult developCombat(){
        CombatResult micr=currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        if(micr==CombatResult.LoseAndConvert){
            CardDealer dealer = CardDealer.getInstance();
            Cultist cardcul=dealer.nextCultist();
            CultistPlayer micultist = new CultistPlayer(currentPlayer,cardcul);
            players.remove(currentPlayer);
            players.add(micultist);
            currentPlayer=micultist;
            
        }
        return micr;
        
        
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        Iterator<Treasure> iter= treasures.iterator();
        for (int i = 1; i <= treasures.size(); i++){
            Treasure t=iter.next();
            currentPlayer.discardVisibleTreasure(t);
            dealer.giveTreasureBack(t);
            
         }
            
            
            
            
            
        
    }
    
    public void discardHiddenTreasures (ArrayList<Treasure> treasures){
        Iterator<Treasure> iter= treasures.iterator();
        for (int i = 1; i <= treasures.size(); i++){
            Treasure t=iter.next();
            currentPlayer.discardHiddenTreasure(t);
            dealer.giveTreasureBack(t);
            
         }
    }
    
    public void makeTreasuresVisible (ArrayList<Treasure> treasures){ 
          Treasure t;

          for (int i=0; i<treasures.size(); i++){   
              t=treasures.get(i);
              currentPlayer.makeTreasureVisible(t);
          }
} 





    
    public boolean buyLevels (ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        boolean canl = currentPlayer.buyLevels(visible, hidden);
        return canl;
    }
    
    public void initGame(ArrayList<String> players){
        
        //Inicializar los Players
        this.initPlayers(players);
        currentPlayer = this.nextPlayer();
        
        
        
        //Inicializar los Decks (de monstruos y de tesoros)
        dealer.initCards();
       // NapakalakiView napakalakiView = new NapakalakiView();
        //napakalakiView.showView();
        //Iniciar el primer turno
        nextTurn();
        
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
        
    }
    
    public void printPlayer(){
        System.out.println(currentPlayer);
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
        
    }
    
    
    
    public boolean nextTurn(){
        boolean stateOK;
        stateOK=nextTurnAllowed();
        
        currentPlayer.validState();
        if (stateOK){
            currentMonster=dealer.nextMonster();
            currentPlayer=this.nextPlayer();
            boolean dead= currentPlayer.isDead();
            if(dead){
                currentPlayer.initTreasures();
            }
        }
        
            return stateOK;
        
    }
    
    public boolean nextTurnAllowed(){
        
        if (currentPlayer.validState()){
            
            return true;
        }
        else
            
            return false;
        
    }
    
    public boolean endOfGame(CombatResult result){
        if (result == CombatResult.WinAndWinGame){
            return true;
                    }
        else 
            return false;
            
        
        
    }
    
    
}
