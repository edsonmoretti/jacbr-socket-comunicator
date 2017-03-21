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

    private String CNPJCPF;
    private String xNome;
    private String xFant;
    private String IE;
    private String IEST;
    private String IM;
    private String CNAE;
    private String CRT;
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
    private String cUF;
    private String cMunFG;

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

    public Emitente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public void setCNPJCPF(String CNPJCPF) {
        this.CNPJCPF = CNPJCPF;
    }

    public void setxNome(String xNome) {
        this.xNome = xNome;
    }

    public void setxFant(String xFant) {
        this.xFant = xFant;
    }

    public void setIE(String IE) {
        this.IE = IE;
    }

    public void setIEST(String IEST) {
        this.IEST = IEST;
    }

    public void setIM(String IM) {
        this.IM = IM;
    }

    public void setCNAE(String CNAE) {
        this.CNAE = CNAE;
    }

    public void setCRT(String CRT) {
        this.CRT = CRT;
    }

    public void setxLgr(String xLgr) {
        this.xLgr = xLgr;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public void setxCpl(String xCpl) {
        this.xCpl = xCpl;
    }

    public void setxBairro(String xBairro) {
        this.xBairro = xBairro;
    }

    public void setcMun(String cMun) {
        this.cMun = cMun;
    }

    public void setxMun(String xMun) {
        this.xMun = xMun;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public void setcPais(String cPais) {
        this.cPais = cPais;
    }

    public void setxPais(String xPais) {
        this.xPais = xPais;
    }

    public void setFone(String Fone) {
        this.Fone = Fone;
    }

    public void setcUF(String cUF) {
        this.cUF = cUF;
    }

    public void setcMunFG(String cMunFG) {
        this.cMunFG = cMunFG;
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
