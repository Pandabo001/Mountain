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
  
  public int getRows(){
    return grid.length;
  }
  
  public int getColumns(){
    return grid[0].length;
  }
  
  /**
   * @return the min value in the entire grid
   */
  public int findMinValue(){
    
    int min = grid[0][0];
    for (int i = 0; i<grid.length; i++) {
      for (int j = 0; j<grid[0].length; j++) {
        if (grid[i][j]<min){
          min = grid[i][j];
        }
      }
    }
    return min;
  }
  
  
  /**
   * @return the max value in the entire grid
   */
  public int findMaxValue(){
    
    int max = grid[0][0];
    for (int i = 0; i<grid.length; i++) {
      
      for (int j = 0; j<grid[0].length; j++) {
        
        if (grid[i][j]>max){
          max = grid[i][j];
        }
      }
    }
    return max;
  }
  
  
  public void drawMap(){
    
  }
  
  
  
  
}