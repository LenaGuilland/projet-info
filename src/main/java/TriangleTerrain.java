





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liiina55
 */



public class TriangleTerrain {
    //attributs
    private int i;
    private Point PTi1;
    private Point PTi2;
    private Point PTi3;
    private SegmentTerrain STi1;
    private SegmentTerrain STi2;
    private SegmentTerrain STi3;
    
    //variable servant à numéroter les TriangleTerrain
    private static int numero=0;
    
    //tableau contenant tous les triangles créés
    private static TriangleTerrain [] ListeTriangle = new TriangleTerrain [255];
    //tableau contenant les 3 points associés aux triangles créés
    private static Point [][] ListePoint = new Point [3][255];
    //tableau contenant les 3 segments associés aux triangles créés
    private static SegmentTerrain [][] ListeSegment = new SegmentTerrain [3][255];
    
    
    //constructeur
    public TriangleTerrain(){
        this.i = numero;
        this.PTi1 = new Point(0,0);
        this.PTi2 = new Point(0,0);
        this.PTi3 = new Point(0,0);
        ListePoint [0][numero] = this.PTi1;
        ListePoint [1][numero] = this.PTi2;
        ListePoint [2][numero] = this.PTi3;
        this.STi1 = new SegmentTerrain();
        this.STi2 = new SegmentTerrain();
        this.STi3 = new SegmentTerrain();
        ListeSegment [0][numero] = this.STi1;
        ListeSegment [1][numero] = this.STi2;
        ListeSegment [2][numero] = this.STi3;
        ListeTriangle [numero] = this;
        numero++;
    }
    
    public TriangleTerrain(Point PT1, Point PT2, Point PT3){
        this.i = numero;
        //on crée et fixe le point A
        this.PTi1 = new Point(PT1.getAbs(),PT1.getOrd());
        ListePoint [0][numero] = this.PTi1;
        //on crée et fixe le point B
        this.PTi2 = new Point(PT2.getAbs(),PT2.getOrd());
        ListePoint [1][numero] = this.PTi2;
        //on crée et fixe le point C
        this.PTi3 = new Point(PT3.getAbs(),PT3.getOrd());
        ListePoint [2][numero] = this.PTi3;
        
        //on crée et fixe les 3 segments associés
        this.STi1 = new SegmentTerrain(PT1, PT2);
        this.STi2 = new SegmentTerrain(PT2, PT3);
        this.STi3 = new SegmentTerrain(PT3, PT1);
        ListeSegment [0][numero] = this.STi1;
        ListeSegment [1][numero] = this.STi2;
        ListeSegment [2][numero] = this.STi3;
        
        //on actualise le TT
        ListeTriangle [numero] = this;
        
        numero++;
    }
    
    //méthode get/set
    public int getIdent(){
        return this.i;
    }
    
    //constuction d'un triplet de points
    public void Triplet(Point PT1, Point PT2, Point PT3){
        //on fixe le point A
        this.PTi1.setAbs(PT1.getAbs());
        this.PTi1.setOrd(PT1.getOrd());
        this.PTi1.setIdent(PT1.getIdent());
        ListePoint [0][numero] = this.PTi1;
        
        //on fixe le point B
        this.PTi2.setAbs(PT2.getAbs());
        this.PTi2.setOrd(PT2.getOrd());
        this.PTi2.setIdent(PT2.getIdent());
        ListePoint [1][numero] = this.PTi2;
        
        //on fixe le point C
        this.PTi3.setAbs(PT3.getAbs());
        this.PTi3.setOrd(PT3.getOrd());
        this.PTi3.setIdent(PT3.getIdent());
        ListePoint [2][numero] = this.PTi3;
        
        //on crée les 3 segments associés
        this.STi1.Segment(PT1, PT2);
        this.STi2.Segment(PT2, PT3);
        this.STi3.Segment(PT3, PT1);
        ListeSegment [0][numero] = this.STi1;
        ListeSegment [1][numero] = this.STi2;
        ListeSegment [2][numero] = this.STi3;
        
        //on actualise le TT
        ListeTriangle [numero] = this;
    }
   
    //affichage
    public String toString(){
        String res ="TriangleTerrain TT"+this.i+" comprend le triplet de point : [ "+this.PTi1+" ; "+this.PTi2+" ; "+this.PTi3+" ]\n";
        res = res+"et les ST : "+this.STi1+" , "+this.STi2+" , "+this.STi3;
        return res;
    }
    
    
    //Calcul du sinus de l'angle entre 2 segments
    public static double Sinus(SegmentTerrain S1, SegmentTerrain S2){
        double sin;
        //on copie temporairement les points de départ et d'arrivée des segments S1 et S2 pour pouvoir en récupérer les coordonnées
        Point S1Depart = new Point();
        S1Depart = S1.getDepart();
        Point S1Arrivee = new Point();
        S1Arrivee = S1.getArrivee();
        Point S2Depart = new Point();
        S2Depart = S2.getDepart();
        Point S2Arrivee = new Point();
        S2Arrivee = S2.getArrivee();
        
        //formule de calcul du sinus de l'angle entre les 2 segments
        sin =( (S1Arrivee.getAbs()-S1Depart.getAbs())*(S2Arrivee.getOrd()-S2Depart.getOrd()) - (S1Arrivee.getOrd()-S1Depart.getOrd())*(S2Arrivee.getAbs()-S2Depart.getAbs()) ) / ( S1Depart.distance(S1Arrivee)*S2Depart.distance(S2Arrivee) );
        return sin;
    }
    
    //renvoie TRUE lorsque le point est sur le segment
    public static boolean Colineaire(SegmentTerrain S1, Point C){
        //crée un segment S2=[B;C]
        SegmentTerrain S2 = new SegmentTerrain();
        Point S1Arrivee = new Point();
        S1Arrivee = S1.getArrivee();
        S2.Segment(S1Arrivee,C);
        
        //colinéaire lorsque sinus a une valeur proche de 0
        if( (Sinus(S1,S2)<0.1) && (Sinus(S1,S2)>-0.1) ){
            return true;
        } else {
            return false;
        }
    }
    
    //renvoie TRUE lorsque le point forme un angle positif avec le segment
    public static boolean Positif(SegmentTerrain S1, Point C){
        //crée un segment S2=[B;C]
        SegmentTerrain S2 = new SegmentTerrain();
        Point S1Arrivee = new Point();
        S1Arrivee = S1.getArrivee();
        S2.Segment(S1Arrivee,C);
        
        //positif si le sinus est positif
        if( (Sinus(S1,S2)>=0)){
            return true;
        } else {
            return false;
        }
    }
    
    //renvoie TRUE lorsque le point forme un angle négatif avec le segment
    public static boolean Negatif(SegmentTerrain S1, Point C){
        //crée un segment S2=[B;C]
        SegmentTerrain S2 = new SegmentTerrain();
        Point S1Arrivee = new Point();
        S1Arrivee = S1.getArrivee();
        S2.Segment(S1Arrivee,C);
        
        //négatif si le sinus est négatif
        if( (Sinus(S1,S2)<=0)){
            return true;
        } else {
            return false;
        }
    }
    
    //renvoie TRUE lorsque le point est dans le TT indiqué
    public boolean Comprend(Point P){
        //on considère le point comme étant dans le TT lorsque tous les angles formés avec les ST sont tous aigus ou tous optus (tous positifs ou tous négatifs)
        if( ( (Positif(this.STi1,P)==true)&&(Positif(this.STi2,P)==true)&&(Positif(this.STi3,P)==true) ) || ( (Negatif(this.STi1,P)==true)&&(Negatif(this.STi2,P)==true)&&(Negatif(this.STi3,P)==true)) ){
            return true;
        } else {
            return false;
        }
        //la méthode renvoie FALSE lorsque P a les même coordonnées qu'un des 3 points de TTS
        //elle renvoie cependant TRUE si le point est colinéaire à un des 3 ST
    }
    
    //renvoie le TT associé à l'identificateur indiqué
    public static TriangleTerrain chercherTT(int ident){
        TriangleTerrain TT = new TriangleTerrain();
        for (int i =0; i<255; i++){
            TT= ListeTriangle[i];
            if (TT.getIdent()==ident){
                return TT;
            }
        }
        return null;
    }
    
    public static Point chercherPTdeTT(int j, TriangleTerrain TT){
        return ListePoint[j][TT.getIdent()];
    }
    
    
    //tester classe TriangleTerrain (et Segment Terrain)
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
        
        
        System.out.println(" ");
        System.out.println(" ");
        Point D = new Point(0,0);
        Point E = new Point(2,0);
        Point F = new Point(0,2);
        TriangleTerrain TT = new TriangleTerrain();
        System.out.println(D);
        System.out.println(E);
        System.out.println(F);
        TT.Triplet(D,E,F);
        System.out.println(TT);
        Point P = new Point (0.5,0.5);
        System.out.println(P);
        System.out.println("DE et EP forment un angle positif : "+Positif(TT.STi1,P));
        System.out.println("EF et FP forment un angle positif : "+Positif(TT.STi2,P));
        System.out.println("FD et DP forment un angle positif : "+Positif(TT.STi3,P));
        System.out.println(" ");
        System.out.println("DE et EP forment un angle negatif : "+Negatif(TT.STi1,P));
        System.out.println("EF et FP forment un angle negatif : "+Negatif(TT.STi2,P));
        System.out.println("FD et DP forment un angle negatif : "+Negatif(TT.STi3,P));
        System.out.println(" ");
        System.out.println("TriangleTerrain TT0 comprend P : "+TT.Comprend(P));
        
        
        System.out.println(" ");
        System.out.println(" ");
        Point G = new Point(0,0);
        Point H = new Point(4,0);
        Point I = new Point(0,4);
        System.out.println(G);
        System.out.println(H);
        System.out.println(I);
        TriangleTerrain TT2 = new TriangleTerrain(G,H,I);
        System.out.println(TT2);
        
        
        System.out.println(" ");
        System.out.println(" ");
        Point M = new Point();
        M = chercherPTdeTT(1,TT2);
        System.out.println(M);
    }
    
}
