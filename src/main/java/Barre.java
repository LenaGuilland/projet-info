/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liiina55
 */
public class Barre extends Point {
    private Point noeudDeb;
    private Point noeudFin;
    private TypeBarre type;
    private int ident;

    //constructeur
    public Barre(Point noeudDeb, Point noeudFin){
        this.noeudDeb= noeudDeb;
        this.noeudFin= noeudFin;
    }
    
    //calculer milieu segment
    public Point milieu(Point noeudDeb, Point noeudFin){      
        double xdeb=noeudDeb.getAbs();
        double xfin=noeudDeb.getAbs();
        double ydeb=noeudDeb.getOrd();
        double yfin=noeudFin.getOrd();
        double x=(xdeb+xfin)/2;
        double y=(ydeb+yfin)/2;
        Point milieu=new Point(x,y);
        return milieu;    
    }
    
    //obtenir longueur du segment 
    public double longueur(){
        return noeudDeb.distance(noeudFin);
    }
    
    
}