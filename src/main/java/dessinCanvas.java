/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dessinVect;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author Léna
 */
public class dessinCanvas extends Pane{
    
    private Canvas vraiCanvas;
    
    public dessinCanvas(){
        this.vraiCanvas = new Canvas(this.getWidth(), this.getHeight());  
        this.getChildren().add(this.vraiCanvas);
        this.vraiCanvas.heightProperty().bind(this.heightProperty());
        this.vraiCanvas.heightProperty().addListener((o)-> {
        System.out.println("w = "+this.vraiCanvas.getWidth()+" ; h = "+ this.vraiCanvas.getHeight());
            this.toutDessiner();
        });
        this.vraiCanvas.widthProperty().bind(this.widthProperty());
        this.vraiCanvas.widthProperty().addListener((o)-> {
                        this.toutDessiner();
        });
        this.toutDessiner();
    }
    
    public void toutDessiner(){
       System.out.println("redessiner");
       GraphicsContext context = this.vraiCanvas.getGraphicsContext2D();
       context.setFill(Color.RED);
       context.fillRect(0,0,this.vraiCanvas.getWidth(), this.vraiCanvas.getHeight());
    }
            
}
