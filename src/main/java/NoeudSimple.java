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
    
    //tableau contenant tous les NoeudSimples créés
    private static NoeudSimple [] ListeNoeudSimple = new NoeudSimple [255];
    
    //constructeur
    //crée un Noeud à partir de 2 coordonnées et d'un Terrain
    public NoeudSimple(Terrain T, double abs, double ord){
        boolean DansUnTT = false;
        Point P = new Point(abs, ord);
        TriangleTerrain TTi = new TriangleTerrain();
        
        //la variable DansUnTT devient TRUE lorsque P est compris dans un des TriangleTerrain créés
        int i =0;
        //on cherche si le point est compris dans au moins un des TriangleTerrain du Terrain
        while(i<T.TailleListeTriangle()){
            TTi = T.chercherTT(i);
            if(TTi==null){
                i=T.TailleListeTriangle();
            } else if(TTi.Comprend(P)==true){
                DansUnTT = true;
                i=T.TailleListeTriangle();
            }
            i++;
        }
        
        //on vérifie que le noeud est compris dans le Terrain mais pas dans un TrianleTerrain
        if((abs<T.getXMIN())||(abs>T.getXMAX())){
            throw new Error("Le noeud n'est pas compris dans le Terrain");
        } else if ((ord<T.getYMIN())||(ord>T.getYMAX())){
            throw new Error("Le noeud n'est pas compris dans le Terrain");
        } else if (DansUnTT==true){
           throw new Error("Le noeud est compris dans un TriangleTerrain");
        } else {
          this.abs=abs;
          this.ord=ord;
          ListeNoeudSimple [this.getIdent()] = this;
        }
        
    }
    
    
    //affichage
    public String toString(){
        String res = "Noeud "+this.getIdent()+" : ("+abs+";"+ord+")";
        return res;
    }
    
    //renvoie l'Appui associé à l'identificateur indiqué
    public static NoeudSimple donneNoeudSimple(int ident){
        return ListeNoeudSimple[ident];
    }
    
    
    //tester classe NoeudSimple
    public static void main (String[] args){
        
        Terrain T = new Terrain(-1,1,-1,1);
        T.ajoutTT(new Point(-1,-1), new Point(1,-1), new Point(-1,1));
        
        NoeudSimple NS3 = new NoeudSimple(T,0.5,0.5);
        System.out.println(NS3);
        

        NoeudSimple NS = new NoeudSimple(T,0,0);
        System.out.println(NS);
        NoeudSimple NS1 = new NoeudSimple(T,-1,0);
        System.out.println(NS1);
        NoeudSimple NS2 = new NoeudSimple(T,0,1);
        System.out.println(NS2);
        
    }
}
