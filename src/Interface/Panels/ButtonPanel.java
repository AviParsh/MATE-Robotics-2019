package Interface.Panels;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private JButton killButton;
    private JButton shutDownButton;

    public ButtonPanel(){
        killButton = new JButton("Kill Time");
        shutDownButton = new JButton("Shut Down");

        this.setLayout(new GridLayout(1, 2));

        this.add(killButton);
        this.add(shutDownButton);
    }
}
