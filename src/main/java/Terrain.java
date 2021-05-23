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
    
    //méthodes get
    public double getXMIN(){
        return this.xmin;
    }
    
    public double getXMAX(){
        return this.xmax;
    }
    
    public double getYMIN(){
        return this.ymin;
    }
    
    public double getYMAX(){
        return this.ymax;
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
    }
    
}
