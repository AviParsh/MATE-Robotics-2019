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
        rightSlider = new JSlider(JSlider.VERTICAL, -50, 50, 0);

        prepareSlider(leftSlider); //sets slider size, labels, bounds
        prepareSlider(rightSlider);

        addSliderLabels(leftSlider);
        addSliderLabels(rightSlider);

        this.add(leftSlider, BorderLayout.WEST);
        this.add(rightSlider, BorderLayout.EAST);
    }

    public JSlider getRightSlider(){
        return rightSlider;
    }

    public JSlider getLeftSlider(){
        return leftSlider;
    }

    private void prepareSlider(JSlider slider){
        Dimension dimension = slider.getPreferredSize();
        slider.setSize(new Dimension(dimension.width+50,dimension.height+550));
        slider.setBounds(0,0,100,200);
        slider.setPaintLabels(true);
        slider.setBackground(new Color(44,62,80));
        slider.setBorder(BorderFactory.createLineBorder(Color.black,3));

    }

    private void addSliderLabels(JSlider slider){
        Hashtable positionLabels = new Hashtable();
        JLabel maxLabel = new JLabel("-50");
        JLabel middleLabel = new JLabel("0");
        JLabel minLabel = new JLabel("50");
        maxLabel.setForeground(Color.white);
        middleLabel.setForeground(Color.white);
        minLabel.setForeground(Color.white);

        positionLabels.put(Integer.parseInt(maxLabel.getText()), maxLabel);
        positionLabels.put(Integer.parseInt(maxLabel.getText()), middleLabel);
        positionLabels.put(Integer.parseInt(maxLabel.getText()), minLabel);

        slider.setLabelTable(positionLabels);
    }

    public void setLeftSliderpos(int val){
        leftSlider.setValue(val);
    }
    public void setRightSliderpos(int val){
        rightSlider.setValue(val);
    }
}

