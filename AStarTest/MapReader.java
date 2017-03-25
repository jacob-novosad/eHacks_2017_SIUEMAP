
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
public class MapReader {
    BufferedImage image;
    int offSetX;
    int offSetY;
    
    public MapReader() {
        
    }
    
    
    public GridSpace[][] thingy(String filename,int offX,int offY){
        try {
            image = ImageIO.read(new File(filename));
            
            System.out.println(image.getRGB(0, 0));
        //   System.out.println(image.getHeight());
        //    System.out.println(image.getWidth());
            
            int xsize=(image.getWidth()-offX)/7;
            int ysize=(image.getHeight()-offY)/7;
            
            
            GridSpace[][] grid = new GridSpace[xsize][ysize];
            for(int x=offX;x<image.getWidth() && x+6<image.getWidth();x+=7){
                for(int y=offY;y<image.getHeight()&& y+6<image.getHeight();y+=7){
                    
                    boolean green=false;
                    boolean yellow=false;
                    boolean pink=false;
                                      
                    for(int i=x; i<=x+6;i++){
                        for(int j=y; j<=y+6;j++){
                                                        
                            
                            int pixelColor=image.getRGB(i, j);
                            if(pixelColor==-16711936) { //green
                                green=true;
                            }
                            else if(pixelColor==-256) { //yellow
                                yellow=true;
                            }
                            else if(pixelColor==-65281) {
                                pink=true;
                            }    
                        }
                    }
                    
                    if(yellow){
                        grid[x/7][y/7] = new GridSpace(x/7,y/7,0,2);
                    }
                    else if(green) {
                        grid[x/7][y/7] = new GridSpace(x/7,y/7,0,1);
                    }
                    else if(pink) {
                        grid[x/7][y/7] = new GridSpace(x/7,y/7,0,3);
                    }
                    else grid[x/7][y/7] = new GridSpace(x/7,y/7,0,0);
                }
            }
            
            for(int y=0;y<grid[0].length;y++) {
                for(int x=0;x<grid.length;x++) {
                    System.out.print(grid[x][y].getType());
                }
                System.out.println();
            }
           
            return grid;
        } catch (IOException e) {
            System.out.println("PICTURE NOT FOUND");
            return null;
        }
    }
}
