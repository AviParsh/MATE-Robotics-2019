package Interface.Panels.Graph;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;

public class GraphPanel extends JPanel {

    private Data data;
    //private ArrayList<Point> data;
    private int width, height;

    public GraphPanel(Data d){
        height = GraphConstants.maxY - GraphConstants.minY;
        width = 200;

        this.setSize(width, height);

        setVisible(true);
//        for (int i = 0; i < width ;i++){
//            data.add(new Point(i, height / 2));
//        }
    }

    public void updateData(Data d){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

//        for(int i = 0; i < data.size(); i++){
//            data.get(i).draw(g, this.getHeight());
//        }
    }

}
