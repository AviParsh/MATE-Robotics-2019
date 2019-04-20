package Interface.Panels;

import javax.swing.*;
import javax.swing.JSlider;
import java.awt.*;
import java.util.Hashtable;
import net.java.games.input.Controller;
import Controls.JInputJoystick;

public class SliderPanel extends JPanel{
    private JSlider leftSlider;
    private JSlider rightSlider;
    public SliderPanel(){

        leftSlider = new JSlider(JSlider.VERTICAL, -50, 50, 0);
        leftSlider.setPreferredSize(new Dimension(500,234));
        leftSlider.setBounds(0,0,100,200);

        rightSlider = new JSlider(JSlider.VERTICAL, -50, 50, 0);
        rightSlider.setPreferredSize(new Dimension(50,234));
        rightSlider.setBounds(0,0,100,200);

        leftSlider.setPaintLabels(true);
        rightSlider.setPaintLabels(true);

        prepareSlider(); //sets slider size, labels, bounds

        this.add(leftSlider, BorderLayout.EAST);
        this.add(rightSlider, BorderLayout.EAST);
    }

    public JSlider getRightSlider(){
        return rightSlider;
    }

    public JSlider getLeftSlider(){
        return leftSlider;
    }

    public void prepareSlider(){

        // Add positions label in the slider
        Hashtable position = new Hashtable();
        JLabel l1 = new JLabel("-50");
        JLabel l2 = new JLabel("0");
        JLabel l3 = new JLabel("50");
        l1.setForeground(Color.white);
        l2.setForeground(Color.white);
        l3.setForeground(Color.white);

        position.put(-50, l1);
        position.put(0, l2);
        position.put(50, l3);

        // Set the label to be drawn
        leftSlider.setLabelTable(position);
        rightSlider.setLabelTable(position);
        leftSlider.setBackground(new Color(44,62,80));
        rightSlider.setBackground(new Color(44,62,80));
    }

    public void setLeftSliderpos(int val){
        leftSlider.setValue(val);
    }
    public void setRightSliderpos(int val){
        rightSlider.setValue(val);
    }
    public void update(int heightofpanel){
        leftSlider.setPreferredSize(new Dimension(100,heightofpanel-10));
        rightSlider.setPreferredSize(new Dimension(100,heightofpanel-10));
   }
}

