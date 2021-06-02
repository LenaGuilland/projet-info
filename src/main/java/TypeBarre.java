/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sofie
 */
public class TypeBarre {
    private int i;
    private double cout;
    private double Lmax;
    private double Lmin;
    private double Rtmax;
    private double Rcmax;
    private static int ident;
    
    public TypeBarre(double cout, double Lmax, double Lmin,double Rtmax,double Rcmax){
        i=ident;
        ident++;
        this.cout = cout;
        this.Lmax = Lmax;
        this.Lmin = Lmin;
        this.Rtmax = Rtmax;
        this.Rcmax = Rcmax;
    }
    
    /*public static void barreAcier(){
    }
    public static void barrBois(){
    }*/
    
    public double getCout(){
        return cout;
    }
    public void setCout(double a){
        cout=a;
    }
    
    public double getLmax(){
        return Lmax;
    }
    public void setLmax(double a){
        Lmax=a;
    }
    
    public double getLmin(){
        return Lmin;
    }
    public void setLmin(double a){
        Lmin=a;
    }
    
    public double getRtmax(){
        return Rtmax;
    }
    public void setRtmax(double a){
        Rtmax=a;
    }
        
    public double getRcmax(){
        return Rcmax;
    }
    public void setRcmax(double a){
        Rcmax=a;
    }
    
    public String toString(){
        String res="Type"+ident;
        return res;
    }
    
    
    
}
