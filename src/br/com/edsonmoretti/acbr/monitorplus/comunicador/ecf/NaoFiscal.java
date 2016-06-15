/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import java.math.BigDecimal;

/**
 *
 * @author Edson
 */
public class NaoFiscal {

    /**
     * Realiza a impressão completa de Comprovante Não Fiscal, conforme os dados
     * informados nos parâmetros.
     *
     * @param codCNF Código do comprovante não fiscal.
     * @param valor Valor para o comprovante não fiscal.
     * @param codFormaPagto Código da Forma de Pagamento utilizada para
     * pagamento Comprovante não Fiscal.
     * @param obs Observação será impresso no final do comprovante.
     * @throws ACBrECFException
     */
    public void naoFiscalCompleto(String codCNF, BigDecimal valor, String codFormaPagto, String obs) throws ACBrECFException {
        ACBrECF.comandoECF("NaoFiscalCompleto(" + codCNF + "," + valor + "," + codFormaPagto + "," + obs + ")");
    }

    /**
     * Realiza a impressão completa de Comprovante Não Fiscal, conforme os dados
     * informados nos parâmetros.
     *
     * @param codCNF Código do comprovante não fiscal.
     * @param valor Valor para o comprovante não fiscal.
     * @param codFormaPagto Código da Forma de Pagamento utilizada para
     * pagamento Comprovante não Fiscal.
     * @throws ACBrECFException
     */
    public void naoFiscalCompleto(String codCNF, BigDecimal valor, String codFormaPagto) throws ACBrECFException {
        naoFiscalCompleto(codCNF, valor, codFormaPagto, "");
    }

    /**
     * Emite comprovante não fiscal do tipo Sangria.
     *
     * @param valor Valor para a Sangria.
     * @param obs Observação
     * @throws ACBrECFException
     */
    public void sangria(BigDecimal valor, String obs) throws ACBrECFException {
        sangria(valor, obs, "", "");
    }

    /**
     * Emite comprovante não fiscal do tipo Sangria.
     *
     * @param valor Valor para a Sangria.
     * @param obs Observação
     * @param descricaoCNF Descrição do Comprovante não fiscal. Parâmetro pode
     * ser omitido e será considerado "SANGRIA".
     * @param descricaoFPG Descrição da Forma de Pagamento. Parâmetro pode ser
     * omitido e será considerado "DINHEIRO".
     * @throws ACBrECFException
     */
    public void sangria(BigDecimal valor, String obs, String descricaoCNF, String descricaoFPG) throws ACBrECFException {
        ACBrECF.comandoECF("Sangria(" + valor + ",\"" + obs + "\"," + descricaoCNF + "," + descricaoFPG + ")");
    }

    /**
     * Emite comprovante não fiscal do tipo Suprimento.
     *
     * @param valor Valor para a Suprimento.
     * @param obs Observação
     * @throws ACBrECFException
     */
    public void suprimento(BigDecimal valor, String obs) throws ACBrECFException {
        sangria(valor, obs, "", "");
    }

    /**
     * Emite comprovante não fiscal do tipo Suprimento.
     *
     * @param valor Valor para a Suprimento.
     * @throws ACBrECFException
     */
    public void suprimento(BigDecimal valor) throws ACBrECFException {
        sangria(valor, "", "", "");
    }

    /**
     * Emite comprovante não fiscal do tipo Suprimento.
     *
     * @param valor Valor para a Suprimento.
     * @param obs Observação
     * @param descricaoCNF Descrição do Comprovante não fiscal. Parâmetro pode
     * ser omitido e será considerado "Suprimento".
     * @param descricaoFPG Descrição da Forma de Pagamento. Parâmetro pode ser
     * omitido e será considerado "Suprimento".
     * @throws ACBrECFException
     */
    public void suprimento(BigDecimal valor, String obs, String descricaoCNF, String descricaoFPG) throws ACBrECFException {
        ACBrECF.comandoECF("Suprimento(" + valor + ",\"" + obs + "\"," + descricaoCNF + "," + descricaoFPG + ")");
    }

    /**
     * Realiza a abertura do Comprovante Não Fiscal.
     *
     * @throws ACBrECFException
     */
    public void abreNaoFiscal() throws ACBrECFException {
        abreNaoFiscal("", "", "");
    }

    /**
     * Realiza a abertura do Comprovante Não Fiscal.
     * <b>Nota:</b> Nem todos os modelos de ECF fazem uso do parâmetro
     * cCPF_CNPJ, nesse caso o Cupom será aberto, porém o número de
     * identificação do cliente não será impresso. Dica: Para identificar o
     * cliente prefira usar o Rodapé do Cupom, que permite até 8 linhas de texto
     * livre.
     *
     * @param CPF_CNPJ Se necessário, informe o CPF/CNPJ do Consumidor
     * @param nome Se necessário, informe o NOME do Consumidor
     * @param endereco Se necessário, informe o ENDEREÇO do Consumidor
     * @throws ACBrECFException
     */
    public void abreNaoFiscal(String CPF_CNPJ, String nome, String endereco) throws ACBrECFException {
        ACBrECF.comandoECF("AbreNaoFiscal(" + CPF_CNPJ + "," + nome + "," + endereco + ")");
    }

    /**
     * Registra o item Não Fiscal, conforme os dados informados nos parâmetros.
     *
     * @param codCNF Código do CNF (Comprovante Não Fiscal).
     * @param valor Valor do Comprovante não fiscal.
     * @param obs Se desejar deixar alguma Observação.
     * @throws ACBrECFException
     */
    public void registraItemNaoFiscal(String codCNF, BigDecimal valor, String obs) throws ACBrECFException {
        ACBrECF.comandoECF("RegistraItemNaoFiscal(" + codCNF + "," + valor + "," + obs + ")");
    }

    /**
     * Registra o item Não Fiscal, conforme os dados informados nos parâmetros.
     *
     * @param codCNF Código do CNF (Comprovante Não Fiscal).
     * @param valor Valor do Comprovante não fiscal.
     * @throws ACBrECFException
     */
    public void registraItemNaoFiscal(String codCNF, BigDecimal valor) throws ACBrECFException {
        registraItemNaoFiscal(codCNF, valor, "");
    }

    /**
     * Cancela o item informado no parâmetro do comprovante não fiscal .
     * <b>Nota:</b> Comando disponível apenas para Daruma.
     *
     * @param numItem Numero do Item a cancelar de acordo com a ordem de
     * impressão no Comprovante não fiscal.
     *
     * @throws ACBrECFException
     */
    public void cancelaItemNaoFiscal(int numItem) throws ACBrECFException {
        ACBrECF.comandoECF("CancelaItemNaoFiscal(" + numItem + ")");
    }

    /**
     * Subtotaliza o comprovane não fiscal.
     *
     * @throws ACBrECFException
     */
    public void subtotalizaNaoFiscal() throws ACBrECFException {
        ACBrECF.comandoECF("SubtotalizaNaoFiscal");
    }

    /**
     * Subtotaliza o comprovane não fiscal.<br>
     * Exemplos:<br>
     * ECF.SubtotalizaNaoFiscal<br>
     * ECF.SubtotalizaNaoFiscal( -1.45 ) para Desconto de R$ 1,45<br>
     * ECF.SubtotalizaNaoFiscal( 5 ) para Acréscimo de R$ 5,00<br>
     * ECF.SubtotalizaNaoFiscal( 0, "Mensagem Linha 1|Mensagem Linha 2") para
     * Sem desconto / acréscimo mas informando 2 linhas de mensagem para serem
     * impressas no rodapé.
     * <br>
     *
     * @param descontoAcrescimo Para Descontos, informe valores negativos, para
     * acréscimos valores positivos
     * @param msgRodape Informe até 8 linhas de mensagem a serem impressas no
     * rodapé do cupom. Usado apenas para o ECF DataRegis que não possui o
     * método FechaCupom, nos demais ECFs, se a mensagem for informada nesse
     * momento, ela será armazenada pelo ACBr e utilizada em FechaCupom
     * @throws ACBrECFException
     */
    public void subtotalizaNaoFiscal(BigDecimal descontoAcrescimo, String msgRodape) throws ACBrECFException {
        ACBrECF.comandoECF("SubtotalizaNaoFiscal (" + descontoAcrescimo + "," + msgRodape + ")");
    }

    /**
     * Efetua o Pagamento do Comprovante Não Fiscal.
     *
     * @param codFormaPagto - Índice da Forma de pagamento cadastrada no ECF.
     * Para conhecer todas as Formas de pagamento cadastradas e seus respectivos
     * índices, utilize o comando ECF.FormasPagamento
     * @param valor Valor pago para essa forma de pagamento.
     * @param observacao Pode ser omitido. Alguns ECFs permitem a impressão de
     * até 2 linhas de observação para cada forma de pagamento
     * @param bImprimeVinculado Pode ser omitido, nesse caso assume "False". Se
     * for informado "True" para este parâmetro, o ACBr apenas verifica se é
     * permitido imprimir Cupom Não Fiscal Vinculado para essa forma de
     * Pagamento.
     * @throws ACBrECFException
     */
    public void efetuaPagamentoNaoFiscal(String codFormaPagto, BigDecimal valor, String observacao, boolean bImprimeVinculado) throws ACBrECFException {
        ACBrECF.comandoECF("EfetuaPagamentoNaoFiscal(" + codFormaPagto + "," + valor + "," + observacao + "," + bImprimeVinculado + ")");
    }

    /**
     * Realiza o Fechamento do comprovante Não Fiscal.
     *
     * @param obs Observação no comprovante Não Fiscal, será impresso no final
     * do comprovante.
     *
     * @throws ACBrECFException
     */
    public void fechaNaoFiscal(String obs) throws ACBrECFException {
        ACBrECF.comandoECF("FechaNaoFiscal(" + obs + ")");
    }

    /**
     * Realiza o Fechamento do comprovante Não Fiscal.
     *
     * @throws ACBrECFException
     */
    public void fechaNaoFiscal() throws ACBrECFException {
        fechaNaoFiscal("");
    }

    /**
     * Cancela o Comprovante Não Fiscal atual (se estiver aberto) em qualquer
     * estágio do Cupom. Se não houver comprovante aberto, cancela o Último
     * Comprovante emitido, caso o último documento seja realmente um
     * Comprovante Não Fiscal
     *
     * @throws ACBrECFException
     */
    public void cancelaNaoFiscal() throws ACBrECFException {
        ACBrECF.comandoECF("CancelaNaoFiscal");
    }
}
