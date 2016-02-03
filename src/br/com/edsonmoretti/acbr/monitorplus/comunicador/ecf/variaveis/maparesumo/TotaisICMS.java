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
public class TotaisICMS {

    /**
     * Retorna Total de Cancelamentos ICMS.
     *
     * @return
     * @throws ACBrECFException
     */
    public BigDecimal getTotalCancelamentos() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("TotalCancelamentos"));
    }

    /**
     * Retorna Total de Descontos ICMS
     *
     * @return
     * @throws ACBrECFException
     */
    public BigDecimal getTotalDescontos() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("TotalDescontos"));
    }

    /**
     * Retorno Total de Acréscimos ICMS.
     *
     * @return
     * @throws ACBrECFException
     */
    public BigDecimal getTotalAcrescimos() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("TotalAcrescimos"));
    }

    /**
     * Retorna Total Vendido em Substituição Tributária ICMS.
     *
     * @return
     * @throws ACBrECFException
     */
    public BigDecimal getTotalSubstituicaoTributaria() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("TotalSubstituicaoTributaria"));
    }

    /**
     * Retorna Total Vendido Não Tributado ICMS.
     *
     * @return
     * @throws ACBrECFException
     */
    public BigDecimal getTotalNaoTributado() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("TotalNaoTributado"));
    }

    /**
     * Retorna Total Vendido Isento ICMS.
     *
     * @return
     * @throws ACBrECFException
     */
    public BigDecimal getTotalIsencao() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("TotalIsencao"));
    }
}
