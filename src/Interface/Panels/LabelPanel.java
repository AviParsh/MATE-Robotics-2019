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
        status.add(new JLabel("           Status:        •"));
        status.add(new JLabel("           Status:        •"));

        labels.add(new JLabel("Elapsed Time:"));
        labels.add(new JLabel("Depth:"));
        labels.add(new JLabel("Temperature:"));
        labels.add(new JLabel("Battery Voltage:"));
        labels.add(new JLabel("Expected Current:")); //calculate in java
        labels.add(new JLabel("Measured Current:"));
        labels.add(new JLabel("Front Servo Angle:"));
        labels.add(new JLabel("Back Servo Angle:"));
        labels.add(new JLabel("Velocity:"));
        labels.add(new JLabel("Gripper Status:"));


        values.add(new JLabel("yuh time"));
        values.add(new JLabel("yuh time"));
        values.add(new JLabel("yuh time"));
        values.add(new JLabel("yuh time"));
        values.add(new JLabel("yuh time"));
        values.add(new JLabel("yuh time"));
        values.add(new JLabel("yuh time"));
        values.add(new JLabel("yuh time"));
        values.add(new JLabel("yuh time"));
        values.add(new JLabel("yuh time"));

        this.setLayout(new GridLayout(10, 3));

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
    public void settext(String s, int i){
        values.get(i).setText(s);
    }
}
