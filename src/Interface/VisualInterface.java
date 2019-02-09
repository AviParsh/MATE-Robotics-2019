package Interface;

import net.java.games.input.Controller;
import Controller.JInputJoystick;
import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;


public class VisualInterface {
    private JInputJoystick joystick = new JInputJoystick(Controller.Type.STICK, Controller.Type.GAMEPAD);

    public VisualInterface(){

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Visual Interface");
        JPanel panel = new JPanel();

        JSlider leftSlider = new JSlider(JSlider.VERTICAL, -50, 50, 0);
        Dimension dl = leftSlider.getPreferredSize();
        leftSlider.setPreferredSize(new Dimension(dl.width+50,dl.height+550));
        leftSlider.setBounds(0,0,100,200);

        JSlider rightSlider = new JSlider(JSlider.VERTICAL, -50, 50, 0);
        Dimension dr = rightSlider.getPreferredSize();
        rightSlider.setPreferredSize(new Dimension(dr.width+50,dr.height+550));
        rightSlider.setBounds(0,0,100,200);

        leftSlider.setPaintLabels(true);
        rightSlider.setPaintLabels(true);

        // Add positions label in the slider
        Hashtable position = new Hashtable();
        position.put(-50, new JLabel("-50"));
        position.put(0, new JLabel("0"));
        position.put(50, new JLabel("50"));

        // Set the label to be drawn
        leftSlider.setLabelTable(position);
        rightSlider.setLabelTable(position);
        panel.add(leftSlider,BorderLayout.WEST);
        panel.add(rightSlider,BorderLayout.EAST);

        frame.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.black,3));
        frame.add(panel,BorderLayout.EAST);
        frame.setSize(1500,800);
        frame.setVisible(true);
        // Check if the controller was found.
        if (!joystick.isControllerConnected()) {
            System.out.println("No controller found!");
        }

        int yvall, yvalr;
        float hstick;
        int t = 1;
        while(t==1) {
            // Get current state of joystick! And check, if joystick is disconnected.
            if (!joystick.pollController()) {
                System.out.println("Controller disconnected!");
                break;
            }

            yvall = getyvall();
            yvalr = getyvalr();
            hstick = gethpos();
            leftSlider.setValue(yvall);
            rightSlider.setValue(yvalr);
            System.out.println(hstick);

        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //following 4 functions are to get joystick pos
    public int getyvalr(){
        if (joystick.getControllerType() == Controller.Type.STICK) {
            return (joystick.getZRotationPercentage()-50)*-1;
        }
        else {
            return (joystick.getYRotationPercentage()-50)*-1;
        }
    }
    public int getxvalr(){
        if (joystick.getControllerType() == Controller.Type.STICK) {
            return joystick.getZAxisPercentage();
        }
        else {
            return joystick.getXRotationPercentage();
        }
    }
    public int getyvall(){
        return (joystick.getYAxisPercentage()-50)*-1;
    }
    public int getxvall(){
        return joystick.getXAxisPercentage();
    }

    //following function is to get dpad pos
    public float gethpos(){
        return joystick.getHatSwitchPosition();
    }
}
