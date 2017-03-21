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
public class Entrega {

    private String CNPJCPF;
    private String xLgr;
    private String nro;
    private String xCpl;
    private String xBairro;
    private String cMun;
    private String xMun;
    private String UF;

    public Entrega(String CNPJCPF, String xLgr, String nro, String xCpl, String xBairro, String cMun, String xMun, String UF) {
        this.CNPJCPF = CNPJCPF;
        this.xLgr = xLgr;
        this.nro = nro;
        this.xCpl = xCpl;
        this.xBairro = xBairro;
        this.cMun = cMun;
        this.xMun = xMun;
        this.UF = UF;
    }

    public Entrega() {
    }

    public void setCNPJCPF(String CNPJCPF) {
        this.CNPJCPF = CNPJCPF;
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

    public String getCNPJCPF() {
        return CNPJCPF;
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

    @Override
    public String toString() {
        return "[Entrega]\n"
                + "CNPJCPF=" + CNPJCPF + "\n"
                + "xLgr=" + xLgr + "\n"
                + "nro=" + nro + "\n"
                + "xCpl=" + xCpl + "\n"
                + "xBairro=" + xBairro + "\n"
                + "cMun=" + cMun + "\n"
                + "xMun=" + xMun + "\n"
                + "UF=" + UF + "\n";
    }

}
