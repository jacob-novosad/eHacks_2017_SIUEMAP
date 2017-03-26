package classmap;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author John
 */
public class MapWriter {
    
    public MapWriter(){
        
    }
    
    public void writePath(String file, String original, ArrayList<GridSpace> path, int offX, int offY) {

        try {
            BufferedImage a = ImageIO.read(new File(original));
            File outputfile = new File(file);
            
            for(int s=0;s<path.size();s++){
                int gridX = path.get(s).getX();
                int gridY = path.get(s).getY();
                
                int color = -16767233; // blue
                int imageX = offX + gridX * 7;
                int imageY = offY + gridY * 7;
                if(s==path.size()-1){
                    color =-65536; //red
                }
                if(s==0) {
                    color = -16711936; //green
                }
                
                
                for(int i=1;i<=5;i++) {
                    for( int j=1;j<=5;j++) {
                        a.setRGB(i+imageX, j+imageY, color);
                    }
                }
                a.setRGB(3+imageX,imageY,color);
                a.setRGB(imageX,imageY+3,color);
                a.setRGB(6+imageX,imageY+3,color);
                a.setRGB(3+imageX,imageY+6,color);
            }
            
            ImageIO.write(a, "png", outputfile);
            System.out.println("wrote to " + outputfile);
        } catch (IOException ex) {
            System.out.println("output file not found");
        }
    }
    
}
