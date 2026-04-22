package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler {

    public static void main(String[] args){
        try {
            Socket client = new Socket("localhost",2003);
            BufferedReader readFromServer = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Can I perform an operation for you : (add/sub/div/multi) nums1 num2 <- In this format. : ");
            String command = readFromServer.readLine();
            PrintWriter writer =  new PrintWriter(client.getOutputStream(), true);
            writer.println(command);
            BufferedReader in  = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println(in.readLine());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
