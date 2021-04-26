/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author liiina55
 */
public class TriangleTerrain extends Point {
    private ArrayList triplet;
    private int ident;
    
    //constructeur
    public TriangleTerrain(){
        this.ident = ident;
        this.triplet = new ArrayList(3);
    }
    
    //constuction d'un triplet de points
    public List triplet(Point A, Point B, Point C){
        List<Double> triplet = new ArrayList<Double>();
               triplet.add(A.getIdent());
               triplet.add(B.getIdent());
               triplet.add(C.getIdent());
        return triplet;
    }           
    
    //construction segment de terrain
    public List segmentTerrain(List triplet){
        List<List>segmentTerrain = new ArrayList<List>();
            segmentTerrain.add(triplet);
        return segmentTerrain;
    }
    
    //
    public static void main(String[] args){
        Point A = new Point(1,2);
        Point B = new Point(2,3);
        Point C = new Point(1,1);
        System.out.println(triplet(Point A, Point B,Point C));
    }
}
