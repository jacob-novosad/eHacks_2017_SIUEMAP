package classmap;

//package astartest;


import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeremiah
 */
public class AStar {
    private GridSpace[][] grid;
    public boolean [][] closed;
    public PriorityQueue open; 
    boolean pathFound = false;
    
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
        while(!open.isEmpty()){
            GridSpace current;
            
            current = (GridSpace) open.remove();
            
            if(current.getX() == endX && current.getY() == endY){
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
                
                if(!open.contains(temp) && (temp.getType() == 1 || temp.getType() == 2 ||  temp.getType() == 3)){
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
