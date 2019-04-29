package Interface.Panels;

import Controls.JInputJoystick;
import Interface.Line;
import net.java.games.input.Controller;

import javax.swing.*;
import java.awt.*;

public class ViewPanel extends JPanel {

    private RotatePanel r1;
    private RotatePanel r2;
    private RotatePanel r3;
    private int width, height;



    public ViewPanel(int h,int w){
        height = h;
        width = w;
        r1 = new RotatePanel(70,"pitch",width/9,height/3);
        r2 = new RotatePanel(70,"pitch", width/9,height/3);
        r3 = new RotatePanel(70,"pitch",width/9,height/3);


        setSize(w,h);

        //yawPanel = new RotatePanel(80, "yaw",getSize());

        this.setLayout(new GridLayout(1, 3));
        this.add(r1);
        this.add(r2);
        this.add(r3);


      //  this.add(yawPanel);

        r1.setBackground(Color.DARK_GRAY);
      //  yawPanel.setBackground(Color.lightGray);


    }

    public void Update(int width,int height){
        this.height = height;
        this.width = width;

        setSize(width,height);


    }

    public void Resize(int width, int height){
        r1.Resize(width/9,height/3);
        r2.Resize(width/9,height/3);
        r3.Resize(width/9,height/3);


    }


    public RotatePanel getr1(){ return r1; }
    public RotatePanel getr2(){ return r2;}
    public RotatePanel getr3(){return r3;}

}
