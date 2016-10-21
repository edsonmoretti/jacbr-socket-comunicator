/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.blocox.reducaoz;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrUtils;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.Numeros;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Override
    public String toString() {
        String xmlExemplo = "";
        InputStream in = getClass().getResourceAsStream("/br/com/edsonmoretti/acbr/monitorplus/comunicador/ecf/paf/blocox/EnvioReducaoZ.xml");
        try {
            Reader fr = new InputStreamReader(in, "utf-8");
            while (fr.ready()) {
                xmlExemplo += String.valueOf(((char) fr.read()));
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DadosDaReducaoZ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DadosDaReducaoZ.class.getName()).log(Level.SEVERE, null, ex);
        }
        String xml = xmlExemplo.replace("_NumeroFabricacao_", numeroFabricacaoECF)
                .replace("_Tipo_", tipoECF)
                .replace("_Marca_", marcaECF)
                .replace("_Modelo_", modeloECF)
                .replace("_Versao_", versaoECF)
                .replace("_Caixa_", caixa)
                .replace("_DataReferencia_", ACBrUtils.formatDataDB(dataReferencia))
                .replace("_CRZ_", CRZ)
                .replace("_COO_", COO)
                .replace("_CRO_", CRO)
                .replace("_VendaBrutaDiaria_", Numeros.fmtBig(vendaBrutaDiaria, 2))
                .replace("_GT_", Numeros.fmtBig(GT, 2))
                .replace("_TotalizadoresParciais_", totalizadoresParciais.toString());
        return xml;
    }
    /*<Ecf>
            <NumeroFabricacao>_NumeroFabricacao_</NumeroFabricacao>
            <Tipo>_Tipo_</Tipo>
            <Marca>_Marca_</Marca>
            <Modelo>_Modelo_</Modelo>
            <Versao>_Versao_</Versao>
            <Caixa>_Caixa_</Caixa>
            <DadosReducaoZ>
                <DataReferencia>_DataReferencia_</DataReferencia>
                <CRZ>_CRZ_</CRZ>
                <COO>_COO_</COO>
                <CRO>_CRO_</CRO>
                <VendaBrutaDiaria>_VendaBrutaDiaria_</VendaBrutaDiaria>
                <GT>_GT_</GT>
                _TotalizadoresParciais_
            </DadosReducaoZ>
        </Ecf>*/
}
