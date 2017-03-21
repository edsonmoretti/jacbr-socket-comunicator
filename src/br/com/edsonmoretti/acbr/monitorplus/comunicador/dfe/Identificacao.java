/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrUtils;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.enun.ModeloDFe;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.enun.cUF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.enun.finNFe;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.enun.idDest;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.enun.indFinal;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.enun.indPres;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.enun.procEmi;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.enun.tpEmis;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.enun.tpImp;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.enun.tpNF;
import java.util.Date;

/**
 * @author Edson Moretti
 * @author DANIEL
 */
public class Identificacao {

    private cUF cUF;
    private String cNF;
    private String natOp;
    private int indPag;
    private ModeloDFe mod;
    private int serie;
    private int nNF;
    private Date dhEmi;
    private Date dhSaiEnt;
    private tpNF tpNF;
    /*
    Identificador de local de destino da operação
     */
    private idDest idDest;
    private String cMunFG;
    private tpImp tpImp;
    private tpEmis tpEmis;
    private finNFe finNFe;
    private indFinal indFinal;
    private indPres indPres;
    private procEmi procEmi;
    private String verProc;
    private Date dhCont;
    private String xJust;

    public Identificacao(cUF cUF, String cNF, String natOp, int indPag, ModeloDFe mod, int serie, int nNF, Date dhEmi, Date dhSaiEnt, tpNF tpNF, idDest idDest, String cMunFG, tpImp tpImp, tpEmis tpEmis, finNFe finNFe, indFinal indFinal, indPres indPres, procEmi procEmi, String verProc, Date dhCont, String xJust) {
        this.cUF = cUF;
        this.cNF = cNF;
        this.natOp = natOp;
        this.indPag = indPag;
        this.mod = mod;
        this.serie = serie;
        this.nNF = nNF;
        this.dhEmi = dhEmi;
        this.dhSaiEnt = dhSaiEnt;
        this.tpNF = tpNF;
        this.idDest = idDest;
        this.cMunFG = cMunFG;
        this.tpImp = tpImp;
        this.tpEmis = tpEmis;
        this.finNFe = finNFe;
        this.indFinal = indFinal;
        this.indPres = indPres;
        this.procEmi = procEmi;
        this.verProc = verProc;
        this.dhCont = dhCont;
        this.xJust = xJust;
    }

    public Identificacao() {
    }

    public cUF getcUF() {
        return cUF;
    }

    public void setcUF(cUF cUF) {
        this.cUF = cUF;
    }

    public String getcNF() {
        return cNF;
    }

    public void setcNF(String cNF) {
        this.cNF = cNF;
    }

    public String getNatOp() {
        return natOp;
    }

    public void setNatOp(String natOp) {
        this.natOp = natOp;
    }

    public int getIndPag() {
        return indPag;
    }

    public void setIndPag(int indPag) {
        this.indPag = indPag;
    }

    public ModeloDFe getMod() {
        return mod;
    }

    public void setMod(ModeloDFe mod) {
        this.mod = mod;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public int getnNF() {
        return nNF;
    }

    public void setnNF(int nNF) {
        this.nNF = nNF;
    }

    public Date getDhEmi() {
        return dhEmi;
    }

    public void setDhEmi(Date dhEmi) {
        this.dhEmi = dhEmi;
    }

    public Date getDhSaiEnt() {
        return dhSaiEnt;
    }

    public void setDhSaiEnt(Date dhSaiEnt) {
        this.dhSaiEnt = dhSaiEnt;
    }

    public tpNF getTpNF() {
        return tpNF;
    }

    public void setTpNF(tpNF tpNF) {
        this.tpNF = tpNF;
    }

    public idDest getIdDest() {
        return idDest;
    }

    public void setIdDest(idDest idDest) {
        this.idDest = idDest;
    }

    public String getcMunFG() {
        return cMunFG;
    }

    public void setcMunFG(String cMunFG) {
        this.cMunFG = cMunFG;
    }

    public tpImp getTpImp() {
        return tpImp;
    }

    public void setTpImp(tpImp tpImp) {
        this.tpImp = tpImp;
    }

    public tpEmis getTpEmis() {
        return tpEmis;
    }

    public void setTpEmis(tpEmis tpEmis) {
        this.tpEmis = tpEmis;
    }

    public finNFe getFinNFe() {
        return finNFe;
    }

    public void setFinNFe(finNFe finNFe) {
        this.finNFe = finNFe;
    }

    public indFinal getIndFinal() {
        return indFinal;
    }

    public void setIndFinal(indFinal indFinal) {
        this.indFinal = indFinal;
    }

    public indPres getIndPres() {
        return indPres;
    }

    public void setIndPres(indPres indPres) {
        this.indPres = indPres;
    }

    public procEmi getProcEmi() {
        return procEmi;
    }

    public void setProcEmi(procEmi procEmi) {
        this.procEmi = procEmi;
    }

    public String getVerProc() {
        return verProc;
    }

    public void setVerProc(String verProc) {
        this.verProc = verProc;
    }

    public Date getDhCont() {
        return dhCont;
    }

    public void setDhCont(Date dhCont) {
        this.dhCont = dhCont;
    }

    public String getxJust() {
        return xJust;
    }

    public void setxJust(String xJust) {
        this.xJust = xJust;
    }

    @Override
    public String toString() {
        return "[Identificacao]\n"
                + "cUF=" + (cUF == null ? "" : cUF) + "\n"
                + "cNF=" + cNF + "\n"
                + "natOp=" + natOp + "\n"
                + "indPag=" + indPag + "\n"
                + "mod=" + mod + "\n"
                + "serie=" + serie + "\n"
                + "nNF=" + nNF + "\n"
                + "dhEmi=" + ACBrUtils.formatDataHora(dhEmi) + "\n"
                + "dhSaiEnt=" + ACBrUtils.formatDataHora(dhSaiEnt) + "\n"
                + "tpNF=" + tpNF + "\n"
                + "idDest=" + idDest + "\n"
                + "cMunFG=" + cMunFG + "\n"
                + "tpImp=" + tpImp + "\n"
                + "tpEmis=" + tpEmis + "\n"
                + "finNFe=" + finNFe + "\n"
                + "indFinal=" + indFinal + "\n"
                + "indPres=" + indPres + "\n"
                + "procEmi=" + procEmi + "\n"
                + "verProc=" + verProc + "\n"
                + "dhCont=" + ACBrUtils.formatDataHora(dhCont) + "\n"
                + "xJust=" + (xJust == null ? "" : xJust) + "\n";
    }
}
