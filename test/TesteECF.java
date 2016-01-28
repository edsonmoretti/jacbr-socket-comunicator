
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.ACBrECF;
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
                    e.getCupomFiscal().vendeItem("001", "descricao item 1", Numeros.parseToBig("18"), new BigDecimal("5"), Numeros.parseToBig("5,00"));
                    e.getCupomFiscal().vendeItem("002", "descricao item 2", "17", "2", "1,02");
                    e.getCupomFiscal().vendeItem("003", "descricao item 3", Double.parseDouble("18"), Double.parseDouble("2"), Double.parseDouble("1.02"));
                    if (e.getVariaveis().getEquipamento().marcaStr().toLowerCase().contains("daruma")) {
                        e.getCupomFiscal().vendeItem("004", "descricao item 4", Numeros.parseToBig("17"), new BigDecimal("20"), BigDecimal.ONE, BigDecimal.TEN, "UND", '$', 'A', 1);
                    }
                    e.getCupomFiscal().cancelaItemVendido(2);
                    e.getCupomFiscal().vendeItem("005", "descricao item 5", "17", "4", "1,02");
                    e.getCupomFiscal().cancelaItemVendido(4);
                    if (e.getVariaveis().getEquipamento().marcaStr().toLowerCase().contains("daruma")) {
                        e.getCupomFiscal().cancelaItemVendidoParcial(1, "1,5");
                    }
                    e.getCupomFiscal().vendeItem("006", "descricao item 6 - aplicar desc", "FF", "6", "1,00");
                    e.getCupomFiscal().descontoItemAnterior(BigDecimal.ONE, '%');
                    e.getCupomFiscal().vendeItem("007", "descricao item 7 - aplicar acres", "12", BigDecimal.TEN, BigDecimal.ONE);
                    e.getCupomFiscal().acrescimoItemAnterior(BigDecimal.ONE, '%');
                    e.getCupomFiscal().vendeItem("008", "descricao item 8 - aplicar desc item", "II", BigDecimal.TEN, BigDecimal.ONE);
                    e.getCupomFiscal().descontoAcrescimoItem(BigDecimal.ONE, 'D', '$', 8);
                    System.out.println("Numero Cupom: " + e.getCupomFiscal().getVariaveis().numCupom());
                    System.out.println("Numero ultimo item: " + e.getCupomFiscal().getVariaveis().numUltItem());
                    e.getCupomFiscal().subtotalizaCupom();
                    e.getCupomFiscal().efetuaPagamento("01", new BigDecimal(100));
                    System.out.println("Subtotal: " + e.getCupomFiscal().getVariaveis().subTotal());
                    System.out.println("Total pago: " + e.getCupomFiscal().getVariaveis().totalPago());
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
        for (ACBrECF.Variaveis.ComprovanteNaoFiscal comprovanteNaoFiscal : e.getVariaveis().getComprovantesNaoFiscais().comprovantesNaoFiscais()) {
            System.out.println(comprovanteNaoFiscal);
        }
        System.out.println("\ncarregaComprovantesNaoFiscais");
        for (ACBrECF.Variaveis.ComprovanteNaoFiscal comprovanteNaoFiscal : e.getVariaveis().getComprovantesNaoFiscais().carregaComprovantesNaoFiscais()) {
            System.out.println(comprovanteNaoFiscal);
        }
        System.out.println("\nlerTotaisComprovanteNaoFiscal");
        for (ACBrECF.Variaveis.ComprovanteNaoFiscal comprovanteNaoFiscal : e.getVariaveis().getComprovantesNaoFiscais().lerTotaisComprovanteNaoFiscal()) {
            System.out.println(comprovanteNaoFiscal);
        }
        System.out.println("\nAchar");
        System.out.println(e.getVariaveis().getComprovantesNaoFiscais().achaCNFDescricao("sangria"));
    }

    private static void relatoriosGerenciais() throws ACBrECFException {
        System.out.println("relatoriosGerenciais");
        for (ACBrECF.Variaveis.RelatorioGerencial r : e.getVariaveis().getRelatoriosGerenciais().relatoriosGerenciais()) {
            System.out.println(r);
        }
        System.out.println("carregaRelatoriosGerenciais");
        for (ACBrECF.Variaveis.RelatorioGerencial r : e.getVariaveis().getRelatoriosGerenciais().carregaRelatoriosGerenciais()) {
            System.out.println(r);
        }
        System.out.println("lerTotaisRelatoriosGerenciais");
        for (ACBrECF.Variaveis.RelatorioGerencial r : e.getVariaveis().getRelatoriosGerenciais().lerTotaisRelatoriosGerenciais()) {
            System.out.println(r);
        }
        System.out.println("achar");
        System.out.println(e.getVariaveis().getRelatoriosGerenciais().achaRGDescricao("Fechamento"));
    }

    private static void mapaDeResumo() throws ACBrECFException {
        System.out.println(e.getVariaveis().getMapaResumo().dataMovimento());
        System.out.println(e.getVariaveis().getMapaResumo().dadosReducaoZ());
        if (e.getVariaveis().getEquipamento().marcaStr().toLowerCase().contains("sweda")) {
            JOptionPane.showMessageDialog(null, "DadosUltimReducao Nao implementado Impressora Sweda.");
        } else {
            System.out.println(e.getVariaveis().getMapaResumo().dadosUltimaReducaoZ()); //TODO: Testar em impressora Fisica
        }
        System.out.println(e.getVariaveis().getMapaResumo().numReducoesZRestantes());
        System.out.println(e.getVariaveis().getMapaResumo().numCOO());
        System.out.println(e.getVariaveis().getMapaResumo().numCRZ());
        System.out.println(e.getVariaveis().getMapaResumo().numCRO());
        System.out.println(e.getVariaveis().getMapaResumo().numCCF());
        System.out.println(e.getVariaveis().getMapaResumo().numCOOInicial());
        System.out.println(e.getVariaveis().getMapaResumo().numGNF());
        System.out.println(e.getVariaveis().getMapaResumo().numGNFC());
        System.out.println(e.getVariaveis().getMapaResumo().numGRG());
        System.out.println(e.getVariaveis().getMapaResumo().numCDC());
        System.out.println(e.getVariaveis().getMapaResumo().numCFC());
        System.out.println(e.getVariaveis().getMapaResumo().numCCDC());
        System.out.println(e.getVariaveis().getMapaResumo().numCFD());
        System.out.println(e.getVariaveis().getMapaResumo().numNCN());
        System.out.println(e.getVariaveis().getMapaResumo().vendaBruta());
        System.out.println(e.getVariaveis().getMapaResumo().grandeTotal());
        System.out.println(e.getVariaveis().getMapaResumo().totalTroco());
    }

    private static void dadosEquipamento() throws ACBrECFException {
        System.out.println(e.getVariaveis().getEquipamento().estado());
        System.out.println(e.getVariaveis().getEquipamento().dataHora());
        System.out.println(e.getVariaveis().getEquipamento().marcaStr());
        System.out.println(e.getVariaveis().getEquipamento().modeloStr());
        System.out.println(e.getVariaveis().getEquipamento().subModeloECF());
        System.out.println(e.getVariaveis().getEquipamento().numECF());
        System.out.println(e.getVariaveis().getEquipamento().numLoja());
        System.out.println(e.getVariaveis().getEquipamento().numSeriaMFD());
        System.out.println(e.getVariaveis().getEquipamento().numSerie());
        System.out.println(e.getVariaveis().getEquipamento().numVersao());
        System.out.println(e.getVariaveis().getEquipamento().cnpj());
        System.out.println(e.getVariaveis().getEquipamento().ie());
        System.out.println(e.getVariaveis().getEquipamento().im());
        System.out.println(e.getVariaveis().getEquipamento().paf());
        System.out.println(e.getVariaveis().getEquipamento().usuarioAtual());
        System.out.println(e.getVariaveis().getEquipamento().cliche());
        System.out.println(e.getVariaveis().getEquipamento().dataHoraSwBasico());
        System.out.println(e.getVariaveis().getEquipamento().decimaisQtd());
        System.out.println(e.getVariaveis().getEquipamento().decimaisPreco());
        System.out.println(e.getVariaveis().getEquipamento().colunas());
        System.out.println(e.getVariaveis().getEquipamento().mfAdicional());
        System.out.println(e.getVariaveis().getEquipamento().rfdid());
        System.out.println(e.getVariaveis().getEquipamento().registroFitaDetalhe());
    }

    private static void aliquotas() throws ACBrECFException {
        for (ACBrECF.Variaveis.Aliquota aliquota : e.getVariaveis().getAliquotas().aliquotas()) {
            System.out.println("Aliquotas: " + aliquota);
        }
        for (ACBrECF.Variaveis.Aliquota aliquota : e.getVariaveis().getAliquotas().carregaAliquotas()) {
            System.out.println("carregaAliquotas: " + aliquota);
        }
        for (ACBrECF.Variaveis.Aliquota aliquota : e.getVariaveis().getAliquotas().lerTotaisAliquota()) {
            System.out.println("lerTotaisAliquota: " + aliquota + " - Total: " + aliquota.getTotal());
        }
        System.out.println(e.getVariaveis().getAliquotas().acharAliquotaPorValor(BigDecimal.TEN));
        System.out.println(e.getVariaveis().getAliquotas().acharAliquotaPorValor(BigDecimal.TEN, 'S'));
        System.out.println(e.getVariaveis().getAliquotas().acharAliquotaPorValor(BigDecimal.TEN, 'T'));
    }

    private static void formasDePagamento() throws ACBrECFException {
        for (ACBrECF.Variaveis.FormaDePagamento formaDePagamento : e.getVariaveis().getFormasDePagamento().formasPagamento()) {
            System.out.println("Formas " + formaDePagamento);
        }
        for (ACBrECF.Variaveis.FormaDePagamento formaDePagamento : e.getVariaveis().getFormasDePagamento().carregaFormasPagamento()) {
            System.out.println("Carrega " + formaDePagamento);
        }
        for (ACBrECF.Variaveis.FormaDePagamento formaDePagamento : e.getVariaveis().getFormasDePagamento().lerTotaisFormaPagamento()) {
            System.out.println("LerTotais " + formaDePagamento);
        }
        System.out.println(e.getVariaveis().getFormasDePagamento().achaFPGDescricao("dinheiro"));
    }

    private static void variaveis() throws ACBrECFException {
        System.out.println(e.getVariaveis().carregaUnidadesMedida());
        System.out.println(e.getVariaveis().unidadesMedida());
    }
}
