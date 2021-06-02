/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liiina55
 */
public class Terrain {
    //attributs
    private double xmin;
    private double xmax;
    private double ymin;
    private double ymax;
    //tableau contenant tous les TriangleTerrain appartenant au terrain
    private TriangleTerrain [] ListeTriangle = new TriangleTerrain [255];
    
    //Constructeur
    public Terrain(double xmin, double xmax, double ymin, double ymax){
        this.xmin = xmin;
        this.xmax = xmax;
        this.ymin = ymin;
        this.ymax = ymax;
    }
    
    //méthodes get
    public double getXMIN(){
        return xmin;
    }
    
    public double getXMAX(){
        return xmax;
    }
    
    public double getYMIN(){
        return ymin;
    }
    
    public double getYMAX(){
        return ymax;
    }
    
    //crée un TT et l'ajoute dans une case vide du tableau du Terrain
    public void ajoutTT(Point A, Point B, Point C) {
        int i=0;
        while (i< ListeTriangle.length){
            if(ListeTriangle[i]==null){
                ListeTriangle[i] = new TriangleTerrain(A,B,C);
                i=ListeTriangle.length;
            }
            i++;
        }
    }
    
    //renvoie la dimension du tableau
    public int TailleListeTriangle(){
        return ListeTriangle.length;
    }
    
    //renvoie le TT associé à l'identificateur indiqué
    public TriangleTerrain chercherTT(int i){
        return ListeTriangle[i];
    }
    
    
    //Affichage
    public String toString(){
        String res ="de coordonnées :\n";
        res = res+"x compris entre "+xmin+" et "+xmax+"\n";
        res = res+"y compris entre "+ymin+" et "+ymax+"\n";
        return res;
    }
    
    //tester classe Terrain
    public static void main(String arg[]){
        Terrain T = new Terrain(10,20,30,40);
        System.out.println(T);
        
        Point A = new Point(0,0);
        Point B = new Point(1,0);
        Point C = new Point(0,9);
        T.ajoutTT(A,B,C);
        System.out.println(T.ListeTriangle[0]);
    }

    
    
}
