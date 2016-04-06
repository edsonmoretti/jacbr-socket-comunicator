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
public class Emitente {

    private final String CNPJCPF;
    private final String xNome;
    private final String xFant;
    private final String IE;
    private final String IEST;
    private final String IM;
    private final String CNAE;
    private final String CRT;
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
    private final String cUF;
    private final String cMunFG;

    public Emitente(String CNPJCPF, String xNome, String xFant, String IE, String IEST, String IM, String CNAE, String CRT, String xLgr, String nro, String xCpl, String xBairro, String cMun, String xMun, String UF, String CEP, String cPais, String xPais, String Fone, String cUF, String cMunFG) {
        this.CNPJCPF = CNPJCPF;
        this.xNome = xNome;
        this.xFant = xFant;
        this.IE = IE;
        this.IEST = IEST;
        this.IM = IM;
        this.CNAE = CNAE;
        this.CRT = CRT;
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
        this.cUF = cUF;
        this.cMunFG = cMunFG;
    }

    public String getCNPJCPF() {
        return CNPJCPF;
    }

    public String getxNome() {
        return xNome;
    }

    public String getxFant() {
        return xFant;
    }

    public String getIE() {
        return IE;
    }

    public String getIEST() {
        return IEST;
    }

    public String getIM() {
        return IM;
    }

    public String getCNAE() {
        return CNAE;
    }

    public String getCRT() {
        return CRT;
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

    public String getcUF() {
        return cUF;
    }

    public String getcMunFG() {
        return cMunFG;
    }

    @Override
    public String toString() {
        return "[Emitente]\n"
                + "CNPJCPF=" + CNPJCPF + "\n"
                + "xNome=" + xNome + "\n"
                + "xFant=" + xFant + "\n"
                + "IE=" + IE + "\n"
                + "IEST=" + IEST + "\n"
                + "IM=" + IM + "\n"
                + "CNAE=" + CNAE + "\n"
                + "CRT=" + CRT + "\n"
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
                + "Fone=" + Fone + "\n"
                + "cUF=" + cUF + "\n"
                + "cMunFG=" + cMunFG + "\n";
    }

}
