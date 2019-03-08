package Interface.Panels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LabelPanel extends JPanel {
    private ArrayList<JLabel> labels = new ArrayList<JLabel>();
    private ArrayList<JLabel> values = new ArrayList<JLabel>();

    public LabelPanel(){
        labels.add(new JLabel("Depth:"));
        labels.add(new JLabel("Knots:"));
        labels.add(new JLabel("Connection Status:"));
        labels.add(new JLabel("ComPort:"));

        values.add(new JLabel("yuh time"));
        values.add(new JLabel("yuh time"));
        values.add(new JLabel("yuh time"));
        values.add(new JLabel("yuh time"));

        this.setLayout(new GridLayout(4, 2));

        for(int i = 0; i < labels.size(); i++){
            this.add(labels.get(i));
            this.add(values.get(i));
        }


    }
}
