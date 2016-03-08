
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
            ACBrETQ etq = new ACBrETQ();
            if (!etq.isAtivo()) {
                etq.ativar();
            }
            System.out.println("Modelo: " + etq.modelo() + " - " + etq.modeloStr());
            etq.imprimirTexto(0, 3, 2, 1, 55, 100, "Teste de etiqueta");
            etq.imprimirBarras(1, "1", "10", "5", 1, 1, "23121", 1);
            etq.imprimir(1, 0);
        } catch (ACBrECFException ex) {
            Logger.getLogger(TesteETQ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
