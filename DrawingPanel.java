import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Window;
import java.net.URL;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import javax.imageio.ImageIO;

public class DrawingPanel {
  
  // class constants
  public static final String ANIMATED_PROPERTY   = "drawingpanel.animated";
  public static final String DIFF_PROPERTY       = "drawingpanel.diff";
  public static final String HEADLESS_PROPERTY   = "drawingpanel.headless";
  public static final String MULTIPLE_PROPERTY   = "drawingpanel.multiple";
  public static final String SAVE_PROPERTY       = "drawingpanel.save";
  public static final String ANIMATION_FILE_NAME = "_drawingpanel_animation_save.txt";
  private static final String TITLE              = "DrawingPanel";
  private static final String COURSE_WEB_SITE = "http://www.cs.washington.edu/education/courses/cse142/CurrentQtr/drawingpanel.txt";
  private static final int DELAY                 = 100;     // delay between repaints in millis
  private static final int MAX_FRAMES            = 100;     // max animation frames
  private static final int MAX_SIZE              = 10000;   // max width/height
  private static final boolean DEBUG             = true;
  private static int instances = 0;
  private static Thread shutdownThread = null;
  
  
  // fields
  private int width, height;             // dimensions of window frame
  private Graphics2D g2;                 // graphics context for painting
  private long createTime;               // time at which DrawingPanel was constructed
  
  // construct a drawing panel of given width and height enclosed in a window
  public DrawingPanel(int width, int height) {
    if (width < 0 || width > MAX_SIZE || height < 0 || height > MAX_SIZE) {
      throw new IllegalArgumentException("Illegal width/height: " + width + " x " + height);
    }
    
    this.width = width;
    this.height = height;
        
    if (DEBUG) System.out.println("w = " + width + " ,h = " + height);
  }
  
  
  
  // obtain the Graphics object to draw on the panel
  public Graphics2D getGraphics() {
    return g2;
  }
}
