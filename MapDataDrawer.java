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
  
  

  public int indexOfMinInCol(int col){
    
    int min = grid[0][col];
    int minRow = 0;
    for (int i = 1; i < grid.length; i++){
      
      if (grid[i][col] < min){
        
        min = grid[i][col];
        minRow = i;
      }
    }
    return minRow;
  }
  

  public void drawMap(Graphics g){
    
  }
  

  public int drawLowestElevPath(Graphics g, int row){
    int max = findMaxValue();
    int totalChange = 0;
    
    for (int j = 0; j < grid[0].length - 1; j++){
      
      g.fillRect(j, row, 1, 1);
      int fwd = grid[row][j + 1];
      int fwd_up = -1;
      int fwd_down = -1;
      
      if (row != 0){
        
        fwd_up = grid[row - 1][j + 1];
      }
      
      if (row != grid.length - 1){
        
        fwd_down = grid[row + 1][j + 1];
      }
      
      int current_fwd_diff = Math.abs(grid[row][j] - fwd);
      int current_fwdup_diff = max + 1;
      int current_fwddown_diff = max + 1;
      if (fwd_up > -1){
        
        current_fwdup_diff = Math.abs(grid[row][j] - fwd_up);
      }
      
      if (fwd_down > -1){
        
        current_fwddown_diff = Math.abs(grid[row][j] - fwd_down);
      }
      
      int least = current_fwd_diff;
      
      if (current_fwd_diff > current_fwdup_diff){
        
        if (current_fwdup_diff > current_fwddown_diff){
          
          least = current_fwddown_diff;
          row++;
        }else{
          
          least = current_fwdup_diff;
          row--;
        }
      }else{
        
        if (current_fwd_diff > current_fwddown_diff){
          
          least = current_fwddown_diff;
          row++;
          
        }else{
          least = current_fwd_diff;
        }
      }
      
      totalChange += least;
      
    }
    
    return totalChange;
  }
  

  public int indexOfLowestElevPath(Graphics g){
    int least = drawLowestElevPath(g, 0);
    int index = 0;
    
    for (int i = 1; i < grid.length; i++){
      
      int change = drawLowestElevPath(g, i);
      if (change < least){
        least = change;
        index = i;
      }
    }
    
    return index;
    
  }
  
  
  
}