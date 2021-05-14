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
    
    //tableau contenant tous les Points créés
    private static Point [] Liste = new Point [255];
    
    //constructeur
    //crée un Point nul
    public Point(){
        this(0,0);
    }
    
    //crée un Point à partir de 2 coordonnées
    public Point(double abs, double ord){
        this.i = numero;
        this.abs=abs;
        this.ord=ord;
        Liste[numero] = this;
        numero++;
    }
    
    public Point(Point P){
        this.i = P.getIdent();
        this.abs=P.getAbs();
        this.ord=P.getOrd();
    }
    
    
    //méthodes get/set
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
    public void setIdent(int i){
        this.i=i;
    }
    
    
    //affichage
    public String toString(){
        String res ="Point "+i+" : ("+abs+";"+ord+")";
        return res;
    }
    
    
    //renvoie la distance entre 2 Points
    public double distance(Point B){
        //double dabs=this.abs;
        //double dord;
        //return Math.sqrt()
        return Math.sqrt((B.abs-this.abs)*(B.abs-this.abs)+(B.ord-this.ord)*(B.ord-this.ord));
    }
    
    //tester classe Point
    public static void main(String[] args){
        Point A = new Point(1,2);
        Point B = new Point(2,3);
        Point C = new Point(1,1);
        System.out.println(A.getIdent());
        System.out.println(B.getIdent());
        System.out.println(C.getIdent());
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(Liste[0]);
        System.out.println(Liste[1]);
        System.out.println(Liste[2]);
    }
    
}
