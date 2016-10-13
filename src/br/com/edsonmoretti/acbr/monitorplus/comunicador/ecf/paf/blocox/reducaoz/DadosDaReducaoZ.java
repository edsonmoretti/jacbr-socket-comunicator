/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.blocox.reducaoz;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Edson
 */
public class DadosDaReducaoZ {

    private String numeroFabricacaoECF;
    private String tipoECF;
    private String marcaECF;
    private String modeloECF;
    private String versaoECF;
    private String caixa;
    private Date dataReferencia;
    private String CRZ;
    private String COO;
    private String CRO;
    private BigDecimal vendaBrutaDiaria;
    private BigDecimal GT;
    private final TotalizadoresParciais totalizadoresParciais = new TotalizadoresParciais();

    public String getNumeroFabricacaoECF() {
        return numeroFabricacaoECF;
    }

    public void setNumeroFabricacaoECF(String numeroFabricacaoECF) {
        this.numeroFabricacaoECF = numeroFabricacaoECF;
    }

    public String getTipoECF() {
        return tipoECF;
    }

    public void setTipoECF(String tipoECF) {
        this.tipoECF = tipoECF;
    }

    public String getMarcaECF() {
        return marcaECF;
    }

    public void setMarcaECF(String marcaECF) {
        this.marcaECF = marcaECF;
    }

    public String getModeloECF() {
        return modeloECF;
    }

    public void setModeloECF(String modeloECF) {
        this.modeloECF = modeloECF;
    }

    public String getVersaoECF() {
        return versaoECF;
    }

    public void setVersaoECF(String versaoECF) {
        this.versaoECF = versaoECF;
    }

    public String getCaixa() {
        return caixa;
    }

    public void setCaixa(String caixa) {
        this.caixa = caixa;
    }

    public Date getDataReferencia() {
        return dataReferencia;
    }

    public void setDataReferencia(Date dataReferencia) {
        this.dataReferencia = dataReferencia;
    }

    public String getCRZ() {
        return CRZ;
    }

    public void setCRZ(String CRZ) {
        this.CRZ = CRZ;
    }

    public String getCOO() {
        return COO;
    }

    public void setCOO(String COO) {
        this.COO = COO;
    }

    public String getCRO() {
        return CRO;
    }

    public void setCRO(String CRO) {
        this.CRO = CRO;
    }

    public BigDecimal getVendaBrutaDiaria() {
        return vendaBrutaDiaria;
    }

    public void setVendaBrutaDiaria(BigDecimal vendaBrutaDiaria) {
        this.vendaBrutaDiaria = vendaBrutaDiaria;
    }

    public BigDecimal getGT() {
        return GT;
    }

    public void setGT(BigDecimal GT) {
        this.GT = GT;
    }

    public TotalizadoresParciais getTotalizadoresParciais() {
        return totalizadoresParciais;
    }
}
