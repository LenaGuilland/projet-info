/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sofie
 */
public class NoeudSimple extends Noeud {
    private double abs;
    private double ord;
    
    
    //constructeur
    //crée un Noeud nul
    public NoeudSimple(){
        this.abs=0;
        this.ord=0;
    }
    
    //crée un Noeud à partir de 2 coordonnées et d'un Terrain
    public NoeudSimple(Terrain T, double abs, double ord){
        boolean DansUnTT = false;
        Point P = new Point(abs, ord);
        TriangleTerrain TTi = new TriangleTerrain();
        
        //la variable DansUnTT devient true lorsque P est compris dans un des TriangleTerrain créés
        int i =0;
        while(i<256){
            TTi = TriangleTerrain.chercherTT(i);
            if(TTi.Comprend(P)==true){
                DansUnTT = true;
                i=256;
            }
            i++;
        }
        
        //on vérifie que le noeud est compris dans le Terrain mais pas dans un TrianleTerrain
        if((abs<T.getXMIN())||(abs>T.getXMAX())){
            throw new Error("Le noeud n'est pas compris dans le Terrain");
        } else if ((ord<T.getYMIN())||(ord>T.getYMAX())){
            throw new Error("Le noeud n'est pas compris dans le Terrain");
        } else if (DansUnTT==true){
           throw new Error("Le noeud n'est pas compris dans un TriangleTerrain");
        } else {
          this.abs=abs;
          this.ord=ord; 
        }
        
    }
    
    
    //affichage
    public String toString(){
        String res = "Point "+this.getIdent()+" : ("+abs+";"+ord+")";
        return res;
    }
    
    //tester classe NoeudSimple
    public static void main (String[] args){
        NoeudSimple NS = new NoeudSimple();
        System.out.println(NS);
        NoeudSimple NS1 = new NoeudSimple();
        System.out.println(NS1);
        NoeudSimple NS2 = new NoeudSimple();
        System.out.println(NS2);
        
        System.out.println(" ");
        System.out.println(" ");
        Terrain T = new Terrain(-100,100,-100,100);
        NoeudSimple NS3 = new NoeudSimple(T,-18,42);
        System.out.println(NS3);
    }
}
