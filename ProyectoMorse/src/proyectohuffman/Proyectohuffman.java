/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohuffman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.LinkedList;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author Robert
 */
public class Proyectohuffman extends Application {
    public static Scene scene;
    public static int horaTamaño = 300;
    
    @Override
    public void init(){
        System.out.println("Datos Cargados!!!");
       
    }
    
    public void start(Stage primaryStage){      
        VentanaArbol i = new VentanaArbol();
        scene = new Scene(i.getRoot(), 600, horaTamaño);
        primaryStage.setTitle("PROYECTO HUFFMAN");
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
