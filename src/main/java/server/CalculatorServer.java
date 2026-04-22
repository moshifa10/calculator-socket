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
            BufferedReader readClientInput = new BufferedReader(new InputStreamReader(clientAccept.getInputStream()));

//            writer.println("Can I perform an operation for you : (add/sub/div/multi) nums1 num2 <- In this format.");
            String answer = readClientInput.readLine();

            PrintWriter writer = new PrintWriter(clientAccept.getOutputStream(), true);

            String[] command = answer.split(" ");
//            System.out.println(command[0]);
//            System.out.println(command[1]+ " " + command[1]);
//            System.out.println(command[0].equals("add"));

            Double calcAnswer;
            switch (command[0]) {
                case "add":
                    Addition addition = new Addition();
                    System.out.println("I am in here");
                    calcAnswer = addition.execute(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    writer.println("Server gives answer: " + calcAnswer);
                    System.out.println(calcAnswer);
                    break;
                case "sub":
                    Subraction subraction = new Subraction();
                    calcAnswer = subraction.execute(Integer.parseInt(command[1]), Integer.parseInt(command[2]));

                    writer.println("Server gives answer: " + calcAnswer);
                    break;
                case "div":
                    Division division = new Division();
                    calcAnswer = division.execute(Integer.parseInt(command[1]), Integer.parseInt(command[2]));

                    writer.println("Server gives answer: " + calcAnswer);
                    break;
                case "multi":
                    Multiplication multiplication = new Multiplication();
                    calcAnswer = multiplication.execute(Integer.parseInt(command[1]), Integer.parseInt(command[2]));

                    writer.println("Server gives answer: " + calcAnswer);
                    break;
                default:
                    throw new IllegalArgumentException("Illegal command");
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
