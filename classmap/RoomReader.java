package classmap;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author John
 */
public class RoomReader {
    public RoomReader () {
        
    }
    
    public ArrayList<Room> readRooms(String roomFile) {
        ArrayList<Room> rooms= new ArrayList<Room>();
        Scanner fileIn;
        
        try {
            fileIn = new Scanner(new BufferedReader(new FileReader(roomFile)));
            String line=""; 
            while( fileIn.hasNextLine()) {
                line=fileIn.nextLine();
                String[] r =line.split(":");
                rooms.add(new Room(r[1],r[0],Integer.decode(r[2]), Integer.decode(r[3])));
            }
            return rooms;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(RoomReader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    
}
