/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sofie
 */
public class SegmentTerrain {
    //attributs
    private int i;
    private Point depart;
    private Point arrivee;
    
    //variable servant à numéroter les SegmentTerrain
    private static int numero=0;
    
    //tableau contenant tous les segments créés
    private static SegmentTerrain [] ListeSegment = new SegmentTerrain [255];
    //tableau contenant les 2 points associés aux segments créés
    private static Point [][] ListePoint = new Point [2][255];
    
    //constructeur
    public SegmentTerrain(){
        this.i = numero;
        this.depart= new Point(0,0);
        this.arrivee= new Point(0,0);
        ListeSegment[numero] = this;
        ListePoint [0][numero] = this.depart;
        ListePoint [1][numero] = this.arrivee;
        numero++;
    }
    
    public SegmentTerrain(Point A, Point B){
        this.i = numero;
        this.depart= new Point(A.getAbs(),A.getOrd());
        this.arrivee= new Point(B.getAbs(),B.getOrd());
        ListeSegment[numero] = this;
        ListePoint [0][numero] = this.depart;
        ListePoint [1][numero] = this.arrivee;
        numero++;
    }
    
    
    //constuction d'un segment de 2 points
    public void Segment(Point A, Point B){
        //on fixe le point de départ
        depart.setAbs(A.getAbs());
        depart.setOrd(A.getOrd());
        depart.setIdent(A.getIdent());
        //on actualise le point de départ
        ListePoint [0][this.i] = this.depart;
        
        //on fixe le point d'arrivée
        arrivee.setAbs(B.getAbs());
        arrivee.setOrd(B.getOrd());
        arrivee.setIdent(B.getIdent());
        //on actualise le point d'arrivée
        ListePoint [1][this.i] = this.arrivee;
        
        //on actualise le segment
        ListeSegment[this.i] = this;
    }
    
    
    //méthodes get/set
    public Point getDepart() {
        return depart;
    }
    
    public Point getArrivee() {
        return arrivee;
    }
    
    public int getIdent(){
        return this.i;
    }
    
    public void setIdent(int i){
        this.i=i;
    }
    
    
    //affichage
    public String toString(){
        String res ="ST"+i+" = [ "+ListePoint[0][this.i]+" ; "+ListePoint[1][this.i]+" ]";
        return res;
    }
    
    //tester classe SegmentTerrain
    public static void main(String[] args){
        Point A = new Point(0,0);
        Point B = new Point(1,0);
        Point C = new Point(0,9);
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        SegmentTerrain S1 = new SegmentTerrain();
        S1.Segment(A,B);
        System.out.println(S1);
        System.out.println(C);
    }
    
    
}
