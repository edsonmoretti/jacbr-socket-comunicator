/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis.maparesumo;

import static br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF.comandoECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.Numeros;
import java.math.BigDecimal;

/**
 *
 * @author Edson
 */
public class TotalNaoFiscal {

    /**
     * Retorna Valor Total de Comprovantes Não Fiscal.
     *
     * @return BigDecimal ex: 60
     * @throws ACBrECFException
     */
    public BigDecimal getTotalNaoFiscal() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("TotalNaoFiscal"));
    }

    /**
     * Retorna Total de Cancelamentos Operações Não Fiscal.
     *
     * @return
     * @throws ACBrECFException
     */
    public BigDecimal getTotalCancelamentosOPNF() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("TotalCancelamentosOPNF"));
    }

    /**
     * Retorna Total de Descontos de Operações Não Fiscais
     *
     * @return BigDecimal ex: 60
     * @throws ACBrECFException
     */
    public BigDecimal getTotalDescontosOPNF() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("TotalDescontosOPNF"));
    }

    /**
     * Retorno Total de Acréscimos de Operações Não Fiscais.
     *
     * @return BigDecimal ex: 60
     * @throws ACBrECFException
     */
    public BigDecimal getTotalAcrescimosOPNF() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("TotalAcrescimosOPNF"));
    }
}
