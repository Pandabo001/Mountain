import java.util.*;
import java.io.*;
import java.awt.*;

public class MapDataDrawer{
  
  public int[][] grid;
  
  public MapDataDrawer(String filename, int rows, int cols){
    
    grid = new int[rows][cols];
    
    Scanner sc;
    try {
      
      sc = new Scanner(new File(filename));
      for (int i = 0; i < rows; i++){
        
        for (int j = 0; j < cols; j++){
          
          if (sc.hasNextInt()){
            
            grid[i][j] = sc.nextInt(); 
          }
        }
        
      }
      
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
  
  
  
  public void drawMap(){
    
  }
  
  
  
  
}