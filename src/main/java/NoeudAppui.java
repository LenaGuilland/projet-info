


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sofie
 */
public class NoeudAppui extends Noeud {
    private TriangleTerrain TTi;
    private int j; //numéro du premier point du segment de terrain sur lequel se trouve le noeud appui
    private double α; //position de l'appui sur le segment de terrain
    
    //tableau contenant tous les NoeudAppuis créés
    private static NoeudAppui [] ListeNoeudAppui = new NoeudAppui [255];
    
    //tableau contenant tous les NoeudSimples associés aux NoeudAppuis créés
    private static NoeudSimple [] ListeNoeudSimple = new NoeudSimple [255];
    
    //constructeur
    //crée un NoeudAppui dont on connait tous les paramètres
    public NoeudAppui (Terrain T, TriangleTerrain TT, int j, double α){
        TTi = TT;
        //j ne peut avoir comme valeur que 0, 1 et 2
        //i doit être compris au sens large entre 0 et 1
        if((j<0)||(j>=3)){
            throw new Error("la valeur de l'indice j n'est pas valide");
        } else if ((α<0)||(α>1)){
            throw new Error("la valeur de l'indice α n'est pas valide");
        } else {
           this.j= j;
           this.α= α; 
           ListeNoeudAppui [this.getIdent()] = this;
           ListeNoeudSimple [this.getIdent()] = new NoeudSimple(T,this.absAppui(),this.ordAppui());
        }
    }
    
    //crée un NoeudAppui et son TriangleTerrain associé
    public NoeudAppui(Terrain T, Point PT1, Point PT2, Point PT3, int j, double α){
        this(T, new TriangleTerrain(PT1,PT2,PT3), j, α);
    }
    
    
    
    
    //renvoie le numéro du point suivant sur le segment
    public static int numeroSuivant(int j){
        return (j+1)%3;
    }
    
    //renvoie l'abscisse de l'appui
    public double absAppui(){
        //récupère le point de départ du segment
        Point PTij = new Point(TriangleTerrain.chercherPTdeTT(j, TTi));
        //récupère le point d'arrivée du segment
        Point PTik = new Point(TriangleTerrain.chercherPTdeTT(numeroSuivant(j), TTi));
        
        return α*PTij.getAbs()+(1-α)*PTik.getAbs();
    }
    
    //renvoie l'ordonnée de l'appui
    public double ordAppui(){
        //récupère le point de départ du segment
        Point PTij = new Point(TriangleTerrain.chercherPTdeTT(j, TTi));
        //récupère le point d'arrivée du segment
        Point PTik = new Point(TriangleTerrain.chercherPTdeTT(numeroSuivant(j), TTi));
        
        return α*PTij.getOrd()+(1-α)*PTik.getOrd();
    }
    
    //renvoie l'Appui associé à l'identificateur indiqué
    public static NoeudAppui donneAppui(int ident){
        return ListeNoeudAppui[ident];
    }
    
    //renvoie le NoeudSimple associé au NoeudAppui
    public static NoeudSimple donneNoeudSimpleAssocie(NoeudAppui NA){
        return ListeNoeudSimple[NA.getIdent()];
    }
    
    //affichage
    public String toString(){
        String res ="Appui "+this.getIdent()+" : ("+this.absAppui()+";"+this.ordAppui()+")";
        return res;
    }
    
    
    //tester classe NoeudAppui
    public static void main (String[] args){
        int j=2;
        System.out.println(numeroSuivant(j));
        
        Point D = new Point(0,0);
        Point E = new Point(2,0);
        Point F = new Point(0,2);
        System.out.println(D);
        System.out.println(E);
        System.out.println(F);
        Terrain Terrain = new Terrain(0,10,0,10);
        NoeudAppui NA1 = new NoeudAppui(Terrain, D,E,F,E.getIdent(),0.5);
        System.out.println(NA1);
        
        
        System.out.println(" ");
        System.out.println(" ");
        Point M = new Point();
        M = TriangleTerrain.chercherPTdeTT(1,NA1.TTi);
        System.out.println(M);
    }
    
}
