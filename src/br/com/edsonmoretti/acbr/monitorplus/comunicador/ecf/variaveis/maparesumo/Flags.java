/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis.maparesumo;

import static br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF.comandoECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.TipoDocumento;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;

/**
 *
 * @author Edson
 */
public class Flags {

    /**
     * Retorna o tipo do último documento emitido pelo ECF.
     * <b>Nota:</b> Comando disponível apenas para Epson e FiscNet, os demais
     * modelos de ECF irá retornar "docNenhum".<br><br>
     * <b>Tipo de documento:</b> <br>
     * <b>docRZ</b> - Redução Z; <br>
     * <b>docLX</b> - Leitura X; <br>
     * <b>docCF</b> - Cupom Fiscal; <br>
     * <b>docCFBP</b> - Cupom Fiscal Bilhete de Passagem; <br>
     * <b>docCupomAdicional</b> - Cupom Adicional; <br>
     * <b>docCFCancelamento</b> - Cancelamento Cupom Fiscal; <br>
     * <b>docCCD</b> - Comprovante de Crédito ou Débito; <br>
     * <b>docAdicionalCCD</b> - Adicional de Comprovante de Crédito ou Débito;
     * <br>
     * <b>docSegViaCCD</b> - Segunda Via de Comprovante de Crédito ou Débito;
     * <br>
     * <b>docReimpressaoCCD</b> - Reimpressão de Comprovante de Crédito ou
     * Débito;
     * <br>
     * <b>docEstornoCCD</b> - Estorno de Comprovante de Crédito ou Débito;
     * <br>
     * <b>docCNF</b> - Comprovante Não Fiscal; <br>
     * <b>docCNFCancelamento</b> - Cancelamento Comprovante Não Fiscal;
     * <br>
     * <b>docSangria</b> - Sangria; <br>
     * <b>docSuprimento</b> - Suprimento; <br>
     * <b>docEstornoPagto</b> - Estorno Pagamento; <br>
     * <b>docRG</b> - Relatório Gerencial; <br>
     * <b>docLMF</b> - Leitura da Memória Fiscal; <br>
     * <b>docTodos</b> - Todos; <br>
     * <b>docNenhum</b> - Nenhum documento; <br>
     *
     * @return Tipo de Documento
     * @throws ACBrECFException
     */
    public TipoDocumento getTipoUltimoDocumento() throws ACBrECFException {
        switch (comandoECF("TipoUltimoDocumento")) {
            case "docRZ":
                return TipoDocumento.docRZ;
            case "docLX":
                return TipoDocumento.docLX;
            case "docCF":
                return TipoDocumento.docCF;
            case "docCFBP":
                return TipoDocumento.docCFBP;
            case "docCupomAdicional":
                return TipoDocumento.docCupomAdicional;
            case "docCFCancelamento":
                return TipoDocumento.docCFCancelamento;
            case "docCCD":
                return TipoDocumento.docCCD;
            case "docAdicionalCCD":
                return TipoDocumento.docAdicionalCCD;
            case "docSegViaCCD":
                return TipoDocumento.docSegViaCCD;
            case "docReimpressaoCCD":
                return TipoDocumento.docReimpressaoCCD;
            case "docEstornoCCD":
                return TipoDocumento.docEstornoCCD;
            case "docCNF":
                return TipoDocumento.docCNF;
            case "docCNFCancelamento":
                return TipoDocumento.docCNFCancelamento;
            case "docSangria":
                return TipoDocumento.docSangria;
            case "docSuprimento":
                return TipoDocumento.docSuprimento;
            case "docEstornoPagto":
                return TipoDocumento.docEstornoPagto;
            case "docLMF":
                return TipoDocumento.docLMF;
            case "docRG":
                return TipoDocumento.docRG;
            case "docTodos":
                return TipoDocumento.docTodos;
            case "docNenhum":
                return TipoDocumento.docNenhum;
            default:
                throw new ACBrECFException("Tipo de Documento não reconhecido.");
        }
    }

    /**
     * Retorna se o ECF está com pouco papel.
     *
     * @return
     * @throws ACBrECFException
     */
    public boolean isPoucoPapel() throws ACBrECFException {
        return comandoECF("PoucoPapel").equalsIgnoreCase("true");
    }

    /**
     * Retorna se o ECF está em Horário de Verão.
     * <b>Nota:</b> Isso também pode ser constatado observando a letra “V” ao
     * lado da Hora no rodapé do Cupom Fiscal - Exemplo: 10:16:32V
     *
     * @return
     * @throws ACBrECFException
     */
    public boolean isHorarioVerao() throws ACBrECFException {
        return comandoECF("HorarioVerao").equalsIgnoreCase("true");
    }

    /**
     * Retorna se o ECF arredonda os valores do "Total por Item" durante a
     * Venda.<br>
     * <br>Exemplo: Qtd 1 x Preço Unit. 1,207 = 1,21 com Arredondamento no ECF
     * <br>= 1,20 sem Arredondamento no ECF.<br>
     * <br>
     * <b>Nota: </b>
     * Na maioria dos ECFs o Arredondamento deve ser programado, o que pode ser
     * feito com o comando ECF.MudaArredondamento
     * <br>
     * Em alguns ECFs o arredondamento é definido de acordo com o comando
     * enviado para a Venda de Item, nesse caso, o ACBr procura usar o
     * Arredondamento sempre que possível.
     * <br>
     * Após o convênio do ICMS 56/94 o arredondamento não é mais permitido,
     * portanto todos os novos ECFs apenas Truncam o Total por Item.
     *
     * @return
     * @throws ACBrECFException
     */
    public boolean isArredonda() throws ACBrECFException {
        return comandoECF("Arredonda").equalsIgnoreCase("true");
    }

    /**
     * Retorna se a ECF tem MFD( Memória Fita Detalhe).
     *
     * @return
     * @throws ACBrECFException
     */
    public boolean isMFD() throws ACBrECFException {
        return comandoECF("MFD").equalsIgnoreCase("true");
    }

    /**
     * Retorna se a ECF possui impressão Térmica.
     *
     * @return @throws ACBrECFException
     */
    public boolean isTermica() throws ACBrECFException {
        return comandoECF("Termica").equalsIgnoreCase("true");
    }

    /**
     * Retorna se a ECF Identifica Consumidor no rodapé do cupom.
     *
     * @return
     * @throws ACBrECFException
     */
    public boolean isIdentificaConsumidorRodape() throws ACBrECFException {
        return comandoECF("IdentificaConsumidorRodape").equalsIgnoreCase("true");
    }

    /**
     * Retorna se ECF permite desconto em ISSQN.
     *
     * @return
     * @throws ACBrECFException
     */
    public boolean isParamDescontoISSQN() throws ACBrECFException {
        return comandoECF("ParamDescontoISSQN").equalsIgnoreCase("true");
    }
}
