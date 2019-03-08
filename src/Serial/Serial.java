//package Serial;
//
////import com.fazecast.jSerialComm.SerialPort;
//
//import java.util.Scanner;
//
//public class Serial {
//    private int chosenPort = 0;
//    private SerialPort[] ports = SerialPort.getCommPorts();
//    private Scanner data;
//
//    public Serial() {
//        System.out.println("Select a port: ");
//        int i = 1;
//        for (SerialPort port : ports) {
//            System.out.println(i++ + ". " + port.getSystemPortName());
//        }
//        Scanner s = new Scanner(System.in);
//        chosenPort = s.nextInt();
//
//        SerialPort port = ports[chosenPort - 1];
//        if (port.openPort()) {
//            System.out.println("Successfully opened the port!");
//
//        } else {
//            System.out.println("Unable to open the port");
//            return;
//        }
//
//        port.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
//
//        data = new Scanner(port.getInputStream());
//
//    }
//    public Serial(int c) {
//        chosenPort = c;
//
//        SerialPort port = ports[chosenPort - 1];
//        if (port.openPort()) {
//            System.out.println("Successfully opened the port!");
//
//        } else {
//            System.out.println("Unable to open the port");
//            return;
//        }
//
//        port.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
//        data = new Scanner(port.getInputStream());
//
//    }
//
//    public String getPitcb(){
//        return (data.nextLine());
//    }
//}
