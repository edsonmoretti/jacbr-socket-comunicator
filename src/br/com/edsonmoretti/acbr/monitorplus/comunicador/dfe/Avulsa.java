/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe;

/**
 *
 * @author DANIEL
 */
public class Avulsa {

    private final String CNPJ;
    private final String xOrgao;
    private final String matr;
    private final String xAgente;
    private final String fone;
    private final String UF;
    private final String nDAR;
    private final String dEmi;
    private final String vDAR;
    private final String repEmi;
    private final String dPag;

    public Avulsa(String CNPJ, String xOrgao, String matr, String xAgente, String fone, String UF, String nDAR, String dEmi, String vDAR, String repEmi, String dPag) {
        this.CNPJ = CNPJ;
        this.xOrgao = xOrgao;
        this.matr = matr;
        this.xAgente = xAgente;
        this.fone = fone;
        this.UF = UF;
        this.nDAR = nDAR;
        this.dEmi = dEmi;
        this.vDAR = vDAR;
        this.repEmi = repEmi;
        this.dPag = dPag;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public String getxOrgao() {
        return xOrgao;
    }

    public String getMatr() {
        return matr;
    }

    public String getxAgente() {
        return xAgente;
    }

    public String getFone() {
        return fone;
    }

    public String getUF() {
        return UF;
    }

    public String getnDAR() {
        return nDAR;
    }

    public String getdEmi() {
        return dEmi;
    }

    public String getvDAR() {
        return vDAR;
    }

    public String getRepEmi() {
        return repEmi;
    }

    public String getdPag() {
        return dPag;
    }

    @Override
    public String toString() {
        return "[Avulsa]\n"
                + "CNPJ=" + CNPJ + "\n"
                + "xOrgao=" + xOrgao + "\n"
                + "matr=" + matr + "\n"
                + "xAgente=" + xAgente + "\n"
                + "fone=" + fone + "\n"
                + "UF=" + UF + "\n"
                + "nDAR=" + nDAR + "\n"
                + "dEmi=" + dEmi + "\n"
                + "vDAR=" + vDAR + "\n"
                + "repEmi=" + repEmi + "\n"
                + "dPag=" + dPag + "\n";
    }

}
