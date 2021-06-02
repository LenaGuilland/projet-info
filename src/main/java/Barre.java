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
    private NoeudSimple depart;
    private NoeudSimple arrivee;
    private TypeBarre type;
    
    //variable servant à numéroter les Barres
    private static int numero=0;
    
    //tableau contenant tous les Barres créés
    private static Barre [] ListeBarre = new Barre [255];
    
    //tableau contenant les 2 points associés à chaque Barre créé
    private static NoeudSimple [][] ListeNoeudSimple = new NoeudSimple [2][255];
    
    //tableau contenant le type de barre associé à chaque Barre
    private static TypeBarre [] ListeTypeBarre = new TypeBarre [255];
    
    
    //crée un SegmentTerrain à partir de 2 Points
    public Barre(NoeudSimple A, NoeudSimple B, TypeBarre Type){
        
        //on vérifie qu'il n'existe pas déjà une autre barre reliant les deux points
        int j=0;
        
        while (j< ListeBarre.length){
            if(ListeBarre[j]==null){
                //si les points A et B ne forment pas déjà une barre, alors on en crée une
                i = numero;
                //on fixe les deux Points
                depart= A;
                arrivee= B;
                this.type = Type;
                //on sauvegarde les Points et le SegmentTerrain créés
                ListeNoeudSimple [0][numero] = depart;
                ListeNoeudSimple [1][numero] = arrivee;
                ListeTypeBarre [numero] = type;
                ListeBarre[numero] = this;
                numero++;
                j = ListeBarre.length;
                
            } else if ( (ListeBarre[j].getDepart()==A)&&(ListeBarre[j].getArrivee()==B) || (ListeBarre[j].getDepart()==B)&&(ListeBarre[j].getArrivee()==A) ){
                //si une barre relie déjà les deux points, on renvoie une erreur
                throw new Error("Une autre barre relie déjà ces deux points"); 
                
            } else {
                //si une barre existe déjà, on vérifie qu'elle ne relie pas les mêmes points
                i = numero;
                //on fixe les deux Points
                depart= A;
                arrivee= B;
                this.type = Type;
                //on sauvegarde les Points et le SegmentTerrain créés
                ListeNoeudSimple [0][numero] = depart;
                ListeNoeudSimple [1][numero] = arrivee;
                ListeTypeBarre [numero] = type;
                ListeBarre[numero] = this;
                numero++;
                j = ListeBarre.length;
            }
            
            j++;
        }
    }
    
    
    
     //méthodes get/set
    public NoeudSimple getDepart() {
        return depart;
    }
    public NoeudSimple getArrivee() {
        return arrivee;
    }
    public int getIdent(){
        return i;
    }
    public void setIdent(int i){
        this.i=i;
    }
    
    
    //affichage
    public String toString(){
        String res ="Barre "+i+" = [ "+ListeNoeudSimple[0][i]+" ; "+ListeNoeudSimple[1][i]+" ] de type : "+ListeTypeBarre[i];
        return res;
    }
    
    
    public static void main (String[] args){
        Catalogue CATA = new Catalogue();
        Terrain Terrain = new Terrain(0,10,0,10);
        NoeudSimple A = new NoeudSimple(Terrain,0,0);
        NoeudSimple B = new NoeudSimple(Terrain,1,0);
        NoeudSimple C = new NoeudSimple(Terrain,5,5);
        System.out.println( new Barre(A,B,CATA.getAcier() ));
        System.out.println( new Barre(B,C,CATA.getBois() ));
    }
    
}
