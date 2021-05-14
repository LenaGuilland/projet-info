/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dessinVect;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
/**
 *
 * @author Léna
 */
public class MainPane extends BorderPane {
    
    //à gauche :
    private RadioButton rbSelect;
    private RadioButton rbPoint;
    private RadioButton rbSegment;
    
    //à droite :
    private Button bGrouper;
    private Button bCouleur;
    
    //au milieu (canvas = zone de dessin)
    private dessinCanvas cZoneDessin;
    
    
    public MainPane (){
        this.rbSelect= new RadioButton("Selectionner");
        this.rbPoint= new RadioButton("Point");
        this.rbSegment= new RadioButton("Segment");
        
        VBox vbGauche = new VBox(this.rbSelect, this.rbPoint, this.rbSegment);
        this.setLeft(vbGauche);
        
        this.bGrouper = new Button("Grouper");
        //action/événement "cliquer sur le bouton grouper"
        this.bGrouper.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println("bouton Grouper cliqué");
            }
        });
        
        this.bCouleur = new Button("Couleur");
        //action/événement "cliquer sur le bouton couleur"
        this.bCouleur.setOnAction((t) -> {
            System.out.println("bouton couleur cliqué");
        });
        this.bCouleur.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                System.out.println("souris sur bouton couleur en : "+t.getX() + "," +t.getY());
            }
        });
        VBox vbDroite = new VBox(this.bGrouper, this.bCouleur);
        this.setRight(vbDroite);
        
        this.cZoneDessin = new dessinCanvas();
        this.setCenter(this.cZoneDessin);
    }
    
}
