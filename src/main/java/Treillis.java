/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sofie
 */
public class Treillis {
    //attributs
    private Terrain T;
    private NoeudSimple[] ListeNoeudSimple = new NoeudSimple[255];
    private NoeudAppui[] ListeNoeudAppui = new NoeudAppui[255];
    private Barre[] ListeBarre = new Barre[255];
    private Catalogue CATA;
    
    //constructeurs
    //crée un Treillis avec les paramètres indiqués
    public Treillis(Terrain Terrain, NoeudSimple[] ListeNoeudSimple, NoeudAppui[] ListeNoeudAppui, Barre[] ListeBarre, Catalogue CATA){
        T = Terrain;
        this.ListeNoeudSimple = ListeNoeudSimple;
        this.ListeNoeudAppui = ListeNoeudAppui;
        this.ListeBarre = ListeBarre;
        this.CATA = CATA;
    }
    
    //crée un Treillis avec des tableaux vides à partir d'un Terrain et d'un Catalogue
    public Treillis(Terrain T, Catalogue CATA){
        this(T, new NoeudSimple[255], new NoeudAppui[255], new Barre[255], CATA);
    }
    
    //crée un NoeudAppui et l'ajoute dans une case vide du tableau du Treillis
    public void ajoutAppui(Terrain T, TriangleTerrain TT, int j, double α){
        int i=0;
        while (i< ListeNoeudAppui.length){
            if(ListeNoeudAppui[i]==null){
                ListeNoeudAppui[i] = new NoeudAppui(T, TT, j, α);
                i=ListeNoeudAppui.length +1;
            }
            i++;
        }
    }
    //crée un NoeudSimple et l'ajoute dans une case vide du tableau du Treillis
    public void ajoutNoeudSimple(Terrain T, double abs, double ord){
        int i=0;
        while (i< ListeNoeudSimple.length){
            if(ListeNoeudSimple[i]==null){
                ListeNoeudSimple[i] = new NoeudSimple(T, abs, ord);
                i=ListeNoeudSimple.length;
            }
            i++;
        }
    }
    
    //on surcharge la méthode creerBarre pour qu'elle crée une Barre entre deux NoeudSimple, que les Noeuds fournis soient des Simples ou des Appuis
    //cas où les deux Noeuds sont des NoeudsSimples
    public void ajoutBarre(NoeudSimple N1, NoeudSimple N2, TypeBarre type){
        int i=0;
        while (i< ListeBarre.length){
            if(ListeBarre[i]==null){
                ListeBarre[i] = new Barre(N1, N2, type);
                i=ListeBarre.length;
            }
            i++;
        }
    }
    //cas où le Noeud de départ est un NoeudAppui
    public void ajoutBarre(NoeudAppui NA1, NoeudSimple N2, TypeBarre type){
        int i=0;
        while (i< ListeBarre.length){
            if(ListeBarre[i]==null){
                ListeBarre[i] = new Barre(NoeudAppui.donneNoeudSimpleAssocie(NA1), N2, type);
                i=ListeBarre.length;
            }
            i++;
        }
    }
    //cas où le Noeud d'arrivée est un NoeudAppui
    public void ajoutBarre(NoeudSimple N1, NoeudAppui NA2, TypeBarre type){
        int i=0;
        while (i< ListeBarre.length){
            if(ListeBarre[i]==null){
                ListeBarre[i] = new Barre(N1, NoeudAppui.donneNoeudSimpleAssocie(NA2), type);
                i=ListeBarre.length;
            }
            i++;
        }
    }
    //cas où les deux Noeuds sont des NoeudsAppuis
    public void ajoutBarre(NoeudAppui NA1, NoeudAppui NA2, TypeBarre type){
        int i=0;
        while (i< ListeBarre.length){
            if(ListeBarre[i]==null){
                ListeBarre[i] = new Barre(NoeudAppui.donneNoeudSimpleAssocie(NA1), NoeudAppui.donneNoeudSimpleAssocie(NA2), type);
                i=ListeBarre.length;
            }
            i++;
        }
    }
    
    //supprime la Barre associée à la case indiquée dans ListeBarre
    public void supprBarre(int i){
        ListeBarre[i] = null;
    }
    //supprime l'Appui associée à la case indiquée dans ListeNoeudAppui ainsi que les Barres dont il est une extrémité
    public void supprAppui(int i){
        int j=0;
        boolean comprend = false;
        //parcourt tout le tableau à la recherche des Barres qui contiennent le Noeud associé à l'Appui
        while (j< ListeBarre.length){
            if(ListeBarre[j].getDepart()==NoeudAppui.donneNoeudSimpleAssocie(ListeNoeudAppui[i]) ){
                comprend=true;
            }
            if(ListeBarre[j].getArrivee()==NoeudAppui.donneNoeudSimpleAssocie(ListeNoeudAppui[i]) ){
                comprend=true;
            }
            if(comprend==true){
                ListeBarre[j]= null;
            }
            if(ListeBarre[j+1]==null){
                j=ListeBarre.length;
            }
            j++;
            comprend = false;
        }
        this.ListeNoeudAppui[i] = null;
    }
    //supprime le Noeud associée à la case indiquée dans ListeNoeudSimple ainsi que les Barres dont il est une extrémité
    public void supprNoeud(int i){
        int j=0;
        boolean comprend = false;
        //parcourt tout le tableau à la recherche des Barres qui contiennent le Noeud
        while (j< ListeBarre.length){
            if(ListeBarre[j].getDepart()==ListeNoeudSimple[i] ){
                comprend=true;
            }
            if(ListeBarre[j].getArrivee()==ListeNoeudSimple[i] ){
                comprend=true;
            }
            if(comprend==true){
                ListeBarre[j]= null;
            }
            if(ListeBarre[j+1]==null){
                j=ListeBarre.length;
            }
            j++;
            comprend = false;
        }
        ListeNoeudSimple[i] = null;
    }
    
    //renvoie le Noeud associé à la case indiquée du tableau ListeNoeudSimple
    public NoeudSimple donneNoeudTreillis(int i){
        return ListeNoeudSimple[i];
    }
    //renvoie l'Appui associé à la case indiquée du tableau ListeNoeudAppui
    public NoeudAppui donneAppuiTreillis(int i){
        return ListeNoeudAppui[i];
    }
    //renvoie la Barre associée à la case indiquée du tableau ListeBarre
    public Barre donneBarreTreillis(int i){
        return ListeBarre[i];
    }
    
    //affichage
    public String toString(){
        String res ="Treillis associé à un Terrain "+T+" comprend :\n";
        
        res =res+"Les Noeuds :\n";
        int i=0;
        while (i< ListeNoeudSimple.length){
            res =res+"  "+ListeNoeudSimple[i]+"\n";
            if(ListeNoeudSimple[i+1]==null){
                i=ListeNoeudSimple.length;
            }
            i++;
        }
        
        res =res+"Les Appuis :\n";
        i=0;
        while (i< ListeNoeudAppui.length){
            res =res+"  "+ListeNoeudAppui[i]+"\n";
            if(ListeNoeudAppui[i+1]==null){
                i=ListeNoeudAppui.length;
            }
            i++;
        }
        
        res =res+"Les Barres :\n";
        i=0;
        while (i< ListeBarre.length){
            res =res+"  "+ListeBarre[i]+"\n";
            if(ListeBarre[i+1]==null){
                i=ListeBarre.length;
            }
            i++;
        }
        
        return res;
    }
    
    
    public static void main (String[] args){
        //on créer un Terrain et ses TriangleTerrains
        Terrain Terrain = new Terrain(0,10,0,10);
        Point A = new Point(0,3);
        Point B = new Point(2,3);
        Point C = new Point(4,0);
        TriangleTerrain TT0 = new TriangleTerrain(A,B,C);
        Point D = new Point(6,0);
        Point E = new Point(8,3);
        Point F = new Point(10,3);
        TriangleTerrain TT1 = new TriangleTerrain(D,E,F);
        
        
        //on créer un Treillis
        Catalogue CATA = new Catalogue();
        Treillis Trei0 = new Treillis(Terrain,CATA);
        
        //on lui ajoute des Appuis
        Trei0.ajoutAppui(Terrain, TT0, 0, 0.5);
        System.out.println(NoeudAppui.donneAppui(0));
        Trei0.ajoutAppui(Terrain, TT1, 1, 0.5);
        System.out.println(NoeudAppui.donneAppui(2));
        
        
        //on crée des Noeuds
        Trei0.ajoutNoeudSimple(Terrain,3,6);
        System.out.println(Trei0.donneNoeudTreillis(0));
        Trei0.ajoutNoeudSimple(Terrain,5,3);
        System.out.println(Trei0.donneNoeudTreillis(1));
        Trei0.ajoutNoeudSimple(Terrain,7,6);
        System.out.println(Trei0.donneNoeudTreillis(2));
        
        //on crée des Barres reliant les Noeuds et les Appuis
        
        Trei0.ajoutBarre(Trei0.donneNoeudTreillis(0), Trei0.donneNoeudTreillis(1), CATA.getAcier());
        System.out.println(Trei0.donneBarreTreillis(0));
        Trei0.ajoutBarre(Trei0.donneNoeudTreillis(1), Trei0.donneNoeudTreillis(2), CATA.getAcier());
        System.out.println(Trei0.donneBarreTreillis(1));
        Trei0.ajoutBarre(Trei0.donneNoeudTreillis(2), Trei0.donneNoeudTreillis(0), CATA.getAcier());
        System.out.println(Trei0.donneBarreTreillis(2));
        
        Trei0.ajoutBarre(Trei0.donneAppuiTreillis(0), Trei0.donneNoeudTreillis(1), CATA.getAcier());
        System.out.println(Trei0.donneBarreTreillis(3));
        Trei0.ajoutBarre(Trei0.donneAppuiTreillis(0), Trei0.donneNoeudTreillis(0), CATA.getAcier());
        System.out.println(Trei0.donneBarreTreillis(4));
        
        Trei0.ajoutBarre(Trei0.donneNoeudTreillis(1), Trei0.donneAppuiTreillis(1), CATA.getAcier());
        System.out.println(Trei0.donneBarreTreillis(5));
        Trei0.ajoutBarre(Trei0.donneNoeudTreillis(2), Trei0.donneAppuiTreillis(1), CATA.getAcier());
        System.out.println(Trei0.donneBarreTreillis(6));
        
        System.out.println(Trei0);
        

        //on supprime les Appuis
        
        Trei0.supprAppui(1);
        System.out.println(Trei0);
        Trei0.supprAppui(0);
        System.out.println(Trei0);
        
        //on supprime un Noeud
        Trei0.supprNoeud(2);
        System.out.println(Trei0);
        
        //on supprime une Barre
        Trei0.supprBarre(0);
        System.out.println(Trei0);
        
        
    }
}
