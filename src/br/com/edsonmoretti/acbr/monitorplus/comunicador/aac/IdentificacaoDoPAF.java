/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.aac;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.TextUtils;
import java.io.File;

/**
 *
 * @author Edson
 */
public class IdentificacaoDoPAF {

    private final String tipoDeRegistro = "N2";
    private String laudoDoPafEcf;
    private String nomeDoPafEcf;
    private String versaoDoPafEcf;
    private String versaoDaEr;
    private File principalExecutavel;

    public String getLaudoDoPafEcf() {
        return laudoDoPafEcf;
    }

    public void setLaudoDoPafEcf(String laudoDoPafEcf) {
        this.laudoDoPafEcf = laudoDoPafEcf;
    }

    public String getNomeDoPafEcf() {
        return nomeDoPafEcf;
    }

    public void setNomeDoPafEcf(String nomeDoPafEcf) {
        this.nomeDoPafEcf = nomeDoPafEcf;
    }

    public String getVersaoDoPafEcf() {
        return versaoDoPafEcf;
    }

    public void setVersaoDoPafEcf(String versaoDoPafEcf) {
        this.versaoDoPafEcf = versaoDoPafEcf;
    }

    public String getTipoDeRegistro() {
        return tipoDeRegistro;
    }

    public File getPrincipalExecutavel() {
        return principalExecutavel;
    }

    public void setPrincipalExecutavel(File principalExecutavel) {
        this.principalExecutavel = principalExecutavel;
    }

    public String getVersaoDaEr() {
        return versaoDaEr;
    }

    public void setVersaoDaEr(String versaoDaEr) {
        this.versaoDaEr = versaoDaEr;
    }

    @Override
    public String toString() {
        return TextUtils.formatoACBrX(tipoDeRegistro, 2)
                + TextUtils.formatoACBrX(laudoDoPafEcf, 10)
                + TextUtils.formatoACBrX(nomeDoPafEcf, 50)
                + TextUtils.formatoACBrX(versaoDoPafEcf, 10);
    }

}
