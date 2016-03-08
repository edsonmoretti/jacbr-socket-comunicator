/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ibge;

import java.math.BigDecimal;

/**
 *
 * @author Edson Moretti - www.edsonmoretti.com.br
 */
public class Ibge {

    private String uf;
    private String codUF;
    private String municipio;
    private String codMunicipio;
    private BigDecimal areaMunicipio;

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCodUF() {
        return codUF;
    }

    public void setCodUF(String codUF) {
        this.codUF = codUF;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public BigDecimal getAreaMunicipio() {
        return areaMunicipio;
    }

    public void setAreaMunicipio(BigDecimal areaMunicipio) {
        this.areaMunicipio = areaMunicipio;
    }

}
