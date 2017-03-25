package astartest;


import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Class name: GridSpace.java
 * 
 * Description: A GridSpace represents a cell on a two dimensional or three 
 * dimensional. A GridSpace also contains values that can be used to preform an
 * A* path finding algorithm by an outside class.
 * 
 * Last date modified: 3/25/2017
 */

/**
 *
 * @author John
 */
public class GridSpace implements Comparable{
 
    private GridSpace p;    //Instance of cell in the path directly before the
                            //current cell.
    private int f;          //Score of the cell (f = g + h)
    private int g;          //Cost(distance) from start cell to current cell.
    private int h;          //Estimated cost from currenct cell to end cell.
    private int type;       //Type of cell is either wall = 0, open = 1, 
                            //doors = 2, or stairs = 3.
    private int x;          //X-axis value
    private int y;          //Y-axis value
    private int z;          //Z-axis value
    
    
    /**
     * Creates new GridSpace with cost 0 and type 0 (wall)
     */
    public GridSpace(){
        x=0;
        y=0;
        z=0;
        g=0;
        h=0;
        f=0;
        type=0;
        p = null;
    }

    /**
     * Creates new GridSpace with x, y, and z coordinates.
     * @param x
     * @param y
     * @param z 
     */
    public GridSpace(int x, int y,int z){
        this.x=x;
        this.y=y;
        this.z=z;
        g =0;
        f=0;
        type=0;
        p = null;
    }
    
    /**
     * Creates new GridSpace with x, y, and z coordinates and cell type.
     * @param x
     * @param y
     * @param z
     * @param t 
     */
    public GridSpace(int x, int y,int z, int t){
        this.x=x;
        this.y=y;
        this.z=z;
        g =0;
        f =0;
        type=t;
        p = null;
    }

    /**
     * Calculates the shortest distance between the current cell and the end.
     * @param x
     * @param y
     * @param z
     * @return 
     */
    public int h(int x, int y, int z){
        return Math.abs(this.x-x)+Math.abs(this.y-y)+Math.abs(this.y-y);
    }
    
    
    @Override
    public int compareTo(Object o) {
        GridSpace s =(GridSpace) o; 
        return s.f - this.f;
    }
    
    public int getF() {
        return f;
    }

    public int getG() {
        return g;
    }

    public int getH() {
        return h;
    }

    public int getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setF(int f) {
        this.f = f;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }
    
    public void setType(int t){
        this.type = t;
    }

    public GridSpace getP() {
        return p;
    }

    public void setP(GridSpace p) {
        this.p = p;
    }
}
