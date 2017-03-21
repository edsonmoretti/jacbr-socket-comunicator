/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.enun.CRT;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.enun.cUF;

/**
 *
 * @author DANIEL
 */
public class Emitente {

    private String CNPJCPF;
    private String xNome;
    private String xFant;
    private String IE;
    private String IEST = "";
    private String IM = "";
    private String CNAE = "";
    private CRT CRT;
    private String xLgr;
    private String nro;
    private String xCpl;
    private String xBairro;
    private String cMun;
    private String xMun;
    private String UF;
    private String CEP;
    private String cPais = "1058";
    private String xPais;
    private String Fone;
    private cUF cUF;
    private String cMunFG;

    public Emitente(String CNPJCPF, String xNome, String xFant, String IE, String IEST, String IM, String CNAE, CRT CRT, String xLgr, String nro, String xCpl, String xBairro, String cMun, String xMun, String UF, String CEP, String cPais, String xPais, String Fone, cUF cUF, String cMunFG) {
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

    public String getxFant() {
        return xFant;
    }

    public void setxFant(String xFant) {
        this.xFant = xFant;
    }

    public String getIE() {
        return IE;
    }

    public void setIE(String IE) {
        this.IE = IE;
    }

    public String getIEST() {
        return IEST;
    }

    public void setIEST(String IEST) {
        this.IEST = IEST;
    }

    public String getIM() {
        return IM;
    }

    public void setIM(String IM) {
        this.IM = IM;
    }

    public String getCNAE() {
        return CNAE;
    }

    public void setCNAE(String CNAE) {
        this.CNAE = CNAE;
    }

    public CRT getCRT() {
        return CRT;
    }

    public void setCRT(CRT CRT) {
        this.CRT = CRT;
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

    public void setUF(cUF UF) {
        setUF(UF.getUf());
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

    public cUF getcUF() {
        return cUF;
    }

    public void setcUF(cUF cUF) {
        this.cUF = cUF;
    }

    public String getcMunFG() {
        return cMunFG;
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
