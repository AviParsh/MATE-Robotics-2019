package Communication;

import java.net.*;
import java.io.*;


public class Client{

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port){
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        }catch(IOException e){
            System.out.println(e.getStackTrace());
        }
    }

    public void stopConnection(){
        try {
            in.close();
            out.close();
            clientSocket.close();
        }catch(IOException e){
            System.out.println(e.getStackTrace());
        }
    }

    public void sendMessage(String message){
        out.println(message);
    }

    public String getMessage(){
        String response = "No message received";
        try {
            response = in.readLine();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return response;
    }

/*
    public static void main(String[] args) throws IOException{
        Client javaClient = new Client();
        javaClient.startConnection("localhost", 7937);

        //used for sending messages:
        javaClient.sendMessage("sending from client");

        //used for receving messages:
        while(true){
            String message = javaClient.getMessage();
            if(message != null){
                System.out.println(message);
            } else {
                System.out.println("No message being received.");
            }
        }
    }

    */


}