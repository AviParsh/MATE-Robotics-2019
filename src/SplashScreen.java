
import javax.swing.*;
import java.awt.*;

public class SplashScreen {
    JFrame frame;
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/Graphics/Images/ROV.png").getImage().getScaledInstance(750,422,Image.SCALE_DEFAULT));
    JLabel image=new JLabel(imageIcon);  //Image has a scale of 1.77778:1
    SplashScreen()
    {
        createGUI();
        addImage();
    }
    public void createGUI(){
        frame=new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(1000,600);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(44,62,80));
        frame.setVisible(true);

    }
    public void addImage(){
        image.setSize(800,400);//Setting size of the image
        image.setLocation(60,20);
        frame.add(image);//Adding image to the frame
    }
}