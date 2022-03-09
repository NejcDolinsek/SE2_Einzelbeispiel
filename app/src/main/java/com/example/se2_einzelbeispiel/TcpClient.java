package com.example.se2_einzelbeispiel;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TcpClient {

    String ServerAnswer;
    String Matrikelnummer;

    public TcpClient(String matrikelnummer) {
        Matrikelnummer = matrikelnummer;
    }

    public String run() throws IOException {
        Socket clientSocked = new Socket("se2-isys.aau.at",53212);
        DataOutputStream outToServer = new DataOutputStream(clientSocked.getOutputStream());
        BufferedReader inFormServer = new BufferedReader(new InputStreamReader(clientSocked.getInputStream()));

        outToServer.writeBytes(Matrikelnummer +"\n");

        ServerAnswer = inFormServer.readLine();

        return ServerAnswer;
    }

    public String getServerAnswer(){return ServerAnswer;}
}
