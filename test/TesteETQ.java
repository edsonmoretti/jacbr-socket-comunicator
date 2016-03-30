
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
            boolean PPLB = true;
            boolean EPL2 = false;
            if (PPLB) {
                ACBrETQ e = new ACBrETQ();
                System.out.println("Modelo: " + e.getModelo() + " - " + e.modeloStr());
                e.imprimirTexto(0, 2, 2, 2, 190, 0, " EDSON MORETTI - ");
                e.imprimirBarras(0, "1", "2", "30", 130, 50, "1234567890", 0);
                e.imprimirTexto(0, 3, 3, 2, 15, 250, "R$");
                e.imprimirTexto(0, 3, 4, 4, 15, 410, "100.00");
                e.setTemperatura(10);
                e.imprimir(1, 779);
                e.setLimparMemoria(true);
                Thread.sleep(1000);
            }
            if (EPL2) {
                ACBrETQ e = new ACBrETQ();
                e.ativar();
                System.out.println("Modelo: " + e.getModelo() + " - " + e.modeloStr());
                e.imprimirTexto(0, 2, 1, 3, 15, 45, "Descricao");
                e.imprimirTexto(0, 2, 1, 1, 80, 55, "R$ 0,00");
                e.imprimirBarras(0, "15", "45", "10", 120, 55, "0", 45);
                e.imprimirLinha(15, 15, 15, 15);
//                e.imprimirTexto(0, 2, 1, 3, 15, 365, Etiqueta.Descr);
//                e.imprimirTexto(0, 2, 1, 1, 80, 365, "R$ " + Etiqueta.Valor);
//                ImprimirBarras(0, Etiqueta.TipoBarCode, "2", "2", 120, 365, Etiqueta.Barras, 080, becSIM);
//                e.imprimirTexto(0, 2, 1, 3, 15, 670, Etiqueta.Descr);
//                e.imprimirTexto(0, 2, 1, 1, 80, 670, "R$ " + Etiqueta.Valor);
                e.imprimir(1, 779);
            }
        } catch (ACBrECFException ex) {
            Logger.getLogger(TesteETQ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(TesteETQ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
