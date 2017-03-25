
import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author John
 */
public class GridSpace implements Comparable{

/*    
    public enum Type{
        OPEN,WALL,ROOM,STAIRS
    }
    private Type t;
 */   
    private GridSpace p;
    private int f;
    private int g;
    private int h;
    private int type;
    private int x;
    private int y;
    private int z;
    
    
    /**
     * Creates new grid space with cost 0 and type 0 (open)
     */
    public GridSpace(){
        x=0;
        y=0;
        z=0;
        g=0;
        h=0;
        f=0;
        type=0;
        //t = Type.OPEN;
    }

        public GridSpace(int x, int y,int z){
        this.x=x;
        this.y=y;
        this.z=z;
        g =0;
        f=0;
        type=0;
        //t = Type.OPEN;
    }
    
    /**
     * Creates new grid space with cost 0 and type t (0 for open, 1 for closed)
     */
    public GridSpace(int x, int y,int z, int t){
        this.x=x;
        this.y=y;
        this.z=z;
        g =0;
        f =0;
        type=t;
        //t = Type.OPEN;
    }
    
    public GridSpace(int x, int y,int z, int t ,int c){
        this.x=x;
        this.y=y;
        this.z=z;
        f=0;
        type=t;
        //t = Type.OPEN;
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

    public GridSpace getP() {
        return p;
    }

    public void setP(GridSpace p) {
        this.p = p;
    }
    
    public int h(int x, int y, int z){
        return Math.abs(this.x-x)+Math.abs(this.y-y)+Math.abs(this.y-y);
    }
    
    
    public int compareTo(Object o) {
        GridSpace s =(GridSpace) o; 
        return s.f - this.f;
    }
   
}
