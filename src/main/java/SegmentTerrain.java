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
    private int [] info; //tableau contenant les identificateurs des 2 points
    
    //variable servant à numéroter les SegmentTerrain
    private static int numero=0;
    
    //constructeur
    public SegmentTerrain(){
        this.i = numero;
        numero++;
        this.depart= new Point(0,0);
        this.arrivee= new Point(0,0);
        this.info = new int[2];
    }
    
    //constuction d'un segment de 2 points
    public void Segment(Point A, Point B){
        //on fixe le point de départ
        depart.setAbs(A.getAbs());
        depart.setOrd(A.getOrd());
        //on note son identificateur
        this.info[0]= A.getIdent();
        
        //on fixe le point d'arrivée
        arrivee.setAbs(B.getAbs());
        arrivee.setOrd(B.getOrd());
        //on note son identificateur
        this.info[1]= B.getIdent();
    }
    
    //affichage
    public String toString(){
        String res ="ST"+i+" = [ "+this.info[0]+" ; "+this.info[1]+" ]";
        return res;
    }
    
    
    
    
    //Calcul du sinus de l'angle entre 2 segments
    public static double Sinus(SegmentTerrain S1, SegmentTerrain S2){
        double sin;
        //formule de calcul du sinus de l'angle entre les 2 segments
        sin =( (S1.arrivee.getAbs()-S1.depart.getAbs())*(S2.arrivee.getOrd()-S2.depart.getOrd()) - (S1.arrivee.getOrd()-S1.depart.getOrd())*(S2.arrivee.getAbs()-S2.depart.getAbs()) ) / ( S1.depart.distance(S1.arrivee)*S2.depart.distance(S2.arrivee) );
        return sin;
    }
    
    //renvoit TRUE lorsque le point est sur le segment
    public static boolean Colineaire(SegmentTerrain S1, Point C){
        //crée un segment S2=[B;C]
        SegmentTerrain S2 = new SegmentTerrain();
        S2.Segment(S1.arrivee,C);
        
        //colinéaire lorsque sinus a une valeur proche de 0
        if( (Sinus(S1,S2)<0.1) && (Sinus(S1,S2)>-0.1) ){
            return true;
        } else {
            return false;
        }
    }
    
    //renvoit TRUE lorsque le point forme un angle positif avec le segment
    public static boolean Positif(SegmentTerrain S1, Point C){
        //crée un segment S2=[B;C]
        SegmentTerrain S2 = new SegmentTerrain();
        S2.Segment(S1.arrivee,C);
        
        //positif si le sinus est positif
        if( (Sinus(S1,S2)>=0)){
            return true;
        } else {
            return false;
        }
    }
    
    //renvoit TRUE lorsque le point forme un angle négatif avec le segment
    public static boolean Negatif(SegmentTerrain S1, Point C){
        //crée un segment S2=[B;C]
        SegmentTerrain S2 = new SegmentTerrain();
        S2.Segment(S1.arrivee,C);
        
        //négatif si le sinus est négatif
        if( (Sinus(S1,S2)<=0)){
            return true;
        } else {
            return false;
        }
    }
    
    
    
    
}
