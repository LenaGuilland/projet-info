/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sofie
 */
public class Catalogue {
    
    private TypeBarre acier;
    private TypeBarre bois;
    
    public Catalogue(){
        acier = barreAcier();
        bois = barreBois();
    }
        
    public TypeBarre barreAcier(){
        acier = new TypeBarre(20.0,10.0,5.0,12.0,8.0);
        return acier;
    }
    
    public TypeBarre barreBois(){
        bois = new TypeBarre(15,9,4,10,7);
        return bois;
    }
    
    public String toString(String S){
        String res="";
        if(S=="bois"){
            res="cout : "+bois.getCout()+"€\n"+"longueur min : "+bois.getLmin()+"m\n"+"longueur max : "+bois.getLmax()+"m\n"+"résistance compression max : "+bois.getRcmax()+"\n"+"résistance tension max : "+bois.getRtmax();
        }
        else if(S=="acier"){
            res="cout : "+acier.getCout()+"€\n"+"longueur min : "+acier.getLmin()+"m\n"+"longueur max : "+acier.getLmax()+"m\n"+"résistance compression max : "+acier.getRcmax()+"\n"+"résistance tension max : "+acier.getRtmax();
        }
        return res;
    }
    
    //méthodes get/set
    public TypeBarre getAcier(){
        return acier;
    }
    public TypeBarre getBois(){
        return bois;
    }
    
    
    public static void main(String[] args){
        Catalogue CATA = new Catalogue();
        String S = "bois";
        System.out.println(CATA.toString(S));
    }
    
}
