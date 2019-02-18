package Interface;

import com.fazecast.jSerialComm.SerialPort;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        VisualInterface gui = new VisualInterface();

        SerialPort[] ports = SerialPort.getCommPorts();
        System.out.println("Select a port: ");
        int i = 1;
        for(SerialPort port: ports){
            System.out.println(i++ + ". " + port.getSystemPortName());
        }
        Scanner s = new Scanner(System.in);
        int chosenport = s.nextInt();

        SerialPort port = ports[chosenport - 1];
        if(port.openPort()){
            System.out.println("Successfully opened the port!");
        }else{
            System.out.println("Unable to open the port");
            return;
        }

        port.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER,0,0);

        Scanner data = new Scanner(port.getInputStream());
        while(data.hasNextLine()){
            System.out.println(data.nextLine());
        }
    }

}
