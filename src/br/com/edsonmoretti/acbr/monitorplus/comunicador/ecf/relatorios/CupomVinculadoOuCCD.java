package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.relatorios;

import static br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF.comandoECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import java.math.BigDecimal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edson
 */
public class CupomVinculadoOuCCD {

    /**
     * - Verifica se existe algum relatório Gerencial ou Vinculado aberto, se
     * for o caso, fecha-o.
     * <br>
     * - Carrega as tabelas de Formas de Pagamento e Comprovantes não Fiscais na
     * memória.
     * <br>
     * - Deve ser chamado apenas no inicio da aplicação
     *
     * @exception ACBrECFException
     */
    public void preparaTEF() throws ACBrECFException {
        comandoECF("PreparaTEF");
    }

    /**
     * Emite o Cupom vinculado conforme os dados que foram informados nos
     * parâmetros. A emissão é automaticamente encerrada 2 minutos após abertura
     * (Tempo máximo de emissão).<br>
     **<b>Nota:</b> Para imprimir um Cupom Vinculado você deve ter informaçoes
     * dos Pagamentos Efetuados no último Cupom Fiscal.
     *
     * @param COO Número de COO do cupom anterior. (Necessário documento
     * anterior seja cupom fiscal)
     *
     * @param codFormaPagto Código da forma de pagamento utilizada no cupom
     * anterior.(Permite Vinculado)
     *
     * @param valor Valor a vincular no cupom anterior.
     * @exception ACBrECFException
     */
    public void abreCupomVinculado(String COO, String codFormaPagto, BigDecimal valor) throws ACBrECFException {
        abreCupomVinculado(COO, codFormaPagto, valor.toString());
    }

    /**
     * Emite o Cupom vinculado conforme os dados que foram informados nos
     * parâmetros. A emissão é automaticamente encerrada 2 minutos após abertura
     * (Tempo máximo de emissão).<br>
     **<b>Nota:</b> Para imprimir um Cupom Vinculado você deve ter informaçoes
     * dos Pagamentos Efetuados no último Cupom Fiscal.
     *
     * @param COO Número de COO do cupom anterior. (Necessário documento
     * anterior seja cupom fiscal)
     *
     * @param codFormaPagto Código da forma de pagamento utilizada no cupom
     * anterior.(Permite Vinculado)
     *
     * @param valor Valor a vincular no cupom anterior.
     * @exception ACBrECFException
     */
    public void abreCupomVinculado(String COO, String codFormaPagto, String valor) throws ACBrECFException {
        abreCupomVinculado(COO, codFormaPagto, "", valor);
    }

    /**
     * Emite o Cupom vinculado conforme os dados que foram informados nos
     * parâmetros. A emissão é automaticamente encerrada 2 minutos após abertura
     * (Tempo máximo de emissão).<br>
     * <b>Nota:</b> Para imprimir um Cupom Vinculado você deve ter informaçoes
     * dos Pagamentos Efetuados no último Cupom Fiscal.
     *
     * @param COO Número de COO do cupom anterior. (Necessário documento
     * anterior seja cupom fiscal)
     *
     * @param codFormaPagto Código da forma de pagamento utilizada no cupom
     * anterior.(Permite Vinculado)
     *
     * @param codComprovanteNaoFiscal Se necessário, informe o Código do
     * Comprovante Não Fiscal.
     *
     * @param valor Valor a vincular no cupom anterior.
     * @exception ACBrECFException
     *
     */
    public void abreCupomVinculado(String COO, String codFormaPagto, String codComprovanteNaoFiscal, BigDecimal valor) throws ACBrECFException {
        if (codComprovanteNaoFiscal.isEmpty()) {
            comandoECF("AbreCupomVinculado(" + COO + "," + codFormaPagto + "," + valor + ")");
        } else {
            comandoECF("AbreCupomVinculado(" + COO + "," + codFormaPagto + "," + codComprovanteNaoFiscal + "," + valor + ")");
        }
    }

    /**
     * Emite o Cupom vinculado conforme os dados que foram informados nos
     * parâmetros. A emissão é automaticamente encerrada 2 minutos após abertura
     * (Tempo máximo de emissão).<br>
     * <b>Nota:</b> Para imprimir um Cupom Vinculado você deve ter informaçoes
     * dos Pagamentos Efetuados no último Cupom Fiscal.
     *
     * @param COO Número de COO do cupom anterior. (Necessário documento
     * anterior seja cupom fiscal)
     *
     * @param codFormaPagto Código da forma de pagamento utilizada no cupom
     * anterior.(Permite Vinculado)
     *
     * @param codComprovanteNaoFiscal Se necessário, informe o Código do
     * Comprovante Não Fiscal.
     *
     * @param valor Valor a vincular no cupom anterior.
     * @exception ACBrECFException
     *
     */
    public void abreCupomVinculado(String COO, String codFormaPagto, String codComprovanteNaoFiscal, String valor) throws ACBrECFException {
        if (codComprovanteNaoFiscal.isEmpty()) {
            comandoECF("AbreCupomVinculado(" + COO + ",\"" + codFormaPagto + "\"," + valor + ")");
        } else {
            comandoECF("AbreCupomVinculado(" + COO + "," + codFormaPagto + "," + codComprovanteNaoFiscal + "," + valor + ")");
        }
    }

    /**
     * Semelhante ao comando ECF.AbreCupomVinculado. A diferença é que este
     * comando realiza a impressão do cupom vinculado realizando o fechamento
     * sem utilizar o tempo de espera do ECF.<br>
     * Nota: Não permite imprimir linhas no cupom vinculado.
     *
     * @param COO
     * @param codFormaPagto
     * @param valor
     * @throws ACBrECFException
     */
    public void cupomVinculado(String COO, String codFormaPagto, String valor) throws ACBrECFException {
        comandoECF("CupomVinculado( " + COO + ", " + codFormaPagto + ", " + valor + " )");
    }
    /**
     * Semelhante ao comando ECF.AbreCupomVinculado. A diferença é que este
     * comando realiza a impressão do cupom vinculado realizando o fechamento
     * sem utilizar o tempo de espera do ECF.<br>
     * Nota: Não permite imprimir linhas no cupom vinculado.
     *
     * @param COO
     * @param codFormaPagto
     * @param valor
     * @throws ACBrECFException
     */
    public void cupomVinculado(String COO, String codFormaPagto, BigDecimal valor) throws ACBrECFException {
        comandoECF("CupomVinculado( " + COO + ", " + codFormaPagto + ", " + valor + " )");
    }

    /**
     * Semelhante ao comando ECF.AbreCupomVinculado. A diferença é que este
     * comando realiza a impressão do cupom vinculado realizando o fechamento
     * sem utilizar o tempo de espera do ECF.<br>
     * Nota: Não permite imprimir linhas no cupom vinculado.
     *
     * @param COO
     * @param codFormaPagto
     * @param codComprovanteNaoFsical
     * @param valor
     * @throws ACBrECFException
     */
    public void cupomVinculado(String COO, String codFormaPagto, String codComprovanteNaoFsical, BigDecimal valor) throws ACBrECFException {
        comandoECF("CupomVinculado( " + COO + ", " + codFormaPagto + ", " + codComprovanteNaoFsical + ", " + valor + " )");
    }

    /**
     * Imprimi no final do cupom vinculado o texto informado no parâmetro. <br>
     * Nota: A impressão só é realizada com o cupom vinculado em estado aberto,
     * portanto depende do comando ECF.AbreCupomVinculado ser executado
     * primeiro.
     *
     *
     * @param linha Texto a ser impresso no final do cupom vinculado.
     *
     * @throws ACBrECFException
     */
    public void linhaCupomVinculado(String linha) throws ACBrECFException {
        comandoECF("LinhaCupomVinculado(\"" + linha + "\")");
    }

    /**
     * Estorna o cupom vinculado retornando a quantidade de cupons
     * estornados.Para utilizar este comando é necessário que o último documento
     * emitido seja docCCD. <br>
     * Este comando irá estornar todos os cupons vinculados para mais
     * informações veja o DOC de estornaCCD(boolean);
     *
     * @throws ACBrECFException
     */
    public void estornaCCD() throws ACBrECFException {
        estornaCCD(false);
    }

    /**
     * Estorna o cupom vinculado retornando a quantidade de cupons
     * estornados.Para utilizar este comando é necessário que o último documento
     * emitido seja docCCD. <br>
     * Se true irá estornar todos os cupons vinculados, se informado com "false"
     * será estornado apenas o último CCD.
     *
     * @param b
     * @throws ACBrECFException
     */
    public void estornaCCD(boolean b) throws ACBrECFException {
        comandoECF("");
    }

    /**
     * Imprime a segunda via do cupom vinculado.Para utilizar este comando é
     * necessário que o último documento emitido seja docCCD.<br>
     * Nota: Comando disponível apenas para Daruma.
     *
     * @throws ACBrECFException
     */
    public void segundaViaVinculado() throws ACBrECFException {
        comandoECF("SegundaViaVinculado");
    }

    /**
     * Reimprime o cupom vinculado. <br>
     * Nota: Comando disponível apenas para Daruma.
     *
     * @throws ACBrECFException
     */
    public void reimpressaoVinculado() throws ACBrECFException {
        comandoECF("ReimpressaoVinculado");
    }
}
