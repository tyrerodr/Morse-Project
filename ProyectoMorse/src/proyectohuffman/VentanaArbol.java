/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohuffman;


import java.io.File;
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
     

     
     Circle a = new Circle(245, 127, 16);
     Circle b = new Circle(465, 127, 16);
     Circle c = new Circle(185, 187, 16);
     Circle d = new Circle(295, 187, 16);
     Circle e = new Circle(406, 187, 16);
     Circle f = new Circle(514, 187, 16);
     Circle g = new Circle(267, 251, 16);
     Circle h = new Circle(322, 251, 16);
     Circle i = new Circle(160, 251, 16);
     Circle j = new Circle(215, 251, 16);
     Circle k = new Circle(267, 251, 16);
     Circle l = new Circle(322, 251, 16);
     Circle m = new Circle(380, 251, 16);
     Circle n = new Circle(435, 251, 16);
     Circle o = new Circle(485, 251, 16);
     Circle p = new Circle(540, 251, 16);
     Circle q = new Circle(448, 311, 13);
     Circle r = new Circle(468, 311, 13);
     Circle s = new Circle(488, 311, 13);
     Circle t = new Circle(498, 311, 13);
     Circle u = new Circle(366, 311, 12);

     
     
     root.getChildren().add(a);
     root.getChildren().add(b);
     root.getChildren().add(c);
     root.getChildren().add(d);
     root.getChildren().add(e);
     root.getChildren().add(f);
     root.getChildren().add(g);
     root.getChildren().add(h);
     root.getChildren().add(i);
     root.getChildren().add(j);
     root.getChildren().add(k);
     root.getChildren().add(l);
     root.getChildren().add(m);
     root.getChildren().add(n);
     root.getChildren().add(o);
     root.getChildren().add(p);
     root.getChildren().add(q);
     root.getChildren().add(r);
     root.getChildren().add(s);
     root.getChildren().add(t);
     root.getChildren().add(u);
     /*root.getChildren().add(v);
     root.getChildren().add(w);
     root.getChildren().add(x);
     root.getChildren().add(y);
     root.getChildren().add(z);*/
    
     
     root.setCenter(center);
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
