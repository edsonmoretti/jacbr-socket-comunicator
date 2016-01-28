
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrNCM;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrNFe;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrNFeException;
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
public class TesteNFe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ACBrNFe.getInstance().statusServico();
        } catch (ACBrNFeException ex) {
            Logger.getLogger(TesteNFe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
