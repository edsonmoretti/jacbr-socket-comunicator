/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.cupomfiscal;

import static br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.ACBrECF.comandoECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.Numeros;
import java.math.BigDecimal;

/**
 *
 * @author Edson
 *
 * Variáveis do Cupom Fiscal
 */
public class Variaveis {

    /**
     * Retorna o Número do cupom.
     *
     * @return String com num do Cupom. EX: 002482
     * @throws ACBrECFException
     */
    public String numCupom() throws ACBrECFException {
        return comandoECF("NumCupom").trim();
    }

    /**
     * Retorna o Sub-total do cupom atual (em aberto). Considerando a soma dos
     * Itens Vendidos, o Desconto / Acréscimo concedido em ECF.SubtotalizaCupom
     * e os pagamentos já efetuados com ECF.EfetuaPagamento
     *
     * @return BigDecimal com valor do SubTotal
     * @throws ACBrECFException
     */
    public BigDecimal subTotal() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("SubTotal").trim());
    }

    /**
     * Retorna o Total de pagamentos já efetuados quando o ECF está no estado
     * estPagamento
     *
     * @return BigDecimal com Valores já pagos.
     * @throws ACBrECFException
     */
    public BigDecimal totalPago() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("TotalPago").trim());
    }

    /**
     * Retorna o número do último item.
     *
     * @return int Com Numéro do último item, ex: 3
     * @throws ACBrECFException
     */
    public int numUltItem() throws ACBrECFException {
        return Integer.parseInt(comandoECF("NumUltItem").trim());
    }
}
