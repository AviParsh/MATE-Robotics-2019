package Interface.Panels.Graph;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;

public class GraphPanel extends JPanel {

    private Data data;
    private ArrayList<Point> datapoints =  new ArrayList<Point>();
    private int width, height;

    public GraphPanel(){
        height = GraphConstants.maxY - GraphConstants.minY;
        width = 200;

        this.setSize(width, height);

        setVisible(true);
        for (int i = 0; i < width ;i++){
            datapoints.add(new Point(i, height / 2));
        }
    }

    public void updateData(Data d){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for(int i = 0; i < datapoints.size(); i++){
            datapoints.get(i).draw(g, this.getHeight());
        }
    }

}
