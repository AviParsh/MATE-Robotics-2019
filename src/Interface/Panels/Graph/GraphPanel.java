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

            datapoints.add(new Point(i,50));

        }

    }



    public void PaintComponent(Graphics g){
        int i = 0;
        while(i<datapoints.size()){
            datapoints.get(i).draw(g,getHeight());

        }

    }

    public void updatedata(int reading){
        datapoints.add(new Point(datapoints.size(),reading));

    }





}
