/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javax.swing.JFileChooser;
import static proyectohuffman.VentanaArbol.root;

/**
 *
 * @author Bryan
 */
public class Util {
    public static HashMap<String, List<String>> mapa = new HashMap<>();
    public static LinkedList<Circle> circlelist = new LinkedList<>();
    public static HashMap<String, List<String>> circlemapa = new HashMap<>();
   
    public static HashMap<String, List<String>> leerArchivo() {
        try (BufferedReader bff = new BufferedReader(new FileReader("src/recursos/archivo/traducciones.txt"))) {            
            String linea;
            while ((linea = bff.readLine()) != null) {                
                String[] array = linea.split("\\|");
                List<String> lista = new LinkedList<>();
                for(int i=1 ; i<array.length ; i++){
                    lista.add(array[i]);
                }
                mapa.put(array[0], lista);
                
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mapa;
    }

    public static LinkedList<Circle> cargarCirculo() {
        try (BufferedReader bff = new BufferedReader(new FileReader("src/recursos/archivo/circle.txt"))) {
            String linea;
            while ((linea = bff.readLine()) != null) {
                String[] array = linea.split("\\,");
                circlelist.add(new Circle(Double.parseDouble(array[0]), Double.parseDouble(array[1]), Double.parseDouble(array[2])));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Circle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Circle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return circlelist;
    }
        
    
    public static void asignarCirculo(BorderPane pane){
        Iterator<Circle> iterador = circlelist.iterator();
        Iterator<List<String>> i =  mapa.values().iterator();
        
        while(iterador.hasNext()){
            Circle c = iterador.next();
            
            c.setFill(Color.TRANSPARENT);
            pane.getChildren().add(c);
        }
    }
    
    }
    
    

