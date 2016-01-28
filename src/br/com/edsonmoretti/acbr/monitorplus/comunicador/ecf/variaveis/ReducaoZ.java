/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Edson
 */
public class ReducaoZ {
    //dados do ECF

    private Date dataMovimento;
    private String numSerie;
    private String numECF;
    private String numLoja;
    private String numCOOInicial;
    private String numCOO;
    private String numCRZ;
    private String numCRO;
    //Totalizadores
    private BigDecimal vendaBruta;
    private BigDecimal grandeTotal;
    private BigDecimal totalDescontos;
    private BigDecimal totalCancelamentos;
    private BigDecimal totalAcrescimos;
    private BigDecimal totalNaoFiscal;
    //Aliquotas
    private HashMap<String, BigDecimal> totaisAliquotas;
    //Outras ICMS
    private BigDecimal totalSubstituicaoTributaria;
    private BigDecimal totalNaoTributado;
    private BigDecimal totalIsencao;
    //Nao Fiscal
    private BigDecimal totalSangria;
    private BigDecimal totalSuprimento;

    public Date getDataMovimento() {
        return dataMovimento;
    }

    protected void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public String getNumSerie() {
        return numSerie;
    }

    protected void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getNumECF() {
        return numECF;
    }

    protected void setNumECF(String numECF) {
        this.numECF = numECF;
    }

    public String getNumLoja() {
        return numLoja;
    }

    protected void setNumLoja(String numLoja) {
        this.numLoja = numLoja;
    }

    public String getNumCOOInicial() {
        return numCOOInicial;
    }

    protected void setNumCOOInicial(String numCOOInicial) {
        this.numCOOInicial = numCOOInicial;
    }

    public String getNumCOO() {
        return numCOO;
    }

    protected void setNumCOO(String numCOO) {
        this.numCOO = numCOO;
    }

    public String getNumCRZ() {
        return numCRZ;
    }

    protected void setNumCRZ(String numCRZ) {
        this.numCRZ = numCRZ;
    }

    public String getNumCRO() {
        return numCRO;
    }

    protected void setNumCRO(String numCRO) {
        this.numCRO = numCRO;
    }

    public BigDecimal getVendaBruta() {
        return vendaBruta;
    }

    protected void setVendaBruta(BigDecimal vendaBruta) {
        this.vendaBruta = vendaBruta;
    }

    public BigDecimal getGrandeTotal() {
        return grandeTotal;
    }

    protected void setGrandeTotal(BigDecimal grandeTotal) {
        this.grandeTotal = grandeTotal;
    }

    public BigDecimal getTotalDescontos() {
        return totalDescontos;
    }

    protected void setTotalDescontos(BigDecimal totalDescontos) {
        this.totalDescontos = totalDescontos;
    }

    public BigDecimal getTotalCancelamentos() {
        return totalCancelamentos;
    }

    protected void setTotalCancelamentos(BigDecimal totalCancelamentos) {
        this.totalCancelamentos = totalCancelamentos;
    }

    public BigDecimal getTotalAcrescimos() {
        return totalAcrescimos;
    }

    protected void setTotalAcrescimos(BigDecimal totalAcrescimos) {
        this.totalAcrescimos = totalAcrescimos;
    }

    public BigDecimal getTotalNaoFiscal() {
        return totalNaoFiscal;
    }

    protected void setTotalNaoFiscal(BigDecimal totalNaoFiscal) {
        this.totalNaoFiscal = totalNaoFiscal;
    }

    public HashMap<String, BigDecimal> getTotaisAliquotas() {
        return totaisAliquotas;
    }

    protected void setTotaisAliquotas(HashMap<String, BigDecimal> totaisAliquotas) {
        this.totaisAliquotas = totaisAliquotas;
    }

    public BigDecimal getTotalSubstituicaoTributaria() {
        return totalSubstituicaoTributaria;
    }

    protected void setTotalSubstituicaoTributaria(BigDecimal totalSubstituicaoTributaria) {
        this.totalSubstituicaoTributaria = totalSubstituicaoTributaria;
    }

    public BigDecimal getTotalNaoTributado() {
        return totalNaoTributado;
    }

    protected void setTotalNaoTributado(BigDecimal totalNaoTributado) {
        this.totalNaoTributado = totalNaoTributado;
    }

    public BigDecimal getTotalIsencao() {
        return totalIsencao;
    }

    protected void setTotalIsencao(BigDecimal totalIsencao) {
        this.totalIsencao = totalIsencao;
    }

    public BigDecimal getTotalSangria() {
        return totalSangria;
    }

    protected void setTotalSangria(BigDecimal totalSangria) {
        this.totalSangria = totalSangria;
    }

    public BigDecimal getTotalSuprimento() {
        return totalSuprimento;
    }

    protected void setTotalSuprimento(BigDecimal totalSuprimento) {
        this.totalSuprimento = totalSuprimento;
    }

    @Override
    public String toString() {
        String s = "{";
        for (String string : totaisAliquotas.keySet()) {
            s += string + " = " + totaisAliquotas.get(string) + "\n";
        }
        s += "}";
        return "ReducaoZ{" + "dataMovimento=" + dataMovimento + ",\nnumSerie=" + numSerie + ",\nnumECF=" + numECF + ",\nnumLoja=" + numLoja + ",\nnumCOOInicial=" + numCOOInicial + ",\nnumCOO=" + numCOO + ",\nnumCRZ=" + numCRZ + ",\nnumCRO=" + numCRO + ",\nvendaBruta=" + vendaBruta + ",\ngrandeTotal=" + grandeTotal + ",\ntotalDescontos=" + totalDescontos + ",\ntotalCancelamentos=" + totalCancelamentos + ",\ntotalAcrescimos=" + totalAcrescimos + ",\ntotalNaoFiscal=" + totalNaoFiscal + ",\ntotaisAliquotas=" + s + ",\ntotalSubstituicaoTributaria=" + totalSubstituicaoTributaria + ",\ntotalNaoTributado=" + totalNaoTributado + ",\ntotalIsencao=" + totalIsencao + ",\ntotalSangria=" + totalSangria + ",\ntotalSuprimento=" + totalSuprimento + '}';
    }
}
