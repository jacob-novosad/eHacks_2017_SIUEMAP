package astartest;


import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Class name: AStar.java
 * 
 * Description: The A* algorithm is implemented in this class by using the
 * GridSpace class for the cells in the grid. The shortest path from any two
 * points on the grid can be calculated as long as the values are valid.
 * 
 * Last date modified: 3/25/2017
 */

/**
 *
 * @author Jeremiah
 */
public class AStar {
    private GridSpace[][] grid; //Holds all the cells in the grid.
    public boolean [][] closed; //A grid that identifies all the walls found in 
                                //the grid.
    public PriorityQueue open;  //Holds all of the open,door,and stair cells in 
                                //the grid.
    int startX, startY;         //The start coordinates for the path.
    int endX, endY;             //The end coordinates for the path.
    boolean pathFound = false;  //Will remain false if path is impossible.
    
    /**
     * Initializes all of the grid and sets the cells in closed to false.
     * @param grid
     */
    public AStar(GridSpace[][] grid){
        this.grid = grid;
        this.closed = new boolean[this.grid.length][this.grid[0].length];
        
        for(int i = 0; i < closed.length; i++){
            for(int j = 0; j < closed[i].length; j++){        
                closed[i][j] = false;
            }
        }
        this.open = new PriorityQueue();
    }
    
    /**
     * The p(parent), g(cost from start cell to current cell), h(estimated cost
     * to the end cell), and f(score of the cell) are all calculated. The start
     * cell is added to the PriorityQueue "open". After that, cells are added to
     * "open" if are types 1-3(1 = open cell, 2 = stair cell, 3 = door cell).
     * This process is repeated until the end cell is reached.
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @return 
     */
    public ArrayList<GridSpace> findPath(int startX, int startY, int endX, int endY){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                grid[i][j].setP(null);
                grid[i][j].setG(-1);
                grid[i][j].setF(-1);
                grid[i][j].setH(grid[i][j].h(endX, endY));
            }
        }
        
        grid[startX][startY].setG(0);
        grid[startX][startY].setF(grid[startX][startY].getH());
        
        open.add(grid[startX][startY]);
        
        //Search for the shortest path to the end cell begins.
        while(!open.isEmpty()){
            GridSpace current;
            
            current = (GridSpace) open.remove();
            
            if(current.getX() == endX && current.getY() == endY){
                //If the end cell is found, it returns the path.
                return retrievePath(current);
            }
            
            closed[current.getX()][current.getY()] = true;
            ArrayList<GridSpace> neighbors = getNeighbors(current);
            
            for(int i = 0; i < neighbors.size(); i++){
                GridSpace temp = neighbors.get(i);
                if(closed[temp.getX()][temp.getY()] == true){
                    continue;
                }
                
                int newG = current.getG() + 1;
                
                if(!open.contains(temp) && (temp.getType() == 1)||
                        (temp.getType() == 2)||(temp.getType() == 3)){
                    
                    open.add(temp);
                }else if(newG > temp.getG()){
                    continue;
                }
                
                temp.setP(current);
                temp.setG(newG);
                temp.setF(newG+temp.getH());
            }
            
            
        }
        
        return null;
    }
    
    /**
     * Finds all of the adjacent cells to the current cell, checks to see if
     * the coordinates are on the grid, and makes sure that they are not walls.
     * @param current
     * @return 
     */
    public ArrayList<GridSpace> getNeighbors(GridSpace current){
        ArrayList<GridSpace> neighbors = new ArrayList<GridSpace>(4);
        
        
        
        if(current.getX()-1 < 0 == false){
            neighbors.add(grid[current.getX()-1][current.getY()]);
        }
        
        if(current.getX()+1 >= grid.length == false){
            neighbors.add(grid[current.getX()+1][current.getY()]);
        }
        if(current.getY()+1 >= grid[current.getY()].length == false){
            neighbors.add(grid[current.getX()][current.getY()+1]);
        }
        
        if(current.getY()-1 < 0 == false){
            neighbors.add(grid[current.getX()][current.getY()-1]);
        }
        
        return neighbors;
    }
    
    /**
     * The path is constructed adding the end cell to the back of a list and
     * adding its parent cell to the index in front of it. This process is
     * repeated until the start cell is reached.
     * @param current
     * @return 
     */
    public ArrayList<GridSpace> retrievePath(GridSpace current){
        ArrayList<GridSpace> path = new ArrayList<GridSpace>();
        GridSpace temp = current;
        path.add(current);
        
        while(temp.getP() != null){
            path.add(0,temp.getP());
            
            temp = temp.getP();
        }
        
        return path;
    }
}
