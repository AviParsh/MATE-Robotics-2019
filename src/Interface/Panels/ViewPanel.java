package Interface.Panels;

import Controls.JInputJoystick;
import Interface.Line;
import net.java.games.input.Controller;

import javax.swing.*;
import java.awt.*;

public class ViewPanel extends JPanel {

    private RotatePanel pitchPanel;
    private RotatePanel yawPanel;
    private int width, height;



    public ViewPanel(int h,int w){
        height = h;
        width = w;

        setSize(w,h);

        //yawPanel = new RotatePanel(80, "yaw",getSize());

        this.setLayout(new GridLayout(1, 1));
        this.add(pitchPanel);
      //  this.add(yawPanel);

        pitchPanel.setBackground(Color.DARK_GRAY);
      //  yawPanel.setBackground(Color.lightGray);


    }

    public void Update(int width,int height){
        this.height = height;
        this.width = width;

        setSize(width,height);


    }


    public RotatePanel getPitchPanel(){ return pitchPanel; }
    public RotatePanel getYawPanel(){ return yawPanel;}
}
