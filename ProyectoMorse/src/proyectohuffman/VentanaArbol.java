/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohuffman;


import TDAS.Util;
import static TDAS.Util.circlelist;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

import javafx.scene.paint.Color;


/**
 *
 * @author Bryan
 */
public final class VentanaArbol {
    public static BorderPane root = new BorderPane();
    public static HBox top = new HBox();
    public static VBox buttom = new VBox();
    public static VBox center = new VBox();
    public static Stack<String> pila = new Stack();
    public static Thread hilo;

    public VentanaArbol() {
        Util.asignarCirculo(root);
        root.setPadding(new Insets(10));
        root.setStyle("-fx-background-color: #ffffff;");
        crearPanelTop();
        bottom();
        center();
        
        
    }

       
    public void center(){
     File file = new File("Imagen.png");
     Image image = new Image(file.toURI().toString());
     center.getStylesheets().add(file.toURI().toString());
     BackgroundImage backgroundimage = new BackgroundImage(image,  
                                             BackgroundRepeat.NO_REPEAT,  
                                             BackgroundRepeat.NO_REPEAT,  
                                             BackgroundPosition.CENTER,  
                                                BackgroundSize.DEFAULT); 
     Background background = new Background(backgroundimage); 
     center.setBackground(background);      
     root.setCenter(center);
    }
            
    
    public void enceder(String Letra){
        for(Map.Entry<String, List<String>> entry : Util.mapa.entrySet()) {
            for (int i = 0; i < Letra.length(); i++) {
                if(entry.getKey().equals(Letra.charAt(i))){
                    acumularPila(entry.getValue());
                }
            }
        }
    }
    
    
    public void acumularPila(List<String> letra){
        List<String> val = new LinkedList<>();
        for(String a : letra){
            if((".".equals(a) || "-".equals(a))){
                val.add(a);
                for (Map.Entry<String, List<String>> entry : Util.mapa.entrySet()) {
                    if(val.equals(entry.getValue())){
                        pila.push(entry.getKey());
                    }
                }
                }
        }  
        val.clear();
        hilo.start();
    }
    
    
    
    public static void generarHilo(){
        Thread hilo = new Thread(new Runnable() {
        @Override
        public void run() {
            pila = invertir(pila);
            while(!pila.isEmpty()){                
            System.out.println("-----------");
            System.out.println(pila);
            String obj = pila.pop();
            
            Iterator<Circulo> iterador = circlelist.iterator();
            while (iterador.hasNext()) {
                Circulo c = iterador.next();
                Platform.runLater(() -> {      
                    if(obj.equals(c.getReferencia())){
                    c.getCircle().setFill(Color.YELLOW);  
                }
                });
                c.getCircle().setFill(Color.TRANSPARENT);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(VentanaArbol.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }});setThread(hilo);
        }
    
    public static void setThread(Thread puestoThread) {
        VentanaArbol.hilo = puestoThread;
    }
    
    
    
    public static Stack invertir(Stack pila){
        Stack pilanew = new Stack();
        while(!pila.isEmpty()){
            pilanew.push(pila.pop());
        } 
        return pilanew;
    }

    
    public void bottom() {
        Label msg1 = new Label("Seleccione el recorrido \"Letra\""); 
        msg1.setAlignment(Pos.CENTER);
        Button btnRecorrer = new Button("RECORRER");
        HBox parteBoton = new HBox(btnRecorrer);
        parteBoton.setAlignment(Pos.CENTER);
        TextField txtArchivo = new TextField();
        buttom.getChildren().addAll(msg1,txtArchivo,parteBoton);
        buttom.setSpacing(10);
        buttom.setAlignment(Pos.CENTER);
        root.setBottom(buttom);
        
        btnRecorrer.setOnMouseClicked((event) -> {
            generarHilo();
            enceder(txtArchivo.getText());
            txtArchivo.setText(null);
            
        });
    }
    

     public void crearPanelTop() {
        Label icono = new Label("ARBOL MORSE");
        icono.setTextFill(Color.WHITE);
        VBox iconoBox = new VBox(icono);
        top.getChildren().add(iconoBox);
        top.setStyle("-fx-background-color: #5ce0d3;");
        top.setAlignment(Pos.CENTER);
        root.setTop(top);
     }
     
    
    public static BorderPane getRoot() {
        return root;
    }
    
}
