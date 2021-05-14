/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sofie
 */
public class Barre {
    //attributs
    private int i;
    private Point depart;
    private Point arrivee;
    private TypeBarre type;
    
    //variable servant à numéroter les Barres
    private static int numero=0;
    
    //tableau contenant tous les Barres créés
    private static Barre [] ListeBarre = new Barre [255];
    
    //tableau contenant les 2 points associés à chaque Barre créé
    private static Point [][] ListePoint = new Point [2][255];
    
    //tableau contenant le type de barre associé à chaque Barre
    private static TypeBarre [] ListeTypeBarre = new TypeBarre [255];
    
    
    //crée un SegmentTerrain à partir de 2 Points
    public Barre(Point A, Point B, TypeBarre type){
        this.i = numero;
        //on fixe les deux Points
        this.depart= A;
        this.arrivee= B;
        this.type = type;
        //on sauvegarde les Points et le SegmentTerrain créés
        ListePoint [0][numero] = this.depart;
        ListePoint [1][numero] = this.arrivee;
        ListeTypeBarre [numero] = type;
        ListeBarre[numero] = this;
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
        return this.i;
    }
    public void setIdent(int i){
        this.i=i;
    }
    
    
    //affichage
    public String toString(){
        String res ="Barre "+i+" = [ "+ListePoint[0][this.i]+" ; "+ListePoint[1][this.i]+" ] de type : "+ListeTypeBarre[this.i];
        return res;
    }
    
    
    public static void main (String[] args){
        Catalogue CATA = new Catalogue();
        Point A = new Point(0,0);
        Point B = new Point(1,0);
        System.out.println( new Barre(A,B,CATA.getAcier() ));
        
    }
    
}
