package Interface;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class SliderPanel extends JPanel {

    private JSlider leftSlider;
    private JSlider rightSlider;

    public SliderPanel(){

        leftSlider = new JSlider(JSlider.VERTICAL, -50, 50, 0);
        rightSlider = new JSlider(JSlider.VERTICAL, -50, 50, 0);

        prepareSlider(leftSlider); //sets slider size, labels, bounds
        prepareSlider(rightSlider);

        addSliderLabels(leftSlider);
        addSliderLabels(rightSlider);

        leftSlider.setBackground(new Color(44,62,80));
        rightSlider.setBackground(new Color(44,62,80));

        this.setBackground(new Color(84, 110, 122));

        this.add(leftSlider, BorderLayout.WEST);
        this.add(rightSlider, BorderLayout.EAST);
    }

    private void prepareSlider(JSlider slider){
        Dimension dimension = slider.getPreferredSize();
        slider.setPreferredSize(new Dimension(dimension.width+50,dimension.height+550));
        slider.setBounds(0,0,100,200);
        slider.setPaintLabels(true);
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

}
