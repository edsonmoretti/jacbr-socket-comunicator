
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrCTe;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.cte.Destinatario;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.cte.Emitente;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.cte.Entrega;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.cte.Identificacao;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.cte.InfCTe;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrCTeException;
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
public class TesteCTe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ACBrCTe cte = new ACBrCTe();
            String dados = "dados";
            System.out.println(cte.getStatusServico().toString());
            cte.setInfCTe(new InfCTe());
            cte.setDestinatario(new Destinatario(dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados));
            cte.setIdentificacao(new Identificacao(dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados));
            cte.setEmitente(new Emitente(dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados, dados));
            cte.setEntrega(new Entrega(dados, dados, dados, dados, dados, dados, dados, dados));
            cte.criarCTe();
        } catch (ACBrCTeException ex) {
            Logger.getLogger(TesteCTe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
