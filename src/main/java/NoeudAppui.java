


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
    //numéro du premier point du segment de terrain sur lequel se trouve le noeud d'appui
    private int j;
    //position du noeud sur le segment de terrain
    private double α;
    
    //constructeur
    public NoeudAppui(){
        this.TTi= new TriangleTerrain();
        this.j= 0;
        this.α= 0;
    }
    
    public NoeudAppui(Point PT1, Point PT2, Point PT3, int j, double α){
        this.TTi= new TriangleTerrain(PT1,PT2,PT3);
        this.j= j;
        this.α= α;
    }
    
    //renvoie le numéro du point suivant sur le segment
    public static int numeroSuivant(int j){
        int k;
        k=(j+1)%3;
        return k;
    }
    
    
    //affichage
    public String toString(){
        String res ="Appui "+this.getIdent()+" : ("+0+";"+0+")";
        return res;
    }
    
    
    //tester NoeudAppui
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
        
        
        
    }
    
}
