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
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michaelfuschiotti and Lorenzo Velloni 
 */
public class Client {
    String nome;
    String colore;
    Socket connection;
    
    public Client(String nome, String colore) {
        this.nome = nome;
        this.colore = colore;
    }
    
    public void connetti(String nomeServer, int portaServer){
        
        nomeServer = "127.0.0.1";
        portaServer = 2000;
        
        try {
            System.out.println("Provo a connettermi al server...");
            connection = new Socket(nomeServer, portaServer);
            
            System.out.println("Connesso!!!");
        } 
        catch(ConnectException ex){
            System.err.println("Server non disponibile!");
        }
        catch(UnknownHostException ex){
            System.err.println("Errore DNS!");
        }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore scheda di rete.");
            ex.printStackTrace();
        }
       
    }
    
    
    public void scrivi(){
        String messaggio = null;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         //new InputStreamReader morirà quando l'oggetto Buffered Reader finisce 
            //classe statica perché System = S grande -> classe STATICA 
        try {           
            messaggio = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            OutputStream os = connection.getOutputStream();
            os.write(messaggio.getBytes());
            os.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void leggi(){
        try {
            DataInputStream dos = new DataInputStream(connection.getInputStream());
            dos.readUTF();
            System.out.println("Sono, il client ed ho letto la risposta del server.");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void chiudi(){
        try {
            if (connection!=null)
                connection.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
