


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
    
    
    //constructeur
    //crée un NoeudAppui nul associé à une TriangleTerrain nul
    public NoeudAppui(){
        this.TTi= new TriangleTerrain();
        this.j= 0;
        this.α= 0;
    }
    
    //crée un NoeudAppui et son TriangleTerrain associé
    public NoeudAppui(Point PT1, Point PT2, Point PT3, int j, double α){
        this.TTi= new TriangleTerrain(PT1,PT2,PT3);
        //j ne peut avoir comme valeur que 0, 1 et 2
        //i doit être compris au sens large entre 0 et 1
        if((j<0)||(j>=3)){
            throw new Error("la valeur de l'indice j n'est pas valide");
        } else if ((α<0)||(α>1)){
            throw new Error("la valeur de l'indice α n'est pas valide");
        } else {
           this.j= j;
           this.α= α; 
        }
        
    }
    
    
    //renvoie le numéro du point suivant sur le segment
    public static int numeroSuivant(int j){
        return (j+1)%3;
    }
    
    //renvoie l'abscisse de l'appui
    public double absAppui(){
        Point PTij = new Point();
        Point PTik = new Point();
        
        //récupère le point de départ du segment
        PTij = TriangleTerrain.chercherPTdeTT(this.j, this.TTi);
        //récupère le point d'arrivée du segment
        PTik = TriangleTerrain.chercherPTdeTT(numeroSuivant(j), TTi);
        
        return this.α*PTij.getAbs()+(1-this.α)*PTik.getAbs();
    }
    
    //renvoie l'ordonnée de l'appui
    public double ordAppui(){
        Point PTij = new Point();
        Point PTik = new Point();
        
        //récupère le point de départ du segment
        PTij = TriangleTerrain.chercherPTdeTT(this.j, this.TTi);
        //récupère le point d'arrivée du segment
        PTik = TriangleTerrain.chercherPTdeTT(numeroSuivant(j), TTi);
        
        return this.α*PTij.getOrd()+(1-this.α)*PTik.getOrd();
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
        NoeudAppui NA1 = new NoeudAppui(D,E,F,E.getIdent(),0.5);
        System.out.println(NA1);
        
        
        System.out.println(" ");
        System.out.println(" ");
        Point M = new Point();
        M = TriangleTerrain.chercherPTdeTT(1,NA1.TTi);
        System.out.println(M);
    }
    
}
