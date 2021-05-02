/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liiina55
 */
public class TypeBarre {
    
    private double cout;
    private double Lmax;
    private double Lmin;
    private double Rtmax;
    private double Rcmax;
    private static int ident;
    private TypeBarre barreBois;
    private TypeBarre barreAcier;
    
    public TypeBarre(){
        this.ident=ident;
        ident++;
        this.barreBois = new TypeBarre();
        this.barreAcier = new TypeBarre();
    }
    
    /*public static void barreAcier(){
    }
    public static void barrBois(){
    }*/
    
    public double getCout(){
        cout=this.cout;
        return cout;
    }
    public void setCout(double a){
        this.cout=a;
    }
    
    public double getLmax(){
        Lmax=this.Lmax;
        return Lmax;
    }
    public void setLmax(double a){
        this.Lmax=a;
    }
    
    public double getLmin(){
        Lmin=this.Lmin;
        return Lmin;
    }
    public void setLmin(double a){
        this.Lmin=a;
    }
    
    public double getRtmax(){
        Rtmax=this.Rtmax;
        return Rtmax;
    }
    public void setRtmax(double a){
        this.Rtmax=a;
    }
        
    public double getRcmax(){
        Rcmax=this.Rcmax;
        return Rcmax;
    }
    public void setRcmax(double a){
        this.Rcmax=a;
    }
    
}