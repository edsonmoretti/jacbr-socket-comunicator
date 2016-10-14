
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrAAC;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.aac.ECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrAACException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
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
public class TesteACBrAAC {

    public static void main(String[] args) {
        try {
            ACBrAAC aac = new ACBrAAC();
            aac.getArquivosAutenticados().getEmpresaDesenvolvedora().setCnpj("10493367000148");
            aac.getArquivosAutenticados().getEmpresaDesenvolvedora().setInscricaoEstadual("01234564");
            aac.getArquivosAutenticados().getEmpresaDesenvolvedora().setInscricaoMunicipal("");
            aac.getArquivosAutenticados().getEmpresaDesenvolvedora().setRazaoSocial("geraldo joao da silva me");
            aac.getArquivosAutenticados().getIdentificacaoDoPAF().setLaudoDoPafEcf("56565456");
            aac.getArquivosAutenticados().getIdentificacaoDoPAF().setNomeDoPafEcf("gtech-paf++");
            aac.getArquivosAutenticados().getIdentificacaoDoPAF().setVersaoDoPafEcf("2.04");
            for (int i = 0; i < 10; i++) {
                File f = new File("arq" + i + ".jar");
                try {
                    f.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(ACBrAAC.class.getName()).log(Level.SEVERE, null, ex);
                }
                aac.getArquivosAutenticados().getRelacaoDosArquivos().add(f);
            }
            aac.getArquivosAutenticados().salvarArquivo();
            ECF e2 = new ECF();
            ECF e = new ECF();
            e.setSerieEcf("DR0511BR000000261311");
            e2.setSerieEcf("DR000000000000000000");
            ACBrECF ecf = new ACBrECF(true);
            e.setGrandeTotal(ecf.getVariaveis().getMapaResumo().getGrandeTotal());
            e2.setGrandeTotal(BigDecimal.TEN);
            aac.getArquivoCriptografado().getEcfs().add(e);
            aac.getArquivoCriptografado().getEcfs().add(e2);
            aac.getArquivoCriptografado().criarArquivo(ecf.getVariaveis().getEquipamento().getCnpj());
            System.out.println("----------------");
            aac.getArquivoCriptografado().isEcfAutorizado(ecf);
            System.out.println("Está autorizado? DR000000000000000000: " + aac.getArquivoCriptografado().isEcfAutorizado("DR000000000000000000", BigDecimal.TEN, "10493367000148"));
        } catch (ACBrAACException ex) {
            Logger.getLogger(ACBrAAC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ACBrECFException ex) {
            Logger.getLogger(TesteACBrAAC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
