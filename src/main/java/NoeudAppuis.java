/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liiina55
 */
public class NoeudAppuis extends Point{
    
    private int numero; 
    private double posAppuis;
    private TriangleTerrain TT;

    //constructeur
    public NoeudAppuis(int numero, double posAppuis){
        this.numero = numero;
        this.posAppuis = posAppuis;
    }
    
    public int getnumero(){
        return this.numero;
    }
    
    public double getposAppuis(){
        return this.posAppuis;
    }
    
    
    //méthode numero
    public int Numero(int j){
        if((j>=81)||(j<0)){
            throw new Error("la valeur de l'indice n'est pas valide");
        }
        retrun
    }
    
    public static void main(String[] args){
         
    }
}