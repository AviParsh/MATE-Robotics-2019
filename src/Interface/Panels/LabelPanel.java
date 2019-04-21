package Interface.Panels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LabelPanel extends JPanel {
    private ArrayList<JLabel> labels = new ArrayList<JLabel>();
    private ArrayList<JLabel> values = new ArrayList<JLabel>();
    private ArrayList<JLabel> status = new ArrayList<JLabel>();

    public LabelPanel(){
        setBorder(BorderFactory.createLineBorder(Color.white,3));
        setBackground(new Color(84, 110, 122));
        Font myFont = new Font("Verdana", Font.BOLD, 16);

        status.add(new JLabel("           Status:        •"));
        status.add(new JLabel("           Status:        •"));
        status.add(new JLabel("           Status:        •"));
        status.add(new JLabel("           Status:        •"));
        status.add(new JLabel("           Status:        •"));
        status.add(new JLabel("           Status:        •"));
        status.add(new JLabel("           Status:        •"));
        status.add(new JLabel("           Status:        •"));

        labels.add(new JLabel("Depth:"));
        labels.add(new JLabel("Knots:"));
        labels.add(new JLabel("Connection Status:"));
        labels.add(new JLabel("ComPort:"));
        labels.add(new JLabel("Depth:"));
        labels.add(new JLabel("Knots:"));
        labels.add(new JLabel("Connection Status:"));
        labels.add(new JLabel("ComPort:"));

        values.add(new JLabel("yuh time"));
        values.add(new JLabel("yuh time"));
        values.add(new JLabel("yuh time"));
        values.add(new JLabel("yuh time"));
        values.add(new JLabel("yuh time"));
        values.add(new JLabel("yuh time"));
        values.add(new JLabel("yuh time"));
        values.add(new JLabel("yuh time"));

        this.setLayout(new GridLayout(8, 3));

        for(int i = 0; i < labels.size(); i++){
            labels.get(i).setFont(myFont);
            values.get(i).setFont(myFont);
            status.get(i).setFont(myFont);
            status.get(i).setForeground(Color.green);
            labels.get(i).setForeground(Color.white);
            values.get(i).setForeground(Color.white);

        }

        for(int i = 0; i < labels.size(); i++){
            this.add(status.get(i));
            this.add(labels.get(i));
            this.add(values.get(i));
        }


    }
}
