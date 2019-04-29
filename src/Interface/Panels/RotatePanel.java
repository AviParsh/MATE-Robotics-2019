package Interface.Panels;

import Controls.JInputJoystick;
import Controls.gamepad;
import Interface.Line;
import net.java.games.input.Controller;

import javax.swing.*;
import java.awt.*;

public class RotatePanel extends JPanel {
    private Line line;
    private Line rline;

    private String type;
    private gamepad Logitech;
    private JLabel ameasure = new JLabel();

    private int width, height;
    private int rad;



    public RotatePanel(int r,String type, int w, int h){
        width = w;
        height = h;
        rad = r;
        ameasure.setForeground(Color.white);
        ameasure.setSize(100,100);
        ameasure.setLocation(width/2,height/2);

        ameasure.setText("Angle Measure");
        ameasure.setVisible(true);
        add(ameasure);



        Logitech = new gamepad();
        setBackground(Color.DARK_GRAY);

        if(type.equals("pitch")) {
            line = new Line((width /2) - rad, height / 2, (width/2) + rad, height / 2);

            this.type = type;

        }
        rline = new Line((width / 2) - rad, height / 2, (width / 2) + rad, height / 2);

        repaint();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        line.draw(g2);
        rline.draw(g2);
        rline.setcolor(g2,Color.RED);



    }

    public void Update(){
        repaint();
        String a = Double.toString(line.getangle()*(180/Math.PI));

        ameasure.setText(a);


    }

    public Line getLine(){return line;}

    public Line getRLine(){return rline;}

    public void Resize(int w, int h){
        width = w;
        height = h;
        line = new Line((width / 2) - rad, height / 2, (width / 2) + rad, height / 2);
        rline = new Line((width / 2) - rad, height / 2, (width / 2) + rad, height / 2);

    }



}

