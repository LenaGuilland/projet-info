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
    private int ident;
    
    
    
    public static void bois(double cout, double Lmax, double Lmin,double Rtmax, double Rcmax){
        cout = 4;
        Lmax = 10;
        Lmin = 5;
        Rtmax = 6;
        Rcmax = 3;
    }
    
    public static void acier(double cout, double Lmax, double Lmin,double Rtmax, double Rcmax){
        cout = 8;
        Lmax = 20;
        Lmin = 10;
        Rtmax = 7;
        Rcmax = 5;
    }
}
