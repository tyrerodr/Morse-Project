/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohuffman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;


/**
 *
 * @author Robert
 */
public class ProyectoMorse extends Application {
    public static Scene scene;
    public static int horaTamaño = 300;
    
    @Override
    public void init(){
        System.out.println("Datos Cargados!!!");
       
    }
    
    public void start(Stage primaryStage){      
        VentanaArbol i = new VentanaArbol();
        scene = new Scene(i.getRoot(), 700, 500);
        primaryStage.setTitle("PROYECTO MORSE");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    @Override
    public void stop(){
        System.exit(0);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
