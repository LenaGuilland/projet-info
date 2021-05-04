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
    public NoeudSimple(){
        this.abs=0;
        this.ord=0;
    }
    
    public NoeudSimple(double abs, double ord){
        this.abs=abs;
        this.ord=ord;
    }
    
    
    //affichage
    public String toString(){
        String res = "Point "+this.getIdent()+" : ("+abs+";"+ord+")";
        return res;
    }
    
    public static void main (String[] args){
        NoeudSimple NS = new NoeudSimple();
        System.out.println(NS);
        NoeudSimple NS1 = new NoeudSimple();
        System.out.println(NS1);
        NoeudSimple NS2 = new NoeudSimple();
        System.out.println(NS2);
    }
}
