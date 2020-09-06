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
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Bryan
 */
public class Util {
    
    public static HashMap<String, List<String>> leerArchivo() {

        HashMap<String, List<String>> mapa = new HashMap<>();
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
        
        
        
    }
    
    

