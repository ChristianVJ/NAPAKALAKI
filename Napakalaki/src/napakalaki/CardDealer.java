/* 
 * To change this template, choose Tools | Templates 
 * and open the template in the editor. 
 */
package napakalaki; 
  
import java.util.ArrayList; 
import java.util.Collections; 
/** 
 * 
 * @author Christian 
 */
public class CardDealer { 
      
     
      
    private ArrayList<Monster> unusedMonsters = new ArrayList(); 
    private ArrayList<Monster> usedMonsters = new ArrayList(); 
    private ArrayList<Treasure> unusedTreasures = new ArrayList(); 
    private ArrayList<Treasure> usedTreasures = new ArrayList(); 
    private ArrayList<Cultist> unusedCultists = new ArrayList();
    private static final CardDealer instance = new CardDealer(); 
      
    private CardDealer(){ 
      
    } 
      
    public static CardDealer getInstance(){ 
        return instance; 
    } 
      
    private void initCultistCardDeck(){
        
        unusedCultists.add(new Cultist ("Sectario1",1));
        unusedCultists.add(new Cultist ("Sectario2",2));
        unusedCultists.add(new Cultist ("Sectario3",2));
        unusedCultists.add(new Cultist ("Sectario4",1));
        unusedCultists.add(new Cultist ("Sectario5",1));
        unusedCultists.add(new Cultist ("Sectario6",1));
        
        shuffleCultists();
        
    }
    
    private void shuffleCultists(){
        Collections.shuffle(unusedCultists);
    }
    
    public Cultist nextCultist(){
        Cultist next_cultist =  unusedCultists.get(unusedCultists.size()-1); 
        unusedMonsters.remove(unusedCultists.size()-1); 
        return next_cultist; 
    }
    
     private void initTreasureCardDeck(){ 
           
       TreasureKind tka=TreasureKind.armor; 
       TreasureKind tkb=TreasureKind.oneHand; 
       TreasureKind tkc=TreasureKind.bothHand; 
       TreasureKind tkd=TreasureKind.helmet; 
       TreasureKind tke=TreasureKind.shoe; 
       TreasureKind tkf=TreasureKind.necklace; 
         
        unusedTreasures.add(new Treasure ("Si mi amo.jpg", 0, 4, 7, tkd)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Botas de investigacion.jpg", 600, 3, 4, tke));      
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Capucha de Cthulhu.jpg", 500, 3, 5, tkd)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("A prueba de babas.jpg", 400, 2, 5, tka)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Botas de lluvia acida.jpg", 800, 1, 1, tkc)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Casco minero.jpg", 400, 2, 4, tkd)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Ametralladora Thompson.jpg", 600, 4, 8, tkc)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Camiseta de la UGR.jpg", 100, 1, 7, tka)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Clavo de rail ferroviario.jpg", 400, 3, 6, tkb)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Cuchillo de sushi arcano.jpg", 300, 2, 3, tkd)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Fezalopodo.jpg", 700, 3, 5, tkd)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Hacha prehistorica.jpg", 500, 2, 5, tkb)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("El aparato de Pr. Tesla.jpg", 900, 4, 8, tka)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Gaita.jpg", 800, 4, 5, tkc)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("insecticida.jpg", 300, 2, 3, tkb)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Escopeta de 3 canones.jpg", 700, 4, 6, tkc)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Garabato mistico.jpg", 300, 2, 2, tkb)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("La fuerza de Mr. T.jpg", 1000,0, 0, tkf )); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Rebeca metalica.jpg", 400, 2, 3, tka)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Mazo de los antiguos.jpg", 200, 3, 4, tkb)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Necroplayboycon.jpg", 300, 3, 5, tkb)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Lanzallamas.jpg", 800, 4, 8, tkc)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Necrocomicon.jpg", 100, 1, 1, tkb)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Necronomicon.jpg", 800, 5, 7, tkc)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Linterna a 2 manos.jpg", 400, 3, 6, tkc)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Necrognomicon.jpg", 200, 2, 4, tkb)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Necrotelecom.jpg", 300, 2, 3, tkd)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Porra preternatural.jpg", 200, 2, 3, tkb)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Tentaculo de pega.jpg", 200, 0, 1, tkd)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Zapato deja-amigos.jpg", 500, 0, 1, tke)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Shogulador.jpg", 600, 1, 1, tkc)); 
        //--------------------------------------------------------------------------------------- 
        unusedTreasures.add(new Treasure ("Varita de atizamiento.jpg", 400, 3, 4, tkb)); 
  
        shuffleTreasures();
        
    } 
      
     private void initMonsterCardDeck(){ 
           
       TreasureKind tka=TreasureKind.armor; 
       TreasureKind tkb=TreasureKind.oneHand; 
       TreasureKind tkc=TreasureKind.bothHand; 
       TreasureKind tkd=TreasureKind.helmet; 
       TreasureKind tke=TreasureKind.shoe; 
       TreasureKind tkf=TreasureKind.necklace; 
         
       ArrayList vt= new ArrayList<TreasureKind>(); 
       ArrayList ht= new ArrayList<TreasureKind>(); 
       ArrayList test= new ArrayList<TreasureKind>(); 
         
       //--------------------------------------------------------------------------------------- 
        vt.add(tka); 
        ht.add(tka); 
        BadStuff byak = new BadStuff("Pierdes tu armadura visible y otra oculta", 0, vt, ht); 
        Prize byak1 = new Prize(2,1); 
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, byak, byak1,0)); 
        vt.clear(); 
        ht.clear(); 
        //--------------------------------------------------------------------------------------- 
        vt.add(tkd); 
        BadStuff chi = new BadStuff("Embobados con el lindo primigenio te descartas de tu casco visible", 0, vt, ht ); 
        Prize chi1 = new Prize(1,1); 
        unusedMonsters.add(new Monster("Chibithulhu", 2, chi, chi1,0)); 
        vt.clear(); 
        //---------------------------------------------------------------------------------------   
        vt.add(tke); 
        BadStuff sopor = new BadStuff("El primordial bostezo contagioso. Pierdes el calzado visible", 0, vt, ht); 
        Prize sopor1 = new Prize(1,1); 
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, sopor, sopor1,0)); 
        vt.clear(); 
        //--------------------------------------------------------------------------------------- 
        vt.add(tkb); 
        ht.add(tke); 
        BadStuff angeles = new BadStuff("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0, vt, ht); 
        Prize angeles1 = new Prize(4,1); 
        unusedMonsters.add(new Monster("Angeles de la noche ibicenca", 14, angeles, angeles1,0)); 
        vt.clear(); 
        ht.clear(); 
        //--------------------------------------------------------------------------------------- 
        BadStuff gorron = new BadStuff("Pierdes todos tus tesoros visibles", 0, -1, 0); 
        Prize gorron1 = new Prize(3,1); 
        unusedMonsters.add(new Monster("El gorron en el umbral", 10, gorron, gorron1,0)); 
        //---------------------------------------------------------------------------------------       
        vt.add(tka); 
        BadStuff hp = new BadStuff("Pierdes la armadura visible", 0, vt, ht); 
        Prize hp1= new Prize(2,1); 
        unusedMonsters.add(new Monster("HP Munchcraft", 6, hp, hp1,0)); 
        vt.clear(); 
        //---------------------------------------------------------------------------------------         
        vt.add(tka); 
        BadStuff  bich = new BadStuff("Pierdes la armadura visible", 0, vt, ht); 
        Prize bich1 = new Prize(1,1); 
        unusedMonsters.add(new Monster("Bichgooth", 2, bich, bich1,0)); 
        vt.clear(); 
        //--------------------------------------------------------------------------------------- 
        Prize reyrosa = new Prize (4,2); 
        BadStuff reyrosa1 = new BadStuff ("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0); 
        unusedMonsters.add(new Monster("El rey de la rosa", 13, reyrosa1, reyrosa,0)); 
        //--------------------------------------------------------------------------------------- 
        Prize myprize = new Prize (1,1); 
        BadStuff mybs=new BadStuff("Toses los pulmones y pierdes 2 niveles", 2,0,0); 
        Monster myMonster=new Monster ("La que redacta en las tinieblas", 2, mybs, myprize,0); 
        unusedMonsters.add(myMonster); 
        //--------------------------------------------------------------------------------------- 
        Prize myprize2 = new Prize (2,1); 
        BadStuff mybs2=new BadStuff("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas Muerto", true); 
        Monster myMonster2=new Monster ("Los hondos", 8, mybs2, myprize2,0); 
        unusedMonsters.add(myMonster2); 
        //--------------------------------------------------------------------------------------- 
        Prize myprize3 = new Prize (2,1); 
        vt.add(tkc); 
        BadStuff mybs3=new BadStuff("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2,vt,ht); 
        Monster myMonster3=new Monster ("Roboggoth", 8, mybs3, myprize3,0); 
        unusedMonsters.add(myMonster3); 
        vt.clear(); 
        //--------------------------------------------------------------------------------------- 
        Prize myprize4 = new Prize (3,1); 
        BadStuff mybs4=new BadStuff("No le hace gracia que pronuncien mal su nombre. Estas muerto", true); 
        Monster myMonster4=new Monster ("Yskhtihyssg-Goth", 12, mybs4, myprize4,0); 
        unusedMonsters.add(myMonster4); 
        //--------------------------------------------------------------------------------------- 
        Prize myprize5 = new Prize (1,1); 
        BadStuff mybs5=new BadStuff("Da mucho asquito. Pierdes 3 niveles.", 3,0,0); 
        Monster myMonster5=new Monster ("Pollipolipo volante", 3, mybs5, myprize5,0); 
        unusedMonsters.add(myMonster5); 
        //--------------------------------------------------------------------------------------- 
        Prize myprize6 = new Prize (2,1); 
        BadStuff mybs6=new BadStuff("Pierdes 2 niveles y 2 tesoros ocultos.", 2,0,2); 
        Monster myMonster6=new Monster ("Semillas Cthulhu", 4, mybs6, myprize6,0); 
        unusedMonsters.add(myMonster6); 
        //--------------------------------------------------------------------------------------- 
        Prize myprize7 = new Prize (2,1); 
        vt.add(tkb); 
        BadStuff mybs7=new BadStuff("Te intentas escaquear. Pierdes una mano visible", 0,vt,ht); 
        Monster myMonster7=new Monster ("Dameargo", 1, mybs7, myprize7,0); 
        unusedMonsters.add(myMonster7); 
        vt.clear(); 
        //--------------------------------------------------------------------------------------- 
        Prize myprize8 = new Prize (4,1); 
        BadStuff mybs8=new BadStuff("La familia te atrapa. Estas Muerto",true); 
        Monster myMonster8=new Monster ("Familia feliz", 1, mybs8, myprize8,0); 
        unusedMonsters.add(myMonster8); 
        //--------------------------------------------------------------------------------------- 
        Prize myprize9 = new Prize (1,1); 
        BadStuff mybs9=new BadStuff("Pierdes 2 niveles y 5 tesoros visibles.", 2,5,0); 
        Monster myMonster9=new Monster ("El lenguas", 20, mybs9, myprize9,0); 
        unusedMonsters.add(myMonster9); 
        //--------------------------------------------------------------------------------------- 
        vt.add(tkb); 
        vt.add(tkc); 
        vt.add(tkb); 
        Prize myprize10 = new Prize (1,1); 
        BadStuff mybs10=new BadStuff("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3,vt,ht); 
        Monster myMonster10=new Monster ("Bicefalo", 20, mybs10, myprize10,0); 
        unusedMonsters.add(myMonster10); 
        vt.clear(); 
        //--------------------------------------------------------------------------------------- 
         vt.add(tkb); 
        Prize myprize11 = new Prize (3,1); 
        BadStuff mybs11=new BadStuff("Pierdes una mano visible", 0,vt,ht); 
        Monster myMonster11=new Monster ("El mal indecible impronunciable", 10, mybs11, myprize11,-2); 
        unusedMonsters.add(myMonster11); 
        //--------------------------------------------------------------------------------------- 
        Prize myprize12 = new Prize (2,1); 
        BadStuff mybs12=new BadStuff("Pierdes tus tesoros visibles. JaJaJa", 0,-1,0); 
        Monster myMonster12=new Monster ("Testigos oculares", 6, mybs12, myprize12,2); 
        unusedMonsters.add(myMonster12); 
        //--------------------------------------------------------------------------------------- 
        Prize myprize13 = new Prize (2,5); 
        BadStuff mybs13=new BadStuff("Hoy no es tu dia de suerte. Mueres.", true); 
        Monster myMonster13=new Monster ("El gran cthulhu", 20, mybs13, myprize13,4); 
        unusedMonsters.add(myMonster13); 
        //--------------------------------------------------------------------------------------- 
        Prize myprize14 = new Prize (2,1); 
        BadStuff mybs14=new BadStuff("Tu gobierno te recorta 2 niveles.", 2,0,0); 
        Monster myMonster14=new Monster ("Serpiente politico", 8, mybs14, myprize14,-2); 
        unusedMonsters.add(myMonster14); 
        //--------------------------------------------------------------------------------------- 
        vt.add(tkd);
        vt.add(tka);
        ht.add(tkb); 
        ht.add(tkc); 
        ht.add(tkb); 
        Prize myprize15 = new Prize (1,1); 
        BadStuff mybs15=new BadStuff("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.", 2,vt,ht); 
        Monster myMonster15=new Monster ("Felpuggoth", 2, mybs15, myprize15,5); 
        unusedMonsters.add(myMonster15); 
        //---------------------------------------------------------------------------------------  
        Prize myprize16 = new Prize (4,2); 
        BadStuff mybs16=new BadStuff("Pierdes dos niveles.", 2,0,0); 
        Monster myMonster16=new Monster ("Shoggoth", 16, mybs16, myprize16,-4); 
        unusedMonsters.add(myMonster16); 
        //---------------------------------------------------------------------------------------  
        Prize myprize17 = new Prize (1,1); 
        BadStuff mybs17=new BadStuff("Pintalabios negro. Pierdes dos niveles.", 2,0,0); 
        Monster myMonster17=new Monster ("Lolitagooth", 2, mybs17, myprize17,3); 
        unusedMonsters.add(myMonster17);  
           
        
        shuffleMonsters(); 
        
    
     } 
     
     public void initCards(){
         initMonsterCardDeck();
         initTreasureCardDeck();
         initCultistCardDeck();
     }
       
     private void shuffleTreasures(){ 
          Collections.shuffle(unusedTreasures); 
     } 
       
     private void shuffleMonsters(){ 
          Collections.shuffle(unusedMonsters); 
     } 
       
     public Treasure nextTreasure(){ 
           
        if (unusedTreasures.isEmpty())  
        { 
            unusedTreasures.addAll(usedTreasures);  
            usedTreasures.clear(); 
            Collections.shuffle(unusedTreasures); 
        } 
        Treasure next_treasure = unusedTreasures.get(unusedTreasures.size()-1); 
        unusedTreasures.remove(next_treasure); 
        return next_treasure; 
     }           
     
     
       
     public Monster nextMonster(){ 
           
         if (unusedMonsters.isEmpty())  
        { 
            unusedMonsters = new ArrayList(usedMonsters);  
            usedMonsters.clear(); 
            Collections.shuffle(unusedMonsters); 
        } 
        Monster next_monster =  unusedMonsters.get(unusedMonsters.size()-1); 
        unusedMonsters.remove(next_monster); 
        return next_monster; 
       
           
     } 
       
     public void giveTreasureBack(Treasure t){ 
         usedTreasures.add(t); 
           
     } 
  
     public void giveMonsterBack(Monster m){ 
         usedMonsters.add(m); 
     } 
      
       
} 