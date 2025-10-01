package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Hello world!");

        Scanner myObj = new Scanner(System.in);
        System.out.println("Inserisci l'IP del server");
        String serverIP= myObj.nextLine();
        System.out.println("Inserisci la Porta del server");
        Integer serverPort = Integer.parseInt(myObj.nextLine());
        Socket mioSocket = new Socket(serverIP,serverPort);

        BufferedReader in = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));
        PrintWriter out = new PrintWriter(mioSocket.getOutputStream(),true);

        String stringaDaInviare;
        do{
        System.out.println("Inserisci la stringa da tastiera : ");
     stringaDaInviare = myObj.nextLine();
        out.println(stringaDaInviare);
        
        String stringaRicevuta = in.readLine();
        System.out.println("Stringa ricevuta : "+stringaRicevuta);
    }while(!stringaDaInviare.equals("!"));
        

        

    }
}