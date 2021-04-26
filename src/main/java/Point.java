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
    private double abs;
    private double ord;
    private double ident;
    
    //constructeur
    public Point(double abs, double ord){
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
    
    public double getIdent(){
        return this.ident;
    }
    
    public double ident(Point A){
        ident = A.abs+A.ord;
        return ident;
    }
    
    public double distance(Point B){
        //double dabs=this.abs;
        //double dord;
        //return Math.sqrt()
        return Math.sqrt((this.abs-B.abs)*(this.abs-B.abs)+(this.ord-B.ord)*(this.ord-B.ord));
    }
}
