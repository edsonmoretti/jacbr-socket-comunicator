
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.RelatorioGerencial;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis.Aliquota;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis.ComprovanteNaoFiscal;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis.FormaDePagamento;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.Numeros;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edson Moretti - www.edsonmoretti.com.br
 */
public class TesteECF {

    private static ACBrECF e;

    public static void main(String[] args) {
        try {
            e = new ACBrECF(false);
            e.ativar();
            {//Variaveis
//                variaveis();
//                System.out.println("\n-- TESTANDO DADOS EQUIPAMENTO --\n");
//                dadosEquipamento();
//                System.out.println("\n-- TESTANDO MAPA DE RESUMO --\n");
//                mapaDeResumo();
//                System.out.println("\n-- TESTANDO ALIQUOTAS --\n");
//                aliquotas();
//                System.out.println("\n-- TESTANDO FORMAS DE PAGAMENTO --\n");
//                formasDePagamento();
//                System.out.println("\n-- TESTANDO COMPROVANTES NÃO FISCAIS --\n");
//                comprovantesNFiscais();
//                System.out.println("\n-- TESTANDO RELATORIOS GERENCIAIS --\n");
//                relatoriosGerenciais();

            }
            {//Cupom Fiscal
//                e.getCupomFiscal().testaPodeAbrirCupom();
//                e.getCupomFiscal().identificaConsumidor("07900648470");
                try {
                    e.getCupomFiscal().abreCupom();
                    e.getCupomFiscal().vendeItem("001", "descricao item 1", Numeros.parseToBig("18"), new BigDecimal("5"), Numeros.parseToBig("5,00"), 'T');
                    e.getCupomFiscal().vendeItem("002", "descricao item 2", "17", "2", "1,02", 'T');
                    e.getCupomFiscal().vendeItem("003", "descricao item 3", Double.parseDouble("18"), Double.parseDouble("2"), Double.parseDouble("1.02"), 'T');
                    if (e.getVariaveis().getEquipamento().getMarcaStr().toLowerCase().contains("daruma")) {
//                        e.getCupomFiscal().vendeItem("004", "descricao item 4", Numeros.parseToBig("17"), new BigDecimal("20"), BigDecimal.ONE, BigDecimal.TEN, "UND", '$', 'A', 1, 'T');
                    }
                    e.getCupomFiscal().cancelaItemVendido(2);
                    e.getCupomFiscal().vendeItem("005", "descricao item 5", "17", "4", "1,02", 'T');
                    e.getCupomFiscal().cancelaItemVendido(4);
                    if (e.getVariaveis().getEquipamento().getMarcaStr().toLowerCase().contains("daruma")) {
                        e.getCupomFiscal().cancelaItemVendidoParcial(1, "1,5");
                    }
                    e.getCupomFiscal().vendeItem("006", "descricao item 6 - aplicar desc", "FF", "6", "1,00", 'T');
                    e.getCupomFiscal().descontoItemAnterior(BigDecimal.ONE, '%');
                    e.getCupomFiscal().vendeItem("007", "descricao item 7 - aplicar acres", "12", BigDecimal.TEN, BigDecimal.ONE, 'T');
                    e.getCupomFiscal().acrescimoItemAnterior(BigDecimal.ONE, '%');
                    e.getCupomFiscal().vendeItem("008", "descricao item 8 - aplicar desc item", "II", BigDecimal.TEN, BigDecimal.ONE, 'T');
                    e.getCupomFiscal().descontoAcrescimoItem(BigDecimal.ONE, 'D', '$', 8);
                    System.out.println("Numero Cupom: " + e.getCupomFiscal().getVariaveis().getNumCupom());
                    System.out.println("Numero ultimo item: " + e.getCupomFiscal().getVariaveis().getNumUltItem());
                    e.getCupomFiscal().subtotalizaCupom();
                    e.getCupomFiscal().efetuaPagamento("01", new BigDecimal(100));
                    System.out.println("Subtotal: " + e.getCupomFiscal().getVariaveis().getSubTotal());
                    System.out.println("Total pago: " + e.getCupomFiscal().getVariaveis().getTotalPago());
                    e.getCupomFiscal().fechaCupom("mensagem linha1|mensagem linha2");
                } catch (Exception ex) {
                    System.err.println(ex);
                    e.getCupomFiscal().cancelaCupom();
                }
            }
        } catch (ACBrECFException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(TesteECF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void comprovantesNFiscais() throws ACBrECFException {
        System.out.println("\ncomprovantesNaoFiscais");
        for (ComprovanteNaoFiscal comprovantesNaoFiscai : e.getVariaveis().getComprovantesNaoFiscais().getComprovantesNaoFiscais()) {
            System.out.println(comprovantesNaoFiscai);

        }
        System.out.println("\ncarregaComprovantesNaoFiscais");
        for (ComprovanteNaoFiscal comprovanteNaoFiscal : e.getVariaveis().getComprovantesNaoFiscais().carregaComprovantesNaoFiscais()) {
            System.out.println(comprovanteNaoFiscal);
        }
        System.out.println("\nlerTotaisComprovanteNaoFiscal");
        for (ComprovanteNaoFiscal comprovanteNaoFiscal : e.getVariaveis().getComprovantesNaoFiscais().lerTotaisComprovanteNaoFiscal()) {
            System.out.println(comprovanteNaoFiscal);
        }
        System.out.println("\nAchar");
        System.out.println(e.getVariaveis().getComprovantesNaoFiscais().achaCNFDescricao("sangria"));
    }

    private static void relatoriosGerenciais() throws ACBrECFException {
        System.out.println("relatoriosGerenciais");
        for (RelatorioGerencial r : e.getVariaveis().getRelatoriosGerenciais().getRelatoriosGerenciais()) {
            System.out.println(r);
        }
        System.out.println("carregaRelatoriosGerenciais");
        for (RelatorioGerencial r : e.getVariaveis().getRelatoriosGerenciais().carregaRelatoriosGerenciais()) {
            System.out.println(r);
        }
        System.out.println("lerTotaisRelatoriosGerenciais");
        for (RelatorioGerencial r : e.getVariaveis().getRelatoriosGerenciais().lerTotaisRelatoriosGerenciais()) {
            System.out.println(r);
        }
        System.out.println("achar");
        System.out.println(e.getVariaveis().getRelatoriosGerenciais().achaRGDescricao("Fechamento"));
    }

    private static void mapaDeResumo() throws ACBrECFException {
        System.out.println(e.getVariaveis().getMapaResumo().getDataMovimento());
        System.out.println(e.getVariaveis().getMapaResumo().getDadosReducaoZ());
        if (e.getVariaveis().getEquipamento().getMarcaStr().toLowerCase().contains("sweda")) {
            JOptionPane.showMessageDialog(null, "DadosUltimReducao Nao implementado Impressora Sweda.");
        } else {
            System.out.println(e.getVariaveis().getMapaResumo().getDadosUltimaReducaoZ()); //TODO: Testar em impressora Fisica
        }
        System.out.println(e.getVariaveis().getMapaResumo().getNumReducoesZRestantes());
        System.out.println(e.getVariaveis().getMapaResumo().getNumCOO());
        System.out.println(e.getVariaveis().getMapaResumo().getNumCRZ());
        System.out.println(e.getVariaveis().getMapaResumo().getNumCRO());
        System.out.println(e.getVariaveis().getMapaResumo().getNumCCF());
        System.out.println(e.getVariaveis().getMapaResumo().getNumCOOInicial());
        System.out.println(e.getVariaveis().getMapaResumo().getNumGNF());
        System.out.println(e.getVariaveis().getMapaResumo().getNumGNFC());
        System.out.println(e.getVariaveis().getMapaResumo().getNumGRG());
        System.out.println(e.getVariaveis().getMapaResumo().getNumCDC());
        System.out.println(e.getVariaveis().getMapaResumo().getNumCFC());
        System.out.println(e.getVariaveis().getMapaResumo().getNumCCDC());
        System.out.println(e.getVariaveis().getMapaResumo().getNumCFD());
        System.out.println(e.getVariaveis().getMapaResumo().getNumNCN());
        System.out.println(e.getVariaveis().getMapaResumo().getVendaBruta());
        System.out.println(e.getVariaveis().getMapaResumo().getGrandeTotal());
        System.out.println(e.getVariaveis().getMapaResumo().getTotalTroco());
    }

    private static void dadosEquipamento() throws ACBrECFException {
        System.out.println(e.getVariaveis().getEquipamento().getEstado());
        System.out.println(e.getVariaveis().getEquipamento().getDataHora());
        System.out.println(e.getVariaveis().getEquipamento().getMarcaStr());
        System.out.println(e.getVariaveis().getEquipamento().getModeloStr());
        System.out.println(e.getVariaveis().getEquipamento().getSubModeloECF());
        System.out.println(e.getVariaveis().getEquipamento().getNumECF());
        System.out.println(e.getVariaveis().getEquipamento().getNumLoja());
        System.out.println(e.getVariaveis().getEquipamento().getNumSerieMFD());
        System.out.println(e.getVariaveis().getEquipamento().getNumSerie());
        System.out.println(e.getVariaveis().getEquipamento().getNumVersao());
        System.out.println(e.getVariaveis().getEquipamento().getCnpj());
        System.out.println(e.getVariaveis().getEquipamento().getIe());
        System.out.println(e.getVariaveis().getEquipamento().getIm());
        System.out.println(e.getVariaveis().getEquipamento().getPaf());
        System.out.println(e.getVariaveis().getEquipamento().getUsuarioAtual());
        System.out.println(e.getVariaveis().getEquipamento().getCliche());
        System.out.println(e.getVariaveis().getEquipamento().getDataHoraSwBasico());
        System.out.println(e.getVariaveis().getEquipamento().getDecimaisQtd());
        System.out.println(e.getVariaveis().getEquipamento().getDecimaisPreco());
        System.out.println(e.getVariaveis().getEquipamento().getColunas());
        System.out.println(e.getVariaveis().getEquipamento().getMfAdicional());
        System.out.println(e.getVariaveis().getEquipamento().getRfdid());
        System.out.println(e.getVariaveis().getEquipamento().getRegistroFitaDetalhe());
    }

    private static void aliquotas() throws ACBrECFException {
        for (Aliquota aliquota : e.getVariaveis().getAliquotas().getAliquotas()) {
            System.out.println("Aliquotas: " + aliquota);
        }
        for (Aliquota aliquota : e.getVariaveis().getAliquotas().carregaAliquotas()) {
            System.out.println("carregaAliquotas: " + aliquota);
        }
        for (Aliquota aliquota : e.getVariaveis().getAliquotas().lerTotaisAliquota()) {
            System.out.println("lerTotaisAliquota: " + aliquota + " - Total: " + aliquota.getTotal());
        }
        System.out.println(e.getVariaveis().getAliquotas().acharAliquotaPorValor(BigDecimal.TEN));
        System.out.println(e.getVariaveis().getAliquotas().acharAliquotaPorValor(BigDecimal.TEN, 'S'));
        System.out.println(e.getVariaveis().getAliquotas().acharAliquotaPorValor(BigDecimal.TEN, 'T'));
    }

    private static void formasDePagamento() throws ACBrECFException {
        for (FormaDePagamento formaDePagamento : e.getVariaveis().getFormasDePagamento().getFormasPagamento()) {
            System.out.println("Formas " + formaDePagamento);
        }
        for (FormaDePagamento formaDePagamento : e.getVariaveis().getFormasDePagamento().carregaFormasPagamento()) {
            System.out.println("Carrega " + formaDePagamento);
        }
        for (FormaDePagamento formaDePagamento : e.getVariaveis().getFormasDePagamento().getTotaisFormaPagamento()) {
            System.out.println("LerTotais " + formaDePagamento);
        }
        System.out.println(e.getVariaveis().getFormasDePagamento().achaFPGDescricao("dinheiro"));
    }

    private static void variaveis() throws ACBrECFException {
        System.out.println(e.getVariaveis().carregaUnidadesMedida());
        System.out.println(e.getVariaveis().unidadesMedida());
    }
}
