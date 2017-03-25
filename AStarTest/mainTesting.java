
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
    public static void main(String[] args) {
        MapReader r= new MapReader();
        GridSpace[][] grid=r.thingy("peckHall0GridColor.png", 1, 1);
        AStar pathfinder=new AStar(grid);
        ArrayList<GridSpace> path = pathfinder.findPath(29, 5, 34, 20);
        for(GridSpace i:path) {
            System.out.println( i.getX() + "," + i.getY());
        }
    }
}
