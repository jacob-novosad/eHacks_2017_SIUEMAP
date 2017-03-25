
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
public class mainTesting {
//    public static void main(String[] args) {
        MapReader r= new MapReader();
        GridSpace[][] grid0=r.thingy("peckHall0GridColor.png", 1, 1);
        GridSpace[][] grid1=r.thingy("peckHall1GridColor.png", 1, 1);
        GridSpace[][] grid2=r.thingy("peckHall2GridColor.png", 1, 1);
        GridSpace[][] grid3=r.thingy("peckHall3GridColor.png", 1, 1);
        
      
        AStar pathfinder=new AStar(grid0);
        ArrayList<GridSpace> path = pathfinder.findPath(29, 5, 34, 20);
        for(int i = 0; i < path.size(); i++){
            System.out.println( path.get(i).getX() + "," +  path.get(i).getY());
        }
        MapWriter w = new MapWriter();
        w.writePath("peckHall0Path.png", "peckHall0GridColor.png", path, 1, 1);
    }
}
