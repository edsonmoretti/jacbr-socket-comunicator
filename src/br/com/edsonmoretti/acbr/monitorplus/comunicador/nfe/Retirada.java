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
public class Retirada {

    private final String CNPJCPF;
    private final String xLgr;
    private final String nro;
    private final String xCpl;
    private final String xBairro;
    private final String cMun;
    private final String xMun;
    private final String UF;

    public Retirada(String CNPJCPF, String xLgr, String nro, String xCpl, String xBairro, String cMun, String xMun, String UF) {
        this.CNPJCPF = CNPJCPF;
        this.xLgr = xLgr;
        this.nro = nro;
        this.xCpl = xCpl;
        this.xBairro = xBairro;
        this.cMun = cMun;
        this.xMun = xMun;
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
        return "[Retirada]\n"
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
