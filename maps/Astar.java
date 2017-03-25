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
public class Astar {
    PriorityQueue openList;
    //closedlist;
    
   private GridSpace graphSpaces[][];
   for each graphSpace
           setP(null);
   
   for each graphSpace
           setG(infinity)
   
   start.setG(0);
           
   for each graphSpace 
           setF(intfinity)
                   
   start.setF(start.h(target cordinates))
                   
    for each graphspace
           setH( h(target cordinates))
           
   while(!openSet.isEmpty()){
               current=openlist.excract();
               if(current==target) {
                   return path
               }
               
               cloasedSet.add(current)
               for each neighbor of current
                       if(neighbor is in closedset) // already vistied
                            //ignore it
                    newG = current.g + 1;
                       if(neighbor not in open set)
                        then ad to open
                       else if( newG >= neighbor.getG())
                           // ignore it
                   neighbor.setP(current);
                   neighbor.setG(newG);
                   neighbor.setF(newG+ neighbor.getH())
                          
                       
                       
   }   
}
