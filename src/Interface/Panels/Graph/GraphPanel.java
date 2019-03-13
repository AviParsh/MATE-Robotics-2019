package Interface.Panels.Graph;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphPanel extends JPanel {
    private ArrayList<Point> datapoints = new ArrayList<Point>(1);

    public GraphPanel(){
        setSize(100,100);
        setVisible(true);
        for (int i = 0;i<100;i++){

            datapoints.add(new Point(i,50 - i));

        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int i = 0;
        while(i<datapoints.size()){
            datapoints.get(i).draw(g,getHeight());
            i++;
        }

        g.setColor(Color.black);
        g.drawOval(10, 10, 50, 50);

    }

    public void updatedata(int reading){
        datapoints.add(new Point(datapoints.size(),reading));

    }





}
