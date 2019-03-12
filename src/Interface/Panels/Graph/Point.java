package Interface.Panels.Graph;

import java.awt.*;

public class Point {
    int x;
    int y;

    public Point(int x_coord, int y_coord){
        x = x_coord;
        y = y_coord;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void draw (Graphics g,int height){
        g.drawOval(x, height-y, 5, 5);
    }

}
