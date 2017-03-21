/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.nfe;

/**
 *
 * @author DANIEL
 */
public class Identificacao {

    private String cUF;
    private String cNF;
    private String natOp;
    private String indPag;
    private String mod;
    private String serie;
    private String nNF;
    private String dhEmi;
    private String dhSaiEnt;
    private String tpNF;
    private String idDest;
    private String cMunFG;
    private String tpImp;
    private String tpEmis;
    private String finNFe;
    private String indFinal;
    private String indPres;
    private String procEmi;
    private String verProc;
    private String dhCont;
    private String xJust;

    public Identificacao(String cUF, String cNF, String natOp, String indPag, String mod, String serie, String nNF, String dhEmi, String dhSaiEnt, String tpNF, String idDest, String cMunFG, String tpImp, String tpEmis, String finNFe, String indFinal, String indPres, String procEmi, String verProc, String dhCont, String xJust) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getcUF() {
        return cUF;
    }

    public void setcUF(String cUF) {
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

    public String getIndPag() {
        return indPag;
    }

    public void setIndPag(String indPag) {
        this.indPag = indPag;
    }

    public String getMod() {
        return mod;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getnNF() {
        return nNF;
    }

    public void setnNF(String nNF) {
        this.nNF = nNF;
    }

    public String getDhEmi() {
        return dhEmi;
    }

    public void setDhEmi(String dhEmi) {
        this.dhEmi = dhEmi;
    }

    public String getDhSaiEnt() {
        return dhSaiEnt;
    }

    public void setDhSaiEnt(String dhSaiEnt) {
        this.dhSaiEnt = dhSaiEnt;
    }

    public String getTpNF() {
        return tpNF;
    }

    public void setTpNF(String tpNF) {
        this.tpNF = tpNF;
    }

    public String getIdDest() {
        return idDest;
    }

    public void setIdDest(String idDest) {
        this.idDest = idDest;
    }

    public String getcMunFG() {
        return cMunFG;
    }

    public void setcMunFG(String cMunFG) {
        this.cMunFG = cMunFG;
    }

    public String getTpImp() {
        return tpImp;
    }

    public void setTpImp(String tpImp) {
        this.tpImp = tpImp;
    }

    public String getTpEmis() {
        return tpEmis;
    }

    public void setTpEmis(String tpEmis) {
        this.tpEmis = tpEmis;
    }

    public String getFinNFe() {
        return finNFe;
    }

    public void setFinNFe(String finNFe) {
        this.finNFe = finNFe;
    }

    public String getIndFinal() {
        return indFinal;
    }

    public void setIndFinal(String indFinal) {
        this.indFinal = indFinal;
    }

    public String getIndPres() {
        return indPres;
    }

    public void setIndPres(String indPres) {
        this.indPres = indPres;
    }

    public String getProcEmi() {
        return procEmi;
    }

    public void setProcEmi(String procEmi) {
        this.procEmi = procEmi;
    }

    public String getVerProc() {
        return verProc;
    }

    public void setVerProc(String verProc) {
        this.verProc = verProc;
    }

    public String getDhCont() {
        return dhCont;
    }

    public void setDhCont(String dhCont) {
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
                + "cUF=" + cUF + "\n"
                + "cNF=" + cNF + "\n"
                + "natOp=" + natOp + "\n"
                + "indPag=" + indPag + "\n"
                + "mod=" + mod + "\n"
                + "serie=" + serie + "\n"
                + "nNF=" + nNF + "\n"
                + "dhEmi=" + dhEmi + "\n"
                + "dhSaiEnt=" + dhSaiEnt + "\n"
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
                + "dhCont=" + dhCont + "\n"
                + "xJust=" + xJust + "\n";
    }

}
