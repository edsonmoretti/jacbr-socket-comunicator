/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.produto;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.ListVO;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.MembroList;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.produto.di.LADI;

/**
 *
 * @author DANIEL
 */
public class DI extends MembroList {

    private final String nDi;
    private final String dDi;
    private final String xLocDesemb;
    private final String UFDesemb;
    private final String dDesemb;
    private final String tpViaTransp;
    private final String vAFRMM;
    private final String tpIntermedio;
    private final String CNPJ;
    private final String UFTerceiro;
    private final String cExportador;
    private final ListVO<LADI> list_LADI;

    public DI(String nDi, String dDi, String xLocDesemb, String UFDesemb, String dDesemb, String tpViaTransp, String vAFRMM, String tpIntermedio, String CNPJ, String UFTerceiro, String cExportador) {
        this.nDi = nDi;
        this.dDi = dDi;
        this.xLocDesemb = xLocDesemb;
        this.UFDesemb = UFDesemb;
        this.dDesemb = dDesemb;
        this.tpViaTransp = tpViaTransp;
        this.vAFRMM = vAFRMM;
        this.tpIntermedio = tpIntermedio;
        this.CNPJ = CNPJ;
        this.UFTerceiro = UFTerceiro;
        this.cExportador = cExportador;
        this.list_LADI = new ListVO<>();
    }

    public String getnDi() {
        return nDi;
    }

    public String getdDi() {
        return dDi;
    }

    public String getxLocDesemb() {
        return xLocDesemb;
    }

    public String getUFDesemb() {
        return UFDesemb;
    }

    public String getdDesemb() {
        return dDesemb;
    }

    public String getTpViaTransp() {
        return tpViaTransp;
    }

    public String getvAFRMM() {
        return vAFRMM;
    }

    public String getTpIntermedio() {
        return tpIntermedio;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public String getUFTerceiro() {
        return UFTerceiro;
    }

    public String getcExportador() {
        return cExportador;
    }

    /**
     * Grupo de informações da Adição da DI - Declaração de Importação - LADI
     *
     * @param indice
     * @return LADI
     */
    public LADI getLADI(int indice) {
        return list_LADI.get(indice);
    }

    public DI addLADI(LADI LADI) {
        LADI.setInd_PAI(this.getInd() + this.getInd());
        list_LADI.add(LADI);
        return this;
    }

    @Override
    public String toString() {
        return "[DI]\n"
                + "nDi=" + nDi + "\n"
                + "dDi=" + dDi + "\n"
                + "xLocDesemb=" + xLocDesemb + "\n"
                + "UFDesemb=" + UFDesemb + "\n"
                + "dDesemb=" + dDesemb + "\n"
                + "tpViaTransp=" + tpViaTransp + "\n"
                + "vAFRMM=" + vAFRMM + "\n"
                + "tpIntermedio=" + tpIntermedio + "\n"
                + "CNPJ=" + CNPJ + "\n"
                + "UFTerceiro=" + UFTerceiro + "\n"
                + "cExportador=" + cExportador + "\n"
                + list_LADI.toString();
    }

}
