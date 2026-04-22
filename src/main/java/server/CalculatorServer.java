package server;


import calc.Addition;
import calc.Division;
import calc.Multiplication;
import calc.Subraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {

    public static void  main(String[] args){

        try {
            System.out.println("I am waiting for a client .......");
            ServerSocket serverSocket = new ServerSocket(2003);

            // accept then after I have bind the socket
            Socket clientAccept = serverSocket.accept();
            System.out.println("Client have connected");

            // accept input from the client
            PrintWriter writer = new PrintWriter(clientAccept.getOutputStream());
            BufferedReader readClientInput = new BufferedReader(new InputStreamReader(clientAccept.getInputStream()));

            writer.println("Can I perform an operation for you : (add/sub/div/multi) nums1 num2 <- In this format.");
            String answer = readClientInput.readLine();

            switch (answer){

                case "add":
                    Addition addition =
                case "sub":
                    Subraction subraction =
                case "div":
                    Division division =
                case "multi":
                    Multiplication multiplication =
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
