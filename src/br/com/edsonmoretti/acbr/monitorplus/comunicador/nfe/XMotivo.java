/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.nfe;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.TextUtils;

/**
 *
 * @author Edson
 */
public class XMotivo {

    private String Versao;
    private String TpAmb;
    private String VerAplic;
    private String CStat;
    private String XMotivo;
    private String CUF;
    private String DhRecbto;

    public XMotivo(String re) {
        setCamposXMotivo(re);
    }

    public XMotivo(XMotivo re) {
        setCamposXMotivo(re);
    }

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

    private void setCamposXMotivo(XMotivo xMotivo) {
        this.setCStat(xMotivo.getCStat());
        this.setCUF(xMotivo.getCUF());
        this.setDhRecbto(xMotivo.getDhRecbto());
        this.setTpAmb(xMotivo.getTpAmb());
        this.setVerAplic(xMotivo.getVerAplic());
        this.setVersao(xMotivo.getVersao());
        this.setXMotivo(xMotivo.getXMotivo());
    }

    private void setCamposXMotivo(String s) {
        this.setCStat(TextUtils.lerTagIni("CStat", s));
        this.setCUF(TextUtils.lerTagIni("CUF", s));
        this.setDhRecbto(TextUtils.lerTagIni("DhRecbto", s));
        this.setTpAmb(TextUtils.lerTagIni("TpAmb", s));
        this.setVerAplic(TextUtils.lerTagIni("VerAplic", s));
        this.setVersao(TextUtils.lerTagIni("Versao", s));
        this.setXMotivo(TextUtils.lerTagIni("XMotivo", s));
    }

    @Override
    public String toString() {
        return "XMotivo{" + "Versao=" + Versao + ", TpAmb=" + TpAmb + ", VerAplic=" + VerAplic + ", CStat=" + CStat + ", XMotivo=" + XMotivo + ", CUF=" + CUF + ", DhRecbto=" + DhRecbto + '}';
    }
}
