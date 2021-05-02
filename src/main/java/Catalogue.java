/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liiina55
 */
public class Catalogue {
    
    private TypeBarre acier;
    private TypeBarre bois;
    
    public Catalogue(){
        this.acier = barreAcier();
        this.bois = barreBois();
    }
        
    public TypeBarre barreAcier(){
        acier.setCout(20);
        acier.setLmax(10);
        acier.setLmin(5);
        acier.setRcmax(12);
        acier.setRtmax(8);
        return acier;
    }
    
    public TypeBarre barreBois(){
        bois.setCout(15);
        bois.setLmax(9);
        bois.setLmin(4);
        bois.setRcmax(10);
        bois.setRtmax(7);
        return bois;
    }
    
    public String toString(TypeBarre b){
        String res="";
        if(b==barreBois()){
            res="cout : "+bois.getCout()+"€\n"+"longueur min : "+bois.getLmin()+"m\n"+"longueur max : "+bois.getLmax()+"m\n"+"résistance compression max : "+bois.getRcmax()+"\n"+"résistance tension max : "+bois.getRtmax();
        }
        else if(b==barreAcier()){
            res="cout : "+acier.getCout()+"€\n"+"longueur min : "+acier.getLmin()+"m\n"+"longueur max : "+acier.getLmax()+"m\n"+"résistance compression max : "+acier.getRcmax()+"\n"+"résistance tension max : "+acier.getRtmax();
        }
        return res;
    }
    
    public static void main(String[] args){
        TypeBarre b= new TypeBarre();
        System.out.println(b.toString());
    }
}
