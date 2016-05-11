
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
        ACBrNFe n = new ACBrNFe();
        System.out.println("----------CONSULTANDO CERTIFICADO----------");
        try {
            System.out.println(n.getCNPJDoCertificado());
        } catch (ACBrNFeException ex) {
            Logger.getLogger(TesteNFe.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("----------CONSULTANDO STATUS----------");
        try {
            System.out.println(n.getStatusServico());
        } catch (ACBrNFeException ex) {
            Logger.getLogger(TesteNFe.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.println("----------CRIANDO NFE VIA OBJETO COM VALORES ESTATICOS ----------");
//        try {
//            NFeVO nFe = new NFeVO(
//                    new InfNfe(),
//                    new Identificacao("26", "1", "5102 VENDA", "0", "55", "1", "1", "04/04/2016", "04/04/2016", "1", "1", "2605707", "2", "1", "1", "0", "1", "0", "GPP-0.1171.130", "", ""),
//                    new Emitente("02705381000130", "Brasystem Informatica", "Brasystem", "252730810", "", "", "", "1", "Rua saldanha marinho", "374", "Apto1", "Centro", "4205407", "Florianopolis", "SC", "93600-000", "1058", "BRASIL", "(48) 3025-2628", "SC", "4205407"),
//                    new Avulsa("", "", "", "", "", "", "", "", "", "", ""),
//                    new Destinatario("1", "11605720000105", "MARIA EDILMA T DE MORAIS SUPERMERCADO", "1", "039235092", "", "jluciano@ig.com.br", "RUA MAJOR JOAO COELHO", "565", "ap1", "COHAB III", "2604106", "CARUARU", "PE", "55022-220", "1058", "BRASIL", "(81) 99563-0111"),
//                    new Retirada("", "", "", "", "", "", "", ""),
//                    new Entrega("", "", "", "", "", "", "", "")
//            )
//                    .addNFRef(new NFRef("Tipo", "refNFe", "cUF", "AAMM", "CNPJ", "mod", "Serie", "nNF", "CNPJCPF", "IE", "refCTe", "ModECF", "nECF", "nCOO"))
//                    .addNFRef(new NFRef("Tipo", "refNFe", "cUF", "AAMM", "CNPJ", "mod", "Serie", "nNF", "CNPJCPF", "IE", "refCTe", "ModECF", "nECF", "nCOO"))
//                    .addautXML(new AautXML("CNPJCPF"))
//                    .addautXML(new AautXML("CNPJCPF"))
//                    .addProduto(new Produto("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
//                            .addNVE(new NVE("NVE1P1"))
//                            .addNVE(new NVE("NVE2P1"))
//                            .addNVE(new NVE("NVE3P1")))
//                    .addProduto(new Produto("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
//                            .addNVE(new NVE("NVE1P1"))
//                            .addNVE(new NVE("NVE2P1")));
//            nFe.toString();
//            System.out.println(n.criarNFe(nFe.toString()));
////            System.out.println(n.criarNFe("C:\\Users\\DANIEL\\Desktop\\ex1Nfe.ini", false));
//        } catch (ACBrNFeException ex) {
//            Logger.getLogger(TesteNFe.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        System.out.println("----------VALIDANDO NFE VIA CAMINHO STRING----------");
//        try {
//            n.validarNFe("D:\\SVN\\COPIA LOCAL\\GESTAO++\\smallfit\\Gestao++\\dir\\sis\\nfe\\XML_ENTRADA\\26160402705381000130550010000000301895970630data.xml");
//        } catch (ACBrNFeInvalidaException ex) {
//            Logger.getLogger(TesteNFe.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println("----------VALIDANDO NFE VIA CAMINHO FILE----------");
//        try {
//            n.validarNFe(new File("D:\\SVN\\COPIA LOCAL\\GESTAO++\\smallfit\\Gestao++\\dir\\sis\\nfe\\XML_ENTRADA\\26160402705381000130550010000000301895970630data.xml"));
//        } catch (ACBrNFeInvalidaException ex) {
//            Logger.getLogger(TesteNFe.class.getName()).log(Level.SEVERE, null, ex);
//        }
        System.out.println("----------ASSINANDO NFE VIA CAMINHO STRING----------");
        try {
            n.assinarNFe("D:\\SVN\\COPIA LOCAL\\GESTAO-INTEGRADO\\smallfit\\INTEGRADO smallfit\\dir\\sis\\nfe\\xml\\tempFiles\\26160404387293000162550010000001191193043113data.xml");
        } catch (ACBrNFeException ex) {
            Logger.getLogger(TesteNFe.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("----------ENVIANDO NFE VIA CAMINHO STRING----------");
        try {
            System.out.println(n.enviarNFe("D:\\SVN\\COPIA LOCAL\\GESTAO-INTEGRADO\\smallfit\\INTEGRADO smallfit\\dir\\sis\\nfe\\xml\\tempFiles\\26160404387293000162550010000001191193043113data.xml", 1));
        } catch (ACBrNFeException ex) {
            Logger.getLogger(TesteNFe.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("----------CONSULTANDO NFE VIA CAMINHO STRING----------");
        try {
            System.out.println(n.consultarNFe("D:\\SVN\\COPIA LOCAL\\GESTAO-INTEGRADO\\smallfit\\INTEGRADO smallfit\\dir\\sis\\nfe\\xml\\tempFiles\\26160404387293000162550010000001191193043113data.xml"));
        } catch (ACBrNFeException ex) {
            Logger.getLogger(TesteNFe.class.getName()).log(Level.SEVERE, null, ex);
        }
////        System.out.println("----------ASSINANDO NFE VIA CAMINHO FILE----------");
//        try {
//            n.assinarNFe(new File("D:\\SVN\\COPIA LOCAL\\GESTAO++\\smallfit\\Gestao++\\dir\\sis\\nfe\\XML_ENTRADA\\26160402705381000130550010000000301895970630data.xml"));
//        } catch (ACBrNFeException ex) {
//            Logger.getLogger(TesteNFe.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
