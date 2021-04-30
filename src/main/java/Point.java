/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liiina55
 */
public class Point {
    //attributs
    private int i;
    private double abs;
    private double ord;
    
    //variable servant à numéroter les points
    private static int numero=0;
    
    //constructeur
    public Point(double abs, double ord){
        this.i = numero;
        numero++;
        this.abs=abs;
        this.ord=ord;
    }
    
    //getter, setter
    public double getAbs(){
        return this.abs;
    }
    
    public double getOrd(){
        return this.ord;
    }

    public void setAbs(double abs){
        this.abs=abs;
    }  
    
    public void setOrd(double ord){
        this.ord=ord;
    }
    
    public int getIdent(){
        return this.i;
    }
    
    //affichage
    public String toString(){
        String res ="Point "+i+" : ("+abs+";"+ord+")";
        return res;
    }
    
    //calcul de la distance entre  points
    public double distance(Point B){
        //double dabs=this.abs;
        //double dord;
        //return Math.sqrt()
        return Math.sqrt((B.abs-this.abs)*(B.abs-this.abs)+(B.ord-this.ord)*(B.ord-this.ord));
    }
    
}
