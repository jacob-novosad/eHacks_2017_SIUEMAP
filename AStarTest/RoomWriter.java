
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
public class RoomWriter {
    


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("File:");
        String gridColorMap = sc.next();
        System.out.println("Xoff:");
        int xoff = sc.nextInt();
        System.out.println("Yoff:");
        int yoff= sc.nextInt();
        
        System.out.println("Building Name:");
        String building = sc.next();
        building += sc.nextLine();
        System.out.println(building);
         
        ArrayList<Room> rooms= new ArrayList<Room>();
        
        MapReader r= new MapReader();
        GridSpace[][] grid = r.thingy(gridColorMap, xoff, yoff);
        
        for(int y=0;y<6;y++) {//y<grid[0].length
            for(int x=0;x<grid.length;x++) {
                if(grid[x][y].getType()==2) {
                    System.out.println( "Room At ("+ (xoff+ x* 7)+","+(yoff+ y* 7)+")" );
                    
                    System.out.println("Number:");
                    String roomNum = sc.nextLine();
                    
                    rooms.add(new Room(roomNum,building,x,y));   
                }
            }
        }
        
        
        System.out.println("All Rooms Found for: " + gridColorMap);
        System.out.println("Enter Write Folder:");
        String fileOut = sc.next();
        BufferedWriter out;
        
        try {
            out = new BufferedWriter(new FileWriter(fileOut));
            for(Room room:rooms){
                out.write(room.getBuilding() + ":" + room.getRoomNumber() + ":" + room.getX() + ":" + room.getY()+"\n");
                out.flush();
            }
            System.out.println("File writen");
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(RoomWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}