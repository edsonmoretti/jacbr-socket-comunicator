
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrNFe;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrNFeException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrNFeInvalidaException;
import java.io.File;
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
        ACBrNFe n = new ACBrNFe();
        System.out.println("----------CONSULTANDO STATUS----------");
        try {
            System.out.println(n.getStatusServico());
        } catch (ACBrNFeException ex) {
            Logger.getLogger(TesteNFe.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("----------VALIDANDO NFE VIA CAMINHO STRING----------");
        try {
            n.validarNFe("D:\\PROJETOS\\Java\\SVN\\GTECH-GESTAO\\INTEGRADO\\dir\\sis\\nfe\\xml\\tempFiles\\26151110493367000148550010000002011170864657data.xml");
        } catch (ACBrNFeInvalidaException ex) {
            Logger.getLogger(TesteNFe.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("----------VALIDANDO NFE VIA CAMINHO FILE----------");
        try {
            n.validarNFe(new File("D:\\PROJETOS\\Java\\SVN\\GTECH-GESTAO\\INTEGRADO\\dir\\sis\\nfe\\xml\\tempFiles\\26151110493367000148550010000002011170864657data.xml"));
        } catch (ACBrNFeInvalidaException ex) {
            Logger.getLogger(TesteNFe.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("----------ASSINANDO NFE VIA CAMINHO STRING----------");
        try {
            n.assinarNFe("D:\\PROJETOS\\Java\\SVN\\GTECH-GESTAO\\INTEGRADO\\dir\\sis\\nfe\\xml\\tempFiles\\26151110493367000148550010000002011170864657data.xml");
        } catch (ACBrNFeException ex) {
            Logger.getLogger(TesteNFe.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("----------ASSINANDO NFE VIA CAMINHO FILE----------");
        try {
            n.assinarNFe(new File("D:\\PROJETOS\\Java\\SVN\\GTECH-GESTAO\\INTEGRADO\\dir\\sis\\nfe\\xml\\tempFiles\\26151110493367000148550010000002011170864657data.xml"));
        } catch (ACBrNFeException ex) {
            Logger.getLogger(TesteNFe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
