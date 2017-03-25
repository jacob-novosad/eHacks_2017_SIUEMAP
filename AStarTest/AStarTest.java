/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package astartest;

import java.util.ArrayList;

/**
 *
 * @author Jeremiah
 */
public class AStarTest {

    /**
     * @param args the command line arguments
     */
    public void testAStar() {
        // TODO code application logic here
        
        MapReader r= new MapReader();
        r.thingy("peckHall0GridColor.png", 1, 1);
        
        
        
        
        GridSpace[][] grid = new GridSpace[10][10];
        int startX = 7;
        int startY = 9;
        int endX = 0;
        int endY = 0;
        
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                GridSpace temp = new GridSpace(i,j,0,1);
                grid[i][j] = temp;
            }
        }
        
        grid[1][0].setType(0);
        grid[1][1].setType(0);
        grid[2][1].setType(0);
        grid[2][2].setType(0);
        
        grid[4][5].setType(0);
        grid[5][5].setType(0);
        grid[5][6].setType(0);
        grid[6][6].setType(0);
        
        AStar star = new AStar(grid);
        ArrayList<GridSpace> path = star.findPath(startX, startY, endX, endY);
        String p = "";
        for(int i = 0; i < path.size(); i++){
            p.concat("("+path.get(i).getX()+","+path.get(i).getY()+") ");
            System.out.printf("(%d,%d)",path.get(i).getX(),path.get(i).getY());
        }
        
        System.out.println(p);

    }

    
}
