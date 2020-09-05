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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Bryan
 */
public class Util {
    
    public static String leerTexto(String archivo){
        String line = null;
        try(BufferedReader bffr = new BufferedReader(new FileReader("/src"+archivo))) {
            String linea;
            while ((linea = bffr.readLine()) != null) {
                line= line + linea;
            }    
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return line;
    }
    public static HashMap<String,Integer> calcularFrecuencias(String texto){
        HashMap<String,Integer> mapa = new HashMap<>();
        String[] caracteres = texto.split("");
        for (String caracter : caracteres) {
            if (mapa.containsKey(caracter)) {
                mapa.put(caracter, mapa.get(caracter) + 1);
            } else {
                mapa.put(caracter, 1);
            }  
        }
        return mapa;
    }
    public static String binarioHexadecimal(String binario){
        String hexadecimal = "";
        String[] bin = binario.split(" ");
        for(int i = 0;i< bin.length;i+=1){ 
            hexadecimal+=validacionBinario(bin[i])+" ";
        }
        return hexadecimal;
    }
    private static String validacionBinario(String cadena){
        switch (cadena.length()) {
            case 4:
                return String.valueOf(Integer.toHexString(Integer.parseInt(cadena,2)));
            case 3:
                return String.valueOf(Integer.toHexString(Integer.parseInt(cadena,2)))+" -";
            case 2:
                return String.valueOf(Integer.toHexString(Integer.parseInt(cadena,2)))+" - -";
            case 1:
                return String.valueOf(Integer.toHexString(Integer.parseInt(cadena,2)))+" - - -";
        }  
        return null;   
    }
    public static String hexadecimalBinario(String hexadecimal){
        String binario = "";
        String[] bin = hexadecimal.split(" ");
        for(int i = 0;i< bin.length;i+=1){ 
            binario += validacionHexadecimal(bin[i])+" ";
        }
        return binario;
    }
    //Validacion inversa
    private static String validacionHexadecimal(String cadena){
        String Hexa = ""; 
        if(!cadena.equals("-"))   
            Hexa = String.valueOf(Integer.toBinaryString(Integer.parseInt(cadena,16)));
        switch (Hexa.length()){
                case 1:
                    return "000" + Hexa; 
                case 2:
                    return "00" + Hexa;
                case 3:   
                    return "0" + Hexa;
                case 4:
                    return Hexa;
            }
        return "";
    }

    public void guardarTexto(String nombreArchivo, String texto, HashMap<String,String> mapa){
        
        
        
    }
    
    
}
