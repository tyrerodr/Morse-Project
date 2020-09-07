/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohuffman;

import TDAS.BinaryTree;
import TDAS.Util;
import java.util.HashMap;
import java.util.List;
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
        Util.leerArchivo();
        Util.cargarCirculo();
       
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
        BinaryTree<String> tree = new BinaryTree<>();
        HashMap<String, List<String>> mapa = Util.leerArchivo();
        tree.crearArbolMorse(mapa).preOrden();
        launch(args);
    }
    
}
