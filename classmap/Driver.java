
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author John
 */
public class Driver {
    MapReader mreader= new MapReader();
    RoomReader rreader= new RoomReader();
    ArrayList<GridSpace[][]> pgrid;
    ArrayList<Room> prooms;
    Room[] stairs =new Room[4];
    
    String[] peckOutputMaps = {"peckHall0Out.png","peckHall1Out.png","peckHall2Out.png","peckHall3Out.png"};
    String[] peckOriginalMaps = {"peckHall0.png","peckHall1.png","peckHall2.png","peckHall3.png"};
    
    public Driver(){
        pgrid = new ArrayList<GridSpace[][]>();
        prooms = new ArrayList<Room>();
        pgrid.add(0,mreader.thingy("peckHall0GridColor.png", 1, 1));
        pgrid.add(1,mreader.thingy("peckHall1GridColor.png", 1, 1));
        pgrid.add(2,mreader.thingy("peckHall2GridColor.png", 1, 1));
        pgrid.add(3,mreader.thingy("peckHall3GridColor.png", 1, 1));
        
        ArrayList<Room> rooms0 = rreader.readRooms("peckHall0Rooms.txt");        
        ArrayList<Room> rooms1 = rreader.readRooms("peckHall1Rooms.txt");        
        ArrayList<Room> rooms2 = rreader.readRooms("peckHall2Rooms.txt");       
        ArrayList<Room> rooms3 = rreader.readRooms("peckHall3Rooms.txt");
        
        for(Room r:rooms0)prooms.add(r);
        for(Room r:rooms1)prooms.add(r);
        for(Room r:rooms2)prooms.add(r);
        for(Room r:rooms3)prooms.add(r);
        
        for(Room r:prooms) {
            System.out.println(r.getRoomNumber());
        }
        stairs[0]=new Room("0Stairs","Peck Hall", 52, 47);
        stairs[1]=new Room("1Stairs","Peck Hall", 49, 48);
        stairs[2]=new Room("2Stairs","Peck Hall", 55, 45);
        stairs[3]=new Room("3Stairs","Peck Hall", 49, 47);
        
        prooms.add(stairs[0]);
        prooms.add(stairs[1]);
        prooms.add(stairs[2]);
        prooms.add(stairs[3]);
            
    }
    
    public void clearOutput(){
        MapWriter mwriter =new MapWriter();
        ArrayList<GridSpace> nill = new ArrayList<GridSpace>();
        mwriter.writePath(peckOutputMaps[0],peckOriginalMaps[0], nill, 1, 1);
    }
    
    public String path(String startBuilding,String startRoom,String targetBuilding, String targetRoom ){
        clearOutput();
        if(startBuilding==targetBuilding){
            Room r1=findRoom(startRoom);
            Room r2=findRoom(targetRoom);
            if(r1 == null || r2 == null){
                return "ROOMS NOT FOUND";
            }
            if(r1.getFloor()==r2.getFloor()) {
                
                if(r1.getBuilding().compareTo("Peck Hall")==0){
                    System.out.println(r1.getFloor());
                    AStar pathfinder=new AStar(pgrid.get(r1.getFloor()));
                    
                    ArrayList<GridSpace> path=pathfinder.findPath(r1.getX(), r1.getY(), r2.getX(), r2.getY());
                    MapWriter mwriter =new MapWriter();
                    mwriter.writePath(peckOutputMaps[r1.getFloor()],peckOriginalMaps[r1.getFloor()], path, 1, 1);
                    
                    return "";
                } else {  // else enginering building
                    return "EBS";
                }              
            } else { // not same floor;
                if(r1.getBuilding().compareTo("Peck Hall")==0){
                    AStar pathfinder=new AStar(pgrid.get(r1.getFloor()));
                    
                    ArrayList<GridSpace> path=pathfinder.findPath(r1.getX(), r1.getY(), stairs[r1.getFloor()].getX(), stairs[r1.getFloor()].getY());
                    
                    MapWriter mwriter =new MapWriter();
                    mwriter.writePath(peckOutputMaps[r1.getFloor()],peckOriginalMaps[r1.getFloor()], path, 1, 1);
                    
                    AStar pathfinder2=new AStar(pgrid.get(r2.getFloor()));
                    ArrayList<GridSpace> path2=pathfinder2.findPath(stairs[r2.getFloor()].getX(), stairs[r2.getFloor()].getY(),r2.getX(), r2.getY() );
                    
                    MapWriter mwriter2 =new MapWriter();
                    mwriter.writePath(peckOutputMaps[r2.getFloor()],peckOriginalMaps[r2.getFloor()], path2, 1, 1);
                    
                    return "";
                } else {// else engineeringbuilding
                    return "EBD";
                }
            }
        }
        else {
            return "NOT IMPLEMENTED";
        }
    }
    
    public Room findRoom(String roomNumber) {
        System.out.println(roomNumber);
        
        for(Room r:prooms) {
            //System.out.println( r.getRoomNumber() );
            if(r.getRoomNumber().compareTo(roomNumber)==0){
                return r;
            }
        }
        return null;
    }
    
}
