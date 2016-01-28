package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.relatorios;

import static br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.ACBrECF.comandoECF;
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
}
