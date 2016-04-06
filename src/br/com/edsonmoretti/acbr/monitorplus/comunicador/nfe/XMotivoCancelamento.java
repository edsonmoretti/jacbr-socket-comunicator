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
public class XMotivoCancelamento extends XMotivo {

    private String ChNFe;
    private String NProt;
    private String tpEvento;
    private String xEvento;
    private String nSeqEvento;
    private String CNPJDest;
    private String emailDest;
    private String XML;

    public XMotivoCancelamento() {
    }

    public XMotivoCancelamento(XMotivo xMotivo) {
        setCamposXMotivo(xMotivo);
    }

    public XMotivoCancelamento(String xMotivo) {
        setCamposXMotivo(xMotivo);
    }

    public String getChNFe() {
        return ChNFe;
    }

    public void setChNFe(String ChNFe) {
        this.ChNFe = ChNFe;
    }

    public String getNProt() {
        return NProt;
    }

    public void setNProt(String NProt) {
        this.NProt = NProt;
    }

    public String getTpEvento() {
        return tpEvento;
    }

    public void setTpEvento(String tpEvento) {
        this.tpEvento = tpEvento;
    }

    public String getxEvento() {
        return xEvento;
    }

    public void setxEvento(String xEvento) {
        this.xEvento = xEvento;
    }

    public String getnSeqEvento() {
        return nSeqEvento;
    }

    public void setnSeqEvento(String nSeqEvento) {
        this.nSeqEvento = nSeqEvento;
    }

    public String getCNPJDest() {
        return CNPJDest;
    }

    public void setCNPJDest(String CNPJDest) {
        this.CNPJDest = CNPJDest;
    }

    public String getEmailDest() {
        return emailDest;
    }

    public void setEmailDest(String emailDest) {
        this.emailDest = emailDest;
    }

    public String getXML() {
        return XML;
    }

    public void setXML(String XML) {
        this.XML = XML;
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
        return "XMotivoCancelamento{" + "ChNFe=" + ChNFe + ", NProt=" + NProt + ", tpEvento=" + tpEvento + ", xEvento=" + xEvento + ", nSeqEvento=" + nSeqEvento + ", CNPJDest=" + CNPJDest + ", emailDest=" + emailDest + ", XML=" + XML + " - " + super.toString();
    }

}
