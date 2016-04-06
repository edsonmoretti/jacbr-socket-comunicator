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

    private final String cUF;
    private final String cNF;
    private final String natOp;
    private final String indPag;
    private final String mod;
    private final String serie;
    private final String nNF;
    private final String dhEmi;
    private final String dhSaiEnt;
    private final String tpNF;
    private final String idDest;
    private final String cMunFG;
    private final String tpImp;
    private final String tpEmis;
    private final String finNFe;
    private final String indFinal;
    private final String indPres;
    private final String procEmi;
    private final String verProc;
    private final String dhCont;
    private final String xJust;

    public Identificacao(String cUF, String cNF, String natOp, String indPag, String mod, String serie, String nNF, String dhEmi, String dhSaiEnt, String tpNF, String idDest,String cMunFG, String tpImp, String tpEmis, String finNFe, String indFinal, String indPres, String procEmi, String verProc, String dhCont, String xJust) {
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
