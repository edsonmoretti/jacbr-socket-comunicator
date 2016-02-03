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
public class TotaisISSQN {

    /**
     * Retorna Total de Cancelamentos ISSQN.
     *
     * @return
     * @throws ACBrECFException
     */
    public BigDecimal getTotalCancelamentosISSQN() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("TotalCancelamentosISSQN"));
    }

    /**
     * Retorna Total de Descontos ISSQN
     *
     * @return
     * @throws ACBrECFException
     */
    public BigDecimal getTotalDescontosISSQN() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("TotalDescontosISSQN"));
    }

    /**
     * Retorno Total de Acréscimos ISSQN.
     *
     * @return
     * @throws ACBrECFException
     */
    public BigDecimal getTotalAcrescimosISSQN() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("TotalAcrescimosISSQN"));
    }

    /**
     * Retorna Total Vendido em Substituição Tributária ISSQN.
     *
     * @return
     * @throws ACBrECFException
     */
    public BigDecimal getTotalSubstituicaoTributariaISSQN() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("TotalSubstituicaoTributariaISSQN"));
    }

    /**
     * Retorna Total Vendido Não Tributado ISSQN.
     *
     * @return
     * @throws ACBrECFException
     */
    public BigDecimal getTotalNaoTributadoISSQN() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("TotalNaoTributadoISSQN"));
    }

    /**
     * Retorna Total Vendido Isento ISSQN.
     *
     * @return
     * @throws ACBrECFException
     */
    public BigDecimal getTotalIsencaoISSQN() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("TotalIsencaoISSQN"));
    }
}
