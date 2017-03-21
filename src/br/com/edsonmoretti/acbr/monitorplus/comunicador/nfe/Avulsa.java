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
public class Avulsa {

    private String CNPJ;
    private String xOrgao;
    private String matr;
    private String xAgente;
    private String fone;
    private String UF;
    private String nDAR;
    private String dEmi;
    private String vDAR;
    private String repEmi;
    private String dPag;

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

    public Avulsa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public void setxOrgao(String xOrgao) {
        this.xOrgao = xOrgao;
    }

    public void setMatr(String matr) {
        this.matr = matr;
    }

    public void setxAgente(String xAgente) {
        this.xAgente = xAgente;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public void setnDAR(String nDAR) {
        this.nDAR = nDAR;
    }

    public void setdEmi(String dEmi) {
        this.dEmi = dEmi;
    }

    public void setvDAR(String vDAR) {
        this.vDAR = vDAR;
    }

    public void setRepEmi(String repEmi) {
        this.repEmi = repEmi;
    }

    public void setdPag(String dPag) {
        this.dPag = dPag;
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
