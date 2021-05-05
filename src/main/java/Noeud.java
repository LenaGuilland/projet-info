/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sofie
 */
public class Noeud {
    private int i;
    
    //variable servant à numéroter les Noeuds
    private static int numero=0;
    
    //constructeur
    public Noeud(){
        this.i = numero;
        numero++;
    }
    
    //méthodes get/set
    public int getIdent(){
        return this.i;
    }
    
}
