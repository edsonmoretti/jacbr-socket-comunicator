
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrETQ;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
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
public class TesteETQ {

    public static void main(String[] args) {
        try {
            for (int i = 11; i < 13; i++) {
                ACBrETQ e = new ACBrETQ();
                e.ativar();
                System.out.println("Modelo: " + e.modelo() + " - " + e.modeloStr());
                e.imprimirTexto(0, 2, 2, 2, 190, 0, " EDSON MORETTI - " + i);
                e.imprimirBarras(0, "1", "2", "30", 130, 50, "1234567890", 0);
                e.imprimirTexto(0, 3, 3, 2, 15, 250, "R$");
                e.imprimirTexto(0, 3, 4, 4, 15, 410, "100.00");
                e.setTemperatura(7);
                e.imprimir(1, 779);
                e.setLimparMemoria(true);
                Thread.sleep(1000);
            }
        } catch (ACBrECFException ex) {
            Logger.getLogger(TesteETQ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(TesteETQ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
