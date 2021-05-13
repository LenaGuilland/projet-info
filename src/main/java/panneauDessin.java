/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dessinVect;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
/**
 *
 * @author Léna
 */
public class panneauDessin extends BorderPane {
    
    //à gauche :
    private RadioButton rbSelect;
    private RadioButton rbPoint;
    private RadioButton rbSegment;
    
    //à droite :
    private Button bGrouper;
    private Button bCouleur;
    
    //au milieu (canvas = zone de dessin)
    private sousPanneauDessin cZoneDessin;
    
    
    public panneauDessin (){
        this.rbSelect= new RadioButton("Selectionner");
        this.rbPoint= new RadioButton("Point");
        this.rbSegment= new RadioButton("Segment");
        
        VBox vbGauche = new VBox(this.rbSelect, this.rbPoint, this.rbSegment);
        this.setLeft(vbGauche);
        
        this.bGrouper = new Button("Grouper");
        this.bCouleur = new Button("Couleur");
        
        VBox vbDroite = new VBox(this.bGrouper, this.bCouleur);
        this.setRight(vbDroite);
        
        this.cZoneDessin = new sousPanneauDessin(200,200);
        this.setCenter(this.cZoneDessin);
    }
    
}
