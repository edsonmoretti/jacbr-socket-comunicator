/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.aac;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrUtils;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.TextUtils;

/**
 *
 * @author Edson
 */
public class EmpresaDesenvolvedora {

    private final String tipoDeRegistro = "N1";
    private String cnpj;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
    private String razaoSocial;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getTipoDeRegistro() {
        return tipoDeRegistro;
    }

    @Override
    public String toString() {
        return TextUtils.formatoACBrX(tipoDeRegistro, 2)
                + TextUtils.formatoACBrN(cnpj, 14)
                + TextUtils.formatoACBrX(inscricaoEstadual, 14)
                + TextUtils.formatoACBrX(inscricaoMunicipal, 14)
                + TextUtils.formatoACBrX(razaoSocial, 50);
    }

}
