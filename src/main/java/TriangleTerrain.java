


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liiina55
 */

import static SegmentTerrain.Negatif;
import static SegmentTerrain.Positif;

public class TriangleTerrain {
    //attributs
    private int i;
    private Point PTi1;
    private Point PTi2;
    private Point PTi3;
    private int [] info;
    private SegmentTerrain STi1;
    private SegmentTerrain STi2;
    private SegmentTerrain STi3;
    
    //variable servant à numéroter les TriangleTerrain
    private static int numero=0;
    
    //constructeur
    public TriangleTerrain(){
        this.i = numero;
        numero++;
        this.PTi1 = new Point(0,0);
        this.PTi2 = new Point(0,0);
        this.PTi3 = new Point(0,0);
        this.info = new int[3];
        this.STi1 = new SegmentTerrain();
        this.STi2 = new SegmentTerrain();
        this.STi3 = new SegmentTerrain();
    }
    
    //constuction d'un triplet de points
    public void Triplet(Point PT1, Point PT2, Point PT3){
        //on fixe le point A
        this.PTi1.setAbs(PT1.getAbs());
        this.PTi1.setOrd(PT1.getOrd());
        this.info[0]= PT1.getIdent();
        
        //on fixe le point B
        this.PTi2.setAbs(PT2.getAbs());
        this.PTi2.setOrd(PT2.getOrd());
        this.info[1]= PT2.getIdent();
        
        //on fixe le point C
        this.PTi3.setAbs(PT3.getAbs());
        this.PTi3.setOrd(PT3.getOrd());
        this.info[2]= PT3.getIdent();
        
        //on crée les 3 segments associés
        this.STi1.Segment(PT1, PT2);
        this.STi2.Segment(PT2, PT3);
        this.STi3.Segment(PT3, PT1);
    }
   
    //affichage
    public String toString(){
        String res ="TriangleTerrain TT"+this.i+" comprend le triplet : [ "+this.info[0]+" ; "+this.info[1]+" ; "+this.info[2]+" ]\n";
        res = res+"et les ST : "+this.STi1+" , "+this.STi2+" , "+this.STi3;
        return res;
    }
    
    
    //renvoit TRUE lorsque le point est dans le TT indiqué
    public boolean Comprend(Point P){
        //on considère le point comme étant dans le TT lorsque tous les angles formés avec les ST sont tous aigus ou tous optus (tous positifs ou tous négatifs)
        if( ( (Positif(this.STi1,P)==true)&&(Positif(this.STi2,P)==true)&&(Positif(this.STi3,P)==true) ) || ( (Negatif(this.STi1,P)==true)&&(Negatif(this.STi2,P)==true)&&(Negatif(this.STi3,P)==true)) ){
            return true;
        } else {
            return false;
        }
        //la méthode renvoit FALSE lorsque P a les même coordonnées qu'un des 3 points de TTS
        //elle renvoit cependant TRUE si le point est colinéaire à un des 3 ST
    }
    
    
    
}
    
    
    
    
}
