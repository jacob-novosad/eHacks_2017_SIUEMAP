/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classmap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Jacob
 */
public class ClassMap extends Application {
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
      
        // Makes a grid pane, good for multiple "slots"
        GridPane gridPane = new GridPane();

        
        //Tempory testing images 
//        Image building1Floor0 = new Image(new FileInputStream("peckHall0.png"));  
//        Image building1Floor1 = new Image(new FileInputStream("peckHall1.png"));  
//        Image building1Floor2 = new Image(new FileInputStream("peckHall2.png"));  
//        Image building1Floor3 = new Image(new FileInputStream("peckHall3.png"));  
        Image campus = new Image(new FileInputStream("campusMap.png"));
        /***************************************
         *  Building 1 floor plan images
         **************************************/
        Image building1Floor0 = new Image(new FileInputStream("building1Floor0.png"));  
        Image building1Floor1 = new Image(new FileInputStream("building1Floor1.png"));  
        Image building1Floor2 = new Image(new FileInputStream("building1Floor2.png"));  
        Image building1Floor3 = new Image(new FileInputStream("building1Floor3.png"));  
        /**********************************************
         * Possible building 2 floor plan images
         **********************************************/
        Image building2Floor0 = new Image(new FileInputStream("building2Floor0.png"));  
        Image building2Floor1 = new Image(new FileInputStream("building2Floor1.png"));  
        Image building2Floor2 = new Image(new FileInputStream("building2Floor2.png"));  
        Image building2Floor3 = new Image(new FileInputStream("building2Floor3.png"));  
        /***************************************************
         * ImageView allows us to display an image and it 
         * takes an image, we will be updating this with 
         * new images with object.setImage with button press
         ***************************************************/
        ImageView floor0 = new ImageView(building1Floor0);
        //ImageView floor1 = new ImageView(peck1);
//        ImageView floor2 = new ImageView(peck2);
//        ImageView floor3 = new ImageView(peck3);
        
        // Ratio variables used mostly for testing, but allows me to stretch/shrink 
        int heightWidthRatio = 600;
        int widthRatio = 1200;
        
        
        // Keeps the image height and width ratio change the same (like pulling on the corner of an image
        floor0.setPreserveRatio(true);
        floor0.setFitHeight(heightWidthRatio);
        floor0.setFitWidth(widthRatio);

        /*********************** Buttons ****************************/
        Button campusMap = new Button("Campus Map");
        Button floor0Button = new Button("B1 Basement");
        Button floor1Button = new Button("B1 Floor 1");
        Button floor2Button = new Button("B1 Floor 2");
        Button floor3Button = new Button("B1 Floor 3");
        Button floor0Button2 = new Button("B2 Basement");
        Button floor1Button2 = new Button("B2 Floor 1");
        Button floor2Button2 = new Button("B2 Floor 2");
        Button floor3Button2 = new Button("B2 Floor 3");
        
        // Adds default ImageView to the gridpane in column 0 row 1
        gridPane.add(floor0,0,1);

        // Button Triggers
        floor0Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                floor0.setImage(building1Floor0);
            }
        });
        
        floor1Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                floor0.setImage(building1Floor1);
            }
        });
        
        floor2Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                floor0.setImage(building1Floor2);
            }
        });
        
        floor3Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                floor0.setImage(building1Floor3);
            }
        });
        
        floor0Button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                floor0.setImage(building2Floor0);
            }
        });
        
        floor1Button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                floor0.setImage(building2Floor1);
            }
        });
        
        floor2Button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                floor0.setImage(building2Floor2);
            }
        });
        
        floor3Button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                floor0.setImage(building2Floor3);
            }
        });
        campusMap.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                floor0.setImage(campus);
            }
        });
        
        
        // Putting a frame inside the gridPane to group all my buttons together in an easy fashion 
        HBox hBox = new HBox();
        
        // adding buttons to Hbox inside of gridPane 
        hBox.getChildren().add(campusMap);
        hBox.getChildren().add(floor0Button);
        hBox.getChildren().add(floor1Button);
        hBox.getChildren().add(floor2Button);
        hBox.getChildren().add(floor3Button);
        gridPane.add(hBox,0,0);
        // Totally not driving a white van ^^^^^^^^^ -_o

        Scene scene = new Scene(gridPane,1000,600);
        primaryStage.setTitle("Class Map");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
