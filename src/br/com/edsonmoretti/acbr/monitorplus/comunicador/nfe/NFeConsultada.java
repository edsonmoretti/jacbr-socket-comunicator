/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.nfe;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrNFeException;

/**
 *
 * @author Edson
 */
public class NFeConsultada extends StatusDoServico {

    private String ChNFe;
    private String NProt;
    private String DigVal;

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

    public String getDigVal() {
        return DigVal;
    }

    public void setDigVal(String DigVal) {
        this.DigVal = DigVal;
    }
}
