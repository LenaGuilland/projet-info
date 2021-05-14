/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dessinVect;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author Léna
 */
public class Main extends Application {

    @Override
    public void start(Stage fenetre) {
        Scene sc = new Scene(new MainPane(), 800, 600);
        fenetre.setScene(sc);
          fenetre.show();
    }

    public static void main(String[] args) {
        launch();
    }

}