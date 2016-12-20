
import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edson
 */
public class Geral {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i < 65536; i++) {
            ServerSocket socket = null;
            try {
                socket = new ServerSocket(i+5000);
                System.out.println("Porta " + i+5000 + " aberta");
                Thread.sleep(1000);
            } catch (IOException e) {
                System.out.println("Porta " + i+5000 + " fechada");
            } catch (InterruptedException ex) {
                Logger.getLogger(Geral.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        /* e.printStackTrace(); */ }
                }
            }
        }
    }

}
