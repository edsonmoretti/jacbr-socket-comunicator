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
    //CONTADORES
    private Date dataMovimento;
    private String numSerie;
    private String numECF;
    private String numLoja;
    private String numCOOInicial;
    private String numCOO;
    private String numCRZ;
    private String numCRO;
    private String numGNF;
    private String numCCF;
    private String numCFD;
    private String numCDC;
    private String numGRG;
    private String numNFC;
    private String numGNFC;
    private String numCFC;
    private String numNCN;
    private String numCCDC;

    //Totalizadores
    private BigDecimal vendaLiquida;
    private BigDecimal vendaBruta;
    private BigDecimal grandeTotal;
    private BigDecimal totalDescontos;
    private BigDecimal totalCancelamentos;
    private BigDecimal totalAcrescimos;
    private BigDecimal totalNaoFiscal;

    private BigDecimal totalDescontosISSQN;
    private BigDecimal totalCancelamentosISSQN;
    private BigDecimal totalAcrescimosISSQN;
    private BigDecimal totalDescontosOPNF;
    private BigDecimal totalCancelamentosOPNF;
    private BigDecimal totalAcrescimosOPNF;
    private BigDecimal totalTroco;

    //Aliquotas/ICMS
    private HashMap<String, BigDecimal> totaisAliquotas;
    //Outras ICMS
    private BigDecimal totalSubstituicaoTributariaICMS;
    private BigDecimal totalNaoTributadoICMS;
    private BigDecimal totalIsencaoICMS;
    //Outras ISSQN
    private BigDecimal totalSubstituicaoTributariaISSQN;
    private BigDecimal totalNaoTributadoISSQN;
    private BigDecimal totalIsencaoISSQN;
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

    public BigDecimal getTotalSubstituicaoTributariaICMS() {
        return totalSubstituicaoTributariaICMS;
    }

    protected void setTotalSubstituicaoTributariaICMS(BigDecimal totalSubstituicaoTributariaICMS) {
        this.totalSubstituicaoTributariaICMS = totalSubstituicaoTributariaICMS;
    }

    public BigDecimal getTotalNaoTributadoICMS() {
        return totalNaoTributadoICMS;
    }

    protected void setTotalNaoTributadoICMS(BigDecimal totalNaoTributadoICMS) {
        this.totalNaoTributadoICMS = totalNaoTributadoICMS;
    }

    public BigDecimal getTotalIsencaoICMS() {
        return totalIsencaoICMS;
    }

    protected void setTotalIsencaoICMS(BigDecimal totalIsencaoICMS) {
        this.totalIsencaoICMS = totalIsencaoICMS;
    }

    public BigDecimal getTotalSubstituicaoTributariaISSQN() {
        return totalSubstituicaoTributariaISSQN;
    }

    public void setTotalSubstituicaoTributariaISSQN(BigDecimal totalSubstituicaoTributariaISSQN) {
        this.totalSubstituicaoTributariaISSQN = totalSubstituicaoTributariaISSQN;
    }

    public BigDecimal getTotalNaoTributadoISSQN() {
        return totalNaoTributadoISSQN;
    }

    public void setTotalNaoTributadoISSQN(BigDecimal totalNaoTributadoISSQN) {
        this.totalNaoTributadoISSQN = totalNaoTributadoISSQN;
    }

    public BigDecimal getTotalIsencaoISSQN() {
        return totalIsencaoISSQN;
    }

    public void setTotalIsencaoISSQN(BigDecimal totalIsencaoISSQN) {
        this.totalIsencaoISSQN = totalIsencaoISSQN;
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

    public BigDecimal getVendaLiquida() {
        return vendaLiquida;
    }

    protected void setVendaLiquida(BigDecimal vendaLiquida) {
        this.vendaLiquida = vendaLiquida;
    }
////////////////////////

    public String getNumGNF() {
        return numGNF;
    }

    protected void setNumGNF(String numGNF) {
        this.numGNF = numGNF;
    }

    public String getNumCCF() {
        return numCCF;
    }

    protected void setNumCCF(String numCCF) {
        this.numCCF = numCCF;
    }

    public String getNumCFD() {
        return numCFD;
    }

    protected void setNumCFD(String numCFD) {
        this.numCFD = numCFD;
    }

    public String getNumCDC() {
        return numCDC;
    }

    protected void setNumCDC(String numCDC) {
        this.numCDC = numCDC;
    }

    public String getNumGRG() {
        return numGRG;
    }

    protected void setNumGRG(String numGRG) {
        this.numGRG = numGRG;
    }

    public String getNumNFC() {
        return numNFC;
    }

    protected void setNumNFC(String numNFC) {
        this.numNFC = numNFC;
    }

    public String getNumGNFC() {
        return numGNFC;
    }

    protected void setNumGNFC(String numGNFC) {
        this.numGNFC = numGNFC;
    }

    public String getNumCFC() {
        return numCFC;
    }

    protected void setNumCFC(String numCFC) {
        this.numCFC = numCFC;
    }

    public String getNumNCN() {
        return numNCN;
    }

    protected void setNumNCN(String numNCN) {
        this.numNCN = numNCN;
    }

    public String getNumCCDC() {
        return numCCDC;
    }

    protected void setNumCCDC(String numCCDC) {
        this.numCCDC = numCCDC;
    }

    public BigDecimal getTotalDescontosISSQN() {
        return totalDescontosISSQN;
    }

    protected void setTotalDescontosISSQN(BigDecimal totalDescontosISSQN) {
        this.totalDescontosISSQN = totalDescontosISSQN;
    }

    public BigDecimal getTotalCancelamentosISSQN() {
        return totalCancelamentosISSQN;
    }

    protected void setTotalCancelamentosISSQN(BigDecimal totalCancelamentosISSQN) {
        this.totalCancelamentosISSQN = totalCancelamentosISSQN;
    }

    public BigDecimal getTotalAcrescimosISSQN() {
        return totalAcrescimosISSQN;
    }

    protected void setTotalAcrescimosISSQN(BigDecimal totalAcrescimosISSQN) {
        this.totalAcrescimosISSQN = totalAcrescimosISSQN;
    }

    public BigDecimal getTotalDescontosOPNF() {
        return totalDescontosOPNF;
    }

    protected void setTotalDescontosOPNF(BigDecimal totalDescontosOPNF) {
        this.totalDescontosOPNF = totalDescontosOPNF;
    }

    public BigDecimal getTotalCancelamentosOPNF() {
        return totalCancelamentosOPNF;
    }

    protected void setTotalCancelamentosOPNF(BigDecimal totalCancelamentosOPNF) {
        this.totalCancelamentosOPNF = totalCancelamentosOPNF;
    }

    public BigDecimal getTotalAcrescimosOPNF() {
        return totalAcrescimosOPNF;
    }

    protected void setTotalAcrescimosOPNF(BigDecimal totalAcrescimosOPNF) {
        this.totalAcrescimosOPNF = totalAcrescimosOPNF;
    }

    public BigDecimal getTotalTroco() {
        return totalTroco;
    }

    protected void setTotalTroco(BigDecimal totalTroco) {
        this.totalTroco = totalTroco;
    }

    @Override
    public String toString() {
        String s = "{";
        for (String string : totaisAliquotas.keySet()) {
            s += string + " = " + totaisAliquotas.get(string) + "\n";
        }
        s += "}";
        return "ReducaoZ{" + "dataMovimento=" + dataMovimento + ",\nnumSerie=" + numSerie + ",\nnumECF=" + numECF + ",\nnumLoja=" + numLoja + ",\nnumCOOInicial=" + numCOOInicial + ",\nnumCOO=" + numCOO + ",\nnumCRZ=" + numCRZ + ",\nnumCRO=" + numCRO + ",\nvendaBruta=" + vendaBruta + ",\ngrandeTotal=" + grandeTotal + ",\ntotalDescontos=" + totalDescontos + ",\ntotalCancelamentos=" + totalCancelamentos + ",\ntotalAcrescimos=" + totalAcrescimos + ",\ntotalNaoFiscal=" + totalNaoFiscal + ",\ntotaisAliquotas=" + s + ",\ntotalSubstituicaoTributaria=" + totalSubstituicaoTributariaICMS + ",\ntotalNaoTributado=" + totalNaoTributadoICMS + ",\ntotalIsencao=" + totalIsencaoICMS + ",\ntotalSangria=" + totalSangria + ",\ntotalSuprimento=" + totalSuprimento + '}';
    }
}
