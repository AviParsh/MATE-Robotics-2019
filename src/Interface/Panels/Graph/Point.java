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

    public void draw (Graphics g, int panelHeight){
        int realY = 0;
        if(y > 0){
            realY = panelHeight - y;
        }

        g.drawOval(x, realY, 5, 5);
    }

}
