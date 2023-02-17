/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicazionetcpoop;

/**
 *
 * @author michaelfuschiotti
 */
public class MainServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server s = new Server(2000);
        
        s.attendi();
        s.scrivi();
        s.leggi();
        s.chiudi();
        
        
        
    }
    
}
