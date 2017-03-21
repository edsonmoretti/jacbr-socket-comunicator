/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.enun.indIEDest;

/**
 *
 * @author DANIEL
 */
public class Destinatario {

    private String idEstrangeiro;
    private String CNPJCPF;
    private String xNome;
    private indIEDest indIEDest;
    private String IE;
    private String ISUF;
    private String Email;
    private String xLgr;
    private String nro;
    private String xCpl;
    private String xBairro;
    private String cMun;
    private String xMun;
    private String UF;
    private String CEP;
    private String cPais;
    private String xPais;
    private String Fone;

    public Destinatario(String idEstrangeiro, String CNPJCPF, String xNome, indIEDest indIEDest, String IE, String ISUF, String Email, String xLgr, String nro, String xCpl, String xBairro, String cMun, String xMun, String UF, String CEP, String cPais, String xPais, String Fone) {
        this.idEstrangeiro = idEstrangeiro;
        this.CNPJCPF = CNPJCPF;
        this.xNome = xNome;
        this.indIEDest = indIEDest;
        this.IE = IE;
        this.ISUF = ISUF;
        this.Email = Email;
        this.xLgr = xLgr;
        this.nro = nro;
        this.xCpl = xCpl;
        this.xBairro = xBairro;
        this.cMun = cMun;
        this.xMun = xMun;
        this.UF = UF;
        this.CEP = CEP;
        this.cPais = cPais;
        this.xPais = xPais;
        this.Fone = Fone;
    }

    public Destinatario() {
    }

    public String getIdEstrangeiro() {
        return idEstrangeiro;
    }

    public void setIdEstrangeiro(String idEstrangeiro) {
        this.idEstrangeiro = idEstrangeiro;
    }

    public String getCNPJCPF() {
        return CNPJCPF;
    }

    public void setCNPJCPF(String CNPJCPF) {
        this.CNPJCPF = CNPJCPF;
    }

    public String getxNome() {
        return xNome;
    }

    public void setxNome(String xNome) {
        this.xNome = xNome;
    }

    public indIEDest getIndIEDest() {
        return indIEDest;
    }

    public void setIndIEDest(indIEDest indIEDest) {
        this.indIEDest = indIEDest;
    }

    public String getIE() {
        return IE;
    }

    public void setIE(String IE) {
        this.IE = IE;
    }

    public String getISUF() {
        return ISUF;
    }

    public void setISUF(String ISUF) {
        this.ISUF = ISUF;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getxLgr() {
        return xLgr;
    }

    public void setxLgr(String xLgr) {
        this.xLgr = xLgr;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getxCpl() {
        return xCpl;
    }

    public void setxCpl(String xCpl) {
        this.xCpl = xCpl;
    }

    public String getxBairro() {
        return xBairro;
    }

    public void setxBairro(String xBairro) {
        this.xBairro = xBairro;
    }

    public String getcMun() {
        return cMun;
    }

    public void setcMun(String cMun) {
        this.cMun = cMun;
    }

    public String getxMun() {
        return xMun;
    }

    public void setxMun(String xMun) {
        this.xMun = xMun;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getcPais() {
        return cPais;
    }

    public void setcPais(String cPais) {
        this.cPais = cPais;
    }

    public String getxPais() {
        return xPais;
    }

    public void setxPais(String xPais) {
        this.xPais = xPais;
    }

    public String getFone() {
        return Fone;
    }

    public void setFone(String Fone) {
        this.Fone = Fone;
    }

    @Override
    public String toString() {
        return "[Destinatario]\n"
                + "idEstrangeiro=" + idEstrangeiro + "\n"
                + "CNPJCPF=" + CNPJCPF + "\n"
                + "xNome=" + xNome + "\n"
                + "indIEDest=" + indIEDest + "\n"
                + "IE=" + IE + "\n"
                + "ISUF=" + ISUF + "\n"
                + "Email=" + Email + "\n"
                + "xLgr=" + xLgr + "\n"
                + "nro=" + nro + "\n"
                + "xCpl=" + xCpl + "\n"
                + "xBairro=" + xBairro + "\n"
                + "cMun=" + cMun + "\n"
                + "xMun=" + xMun + "\n"
                + "UF=" + UF + "\n"
                + "CEP=" + CEP + "\n"
                + "cPais=" + cPais + "\n"
                + "xPais=" + xPais + "\n"
                + "Fone=" + Fone + "\n";
    }

}
