/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.aac;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Edson
 */
public class ECF {

    private String serieEcf;
    private String numCaixa;
    private BigDecimal grandeTotal;
    private String crzAtual;
    private String croAtual;

    public String getSerieEcf() {
        return serieEcf;
    }

    public void setSerieEcf(String serieEcf) {
        this.serieEcf = serieEcf;
    }

    public String getNumCaixa() {
        return numCaixa;
    }

    public void setNumCaixa(String numCaixa) {
        this.numCaixa = numCaixa;
    }

    /**
     * Mesmo que getTotalizadorGeral
     *
     * @return
     * @deprecated
     */
    public BigDecimal getGrandeTotal() {
        return grandeTotal.setScale(4, RoundingMode.HALF_DOWN);
    }

    /**
     * Mesmo que getTotalizadorGeral
     *
     * @param grandeTotal
     * @deprecated
     */
    public void setGrandeTotal(BigDecimal grandeTotal) {
        this.grandeTotal = grandeTotal;
    }

    public BigDecimal getTotalizadorGeral() {
        return (grandeTotal == null ? BigDecimal.ZERO : grandeTotal).setScale(4, RoundingMode.HALF_DOWN);
    }

    public void setTotalizadorGeral(BigDecimal grandeTotal) {
        this.grandeTotal = grandeTotal;
    }

    public String getCrzAtual() {
        return crzAtual;
    }

    public void setCrzAtual(String crzAtual) {
        this.crzAtual = crzAtual;
    }

    public String getCroAtual() {
        return croAtual;
    }

    public void setCroAtual(String croAtual) {
        this.croAtual = croAtual;
    }

}
