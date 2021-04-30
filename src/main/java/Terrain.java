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
    
    //Constructeur
    public Terrain(double xmin, double xmax, double ymin, double ymax){
        this.xmin = xmin;
        this.xmax = xmax;
        this.ymin = ymin;
        this.ymax = ymax;
    }
    
    //Affichage
    public String toString(){
        String res ="Info sur le Terrain :\n";
        res = res+"x compris entre "+xmin+" et "+xmax+"\n";
        res = res+"y compris entre "+ymin+" et "+ymax+"\n";
        res = res+"Comprend les TriangleTerrain [A REMPLIR]";
        return res;
    }
    
    //main
    public static void main(String arg[]){
        Terrain T = new Terrain(10,20,30,40);
        System.out.println(T);
    }
}
