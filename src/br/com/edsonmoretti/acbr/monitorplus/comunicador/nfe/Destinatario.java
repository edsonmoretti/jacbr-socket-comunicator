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
public class Destinatario {

    private final String idEstrangeiro;
    private final String CNPJCPF;
    private final String xNome;
    private final String indIEDest;
    private final String IE;
    private final String ISUF;
    private final String Email;
    private final String xLgr;
    private final String nro;
    private final String xCpl;
    private final String xBairro;
    private final String cMun;
    private final String xMun;
    private final String UF;
    private final String CEP;
    private final String cPais;
    private final String xPais;
    private final String Fone;

    public Destinatario(String idEstrangeiro, String CNPJCPF, String xNome, String indIEDest, String IE, String ISUF, String Email, String xLgr, String nro, String xCpl, String xBairro, String cMun, String xMun, String UF, String CEP, String cPais, String xPais, String Fone) {
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

    public String getIdEstrangeiro() {
        return idEstrangeiro;
    }

    public String getCNPJCPF() {
        return CNPJCPF;
    }

    public String getxNome() {
        return xNome;
    }

    public String getIndIEDest() {
        return indIEDest;
    }

    public String getIE() {
        return IE;
    }

    public String getISUF() {
        return ISUF;
    }

    public String getEmail() {
        return Email;
    }

    public String getxLgr() {
        return xLgr;
    }

    public String getNro() {
        return nro;
    }

    public String getxCpl() {
        return xCpl;
    }

    public String getxBairro() {
        return xBairro;
    }

    public String getcMun() {
        return cMun;
    }

    public String getxMun() {
        return xMun;
    }

    public String getUF() {
        return UF;
    }

    public String getCEP() {
        return CEP;
    }

    public String getcPais() {
        return cPais;
    }

    public String getxPais() {
        return xPais;
    }

    public String getFone() {
        return Fone;
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
