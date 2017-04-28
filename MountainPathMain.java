import java.awt.*;

public class MountainPathMain{
    
  public static void main(String[] args){
    
    //construct DrawingPanel, and get its Graphics context
    DrawingPanel board = new DrawingPanel(844, 480);
    Graphics g = board.getGraphics();
    
    //Step 1 - construct mountain map data
    MapDataDrawer map = new MapDataDrawer("Colorado_844x480.dat", 480, 844);
  }


}
