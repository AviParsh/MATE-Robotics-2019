
import javax.swing.*;
import java.awt.*;

public class SplashScreen {
    JFrame frame;
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/Graphics/Images/ROV.png").getImage().getScaledInstance(750,422,Image.SCALE_DEFAULT));
    JLabel image=new JLabel(imageIcon);  //Image has a scale of 1.77778:1
    JLabel text=new JLabel("WELCOME");//Creating a JLabel object and adding text to it
    JProgressBar progressBar=new JProgressBar();//Creating an object of JProgressBar
    JLabel message=new JLabel();
    SplashScreen()
    {
        createGUI();
        addImage();
        addText();
        addProgressBar();
        runningPBar();
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
    public void addText()
    {
        text.setFont(new Font("SansSerif",Font.BOLD,40));//Setting font size of text
        text.setBounds(385,360,600,50);//Setting size and location
        text.setForeground(Color.WHITE);//Setting foreground color
        frame.add(text);//adding text to the frame
    }
    public void addProgressBar(){
        progressBar.setBounds(285,460,410,30);//Setting Location and size
        progressBar.setBorderPainted(true);//Setting border painted property
        progressBar.setStringPainted(true);//Setting String painted property
        progressBar.setBackground(Color.WHITE);//setting background color
        progressBar.setForeground(Color.BLACK);//setting foreground color
        progressBar.setValue(0);//setting progress bar current value
        frame.add(progressBar);//adding progress bar to frame
    }
    public void addMessage()
    {
        message.setBounds(250,320,200,40);//Setting the size and location of the label
        message.setForeground(Color.WHITE);//Setting foreground Color
        message.setFont(new Font("SansSerif",Font.BOLD,35));//Setting font properties
        frame.add(message);//adding label to the frame
    }
    public void runningPBar(){
        int i=0;//Creating an integer variable and intializing it to 0

        while( i<=100)
        {
            try{
                Thread.sleep(50);//Pausing execution for 50 milliseconds
                progressBar.setValue(i);//Setting value of Progress Bar
                message.setText("LOADING "+Integer.toString(i)+"%");//Setting text of the message JLabel
                i++;
                if(i==100)
                    frame.dispose();
            }catch(Exception e){
                e.printStackTrace();
            }



        }
    }
}