/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package comunicazionetcpoop;

/**
 *
 * @author michaelfuschiotti
 */
public class MainClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client c1 = new Client ("nome", "colore");
        c1.connetti("prova", 2000);
        c1.scrivi();
        c1.leggi();
        c1.chiudi();
        
        
        
    }
    
}
