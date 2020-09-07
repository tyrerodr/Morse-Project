/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohuffman;


import TDAS.Util;
import java.io.File;
import java.util.List;
import java.util.Map;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Bryan
 */
public final class VentanaArbol {
    public static BorderPane root = new BorderPane();
    public static HBox top = new HBox();
    public static VBox buttom = new VBox();
    public static VBox center = new VBox();

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
        for (Map.Entry<String, List<String>> entry : Util.mapa.entrySet()) {
            for (int i = 0; i < Letra.length(); i++) {
                if(entry.getKey().contains(Letra)){
                    entry.getValue();
                }
        System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
            }
        }
    }
    
    
    public void pila(){
        
        
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
            enceder(txtArchivo.getText());
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
