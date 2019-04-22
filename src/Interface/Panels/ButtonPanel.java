package Interface.Panels;

import javax.swing.*;
import java.awt.*;
import Graphics.CircleButton;

public class ButtonPanel extends JPanel {

    private JButton killButton;
    private JButton shutDownButton;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;

    public ButtonPanel(){
        setBorder(BorderFactory.createLineBorder(Color.white,3));
        setBackground(new Color(84, 110, 122));
        shutDownButton = new CircleButton("Terminate");
        killButton = new CircleButton("Kill Thrusters");
        button1 = new CircleButton("button1");
        button2 = new CircleButton("button2");
        button3 = new CircleButton("button3");
        button4 = new CircleButton("button4");
        button5 = new CircleButton("button5");
        button6 = new CircleButton("button6");
        this.setLayout(new GridLayout(2, 1));

        this.add(killButton);
        this.add(shutDownButton);
//        this.add(button1);
//        this.add(button2);
//        this.add(button3);
//        this.add(button4);
//        this.add(button5);
//        this.add(button6);
    }


}
