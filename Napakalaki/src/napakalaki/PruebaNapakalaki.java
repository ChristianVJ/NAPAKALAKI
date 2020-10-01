/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;


import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 *
 * @author Javi
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));  //ASI SE INICIALIZA UNA VARIABLE PARA LECTURA DE FLUJO
        
        
        //System.out.println("Así se escribe una linea por pantalla");
        //int lev = Integer.parseInt(in.readLine());  //ASI SE LEE UN DATO POR TECLADO
        
        
        
//--------------------------------------------MAIN------------------------------------------
        
        ArrayList<Treasure> sht=new ArrayList();
        ArrayList<String> thv=new ArrayList();
        boolean control=true;
        Player miplayer;
        ArrayList<Treasure> mvt= new ArrayList();
        ArrayList<Treasure> mht= new ArrayList();
        ArrayList<String> tesorosch= new ArrayList();
       
        //Ini dealer
        CardDealer dealer= CardDealer.getInstance();
        //ini napakalaki
        Napakalaki napakalakiModel = Napakalaki.getInstance();
        //Leer numero de jugadores
        NapakalakiView napakalakiView = new NapakalakiView();
        Dice.createInstance (napakalakiView);
        
        ArrayList<String> names = new ArrayList();
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView,true);
        names = namesCapture.getNames();
        
        
        
         
        
        
        //initGame()
        napakalakiModel.initGame(names);
        napakalakiView.setNapakalaki(napakalakiModel);
        napakalakiView.showView();
        //nextTurn()
        /*
        while (control){
           // napakalakiModel.nextTurn();
            
            //Imprimir datos del jugador actual
            System.out.println(napakalakiModel.getCurrentPlayer());
            
        
        
        //Preguntar al Jugador si quiere comprar niveles
            System.out.println("\nDeseas vender alguno de tus tesoros? (si o no)\n");
            String opt=in.readLine();
            if (opt.equals("si")){
                System.out.println("Cuantos tesoros desea vender?\n");
                int numtr = Integer.parseInt(in.readLine());
                for(int i =1; i <=numtr;i++){
                    System.out.println("Tesoro número "+i);
                    String treas=in.readLine();
                    tesorosch.add(treas);
                }
                //miplayer=napakalakiModel.getCurrentPlayer();
                mvt.addAll(napakalakiModel.getCurrentPlayer().getVST(tesorosch));
                mht.addAll(napakalakiModel.getCurrentPlayer().getHST(tesorosch));
                napakalakiModel.buyLevels(mvt, mht);
            }
        
            //miplayer=napakalakiModel.getCurrentPlayer();
        //NO: 
        //Mostrar el nivel de combate actualizado del jugador
            System.out.println("\n    Nivel actual de combate; "+napakalakiModel.getCurrentPlayer().getCombatLevel()+"\n\n");
        //Imprimir datos del Monstruo actual
            System.out.println(napakalakiModel.getCurrentMonster());
            
                               
                    
                    
                    
        CombatResult micr = napakalakiModel.developCombat(); 
        
        if(micr==CombatResult.WinAndWinGame){
        control=false;
        System.out.println("\n¡¡¡ Congratulations "+napakalakiModel.getCurrentPlayer().getName()+" has ganado la partida !!!!");      
        }
        
        //SI: endOfGame(combatResult)==WinAndWinGame
        //Imprimir "Game Over"
        //Imprimir la informacion del jugador actual
        
        //SI: endOfGame(combatResult)==Win
        if(micr==CombatResult.Win){
           System.out.println(napakalakiModel.getCurrentPlayer()); 
           System.out.println("\nDesea cambiarse algun tesoro de oculto a visible? (si o no):\n ");
           String hv=in.readLine();
           if(hv.equals("si")){
               System.out.println("\nCuantos tesoros quiere cambiar?");
               int nh = Integer.parseInt(in.readLine());
           
           for(int i =1; i<=nh;i++){
               System.out.println("Tesoro numero "+i+" :\n");
               String tes=in.readLine();
               thv.add(tes);
           }
           //miplayer=napakalakiModel.getCurrentPlayer();
           sht.addAll(napakalakiModel.getCurrentPlayer().getHST(thv));
           napakalakiModel.makeTreasuresVisible(sht);
           sht.clear();
           
        
               }
               
               }
           
        
        //Ir a nextTurn()
        //SI: endOfGame(combatResult)==LoseAndDie
        if(micr==CombatResult.LoseAndDie){
        
        }
        //Imprimir "Has muerto NOOB"
        //Ir a nextTurn()
        //SI: endOfGame(combatResult)==Lose
        if(micr==CombatResult.Lose){
            
            
            
            System.out.println(napakalakiModel.getCurrentPlayer());
           //napa.getCurrentPlayer().payBS();
           System.out.println("\nDesea cambiarse algun tesoro de oculto a visible? (si o no):\n ");
           String hv=in.readLine();
           if(hv.equals("si")){
               System.out.println("\nCuantos tesoros quiere cambiar?");
               int nh = Integer.parseInt(in.readLine());
           
           for(int i =1; i<=nh;i++){
               System.out.println("Tesoro numero "+i+" :\n");
               String tes=in.readLine();
               thv.add(tes);
           }
           //miplayer=napakalakiModel.getCurrentPlayer();
           sht.addAll(napakalakiModel.getCurrentPlayer().getHST(thv));
           napakalakiModel.makeTreasuresVisible(sht);
           sht.clear();
        
               }
        
        }
        
        if(micr==CombatResult.LoseAndConvert){
            
            
            
            System.out.println(napakalakiModel.getCurrentPlayer());
           //napa.getCurrentPlayer().payBS();
           System.out.println("\nDesea cambiarse algun tesoro de oculto a visible? (si o no):\n ");
           String hv=in.readLine();
           if(hv.equals("si")){
               System.out.println("\nCuantos tesoros quiere cambiar?");
               int nh = Integer.parseInt(in.readLine());
           
           for(int i =1; i<=nh;i++){
               System.out.println("Tesoro numero "+i+" :\n");
               String tes=in.readLine();
               thv.add(tes);
           }
           //miplayer=napakalakiModel.getCurrentPlayer();
           sht.addAll(napakalakiModel.getCurrentPlayer().getHST(thv));
           napakalakiModel.makeTreasuresVisible(sht);
           sht.clear();
        
               }
        
        }
        //Imprimir "Has perdido contra el Monstruo...pero no vas a morir aún"
        //discardNecklaceVisible()
        //Ir a nextTurn()
        //SI: endOfGame(combatResult)==LoseAndEscape
        if(micr==CombatResult.LoseAndEscape){
            
            System.out.println(napakalakiModel.getCurrentPlayer()); 
           System.out.println("\nDesea cambiarse algun tesoro de oculto a visible? (si o no):\n ");
           String hv=in.readLine();
           if(hv.equals("si")){
               System.out.println("\nCuantos tesoros quiere cambiar?");
               int nh = Integer.parseInt(in.readLine());
           
           for(int i =1; i<=nh;i++){
               System.out.println("Tesoro numero "+i+" :\n");
               String tes=in.readLine();
               thv.add(tes);
           }
           //miplayer=napakalakiModel.getCurrentPlayer();
           sht.addAll(napakalakiModel.getCurrentPlayer().getHST(thv));
           napakalakiModel.makeTreasuresVisible(sht);
           sht.clear();
        
               }
        
        }
        //Imprimir "Ese Monstruo era mucho para ti...corre niñita...corre"
        //discardNecklaceVisible()
        //Ir a nextT>urn()
        }
        //FIN
        
//--------------------------------------------FIN DEL MAIN------------------------------------------
            
         //System.out.println(myprize.getTreasures());
        //System.out.println(myprize.getLevel());
        
        
        
        
        
        //BadStuff mybs=new BadStuff("You feel cold like in a eternal winter...", 2,vt,ht);
        //Creacion de un Monster
        //Monster myMonster=new Monster ("Frost Warrior", 5, mybs, myprize);
        
       // System.out.println (myMonster);
        
        */
    }
}
