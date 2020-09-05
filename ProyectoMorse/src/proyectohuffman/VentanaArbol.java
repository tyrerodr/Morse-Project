/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohuffman;


import java.io.File;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

/**
 *
 * @author Bryan
 */
public final class VentanaArbol {
    final FileChooser fileChooser = new FileChooser();
    public static BorderPane root = new BorderPane();
    public static HBox top = new HBox();

    public VentanaArbol() {
        root.setPadding(new Insets(10));
        root.setStyle("-fx-background-color: #ffffff;");
        crearPanelTop();
        center();
        
    }

    
    public void center() {
        VBox parteExterna = new VBox();
        HBox mensajeMedico = new HBox();
        Label msg1 = new Label("Seleccione la opcion que desea");
        mensajeMedico.getChildren().addAll(msg1);
        mensajeMedico.setAlignment(Pos.CENTER);

        Button btnComprimir = new Button("COMPRIMIR");
        Button btnDescomprimir = new Button("DESCOMPRIMIR");
        
        HBox parteBoton = new HBox(btnComprimir,btnDescomprimir);
        parteBoton.setAlignment(Pos.CENTER);
        parteBoton.setSpacing(10);
        parteExterna.getChildren().addAll(mensajeMedico, parteBoton);

        parteExterna.setAlignment(Pos.CENTER);
        parteExterna.setSpacing(15);
        root.setCenter(parteExterna);
        
        btnComprimir.setOnMouseClicked((event) -> {
             VBox parteExterna2 = new VBox(); 
             Label archvit = new Label("Nombre del Archivo: ");
             TextField txtArchivo = new TextField();
             HBox partArchivo = new HBox(archvit,txtArchivo);
             partArchivo.setAlignment(Pos.CENTER);
             partArchivo.setSpacing(10);
             Button btnConfirmar = new Button("CONFIRMAR");
            HBox parteBoton2 = new HBox(btnConfirmar);
            parteBoton2.setAlignment(Pos.CENTER);
            parteExterna2.getChildren().addAll(partArchivo, parteBoton2);
            parteExterna2.setSpacing(10);
            parteExterna2.setAlignment(Pos.CENTER);
            root.setCenter(parteExterna2);
            
            btnConfirmar.setOnMouseClicked((e) -> {
            
                
                
                root.getChildren().clear();
                crearPanelTop();
                center();
           });
    
    });
    }
    
        
        
    

    
     public void crearPanelTop() {
        Label icono = new Label("MENÚ DE OPCIONES");
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
