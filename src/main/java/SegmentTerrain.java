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
    
    //tableau contenant tous les SegmentTerrain créés
    private static SegmentTerrain [] ListeSegment = new SegmentTerrain [255];
    
    //tableau contenant les 2 points associés à chaque SegmentTerrain créé
    private static Point [][] ListePoint = new Point [2][255];
    
    //constructeur
    //crée un SegmentTerrain nul
    public SegmentTerrain(){
        this(new Point(0,0),new Point(0,0));
    }
    
    //crée un SegmentTerrain à partir de 2 Points
    public SegmentTerrain(Point A, Point B){
        i = numero;
        //on fixe les deux Points
        depart= A;
        arrivee= B;
        //on sauvegarde les Points et le SegmentTerrain créés
        ListePoint [0][numero] = depart;
        ListePoint [1][numero] = arrivee;
        ListeSegment[numero] = this;
        numero++;
    }
    
    
    //méthodes get/set
    public Point getDepart() {
        return depart;
    }
    public Point getArrivee() {
        return arrivee;
    }
    public int getIdent(){
        return i;
    }
    public void setIdent(int ident){
        i=ident;
    }
    
    
    //modifie un SegmentTerrain à partir de 2 Points
    public void Segment(Point A, Point B){
        //on fixe le point de départ
        depart.setAbs(A.getAbs());
        depart.setOrd(A.getOrd());
        depart.setIdent(A.getIdent());
        //on sauvegarde le point de départ
        ListePoint [0][i] = depart;
        
        //on fixe le point d'arrivée
        arrivee.setAbs(B.getAbs());
        arrivee.setOrd(B.getOrd());
        arrivee.setIdent(B.getIdent());
        //on sauvegarde le point d'arrivée
        ListePoint [1][i] = arrivee;
        
        //on sauvegarde le segment
        ListeSegment[i] = this;
    }
    
    
    //renvoie la valeur du sinus de l'angle entre 2 ST indiqués
    public static double Sinus(SegmentTerrain S1, SegmentTerrain S2){
        double sin;
        //on copie temporairement les points de départ et d'arrivée des segments S1 et S2 pour pouvoir en récupérer les coordonnées
        Point S1Depart = new Point(S1.getDepart());
        Point S1Arrivee = new Point(S1.getArrivee());
        
        Point S2Depart = new Point(S2.getDepart());
        Point S2Arrivee = new Point(S2.getArrivee());
        
        //calcul du sinus de l'angle entre les 2 segments
        sin =( (S1Arrivee.getAbs()-S1Depart.getAbs())*(S2Arrivee.getOrd()-S2Depart.getOrd()) - (S1Arrivee.getOrd()-S1Depart.getOrd())*(S2Arrivee.getAbs()-S2Depart.getAbs()) ) / ( S1Depart.distance(S1Arrivee)*S2Depart.distance(S2Arrivee) );
        return sin;
    }
    
    //renvoie TRUE lorsque le point C est sur le segment [AB]
    public static boolean Colineaire(SegmentTerrain S1, Point C){
        //S1 correspond à un segment [AB]
        //on crée le segment S2=[BC]
        SegmentTerrain S2 = new SegmentTerrain(S1.getArrivee(),C);
        
        //colinéaire lorsque sinus a une valeur proche de 0
        if( (Sinus(S1,S2)<0.1) && (Sinus(S1,S2)>-0.1) ){
            return true;
        } else {
            return false;
        }
    }
    
    //renvoie TRUE lorsque le point C forme un angle positif avec le segment [AB]
    public static boolean Positif(SegmentTerrain S1, Point C){
        //crée un segment S2=[BC]
        SegmentTerrain S2 = new SegmentTerrain(S1.getArrivee(),C);
        
        //angle est positif si le sinus est positif
        if( (Sinus(S1,S2)>=0)){
            return true;
        } else {
            return false;
        }
    }
    
    //renvoie TRUE lorsque le point C forme un angle négatif avec le segment [AB]
    public static boolean Negatif(SegmentTerrain S1, Point C){
        //crée un segment S2=[BC]
        SegmentTerrain S2 = new SegmentTerrain(S1.getArrivee(),C);
        
        //angle est négatif si le sinus est négatif
        if( (Sinus(S1,S2)<=0)){
            return true;
        } else {
            return false;
        }
    }
    
    
    //affichage
    public String toString(){
        String res ="ST"+i+" = [ "+ListePoint[0][i]+" ; "+ListePoint[1][i]+" ]";
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
        System.out.println("AB et BC sont colineaires : "+Colineaire(S1,C));
        System.out.println("AB et BC forment un angle positif : "+Positif(S1,C));
        System.out.println("AB et BC forment un angle negatif : "+Negatif(S1,C));
        
        SegmentTerrain S2 = new SegmentTerrain();
        S2.Segment(B,C);
        System.out.println("Sinus de l'angle entre S1 et S2 vaut : "+Sinus(S1,S2));
    }
    
    
}
