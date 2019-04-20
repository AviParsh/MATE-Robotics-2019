package Interface.Panels;

import Controls.JInputJoystick;
import Interface.Line;
import net.java.games.input.Controller;

import javax.swing.*;
import java.awt.*;

public class ViewPanel extends JPanel {

    private RotatePanel pitchPanel;
    private RotatePanel yawPanel;



    public ViewPanel(){

        setSize(700,200);

        pitchPanel = new RotatePanel(80,"pitch",getSize());
        yawPanel = new RotatePanel(80, "yaw",getSize());

        this.setLayout(new GridLayout(1, 2));
        this.add(pitchPanel);
        this.add(yawPanel);

        pitchPanel.setBackground(Color.PINK);
        yawPanel.setBackground(Color.lightGray);


    }

}
