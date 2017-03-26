/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classmap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label; 
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Jacob
 */
public class ClassMap extends Application {
     public static Driver driver; 
     public static String building1;
     public static String building2;
     public static String[] peckOutputMaps = {"peckHall0Out.png","peckHall1Out.png","peckHall2Out.png","peckHall3Out.png"};
     public boolean loopC = false;
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
      
        int x = 1;
       
        String[] building1Images = new String[4];
        building1Images[0]="building1Floor0.png";
        building1Images[1]="building1Floor1.png";
        building1Images[2]="building1Floor2.png";
        building1Images[3]="building1Floor3.png";
        String[] building2Images = new String[4];
        building2Images[0]="building2Floor0.png";
        building2Images[1]="building2Floor1.png";
        building2Images[2]="building2Floor2.png";
        building2Images[3]="building2Floor3.png";
                
        GridPane test = new GridPane();
        
        Text instructions = new Text ("Enter the FROM and TO then press enter");
        
        TextField fromBuilding = new TextField("Enter BUILDING From");
        fromBuilding.setTooltip(new Tooltip("Peck Hall, Engineering Building, Lovejoy Library, MUC"));
        
        TextField fromRoom = new TextField("Enter ROOM From");
        fromBuilding.setTooltip(new Tooltip(""));
        
        TextField toBuilding = new TextField("Enter BUILDING to");
        fromBuilding.setTooltip(new Tooltip("Peck Hall, Engineering Building, Lovejoy Library, MUC"));
        
        TextField toRoom = new TextField("Enter ROOM to");
        fromBuilding.setTooltip(new Tooltip(""));
        
        Button enter = new Button("Enter");
        
        
        test.add(instructions,0,0);
        test.add(fromBuilding,0,1);
        test.add(fromRoom,1,1);
        test.add(toBuilding,2,1);
        test.add(toRoom,3,1);
        test.add(enter,0,2);
        
        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String buildings = "Peck Hall, Engineering Building, Lovejoy Library, MUC";
                String fromBuildingData = fromBuilding.getText();
                building1=fromBuildingData;
                String fromRoomData = fromRoom.getText();
                String toBuildingData = toBuilding.getText();
                building2=toBuildingData;
                String toRoomData = toRoom.getText();
                if((buildings.contains(fromBuildingData)&& (buildings.contains(toBuildingData))))
                {
                    String output=driver.path(fromBuildingData, fromRoomData, toBuildingData, toRoomData);
                    
                    if(output=="") {
                        loopC = true;
                    }      
                    
                    try {
                        start(primaryStage);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ClassMap.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else {                
                    System.out.println("Wrong Building Name, that building doesn't exist. Totally not because we didn't have time to implement it your just crazy.");}
            }
        });
        
        Scene testScene = new Scene(test,700,600);
//        
//  
//        GridPane test = new GridPane();
//        
//        TextField fromBuilding = new TextField("Enter Building From");
//        
//        test.add(fromBuilding,0,0);
//        Scene testScene = new Scene(test,700,600);
//        primaryStage.setScene(testScene);
//        primaryStage.show();
     
        
        if(loopC) {
            /////////// building 1
            if(building1.compareTo("Peck Hall")==0){
                building1Images[0]="peckHall0Out.png";
                building1Images[1]="peckHall1Out.png";
                building1Images[2]="peckHall2Out.png";
                building1Images[3]="peckHall3Out.png";
            } else { ///////if engineering

            }

            //////////building 2
            if(building2.compareTo("Peck Hall")==0){
                building2Images[0]="peckHall0Out.png";
                building2Images[1]="peckHall1Out.png";
                building2Images[2]="peckHall2Out.png";
                building2Images[3]="peckHall3Out.png";
            } else { ///////if engineering

            }
        }
        
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
        Image building1Floor0 = new Image(new FileInputStream(building1Images[0]));  
        Image building1Floor1 = new Image(new FileInputStream(building1Images[1]));  
        Image building1Floor2 = new Image(new FileInputStream(building1Images[2]));  
        Image building1Floor3 = new Image(new FileInputStream(building1Images[3]));  
        /**********************************************
         * Possible building 2 floor plan images
         **********************************************/
        Image building2Floor0 = new Image(new FileInputStream(building2Images[0]));  
        Image building2Floor1 = new Image(new FileInputStream(building2Images[1]));  
        Image building2Floor2 = new Image(new FileInputStream(building2Images[2]));  
        Image building2Floor3 = new Image(new FileInputStream(building2Images[3]));  
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
        
                // Adds default ImageView to the gridpane in column 0 row 1
        gridPane.add(floor0,0,2);

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
        Text title = new Text("SIUE Class Finder");
        title.setFont(Font.font ("Verdana",20));
        title.setFill(Color.RED);
        gridPane.add(title,0,0);
        // adding buttons to Hbox inside of gridPane 
        hBox.getChildren().add(campusMap);
        hBox.getChildren().add(floor0Button);
        hBox.getChildren().add(floor1Button);
        hBox.getChildren().add(floor2Button);
        hBox.getChildren().add(floor3Button);
        hBox.getChildren().add(floor0Button2);
        hBox.getChildren().add(floor1Button2);
        hBox.getChildren().add(floor2Button2);
        hBox.getChildren().add(floor3Button2);
        gridPane.add(hBox,0,1);
        // Totally not driving a white van ^^^^^^^^^ -_o
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        Scene scene = new Scene(gridPane,700,600);
        primaryStage.setTitle("Class Map");
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        if (loopC == false){

        primaryStage.setScene(testScene);
        primaryStage.show();
     
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        driver=new Driver();
        launch(args);
    }
    
}