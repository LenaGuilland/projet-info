





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
    
    //tableau contenant les 3 points associés à chaque TriangleTerrain créé
    private static Point [][] ListePoint = new Point [3][255];
    
    //tableau contenant les 3 segments associés à chaque TriangleTerrain créé
    private static SegmentTerrain [][] ListeSegment = new SegmentTerrain [3][255];
    
    
    //constructeurs
    //crée un TriangleTerrain à partir de 3 Points et de 3 SegmentTerrains
    public TriangleTerrain(Point PT1, Point PT2, Point PT3, SegmentTerrain ST1, SegmentTerrain ST2, SegmentTerrain ST3){
        i = numero;
        PTi1 = PT1;
        PTi2 = PT2;
        PTi3 = PT3;
        ListePoint [0][numero] = PTi1;
        ListePoint [1][numero] = PTi2;
        ListePoint [2][numero] = PTi3;
        STi1 = ST1;
        STi2 = ST2;
        STi3 = ST3;
        ListeSegment [0][numero] = STi1;
        ListeSegment [1][numero] = STi2;
        ListeSegment [2][numero] = STi3;
        ListeTriangle [numero] = this;
        numero++;
    }
    
    //crée un TriangleTerrain nul
    public TriangleTerrain(){
        this(new Point(0,0),new Point(0,0),new Point(0,0));
    }
    
    //crée un TriangleTerrain à partir de 3 Points
    public TriangleTerrain(Point PT1, Point PT2, Point PT3){
        //crée les 3 ST correspondant aux Points fournis
        this(PT1, PT2, PT3, new SegmentTerrain(PT1, PT2), new SegmentTerrain(PT2, PT3), new SegmentTerrain(PT3, PT1));
    }
    
    
    
    //méthode get/set
    public int getIdent(){
        return i;
    }
    
    
    //modifie un TriangleTerrain à partir de 3 Points
    public void Triplet(Point PT1, Point PT2, Point PT3){
        //on fixe le point PTi1
        PTi1.setAbs(PT1.getAbs());
        PTi1.setOrd(PT1.getOrd());
        PTi1.setIdent(PT1.getIdent());
        ListePoint [0][numero] = PTi1;
        
        //on fixe le point PTi2
        PTi2.setAbs(PT2.getAbs());
        PTi2.setOrd(PT2.getOrd());
        PTi2.setIdent(PT2.getIdent());
        ListePoint [1][numero] = PTi2;
        
        //on fixe le point PTi3
        PTi3.setAbs(PT3.getAbs());
        PTi3.setOrd(PT3.getOrd());
        PTi3.setIdent(PT3.getIdent());
        ListePoint [2][numero] = PTi3;
        
        //on crée et fixe les 3 segments associés
        STi1.Segment(PT1, PT2);
        STi2.Segment(PT2, PT3);
        STi3.Segment(PT3, PT1);
        ListeSegment [0][numero] = STi1;
        ListeSegment [1][numero] = STi2;
        ListeSegment [2][numero] = STi3;
        
        //on sauvegarde le TT
        ListeTriangle [numero] = this;
    }
   
    //affichage
    public String toString(){
        String res ="TriangleTerrain TT"+i+" comprend le triplet de point : [ "+PTi1+" ; "+PTi2+" ; "+PTi3+" ]\n";
        res = res+"et les ST : "+STi1+" , "+STi2+" , "+STi3;
        return res;
    }

    
    //renvoie TRUE lorsque le Point P est compris dans le TriangleTerrain fourni
    public boolean Comprend(Point P){
        //on considère le point comme étant dans le TT lorsque tous les angles formés avec les ST sont aigus ou optus (tous positifs ou tous négatifs) ET qu'il n'est pas colinéaire à l'un des ST
        if( ( ( (SegmentTerrain.Positif(STi1,P)==true)&&(SegmentTerrain.Positif(STi2,P)==true)&&(SegmentTerrain.Positif(STi3,P)==true) ) || ( (SegmentTerrain.Negatif(STi1,P)==true)&&(SegmentTerrain.Negatif(STi2,P)==true)&&(SegmentTerrain.Negatif(STi3,P)==true)) ) && (SegmentTerrain.Colineaire(STi1, P)==false) && (SegmentTerrain.Colineaire(STi2, P)==false) && (SegmentTerrain.Colineaire(STi3, P)==false) ){
            return true;
        } else {
            return false;
        }
        //la méthode renvoie également FALSE lorsque P a les même coordonnées qu'un des 3 points de TTS
    }
    
    
    
    //renvoie le Point n°j du TriangleTerrain indiqué
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
        System.out.println("AB et BC sont colineaires : "+SegmentTerrain.Colineaire(S1,C));
        System.out.println("AB et BC forment un angle positif : "+SegmentTerrain.Positif(S1,C));
        System.out.println("AB et BC forment un angle negatif : "+SegmentTerrain.Negatif(S1,C));
        
        SegmentTerrain S2 = new SegmentTerrain();
        S2.Segment(B,C);
        System.out.println("Sinus de l'angle entre S1 et S2 vaut : "+SegmentTerrain.Sinus(S1,S2));
        
        
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
        System.out.println("DE et EP forment un angle positif : "+SegmentTerrain.Positif(TT.STi1,P));
        System.out.println("EF et FP forment un angle positif : "+SegmentTerrain.Positif(TT.STi2,P));
        System.out.println("FD et DP forment un angle positif : "+SegmentTerrain.Positif(TT.STi3,P));
        System.out.println(" ");
        System.out.println("DE et EP forment un angle negatif : "+SegmentTerrain.Negatif(TT.STi1,P));
        System.out.println("EF et FP forment un angle negatif : "+SegmentTerrain.Negatif(TT.STi2,P));
        System.out.println("FD et DP forment un angle negatif : "+SegmentTerrain.Negatif(TT.STi3,P));
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
