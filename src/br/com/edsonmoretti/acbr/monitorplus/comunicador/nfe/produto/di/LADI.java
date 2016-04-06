/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.nfe.produto.di;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.nfe.MembroList;

/**
 *
 * @author DANIEL
 */
public class LADI extends MembroList {

    private final String nAdicao;
    private final String nSeqAdi;
    private final String cFabricante;
    private final String vDescDI;
    private final String nDraw;

    public LADI(String nAdicao, String nSeqAdi, String cFabricante, String vDescDI, String nDraw) {
        this.nAdicao = nAdicao;
        this.nSeqAdi = nSeqAdi;
        this.cFabricante = cFabricante;
        this.vDescDI = vDescDI;
        this.nDraw = nDraw;
    }

    public String getnAdicao() {
        return nAdicao;
    }

    public String getnSeqAdi() {
        return nSeqAdi;
    }

    public String getcFabricante() {
        return cFabricante;
    }

    public String getvDescDI() {
        return vDescDI;
    }

    public String getnDraw() {
        return nDraw;
    }

    @Override
    public String toString() {
        return "[LADI]\n"
                + "nAdicao=" + nAdicao + "\n"
                + "nSeqAdi=" + nSeqAdi + "\n"
                + "cFabricante=" + cFabricante + "\n"
                + "vDescDI=" + vDescDI + "\n"
                + "nDraw=" + nDraw + "\n";
    }

}
