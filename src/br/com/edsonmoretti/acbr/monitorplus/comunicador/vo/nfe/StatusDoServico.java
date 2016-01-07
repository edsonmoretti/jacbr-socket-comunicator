/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.vo.nfe;

/**
 *
 * @author Edson Moretti - www.edsonmoretti.com.br
 */
public class StatusDoServico {

    private String Versao;
    private String TpAmb;
    private String VerAplic;
    private String CStat;
    private String XMotivo;
    private String CUF;
    private String DhRecbto;
    private String TMed;

    public String getVersao() {
        return Versao;
    }

    public void setVersao(String Versao) {
        this.Versao = Versao;
    }

    public String getTpAmb() {
        return TpAmb;
    }

    public void setTpAmb(String TpAmb) {
        this.TpAmb = TpAmb;
    }

    public String getVerAplic() {
        return VerAplic;
    }

    public void setVerAplic(String VerAplic) {
        this.VerAplic = VerAplic;
    }

    public String getCStat() {
        return CStat;
    }

    public void setCStat(String CStat) {
        this.CStat = CStat;
    }

    public String getXMotivo() {
        return XMotivo;
    }

    public void setXMotivo(String XMotivo) {
        this.XMotivo = XMotivo;
    }

    public String getCUF() {
        return CUF;
    }

    public void setCUF(String CUF) {
        this.CUF = CUF;
    }

    public String getDhRecbto() {
        return DhRecbto;
    }

    public void setDhRecbto(String DhRecbto) {
        this.DhRecbto = DhRecbto;
    }

    public String getTMed() {
        return TMed;
    }

    public void setTMed(String TMed) {
        this.TMed = TMed;
    }

    @Override
    public String toString() {
        return "StatusDoServico{" + "Versao=" + Versao + ", TpAmb=" + TpAmb + ", VerAplic=" + VerAplic + ", CStat=" + CStat + ", XMotivo=" + XMotivo + ", CUF=" + CUF + ", DhRecbto=" + DhRecbto + ", TMed=" + TMed + '}';
    }

}
