/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicazionetcpoop;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michaelfuschiotti
 */
public class Server {
    
    ServerSocket serverSocket = null; //finche non viene stabilita una connessione il collegamento non c'è
    Socket clientSocket = null;
    
    int porta = 2000;
    
    String str = "ciao a tutti!!!"; 
     
    DataInputStream in;
    DataOutputStream out;
    
    public Server(int porta){
        this.porta = porta;
    }
    
    public Socket attendi(){
        
        try {
            
            System.out.println("Inizializzo il server...");
            //inizializzo il servizio
            serverSocket = new ServerSocket(porta);
            
            System.out.println("Il server ha aperto la porta e ascolta.");
            
            System.out.println("Server in ascolto sulla porta 2000:");
            //mi metto in ascolto sulla porta 2000
            //metodo bloccante fino a che il client non fa una richiesta
            
            clientSocket = serverSocket.accept();
            
            
            
            System.out.println("Connessione stabilita con un client.");
            //serverSocket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        
        return clientSocket;
    }
    
    
    public void leggi(){
        String messaggioRicevuto; //contenuto dell'input stream
        try {
            BufferedReader br = new BufferedReader (new InputStreamReader (clientSocket.getInputStream()));
            
            messaggioRicevuto = br.readLine();
            System.out.println(messaggioRicevuto);
            System.out.println("Il messaggio è stato ricevuto.");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void scrivi(){
        try {
            out = new DataOutputStream(clientSocket.getOutputStream());
            System.out.println("CIAO SONO IL SERVER, IL TUO MESSAGGIO È STATO LETTO E TI STO RISPONDENDO...");

            //System.out.println("Il server risponde con: " +risposta);
            out.writeUTF(str);
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void chiudi(){
        try {
            if (serverSocket!=null)
                serverSocket.close();
            System.out.println("Connessione chiusa con il client.");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
